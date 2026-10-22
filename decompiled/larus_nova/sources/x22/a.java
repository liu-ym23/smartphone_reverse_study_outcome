package x22;

import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HintType f562222b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f562221a, r101.f562221a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f562222b, r101.f562222b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f562221a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HintType r104 = this.f562222b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentHint(content=" + this.f562221a + ", type=" + this.f562222b + ")";
    }

    public a() {
        this("", HintType.NORMAL);
    }

    public final HintType getType() {
        return this.f562222b;
    }

    public a(String r100, HintType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f562221a = r100;
        this.f562222b = r101;
    }
}
