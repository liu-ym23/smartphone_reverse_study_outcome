package com.bytedance.ee.bear.bitable.homepage.list.newlist;

import com.bytedance.ee.bear.workspace.HomepageListType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HomepageListType f212837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f212838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f212839c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f212837a == r101.f212837a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f212838b, r101.f212838b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f212839c, r101.f212839c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f212837a.hashCode() * 31) + this.f212838b.hashCode()) * 31;
        Integer r101 = this.f212839c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FragmentMeta(type=" + this.f212837a + ", fragmentName=" + this.f212838b + ", titleResId=" + this.f212839c + ')';
    }

    public final HomepageListType getType() {
        return this.f212837a;
    }

    public e(HomepageListType r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "fragmentName");
        this.f212837a = r100;
        this.f212838b = r101;
        this.f212839c = r102;
    }
}
