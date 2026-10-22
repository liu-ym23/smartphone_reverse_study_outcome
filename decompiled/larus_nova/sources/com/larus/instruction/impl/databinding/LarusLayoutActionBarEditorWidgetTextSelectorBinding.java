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
public final class LarusLayoutActionBarEditorWidgetTextSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f351595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f351596d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351593a;
    }

    public static LarusLayoutActionBarEditorWidgetTextSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L14;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_text_selector, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L12;
        r102 = R.id.text_selector;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.text_selector);
        if (r104 == null) goto L12;
        r102 = R.id.tv_text_selector_sub_title;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.tv_text_selector_sub_title);
        if (r105 == null) goto L12;
        return new LarusLayoutActionBarEditorWidgetTextSelectorBinding(r101, r103, r104, r105);
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L14:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetTextSelectorBinding(View r100, View r101, RecyclerView r102, AppCompatTextView r103) {
        this.f351593a = r100;
        this.f351594b = r101;
        this.f351595c = r102;
        this.f351596d = r103;
    }
}
