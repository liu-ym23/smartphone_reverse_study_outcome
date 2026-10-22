package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f472474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f472475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f472478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f472479f;

    public final String toString() {
        return "CommentSwitchEvent(position=" + this.f472474a + ", commentId='" + this.f472476c + "', lastCommentId='" + this.f472478e + "')";
    }

    public /* synthetic */ j(Integer r100, int r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public j(Integer r100, int r101, String r102, String r103, String r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r102, "commentId");
        Intrinsics.checkNotNullParameter(r103, "commentUUID");
        this.f472474a = r100;
        this.f472475b = r101;
        this.f472476c = r102;
        this.f472477d = r103;
        this.f472478e = r104;
        this.f472479f = r105;
    }
}
