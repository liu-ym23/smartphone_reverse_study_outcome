package com.volcengine.zeus.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.ComponentManager;
import com.volcengine.zeus.FileProvider;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.PluginContext;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.activity.GenerateProxyActivity;
import com.volcengine.zeus.activity.GenerateProxyAppCompatActivity;
import com.volcengine.zeus.activity.IPluginActivity;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.res.PluginResources;
import com.volcengine.zeus.service.PluginIntentService;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.service.client.ServiceManagerNative;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import com.volcengine.zeus.wrapper.PluginActivityWrapper;
import com.volcengine.zeus.wrapper.PluginApplicationWrapper;
import com.volcengine.zeus.wrapper.PluginFragmentActivityWrapper;
import el9.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    static HashMap<String, WeakReference<Context>> contextCache;
    public static Class fragmentClazz;
    static boolean hasEnsure;
    static HashMap<String, Constructor<View>> sConstructorMap;

    public ZeusTransformUtils() {
    }

    static {
        contextCache = new HashMap();
        hasEnsure = false;
        sConstructorMap = null;
    }

    public static void clearConstructorCache() {
        if (Build.VERSION.SDK_INT <= 23) goto L23;
        return;
    L23:
        if (sConstructorMap != null) goto L7;
        sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");     // Catch: Throwable -> L22
    L7:
        Iterator r0 = new HashSet(sConstructorMap.keySet()).iterator();     // Catch: Throwable -> L22
    L8:
        if (r0.hasNext() == false) goto L38;
        String r1 = (String) r0.next();     // Catch: Throwable -> L22
        if (r1.startsWith("android.view.") == true) goto L8;
        if (r1.startsWith("android.widget.") == true) goto L8;
        if (r1.startsWith("android.webkit.") == true) goto L8;
        if (r1.contains(".") == false) goto L8;
        sConstructorMap.remove(r1);     // Catch: Throwable -> L22
        goto L8
    L38:
        return;
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure == false) goto L11;
        return;
    L11:
        fragmentClazz = INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(Zeus.class.getClassLoader(), "android.support.v4.app.FragmentActivity");     // Catch: Throwable -> L7
    L7:
        fragmentClazz = INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(Zeus.class.getClassLoader(), "androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L10
    L8:
        hasEnsure = true;
    }

    private static Context convertProxy2PluginActivity(Context r3) {
    L8:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "convertProxy2PluginActivity failed.", th);
    L10:
        return r3;
    L3:
        if ((r3 instanceof GenerateProxyActivity) == false) goto L5;
    L6:
        return (Activity) FieldUtils.readField(r3, "mTargetActivity");
    L5:
        if ((r3 instanceof GenerateProxyAppCompatActivity) == false) goto L10;
        goto L6
    }

    private static boolean equalsFragmentActivity(Class r2) {
        ensureFragmentActivity();
        Class r0 = fragmentClazz;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r2 != r0) goto L8;
        return true;
    L8:
        return false;
    }

    public static String getAssetPaths(AssetManager r7) {
        StringBuilder r0 = new StringBuilder();
        if (r7 != null) goto L35;
        return XmlPullParser.NO_NAMESPACE;
    L35:
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L28
        if (r1 < 28) goto L9;
    L20:
        Object[] r8 = (Object[]) MethodUtils.invokeMethod(r7, "getApkAssets", new Object[0]);     // Catch: Throwable -> L28
        if (r8 != null) goto L23;
    L31:
        return r0.toString();
    L23:
        if (r8.length <= 0) goto L31;
        int r2 = r8.length;     // Catch: Throwable -> L28
        int r3 = 0;
    L25:
        if (r3 >= r2) goto L31;
        r0.append((String) MethodUtils.invokeMethod(r8[r3], "getAssetPath", new Object[0]));     // Catch: Throwable -> L28
        r3 = r3 + 1;
        goto L25
    L9:
        if (r1 == 27) goto L11;
    L13:
        int r4 = ((Integer) MethodUtils.invokeMethod(r7, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L28
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L31;
        String r6 = (String) MethodUtils.invokeMethod(r7, "getCookieName", new Object[]{Integer.valueOf(r5 + 1)});     // Catch: IndexOutOfBoundsException -> L32 Throwable -> L28
        if (TextUtils.isEmpty(r6) == true) goto L19;
        r0.append(r6);     // Catch: IndexOutOfBoundsException -> L32 Throwable -> L28
    L19:
        r5 = r5 + 1;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L28:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        goto L31
    }

    private static int[] handleAttrBefore(int[] r1) {
        int[] r2 = Arrays.copyOf(r1, r1.length);
        Arrays.sort(r2);
        return r2;
    }

    private static boolean instanceOfFragmentActivity(Object r1) {
        ensureFragmentActivity();
        Class r0 = fragmentClazz;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isInstance(r1);
    }

    private static boolean isSupportLibIso(String r1) {
        return PluginManager.getInstance().getPlugin(r1).mIsSupportLibIso;
    L4:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static Activity _getActivity(Object r2, String r3) {
        Activity r4 = (Activity) MethodUtils.invokeMethod(r2, "getActivity", new Object[0]);     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 NoSuchMethodException -> L18
        Activity r0 = (Activity) wrapperContext(r4, r3);     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 NoSuchMethodException -> L18
        if ((r0 instanceof GenerateProxyActivity) == false) goto L7;
        return ((GenerateProxyActivity) r0).mTargetActivity;
    L7:
        if (isSupportLibIso(r3) == true) goto L13;
        if ((r0 instanceof GenerateProxyAppCompatActivity) == false) goto L13;
        return ((GenerateProxyAppCompatActivity) r0).mTargetActivity;
    L13:
        return (Activity) wrapperContext(r4, r3);
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L18:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Class forName(String r0, String r1) throws ClassNotFoundException {
        return INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(Zeus.getPlugin(r1).mClassLoader, r0);
    }

    public static Activity getActivity(Object r0, String r1) {
        return _getActivity(r0, r1);
    }

    public static Context getContext(Object r2, String r3) {
        Context r4 = (Context) MethodUtils.invokeMethod(r2, "getContext", new Object[0]);     // Catch: Exception -> L22
        if (isSupportLibIso(r3) == true) goto L10;
        if (instanceOfFragmentActivity(r4) == false) goto L10;
        return wrapperContext(r4, r3);
    L10:
        if ((r4 instanceof Activity) == false) goto L14;
        return wrapperContext(r4, r3);
    L14:
        if ((r4 instanceof Application) == false) goto L18;
        return wrapperContext(r4, r3);
    L18:
        if ((r4 instanceof PluginContext) == false) goto L21;
        return r4;
    L21:
        return wrapperContext(r4, r3);
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Resources getResources(Object r3, String r4) {
        Resources r5 = (Resources) MethodUtils.invokeMethod(r3, "getResources", new Object[0]);     // Catch: Exception -> L19
        if (r5 != null) goto L8;
        return null;
    L8:
        if ((r5 instanceof PluginResources) == false) goto L17;
        String r1 = (String) FieldUtils.readField(r5, "pluginPkg");     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r1) == false) goto L15;
        if (getAssetPaths(r5.getAssets()).contains("/" + r4 + "/version") == false) goto L17;
        return r5;
    L15:
        if (TextUtils.equals(r1, r4) == false) goto L17;
        return r5;
    L17:
        return PluginManager.getInstance().getPlugin(r4).mResources;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Window getWindow(Activity r1, String r2) {
        Window r3 = r1.getWindow();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return (Window) MethodUtils.invokeMethod(r1, "getWindow", new Object[0]);
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static Context getWrapperFromCache(Object r2, String r3) {
        WeakReference<Context> r4 = contextCache.get(r3 + System.identityHashCode(r2));
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.get();
    }

    public static boolean instanceOf(Object r1, Class r2) {
        if ((r1 instanceof PluginContext) == false) goto L7;
        return r2.isInstance(((PluginContext) r1).mOriginContext);
    L7:
        if ((r1 instanceof PluginActivityWrapper) == false) goto L11;
        return r2.isInstance(((PluginActivityWrapper) r1).mOriginActivity);
    L11:
        if ((r1 instanceof PluginFragmentActivityWrapper) == false) goto L21;
        Object r3 = ((PluginFragmentActivityWrapper) r1).getOriginActivity();     // Catch: Throwable -> L14
    L16:
        return r2.isInstance(r3);
    L14:
        r3 = FieldUtils.readField(r1, "mOriginActivity");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw new RuntimeException(th);
    L21:
        if ((r1 instanceof PluginApplicationWrapper) == false) goto L25;
        return r2.isInstance(((PluginApplicationWrapper) r1).mOriginApplication);
    L25:
        if ((r1 instanceof GenerateProxyActivity) == false) goto L29;
        return r2.isInstance(((GenerateProxyActivity) r1).mTargetActivity);
    L29:
        return r2.isInstance(r1);
    }

    public static Context wrapperContext(Object r7, String r8) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if (Zeus.getAppApplication() != null) goto L10;
        Application r0 = (Application) ((Context) r7).getApplicationContext();
        if (r0 == null) goto L10;
        Zeus.setAppContext(r0);
    L10:
        Context r1 = getWrapperFromCache(r7, r8);
        if (r1 == null) goto L13;
        return r1;
    L13:
        Context r9 = (Context) r7;
        Context r2 = getContextIfNeedWrap(r9, r9, r8);
        if (r2 != null) goto L17;
        return r9;
    L17:
        if (isSupportLibIso(r8) == true) goto L29;
        if (instanceOfFragmentActivity(r2) == false) goto L29;
        if (Looper.myLooper() != null) goto L41;
        Looper.prepare();
    L41:
        Context r10 = new PluginFragmentActivityWrapper((Activity) r2, new PluginContext(r2, PluginManager.getInstance().getPlugin(r8), false));     // Catch: Throwable -> L25
    L38:
        if (r10 == null) goto L40;
        contextCache.put(r8 + System.identityHashCode(r2), new WeakReference(r10));
    L40:
        return r10;
    L25:
        r10 = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{r2, new PluginContext(r2, PluginManager.getInstance().getPlugin(r8), false)}, new Class[]{fragmentClazz, PluginContext.class});     // Catch: Throwable -> L27
    L27:
        return r2;
    L29:
        if ((r2 instanceof Activity) == false) goto L35;
        if (Looper.myLooper() != null) goto L33;
        Looper.prepare();
    L33:
        r10 = new PluginActivityWrapper((Activity) r2, new PluginContext(r2, PluginManager.getInstance().getPlugin(r8), false));
        goto L38
    L35:
        if ((r2 instanceof Application) == false) goto L37;
        r10 = new PluginApplicationWrapper((Application) r2, new PluginContext(r2, PluginManager.getInstance().getPlugin(r8), true));
        goto L38
    L37:
        r10 = new PluginContext(r2, PluginManager.getInstance().getPlugin(r8), false);
        goto L38
    }

    public static Activity wrapperContext2Activity(Object r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Context r0 = wrapperContext(r3, r4);
        if ((r0 instanceof Activity) == false) goto L10;
        return (Activity) r0;
    L10:
        if ((r0 instanceof PluginContext) == false) goto L14;
        return wrapperContext2Activity(((PluginContext) r0).mOriginContext, r4);
    L14:
        throw new RuntimeException("强转失败 context:" + r3 + " wrapperContext:" + r0);
    }

    public static Application wrapperContext2Application(Object r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Context r0 = wrapperContext(r3, r4);
        if ((r0 instanceof Application) == false) goto L10;
        return (Application) r0;
    L10:
        if ((r0 instanceof PluginContext) == false) goto L14;
        return wrapperContext2Application(((PluginContext) r0).mOriginContext, r4);
    L14:
        throw new RuntimeException("强转失败 context:" + r3 + " wrapperContext:" + r0);
    }

    private static Object wrapperContext2FragmentActivity(Object r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Context r0 = wrapperContext(r3, r4);
        if (isSupportLibIso(r4) == true) goto L11;
        if (instanceOfFragmentActivity(r0) == false) goto L11;
        return r0;
    L11:
        if ((r0 instanceof PluginContext) == false) goto L15;
        return wrapperContext2FragmentActivity(((PluginContext) r0).mOriginContext, r4);
    L15:
        throw new RuntimeException("强转失败 context:" + r3 + " wrapperContext:" + r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static boolean instanceOf(Class r0, Object r1) {
        return instanceOf(r1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context getContextIfNeedWrap(Context r2, Context r3, String r4) {
        if (r3 != 0) goto L6;
        return null;
    L6:
        if ((r3 instanceof IPluginActivity) == false) goto L12;
        if (TextUtils.equals(((IPluginActivity) r3).getPluginPkgName(), r4) == true) goto L10;
        return r2;
    L10:
        return null;
    L12:
        if ((r3 instanceof PluginContext) == false) goto L19;
        PluginContext r5 = (PluginContext) r3;
        if (TextUtils.equals(r5.mPlugin.mPkgName, r4) == false) goto L17;
        return null;
    L17:
        return r5.mOriginContext;
    L19:
        if ((r3 instanceof PluginActivityWrapper) == false) goto L26;
        PluginActivityWrapper r6 = (PluginActivityWrapper) r3;
        if (TextUtils.equals(r6.pluginContext.mPlugin.mPkgName, r4) == false) goto L24;
        return null;
    L24:
        return r6.mOriginActivity;
    L26:
        if (isSupportLibIso(r4) == true) goto L41;
        if ((r3 instanceof PluginFragmentActivityWrapper) == false) goto L41;
        if (TextUtils.equals(((PluginFragmentActivityWrapper) r3).pluginContext.mPlugin.mPkgName, r4) == false) goto L54;
        return null;
    L54:
        Object r7 = ((PluginFragmentActivityWrapper) r3).getOriginActivity();     // Catch: Throwable -> L34
    L36:
        return (Context) r7;
    L34:
        r7 = FieldUtils.readField(r3, "mOriginActivity");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw new RuntimeException(th);
    L41:
        if ((r3 instanceof PluginApplicationWrapper) == false) goto L48;
        PluginApplicationWrapper r8 = (PluginApplicationWrapper) r3;
        if (TextUtils.equals(r8.mPluginContext.mPlugin.mPkgName, r4) == false) goto L46;
        return null;
    L46:
        return r8.mOriginApplication;
    L48:
        if ((r3 instanceof ContextWrapper) == false) goto L59;
        Context r0 = (Context) FieldUtils.readField(r3, "mBase");     // Catch: Throwable -> L51
    L53:
        return getContextIfNeedWrap(r2, r0, r4);
    L51:
        r0 = ((ContextWrapper) r3).getBaseContext();
        goto L53
    L59:
        return r2;
    }

    private static void handleAttrAfter(TypedArray r5, int[] r6, int[] r7) {
        if (Arrays.equals(r6, r7) == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L9;
        r0.put(Integer.valueOf(r6[r2]), Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        HashMap r8 = new HashMap();
        int r3 = 0;
    L11:
        if (r3 >= r7.length) goto L23;
        r8.put((Integer) r0.get(Integer.valueOf(r7[r3])), Integer.valueOf(r3));
        r3 = r3 + 1;
        goto L11
    L23:
        int[] r9 = (int[]) FieldUtils.readField(r5, "mData");     // Catch: IllegalAccessException -> L21
        int[] r10 = Arrays.copyOf(r9, r9.length);     // Catch: IllegalAccessException -> L21
        Iterator r1 = r8.keySet().iterator();     // Catch: IllegalAccessException -> L21
    L15:
        if (r1.hasNext() == false) goto L19;
        Integer r4 = (Integer) r1.next();     // Catch: IllegalAccessException -> L21
        Integer r11 = (Integer) r8.get(r4);     // Catch: IllegalAccessException -> L21
        if (r4.equals(r11) == true) goto L15;
        System.arraycopy(r9, r4.intValue() * 7, r10, r11.intValue() * 7, 7);     // Catch: IllegalAccessException -> L21
        goto L15
    L19:
        System.arraycopy(r10, 0, r9, 0, r9.length);     // Catch: IllegalAccessException -> L21
        return;
    L21:
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "read mData failed.");
    }

    public static int mapRes(int r3, String r4, String r5) {
        if (r3 >= 2130706432) goto L5;
        return r3;
    L5:
        int r0 = Zeus.getAppApplication().getResources().getIdentifier(r5, r4, Zeus.getAppApplication().getPackageName());
        if (r0 != 0) goto L8;
        r0 = Zeus.getAppApplication().getResources().getIdentifier(r5.replace("_", "."), r4, Zeus.getAppApplication().getPackageName());
    L8:
        if (r0 != 0) goto L10;
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + r5 + ", pluginResId = " + r3);
    L10:
        return r0;
    }

    public static TypedArray obtainStyledAttributes(Object r4, int[] r5, String r6) {
        if ((r4 instanceof Context) == false) goto L7;
        int[] r7 = handleAttrBefore(r5);
        TypedArray r8 = ((Context) r4).obtainStyledAttributes(r7);
        handleAttrAfter(r8, r7, r5);
        return r8;
    L7:
        if ((r4 instanceof Resources.Theme) == false) goto L15;
        int[] r9 = handleAttrBefore(r5);
        TypedArray r10 = ((Resources.Theme) r4).obtainStyledAttributes(r9);
        handleAttrAfter(r10, r9, r5);
        return r10;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r4, "obtainStyledAttributes", new Object[]{r5, new Class[]{int[].class}});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Object preCheckCast(Object r2, Class r3, String r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Context) == true) goto L8;
        return r2;
    L8:
        boolean r0 = !r3.isInstance(r2);
        if (equalsFragmentActivity(r3) == false) goto L13;
        return wrapperContext2FragmentActivity(r2, r4);
    L13:
        if (r3 != Activity.class) goto L17;
        return wrapperContext2Activity(r2, r4);
    L17:
        if (r3 != Application.class) goto L21;
        return wrapperContext2Application(r2, r4);
    L21:
        if ((r2 instanceof PluginContext) == false) goto L26;
        if (r0 == false) goto L26;
        return ((PluginContext) r2).mOriginContext;
    L26:
        if ((r2 instanceof PluginFragmentActivityWrapper) == false) goto L36;
        if (r0 == false) goto L36;
        return ((PluginFragmentActivityWrapper) r2).getOriginActivity();
    L30:
        return FieldUtils.readField(r2, "mOriginActivity");
    L32:
        th = move-exception;
        throw new RuntimeException(th);
    L36:
        if ((r2 instanceof PluginActivityWrapper) == false) goto L41;
        if (r0 == false) goto L41;
        return ((PluginActivityWrapper) r2).mOriginActivity;
    L41:
        if ((r2 instanceof PluginApplicationWrapper) == false) goto L46;
        if (r0 == false) goto L46;
        return ((PluginApplicationWrapper) r2).mOriginApplication;
    L46:
        if ((r2 instanceof GenerateProxyActivity) == false) goto L53;
        if (r0 == true) goto L49;
        return r2;
    L49:
        return ((GenerateProxyActivity) r2).mTargetActivity;
    L53:
        return r2;
    }

    public static void registerZeusActivityStub(String r0, String[] r1, String r2) {
        ComponentManager.registerActivity(r2, r0, r1);
    }

    public static void setResult(Object r5, int r6, String r7) {
        if ((r5 instanceof Activity) == false) goto L16;
        Object r8 = FieldUtils.readField(r5, "mProxyActivity");     // Catch: Exception -> L8
        if (r8 == null) goto L16;
        MethodUtils.invokeMethod(r8, "setResult", new Object[]{Integer.valueOf(r6)});     // Catch: Exception -> L8
        return;
    L8:
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = " + r5);
    L16:
        MethodUtils.invokeMethod(r5, "setResult", new Object[]{Integer.valueOf(r6)});     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivity(Object r1, Intent r2, String r3) {
        startActivity(r1, r2, null, r3);
    }

    public static ComponentName startService(Object r2, Intent r3, String r4) {
        if ((r2 instanceof Context) == true) goto L5;
        return (ComponentName) MethodUtils.invokeMethod(r2, "startService", new Object[]{r3});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().startServiceNative((Context) r2, r3, r4);
    }

    public static boolean stopService(Object r2, Intent r3, String r4) {
        if ((r2 instanceof Context) == true) goto L5;
        return ((Boolean) MethodUtils.invokeMethod(r2, "stopService", new Object[]{r3})).booleanValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().stopServiceNative((Context) r2, r3, r4);
    }

    public static void unbindService(Object r2, ServiceConnection r3, String r4) {
        if ((r2 instanceof Context) == false) goto L10;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ZeusTransformUtils.unbindService invoke, obj=" + r2 + ", conn=" + r3);
        ServiceManagerNative.getInstance().unbindServiceNative((Context) r2, r3);
        return;
    L10:
        MethodUtils.invokeMethod(r2, "unbindService", new Object[]{r3});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void unregisterReceiver(Object r2, PluginBroadcastReceiver r3, String r4) {
        if ((r2 instanceof Context) == false) goto L10;
        ComponentManager.unregisterReceiver((Context) r2, r3);
        return;
    L10:
        MethodUtils.invokeMethod(r2, "unregisterReceiver", new Object[]{r3});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Object wrapperContextForParams(Object r1, Class r2, String r3) {
        if ((r1 instanceof PluginService) == false) goto L5;
    L12:
        return r1;
    L5:
        if ((r1 instanceof PluginIntentService) == true) goto L12;
        if ((r1 instanceof Context) == false) goto L12;
        Context r4 = convertProxy2PluginActivity(wrapperContext(r1, r3));
        if (r2.isInstance(r4) == false) goto L12;
        return r4;
    }

    public static Uri getUriForFile(Context r0, String r1, File r2, String r3) {
        return FileProvider.getUriForFile(r2);
    L5:
        return UriProtector.parse(XmlPullParser.NO_NAMESPACE);
    }

    public static View inflate(Context r1, int r2, ViewGroup r3, String r4) {
        if ((r1 instanceof PluginContext) == false) goto L5;
    L13:
        LayoutInflater r5 = (LayoutInflater) r1.getSystemService("layout_inflater");
        clearConstructorCache();
        View r6 = r5.inflate(r2, r3);
        clearConstructorCache();
        return r6;
    L5:
        if ((r1 instanceof PluginActivityWrapper) == true) goto L13;
        if (isSupportLibIso(r4) == true) goto L11;
        if ((r1 instanceof PluginFragmentActivityWrapper) == true) goto L13;
    L11:
        if ((r1 instanceof PluginApplicationWrapper) == true) goto L13;
        r1 = wrapperContext(r1, r4);
        goto L13
    }

    public static TypedArray obtainAttributes(Object r2, AttributeSet r3, int[] r4, String r5) {
        if ((r2 instanceof Resources) == false) goto L11;
        int[] r6 = handleAttrBefore(r4);
        TypedArray r7 = ((Resources) r2).obtainAttributes(r3, r6);
        handleAttrAfter(r7, r6, r4);
        return r7;
    L11:
        return (TypedArray) MethodUtils.invokeMethod(r2, "obtainAttributes", new Object[]{r3, r4});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static TypedArray obtainStyledAttributes(Object r2, int r3, int[] r4, String r5) {
        if ((r2 instanceof Context) == false) goto L7;
        int[] r6 = handleAttrBefore(r4);
        TypedArray r7 = ((Context) r2).obtainStyledAttributes(r3, r6);
        handleAttrAfter(r7, r6, r4);
        return r7;
    L7:
        if ((r2 instanceof Resources.Theme) == false) goto L15;
        int[] r8 = handleAttrBefore(r4);
        TypedArray r9 = ((Resources.Theme) r2).obtainStyledAttributes(r3, r8);
        handleAttrAfter(r9, r8, r4);
        return r9;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r2, "obtainStyledAttributes", new Object[]{Integer.valueOf(r3), r4});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r2, PluginBroadcastReceiver r3, IntentFilter r4, String r5) {
        if ((r2 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
        return ComponentManager.registerReceiver((Context) r2, r3, r4, r5);
    L11:
        return (Intent) MethodUtils.invokeMethod(r2, "registerReceiver", new Object[]{r3, r4});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void requestPermissions(Object r2, String[] r3, int r4, String r5) {
        if ((r2 instanceof IPluginActivity) == false) goto L6;
        ((IPluginActivity) r2)._requestPermissions(r3, r4);
        return;
    L6:
        if ((r2 instanceof Activity) == false) goto L19;
        Object r6 = FieldUtils.readField(r2, "mOriginActivity");     // Catch: IllegalAccessException -> L9
    L10:
        if (r6 == null) goto L19;
        r2 = r6;
    L9:
        r6 = null;
    L19:
        MethodUtils.invokeMethod(r2, "requestPermissions", new Object[]{r3, Integer.valueOf(r4)});     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setComponentEnabledSetting(PackageManager r0, ComponentName r1, int r2, int r3) {
        r0.setComponentEnabledSetting(r1, r2, r3);     // Catch: Throwable -> L4
        return;
    }

    public static void setResult(Object r6, int r7, Intent r8, String r9) {
        if ((r6 instanceof Activity) == false) goto L18;
        Object r10 = FieldUtils.readField(r6, "mProxyActivity");     // Catch: Exception -> L15
        if (r10 != null) goto L7;
        r10 = FieldUtils.readField(r6, "mOriginActivity");     // Catch: Exception -> L15
    L7:
        if (r10 == null) goto L18;
        MethodUtils.invokeMethod(r10, "setResult", new Object[]{Integer.valueOf(r7), r8});     // Catch: Exception -> L15
        return;
    L18:
        MethodUtils.invokeMethod(r6, "setResult", new Object[]{Integer.valueOf(r7), r8});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivity(Object r4, Intent r5, Bundle r6, String r7) {
        ComponentManager.startActivity(r4, r5, r6, r7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if ((r4 instanceof Context) == false) goto L15;
        ComponentManager.startActivity((Context) r4, r5, r6, r7);
        return;
    L15:
        MethodUtils.invokeMethod(r4, "startActivity", new Object[]{r5, r6}, new Class[]{Intent.class, Bundle.class});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw new RuntimeException(th);
    }

    public static void startActivityForResult(Object r1, Intent r2, int r3, String r4) {
        startActivityForResult(r1, r2, r3, null, r4);
    }

    public static View inflate(LayoutInflater r1, int r2, ViewGroup r3, String r4) {
        if (r3 == null) goto L4;
        boolean r0 = true;
    L6:
        return inflate(r1, r2, r3, r0, r4);
    L4:
        r0 = false;
        goto L6
    }

    public static TypedArray obtainStyledAttributes(Object r2, AttributeSet r3, int[] r4, String r5) {
        if ((r2 instanceof Context) == false) goto L11;
        int[] r6 = handleAttrBefore(r4);
        TypedArray r7 = ((Context) r2).obtainStyledAttributes(r3, r6);
        handleAttrAfter(r7, r6, r4);
        return r7;
    L11:
        return (TypedArray) MethodUtils.invokeMethod(r2, "obtainStyledAttributes", new Object[]{r3, r4});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static View inflate(LayoutInflater r1, XmlPullParser r2, ViewGroup r3, String r4) {
        if (r3 == null) goto L4;
        boolean r0 = true;
    L6:
        return inflate(r1, r2, r3, r0, r4);
    L4:
        r0 = false;
        goto L6
    }

    public static boolean bindService(Object r7, Intent r8, ServiceConnection r9, int r10, String r11) {
        if ((r7 instanceof Context) == true) goto L5;
        return ((Boolean) MethodUtils.invokeMethod(r7, "bindService", new Object[]{r8, r9, Integer.valueOf(r10)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().bindServiceNative((Context) r7, r8, r9, r10, r11);
    }

    public static int getIdentifier(Object r2, String r3, String r4, String r5, String r6) {
        if ((r2 instanceof Resources) == false) goto L15;
        Resources r7 = (Resources) r2;
        if (TextUtils.equals("android", r5) == true) goto L9;
        r5 = r6;
    L9:
        return r7.getIdentifier(r3, r4, r5);
    L15:
        return ((Integer) MethodUtils.invokeMethod(r2, "getIdentifier", new Object[]{r3, r4, r5})).intValue();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static View inflate(LayoutInflater r3, int r4, ViewGroup r5, boolean r6, String r7) {
        Context r0 = r3.getContext();
        if ((r0 instanceof PluginContext) == false) goto L5;
    L24:
        clearConstructorCache();
        View r8 = r3.inflate(r4, r5, r6);
        clearConstructorCache();
        return r8;
    L5:
        if ((r0 instanceof PluginActivityWrapper) == true) goto L24;
        if (isSupportLibIso(r7) == true) goto L11;
        if ((r0 instanceof PluginFragmentActivityWrapper) == true) goto L24;
    L11:
        if ((r0 instanceof PluginApplicationWrapper) == true) goto L24;
        Context r1 = wrapperContext(r0, r7);
        LayoutInflater.Factory r2 = r3.getFactory();
        LayoutInflater.Factory2 r9 = r3.getFactory2();
        LayoutInflater r10 = (LayoutInflater) r1.getSystemService("layout_inflater");
        if (isSupportLibIso(r7) == true) goto L15;
    L23:
        r3 = r10;
        goto L24
    L15:
        if (r2 != null) goto L28;
    L19:
        if (r9 == null) goto L23;
        FieldUtils.writeField(r10, "mFactory2", r9);     // Catch: Throwable -> L22
    L22:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory2 failed.");
        goto L23
    L28:
        FieldUtils.writeField(r10, "mFactory", r2);     // Catch: Throwable -> L18
    L18:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory failed.");
        goto L19
    }

    public static Intent registerReceiver(Object r2, PluginBroadcastReceiver r3, IntentFilter r4, int r5, String r6) {
        if ((r2 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
        return ComponentManager.registerReceiver((Context) r2, r3, r4, r5, r6);
    L11:
        return (Intent) MethodUtils.invokeMethod(r2, "registerReceiver", new Object[]{r3, r4, Integer.valueOf(r5)});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivityForResult(Object r4, Intent r5, int r6, Bundle r7, String r8) {
        ComponentManager.startActivityForResult(r4, r5, r6, r7, r8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if ((r4 instanceof Activity) == false) goto L13;
        ComponentManager.startActivityForResult((Activity) r4, r5, r6, r7, r8);
        return;
    L13:
        MethodUtils.invokeMethod(r4, "startActivityForResult", new Object[]{r5, Integer.valueOf(r6), r7}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw new RuntimeException(th);
    }

    public static View inflate(LayoutInflater r1, XmlPullParser r2, ViewGroup r3, boolean r4, String r5) {
        Context r6 = r1.getContext();
        if ((r6 instanceof PluginContext) == false) goto L5;
    L13:
        LayoutInflater r7 = (LayoutInflater) r6.getSystemService("layout_inflater");
        clearConstructorCache();
        View r8 = r7.inflate(r2, r3, r4);
        clearConstructorCache();
        return r8;
    L5:
        if ((r6 instanceof PluginActivityWrapper) == true) goto L13;
        if (isSupportLibIso(r5) == true) goto L11;
        if ((r6 instanceof PluginFragmentActivityWrapper) == true) goto L13;
    L11:
        if ((r6 instanceof PluginApplicationWrapper) == true) goto L13;
        r6 = wrapperContext(r6, r5);
        goto L13
    }

    public static TypedArray obtainStyledAttributes(Object r2, AttributeSet r3, int[] r4, int r5, int r6, String r7) {
        if ((r2 instanceof Context) == false) goto L7;
        int[] r8 = handleAttrBefore(r4);
        TypedArray r9 = ((Context) r2).obtainStyledAttributes(r3, r8);
        handleAttrAfter(r9, r8, r4);
        return r9;
    L7:
        if ((r2 instanceof Resources.Theme) == false) goto L15;
        int[] r10 = handleAttrBefore(r4);
        TypedArray r11 = ((Resources.Theme) r2).obtainStyledAttributes(r3, r10, r5, r6);
        handleAttrAfter(r11, r10, r4);
        return r11;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r2, "obtainStyledAttributes", new Object[]{r3, r4, Integer.valueOf(r5), Integer.valueOf(r6)});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r8, PluginBroadcastReceiver r9, IntentFilter r10, String r11, Handler r12, String r13) {
        if ((r8 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
        return ComponentManager.registerReceiver((Context) r8, r9, r10, r11, r12, r13);
    L11:
        return (Intent) MethodUtils.invokeMethod(r8, "registerReceiver", new Object[]{r9, r10, r11, r12});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r9, PluginBroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14, String r15) {
        if ((r9 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
        return ComponentManager.registerReceiver((Context) r9, r10, r11, r12, r13, r14, r15);
    L11:
        return (Intent) MethodUtils.invokeMethod(r9, "registerReceiver", new Object[]{r10, r11, r12, r13, Integer.valueOf(r14)});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
