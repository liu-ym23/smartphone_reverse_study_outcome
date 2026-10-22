package com.bytedance.mira.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.core.res.AssetManagerProcessor;
import com.bytedance.mira.core.res.ResCacheUtil;
import com.bytedance.mira.core.res.ResourcesFactory;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class MiraResourcesManager {
    private static final String TAG = "MiraResourcesManager";
    private static volatile MiraResourcesManager sInstance;
    private volatile AssetManager mAssetManager;
    private AssetManagerProcessor mAssetManagerProcessor;
    private Map<Resources, String> mExtResources;
    private Handler mMainHandler;
    private WeakReference<Activity> mTopActivity;

    public static abstract class TRunnable<T> implements Runnable {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private T f265553t;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_mira_core_MiraResourcesManager$TRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public abstract void run(T r100);

        public void com_bytedance_mira_core_MiraResourcesManager$TRunnable__run$___twin___() {
            run(this.f265553t);
        }

        public TRunnable(T r100) {
            this.f265553t = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_mira_core_MiraResourcesManager$TRunnable_com_larus_apm_impl_protector_RunnableLancet_run(TRunnable r100) {
            r100.com_bytedance_mira_core_MiraResourcesManager$TRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public synchronized AssetManager getAppAssetManager() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mAssetManager != null) goto L6;
        this.mAssetManager = Mira.getAppContext().getAssets();     // Catch: Throwable -> L9
    L6:
        AssetManager r100 = this.mAssetManager;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public static final MiraResourcesManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MiraResourcesManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MiraResourcesManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MiraResourcesManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private Set<Activity> getNeedUpdatedActivities() {
        HashSet r100 = new HashSet();
        Iterator<Activity> r101 = ActivityThreadHelper.getActivities().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Activity r102 = r101.next();
        if (shouldModifyResource(r102) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        WeakReference<Activity> r103 = this.mTopActivity;
        if (r103 != null) goto L11;
    L15:
        MiraLogger.d(MiraLogger.TAG_LOAD, "MiraResourcesManager getNeedUpdatedActivities, size = " + r100.size());
        return r100;
    L11:
        if (r103.get() == null) goto L15;
        Activity r104 = this.mTopActivity.get();
        if (shouldModifyResource(r104) == false) goto L15;
        r100.add(r104);
        goto L15
    }

    private List<Application> getNeedUpdatedApplications() {
        ArrayList r100 = new ArrayList();
        List<Application> r101 = ActivityThreadHelper.getApplications();
        if (r101 != null) goto L5;
    L19:
        MiraLogger.d(MiraLogger.TAG_LOAD, "MiraResourcesManager getNeedUpdatedApplications, size = " + r100.size());
        return r100;
    L5:
        if (r101.size() <= 0) goto L19;
        Iterator<Application> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        Application r103 = r102.next();
        if (r103 == null) goto L8;
        ApplicationInfo r104 = r103.getApplicationInfo();
        if (r104 == null) goto L8;
        if (TextUtils.equals(r104.packageName, Mira.getAppContext().getPackageName()) == true) goto L15;
        if (PluginPackageManager.shareResources(r104.packageName) == false) goto L8;
        r100.add(r103);
        goto L8
    L15:
        r100.add(r103);
        goto L8
    }

    private List<ContextWrapper> getNeedUpdatedTintContextWrapperCache() {
        ArrayList r100 = null;
        Object r101 = FieldUtils.readStaticField(INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.support.v7.widget.TintContextWrapper"), "sCache");     // Catch: Exception -> L17
        if (r101 == null) goto L21;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L17
        Iterator r103 = ((List) r101).iterator();     // Catch: Exception -> L15
    L8:
        if (r103.hasNext() == false) goto L20;
        WeakReference r104 = (WeakReference) r103.next();     // Catch: Exception -> L15
        if (r104 == null) goto L8;
        ContextWrapper r105 = (ContextWrapper) r104.get();     // Catch: Exception -> L15
        if (r105 == null) goto L8;
        r102.add(r105);     // Catch: Exception -> L15
    L20:
        r100 = r102;
    L15:
        Exception e100 = e;
    L19:
        MiraLogger.w(MiraLogger.TAG_LOAD, "MiraResourcesManager getNeedUpdatedTintContextWrapperCache failed.", e100);
    L21:
        StringBuilder r106 = new StringBuilder("MiraResourcesManager getNeedUpdatedTintContextWrapperCache, size = ");
        if (r100 == null) goto L24;
        int r107 = r100.size();
    L25:
        r106.append(r107);
        MiraLogger.d(MiraLogger.TAG_LOAD, r106.toString());
        return r100;
    L24:
        r107 = 0;
    L17:
        e = move-exception;
        r102 = null;
        e100 = e;
        goto L19
    }

    public String getAssetPathCachesStr() {
        return this.mAssetManagerProcessor.getAssetPathCachesStr();
    }

    private MiraResourcesManager() {
        this.mExtResources = new WeakHashMap();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mAssetManagerProcessor = new AssetManagerProcessor();
    }

    public Resources getAppResources() {
        return Mira.getAppContext().getResources();
    }

    public Resources getResourcesForTheme() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L7;
        return null;
    L7:
        return getAppResources();
    }

    public AssetManagerProcessor getAssetManagerProcessor() {
        return this.mAssetManagerProcessor;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void flushRes(Resources r100) {
    L8:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager flushRes " + th.getMessage());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L6;
        MethodUtils.invokeStaticMethod(INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.appcompat.app.ResourcesFlusher"), "flushNougats", new Object[]{r100});     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        MethodUtils.invokeStaticMethod(INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.appcompat.app.ResourcesFlusher"), "flush", new Object[]{r100});     // Catch: Throwable -> L8
        goto L11
    }

    private static void removeAppResFromResourcesManager(Resources r100) {
        Class r101 = INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ResourcesManager");     // Catch: Exception -> L36
        Class r102 = INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.ResourcesImpl");     // Catch: Exception -> L36
        Object r103 = MethodUtils.getAccessibleMethod(Resources.class, "getImpl", new Class[0]).invoke(r100, new Object[0]);     // Catch: Exception -> L36
        Object r104 = MethodUtils.getAccessibleMethod(r101, "getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L36
        Method r105 = DoubleReflector.getMethod(r101, "findKeyForResourceImplLocked", new Class[]{r102});     // Catch: Exception -> L36
        r105.setAccessible(true);     // Catch: Exception -> L36
        if (OSUtil.isAndroidSHigher() == false) goto L16;
        Object r106 = FieldUtils.readField(r104, "mLock");     // Catch: Exception -> L36
        if (r106 == null) goto L31;
        monitor-enter(r106);     // Catch: Exception -> L36
        Object r107 = r105.invoke(r104, new Object[]{r103});     // Catch: Throwable -> L12
        Object r108 = FieldUtils.readField(r104, "mResourceImpls");     // Catch: Throwable -> L12
        if ((r108 instanceof Map) == false) goto L10;
        ((Map) r108).remove(r107);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r106);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L36
    L31:
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraResourcesManager removeAppResFromResourcesManager success");     // Catch: Exception -> L36
        return;
    L16:
        if (OSUtil.isAndroidRHigher() == false) goto L26;
        monitor-enter(r104);     // Catch: Exception -> L36
        Object r109 = r105.invoke(r104, new Object[]{r103});     // Catch: Throwable -> L23
        Object r110 = FieldUtils.readField(r104, "mResourceImpls");     // Catch: Throwable -> L23
        if ((r110 instanceof Map) == false) goto L21;
        ((Map) r110).remove(r109);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r104);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L36
    L26:
        monitor-enter(r104);     // Catch: Exception -> L36
        Object r111 = r105.invoke(r104, new Object[]{r103});     // Catch: Throwable -> L33
        Method r112 = DoubleReflector.getMethod(r101, "cleanupResourceImpl", new Class[]{INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.ResourcesKey")});     // Catch: Throwable -> L33
        if (r112 == null) goto L30;
        r112.setAccessible(true);     // Catch: Throwable -> L33
        r112.invoke(r104, new Object[]{r111});     // Catch: Throwable -> L33
    L30:
        monitor-exit(r104);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraResourcesManager removeAppResFromResourcesManager fail", e);
    }

    public static void replaceApplicationRes(Application r110) {
        final Resources r100 = r110.getResources();
        if ((r100 instanceof MiraResourcesWrapper) == true) goto L9;
        MiraResourcesWrapper r101 = new MiraResourcesWrapper(ResourcesFactory.createResources(r100, r100.getAssets()));
        FieldUtils.writeField(FieldUtils.readField(MethodUtils.getAccessibleMethod(INVOKESTATIC_com_bytedance_mira_core_MiraResourcesManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ContextImpl"), "getImpl", new Class[]{Context.class}).invoke(null, new Object[]{r110}), "mPackageInfo"), "mResources", r101);     // Catch: Exception -> L7
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraResourcesManager replaceApplicationRes, loadedApk.mResources = " + r101);     // Catch: Exception -> L7
        FieldUtils.writeField(r110.getBaseContext(), "mResources", r101);     // Catch: Exception -> L7
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraResourcesManager replaceApplicationRes, app.ContextImpl.mResources = " + r101);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraResourcesManager replaceApplicationRes failed.", e);
    L9:
        r110.registerComponentCallbacks(new AnonymousClass1(r100));
        if (MiraManager.getInstance().getParam().isOpenResFix() == false) goto L15;
        removeAppResFromResourcesManager(r100);
        return;
    }

    private boolean shouldModifyResource(Activity r100) {
        ApplicationInfo r101 = r100.getApplicationInfo();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r101.packageName, Mira.getAppContext().getPackageName()) == false) goto L9;
        return true;
    L9:
        return PluginPackageManager.shareResources(r101.packageName);
    }

    private synchronized void updateActivityThemeImpl(Activity r100) {
        monitor-enter(this);
        if (r100 != null) goto L36;
        monitor-exit(this);
        return;
    L36:
        monitor-enter(r100);     // Catch: Throwable -> L30
        int r101 = ((Integer) FieldUtils.readField(r100.getBaseContext(), "mThemeResource")).intValue();     // Catch: Throwable -> L21 Exception -> L23
        FieldUtils.writeField(r100.getBaseContext(), "mTheme", null);     // Catch: Throwable -> L21 Exception -> L23
        FieldUtils.writeField(r100.getBaseContext(), "mThemeResource", 0);     // Catch: Throwable -> L21 Exception -> L23
        r100.getBaseContext().setTheme(r101);     // Catch: Throwable -> L21 Exception -> L23
        Object r102 = FieldUtils.readField(r100, "mThemeId");     // Catch: Throwable -> L21 Exception -> L23
        if (r102 == null) goto L11;
        int r103 = ((Integer) r102).intValue();     // Catch: Throwable -> L21 Exception -> L23
    L13:
        if (OSUtil.isAndroidQHigher() == false) goto L18;
        Field r104 = DoubleReflector.getFieldAll(r100.getClass(), "mTheme");     // Catch: Throwable -> L21 Exception -> L23
        if (r104 == null) goto L17;
        FieldUtils.writeField(r104, r100, null);     // Catch: Throwable -> L21 Exception -> L23
    L19:
        FieldUtils.writeField(r100, "mThemeResource", 0);     // Catch: Throwable -> L21 Exception -> L23
        r100.setTheme(r103);     // Catch: Throwable -> L21 Exception -> L23
    L25:
        monitor-exit(r100);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L17:
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, TAG + String.format("getField %s#mTheme failed !!!", new Object[]{r100.getClass()}));     // Catch: Throwable -> L21 Exception -> L23
        goto L19
    L18:
        FieldUtils.writeField(r100, "mTheme", null);     // Catch: Throwable -> L21 Exception -> L23
        goto L19
    L11:
        r103 = ((Integer) FieldUtils.readField(r100, "mThemeResource")).intValue();     // Catch: Throwable -> L21 Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        MiraLogger.e(TAG, "UpdateActivityTheme failed.", e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private void updateContextTheme(final Context r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        updateContextThemeImpl(r100);
        return;
    L5:
        this.mMainHandler.post(new AnonymousClass3(this, r100));
    }

    private void updateContextThemeImpl(Context r100) {
        if (r100 != null) goto L14;
        return;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (r100.getClass().getName().contains("TintContextWrapper") == false) goto L8;
        int r101 = ((Integer) FieldUtils.readField(((ContextWrapper) r100).getBaseContext(), "mThemeResource")).intValue();     // Catch: Exception -> L11
        FieldUtils.writeField(r100, "mTheme", null);     // Catch: Exception -> L11
        FieldUtils.writeField(((ContextWrapper) r100).getBaseContext(), "mTheme", null);     // Catch: Exception -> L11
        FieldUtils.writeField(((ContextWrapper) r100).getBaseContext(), "mThemeResource", 0);     // Catch: Exception -> L11
    L9:
        r100.setTheme(r101);     // Catch: Exception -> L11
        return;
    L8:
        r101 = ((Integer) FieldUtils.readField(r100, "mThemeResource")).intValue();     // Catch: Exception -> L11
        FieldUtils.writeField(r100, "mTheme", null);     // Catch: Exception -> L11
        FieldUtils.writeField(r100, "mThemeResource", 0);     // Catch: Exception -> L11
        goto L9
    }

    public void setTopActivity(Activity r100) {
        this.mTopActivity = new WeakReference(r100);
    }

    public void updateActivityTheme(final Activity r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        updateActivityThemeImpl(r100);
        return;
    L5:
        this.mMainHandler.post(new AnonymousClass2(this, r100));
    }

    public static /* synthetic */ void access$000(MiraResourcesManager r100, Activity r101) {
        r100.updateActivityThemeImpl(r101);
    }

    public static /* synthetic */ void access$100(MiraResourcesManager r100, Context r101) {
        r100.updateContextThemeImpl(r101);
    }

    private void reflectReplaceActivityResources(Activity r100, Resources r101) {
        Class<?> r102 = r100.getClass();
    L12:
        Field r103 = r102.getDeclaredField("mResources");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L8
        if (r103 == null) goto L9;
        FieldUtils.writeField(r103, r100, r101);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L8
    L7:
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager reflectReplaceActivityResources failed");
    L9:
        r102 = r102.getSuperclass();
        if (r102 != Object.class) goto L12;
    }

    private void reflectReplaceImpl(Resources r100, AssetManager r101) {
        FieldUtils.getField(Resources.class, "mAssets").set(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        Object r102 = FieldUtils.getField(Resources.class, "mResourcesImpl").get(r100);     // Catch: Exception -> L7
        FieldUtils.getField(r102.getClass(), "mAssets").set(r102, r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "MiraResourcesManager reflectReplaceImpl", e);
    }

    private void replaceResourcesAssets(Resources r100, AssetManager r101) {
        if (r100.getAssets() == r101) goto L9;
        reflectReplaceImpl(r100, r101);
        if ((r100 instanceof MiraResourcesWrapper) == false) goto L7;
        Resources r102 = ((MiraResourcesWrapper) r100).getResources();
        reflectReplaceImpl(r102, r101);
        ResCacheUtil.pruneResourceCaches(r102);
    L7:
        ResCacheUtil.pruneResourceCaches(r100);
        r100.updateConfiguration(r100.getConfiguration(), INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100));
        return;
    }

    private void updateActivityRes2AppRes(Resources r100, Resources r101) {
        r100.updateConfiguration(r101.getConfiguration(), INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101));
        flushRes(r100);
    }

    public synchronized Resources addPluginPath(String r100, String r101) {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L47;
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager addPluginPath, sourceDir = " + r100);     // Catch: Throwable -> L48
        Resources r102 = getAppResources();     // Catch: Throwable -> L48
        if (this.mAssetManagerProcessor != null) goto L9;
        this.mAssetManagerProcessor = new AssetManagerProcessor();     // Catch: Throwable -> L48
    L9:
        AssetManager r103 = this.mAssetManagerProcessor.updateAssetManager(r102.getAssets(), r100);     // Catch: Throwable -> L48
        if (r103 == null) goto L44;
        this.mAssetManager = r103;     // Catch: Throwable -> L48
        if (r102.getAssets() == r103) goto L14;
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update HostContext.Res.AssetManager, " + r101);     // Catch: Throwable -> L48
        replaceResourcesAssets(r102, r103);     // Catch: Throwable -> L48
    L14:
        Iterator<Application> r104 = getNeedUpdatedApplications().iterator();     // Catch: Throwable -> L48
    L16:
        if (r104.hasNext() == false) goto L21;
        Application r105 = r104.next();     // Catch: Throwable -> L48
        if (r105.getResources().getAssets() == r103) goto L20;
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update Application.Res.AssetManager, application=" + r105 + ", " + r101);     // Catch: Throwable -> L48
        replaceResourcesAssets(r105.getResources(), r103);     // Catch: Throwable -> L48
    L20:
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update Application.ContextImpl.Theme, baseContext=" + r105.getBaseContext() + ", " + r101);     // Catch: Throwable -> L48
        updateContextTheme(r105.getBaseContext());     // Catch: Throwable -> L48
        goto L16
    L21:
        Iterator<Activity> r106 = getNeedUpdatedActivities().iterator();     // Catch: Throwable -> L48
    L23:
        if (r106.hasNext() == false) goto L52;
        Activity r107 = r106.next();     // Catch: Throwable -> L48
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager updated Activity.Res, activity=" + r107 + ", " + r101);     // Catch: Throwable -> L48
        updateActivityResources(r107, true, r103);     // Catch: Throwable -> L48
        goto L23
    L52:
        List<ContextWrapper> r108 = getNeedUpdatedTintContextWrapperCache();     // Catch: Exception -> L42 Throwable -> L48
        if (r108 == null) goto L44;
        if (r108.size() <= 0) goto L44;
        Iterator<ContextWrapper> r109 = r108.iterator();     // Catch: Exception -> L42 Throwable -> L48
    L31:
        if (r109.hasNext() == false) goto L44;
        ContextWrapper r110 = r109.next();     // Catch: Exception -> L42 Throwable -> L48
        if ((r110.getResources() instanceof MiraResourcesWrapper) == false) goto L39;
        Resources r111 = ((MiraResourcesWrapper) r110.getResources()).getResources();     // Catch: Exception -> L42 Throwable -> L48
        if ("android.support.v7.widget.VectorEnabledTintResources".equals(r111.getClass().getName()) == false) goto L39;
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update TintContextWrapper.Res.AssetManager, tintContextWrapper=" + r110 + ", " + r101);     // Catch: Exception -> L42 Throwable -> L48
        replaceResourcesAssets(r111, r103);     // Catch: Exception -> L42 Throwable -> L48
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update TintContextWrapper.Theme, tintContextWrapper=" + r110 + ", " + r101);     // Catch: Exception -> L42 Throwable -> L48
        updateContextTheme(r110);     // Catch: Exception -> L42 Throwable -> L48
    L39:
        if ("android.support.v7.widget.VectorEnabledTintResources".equals(r110.getResources().getClass().getName()) == false) goto L31;
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update VectorEnabledTintResources.Res.AssetManager, tintContextWrapper=" + r110 + ", " + r101);     // Catch: Exception -> L42 Throwable -> L48
        replaceResourcesAssets(r110.getResources(), r103);     // Catch: Exception -> L42 Throwable -> L48
        MiraLogger.i(MiraLogger.TAG_LOAD, "MiraResourcesManager update VectorEnabledTintResources.Theme, tintContextWrapper=" + r110 + ", " + r101);     // Catch: Exception -> L42 Throwable -> L48
        updateContextTheme(r110);     // Catch: Exception -> L42 Throwable -> L48
        goto L31
    L42:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "MiraResourcesManager update TintContextWrapper.sCache.Res failed.", e);     // Catch: Throwable -> L48
    L44:
        monitor-exit(this);
        return r102;
    L47:
        throw new IllegalArgumentException();     // Catch: Throwable -> L48
    }

    public synchronized void updateConfiguration(Configuration r100, DisplayMetrics r101) {
        monitor-enter(this);
        getAppResources().updateConfiguration(r100, r101);     // Catch: Throwable -> L17
        if (this.mExtResources.size() <= 0) goto L15;
        Iterator<Map.Entry<Resources, String>> r102 = this.mExtResources.entrySet().iterator();     // Catch: Throwable -> L17
        Configuration r103 = null;
    L6:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<Resources, String> r104 = r102.next();     // Catch: Throwable -> L17
        if (r103 != null) goto L12;
        r103 = new Configuration(r100);     // Catch: Throwable -> L17
        r103.uiMode = r104.getKey().getConfiguration().uiMode;     // Catch: Throwable -> L17
    L12:
        if (r104.getKey() == null) goto L6;
        r104.getKey().updateConfiguration(r103, r101);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void updateActivityResources(Activity r110, boolean r111, AssetManager r112) {
        monitor-enter(this);
        if (r112 != null) goto L11;
        if (r111 == false) goto L7;
        String r113 = MiraLogger.TAG_LOAD;
    L8:
        MiraLogger.w(r113, "MiraResourcesManager updateActivityResources, newAssetManager null, " + r110);     // Catch: Throwable -> L72
        monitor-exit(this);
        return;
    L7:
        r113 = MiraLogger.TAG_ACTIVITY;
        goto L8
    L11:
        MiraParam r100 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L72
        if (r100 != null) goto L14;
    L23:
        if (r111 == true) goto L55;
        Resources r114 = getAppResources();     // Catch: Throwable -> L72
        Resources r115 = r110.getResources();     // Catch: Throwable -> L72
        if (r114 == null) goto L53;
        if (r114 == r115) goto L53;
        CompatibilityInfo r101 = (CompatibilityInfo) MethodUtils.invokeMethod(r115, "getCompatibilityInfo", new Object[0]);     // Catch: Exception -> L33 Throwable -> L72
        CompatibilityInfo r102 = (CompatibilityInfo) MethodUtils.invokeMethod(r114, "getCompatibilityInfo", new Object[0]);     // Catch: Exception -> L33 Throwable -> L72
        if (r101 == null) goto L31;
        if (r101 == r102) goto L31;
        MethodUtils.invokeMethod(r114, "updateConfiguration", new Object[]{r115.getConfiguration(), INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r115), r101});     // Catch: Exception -> L33 Throwable -> L72
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, updateConfiguration");     // Catch: Exception -> L33 Throwable -> L72
    L77:
    L81:
        FieldUtils.writeField(r110.getBaseContext(), "mResources", r114);     // Catch: Exception -> L37 Throwable -> L72
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, activity.mBase.mResources=" + r114 + ", " + r110);     // Catch: Exception -> L37 Throwable -> L72
    L39:
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, activity.mResources=null, " + r110);     // Catch: Throwable -> L72
        reflectReplaceActivityResources(r110, null);     // Catch: Throwable -> L72
        Resources r103 = r110.getResources();     // Catch: Throwable -> L72
        if (r103.getClass().getName().equals("android.support.v7.widget.VectorEnabledTintResources") == false) goto L42;
        MiraResourcesWrapper r104 = new MiraResourcesWrapper(r103);     // Catch: Throwable -> L72
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, VectorEnabledTintResources activity.mResources=" + r104 + ", " + r110);     // Catch: Throwable -> L72
        reflectReplaceActivityResources(r110, r104);     // Catch: Throwable -> L72
    L42:
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, updateTheme, " + r110);     // Catch: Throwable -> L72
        updateActivityTheme(r110);     // Catch: Throwable -> L72
        if (OSUtil.isAndroidOHigher() == false) goto L53;
        if (r114.getClass().getName().equals("android.content.res.HwResources") == false) goto L53;
        if (INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r115).equals(INVOKEVIRTUAL_com_bytedance_mira_core_MiraResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r114)) == true) goto L53;
        FieldUtils.writeField(r110.getBaseContext(), "mDisplay", null);     // Catch: Exception -> L50 Throwable -> L72
        MiraLogger.w(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, activity.mBase.mDisplay=null, " + r110);     // Catch: Exception -> L50 Throwable -> L72
    L50:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, set activity.mBase.mDisplay=null failed.", e);     // Catch: Throwable -> L72
        goto L53
    L37:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, update activity.mBase.mResources failed.", e);     // Catch: Throwable -> L72
    L31:
        updateActivityRes2AppRes(r114, r115);     // Catch: Exception -> L33 Throwable -> L72
    L33:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_ACTIVITY, "MiraResourcesManager updateActivityResources, updateConfiguration failed.", e);     // Catch: Throwable -> L72
    L53:
        if (r110.getResources() == getAppResources()) goto L70;
        this.mExtResources.put(r110.getResources(), TAG);     // Catch: Throwable -> L72
    L70:
        monitor-exit(this);
        return;
    L55:
        Resources r116 = r110.getResources();     // Catch: Throwable -> L72
        if (r116.getAssets() != r112) goto L58;
    L69:
        updateActivityTheme(r110);     // Catch: Throwable -> L72
        goto L70
    L58:
        if (r116.getClass().getName().equals("android.support.v7.widget.TintResources") == false) goto L64;
        r116 = (Resources) FieldUtils.readField(r116, "mResources");     // Catch: Exception -> L61 Throwable -> L72
        goto L64
    L61:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "MiraResourcesManager get android.support.v7.widget.TintResources mResources failed.", e);     // Catch: Throwable -> L72
    L64:
        if (r110.getBaseContext().getResources() == r116) goto L66;
        replaceResourcesAssets(r110.getBaseContext().getResources(), r112);     // Catch: Throwable -> L72
    L66:
        replaceResourcesAssets(r116, r112);     // Catch: Throwable -> L72
        if (r110.getResources() == r116) goto L69;
        replaceResourcesAssets(r110.getResources(), r112);     // Catch: Throwable -> L72
        goto L69
    L14:
        if (r100.withoutHookActivityRes() == null) goto L23;
        if (r100.withoutHookActivityRes().contains(r110.getClass().getName()) == false) goto L23;
        if (r111 == false) goto L19;
        String r117 = MiraLogger.TAG_LOAD;
    L20:
        MiraLogger.w(r117, "MiraResourcesManager updateActivityResources, withoutHookActivityRes, " + r110);     // Catch: Throwable -> L72
        monitor-exit(this);
        return;
    L19:
        r117 = MiraLogger.TAG_ACTIVITY;
    L72:
        th = move-exception;
        throw th;
    }
}
