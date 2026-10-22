package com.ss.videoarch.strategy.strategy.liveio;

import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class SocketAccStrategyBridge {
    private static Method honorNotifyMethod;
    private final Integer ACC_ENTER;
    private final Integer ACC_EXIT;
    private final Integer ACC_UPDATE;
    private final String KEY_ACC_STATUS;
    private final String KEY_APP_MSG_TYPE;
    private final String KEY_KFD;
    private final String KEY_SCENE;
    private final Integer MSG_TYPE_ACC_INFO;
    private final Integer MSG_TYPE_SCENE_INFO;
    private final Integer MSG_TYPE_SUB_SCENE_INFO;
    private final String TAG;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public SocketAccStrategyBridge() {
        this.TAG = "HonorStrategyBridge";
        this.MSG_TYPE_SUB_SCENE_INFO = 32;
        this.MSG_TYPE_ACC_INFO = 16;
        this.MSG_TYPE_SCENE_INFO = 1;
        this.KEY_APP_MSG_TYPE = "msgType";
        this.KEY_SCENE = "scene";
        this.KEY_ACC_STATUS = "accStatus";
        this.KEY_KFD = "KFD";
        this.ACC_ENTER = 1;
        this.ACC_EXIT = 0;
        this.ACC_UPDATE = 2;
        Method r100 = INVOKESTATIC_com_ss_videoarch_strategy_strategy_liveio_SocketAccStrategyBridge_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.hihonor.android.emcom.EmcomManagerEx").getMethod("notifyAppInfo", new Class[]{Bundle.class});     // Catch: Throwable -> L5
        honorNotifyMethod = r100;     // Catch: Throwable -> L5
        r100.setAccessible(true);     // Catch: Throwable -> L5
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_strategy_strategy_liveio_SocketAccStrategyBridge_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public int startAccSocket(String r100) {
        Method r101 = honorNotifyMethod;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r101.isAccessible() == false) goto L17;
        Bundle r102 = new Bundle();
        r102.putInt("msgType", this.MSG_TYPE_ACC_INFO.intValue() + this.MSG_TYPE_SCENE_INFO.intValue());
        r102.putInt("scene", this.MSG_TYPE_SUB_SCENE_INFO.intValue());
        r102.putInt("accStatus", this.ACC_ENTER.intValue());
        r102.putString("KFD", r100);
        honorNotifyMethod.invoke(null, new Object[]{r102});     // Catch: Exception -> L10
    L12:
        return 0;
    L10:
        e = move-exception;
        e.getMessage();
        goto L12
    L17:
        return -1;
    }

    public int stopAccSocket(String r100) {
        Method r101 = honorNotifyMethod;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r101.isAccessible() == false) goto L17;
        Bundle r102 = new Bundle();
        r102.putInt("msgType", this.MSG_TYPE_ACC_INFO.intValue() + this.MSG_TYPE_SCENE_INFO.intValue());
        r102.putInt("scene", this.MSG_TYPE_SUB_SCENE_INFO.intValue());
        r102.putInt("accStatus", this.ACC_EXIT.intValue());
        r102.putString("KFD", r100);
        honorNotifyMethod.invoke(null, new Object[]{r102});     // Catch: Exception -> L10
        return 0;
    L10:
        e = move-exception;
        e.getMessage();
        return -2;
    L17:
        return -1;
    }

    public int updateAccSocket(String r100) {
        Method r101 = honorNotifyMethod;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r101.isAccessible() == false) goto L17;
        Bundle r102 = new Bundle();
        r102.putInt("msgType", this.MSG_TYPE_ACC_INFO.intValue() + this.MSG_TYPE_SCENE_INFO.intValue());
        r102.putInt("scene", this.MSG_TYPE_SUB_SCENE_INFO.intValue());
        r102.putInt("accStatus", this.ACC_UPDATE.intValue());
        r102.putString("KFD", r100);
        honorNotifyMethod.invoke(null, new Object[]{r102});     // Catch: Exception -> L10
        return 0;
    L10:
        e = move-exception;
        e.getMessage();
        return -2;
    L17:
        return -1;
    }
}
