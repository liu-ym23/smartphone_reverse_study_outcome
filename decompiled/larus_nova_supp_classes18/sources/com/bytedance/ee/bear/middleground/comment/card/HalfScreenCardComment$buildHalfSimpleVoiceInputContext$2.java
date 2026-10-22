package com.bytedance.ee.bear.middleground.comment.card;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class HalfScreenCardComment$buildHalfSimpleVoiceInputContext$2 extends FunctionReferenceImpl implements Function0<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p> {
    public HalfScreenCardComment$buildHalfSimpleVoiceInputContext$2(Object r8) {
        super(0, r8, HalfScreenCardComment.class, "snapshotUnifiedVoiceComponentTarget", "snapshotUnifiedVoiceComponentTarget()Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceSimpleTarget;", 0);
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p invoke() {
        HalfScreenCardComment r0 = (HalfScreenCardComment) ((CallableReference) this).receiver;
        int r1 = HalfScreenCardComment.x1;
        r0.getClass();
        int r2 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.g;
        d r3 = r0.E;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L6:
        return com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.a.b(r3.f(Integer.valueOf(r0.n.getCurrentItem())));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m127invoke() {
        return invoke();
    }
}
