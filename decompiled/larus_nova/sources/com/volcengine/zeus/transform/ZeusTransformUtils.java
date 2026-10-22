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
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes.dex */
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
        Iterator r100 = new HashSet(sConstructorMap.keySet()).iterator();     // Catch: Throwable -> L22
    L8:
        if (r100.hasNext() == false) goto L38;
        String r101 = (String) r100.next();     // Catch: Throwable -> L22
        if (r101.startsWith("android.view.") == true) goto L8;
        if (r101.startsWith("android.widget.") == true) goto L8;
        if (r101.startsWith("android.webkit.") == true) goto L8;
        if (r101.contains(".") == false) goto L8;
        sConstructorMap.remove(r101);     // Catch: Throwable -> L22
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

    private static Context convertProxy2PluginActivity(Context r100) {
    L8:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "convertProxy2PluginActivity failed.", th);
    L10:
        return r100;
    L3:
        if ((r100 instanceof GenerateProxyActivity) == false) goto L5;
    L6:
        return (Activity) FieldUtils.readField(r100, "mTargetActivity");
    L5:
        if ((r100 instanceof GenerateProxyAppCompatActivity) == false) goto L10;
        goto L6
    }

    private static boolean equalsFragmentActivity(Class r100) {
        ensureFragmentActivity();
        Class r101 = fragmentClazz;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static String getAssetPaths(AssetManager r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 != null) goto L35;
        return "";
    L35:
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L28
        if (r102 < 28) goto L9;
    L20:
        Object[] r103 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Throwable -> L28
        if (r103 != null) goto L23;
    L31:
        return r101.toString();
    L23:
        if (r103.length <= 0) goto L31;
        int r104 = r103.length;     // Catch: Throwable -> L28
        int r105 = 0;
    L25:
        if (r105 >= r104) goto L31;
        r101.append((String) MethodUtils.invokeMethod(r103[r105], "getAssetPath", new Object[0]));     // Catch: Throwable -> L28
        r105 = r105 + 1;
        goto L25
    L9:
        if (r102 == 27) goto L11;
    L13:
        int r106 = ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L28
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L31;
        String r108 = (String) MethodUtils.invokeMethod(r100, "getCookieName", new Object[]{Integer.valueOf(r107 + 1)});     // Catch: IndexOutOfBoundsException -> L32 Throwable -> L28
        if (TextUtils.isEmpty(r108) == true) goto L19;
        r101.append(r108);     // Catch: IndexOutOfBoundsException -> L32 Throwable -> L28
    L19:
        r107 = r107 + 1;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L28:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        goto L31
    }

    private static int[] handleAttrBefore(int[] r100) {
        int[] r101 = Arrays.copyOf(r100, r100.length);
        Arrays.sort(r101);
        return r101;
    }

    private static boolean instanceOfFragmentActivity(Object r100) {
        ensureFragmentActivity();
        Class r101 = fragmentClazz;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isInstance(r100);
    }

    private static boolean isSupportLibIso(String r100) {
        return PluginManager.getInstance().getPlugin(r100).mIsSupportLibIso;
    L4:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static Activity _getActivity(Object r100, String r101) {
        Activity r102 = (Activity) MethodUtils.invokeMethod(r100, "getActivity", new Object[0]);     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 NoSuchMethodException -> L18
        Activity r103 = (Activity) wrapperContext(r102, r101);     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 NoSuchMethodException -> L18
        if ((r103 instanceof GenerateProxyActivity) == false) goto L7;
        return ((GenerateProxyActivity) r103).mTargetActivity;
    L7:
        if (isSupportLibIso(r101) == true) goto L13;
        if ((r103 instanceof GenerateProxyAppCompatActivity) == false) goto L13;
        return ((GenerateProxyAppCompatActivity) r103).mTargetActivity;
    L13:
        return (Activity) wrapperContext(r102, r101);
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

    public static Class forName(String r100, String r101) throws ClassNotFoundException {
        return INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(Zeus.getPlugin(r101).mClassLoader, r100);
    }

    public static Activity getActivity(Object r100, String r101) {
        return _getActivity(r100, r101);
    }

    public static Context getContext(Object r100, String r101) {
        Context r102 = (Context) MethodUtils.invokeMethod(r100, "getContext", new Object[0]);     // Catch: Exception -> L22
        if (isSupportLibIso(r101) == true) goto L10;
        if (instanceOfFragmentActivity(r102) == false) goto L10;
        return wrapperContext(r102, r101);
    L10:
        if ((r102 instanceof Activity) == false) goto L14;
        return wrapperContext(r102, r101);
    L14:
        if ((r102 instanceof Application) == false) goto L18;
        return wrapperContext(r102, r101);
    L18:
        if ((r102 instanceof PluginContext) == false) goto L21;
        return r102;
    L21:
        return wrapperContext(r102, r101);
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Resources getResources(Object r100, String r101) {
        Resources r102 = (Resources) MethodUtils.invokeMethod(r100, "getResources", new Object[0]);     // Catch: Exception -> L19
        if (r102 != null) goto L8;
        return null;
    L8:
        if ((r102 instanceof PluginResources) == false) goto L17;
        String r103 = (String) FieldUtils.readField(r102, "pluginPkg");     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r103) == false) goto L15;
        if (getAssetPaths(r102.getAssets()).contains(HTTP.URL_DEFAULT + r101 + "/version") == false) goto L17;
        return r102;
    L15:
        if (TextUtils.equals(r103, r101) == false) goto L17;
        return r102;
    L17:
        return PluginManager.getInstance().getPlugin(r101).mResources;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Window getWindow(Activity r100, String r101) {
        Window r102 = r100.getWindow();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return (Window) MethodUtils.invokeMethod(r100, "getWindow", new Object[0]);
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static Context getWrapperFromCache(Object r100, String r101) {
        WeakReference<Context> r102 = contextCache.get(r101 + System.identityHashCode(r100));
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.get();
    }

    public static boolean instanceOf(Object r100, Class r101) {
        if ((r100 instanceof PluginContext) == false) goto L7;
        return r101.isInstance(((PluginContext) r100).mOriginContext);
    L7:
        if ((r100 instanceof PluginActivityWrapper) == false) goto L11;
        return r101.isInstance(((PluginActivityWrapper) r100).mOriginActivity);
    L11:
        if ((r100 instanceof PluginFragmentActivityWrapper) == false) goto L21;
        Object r102 = ((PluginFragmentActivityWrapper) r100).getOriginActivity();     // Catch: Throwable -> L14
    L16:
        return r101.isInstance(r102);
    L14:
        r102 = FieldUtils.readField(r100, "mOriginActivity");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw new RuntimeException(th);
    L21:
        if ((r100 instanceof PluginApplicationWrapper) == false) goto L25;
        return r101.isInstance(((PluginApplicationWrapper) r100).mOriginApplication);
    L25:
        if ((r100 instanceof GenerateProxyActivity) == false) goto L29;
        return r101.isInstance(((GenerateProxyActivity) r100).mTargetActivity);
    L29:
        return r101.isInstance(r100);
    }

    public static Context wrapperContext(Object r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Zeus.getAppApplication() != null) goto L10;
        Application r102 = (Application) ((Context) r100).getApplicationContext();
        if (r102 == null) goto L10;
        Zeus.setAppContext(r102);
    L10:
        Context r103 = getWrapperFromCache(r100, r101);
        if (r103 == null) goto L13;
        return r103;
    L13:
        Context r104 = (Context) r100;
        Context r105 = getContextIfNeedWrap(r104, r104, r101);
        if (r105 != null) goto L17;
        return r104;
    L17:
        if (isSupportLibIso(r101) == true) goto L29;
        if (instanceOfFragmentActivity(r105) == false) goto L29;
        if (Looper.myLooper() != null) goto L41;
        Looper.prepare();
    L41:
        Context r106 = new PluginFragmentActivityWrapper((Activity) r105, new PluginContext(r105, PluginManager.getInstance().getPlugin(r101), false));     // Catch: Throwable -> L25
    L38:
        if (r106 == null) goto L40;
        contextCache.put(r101 + System.identityHashCode(r105), new WeakReference(r106));
    L40:
        return r106;
    L25:
        r106 = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{r105, new PluginContext(r105, PluginManager.getInstance().getPlugin(r101), false)}, new Class[]{fragmentClazz, PluginContext.class});     // Catch: Throwable -> L27
    L27:
        return r105;
    L29:
        if ((r105 instanceof Activity) == false) goto L35;
        if (Looper.myLooper() != null) goto L33;
        Looper.prepare();
    L33:
        r106 = new PluginActivityWrapper((Activity) r105, new PluginContext(r105, PluginManager.getInstance().getPlugin(r101), false));
        goto L38
    L35:
        if ((r105 instanceof Application) == false) goto L37;
        r106 = new PluginApplicationWrapper((Application) r105, new PluginContext(r105, PluginManager.getInstance().getPlugin(r101), true));
        goto L38
    L37:
        r106 = new PluginContext(r105, PluginManager.getInstance().getPlugin(r101), false);
        goto L38
    }

    public static Activity wrapperContext2Activity(Object r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Context r102 = wrapperContext(r100, r101);
        if ((r102 instanceof Activity) == false) goto L10;
        return (Activity) r102;
    L10:
        if ((r102 instanceof PluginContext) == false) goto L14;
        return wrapperContext2Activity(((PluginContext) r102).mOriginContext, r101);
    L14:
        throw new RuntimeException("强转失败 context:" + r100 + " wrapperContext:" + r102);
    }

    public static Application wrapperContext2Application(Object r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Context r102 = wrapperContext(r100, r101);
        if ((r102 instanceof Application) == false) goto L10;
        return (Application) r102;
    L10:
        if ((r102 instanceof PluginContext) == false) goto L14;
        return wrapperContext2Application(((PluginContext) r102).mOriginContext, r101);
    L14:
        throw new RuntimeException("强转失败 context:" + r100 + " wrapperContext:" + r102);
    }

    private static Object wrapperContext2FragmentActivity(Object r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Context r102 = wrapperContext(r100, r101);
        if (isSupportLibIso(r101) == true) goto L11;
        if (instanceOfFragmentActivity(r102) == false) goto L11;
        return r102;
    L11:
        if ((r102 instanceof PluginContext) == false) goto L15;
        return wrapperContext2FragmentActivity(((PluginContext) r102).mOriginContext, r101);
    L15:
        throw new RuntimeException("强转失败 context:" + r100 + " wrapperContext:" + r102);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_transform_ZeusTransformUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static boolean instanceOf(Class r100, Object r101) {
        return instanceOf(r101, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context getContextIfNeedWrap(Context r100, Context r101, String r102) {
        if (r101 != 0) goto L6;
        return null;
    L6:
        if ((r101 instanceof IPluginActivity) == false) goto L12;
        if (TextUtils.equals(((IPluginActivity) r101).getPluginPkgName(), r102) == true) goto L10;
        return r100;
    L10:
        return null;
    L12:
        if ((r101 instanceof PluginContext) == false) goto L19;
        PluginContext r103 = (PluginContext) r101;
        if (TextUtils.equals(r103.mPlugin.mPkgName, r102) == false) goto L17;
        return null;
    L17:
        return r103.mOriginContext;
    L19:
        if ((r101 instanceof PluginActivityWrapper) == false) goto L26;
        PluginActivityWrapper r104 = (PluginActivityWrapper) r101;
        if (TextUtils.equals(r104.pluginContext.mPlugin.mPkgName, r102) == false) goto L24;
        return null;
    L24:
        return r104.mOriginActivity;
    L26:
        if (isSupportLibIso(r102) == true) goto L41;
        if ((r101 instanceof PluginFragmentActivityWrapper) == false) goto L41;
        if (TextUtils.equals(((PluginFragmentActivityWrapper) r101).pluginContext.mPlugin.mPkgName, r102) == false) goto L54;
        return null;
    L54:
        Object r105 = ((PluginFragmentActivityWrapper) r101).getOriginActivity();     // Catch: Throwable -> L34
    L36:
        return (Context) r105;
    L34:
        r105 = FieldUtils.readField(r101, "mOriginActivity");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw new RuntimeException(th);
    L41:
        if ((r101 instanceof PluginApplicationWrapper) == false) goto L48;
        PluginApplicationWrapper r106 = (PluginApplicationWrapper) r101;
        if (TextUtils.equals(r106.mPluginContext.mPlugin.mPkgName, r102) == false) goto L46;
        return null;
    L46:
        return r106.mOriginApplication;
    L48:
        if ((r101 instanceof ContextWrapper) == false) goto L59;
        Context r107 = (Context) FieldUtils.readField(r101, "mBase");     // Catch: Throwable -> L51
    L53:
        return getContextIfNeedWrap(r100, r107, r102);
    L51:
        r107 = ((ContextWrapper) r101).getBaseContext();
        goto L53
    L59:
        return r100;
    }

    private static void handleAttrAfter(TypedArray r100, int[] r101, int[] r102) {
        if (Arrays.equals(r101, r102) == false) goto L5;
        return;
    L5:
        HashMap r103 = new HashMap();
        int r104 = 0;
    L7:
        if (r104 >= r101.length) goto L9;
        r103.put(Integer.valueOf(r101[r104]), Integer.valueOf(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        HashMap r105 = new HashMap();
        int r106 = 0;
    L11:
        if (r106 >= r102.length) goto L23;
        r105.put((Integer) r103.get(Integer.valueOf(r102[r106])), Integer.valueOf(r106));
        r106 = r106 + 1;
        goto L11
    L23:
        int[] r107 = (int[]) FieldUtils.readField(r100, "mData");     // Catch: IllegalAccessException -> L21
        int[] r108 = Arrays.copyOf(r107, r107.length);     // Catch: IllegalAccessException -> L21
        Iterator r109 = r105.keySet().iterator();     // Catch: IllegalAccessException -> L21
    L15:
        if (r109.hasNext() == false) goto L19;
        Integer r110 = (Integer) r109.next();     // Catch: IllegalAccessException -> L21
        Integer r111 = (Integer) r105.get(r110);     // Catch: IllegalAccessException -> L21
        if (r110.equals(r111) == true) goto L15;
        System.arraycopy(r107, r110.intValue() * 7, r108, r111.intValue() * 7, 7);     // Catch: IllegalAccessException -> L21
        goto L15
    L19:
        System.arraycopy(r108, 0, r107, 0, r107.length);     // Catch: IllegalAccessException -> L21
        return;
    L21:
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "read mData failed.");
    }

    public static int mapRes(int r100, String r101, String r102) {
        if (r100 >= 2130706432) goto L5;
        return r100;
    L5:
        int r103 = Zeus.getAppApplication().getResources().getIdentifier(r102, r101, Zeus.getAppApplication().getPackageName());
        if (r103 != 0) goto L8;
        r103 = Zeus.getAppApplication().getResources().getIdentifier(r102.replace("_", "."), r101, Zeus.getAppApplication().getPackageName());
    L8:
        if (r103 != 0) goto L10;
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + r102 + ", pluginResId = " + r100);
    L10:
        return r103;
    }

    public static TypedArray obtainStyledAttributes(Object r100, int[] r101, String r102) {
        if ((r100 instanceof Context) == false) goto L7;
        int[] r103 = handleAttrBefore(r101);
        TypedArray r104 = ((Context) r100).obtainStyledAttributes(r103);
        handleAttrAfter(r104, r103, r101);
        return r104;
    L7:
        if ((r100 instanceof Resources.Theme) == false) goto L15;
        int[] r105 = handleAttrBefore(r101);
        TypedArray r106 = ((Resources.Theme) r100).obtainStyledAttributes(r105);
        handleAttrAfter(r106, r105, r101);
        return r106;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r100, "obtainStyledAttributes", new Object[]{r101, new Class[]{int[].class}});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Object preCheckCast(Object r100, Class r101, String r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Context) == true) goto L8;
        return r100;
    L8:
        boolean r103 = !r101.isInstance(r100);
        if (equalsFragmentActivity(r101) == false) goto L13;
        return wrapperContext2FragmentActivity(r100, r102);
    L13:
        if (r101 != Activity.class) goto L17;
        return wrapperContext2Activity(r100, r102);
    L17:
        if (r101 != Application.class) goto L21;
        return wrapperContext2Application(r100, r102);
    L21:
        if ((r100 instanceof PluginContext) == false) goto L26;
        if (r103 == false) goto L26;
        return ((PluginContext) r100).mOriginContext;
    L26:
        if ((r100 instanceof PluginFragmentActivityWrapper) == false) goto L36;
        if (r103 == false) goto L36;
        return ((PluginFragmentActivityWrapper) r100).getOriginActivity();
    L30:
        return FieldUtils.readField(r100, "mOriginActivity");
    L32:
        th = move-exception;
        throw new RuntimeException(th);
    L36:
        if ((r100 instanceof PluginActivityWrapper) == false) goto L41;
        if (r103 == false) goto L41;
        return ((PluginActivityWrapper) r100).mOriginActivity;
    L41:
        if ((r100 instanceof PluginApplicationWrapper) == false) goto L46;
        if (r103 == false) goto L46;
        return ((PluginApplicationWrapper) r100).mOriginApplication;
    L46:
        if ((r100 instanceof GenerateProxyActivity) == false) goto L53;
        if (r103 == true) goto L49;
        return r100;
    L49:
        return ((GenerateProxyActivity) r100).mTargetActivity;
    L53:
        return r100;
    }

    public static void registerZeusActivityStub(String r100, String[] r101, String r102) {
        ComponentManager.registerActivity(r102, r100, r101);
    }

    public static void setResult(Object r100, int r101, String r102) {
        if ((r100 instanceof Activity) == false) goto L16;
        Object r103 = FieldUtils.readField(r100, "mProxyActivity");     // Catch: Exception -> L8
        if (r103 == null) goto L16;
        MethodUtils.invokeMethod(r103, "setResult", new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L8:
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = " + r100);
    L16:
        MethodUtils.invokeMethod(r100, "setResult", new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivity(Object r100, Intent r101, String r102) {
        startActivity(r100, r101, null, r102);
    }

    public static ComponentName startService(Object r100, Intent r101, String r102) {
        if ((r100 instanceof Context) == true) goto L5;
        return (ComponentName) MethodUtils.invokeMethod(r100, "startService", new Object[]{r101});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().startServiceNative((Context) r100, r101, r102);
    }

    public static boolean stopService(Object r100, Intent r101, String r102) {
        if ((r100 instanceof Context) == true) goto L5;
        return ((Boolean) MethodUtils.invokeMethod(r100, "stopService", new Object[]{r101})).booleanValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().stopServiceNative((Context) r100, r101, r102);
    }

    public static void unbindService(Object r100, ServiceConnection r101, String r102) {
        if ((r100 instanceof Context) == false) goto L10;
        ZeusLogger.i(ZeusLogger.TAG_SERVICE, "ZeusTransformUtils.unbindService invoke, obj=" + r100 + ", conn=" + r101);
        ServiceManagerNative.getInstance().unbindServiceNative((Context) r100, r101);
        return;
    L10:
        MethodUtils.invokeMethod(r100, "unbindService", new Object[]{r101});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void unregisterReceiver(Object r100, PluginBroadcastReceiver r101, String r102) {
        if ((r100 instanceof Context) == false) goto L10;
        ComponentManager.unregisterReceiver((Context) r100, r101);
        return;
    L10:
        MethodUtils.invokeMethod(r100, "unregisterReceiver", new Object[]{r101});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Object wrapperContextForParams(Object r100, Class r101, String r102) {
        if ((r100 instanceof PluginService) == false) goto L5;
    L12:
        return r100;
    L5:
        if ((r100 instanceof PluginIntentService) == true) goto L12;
        if ((r100 instanceof Context) == false) goto L12;
        Context r103 = convertProxy2PluginActivity(wrapperContext(r100, r102));
        if (r101.isInstance(r103) == false) goto L12;
        return r103;
    }

    public static Uri getUriForFile(Context r100, String r101, File r102, String r103) {
        return FileProvider.getUriForFile(r102);
    L5:
        return UriProtector.parse("");
    }

    public static View inflate(Context r100, int r101, ViewGroup r102, String r103) {
        if ((r100 instanceof PluginContext) == false) goto L5;
    L13:
        LayoutInflater r104 = (LayoutInflater) r100.getSystemService("layout_inflater");
        clearConstructorCache();
        View r105 = r104.inflate(r101, r102);
        clearConstructorCache();
        return r105;
    L5:
        if ((r100 instanceof PluginActivityWrapper) == true) goto L13;
        if (isSupportLibIso(r103) == true) goto L11;
        if ((r100 instanceof PluginFragmentActivityWrapper) == true) goto L13;
    L11:
        if ((r100 instanceof PluginApplicationWrapper) == true) goto L13;
        r100 = wrapperContext(r100, r103);
        goto L13
    }

    public static TypedArray obtainAttributes(Object r100, AttributeSet r101, int[] r102, String r103) {
        if ((r100 instanceof Resources) == false) goto L11;
        int[] r104 = handleAttrBefore(r102);
        TypedArray r105 = ((Resources) r100).obtainAttributes(r101, r104);
        handleAttrAfter(r105, r104, r102);
        return r105;
    L11:
        return (TypedArray) MethodUtils.invokeMethod(r100, "obtainAttributes", new Object[]{r101, r102});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static TypedArray obtainStyledAttributes(Object r100, int r101, int[] r102, String r103) {
        if ((r100 instanceof Context) == false) goto L7;
        int[] r104 = handleAttrBefore(r102);
        TypedArray r105 = ((Context) r100).obtainStyledAttributes(r101, r104);
        handleAttrAfter(r105, r104, r102);
        return r105;
    L7:
        if ((r100 instanceof Resources.Theme) == false) goto L15;
        int[] r106 = handleAttrBefore(r102);
        TypedArray r107 = ((Resources.Theme) r100).obtainStyledAttributes(r101, r106);
        handleAttrAfter(r107, r106, r102);
        return r107;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r100, "obtainStyledAttributes", new Object[]{Integer.valueOf(r101), r102});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r100, PluginBroadcastReceiver r101, IntentFilter r102, String r103) {
        if ((r100 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
        return ComponentManager.registerReceiver((Context) r100, r101, r102, r103);
    L11:
        return (Intent) MethodUtils.invokeMethod(r100, "registerReceiver", new Object[]{r101, r102});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void requestPermissions(Object r100, String[] r101, int r102, String r103) {
        if ((r100 instanceof IPluginActivity) == false) goto L6;
        ((IPluginActivity) r100)._requestPermissions(r101, r102);
        return;
    L6:
        if ((r100 instanceof Activity) == false) goto L19;
        Object r104 = FieldUtils.readField(r100, "mOriginActivity");     // Catch: IllegalAccessException -> L9
    L10:
        if (r104 == null) goto L19;
        r100 = r104;
    L9:
        r104 = null;
    L19:
        MethodUtils.invokeMethod(r100, "requestPermissions", new Object[]{r101, Integer.valueOf(r102)});     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setComponentEnabledSetting(PackageManager r100, ComponentName r101, int r102, int r103) {
        r100.setComponentEnabledSetting(r101, r102, r103);     // Catch: Throwable -> L4
        return;
    }

    public static void setResult(Object r100, int r101, Intent r102, String r103) {
        if ((r100 instanceof Activity) == false) goto L18;
        Object r104 = FieldUtils.readField(r100, "mProxyActivity");     // Catch: Exception -> L15
        if (r104 != null) goto L7;
        r104 = FieldUtils.readField(r100, "mOriginActivity");     // Catch: Exception -> L15
    L7:
        if (r104 == null) goto L18;
        MethodUtils.invokeMethod(r104, "setResult", new Object[]{Integer.valueOf(r101), r102});     // Catch: Exception -> L15
        return;
    L18:
        MethodUtils.invokeMethod(r100, "setResult", new Object[]{Integer.valueOf(r101), r102});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivity(Object r100, Intent r101, Bundle r102, String r103) {
        ComponentManager.startActivity(r100, r101, r102, r103);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if ((r100 instanceof Context) == false) goto L15;
        ComponentManager.startActivity((Context) r100, r101, r102, r103);
        return;
    L15:
        MethodUtils.invokeMethod(r100, "startActivity", new Object[]{r101, r102}, new Class[]{Intent.class, Bundle.class});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw new RuntimeException(th);
    }

    public static void startActivityForResult(Object r100, Intent r101, int r102, String r103) {
        startActivityForResult(r100, r101, r102, null, r103);
    }

    public static View inflate(LayoutInflater r100, int r101, ViewGroup r102, String r103) {
        if (r102 == null) goto L4;
        boolean r104 = true;
    L6:
        return inflate(r100, r101, r102, r104, r103);
    L4:
        r104 = false;
        goto L6
    }

    public static TypedArray obtainStyledAttributes(Object r100, AttributeSet r101, int[] r102, String r103) {
        if ((r100 instanceof Context) == false) goto L11;
        int[] r104 = handleAttrBefore(r102);
        TypedArray r105 = ((Context) r100).obtainStyledAttributes(r101, r104);
        handleAttrAfter(r105, r104, r102);
        return r105;
    L11:
        return (TypedArray) MethodUtils.invokeMethod(r100, "obtainStyledAttributes", new Object[]{r101, r102});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static View inflate(LayoutInflater r100, XmlPullParser r101, ViewGroup r102, String r103) {
        if (r102 == null) goto L4;
        boolean r104 = true;
    L6:
        return inflate(r100, r101, r102, r104, r103);
    L4:
        r104 = false;
        goto L6
    }

    public static boolean bindService(Object r100, Intent r101, ServiceConnection r102, int r110, String r111) {
        if ((r100 instanceof Context) == true) goto L5;
        return ((Boolean) MethodUtils.invokeMethod(r100, "bindService", new Object[]{r101, r102, Integer.valueOf(r110)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ServiceManagerNative.getInstance().bindServiceNative((Context) r100, r101, r102, r110, r111);
    }

    public static int getIdentifier(Object r100, String r101, String r102, String r103, String r104) {
        if ((r100 instanceof Resources) == false) goto L15;
        Resources r105 = (Resources) r100;
        if (TextUtils.equals("android", r103) == true) goto L9;
        r103 = r104;
    L9:
        return r105.getIdentifier(r101, r102, r103);
    L15:
        return ((Integer) MethodUtils.invokeMethod(r100, "getIdentifier", new Object[]{r101, r102, r103})).intValue();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static View inflate(LayoutInflater r100, int r101, ViewGroup r102, boolean r103, String r104) {
        Context r105 = r100.getContext();
        if ((r105 instanceof PluginContext) == false) goto L5;
    L24:
        clearConstructorCache();
        View r106 = r100.inflate(r101, r102, r103);
        clearConstructorCache();
        return r106;
    L5:
        if ((r105 instanceof PluginActivityWrapper) == true) goto L24;
        if (isSupportLibIso(r104) == true) goto L11;
        if ((r105 instanceof PluginFragmentActivityWrapper) == true) goto L24;
    L11:
        if ((r105 instanceof PluginApplicationWrapper) == true) goto L24;
        Context r107 = wrapperContext(r105, r104);
        LayoutInflater.Factory r108 = r100.getFactory();
        LayoutInflater.Factory2 r109 = r100.getFactory2();
        LayoutInflater r110 = (LayoutInflater) r107.getSystemService("layout_inflater");
        if (isSupportLibIso(r104) == true) goto L15;
    L23:
        r100 = r110;
        goto L24
    L15:
        if (r108 != null) goto L28;
    L19:
        if (r109 == null) goto L23;
        FieldUtils.writeField(r110, "mFactory2", r109);     // Catch: Throwable -> L22
    L22:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory2 failed.");
        goto L23
    L28:
        FieldUtils.writeField(r110, "mFactory", r108);     // Catch: Throwable -> L18
    L18:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory failed.");
        goto L19
    }

    public static Intent registerReceiver(Object r100, PluginBroadcastReceiver r101, IntentFilter r102, int r103, String r104) {
        if ((r100 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
        return ComponentManager.registerReceiver((Context) r100, r101, r102, r103, r104);
    L11:
        return (Intent) MethodUtils.invokeMethod(r100, "registerReceiver", new Object[]{r101, r102, Integer.valueOf(r103)});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void startActivityForResult(Object r100, Intent r101, int r102, Bundle r103, String r104) {
        ComponentManager.startActivityForResult(r100, r101, r102, r103, r104);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if ((r100 instanceof Activity) == false) goto L13;
        ComponentManager.startActivityForResult((Activity) r100, r101, r102, r103, r104);
        return;
    L13:
        MethodUtils.invokeMethod(r100, "startActivityForResult", new Object[]{r101, Integer.valueOf(r102), r103}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw new RuntimeException(th);
    }

    public static View inflate(LayoutInflater r100, XmlPullParser r101, ViewGroup r102, boolean r103, String r104) {
        Context r105 = r100.getContext();
        if ((r105 instanceof PluginContext) == false) goto L5;
    L13:
        LayoutInflater r106 = (LayoutInflater) r105.getSystemService("layout_inflater");
        clearConstructorCache();
        View r107 = r106.inflate(r101, r102, r103);
        clearConstructorCache();
        return r107;
    L5:
        if ((r105 instanceof PluginActivityWrapper) == true) goto L13;
        if (isSupportLibIso(r104) == true) goto L11;
        if ((r105 instanceof PluginFragmentActivityWrapper) == true) goto L13;
    L11:
        if ((r105 instanceof PluginApplicationWrapper) == true) goto L13;
        r105 = wrapperContext(r105, r104);
        goto L13
    }

    public static TypedArray obtainStyledAttributes(Object r100, AttributeSet r101, int[] r102, int r103, int r104, String r105) {
        if ((r100 instanceof Context) == false) goto L7;
        int[] r106 = handleAttrBefore(r102);
        TypedArray r107 = ((Context) r100).obtainStyledAttributes(r101, r106);
        handleAttrAfter(r107, r106, r102);
        return r107;
    L7:
        if ((r100 instanceof Resources.Theme) == false) goto L15;
        int[] r108 = handleAttrBefore(r102);
        TypedArray r109 = ((Resources.Theme) r100).obtainStyledAttributes(r101, r108, r103, r104);
        handleAttrAfter(r109, r108, r102);
        return r109;
    L15:
        return (TypedArray) MethodUtils.invokeMethod(r100, "obtainStyledAttributes", new Object[]{r101, r102, Integer.valueOf(r103), Integer.valueOf(r104)});
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r100, PluginBroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, String r113) {
        if ((r100 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
        return ComponentManager.registerReceiver((Context) r100, r101, r110, r111, r112, r113);
    L11:
        return (Intent) MethodUtils.invokeMethod(r100, "registerReceiver", new Object[]{r101, r110, r111, r112});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Intent registerReceiver(Object r100, PluginBroadcastReceiver r110, IntentFilter r111, String r112, Handler r113, int r114, String r115) {
        if ((r100 instanceof Context) == false) goto L11;
        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
        return ComponentManager.registerReceiver((Context) r100, r110, r111, r112, r113, r114, r115);
    L11:
        return (Intent) MethodUtils.invokeMethod(r100, "registerReceiver", new Object[]{r110, r111, r112, r113, Integer.valueOf(r114)});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
