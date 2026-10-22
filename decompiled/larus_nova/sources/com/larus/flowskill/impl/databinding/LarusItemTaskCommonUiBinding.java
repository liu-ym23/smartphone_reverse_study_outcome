package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.taskskill.ui.PcDeviceAuthorizingLoadingView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemTaskCommonUiBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f343561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f343562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f343563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f343564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f343565f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343560a;
    }

    public static LarusItemTaskCommonUiBinding a(View r100) {
        int r101 = R.id.item_description;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.item_description);
        if (r102 == null) goto L27;
        r101 = R.id.item_divider;
        View r103 = ViewBindings.findChildViewById(r100, R.id.item_divider);
        if (r103 == null) goto L27;
        r101 = R.id.item_end_barrier;
        if (((Barrier) ViewBindings.findChildViewById(r100, R.id.item_end_barrier)) == null) goto L27;
        r101 = R.id.item_end_icon;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.item_end_icon)) == null) goto L27;
        r101 = R.id.item_end_label;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.item_end_label)) == null) goto L27;
        r101 = R.id.item_end_loading;
        if (((PcDeviceAuthorizingLoadingView) ViewBindings.findChildViewById(r100, R.id.item_end_loading)) == null) goto L27;
        r101 = R.id.item_left_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.item_left_icon);
        if (r104 == null) goto L27;
        r101 = R.id.item_main_name;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.item_main_name);
        if (r105 == null) goto L27;
        r101 = R.id.item_status_badge;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.item_status_badge);
        if (r106 == null) goto L27;
        r101 = R.id.item_status_badge_icon;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.item_status_badge_icon)) == null) goto L27;
        r101 = R.id.item_status_badge_text;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.item_status_badge_text)) == null) goto L27;
        return new LarusItemTaskCommonUiBinding((ConstraintLayout) r100, r102, r103, r104, r105, r106);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusItemTaskCommonUiBinding(ConstraintLayout r100, TextView r101, View r102, AppCompatImageView r103, TextView r104, LinearLayout r105) {
        this.f343560a = r100;
        this.f343561b = r101;
        this.f343562c = r102;
        this.f343563d = r103;
        this.f343564e = r104;
        this.f343565f = r105;
    }
}
