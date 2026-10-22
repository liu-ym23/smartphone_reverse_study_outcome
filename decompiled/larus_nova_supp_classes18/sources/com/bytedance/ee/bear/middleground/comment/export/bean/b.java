package com.bytedance.ee.bear.middleground.comment.export.bean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public final String toString() {
        return "CommentPermission{copy=" + this.a + ", comment=" + this.b + ", escape=" + this.c + ", askSmartReply=" + this.d + ", report=" + this.e + '}';
    }

    public b(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        this.c = false;
        this.d = false;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
