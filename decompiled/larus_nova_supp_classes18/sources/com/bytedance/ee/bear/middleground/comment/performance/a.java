package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.middleground.comment.uitls.h;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final p a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.performance.a$a, reason: collision with other inner class name */
    public static final class C0072a {
    }

    static {
    }

    public final boolean a() {
        if (this.b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        if (this.b > 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.b;
        tt5.a.h("Comment#EditableCostTracker", "recordEnd()... cost = " + r0);
        p r4 = this.a;
        h r5 = r4.d0;
        long r6 = this.c;
        String r8 = this.d;
        String r9 = this.e;
        String r10 = this.f;
        String r7 = r4.k.getType();
        String r11 = du5.b.g(this.a.i);
        r5.getClass();
        HashMap r12 = new HashMap();
        r12.put("cost", Long.valueOf(r0));
        r12.put("web_stage_cost", Long.valueOf(r6));
        r12.put("native_stage_cost", Long.valueOf(r0 - r6));
        r12.put("comment_style", r5.f);
        r12.put("domain", r8);
        r12.put(ResourceData.KEY_TYPE, r9);
        r12.put("from", r10);
        r12.put("file_type", r7);
        r12.put("file_id", r11);
        if (r5.e == false) goto L8;
        String r1 = "true";
    L9:
        r12.put("is_vc", r1);
        tt5.a.b("Comment#CommentAnalytic", "reportCommentEditableCost params = " + r12);
        r5.g.a("mobile_comment_editable_cost_dev", r12);
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        return;
    L8:
        r1 = "false";
        goto L9
    }

    public final void d() {
        if (this.b > 0) goto L5;
        return;
    L5:
        if (this.c != 0) goto L9;
        this.c = System.currentTimeMillis() - this.b;
        tt5.a.h("Comment#EditableCostTracker", "recordWebStage()... webStageCost = " + this.c);
        return;
    }

    public a(p r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void c(long r3, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "domain");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r7, "from");
        tt5.a.h("Comment#EditableCostTracker", "recordStart()... start = " + r3 + ", domain = " + r5 + ", type = " + r6 + ", from = " + r7);
        this.b = r3;
        this.c = 0;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
