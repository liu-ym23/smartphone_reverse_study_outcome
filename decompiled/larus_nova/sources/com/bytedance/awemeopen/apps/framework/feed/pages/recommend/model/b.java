package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f195169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f195170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f195171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f195172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStoreOwner f195173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f195174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f195175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f195176h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f195169a, r101.f195169a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f195170b, r101.f195170b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f195171c, r101.f195171c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f195172d, r101.f195172d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f195173e, r101.f195173e) == true) goto L24;
        return false;
    L24:
        if (this.f195174f == r101.f195174f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f195175g, r101.f195175g) == true) goto L30;
        return false;
    L30:
        if (this.f195176h == r101.f195176h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public final int hashCode() {
        int r100 = ((((((((this.f195169a.hashCode() * 31) + this.f195170b.hashCode()) * 31) + this.f195171c.hashCode()) * 31) + this.f195172d.hashCode()) * 31) + this.f195173e.hashCode()) * 31;
        boolean r101 = this.f195174f;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((((r100 + r102) * 31) + this.f195175g.hashCode()) * 31) + this.f195176h;
    }

    public final String toString() {
        return "AosPageOwner(activity=" + this.f195169a + ", rootView=" + this.f195170b + ", viewPager=" + this.f195171c + ", lifecycleOwner=" + this.f195172d + ", viewModelStoreOwner=" + this.f195173e + ", isMultiTab=" + this.f195174f + ", extraMap=" + this.f195175g + ", writeCommentHeight=" + this.f195176h + ')';
    }

    public final Activity getActivity() {
        return this.f195169a;
    }

    public b(Activity r100, View r101, ViewGroup r102, LifecycleOwner r103, ViewModelStoreOwner r104, boolean r105, Map<String, Object> r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "viewPager");
        Intrinsics.checkNotNullParameter(r103, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r106, "extraMap");
        this.f195169a = r100;
        this.f195170b = r101;
        this.f195171c = r102;
        this.f195172d = r103;
        this.f195173e = r104;
        this.f195174f = r105;
        this.f195175g = r106;
        this.f195176h = r107;
    }

    public /* synthetic */ b(Activity r110, View r111, ViewGroup r112, LifecycleOwner r113, ViewModelStoreOwner r114, Map r115, int r116, int r117) {
        if ((r117 & 64) == 0) goto L5;
        Map r100 = new LinkedHashMap();
    L7:
        if ((r117 & 128) == 0) goto L9;
        int r101 = 0;
    L10:
        this(r110, r111, r112, r113, r114, false, r100, r101);
        return;
    L9:
        r101 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
