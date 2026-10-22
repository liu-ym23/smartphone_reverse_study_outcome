package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDialogCommonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f326659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f326660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f326661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f326662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f326663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f326664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f326665g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326659a;
    }

    public static LarusDialogCommonBinding a(View r110) {
        int r100 = R.id.cancel;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r110, R.id.cancel);
        if (r101 == null) goto L17;
        r100 = R.id.confirm;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r110, R.id.confirm);
        if (r102 == null) goto L17;
        r100 = R.id.dialog_message;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r110, R.id.dialog_message);
        if (r103 == null) goto L17;
        r100 = R.id.dialog_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r110, R.id.dialog_title);
        if (r104 == null) goto L17;
        r100 = R.id.dialog_top_image;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.dialog_top_image);
        if (r105 == null) goto L17;
        r100 = R.id.divider;
        View r106 = ViewBindings.findChildViewById(r110, R.id.divider);
        if (r106 == null) goto L17;
        return new LarusDialogCommonBinding((LinearLayout) r110, r101, r102, r103, r104, r105, r106);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusDialogCommonBinding(LinearLayout r100, TextView r101, TextView r102, TextView r103, TextView r104, SimpleDraweeView r105, View r106) {
        this.f326659a = r100;
        this.f326660b = r101;
        this.f326661c = r102;
        this.f326662d = r103;
        this.f326663e = r104;
        this.f326664f = r105;
        this.f326665g = r106;
    }
}
