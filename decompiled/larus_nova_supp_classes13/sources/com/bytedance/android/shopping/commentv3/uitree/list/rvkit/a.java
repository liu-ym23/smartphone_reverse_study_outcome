package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentExtras;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.DataType;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import com.bytedance.android.shopping.monitor.d;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ CommentAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RecyclerView.ViewHolder c;

    public a(CommentAdapter r1, int r2, RecyclerView.ViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        RecyclerView.LayoutManager r0 = this.a.A.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        GridLayoutManager r1 = (GridLayoutManager) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.findLastVisibleItemPosition() != this.b) goto L41;
        CommentAdapter r2 = this.a;
        if (r2.y == true) goto L25;
        r2.y = true;
        c r3 = r2.z;
        if (r3 == null) goto L21;
        com.bytedance.android.shopping.commentv3.data.b r4 = r3.e;
        if (r4 == null) goto L21;
        CommentParams r5 = r4.a;
        if (r5 == null) goto L21;
        CommentExtras r6 = r5.getCommentExtras();
        if (r6 == null) goto L21;
        String r7 = r6.getCommentMonitorName();
    L22:
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        d.f(r7).h();
    L21:
        r7 = null;
    L25:
        FetchFrom r8 = this.a.x;
        if (r8 == null) goto L42;
        String r9 = r8.getPerfMobKey();
        CommentAdapter r10 = this.a;
        r10.x = null;
        if (r9 == null) goto L43;
        c r11 = r10.z;
        if (r11 == null) goto L34;
        com.bytedance.android.shopping.commentv3.data.b r12 = r11.e;
        if (r12 == null) goto L34;
        int r13 = r12.a();
    L36:
        if (o53.b.a() == false) goto L38;
        String r14 = "goods";
    L39:
        InteractionPerfMonitor.j.getClass();
        InteractionPerfMonitor.a.a(r9).a(r13, r14, this.c.itemView.getContext(), r9);
        return;
    L38:
        r14 = "shop";
    L34:
        r13 = DataType.PRODUCT.getType();
        goto L36
    L43:
        return;
    L42:
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
