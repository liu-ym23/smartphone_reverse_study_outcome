package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements bb5.b {
    public final /* synthetic */ bb5.b a;
    public final /* synthetic */ AsideInputComment b;

    public final void onDetach() {
        this.a.onDetach();
    }

    public final void onPause() {
        this.a.onPause();
    }

    public final void onResume() {
        this.a.onResume();
    }

    public final void onStart() {
        this.a.onStart();
    }

    public final void onStop() {
        this.a.onStop();
    }

    public final void a(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        this.a.a(r3);
        AsideInputComment r0 = this.b;
        r0.getClass();
        int r1 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.a;
        if (ForsetiHelper.s(r0.a.b) == false) goto L9;
        Fragment r2 = r0.a.b;
        if (r2 == null) goto L9;
        View r4 = r2.getView();
        if (r4 == null) goto L9;
        int r5 = r4.getWidth();
    L10:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.d(r3, r5);
        return;
    L9:
        r5 = -1;
        goto L10
    }

    public final void b(int r4) {
        tt5.a.h(this.b.i0, "onAttach() called with: height = " + r4);
        AsideInputComment.E0(this.b, r4);
    }

    public b(bb5.i r1, AsideInputComment r2) {
        this.a = r1;
        this.b = r2;
    }
}
