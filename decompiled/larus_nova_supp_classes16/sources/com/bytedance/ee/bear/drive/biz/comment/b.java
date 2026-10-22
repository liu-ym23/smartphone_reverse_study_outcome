package com.bytedance.ee.bear.drive.biz.comment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.middleground.comment.export.o {
    public final o1 a;

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return true;
    }

    public final boolean f() {
        return true;
    }

    public final void j0() {
    }

    public final boolean a() {
        o1 r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((b1) r0).a() == false) goto L7;
        return true;
    }

    public final boolean e() {
        o1 r0 = this.a;
        if (r0 == null) goto L11;
        b1 r1 = (b1) r0;
        if (r1.a.G.livePerm().getValue() != null) goto L7;
        boolean r2 = false;
    L8:
        if (r2 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = ((u55.b) r1.a.G.livePerm().getValue()).b.a.canDownload();
        goto L8
    L11:
        return false;
    }

    public final boolean g() {
        o1 r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L10;
        b1 r2 = (b1) r0;
        if (r2.a.G.livePerm().getValue() != null) goto L7;
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        r1 = true;
        goto L10
    L7:
        r3 = ((u55.b) r2.a.G.livePerm().getValue()).b();
    L10:
        tt5.a.h("CommentPermissionImpl", "getCopy=" + r1);
        return r1;
    }

    public final boolean getComment() {
        o1 r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((b1) r0).a() == false) goto L7;
        return true;
    }

    public final boolean h() {
        o1 r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L10;
        b1 r2 = (b1) r0;
        if (r2.a.G.getLiveCopyEscape().getValue() != null) goto L7;
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        r1 = true;
        goto L10
    L7:
        r3 = ((Boolean) r2.a.G.getLiveCopyEscape().getValue()).booleanValue();
    L10:
        tt5.a.h("CommentPermissionImpl", "canEscape=" + r1);
        return r1;
    }

    public b(b1 r1) {
        this.a = r1;
    }
}
