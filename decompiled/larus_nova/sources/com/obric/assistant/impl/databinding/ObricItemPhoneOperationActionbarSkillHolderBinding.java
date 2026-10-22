package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricItemPhoneOperationActionbarSkillHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundConstraintLayout f389600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f389601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GradientTextView f389602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f389603d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389600a;
    }

    public ObricItemPhoneOperationActionbarSkillHolderBinding(RoundConstraintLayout r100, AppCompatImageView r101, GradientTextView r102, TextView r103) {
        this.f389600a = r100;
        this.f389601b = r101;
        this.f389602c = r102;
        this.f389603d = r103;
    }
}
