package com.relax;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.relax.uirender.UIRenderRegistry;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxEnv {
    public static final String SP_NAME = "relax_env_config";
    private static final String TAG = "RelaxEnv";
    private Context mContext;
    private HashMap<String, String> mHotReloadPages;
    private boolean mIsDebugServiceAvailable;
    private boolean mRelaxDebugEnabled;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RelaxEnv f404556a = null;

        static {
            f404556a = new RelaxEnv();
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private native int nativeGetRenderType();

    private native void nativeSetEnableNewAnimator(boolean r100);

    private native void nativeSetRenderType(int r100);

    public void setRuntimeType(RuntimeType r100) {
    }

    private void initDebugService() {
        if (this.mIsDebugServiceAvailable == false) goto L17;
        return;
    L17:
        Class r100 = INVOKESTATIC_com_relax_RelaxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.relaxdevtool.RelaxDevToolEnv");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14
        Object r101 = r100.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14
        r100.getDeclaredMethod("init", new Class[]{Context.class}).invoke(r101, new Object[]{this.mContext});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14
        this.mIsDebugServiceAvailable = true;     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14
        return;
    L12:
        e = move-exception;
        this.mIsDebugServiceAvailable = false;
        e.toString();
    }

    public boolean isDevMenuEnabled() {
        return getDevToolEnv(RelaxEnvKey.ENABLE_DEV_MENU.getDesc(), Boolean.TRUE).booleanValue();
    }

    public boolean isDevToolEnabled() {
        return getDevToolEnv(RelaxEnvKey.ENABLE_DEVTOOL.getDesc(), Boolean.FALSE).booleanValue();
    }

    public boolean isRelaxDebugEnabled() {
        if (this.mIsDebugServiceAvailable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mRelaxDebugEnabled == false) goto L7;
        return true;
    }

    public RelaxEnv() {
        this.mRelaxDebugEnabled = true;
        this.mIsDebugServiceAvailable = false;
        this.mHotReloadPages = null;
    }

    public UIRenderRegistry.RenderType renderType() {
        return UIRenderRegistry.RenderType.values()[nativeGetRenderType()];
    }

    public static RelaxEnv inst() {
        return a.f404556a;
    }

    public HashMap<String, String> hotReloadPages() {
        return this.mHotReloadPages;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_relax_RelaxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public void enableDevMenu(boolean r100) {
        setDevToolEnv(RelaxEnvKey.ENABLE_DEV_MENU.getDesc(), Boolean.valueOf(r100));
    }

    public void enableDevTool(boolean r100) {
        setDevToolEnv(RelaxEnvKey.ENABLE_DEVTOOL.getDesc(), Boolean.valueOf(r100));
    }

    public synchronized void init(Application r100) {
        monitor-enter(this);
        this.mContext = r100;     // Catch: Throwable -> L6
        initDebugService();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setEnableNewAnimator(boolean r100) {
        nativeSetEnableNewAnimator(r100);
    }

    public void setHotReloadPages(HashMap<String, String> r100) {
        this.mHotReloadPages = r100;
    }

    public void setRenderType(UIRenderRegistry.RenderType r100) {
        nativeSetRenderType(r100.ordinal());
    }

    public Boolean getDevToolEnv(String r100, Boolean r101) {
        if (hpa.d.f486489a != null) goto L6;
        hpa.d.b();
    L6:
        return hpa.d.f486489a.b();
    }

    public void setDevToolEnv(String r100, Boolean r101) {
        if (hpa.d.f486489a != null) goto L5;
        hpa.d.b();
    L5:
        hpa.d.f486489a.a();
    }
}
