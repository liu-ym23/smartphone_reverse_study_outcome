package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutActionBarEditorWidgetDropdownSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f351568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f351569d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351566a;
    }

    public static LarusLayoutActionBarEditorWidgetDropdownSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L14;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_dropdown_selector, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L12;
        r102 = R.id.drop_down_selector;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.drop_down_selector);
        if (r104 == null) goto L12;
        r102 = R.id.tv_drop_down_selector_sub_title;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.tv_drop_down_selector_sub_title);
        if (r105 == null) goto L12;
        return new LarusLayoutActionBarEditorWidgetDropdownSelectorBinding(r101, r103, r104, r105);
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L14:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetDropdownSelectorBinding(View r100, View r101, RecyclerView r102, AppCompatTextView r103) {
        this.f351566a = r100;
        this.f351567b = r101;
        this.f351568c = r102;
        this.f351569d = r103;
    }
}
