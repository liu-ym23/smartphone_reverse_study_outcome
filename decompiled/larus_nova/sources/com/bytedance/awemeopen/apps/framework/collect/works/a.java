package com.bytedance.awemeopen.apps.framework.collect.works;

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
    public final View f194016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f194017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f194018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserCollectWorksFragmentViewModel f194019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f194020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f194021f;

    public final FragmentActivity getActivity() {
        return this.f194020e;
    }

    public a(View r100, ViewGroup r101, AosRecyclerListFragment r102, UserCollectWorksFragmentViewModel r103, FragmentActivity r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "vm");
        this.f194016a = r100;
        this.f194017b = r101;
        this.f194018c = r102;
        this.f194019d = r103;
        this.f194020e = r104;
        this.f194021f = r105;
    }
}
