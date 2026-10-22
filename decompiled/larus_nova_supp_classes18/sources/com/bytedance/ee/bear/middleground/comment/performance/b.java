package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements af5.a {
    public final p a;
    public long b;
    public long c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    public static final class a {
    }

    static {
    }

    @Override // af5.a
    public final void a() {
        if (this.b > 0) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis() - this.b;
        tt5.a.h("Comment#LoadCostTracker", "recordEnd()... cost = " + r1);
        p r5 = this.a;
        h r6 = r5.d0;
        long r7 = this.c;
        String r9 = this.d;
        String r10 = this.e;
        int r11 = this.f;
        int r12 = this.g;
        int r13 = this.h;
        int r14 = this.i;
        int r15 = this.j;
        int r3 = this.k;
        String r4 = r5.k.getType();
        String r8 = du5.b.g(this.a.i);
        r6.getClass();
        HashMap r0 = new HashMap();
        r0.put("cost", Long.valueOf(r1));
        r0.put("web_stage_cost", Long.valueOf(r7));
        r0.put("native_stage_cost", Long.valueOf(r1 - r7));
        r0.put("from", r9);
        r0.put("comment_style", r6.f);
        r0.put("comment_id", r10);
        r0.put("reply_count", Integer.valueOf(r11));
        r0.put("comment_count", Integer.valueOf(r12));
        r0.put("total_reply_count", Integer.valueOf(r13));
        r0.put("content_length", Integer.valueOf(r14));
        r0.put("image_count", Integer.valueOf(r15));
        r0.put("raw_data_length", Integer.valueOf(r3));
        r0.put("file_type", r4);
        r0.put("file_id", r8);
        if (r6.e == false) goto L8;
        String r2 = "true";
    L9:
        r0.put("is_vc", r2);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentLoadCost params = " + r0);
        r6.g.a("mobile_comment_load_cost_dev", r0);
        this.b = 0;
        this.c = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        return;
    L8:
        r2 = "false";
        goto L9
    }

    public final boolean b() {
        if (this.b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        if (this.b > 0) goto L5;
        return;
    L5:
        if (this.c != 0) goto L9;
        this.c = System.currentTimeMillis() - this.b;
        tt5.a.h("Comment#LoadCostTracker", "recordWebStage()... webStageCost = " + this.c);
        return;
    }

    public b(p r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void d(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        tt5.a.h("Comment#LoadCostTracker", "recordStart()... start = " + r3 + ", from = " + r5);
        this.b = r3;
        this.c = 0;
        this.d = r5;
    }

    public final void c(String r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r3, "commentId");
        tt5.a.h("Comment#LoadCostTracker", "recordInfo()... commentId = " + r3 + ", replyCount = " + r4 + ", commentCount = " + r5 + ", totalReplyCount = " + r6 + ", contentLength = " + r7 + ", imageCount = " + r8 + ", rawDataLength = " + r9);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
    }
}
