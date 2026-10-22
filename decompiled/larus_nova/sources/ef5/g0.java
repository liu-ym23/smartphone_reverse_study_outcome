package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472462b;

    public final String toString() {
        return "ReplyTextChangedEvent(text=" + this.f472461a.length() + ", commentId='" + this.f472462b + "')";
    }

    public g0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "commentId");
        this.f472461a = r100;
        this.f472462b = r101;
    }
}
