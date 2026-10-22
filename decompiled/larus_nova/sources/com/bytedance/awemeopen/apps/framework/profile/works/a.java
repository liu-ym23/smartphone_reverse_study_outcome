package com.bytedance.awemeopen.apps.framework.profile.works;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f197573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f197574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f197575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserProfileWorksFragmentViewModel f197576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f197577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f197578f;

    public final FragmentActivity getActivity() {
        return this.f197577e;
    }

    public a(View r100, ViewGroup r101, AosRecyclerListFragment r102, UserProfileWorksFragmentViewModel r103, FragmentActivity r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "vm");
        this.f197573a = r100;
        this.f197574b = r101;
        this.f197575c = r102;
        this.f197576d = r103;
        this.f197577e = r104;
        this.f197578f = r105;
    }
}
