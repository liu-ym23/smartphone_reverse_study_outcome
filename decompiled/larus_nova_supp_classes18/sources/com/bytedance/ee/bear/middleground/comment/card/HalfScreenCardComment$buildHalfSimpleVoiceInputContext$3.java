package com.bytedance.ee.bear.middleground.comment.card;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class HalfScreenCardComment$buildHalfSimpleVoiceInputContext$3 extends FunctionReferenceImpl implements Function1<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, Boolean> {
    public HalfScreenCardComment$buildHalfSimpleVoiceInputContext$3(Object r8) {
        super(1, r8, HalfScreenCardComment.class, "isUnifiedVoiceComponentTargetValid", "isUnifiedVoiceComponentTargetValid(Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceSimpleTarget;)Z", 0);
    }

    public final Boolean invoke(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        d r0 = ((HalfScreenCardComment) ((CallableReference) this).receiver).E;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L6:
        if (r0.i(r2.a) == (-1)) goto L8;
        boolean r3 = true;
    L10:
        return Boolean.valueOf(r3);
    L8:
        r3 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p) r1);
    }
}
