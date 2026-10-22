package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnAttachStateChangeListener {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        tt5.a.h("CommentImageAreaMarkRender", "onViewAttachedToWindow");
        a r4 = this.a;
        r4.getClass();
        g r0 = g.a;
        FragmentActivity r1 = r4.a.getActivity();
        Fragment r5 = r4.a.b;
        r0.getClass();
        sa5.b r6 = g.a(r1, r5);
        if (r6 == null) goto L5;
        r6.e(this.a.l);
    L5:
        a r7 = this.a;
        if (r7.c != AreaMarkMode.EDIT) goto L11;
        IImageViewer r2 = r7.b;
        if (r2 == null) goto L12;
        r2.Ws(r7.l);
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        tt5.a.h("CommentImageAreaMarkRender", "onViewDetachedFromWindow");
        a r4 = this.a;
        r4.getClass();
        g r0 = g.a;
        FragmentActivity r1 = r4.a.getActivity();
        Fragment r5 = r4.a.b;
        r0.getClass();
        sa5.b r6 = g.a(r1, r5);
        if (r6 == null) goto L5;
        r6.d(this.a.l);
    L5:
        a r7 = this.a;
        if (r7.c != AreaMarkMode.EDIT) goto L10;
        IImageViewer r8 = r7.b;
        if (r8 == null) goto L10;
        r8.Ws(null);
    L10:
        this.a.m.i(false, false);
        this.a.m.j();
    }
}
