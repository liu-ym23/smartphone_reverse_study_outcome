package com.larus.asr.session;

import com.bytedance.android.livesdk.message.model.vf;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SendMessageAsrSessionV2$createComponents$4 extends FunctionReferenceImpl implements Function1<Long, Long> {
    public SendMessageAsrSessionV2$createComponents$4(Object r100) {
        super(1, r100, SendMessageAsrSessionV2.class, "getEffectiveDurationForShortCheck", "getEffectiveDurationForShortCheck(J)J", 0);
    }

    public final Long invoke(long r110) {
        SendMessageAsrSessionV2 r100 = (SendMessageAsrSessionV2) this.receiver;
        int r101 = SendMessageAsrSessionV2.f287549q;
        r100.getClass();
        ObricAsrDelegate r102 = ObricAsrDelegate.f392831b;
        if (r102.m() == false) goto L29;
        if (r102.a() == false) goto L29;
        Long r103 = r100.f287551k;
        if (r103 == null) goto L29;
        boolean r104 = true;
        if (r103.longValue() <= 0) goto L12;
        boolean r105 = true;
    L13:
        Long r106 = null;
        if (r105 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L29;
        Long r107 = Long.valueOf(System.currentTimeMillis() - r103.longValue());
        long r108 = r107.longValue();
        if (1 <= r108) goto L21;
    L23:
        r104 = false;
    L24:
        if (r104 == false) goto L26;
        r106 = r107;
    L26:
        if (r106 == null) goto L29;
        r110 = Math.max(r110, r106.longValue());
        goto L29
    L21:
        if (r108 >= vf.CNY_A_2) goto L23;
    L12:
        r105 = false;
    L29:
        return Long.valueOf(r110);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Long r100) {
        return invoke(r100.longValue());
    }
}
