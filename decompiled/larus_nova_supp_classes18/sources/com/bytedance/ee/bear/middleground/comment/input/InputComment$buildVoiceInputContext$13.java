package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceFinalDispatcherKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InputComment$buildVoiceInputContext$13 extends FunctionReferenceImpl implements Function2<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, CharSequence, Unit> {
    public InputComment$buildVoiceInputContext$13(Object r8) {
        super(2, r8, InputComment.class, "handleUnifiedVoiceComponentSimpleFinalText", "handleUnifiedVoiceComponentSimpleFinalText(Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceSimpleTarget;Ljava/lang/CharSequence;)V", 0);
    }

    public final void invoke(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r6, "p1");
        final InputComment r0 = (InputComment) ((CallableReference) this).receiver;
        int r1 = InputComment.x0;
        r0.getClass();
        CommentVoiceFinalDispatcherKt.a(r5, r6, new InputComment$handleUnifiedVoiceComponentSimpleFinalText$1(r0), new InputComment$handleUnifiedVoiceComponentSimpleFinalText$2(r0), new InputComment$handleUnifiedVoiceComponentSimpleFinalText$3(r0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p) r1, (CharSequence) r2);
        return Unit.INSTANCE;
    }
}
