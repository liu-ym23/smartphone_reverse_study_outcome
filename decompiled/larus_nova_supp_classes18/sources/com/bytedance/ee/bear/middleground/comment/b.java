package com.bytedance.ee.bear.middleground.comment;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ze5.c {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Comment b;

    @Override // ze5.c
    public final void a() {
        tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: insert to current comment and focus input");
        this.a.invoke();
    }

    @Override // ze5.c
    public final void b() {
        tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: insert image failed");
        int r0 = com.bytedance.ee.bear.middleground.comment.uitls.k.a;
        FragmentActivity r1 = this.b.r.getActivity();
        Intrinsics.checkNotNullParameter(r1, "context");
        Toast.showFailureText(r1, xo5.a.c(r1, 2131886932, "count", "9"));
        this.a.invoke();
    }

    public b(Function0<Unit> r1, Comment r2) {
        this.a = r1;
        this.b = r2;
    }
}
