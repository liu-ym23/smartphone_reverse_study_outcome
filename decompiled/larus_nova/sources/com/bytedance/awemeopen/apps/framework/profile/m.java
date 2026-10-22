package com.bytedance.awemeopen.apps.framework.profile;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f197361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserProfileViewModel f197362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f197363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f197364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AosUserProfileFragment f197365e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f197361a, r101.f197361a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f197362b, r101.f197362b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f197363c, r101.f197363c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f197364d, r101.f197364d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f197365e, r101.f197365e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f197361a.hashCode() * 31) + this.f197362b.hashCode()) * 31) + this.f197363c.hashCode()) * 31;
        FragmentActivity r101 = this.f197364d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f197365e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UserProfilePGParameters(fragmentView=" + this.f197361a + ", viewModel=" + this.f197362b + ", lifecycleOwner=" + this.f197363c + ", activity=" + this.f197364d + ", profileFragment=" + this.f197365e + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f197364d;
    }

    public m(View r100, UserProfileViewModel r101, LifecycleOwner r102, FragmentActivity r103, AosUserProfileFragment r104) {
        Intrinsics.checkNotNullParameter(r100, "fragmentView");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "profileFragment");
        this.f197361a = r100;
        this.f197362b = r101;
        this.f197363c = r102;
        this.f197364d = r103;
        this.f197365e = r104;
    }
}
