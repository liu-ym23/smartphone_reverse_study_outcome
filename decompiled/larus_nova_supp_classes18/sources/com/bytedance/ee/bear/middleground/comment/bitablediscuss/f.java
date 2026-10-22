package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Runnable {
    public final /* synthetic */ BitableDiscussPanel a;

    public f(BitableDiscussPanel r1) {
        this.a = r1;
    }

    public final void a() {
        BitableDiscussPanel r0 = this.a;
        String r1 = r0.G;
        int r2 = 0;
        if (r1 == null) goto L13;
        a r3 = r0.ha0();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "replyUUID");
        List r4 = (List) r3.n.getValue();
        if (r4 == null) goto L12;
        int r5 = r4.size();
    L7:
        if (r2 >= r5) goto L12;
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r4, r2)).getReplyUUID(), r1) == true) goto L25;
        r2 = r2 + 1;
    L25:
        if (r2 == (-1)) goto L38;
        BitableDiscussPanel r6 = this.a;
        RecyclerView r7 = null;
        r6.F = null;
        r6.G = null;
        r6.ga0();
        RecyclerView r8 = this.a.p;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
    L30:
        r7.smoothScrollToPosition(r2);
        return;
    L29:
        r7 = r8;
        goto L30
    L38:
        return;
    L12:
        r2 = -1;
        goto L25
    L13:
        String r9 = r0.F;
        if (r9 == null) goto L12;
        a r10 = r0.ha0();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "commentUUID");
        List r11 = (List) r10.n.getValue();
        if (r11 == null) goto L12;
        int r12 = r11.size();
    L18:
        if (r2 >= r12) goto L12;
        if (((CommentBean.CommentDetail) ListProtector.get(r11, r2)).getBitableExtra().isMainComment() == false) goto L24;
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r11, r2)).getCommentUUID(), r9) == true) goto L25;
    L24:
        r2 = r2 + 1;
        goto L18
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
