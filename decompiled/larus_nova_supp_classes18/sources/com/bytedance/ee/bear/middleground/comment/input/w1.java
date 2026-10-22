package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w1 implements CommentKeyboardPlaceholderView.a {
    public final /* synthetic */ InputCommentV2 a;

    public w1(InputCommentV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView.a
    public final void a(int r13, boolean r14) {
        tt5.a.h(this.a.i0, "setOnHeightChangeListener : height = " + r13 + ", canDismiss = " + r14 + ", interceptDismissTags = " + CollectionsKt.joinToString$default(this.a.q0, ",", null, null, 0, null, null, 62, null));
        InputCommentV2 r0 = this.a;
        r0.a.N.a(new ef5.y(r0, r13, r14));
        boolean r1 = false;
        if (this.a.q0.isEmpty() == false) goto L9;
        if (r13 > 0) goto L9;
        if (r14 == false) goto L9;
        if (rcb.b.a(this.a.a.getActivity()) == true) goto L9;
        tt5.a.h(this.a.i0, "setOnHeightChangeListener : so dismiss inputComment");
        kf5.a.a(this.a, false, false, 2);
    L9:
        DialogFragment r15 = this.a.N;
        if (r15 == null) goto L16;
        Dialog r16 = r15.getDialog();
        if (r16 == null) goto L16;
        if (r16.isShowing() != true) goto L16;
        r1 = true;
    L16:
        if (r1 == false) goto L35;
        DialogFragment r17 = this.a.N;
        if (r17 == null) goto L24;
        Dialog r18 = r17.getDialog();
        if (r18 == null) goto L24;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L24;
        WindowManager.LayoutParams r110 = r19.getAttributes();
    L25:
        if (r110 == null) goto L27;
        r110.height = r13;
    L27:
        DialogFragment r111 = this.a.N;
        if (r111 == null) goto L35;
        Dialog r112 = r111.getDialog();
        if (r112 == null) goto L35;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L35;
        r113.setAttributes(r110);
    L24:
        r110 = null;
    L35:
        if (this.a.m0.c() == false) goto L38;
        this.a.G0();
        return;
    }
}
