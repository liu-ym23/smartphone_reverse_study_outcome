package com.ss.android.lark.gadget.lifecycle.launch.entrance;

import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import el9.a;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import njb.b;

/* JADX INFO: loaded from: classes36.dex */
public class AppbrandSupport implements IAppbrandSupport {
    private static final String TAG = "AppbrandSupport";
    private IAppbrandSupport impl;
    private volatile boolean isInit;
    private volatile boolean isInitForMainSandbox;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public boolean isInit() {
        AppBrandLogger.i(TAG, new Object[]{"isinit  " + this.isInit});
        return this.isInit;
    }

    public boolean isInitForMainSandbox() {
        AppBrandLogger.i(TAG, new Object[]{"isInitForMainSandbox " + this.isInitForMainSandbox});
        return this.isInitForMainSandbox;
    }

    public void setIsInit() {
        AppBrandLogger.i(TAG, new Object[]{"setInit " + this.isInit});
        this.isInit = true;
    }

    public void setIsInitForMainSandbox() {
        AppBrandLogger.i(TAG, new Object[]{"setIsInitForMainSandbox " + this.isInitForMainSandbox});
        this.isInitForMainSandbox = true;
    }

    private IAppbrandSupport getImpl() {
        if (this.impl != null) goto L11;
        Object r100 = INVOKESTATIC_com_ss_android_lark_gadget_lifecycle_launch_entrance_AppbrandSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppbrandHostConstants.ImplClass.APPBRAND_SUPPORT_IMPL).newInstance();     // Catch: Throwable -> L8
        if ((r100 instanceof IAppbrandSupport) == false) goto L11;
        this.impl = (IAppbrandSupport) r100;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"init error: " + th.getMessage(), th});
    L11:
        return this.impl;
    }

    public static AppbrandSupport inst() {
        b r100 = b.a.f519472a;
        if (r100.f519469a != null) goto L13;
        monitor-enter(AppbrandSupport.class);
        r100.f519469a = new AppbrandSupport();     // Catch: Throwable -> L9
        monitor-exit(AppbrandSupport.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return r100.f519469a;
    }

    public boolean isAppbrandInit() {
        if (this.isInit == true) goto L5;
    L7:
        return false;
    L5:
        if (getImpl() == null) goto L7;
        return true;
    }

    public AppbrandSupport() {
        this.isInit = false;
        this.isInitForMainSandbox = false;
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public boolean isSDKSupport() {
        if (isAppbrandInit() == true) goto L5;
        return false;
    L5:
        return this.impl.isSDKSupport();
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public void preloadEmptyProcess() {
        if (isAppbrandInit() == false) goto L6;
        this.impl.preloadEmptyProcess();
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_gadget_lifecycle_launch_entrance_AppbrandSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public String getTmaJssdkVersion(IAppContext r100) {
        if (isAppbrandInit() == true) goto L5;
        return "-1";
    L5:
        return this.impl.getTmaJssdkVersion(r100);
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public boolean isSDKSupport(Context r100) {
        return isSDKSupport();
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public void openAppbrand(njb.a r100) {
        if (isAppbrandInit() == false) goto L7;
        this.impl.openAppbrand(r100);
        return;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public boolean openShortcut(Intent r100) {
        if (isAppbrandInit() == true) goto L5;
        return false;
    L5:
        return this.impl.openShortcut(r100);
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public void switchLang(Locale r100) {
        if (isAppbrandInit() == false) goto L6;
        this.impl.switchLang(r100);
        return;
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public String getTmaJssdkVersion(Context r100, IAppContext r101) {
        return getTmaJssdkVersion(r101);
    }

    @Override // com.ss.android.lark.gadget.lifecycle.launch.entrance.IAppbrandSupport
    public void openAppbrand(Context r100, njb.a r101) {
        if (isAppbrandInit() == false) goto L7;
        this.impl.openAppbrand(r100, r101);
        return;
    L7:
        throw null;
    }
}
