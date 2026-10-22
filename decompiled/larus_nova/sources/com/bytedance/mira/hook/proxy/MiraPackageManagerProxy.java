package com.bytedance.mira.hook.proxy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class MiraPackageManagerProxy extends AbsObjectProxy {
    private static final String TAG = "MiraPackageManagerProxy";
    public static Object pmProxy;

    /* JADX INFO: renamed from: com.bytedance.mira.hook.proxy.MiraPackageManagerProxy$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class GetApplicationInfo extends AbsMethodDelegate {
        private GetApplicationInfo() {
        }

        public /* synthetic */ GetApplicationInfo(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r102 == null) goto L35;
            int r104 = 0;
            if (r102.length <= 0) goto L8;
            Object r105 = r102[0];
            if ((r105 instanceof String) == false) goto L8;
            String r106 = (String) r105;
        L10:
            if (r102.length <= 1) goto L15;
            Object r107 = r102[1];
            if ((r107 instanceof Number) == false) goto L15;
            r104 = ((Number) r107).intValue();
        L15:
            if ((16777216 & r104) != 0) goto L35;
            MiraLogger.i(MiraLogger.TAG_PPM, ("MiraPackageManagerProxy >> " + r101.getName() + ", ") + "packageName = " + r106 + ", flags = " + r104);
            if (TextUtils.equals(r106, Mira.getAppContext().getPackageName()) == false) goto L31;
            if ((r104 & 128) == 0) goto L35;
            ApplicationInfo r108 = PluginPackageManager.getApplicationInfo(r106, r104);
            if (r108 == null) goto L35;
            Bundle r109 = r108.metaData;
            if (r109 == null) goto L35;
            if (r109.size() <= 0) goto L35;
            ApplicationInfo r110 = (ApplicationInfo) r103;
            if (r110.metaData != null) goto L29;
            r110.metaData = new Bundle();
        L29:
            r110.metaData.putAll(r108.metaData);
            goto L35
        L31:
            if (PluginPackageManager.isPluginPackage(r106) == false) goto L35;
            return PluginPackageManager.getApplicationInfo(r106, r104);
        L8:
            r106 = null;
        L35:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static class GetComponentInfo extends AbsMethodDelegate {
        private static final int FLAG_ACTIVITY = 1;
        private static final int FLAG_PROVIDER = 4;
        private static final int FLAG_RECEIVER = 3;
        private static final int FLAG_SERVICE = 2;
        private int mFlag;

        private GetComponentInfo(int r100) {
            this.mFlag = r100;
        }

        public /* synthetic */ GetComponentInfo(int r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r103 != null) goto L35;
            if (r102 == null) goto L35;
            int r104 = 0;
            if (r102.length <= 0) goto L9;
            Object r105 = r102[0];
            if ((r105 instanceof ComponentName) == false) goto L9;
            ComponentName r106 = (ComponentName) r105;
        L11:
            if (r102.length <= 1) goto L15;
            Object r107 = r102[1];
            if ((r107 instanceof Number) == false) goto L15;
            r104 = ((Number) r107).intValue();
        L15:
            if (r106 == null) goto L35;
            if ((16777216 & r104) != 0) goto L35;
            MiraLogger.i(MiraLogger.TAG_PPM, ("MiraPackageManagerProxy >> " + r101.getName() + ", ") + "componentName = " + r106 + ", flag = " + r104);
            int r108 = this.mFlag;
            if (r108 != 1) goto L23;
            return PluginPackageManager.getActivityInfo(r106, r104);
        L23:
            if (r108 != 2) goto L27;
            return PluginPackageManager.getServiceInfo(r106, r104);
        L27:
            if (r108 != 3) goto L31;
            return PluginPackageManager.getReceiverInfo(r106, r104);
        L31:
            if (r108 != 4) goto L35;
            return PluginPackageManager.getProviderInfo(r106, r104);
        L9:
            r106 = null;
        L35:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static class GetInstallerPackageName extends AbsMethodDelegate {
        private GetInstallerPackageName() {
        }

        public /* synthetic */ GetInstallerPackageName(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r101, Object[] r102) {
            if (r102 == null) goto L11;
            if (r102.length <= 0) goto L11;
            if ((r102[0] instanceof String) == false) goto L11;
            String r103 = Mira.getAppContext().getPackageName();
            String r104 = (String) r102[0];
            if (PluginPackageManager.isPluginPackage(r104) == false) goto L11;
            r102[0] = r103;
            MiraLogger.w(MiraLogger.TAG_PPM, "MiraPackageManagerProxy << " + r101.getName() + ", " + String.format(" replace pluginPkgName[%s] >>> hostPkgName[%s]", new Object[]{r104, r103}));
        L11:
            return super.beforeInvoke(r100, r101, r102);
        }
    }

    public static class GetPackageInfo extends AbsMethodDelegate {
        private GetPackageInfo() {
        }

        public /* synthetic */ GetPackageInfo(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r103 != null) goto L21;
            if (r102 == null) goto L21;
            int r104 = 0;
            if (r102.length <= 0) goto L9;
            Object r105 = r102[0];
            if ((r105 instanceof String) == false) goto L9;
            String r106 = (String) r105;
        L11:
            if (r102.length <= 1) goto L15;
            Object r107 = r102[1];
            if ((r107 instanceof Number) == false) goto L15;
            r104 = ((Number) r107).intValue();
        L15:
            if (r106 == null) goto L21;
            if ((16777216 & r104) != 0) goto L21;
            return PluginPackageManager.getPackageInfo(r106, r104);
        L9:
            r106 = null;
        L21:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static class QueryIntentComponents extends AbsMethodDelegate {
        private static final int QUERY_INTENT_ACTIVITIES = 1;
        private static final int QUERY_INTENT_SERVICES = 2;
        private int mFlag;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private QueryIntentComponents(int r100) {
            this.mFlag = r100;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraPackageManagerProxy$QueryIntentComponents_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

        public /* synthetic */ QueryIntentComponents(int r100, AnonymousClass1 r101) {
            this(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object] */
        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r110) {
            if (MiraPackageManagerProxy.access$700(r110) == false) goto L42;
            if (r102 == null) goto L42;
            if (r102.length <= 0) goto L10;
            Object r103 = r102[0];
            if ((r103 instanceof Intent) == false) goto L10;
            Intent r104 = (Intent) r103;
        L12:
            if (r102.length <= 2) goto L16;
            Object r105 = r102[2];
            if ((r105 instanceof Number) == false) goto L16;
            int r106 = ((Number) r105).intValue();
        L17:
            if (r104 == null) goto L42;
            if ((16777216 & r106) != 0) goto L42;
            String r107 = "MiraPackageManagerProxy >> " + r101.getName() + ", ";
            MiraLogger.i(MiraLogger.TAG_PPM, r107 + "intent = " + r104 + ", flag = " + r106);
            int r108 = this.mFlag;
            if (r108 != 1) goto L23;
            List<ResolveInfo> r109 = PluginPackageManager.queryIntentActivities(r104, r106);
        L43:
            Class<?> r111 = INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraPackageManagerProxy$QueryIntentComponents_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.pm.ParceledListSlice");     // Catch: Exception -> L38
            if (r101.getReturnType() != r111) goto L29;
            boolean r112 = true;
        L30:
            if (r112 == true) goto L44;
        L40:
            return r109;
        L44:
            Constructor<?> r113 = r111.getDeclaredConstructor(new Class[]{List.class});     // Catch: Exception -> L35
            MiraLogger.i(MiraLogger.TAG_PPM, r107 + "new ParceledListSlice(List)");     // Catch: Exception -> L35
            if (r113 == null) goto L37;
            r113.setAccessible(true);     // Catch: Exception -> L35
            r107 = r113.newInstance(new Object[]{r109});     // Catch: Exception -> L35
            return r107;
        L37:
            return null;
        L35:
            e = move-exception;
            MiraLogger.e(MiraLogger.TAG_PPM, r107 + "new android.content.pm.ParceledListSlice(List) failed.", e);     // Catch: Exception -> L38
            goto L37
        L29:
            r112 = false;
        L38:
            e = move-exception;
            MiraLogger.e(MiraLogger.TAG_PPM, r107 + "get returnParceledListSlice failed.", e);
            goto L40
        L23:
            if (r108 != 2) goto L25;
            r109 = PluginPackageManager.queryIntentServices(r104, r106);
            goto L43
        L25:
            r109 = null;
        L16:
            r106 = 0;
        L10:
            r104 = null;
        L42:
            return super.afterInvoke(r100, r101, r102, r110);
        }
    }

    public static class ResolveContentProvider extends AbsMethodDelegate {
        private ResolveContentProvider() {
        }

        public /* synthetic */ ResolveContentProvider(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r103 != null) goto L21;
            if (r102 == null) goto L21;
            if (r102.length <= 0) goto L9;
            Object r104 = r102[0];
            if ((r104 instanceof String) == false) goto L9;
            String r105 = (String) r104;
        L10:
            Integer r106 = 0;
            if (r102.length <= 1) goto L15;
            Object r107 = r102[1];
            if ((r107 instanceof Number) == false) goto L15;
            r106 = Integer.valueOf(((Number) r107).intValue());
        L15:
            if (r105 == null) goto L21;
            if ((r106.intValue() & 16777216) != 0) goto L21;
            MiraLogger.i(MiraLogger.TAG_PPM, ("MiraPackageManagerProxy >> " + r101.getName() + ", ") + "name = " + r105 + ", flags = " + r106);
            return PluginPackageManager.resolveContentProvider(r105, r106.intValue());
        L9:
            r105 = null;
        L21:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static class ResolveIntent extends AbsMethodDelegate {
        private static final int FLAG_RESOLVE_INTENT = 1;
        private static final int FLAG_RESOLVE_SERVICE = 2;
        private int mFlag;

        private ResolveIntent(int r100) {
            this.mFlag = r100;
        }

        public /* synthetic */ ResolveIntent(int r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r103 != null) goto L26;
            if (r102 == null) goto L26;
            if (r102.length <= 0) goto L9;
            Object r104 = r102[0];
            if ((r104 instanceof Intent) == false) goto L9;
            Intent r105 = (Intent) r104;
        L10:
            Integer r106 = 0;
            if (r102.length <= 2) goto L15;
            Object r107 = r102[2];
            if ((r107 instanceof Number) == false) goto L15;
            r106 = Integer.valueOf(((Number) r107).intValue());
        L15:
            if (r105 == null) goto L26;
            if ((r106.intValue() & 16777216) != 0) goto L26;
            MiraLogger.i(MiraLogger.TAG_PPM, ("MiraPackageManagerProxy >> " + r101.getName() + ", ") + "intent = " + r105 + ", flags = " + r106);
            int r108 = this.mFlag;
            if (r108 == 1) goto L21;
            if (r108 != 2) goto L26;
            return PluginPackageManager.resolveService(r105, r106.intValue());
        L21:
            return PluginPackageManager.resolveIntent(r105, r106.intValue());
        L9:
            r105 = null;
        L26:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        AnonymousClass1 r100 = null;
        AbsObjectProxy.sDelegateMethods.put("getPackageInfo", new GetPackageInfo(r100));
        AbsObjectProxy.sDelegateMethods.put("getApplicationInfo", new GetApplicationInfo(r100));
        int r101 = 1;
        AbsObjectProxy.sDelegateMethods.put("getActivityInfo", new GetComponentInfo(r101, r100));
        int r102 = 2;
        AbsObjectProxy.sDelegateMethods.put("getServiceInfo", new GetComponentInfo(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("getReceiverInfo", new GetComponentInfo(3, r100));
        AbsObjectProxy.sDelegateMethods.put("getProviderInfo", new GetComponentInfo(4, r100));
        AbsObjectProxy.sDelegateMethods.put("queryIntentActivities", new QueryIntentComponents(r101, r100));
        AbsObjectProxy.sDelegateMethods.put("queryIntentServices", new QueryIntentComponents(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("resolveIntent", new ResolveIntent(r101, r100));
        AbsObjectProxy.sDelegateMethods.put("resolveService", new ResolveIntent(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("resolveContentProvider", new ResolveContentProvider(r100));
        AbsObjectProxy.sDelegateMethods.put("getInstallerPackageName", new GetInstallerPackageName(r100));
    }

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
        Object r100 = ActivityThreadHelper.currentActivityThread();     // Catch: Exception -> L7
        Object r101 = FieldUtils.readField(r100, "sPackageManager");     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        setTarget(r101);     // Catch: Exception -> L7
        Object r102 = ProxyHelper.createProxy(r101, this);     // Catch: Exception -> L7
        pmProxy = r102;     // Catch: Exception -> L7
        FieldUtils.writeField(r100, "sPackageManager", r102);     // Catch: Exception -> L7
        FieldUtils.writeField(Mira.getAppContext().getPackageManager(), "mPM", pmProxy);     // Catch: Exception -> L7
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraPackageManagerProxy.hook");     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraPackageManagerProxy hook failed.", e);
    }

    public MiraPackageManagerProxy() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraPackageManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ boolean access$700(Object r100) {
        return isEmptyResult(r100);
    }

    private static boolean isEmptyResult(Object r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof Collection) == false) goto L24;
        return ((Collection) r100).isEmpty();
    L24:
        Class<?> r101 = INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraPackageManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.pm.ParceledListSlice");     // Catch: Exception -> L21
        if (r100.getClass() != r101) goto L23;
        Method r102 = MethodUtils.getAccessibleMethod(r101, "getList", new Class[0]);     // Catch: Exception -> L21
        if (r102 == null) goto L23;
        List r103 = (List) r102.invoke(r100, new Object[0]);     // Catch: Exception -> L21
        if (r103 == null) goto L26;
        if (r103.isEmpty() == true) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    L23:
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    @Override // com.bytedance.mira.hook.proxy.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(r100, r101, r102);
    }
}
