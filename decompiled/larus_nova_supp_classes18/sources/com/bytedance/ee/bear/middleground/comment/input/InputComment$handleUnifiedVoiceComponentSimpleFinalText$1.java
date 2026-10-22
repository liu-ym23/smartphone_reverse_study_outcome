package com.bytedance.ee.bear.middleground.comment.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InputComment$handleUnifiedVoiceComponentSimpleFinalText$1 extends FunctionReferenceImpl implements Function1<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, Boolean> {
    public InputComment$handleUnifiedVoiceComponentSimpleFinalText$1(Object r8) {
        super(1, r8, InputComment.class, "isVoiceTargetValid", "isVoiceTargetValid(Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceSimpleTarget;)Z", 0);
    }

    public final Boolean invoke(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return Boolean.valueOf(InputComment.x((InputComment) ((CallableReference) this).receiver, r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p) r1);
    }
}
