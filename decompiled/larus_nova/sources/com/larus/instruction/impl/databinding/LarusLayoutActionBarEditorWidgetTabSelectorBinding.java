package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutActionBarEditorWidgetTabSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f351591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TabLayout f351592d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351589a;
    }

    public static LarusLayoutActionBarEditorWidgetTabSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L14;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_tab_selector, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L12;
        r102 = R.id.tab_selector_sub_title;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.tab_selector_sub_title);
        if (r104 == null) goto L12;
        r102 = R.id.tl_switch_tab;
        TabLayout r105 = (TabLayout) ViewBindings.findChildViewById(r101, R.id.tl_switch_tab);
        if (r105 == null) goto L12;
        return new LarusLayoutActionBarEditorWidgetTabSelectorBinding(r101, r103, r104, r105);
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L14:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetTabSelectorBinding(View r100, View r101, AppCompatTextView r102, TabLayout r103) {
        this.f351589a = r100;
        this.f351590b = r101;
        this.f351591c = r102;
        this.f351592d = r103;
    }
}
