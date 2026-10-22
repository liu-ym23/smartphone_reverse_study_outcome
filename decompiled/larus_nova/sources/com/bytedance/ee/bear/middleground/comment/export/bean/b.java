package com.bytedance.ee.bear.middleground.comment.export.bean;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f231374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f231375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f231376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f231377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f231378e;

    public final String toString() {
        return "CommentPermission{copy=" + this.f231374a + ", comment=" + this.f231375b + ", escape=" + this.f231376c + ", askSmartReply=" + this.f231377d + ", report=" + this.f231378e + '}';
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f231376c = false;
        this.f231377d = false;
        this.f231374a = r100;
        this.f231375b = r101;
        this.f231376c = r102;
        this.f231377d = r103;
        this.f231378e = r104;
    }
}
