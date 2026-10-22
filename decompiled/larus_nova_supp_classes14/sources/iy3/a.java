package iy3;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CommentRoot(groupId=" + this.a + ", serviceId=" + this.b + ')';
    }

    public a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "groupId");
        Intrinsics.checkNotNullParameter("0", "serviceId");
        this.a = r3;
        this.b = "0";
        if (AoEnv.h() == true) goto L5;
        return;
    L5:
        if (r3.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        return;
    L11:
        throw new RuntimeException("groupId or serviceId can't be empty when constructing CommentRoot.");
    L7:
        r4 = false;
        goto L8
    }
}
