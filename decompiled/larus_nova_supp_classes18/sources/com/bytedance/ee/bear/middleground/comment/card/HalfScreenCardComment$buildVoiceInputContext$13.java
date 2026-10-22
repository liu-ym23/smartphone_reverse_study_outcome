package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.CommentVoiceInputResultConsumer;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class HalfScreenCardComment$buildVoiceInputContext$13 extends FunctionReferenceImpl implements Function2<View, MotionEvent, Boolean> {
    public HalfScreenCardComment$buildVoiceInputContext$13(Object r8) {
        super(2, r8, HalfScreenCardComment.class, "handleHalfLarkSimpleVoiceTouch", "handleHalfLarkSimpleVoiceTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z", 0);
    }

    public final Boolean invoke(View r13, MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r13, "p0");
        Intrinsics.checkNotNullParameter(r14, "p1");
        final HalfScreenCardComment r0 = (HalfScreenCardComment) ((CallableReference) this).receiver;
        CommentImmersiveVoiceTouchDelegate r2 = (CommentImmersiveVoiceTouchDelegate) r0.V.getValue();
        if (r2 == null) goto L8;
        Function0<ViewGroup> r5 = new HalfScreenCardComment$handleHalfLarkSimpleVoiceTouch$1(r0);
        CommentEditText r3 = r0.M;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r3 = null;
    L7:
        CommentImmersiveVoiceTouchDelegate.c(r2, r13, r14, r5, new CommentVoiceInputResultConsumer(new CommentVoiceEditTextBridge(r3), null, new HalfScreenCardComment$handleHalfLarkSimpleVoiceTouch$2(r0), new HalfScreenCardComment$handleHalfLarkSimpleVoiceTouch$3(r0), 10), r0.b.n1(), new HalfScreenCardComment$handleHalfLarkSimpleVoiceTouch$4(r0.f()));
        boolean r15 = true;
    L10:
        return Boolean.valueOf(r15);
    L8:
        r15 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((View) r1, (MotionEvent) r2);
    }
}
