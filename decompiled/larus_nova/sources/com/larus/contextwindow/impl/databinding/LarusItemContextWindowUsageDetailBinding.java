package com.larus.contextwindow.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusItemContextWindowUsageDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f330339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f330340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f330341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f330342d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f330339a;
    }

    public static LarusItemContextWindowUsageDetailBinding a(View r100) {
        int r101 = R.id.context_window_detail_dot;
        View r102 = ViewBindings.findChildViewById(r100, R.id.context_window_detail_dot);
        if (r102 == null) goto L11;
        r101 = R.id.context_window_detail_percent;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.context_window_detail_percent);
        if (r103 == null) goto L11;
        r101 = R.id.context_window_detail_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.context_window_detail_title);
        if (r104 == null) goto L11;
        return new LarusItemContextWindowUsageDetailBinding((LinearLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusItemContextWindowUsageDetailBinding(LinearLayout r100, View r101, TextView r102, TextView r103) {
        this.f330339a = r100;
        this.f330340b = r101;
        this.f330341c = r102;
        this.f330342d = r103;
    }
}
