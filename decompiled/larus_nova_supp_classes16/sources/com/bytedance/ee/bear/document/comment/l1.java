package com.bytedance.ee.bear.document.comment;

import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l1 implements bf5.b {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ CommentPlugin.v b;

    public final void c() {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) CommentPlugin.access$6700(this.b.a, BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (ku5.c.k(CommentPlugin.access$6800(this.b.a)) == true) goto L7;
    L10:
        r0.forcePortrait();
        return;
    L7:
        if (cu5.c.e(CommentPlugin.access$6900(this.b.a)) == false) goto L10;
        if (ku5.c.l() == false) goto L10;
    }

    public final void onCancel() {
        this.a.b(CommentPlugin.v.a(this.b, 1));
    }

    public final void b(Throwable r3) {
        if (CommentPlugin.access$7100(this.b.a) == false) goto L6;
        this.a.b(CommentPlugin.v.a(this.b, 1));
        return;
    }

    public final void d(String r3) {
        if (CommentPlugin.access$7200(this.b.a) == false) goto L6;
        this.a.b(CommentPlugin.v.a(this.b, 0));
        return;
    }

    public l1(CommentPlugin.v r1, tb5.m r2) {
        this.b = r1;
        this.a = r2;
    }
}
