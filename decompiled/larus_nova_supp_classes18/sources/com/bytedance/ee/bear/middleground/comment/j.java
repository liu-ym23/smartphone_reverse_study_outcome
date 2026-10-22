package com.bytedance.ee.bear.middleground.comment;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.export.CommentBuilder;
import com.bytedance.ee.bear.middleground.comment.uitls.r;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements com.bytedance.ee.bear.middleground.comment.export.n {
    public j() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final g a() {
        return new g();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final r e() {
        return new r();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final h f() {
        return new h();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final com.bytedance.ee.bear.middleground.comment.uitls.s.a c() {
        return com.bytedance.ee.bear.middleground.comment.uitls.s.b;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final q d(CommentBuilder r2) {
        return new q(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final Comment g(CommentBuilder r2) {
        int r0 = Comment.z0;
        return Comment.a.a(r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.middleground.comment.f] */
    @Override // com.bytedance.ee.bear.middleground.comment.export.n
    public final com.bytedance.ee.bear.middleground.comment.cell.i b(FragmentActivity r3, Function1 r4, Function1 r5, Function1 r6) {
        com.bytedance.ee.bear.middleground.comment.cell.i r0 = new com.bytedance.ee.bear.middleground.comment.cell.i(r3, new f());
        r0.d = new i(r4, r5, r6);
        return r0;
    }
}
