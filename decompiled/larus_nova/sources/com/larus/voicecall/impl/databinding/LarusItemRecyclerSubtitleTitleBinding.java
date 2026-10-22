package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusItemRecyclerSubtitleTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f378245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f378246b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378245a;
    }

    public LarusItemRecyclerSubtitleTitleBinding(FrameLayout r100, TextView r101) {
        this.f378245a = r100;
        this.f378246b = r101;
    }
}
