package fz3;

import android.text.Editable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Editable f479349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q14.a f479350b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f479349a, r101.f479349a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479350b, r101.f479350b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Editable r100 = this.f479349a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        q14.a r104 = this.f479350b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentContent(content=" + this.f479349a + ", emoji=" + this.f479350b + ')';
    }

    public a(Editable r100, q14.a r101) {
        this.f479349a = r100;
        this.f479350b = r101;
    }
}
