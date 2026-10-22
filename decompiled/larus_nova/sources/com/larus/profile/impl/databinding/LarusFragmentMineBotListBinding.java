package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentMineBotListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusItemProfileBotListEmptyBinding f366442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f366443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusItemProfileUserBannedBinding f366444d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366441a;
    }

    public LarusFragmentMineBotListBinding(ConstraintLayout r100, LarusItemProfileBotListEmptyBinding r101, RecyclerView r102, LarusItemProfileUserBannedBinding r103) {
        this.f366441a = r100;
        this.f366442b = r101;
        this.f366443c = r102;
        this.f366444d = r103;
    }
}
