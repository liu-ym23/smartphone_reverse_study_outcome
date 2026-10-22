package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrPrepareDecision;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qw5.a f243898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.p f243899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.j f243900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<FlowAsrFileAudioDataProvider> f243901d;

    @Override // com.bytedance.flow_audio.impl.business.asr.core.d0
    public final b0 snapshot() {
        gw5.i r100 = this.f243898a.f535002j;
        boolean r101 = false;
        if (r100 == null) goto L14;
        gw5.g r102 = r100.f483065f;
        if (r102 == null) goto L14;
        String r103 = r102.f483054a;
        if (r103 == null) goto L14;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
    L15:
        String r110 = r103;
        FlowAsrSessionState r105 = this.f243899b.a();
        FlowAsrSessionState r106 = this.f243899b.a();
        int[] r107 = com.bytedance.flow_audio.impl.business.asr.p.b.f244015a;
        int r108 = r107[r106.ordinal()];
        if (r108 == 1) goto L20;
        if (r108 == 2) goto L19;
        FlowAsrPrepareDecision r109 = FlowAsrPrepareDecision.IGNORE;
    L21:
        FlowAsrPrepareDecision r111 = r109;
        int r112 = r107[this.f243899b.a().ordinal()];
        if (r112 != 2) goto L24;
        com.bytedance.flow_audio.impl.business.asr.q r113 = new com.bytedance.flow_audio.impl.business.asr.q(true, false);
    L30:
        com.bytedance.flow_audio.impl.business.asr.q r114 = r113;
        FlowAsrSessionState r115 = this.f243899b.a();
        FlowAsrSessionState r116 = FlowAsrSessionState.RECORDING;
        if (r115 != r116) goto L33;
    L36:
        boolean r117 = true;
    L37:
        FlowAsrSessionState r118 = this.f243899b.a();
        if (r118 != r116) goto L40;
    L45:
        boolean r119 = true;
    L46:
        FlowAsrSessionState r120 = this.f243899b.a();
        if (r120 != r116) goto L49;
    L56:
        boolean r121 = true;
    L57:
        FlowAsrSessionState r122 = this.f243899b.a();
        FlowAsrSessionState r123 = FlowAsrSessionState.WAITING_ASR_COMPLETION;
        if (r122 != r123) goto L60;
        boolean r124 = true;
    L62:
        if (this.f243899b.a() != r123) goto L64;
        boolean r125 = true;
    L66:
        if (this.f243899b.a() != r116) goto L68;
        boolean r126 = true;
    L70:
        if (this.f243899b.a() != FlowAsrSessionState.PENDING_FAIL) goto L72;
        boolean r127 = true;
    L74:
        if (this.f243899b.a() != FlowAsrSessionState.RETRYING) goto L76;
        boolean r128 = true;
    L77:
        FlowAsrSessionState r129 = this.f243899b.a();
        if (r129 != FlowAsrSessionState.FINISHED) goto L80;
    L87:
        boolean r210 = true;
    L89:
        if (this.f243901d.invoke() == null) goto L100;
        if (r100 == null) goto L96;
        gw5.b r130 = r100.getContext();
        if (r130 == null) goto L96;
        if (r130.f483038f != 2) goto L96;
        boolean r131 = true;
    L97:
        if (r131 == false) goto L100;
        if (r110 == null) goto L100;
        r101 = true;
    L96:
        r131 = false;
    L100:
        boolean r132 = r117;
        boolean r133 = r119;
        boolean r134 = r121;
        boolean r135 = r124;
        boolean r136 = r125;
        boolean r137 = r126;
        boolean r138 = r127;
        boolean r139 = r128;
        boolean r140 = r210;
        boolean r141 = r101;
        return new b0(r105, r111, r114, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r110, this.f243900c.f243987a);
    L80:
        if (r129 == FlowAsrSessionState.FAILED) goto L87;
        if (r129 == FlowAsrSessionState.CANCELED) goto L87;
        if (r129 == FlowAsrSessionState.RELEASED) goto L87;
        r210 = false;
        goto L89
    L76:
        r128 = false;
        goto L77
    L72:
        r127 = false;
        goto L74
    L68:
        r126 = false;
        goto L70
    L64:
        r125 = false;
        goto L66
    L60:
        r124 = false;
        goto L62
    L49:
        if (r120 == FlowAsrSessionState.STOPPING) goto L56;
        if (r120 == FlowAsrSessionState.RETRYING) goto L56;
        if (r120 == FlowAsrSessionState.WAITING_ASR_COMPLETION) goto L56;
        r121 = false;
        goto L57
    L40:
        if (r118 == FlowAsrSessionState.PENDING_FAIL) goto L45;
        if (r118 == FlowAsrSessionState.RETRYING) goto L45;
        r119 = false;
        goto L46
    L33:
        if (r115 == FlowAsrSessionState.RETRYING) goto L36;
        r117 = false;
        goto L37
    L24:
        if (r112 != 3) goto L26;
    L28:
        r113 = new com.bytedance.flow_audio.impl.business.asr.q(true, true);
        goto L30
    L26:
        if (r112 == 4) goto L28;
        r113 = new com.bytedance.flow_audio.impl.business.asr.q(false, false);
        goto L30
    L19:
        r109 = FlowAsrPrepareDecision.ALREADY_PREPARED;
        goto L21
    L20:
        r109 = FlowAsrPrepareDecision.START_PREPARE;
        goto L21
    L11:
        r104 = false;
    L14:
        r103 = null;
        goto L15
    }

    public c0(qw5.a r100, com.bytedance.flow_audio.impl.business.asr.p r101, com.bytedance.flow_audio.impl.business.asr.j r102, s r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "stateMachine");
        Intrinsics.checkNotNullParameter(r102, "failureStore");
        Intrinsics.checkNotNullParameter(r103, "fileAudioDataProvider");
        this.f243898a = r100;
        this.f243899b = r101;
        this.f243900c = r102;
        this.f243901d = r103;
    }
}
