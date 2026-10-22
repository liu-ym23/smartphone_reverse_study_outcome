package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f472466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f472467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f472468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f472469g;

    public final String toString() {
        return "CommentSendEvent(commentId='" + this.f472463a + "', replyId=" + this.f472464b + ", sendType=" + this.f472465c + ", isWhole=" + this.f472466d + ", clearDraft=" + this.f472467e + ')';
    }

    public /* synthetic */ h(String r100) {
        this(r100, null, 2, false, true);
    }

    public h(String r100, String r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        this.f472463a = r100;
        this.f472464b = r101;
        this.f472465c = r102;
        this.f472466d = r103;
        this.f472467e = r104;
    }
}
