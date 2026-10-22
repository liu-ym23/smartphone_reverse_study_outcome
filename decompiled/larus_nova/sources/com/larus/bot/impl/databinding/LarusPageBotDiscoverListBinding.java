package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bot.impl.common.view.BlockBringChildSwipeRefreshLayout;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotDiscoverListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f317916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f317917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BlockBringChildSwipeRefreshLayout f317918d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317915a;
    }

    public LarusPageBotDiscoverListBinding(ConstraintLayout r100, RecyclerView r101, LinearLayout r102, BlockBringChildSwipeRefreshLayout r103) {
        this.f317915a = r100;
        this.f317916b = r101;
        this.f317917c = r102;
        this.f317918d = r103;
    }
}
