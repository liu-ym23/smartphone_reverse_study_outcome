package com.larus.gallery.api;

import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGalleryDataSource<T> f343846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f343848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f343849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f343850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<ProviderType, t<T>> f343851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f343852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<Object> f343853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function4<Object, FragmentActivity, Boolean, Integer, Unit> f343854i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f343846a, r101.f343846a) == true) goto L12;
        return false;
    L12:
        if (this.f343847b == r101.f343847b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343848c, r101.f343848c) == true) goto L18;
        return false;
    L18:
        if (this.f343849d == r101.f343849d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f343850e, r101.f343850e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f343851f, r101.f343851f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f343852g, r101.f343852g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f343853h, r101.f343853h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f343854i, r101.f343854i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f343846a.hashCode() * 31) + this.f343847b) * 31) + this.f343848c.hashCode()) * 31;
        if (this.f343849d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        i r103 = this.f343850e;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r102 + r105) * 31) + this.f343851f.hashCode()) * 31;
        Object r107 = this.f343852g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f343853h.hashCode()) * 31;
        Function4<Object, FragmentActivity, Boolean, Integer, Unit> r110 = this.f343854i;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "GalleryConfig(dataSource=" + this.f343846a + ", initialPosition=" + this.f343847b + ", displayConfig=" + this.f343848c + ", initialMuted=" + this.f343849d + ", customHolderFactory=" + this.f343850e + ", providers=" + this.f343851f + ", statusBarCallbackSource=" + this.f343852g + ", statusBarCallbackSources=" + this.f343853h + ", onShowStatusBar=" + this.f343854i + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(IGalleryDataSource<T> r100, int r101, b r102, boolean r103, i r104, HashMap<ProviderType, t<T>> r105, Object r106, Set<? extends Object> r107, Function4<Object, ? super FragmentActivity, ? super Boolean, ? super Integer, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r102, "displayConfig");
        Intrinsics.checkNotNullParameter(r105, "providers");
        Intrinsics.checkNotNullParameter(r107, "statusBarCallbackSources");
        this.f343846a = r100;
        this.f343847b = r101;
        this.f343848c = r102;
        this.f343849d = r103;
        this.f343850e = r104;
        this.f343851f = r105;
        this.f343852g = r106;
        this.f343853h = r107;
        this.f343854i = r110;
    }
}
