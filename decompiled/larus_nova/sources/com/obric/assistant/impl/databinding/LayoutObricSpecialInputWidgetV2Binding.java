package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes33.dex */
public final class LayoutObricSpecialInputWidgetV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f389443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f389444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f389445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f389446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f389447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HorizontalScrollView f389448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f389449g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389443a;
    }

    public static LayoutObricSpecialInputWidgetV2Binding a(LayoutInflater r100, ViewGroup r110) {
        if (r110 == null) goto L24;
        r100.inflate(R.layout.layout_obric_special_input_widget_v2, r110);
        int r101 = R.id.layout_resource_bar_special_input_holder;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.layout_resource_bar_special_input_holder);
        if (r102 == null) goto L22;
        r101 = R.id.layout_special_input_primary_content_holder;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.layout_special_input_primary_content_holder);
        if (r103 == null) goto L22;
        r101 = R.id.multi_selector_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.multi_selector_container);
        if (r104 == null) goto L22;
        r101 = R.id.obric_special_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r110, R.id.obric_special_container)) == null) goto L22;
        r101 = R.id.obric_special_input_left_icon;
        if (((LinearLayout) ViewBindings.findChildViewById(r110, R.id.obric_special_input_left_icon)) == null) goto L22;
        r101 = R.id.special_input_divider;
        View r105 = ViewBindings.findChildViewById(r110, R.id.special_input_divider);
        if (r105 == null) goto L22;
        r101 = R.id.task_instruction_scroll_view;
        HorizontalScrollView r106 = (HorizontalScrollView) ViewBindings.findChildViewById(r110, R.id.task_instruction_scroll_view);
        if (r106 == null) goto L22;
        r101 = R.id.text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.text);
        if (r107 == null) goto L22;
        return new LayoutObricSpecialInputWidgetV2Binding(r110, r102, r103, r104, r105, r106, r107);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r101)));
    L24:
        throw new NullPointerException("parent");
    }

    public LayoutObricSpecialInputWidgetV2Binding(View r100, FrameLayout r101, FrameLayout r102, LinearLayout r103, View r104, HorizontalScrollView r105, AppCompatTextView r106) {
        this.f389443a = r100;
        this.f389444b = r101;
        this.f389445c = r102;
        this.f389446d = r103;
        this.f389447e = r104;
        this.f389448f = r105;
        this.f389449g = r106;
    }
}
