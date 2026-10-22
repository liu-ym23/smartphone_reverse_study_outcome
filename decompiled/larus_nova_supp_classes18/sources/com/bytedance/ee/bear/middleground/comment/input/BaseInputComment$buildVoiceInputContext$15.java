package com.bytedance.ee.bear.middleground.comment.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BaseInputComment$buildVoiceInputContext$15 extends FunctionReferenceImpl implements Function1<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, Boolean> {
    public BaseInputComment$buildVoiceInputContext$15(Object r8) {
        super(1, r8, BaseInputComment.class, "isVoiceTargetValid", "isVoiceTargetValid(Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceSimpleTarget;)Z", 0);
    }

    public final Boolean invoke(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        BaseInputComment r0 = (BaseInputComment) ((CallableReference) this).receiver;
        int r1 = BaseInputComment.g0;
        if (r0.isShowing() == false) goto L7;
        int r2 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.g;
        if (Intrinsics.areEqual(r3, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.a.a(r0.j)) == false) goto L7;
        boolean r4 = true;
    L9:
        return Boolean.valueOf(r4);
    L7:
        r4 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p) r1);
    }
}
