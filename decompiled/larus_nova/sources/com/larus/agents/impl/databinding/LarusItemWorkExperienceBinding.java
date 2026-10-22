package com.larus.agents.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusItemWorkExperienceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f286652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f286653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f286654c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f286652a;
    }

    public static LarusItemWorkExperienceBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_work_experience, r101, false);
        int r103 = R.id.work_experience_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.work_experience_arrow)) == null) goto L11;
        r103 = R.id.work_experience_divider;
        View r104 = ViewBindings.findChildViewById(r102, R.id.work_experience_divider);
        if (r104 == null) goto L11;
        r103 = R.id.work_experience_name;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.work_experience_name);
        if (r105 == null) goto L11;
        return new LarusItemWorkExperienceBinding((ConstraintLayout) r102, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemWorkExperienceBinding(ConstraintLayout r100, View r101, TextView r102) {
        this.f286652a = r100;
        this.f286653b = r101;
        this.f286654c = r102;
    }
}
