package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.audio.AudioControlAction;
import com.bytedance.android.shopping.commentv3.audio.StopReason;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AudioControlEvent extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final com.bytedance.android.shopping.commentv3.audio.c d;
    public final com.bytedance.android.shopping.commentv3.data.b e;

    public static final class a {
    }

    static {
    }

    public AudioControlEvent(com.bytedance.android.shopping.commentv3.data.b r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        super(ActionType.AUDIO_CONTROL.getType());
        this.e = r2;
        this.d = new com.bytedance.android.shopping.commentv3.audio.c();
    }

    public static final com.bytedance.kmp.ec.yata.chain.event.b d(AudioControlEvent r8, com.bytedance.android.shopping.commentv3.audio.d r9) {
        r8.getClass();
        if (r9.a == false) goto L5;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        StringBuilder r12 = new StringBuilder("AudioControl failed, error: ");
        r12.append(r9.b);
        r12.append(", message: ");
        String r3 = r9.c;
        String r4 = "Unknown audio control error";
        if (r3 != null) goto L8;
        r3 = "Unknown audio control error";
    L8:
        r12.append(r3);
        String r5 = r12.toString();
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("code", r9.b);
        String r13 = r9.c;
        if (r13 == null) goto L12;
        r4 = r13;
    L12:
        r6[1] = TuplesKt.to("message", r4);
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r5, null, MapsKt.mapOf(r6), 41);
    }

    public static com.bytedance.kmp.ec.yata.chain.event.b e(int r7, String r8) {
        int r0 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "AudioControl failed, error: " + r7 + ", message: " + r8, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r7)), TuplesKt.to("message", r8)}), 41);
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r11, fc3.a r12, fc3.c r13, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "eventContext");
        Intrinsics.checkNotNullParameter(r12, "actionContext");
        Intrinsics.checkNotNullParameter(r13, "handleActionParams");
        Intrinsics.checkNotNullParameter(r14, "completion");
        com.bytedance.android.shopping.commentv3.audio.c r15 = this.d;
        Map r16 = r11.k;
        r15.getClass();
        boolean r17 = false;
        if (r16 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r3 = null;
        if (r1 == true) goto L22;
        Object r2 = r16.get("action_type");
        if ((r2 instanceof Number) == false) goto L18;
        int r4 = ((Number) r2).intValue();
        if (r4 == 1) goto L20;
        if (r4 != 2) goto L18;
        AudioControlAction r5 = AudioControlAction.STOP;
    L21:
        if (r5 == null) goto L22;
        Object r6 = r16.get("audio_info");
        if ((r6 instanceof Map) == true) goto L26;
        r6 = null;
    L26:
        Map r7 = (Map) r6;
        if (r7 == null) goto L56;
        Map r8 = com.bytedance.android.shopping.commentv3.audio.c.a(r7);
        if (r8 == null) goto L56;
        LinkedHashMap r9 = (LinkedHashMap) r8;
        Object r10 = r9.get("vid");
        if (r10 == null) goto L41;
        String r18 = r10.toString();
        if (r18 == null) goto L41;
        if (r18.length() <= 0) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == false) goto L41;
    L42:
        Object r20 = r9.get("url");
        if (r20 == null) goto L56;
        String r21 = r20.toString();
        if (r21 == null) goto L56;
        if (r21.length() <= 0) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == true) goto L53;
        r21 = null;
    L53:
        if (r21 == null) goto L56;
        com.bytedance.android.shopping.commentv3.audio.e r23 = new com.bytedance.android.shopping.commentv3.audio.e(r18, r21, r8);
    L57:
        Object r24 = r16.get("slice_id");
        if (r24 == null) goto L66;
        String r25 = r24.toString();
        if (r25 == null) goto L66;
        if (r25.length() <= 0) goto L64;
        r17 = true;
    L64:
        if (r17 == false) goto L66;
    L67:
        Object r110 = r16.get("on_stop");
        if ((r110 instanceof Map) == true) goto L70;
        r110 = null;
    L70:
        Map r111 = (Map) r110;
        if (r111 == null) goto L76;
        Map r112 = com.bytedance.android.shopping.commentv3.audio.c.a(r111);
        if (r112 == null) goto L76;
        SlcCommonAction.Companion.getClass();
        SlcCommonAction r113 = SlcCommonAction.a.b(r112);
    L77:
        com.bytedance.android.shopping.commentv3.audio.b r114 = new com.bytedance.android.shopping.commentv3.audio.b(r5, r25, r23, r113);
    L78:
        if (r114 != null) goto L81;
        r14.invoke(e(-1001, "AudioControlEvent params is empty"));
        return;
    L81:
        com.bytedance.android.shopping.commentv3.audio.f r26 = this.e.c;
        if (r26 != null) goto L85;
        r14.invoke(e(-1005, "AudioPlaybackController is null"));
        return;
    L85:
        int r115 = com.bytedance.android.shopping.commentv3.event_chain.costom_event.a.a[r114.a.ordinal()];
        if (r115 == 1) goto L96;
        if (r115 != 2) goto L99;
        String r27 = r114.b;
        CommentSliceComponent r116 = r13.d;
        if (r116 == null) goto L92;
        r3 = r116.getSliceId();
    L92:
        if (r3 == null) goto L94;
        StopReason r117 = StopReason.COMPONENT_HIDE;
    L95:
        com.bytedance.android.shopping.commentv3.audio.f.a.a(r26, r27, r117, null, new AudioControlEvent$onHandle$2(this, r14), 4);
        return;
    L94:
        r117 = StopReason.USER_STOP;
        goto L95
    L99:
        return;
    L96:
        r26.a(r114, new AudioControlEvent$onHandle$1(this, r14));
        return;
    L76:
        r113 = null;
    L66:
        r25 = null;
        goto L67
    L49:
        r22 = false;
        goto L50
    L38:
        r19 = false;
    L41:
        r18 = null;
    L56:
        r23 = null;
        goto L57
    L20:
        r5 = AudioControlAction.PLAY;
    L18:
        r5 = null;
    L22:
        r114 = null;
        goto L78
    L5:
        if (r16.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
