package iy3;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496477b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f496476a, r101.f496476a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496477b, r101.f496477b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f496476a.hashCode() * 31) + this.f496477b.hashCode();
    }

    public final String toString() {
        return "CommentRoot(groupId=" + this.f496476a + ", serviceId=" + this.f496477b + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter("0", "serviceId");
        this.f496476a = r100;
        this.f496477b = "0";
        if (AoEnv.h() == true) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        return;
    L11:
        throw new RuntimeException("groupId or serviceId can't be empty when constructing CommentRoot.");
    L7:
        r101 = false;
        goto L8
    }
}
