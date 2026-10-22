package com.bytedance.mira.hook.proxy;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class MiraBinderProxy extends AbsObjectProxy {
    private static final String TAG = "MiraBinderProxy";
    protected HashMap<String, AbsMethodDelegate> mDelegateMethods;
    private String mServiceName;

    /* JADX INFO: renamed from: com.bytedance.mira.hook.proxy.MiraBinderProxy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class QueryLocalInterface extends AbsMethodDelegate {
        private AbsObjectProxy mProxy;

        private QueryLocalInterface(AbsObjectProxy r100) {
            this.mProxy = r100;
        }

        public /* synthetic */ QueryLocalInterface(AbsObjectProxy r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r101, Object[] r102) {
            return super.beforeInvoke(r100, r101, r102);
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            return ProxyHelper.createProxy(this.mProxy.getTarget(), this.mProxy);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
        Class r100 = INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraBinderProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager");     // Catch: Exception -> L11
        Object r101 = MethodUtils.invokeStaticMethod(r100, "getService", new Object[]{this.mServiceName});     // Catch: Exception -> L11
        if (r101 == null) goto L16;
        Object r102 = FieldUtils.readStaticField(r100, "sCache");     // Catch: Exception -> L11
        if (r102 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof Map) == false) goto L18;
        setTarget(r101);     // Catch: Exception -> L11
        ((Map) r102).put(this.mServiceName, ProxyHelper.createProxy(r101, this));     // Catch: Exception -> L11
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraBinderProxy.hook");     // Catch: Exception -> L11
        return;
    L18:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraBinderProxy hook failed.", e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraBinderProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.bytedance.mira.hook.proxy.AbsObjectProxy
    public AbsMethodDelegate findMethodDelegate(String r100) {
        AbsMethodDelegate r101 = super.findMethodDelegate(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.mDelegateMethods.get(r100);
    }

    public MiraBinderProxy(String r100, AbsObjectProxy r101) {
        HashMap<String, AbsMethodDelegate> r102 = new HashMap();
        this.mDelegateMethods = r102;
        this.mServiceName = r100;
        r102.put("queryLocalInterface", new QueryLocalInterface(r101, null));
    }
}
