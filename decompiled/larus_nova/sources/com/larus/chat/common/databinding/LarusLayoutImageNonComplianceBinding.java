package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutImageNonComplianceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f324000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f324001b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324000a;
    }

    public LarusLayoutImageNonComplianceBinding(LinearLayout r100, AppCompatTextView r101) {
        this.f324000a = r100;
        this.f324001b = r101;
    }

    public static LarusLayoutImageNonComplianceBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_layout_image_non_compliance, r101, false);
        int r103 = R.id.non_compliance_img;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.non_compliance_img)) == null) goto L9;
        r103 = R.id.non_compliance_txt;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.non_compliance_txt);
        if (r104 == null) goto L9;
        return new LarusLayoutImageNonComplianceBinding((LinearLayout) r102, r104);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
