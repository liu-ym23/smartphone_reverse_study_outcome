package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraLayoutRuleMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f332778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f332779d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332776a;
    }

    public static LarusDoraLayoutRuleMenuBinding a(LayoutInflater r100) {
        View r101 = r100.inflate(R.layout.larus_dora_layout_rule_menu, null, false);
        int r102 = R.id.delete_btn;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.delete_btn);
        if (r103 == null) goto L11;
        r102 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r101, R.id.divider);
        if (r104 == null) goto L11;
        r102 = R.id.edit_btn;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.edit_btn);
        if (r105 == null) goto L11;
        return new LarusDoraLayoutRuleMenuBinding((ConstraintLayout) r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public LarusDoraLayoutRuleMenuBinding(ConstraintLayout r100, LinearLayout r101, View r102, LinearLayout r103) {
        this.f332776a = r100;
        this.f332777b = r101;
        this.f332778c = r102;
        this.f332779d = r103;
    }
}
