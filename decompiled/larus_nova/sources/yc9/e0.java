package yc9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f567234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f567235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f567236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f567237d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f567234a == r101.f567234a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f567235b, r101.f567235b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f567236c, r101.f567236c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f567237d, r101.f567237d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f567234a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f567235b.hashCode()) * 31;
        f0 r102 = this.f567236c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.f567237d.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageModifyRequest(needReplaceTxtAndFile=" + this.f567234a + ", editResultMsgRequest=" + this.f567235b + ", newReferenceMsgRequest=" + this.f567236c + ", standByEditLocalMsgId=" + this.f567237d + ')';
    }

    public e0(boolean r100, f0 r101, f0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "editResultMsgRequest");
        Intrinsics.checkNotNullParameter(r103, "standByEditLocalMsgId");
        this.f567234a = r100;
        this.f567235b = r101;
        this.f567236c = r102;
        this.f567237d = r103;
    }
}
