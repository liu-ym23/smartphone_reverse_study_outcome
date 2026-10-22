package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.DeepResearchWebProgressBar;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCardDeepResearchWebBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f358525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f358526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DeepResearchWebProgressBar f358527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358528e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358524a;
    }

    public LarusCardDeepResearchWebBinding(ConstraintLayout r100, ConstraintLayout r101, AppCompatImageView r102, DeepResearchWebProgressBar r103, TextView r104) {
        this.f358524a = r100;
        this.f358525b = r101;
        this.f358526c = r102;
        this.f358527d = r103;
        this.f358528e = r104;
    }
}
