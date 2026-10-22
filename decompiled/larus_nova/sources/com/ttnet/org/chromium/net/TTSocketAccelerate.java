package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class TTSocketAccelerate {
    private static final int ACCELERATE_ERROR_CALLBACK_EXCEPTION = -1001;
    private static final int ACCELERATE_ERROR_RESULT_CODE_ERROR = -1002;
    private static final int ACCELERATE_ERROR_TIMEOUT = -1003;
    private static final int ACCELERATE_NOTIFY_EXCEPTION = -1000;
    private static final int ACCELERATE_NOTIFY_SUCC = 0;
    private static final int ACC_DEFAULT = 3;
    private static final int MSG_TYPE_ACC_INFO = 16;
    private static final int MSG_TYPE_SCENE_INFO = 1;
    private static final int MSG_TYPE_SUB_SCENE_INFO = 32;
    private static final int REGIST_ANDROID_VERSION_ERROR = -1003;
    private static final int REGIST_BRAND_ERROR = -1002;
    private static final int REGIST_EXCEPTION = -1001;
    private static final int REGIST_SUCC = 0;
    private static final int REGIST_UNKNOWN = -1000;
    private static final int SCENE_SHORT_VIDEO = 16;
    private static final int STATUS_SCENE_ENTER = 1;
    private static final int SUB_SCENE_HTTP_DNS = 1;
    private static final String TAG = "TTSocketAccelerate";
    private static final String sEmcomManagerExClass = "com.hihonor.android.emcom.EmcomManagerEx";
    private static final String sNotifyAppInfoMethod = "notifyAppInfo";
    private long nativeDelegate;

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnCheckSystemAvailableResult(long r100, TTSocketAccelerate r101, int r102);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnNotifyAccelerateResult(long r100, TTSocketAccelerate r101, int r102, int r103);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void checkSystemAvailable() {
        if (this.nativeDelegate != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains(RomUtils.BRAND_HONOR) == true) goto L12;
        if (Build.BRAND.toLowerCase().contains(RomUtils.BRAND_HONOR) == true) goto L12;
        TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, -1002);
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L15;
        TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, -1003);
        return;
    L15:
        TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, 0);
    }

    public TTSocketAccelerate() {
        this.nativeDelegate = 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_net_TTSocketAccelerate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public void setNativeDelegate(long r100) {
        this.nativeDelegate = r100;
    }

    public void notifyAccelerate(int r100, int r110, int r111) {
        Method r101 = INVOKESTATIC_com_ttnet_org_chromium_net_TTSocketAccelerate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(sEmcomManagerExClass).getMethod(sNotifyAppInfoMethod, new Class[]{Bundle.class});     // Catch: Throwable -> L5
        Bundle r102 = new Bundle();     // Catch: Throwable -> L5
        r102.putInt("msgType", 49);     // Catch: Throwable -> L5
        r102.putInt("scene", 16);     // Catch: Throwable -> L5
        r102.putInt("subscene", r110);     // Catch: Throwable -> L5
        r102.putInt("status", 1);     // Catch: Throwable -> L5
        r102.putInt("accStatus", 3);     // Catch: Throwable -> L5
        r102.putString("KFD", "" + r111);     // Catch: Throwable -> L5
        r101.invoke(null, new Object[]{r102});     // Catch: Throwable -> L5
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r100, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r100, -1000);
    }
}
