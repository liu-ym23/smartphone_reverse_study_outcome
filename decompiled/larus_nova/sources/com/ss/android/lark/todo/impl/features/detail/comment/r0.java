package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoUser f442982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f442983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f442984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RichContent f442985d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f442982a, r101.f442982a) == true) goto L12;
        return false;
    L12:
        if (this.f442983b == r101.f442983b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442984c, r101.f442984c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f442985d, r101.f442985d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f442982a.hashCode() * 31;
        long r101 = this.f442983b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f442984c.hashCode()) * 31;
        RichContent r103 = this.f442985d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreatorInfo(user=" + this.f442982a + ", createTime=" + this.f442983b + ", parentGuid=" + this.f442984c + ", parentSummary=" + this.f442985d + ')';
    }

    public r0(TodoUser r100, long r101, String r102, RichContent r103) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r102, "parentGuid");
        this.f442982a = r100;
        this.f442983b = r101;
        this.f442984c = r102;
        this.f442985d = r103;
    }
}
