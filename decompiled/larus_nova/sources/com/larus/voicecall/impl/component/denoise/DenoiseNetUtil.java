package com.larus.voicecall.impl.component.denoise;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class DenoiseNetUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DenoiseNetUtil f377355a = null;

    static {
        f377355a = new DenoiseNetUtil();
    }

    public DenoiseNetUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(e0 r110, Continuation<? super f> r111) {
        if ((r111 instanceof DenoiseNetUtil$reportDenoiseStatus$1) == false) goto L7;
        DenoiseNetUtil$reportDenoiseStatus$1 r100 = (DenoiseNetUtil$reportDenoiseStatus$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DenoiseNetUtil$reportDenoiseStatus$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof com.larus.network.http.f) == false) goto L21;
        FLogger.f375446a.e("DenoiseNetUtil", "reportDenoiseStatus err=" + ((com.larus.network.http.f) r114).f360157d);
        return null;
    L21:
        return (f) r114.f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r110.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("denoise_status", r110.f377388a.getValue());
        r104.put("bot_id", r110.f377389b);
        r104.put("room_id", r110.f377390c);
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.AUDIO, f.class, "/alice/call/report_denoise_status", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new DenoiseNetUtil$reportDenoiseStatus$1(this, r111);
        goto L8
    }
}
