package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements af5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f232055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f232056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f232057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f232058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f232059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f232060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f232061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f232062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f232063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f232064k;

    public static final class a {
    }

    static {
    }

    @Override // af5.a
    public final void a() {
        if (this.f232055b > 0) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f232055b;
        tt5.a.h("Comment#LoadCostTracker", "recordEnd()... cost = " + r100);
        p r101 = this.f232054a;
        h r102 = r101.f232225d0;
        long r103 = this.f232056c;
        String r104 = this.f232057d;
        String r110 = this.f232058e;
        int r111 = this.f232059f;
        int r112 = this.f232060g;
        int r113 = this.f232061h;
        int r114 = this.f232062i;
        int r115 = this.f232063j;
        int r105 = this.f232064k;
        String r106 = r101.f232235k.getType();
        String r107 = du5.b.g(this.f232054a.f232233i);
        r102.getClass();
        HashMap r108 = new HashMap();
        r108.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r100));
        r108.put("web_stage_cost", Long.valueOf(r103));
        r108.put("native_stage_cost", Long.valueOf(r100 - r103));
        r108.put("from", r104);
        r108.put("comment_style", r102.f232208f);
        r108.put("comment_id", r110);
        r108.put("reply_count", Integer.valueOf(r111));
        r108.put("comment_count", Integer.valueOf(r112));
        r108.put("total_reply_count", Integer.valueOf(r113));
        r108.put("content_length", Integer.valueOf(r114));
        r108.put(FrescoMonitorConst.IMAGE_COUNT, Integer.valueOf(r115));
        r108.put("raw_data_length", Integer.valueOf(r105));
        r108.put("file_type", r106);
        r108.put("file_id", r107);
        if (r102.f232207e == false) goto L8;
        String r109 = "true";
    L9:
        r108.put("is_vc", r109);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentLoadCost params = " + r108);
        r102.f232209g.a("mobile_comment_load_cost_dev", r108);
        this.f232055b = 0;
        this.f232056c = 0;
        this.f232058e = null;
        this.f232059f = 0;
        this.f232060g = 0;
        this.f232061h = 0;
        this.f232062i = 0;
        this.f232063j = 0;
        this.f232064k = 0;
        return;
    L8:
        r109 = "false";
        goto L9
    }

    public final boolean b() {
        if (this.f232055b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        if (this.f232055b > 0) goto L5;
        return;
    L5:
        if (this.f232056c != 0) goto L9;
        this.f232056c = System.currentTimeMillis() - this.f232055b;
        tt5.a.h("Comment#LoadCostTracker", "recordWebStage()... webStageCost = " + this.f232056c);
        return;
    }

    public b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232054a = r100;
    }

    public final void d(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        tt5.a.h("Comment#LoadCostTracker", "recordStart()... start = " + r100 + ", from = " + r101);
        this.f232055b = r100;
        this.f232056c = 0;
        this.f232057d = r101;
    }

    public final void c(String r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        tt5.a.h("Comment#LoadCostTracker", "recordInfo()... commentId = " + r100 + ", replyCount = " + r101 + ", commentCount = " + r102 + ", totalReplyCount = " + r103 + ", contentLength = " + r104 + ", imageCount = " + r105 + ", rawDataLength = " + r106);
        this.f232058e = r100;
        this.f232059f = r101;
        this.f232060g = r102;
        this.f232061h = r103;
        this.f232062i = r104;
        this.f232063j = r105;
        this.f232064k = r106;
    }
}
