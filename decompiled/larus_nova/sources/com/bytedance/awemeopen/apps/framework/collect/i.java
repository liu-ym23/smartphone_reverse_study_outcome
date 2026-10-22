package com.bytedance.awemeopen.apps.framework.collect;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f193986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserCollectViewModel f193987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f193988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f193989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AosUserCollectFragment f193990e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f193986a, r101.f193986a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f193987b, r101.f193987b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f193988c, r101.f193988c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f193989d, r101.f193989d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f193990e, r101.f193990e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f193986a.hashCode() * 31) + this.f193987b.hashCode()) * 31) + this.f193988c.hashCode()) * 31;
        FragmentActivity r101 = this.f193989d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f193990e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UserCollectPGParameters(fragmentView=" + this.f193986a + ", viewModel=" + this.f193987b + ", lifecycleOwner=" + this.f193988c + ", activity=" + this.f193989d + ", collectFragment=" + this.f193990e + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f193989d;
    }

    public i(View r100, UserCollectViewModel r101, LifecycleOwner r102, FragmentActivity r103, AosUserCollectFragment r104) {
        Intrinsics.checkNotNullParameter(r100, "fragmentView");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "collectFragment");
        this.f193986a = r100;
        this.f193987b = r101;
        this.f193988c = r102;
        this.f193989d = r103;
        this.f193990e = r104;
    }
}
