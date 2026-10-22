package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusSubtitleInterpretDropdownListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f378312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f378313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f378314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f378315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f378316e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378312a;
    }

    public static LarusSubtitleInterpretDropdownListBinding a(View r100) {
        int r101 = R.id.icon_arrow;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.icon_arrow);
        if (r102 == null) goto L13;
        r101 = R.id.interpret_item;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.interpret_item);
        if (r103 == null) goto L13;
        r101 = R.id.tv_drop_down_label;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tv_drop_down_label);
        if (r104 == null) goto L13;
        r101 = R.id.tv_selected_option;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tv_selected_option);
        if (r105 == null) goto L13;
        return new LarusSubtitleInterpretDropdownListBinding((ConstraintLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusSubtitleInterpretDropdownListBinding(ConstraintLayout r100, AppCompatImageView r101, LinearLayout r102, AppCompatTextView r103, AppCompatTextView r104) {
        this.f378312a = r100;
        this.f378313b = r101;
        this.f378314c = r102;
        this.f378315d = r103;
        this.f378316e = r104;
    }
}
