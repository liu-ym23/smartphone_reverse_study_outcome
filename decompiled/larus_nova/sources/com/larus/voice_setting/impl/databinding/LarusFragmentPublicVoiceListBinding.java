package com.larus.voice_setting.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusFragmentPublicVoiceListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f376103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusOtherProfileVoiceListEmptyBinding f376104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f376105c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376103a;
    }

    public LarusFragmentPublicVoiceListBinding(ConstraintLayout r100, LarusOtherProfileVoiceListEmptyBinding r101, RecyclerView r102) {
        this.f376103a = r100;
        this.f376104b = r101;
        this.f376105c = r102;
    }
}
