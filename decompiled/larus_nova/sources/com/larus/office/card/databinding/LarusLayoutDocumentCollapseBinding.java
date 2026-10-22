package com.larus.office.card.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutDocumentCollapseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f361344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f361345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f361346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f361347d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f361344a;
    }

    public static LarusLayoutDocumentCollapseBinding a(View r100) {
        int r101 = R.id.click_area;
        View r102 = ViewBindings.findChildViewById(r100, R.id.click_area);
        if (r102 == null) goto L13;
        ConstraintLayout r103 = (ConstraintLayout) r100;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r100, R.id.icon);
        if (r104 == null) goto L11;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r105 != null) goto L9;
        r101 = R.id.title;
        goto L13
    L9:
        return new LarusLayoutDocumentCollapseBinding(r103, r102, r104, r105);
    L11:
        r101 = R.id.icon;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutDocumentCollapseBinding(ConstraintLayout r100, View r101, ImageView r102, TextView r103) {
        this.f361344a = r100;
        this.f361345b = r101;
        this.f361346c = r102;
        this.f361347d = r103;
    }
}
