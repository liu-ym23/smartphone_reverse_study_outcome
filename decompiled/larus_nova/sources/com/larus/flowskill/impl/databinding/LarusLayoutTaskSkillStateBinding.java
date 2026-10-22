package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutTaskSkillStateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f343575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f343576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f343577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f343578d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343575a;
    }

    public static LarusLayoutTaskSkillStateBinding a(View r100) {
        int r101 = R.id.task_skill_state_action;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.task_skill_state_action);
        if (r102 == null) goto L11;
        r101 = R.id.task_skill_state_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.task_skill_state_icon);
        if (r103 == null) goto L11;
        r101 = R.id.task_skill_state_text;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.task_skill_state_text);
        if (r104 == null) goto L11;
        return new LarusLayoutTaskSkillStateBinding((LinearLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutTaskSkillStateBinding(LinearLayout r100, AppCompatTextView r101, AppCompatImageView r102, AppCompatTextView r103) {
        this.f343575a = r100;
        this.f343576b = r101;
        this.f343577c = r102;
        this.f343578d = r103;
    }
}
