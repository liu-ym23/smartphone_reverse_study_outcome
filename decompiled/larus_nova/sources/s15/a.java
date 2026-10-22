package s15;

import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540155b;

    public final String toString() {
        return "AreaCommentExtra(commentId='" + b.h(this.f540154a) + "', replyId='" + b.h(this.f540155b) + "')";
    }

    public a(String r100, String r101) {
        this.f540154a = "";
        this.f540155b = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f540154a = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        this.f540155b = r101;
    }
}
