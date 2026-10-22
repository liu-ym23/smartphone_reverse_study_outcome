package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusScreenTinyMenuLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f326781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f326782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f326783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f326784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f326785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f326786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f326787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f326788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SimpleDraweeView f326789j;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326780a;
    }

    public static LarusScreenTinyMenuLayoutBinding a(View r110) {
        int r100 = R.id.divider;
        View r101 = ViewBindings.findChildViewById(r110, R.id.divider);
        if (r101 == null) goto L23;
        r100 = R.id.left_menu_layout;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.left_menu_layout);
        if (r102 == null) goto L23;
        r100 = R.id.left_menu_text;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.left_menu_text);
        if (r103 == null) goto L23;
        r100 = R.id.left_text_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r110, R.id.left_text_icon);
        if (r104 == null) goto L23;
        r100 = R.id.left_text_url_icon;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.left_text_url_icon);
        if (r105 == null) goto L23;
        r100 = R.id.right_menu_layout;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.right_menu_layout);
        if (r106 == null) goto L23;
        r100 = R.id.right_menu_text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.right_menu_text);
        if (r107 == null) goto L23;
        r100 = R.id.right_text_icon;
        ImageView r111 = (ImageView) ViewBindings.findChildViewById(r110, R.id.right_text_icon);
        if (r111 == null) goto L23;
        r100 = R.id.right_text_url_icon;
        SimpleDraweeView r112 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.right_text_url_icon);
        if (r112 == null) goto L23;
        return new LarusScreenTinyMenuLayoutBinding(r110, r101, r102, r103, r104, r105, r106, r107, r111, r112);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusScreenTinyMenuLayoutBinding(View r100, View r101, LinearLayout r102, AppCompatTextView r103, ImageView r104, SimpleDraweeView r105, LinearLayout r106, AppCompatTextView r107, ImageView r108, SimpleDraweeView r110) {
        this.f326780a = r100;
        this.f326781b = r101;
        this.f326782c = r102;
        this.f326783d = r103;
        this.f326784e = r104;
        this.f326785f = r105;
        this.f326786g = r106;
        this.f326787h = r107;
        this.f326788i = r108;
        this.f326789j = r110;
    }
}
