package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.Content;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f311602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Content> f311603b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f311602a == r101.f311602a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f311603b, r101.f311603b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f311602a * 31;
        List<Content> r101 = this.f311603b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RecommendVideoContentListWrapper(code=" + this.f311602a + ", contentList=" + this.f311603b + ')';
    }

    public v(int r100, List<Content> r101) {
        this.f311602a = r100;
        this.f311603b = r101;
    }
}
