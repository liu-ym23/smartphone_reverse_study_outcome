package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y0 implements CommentKeyboardPlaceholderView.a {
    public final /* synthetic */ InputComment a;

    public y0(InputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView.a
    public final void a(int r13, boolean r14) {
        tt5.a.h("Comment#InputComment", "setOnHeightChangeListener : height = " + r13 + ", canDismiss = " + r14 + ", isOperationVisibible = " + this.a.z + ", interceptDismissTags = " + CollectionsKt.joinToString$default(this.a.u0, ",", null, null, 0, null, null, 62, null));
        InputComment r0 = this.a;
        r0.a.N.a(new ef5.y(r0, r13, r14));
        boolean r3 = false;
        if (this.a.u0.isEmpty() == false) goto L11;
        InputComment r1 = this.a;
        if (r1.z == true) goto L11;
        if (r13 > 0) goto L11;
        if (r14 == false) goto L11;
        if (rcb.b.a(r1.a.getActivity()) == true) goto L11;
        tt5.a.h("Comment#InputComment", "setOnHeightChangeListener, height = " + r13 + ", canDismiss = " + r14 + ", so dismiss inputComment");
        kf5.a.a(this.a, false, false, 2);
    L12:
        DialogFragment r15 = this.a.g0;
        if (r15 == null) goto L19;
        Dialog r16 = r15.getDialog();
        if (r16 == null) goto L19;
        if (r16.isShowing() != true) goto L19;
        r3 = true;
    L19:
        if (r3 == false) goto L38;
        DialogFragment r17 = this.a.g0;
        if (r17 == null) goto L27;
        Dialog r18 = r17.getDialog();
        if (r18 == null) goto L27;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L27;
        WindowManager.LayoutParams r110 = r19.getAttributes();
    L28:
        if (r110 == null) goto L30;
        r110.height = r13;
    L30:
        DialogFragment r111 = this.a.g0;
        if (r111 == null) goto L38;
        Dialog r112 = r111.getDialog();
        if (r112 == null) goto L38;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L38;
        r113.setAttributes(r110);
    L27:
        r110 = null;
    L38:
        if (this.a.S.c() == false) goto L41;
        this.a.d0();
        return;
    L41:
        return;
    L11:
        this.a.z = false;
        goto L12
    }
}
