package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemResearchBannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358495b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358494a;
    }

    public LarusBlockItemResearchBannerBinding(LinearLayout r100, TextView r101) {
        this.f358494a = r100;
        this.f358495b = r101;
    }
}
