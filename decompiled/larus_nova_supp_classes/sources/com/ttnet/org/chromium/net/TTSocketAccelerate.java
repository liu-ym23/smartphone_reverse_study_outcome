package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("net")
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

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void checkSystemAvailable() {
        if (this.nativeDelegate != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains("honor") == true) goto L12;
        if (Build.BRAND.toLowerCase().contains("honor") == true) goto L12;
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
    public static Class INVOKESTATIC_com_ttnet_org_chromium_net_TTSocketAccelerate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
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
        return MiraPluginFix.forName(r3);
    }

    public void setNativeDelegate(long r1) {
        this.nativeDelegate = r1;
    }

    public void notifyAccelerate(int r9, int r10, int r11) {
        Method r1 = INVOKESTATIC_com_ttnet_org_chromium_net_TTSocketAccelerate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(sEmcomManagerExClass).getMethod(sNotifyAppInfoMethod, new Class[]{Bundle.class});     // Catch: Throwable -> L5
        Bundle r2 = new Bundle();     // Catch: Throwable -> L5
        r2.putInt("msgType", 49);     // Catch: Throwable -> L5
        r2.putInt("scene", 16);     // Catch: Throwable -> L5
        r2.putInt("subscene", r10);     // Catch: Throwable -> L5
        r2.putInt("status", 1);     // Catch: Throwable -> L5
        r2.putInt("accStatus", 3);     // Catch: Throwable -> L5
        r2.putString("KFD", XmlPullParser.NO_NAMESPACE + r11);     // Catch: Throwable -> L5
        r1.invoke(null, new Object[]{r2});     // Catch: Throwable -> L5
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r9, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r9, -1000);
    }
}
