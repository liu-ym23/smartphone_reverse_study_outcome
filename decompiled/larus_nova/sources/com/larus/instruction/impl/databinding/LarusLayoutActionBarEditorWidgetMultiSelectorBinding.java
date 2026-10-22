package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutActionBarEditorWidgetMultiSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f351586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HorizontalScrollView f351587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f351588e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351584a;
    }

    public static LarusLayoutActionBarEditorWidgetMultiSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L16;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_multi_selector, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L14;
        r102 = R.id.multi_selector_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.multi_selector_container);
        if (r104 == null) goto L14;
        r102 = R.id.multi_selector_scroll_view;
        HorizontalScrollView r105 = (HorizontalScrollView) ViewBindings.findChildViewById(r101, R.id.multi_selector_scroll_view);
        if (r105 == null) goto L14;
        r102 = R.id.multi_selector_sub_title;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.multi_selector_sub_title);
        if (r106 == null) goto L14;
        return new LarusLayoutActionBarEditorWidgetMultiSelectorBinding(r101, r103, r104, r105, r106);
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L16:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetMultiSelectorBinding(View r100, View r101, LinearLayout r102, HorizontalScrollView r103, AppCompatTextView r104) {
        this.f351584a = r100;
        this.f351585b = r101;
        this.f351586c = r102;
        this.f351587d = r103;
        this.f351588e = r104;
    }
}
