package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f472509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f472511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f472512f;

    public final String toString() {
        return "InsertContentToDraftEvent(commentId=" + this.f472507a + ", replyId=" + this.f472508b + ", isWhole=" + this.f472509c + ", content=" + this.f472510d + ", insertAtBeginning=" + this.f472511e + ", checkExistingContent=" + this.f472512f + ')';
    }

    public v(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f472507a = r100;
        this.f472508b = null;
        this.f472509c = r101;
        this.f472510d = r102;
        this.f472511e = true;
        this.f472512f = true;
    }
}
