package com.larus.agents.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusFragmentWorkExperienceDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f286628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f286629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f286630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f286631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f286632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f286633f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f286628a;
    }

    public LarusFragmentWorkExperienceDetailBinding(FrameLayout r100, ItemTextToggle r101, TextView r102, AppCompatImageView r103, ProgressBar r104, TextView r105) {
        this.f286628a = r100;
        this.f286629b = r101;
        this.f286630c = r102;
        this.f286631d = r103;
        this.f286632e = r104;
        this.f286633f = r105;
    }
}
