package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ LinearLayoutManager a;
    public final /* synthetic */ ef5.m b;
    public final /* synthetic */ e0 c;

    public f0(LinearLayoutManager r1, ef5.m r2, e0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        int r0 = this.a.findFirstVisibleItemPosition();
        int r1 = this.a.findLastVisibleItemPosition();
        if (r0 == (-1)) goto L19;
        if (r1 == (-1)) goto L22;
        if (r0 > r1) goto L21;
    L7:
        List<CommentBean> r2 = this.b.d;
        String r3 = null;
        if (r2 == null) goto L12;
        CommentBean r4 = (CommentBean) CollectionsKt.getOrNull(r2, r0);
        if (r4 == null) goto L12;
        String r5 = r4.getComment_id();
    L13:
        CommentBean r6 = (CommentBean) CollectionsKt.getOrNull(this.b.a, r0);
        if (r6 == null) goto L16;
        r3 = r6.getComment_id();
    L16:
        this.c.e(this.b.a, r0, !Intrinsics.areEqual(r5, r3));
        if (r0 == r1) goto L23;
        r0 = r0 + 1;
        goto L7
    L23:
        return;
    L12:
        r5 = null;
        goto L13
    L21:
        return;
    L22:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
