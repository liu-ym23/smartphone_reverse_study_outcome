package com.ss.android.lark.todo.impl.features.detail.sections;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f443344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f443345d;

    public final int hashCode() {
        int r100 = ((this.f443342a.hashCode() * 31) + this.f443343b.hashCode()) * 31;
        if (this.f443344c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f443345d;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AvatarBean(id=" + this.f443342a + ", avatarKey=" + this.f443343b + ", statusShow=" + this.f443344c + ", avatarResId=" + this.f443345d + ')';
    }

    public final boolean equals(Object r100) {
        c r101 = (c) r100;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(this.f443342a, r101.f443342a) == true) goto L7;
        return false;
    L7:
        if (r101.f443344c == this.f443344c) goto L9;
        return false;
    L9:
        return true;
    }

    public c(String r100, String r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        this.f443342a = r100;
        this.f443343b = r101;
        this.f443344c = r102;
        this.f443345d = r103;
    }
}
