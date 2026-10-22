package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCreateMenuItemLayoutV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f326633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f326634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f326635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f326636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f326637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f326638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f326639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f326640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f326641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDraweeView f326642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SimpleDraweeView f326643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinearLayout f326644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f326645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout f326646o;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326632a;
    }

    public static LarusCreateMenuItemLayoutV2Binding a(LayoutInflater r110, ViewGroup r111) {
        r110.inflate(R.layout.larus_create_menu_item_layout_v2, r111);
        int r100 = R.id.blue_tag_icon;
        SimpleDraweeView r101 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.blue_tag_icon);
        if (r101 == null) goto L33;
        r100 = R.id.blue_tag_layout;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.blue_tag_layout);
        if (r102 == null) goto L33;
        r100 = R.id.blue_tag_text;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r111, R.id.blue_tag_text);
        if (r103 == null) goto L33;
        r100 = R.id.menu_icon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.menu_icon);
        if (r104 == null) goto L33;
        r100 = R.id.menu_left_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.menu_left_container);
        if (r105 == null) goto L33;
        r100 = R.id.menu_right_container;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.menu_right_container);
        if (r106 == null) goto L33;
        r100 = R.id.menu_right_text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r111, R.id.menu_right_text);
        if (r107 == null) goto L33;
        r100 = R.id.menu_sub_text;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r111, R.id.menu_sub_text);
        if (r108 == null) goto L33;
        r100 = R.id.menu_text;
        AppCompatTextView r112 = (AppCompatTextView) ViewBindings.findChildViewById(r111, R.id.menu_text);
        if (r112 == null) goto L33;
        r100 = R.id.menu_text_icon;
        SimpleDraweeView r113 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.menu_text_icon);
        if (r113 == null) goto L33;
        r100 = R.id.menu_title_icon;
        SimpleDraweeView r114 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.menu_title_icon);
        if (r114 == null) goto L33;
        r100 = R.id.menu_title_row;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.menu_title_row);
        if (r115 == null) goto L33;
        r100 = R.id.tv_menu_item_tag;
        AppCompatTextView r116 = (AppCompatTextView) ViewBindings.findChildViewById(r111, R.id.tv_menu_item_tag);
        if (r116 == null) goto L33;
        r100 = R.id.tv_menu_item_tag_layout;
        FrameLayout r117 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.tv_menu_item_tag_layout);
        if (r117 == null) goto L33;
        return new LarusCreateMenuItemLayoutV2Binding(r111, r101, r102, r103, r104, r105, r106, r107, r108, r112, r113, r114, r115, r116, r117);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    public LarusCreateMenuItemLayoutV2Binding(View r100, SimpleDraweeView r101, LinearLayout r102, AppCompatTextView r103, SimpleDraweeView r104, FrameLayout r105, LinearLayout r106, AppCompatTextView r107, AppCompatTextView r108, AppCompatTextView r110, SimpleDraweeView r111, SimpleDraweeView r112, LinearLayout r113, AppCompatTextView r114, FrameLayout r115) {
        this.f326632a = r100;
        this.f326633b = r101;
        this.f326634c = r102;
        this.f326635d = r103;
        this.f326636e = r104;
        this.f326637f = r105;
        this.f326638g = r106;
        this.f326639h = r107;
        this.f326640i = r108;
        this.f326641j = r110;
        this.f326642k = r111;
        this.f326643l = r112;
        this.f326644m = r113;
        this.f326645n = r114;
        this.f326646o = r115;
    }
}
