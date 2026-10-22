package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472482c;

    public final String toString() {
        return "ConfirmDialogShowedEvent(commentId='" + this.f472480a + "', replyId='" + this.f472481b + "', type=" + this.f472482c + ')';
    }

    public final int getType() {
        return this.f472482c;
    }

    public l(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        this.f472480a = r100;
        this.f472481b = r101;
        this.f472482c = r102;
    }
}
