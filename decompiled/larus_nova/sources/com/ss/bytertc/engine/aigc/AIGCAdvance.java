package com.ss.bytertc.engine.aigc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bytertc.engine.NativeRTCRoomFunctions;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.utils.LogUtil;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class AIGCAdvance {
    protected static final String TAG = "AIGCAdvance";
    private static Method mGetNativeMethod;
    private static Method mSetHandlerAIGCMethod;

    public AIGCAdvance() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bytertc_engine_aigc_AIGCAdvance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static int clearAudioCache(RTCRoom r100) {
        long r101 = getNativeRoomHandle(r100);
        if (r101 != 0) goto L7;
        LogUtil.e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
        return -1;
    L7:
        return NativeRTCRoomFunctions.nativeClearAudioCache(r101);
    }

    private static long getNativeRoomHandle(RTCRoom r100) {
        if (mGetNativeMethod == null) goto L16;
    L9:
        Method r101 = mGetNativeMethod;
        if (r101 != null) goto L18;
        return 0;
    L18:
        return ((Long) r101.invoke(r100, new Object[0])).longValue();
    L14:
        LogUtil.e(TAG, "fail to invoke method getNativeHandle");
        return 0;
    L16:
        Class r102 = INVOKESTATIC_com_ss_bytertc_engine_aigc_AIGCAdvance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.bytertc.engine.RTCRoomImpl");     // Catch: Exception -> L8
        if (r102 == null) goto L9;
        mGetNativeMethod = r102.getMethod("getNativeHandle", new Class[0]);     // Catch: Exception -> L8
    L8:
        LogUtil.e(TAG, "fail to find method getNativeHandle");
        goto L9
    }

    public static int stopSession(RTCRoom r100) {
        long r101 = getNativeRoomHandle(r100);
        if (r101 != 0) goto L7;
        LogUtil.e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
        return -1;
    L7:
        return NativeRTCRoomFunctions.nativeStopSession(r101);
    }

    public static int enableAudioCache(RTCRoom r100, boolean r101) {
        long r102 = getNativeRoomHandle(r100);
        if (r102 != 0) goto L7;
        LogUtil.e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
        return -1;
    L7:
        return NativeRTCRoomFunctions.nativeEnableAudioCache(r102, r101);
    }

    public static int setRTCRoomEventHandlerAIGC(RTCRoom r100, IRTCRoomEventHandlerAIGC r101) {
        if (mSetHandlerAIGCMethod == null) goto L16;
    L9:
        Method r102 = mSetHandlerAIGCMethod;
        if (r102 != null) goto L18;
        return 0;
    L18:
        return ((Integer) r102.invoke(r100, new Object[]{r101})).intValue();
    L14:
        LogUtil.e(TAG, "fail to invoke method getNativeHandle");
        return 0;
    L16:
        Class r103 = INVOKESTATIC_com_ss_bytertc_engine_aigc_AIGCAdvance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.bytertc.engine.RTCRoomImpl");     // Catch: Exception -> L8
        if (r103 == null) goto L9;
        mSetHandlerAIGCMethod = r103.getMethod("setRTCRoomEventHandlerAIGC", new Class[]{IRTCRoomEventHandlerAIGC.class});     // Catch: Exception -> L8
    L8:
        LogUtil.e(TAG, "fail to find method getNativeHandle");
        goto L9
    }

    public static int startSession(RTCRoom r110, AIGCSessionConfig r111) {
        long r100 = getNativeRoomHandle(r110);
        if (r100 != 0) goto L6;
        LogUtil.e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
        return -1;
    L6:
        String r101 = r111.token;
        UserInfo r102 = r111.userInfo;
        RTCRoomConfig r103 = r111.roomConfig;
        String r104 = r111.type;
        String r105 = r111.action;
        JSONObject r112 = r111.message;
        if (r112 != null) goto L9;
        String r113 = "";
    L11:
        return NativeRTCRoomFunctions.nativeStartSession(r100, r101, r102, r103, r104, r105, r113, r111.timeout, r111.joinRoomNeedSdp, r111.fgConfig);
    L9:
        r113 = r112.toString();
        goto L11
    }
}
