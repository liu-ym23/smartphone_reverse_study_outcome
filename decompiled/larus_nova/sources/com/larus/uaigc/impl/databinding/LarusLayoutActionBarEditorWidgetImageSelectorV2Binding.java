package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLayoutActionBarEditorWidgetImageSelectorV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f373205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f373206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f373207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f373208e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373204a;
    }

    public static LarusLayoutActionBarEditorWidgetImageSelectorV2Binding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L16;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_image_selector_v2, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L14;
        r102 = R.id.img_photo_template;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.img_photo_template);
        if (r104 == null) goto L14;
        r102 = R.id.share_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.share_container);
        if (r105 == null) goto L14;
        r102 = R.id.tv_img_selector_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.tv_img_selector_title);
        if (r106 == null) goto L14;
        return new LarusLayoutActionBarEditorWidgetImageSelectorV2Binding(r101, r103, r104, r105, r106);
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L16:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding(View r100, View r101, RecyclerView r102, FrameLayout r103, TextView r104) {
        this.f373204a = r100;
        this.f373205b = r101;
        this.f373206c = r102;
        this.f373207d = r103;
        this.f373208e = r104;
    }
}
