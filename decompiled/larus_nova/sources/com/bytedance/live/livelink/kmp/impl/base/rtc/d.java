package com.bytedance.live.livelink.kmp.impl.base.rtc;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static final void b(final ei6.a r100, HashMap r110) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r110, "config");
        Object r101 = r110.get(PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L23;
        Context r102 = (Context) r101;
        Object r103 = r110.get("rtcExtInfo");
        if (r103 == null) goto L21;
        JSONObject r104 = ((JSONObject) r103).optJSONObject("live_rtc_engine_config");
        if (r104 == null) goto L9;
        String r105 = r104.optString("rtc_app_id");
    L10:
        String r106 = String.valueOf(r105);
        Object r107 = r110.get("eglContext");
        if (r107 == null) goto L19;
        Object r111 = r110.get("parameters");
        if (r111 == null) goto L15;
        h.c r108 = new h.c();
        Intrinsics.checkNotNullParameter(new CommonRTCEngineManager_live_link_kmp_implKt$getEngineWrapper$1(r100), "eventHandler");
        h.b r109 = new h.b();
        Intrinsics.checkNotNullParameter(new CommonRTCEngineManager_live_link_kmp_implKt$getEngineWrapper$2(r100), "handler");
        Intrinsics.checkNotNullParameter(new CommonRTCEngineManager_live_link_kmp_implKt$getEngineWrapper$3(r100), "eventHandler");
        new h(r102, r106, r108, r109, r107, (JSONObject) r111);
        throw null;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L9:
        r105 = null;
        goto L10
    L21:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }
}
