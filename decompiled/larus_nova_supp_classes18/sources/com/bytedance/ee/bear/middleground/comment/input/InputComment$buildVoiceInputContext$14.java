package com.bytedance.ee.bear.middleground.comment.input;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.CommentVoiceInputResultConsumer;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InputComment$buildVoiceInputContext$14 extends FunctionReferenceImpl implements Function2<View, MotionEvent, Boolean> {
    public InputComment$buildVoiceInputContext$14(Object r8) {
        super(2, r8, InputComment.class, "handleLarkSimpleVoiceTouch", "handleLarkSimpleVoiceTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z", 0);
    }

    public final Boolean invoke(View r13, MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r13, "p0");
        Intrinsics.checkNotNullParameter(r14, "p1");
        final InputComment r0 = (InputComment) ((CallableReference) this).receiver;
        CommentImmersiveVoiceTouchDelegate r2 = (CommentImmersiveVoiceTouchDelegate) r0.V.getValue();
        if (r2 == null) goto L5;
        CommentImmersiveVoiceTouchDelegate.c(r2, r13, r14, new InputComment$handleLarkSimpleVoiceTouch$1(r0), new CommentVoiceInputResultConsumer(new CommentVoiceEditTextBridge(r0.p), null, new InputComment$handleLarkSimpleVoiceTouch$2(r0), null, 26), r0.b.n1(), new InputComment$handleLarkSimpleVoiceTouch$3(r0.J()));
        boolean r15 = true;
    L7:
        return Boolean.valueOf(r15);
    L5:
        r15 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((View) r1, (MotionEvent) r2);
    }
}
