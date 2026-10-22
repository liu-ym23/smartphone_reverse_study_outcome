package com.bytedance.awemeopen.apps.framework.collect.works;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final View a;
    public final ViewGroup b;
    public final LifecycleOwner c;
    public final UserCollectWorksFragmentViewModel d;
    public final FragmentActivity e;
    public final Function0<String> f;

    public final FragmentActivity getActivity() {
        return this.e;
    }

    public a(View r2, ViewGroup r3, AosRecyclerListFragment r4, UserCollectWorksFragmentViewModel r5, FragmentActivity r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "vm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
