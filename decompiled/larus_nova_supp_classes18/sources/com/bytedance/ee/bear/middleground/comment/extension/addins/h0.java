package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 implements Runnable {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ boolean c;

    public h0(e0 r1, Integer r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        p1 r0 = this.a.getContext().c();
        Integer r1 = null;
        if (r0 == null) goto L5;
        q1 r2 = r0.jV();
    L6:
        if (r2 == null) goto L12;
        Integer r3 = this.b;
        if (r3 == null) goto L10;
        int r4 = r3.intValue();
    L11:
        RecyclerView r5 = r2.P0(Integer.valueOf(r4));
    L13:
        CommentStyle r6 = this.a.b().a().getConfig().n;
        if (r6 != CommentStyle.ASIDE) goto L16;
    L26:
        e0.c(this.a, r5, this.c);
        return;
    L16:
        if (r6 == CommentStyle.ASIDE_IN_PICTURE) goto L26;
        Integer r7 = this.b;
        p1 r8 = this.a.getContext().c();
        if (r8 == null) goto L24;
        q1 r9 = r8.jV();
        if (r9 == null) goto L24;
        r1 = r9.E();
    L24:
        if (Intrinsics.areEqual(r7, r1) == false) goto L28;
        e0.c(this.a, r5, this.c);
        return;
    L28:
        return;
    L10:
        r4 = 0;
        goto L11
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
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
