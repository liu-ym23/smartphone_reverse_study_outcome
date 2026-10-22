package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f247885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f247886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f247887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CacheType f247888d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f247885a, r101.f247885a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247886b, r101.f247886b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f247887c, r101.f247887c) == true) goto L18;
        return false;
    L18:
        if (this.f247888d == r101.f247888d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f247885a.hashCode() * 31) + this.f247886b.hashCode()) * 31) + this.f247887c.hashCode()) * 31) + this.f247888d.hashCode();
    }

    public final String toString() {
        return "CacheItem(originSchema=" + this.f247885a + ", uniqueSchema=" + this.f247886b + ", view=" + this.f247887c + ", cacheType=" + this.f247888d + ')';
    }

    public e(Uri r100, Uri r101, BulletContainerView r102, CacheType r103) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Intrinsics.checkNotNullParameter(r101, "uniqueSchema");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "cacheType");
        this.f247885a = r100;
        this.f247886b = r101;
        this.f247887c = r102;
        this.f247888d = r103;
    }
}
