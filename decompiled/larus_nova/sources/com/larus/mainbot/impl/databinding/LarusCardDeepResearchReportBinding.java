package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCardDeepResearchReportBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f358520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f358521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CustomMarkdownTextView f358523e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358519a;
    }

    public LarusCardDeepResearchReportBinding(ConstraintLayout r100, View r101, FrameLayout r102, TextView r103, CustomMarkdownTextView r104) {
        this.f358519a = r100;
        this.f358520b = r101;
        this.f358521c = r102;
        this.f358522d = r103;
        this.f358523e = r104;
    }
}
