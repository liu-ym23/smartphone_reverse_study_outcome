package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f232049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f232050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f232051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f232052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f232053f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.performance.a$a, reason: collision with other inner class name */
    public static final class C3319a {
    }

    static {
    }

    public final boolean a() {
        if (this.f232049b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        if (this.f232049b > 0) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f232049b;
        tt5.a.h("Comment#EditableCostTracker", "recordEnd()... cost = " + r100);
        p r101 = this.f232048a;
        h r102 = r101.f232225d0;
        long r103 = this.f232050c;
        String r104 = this.f232051d;
        String r105 = this.f232052e;
        String r110 = this.f232053f;
        String r106 = r101.f232235k.getType();
        String r111 = du5.b.g(this.f232048a.f232233i);
        r102.getClass();
        HashMap r112 = new HashMap();
        r112.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r100));
        r112.put("web_stage_cost", Long.valueOf(r103));
        r112.put("native_stage_cost", Long.valueOf(r100 - r103));
        r112.put("comment_style", r102.f232208f);
        r112.put("domain", r104);
        r112.put("type", r105);
        r112.put("from", r110);
        r112.put("file_type", r106);
        r112.put("file_id", r111);
        if (r102.f232207e == false) goto L8;
        String r107 = "true";
    L9:
        r112.put("is_vc", r107);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentEditableCost params = " + r112);
        r102.f232209g.a("mobile_comment_editable_cost_dev", r112);
        this.f232049b = 0;
        this.f232050c = 0;
        this.f232051d = null;
        this.f232052e = null;
        this.f232053f = null;
        return;
    L8:
        r107 = "false";
        goto L9
    }

    public final void d() {
        if (this.f232049b > 0) goto L5;
        return;
    L5:
        if (this.f232050c != 0) goto L9;
        this.f232050c = System.currentTimeMillis() - this.f232049b;
        tt5.a.h("Comment#EditableCostTracker", "recordWebStage()... webStageCost = " + this.f232050c);
        return;
    }

    public a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232048a = r100;
    }

    public final void c(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "domain");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "from");
        tt5.a.h("Comment#EditableCostTracker", "recordStart()... start = " + r100 + ", domain = " + r101 + ", type = " + r102 + ", from = " + r103);
        this.f232049b = r100;
        this.f232050c = 0;
        this.f232051d = r101;
        this.f232052e = r102;
        this.f232053f = r103;
    }
}
