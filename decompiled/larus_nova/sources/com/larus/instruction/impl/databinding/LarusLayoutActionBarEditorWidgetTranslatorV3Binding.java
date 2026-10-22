package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutActionBarEditorWidgetTranslatorV3Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusItemActionbarDropdownListBinding f351604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusItemActionbarDropdownListBinding f351605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusItemActionbarDropdownListBinding f351606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f351607f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351602a;
    }

    public static LarusLayoutActionBarEditorWidgetTranslatorV3Binding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L20;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_translator_v3, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L18;
        r102 = R.id.icon_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.icon_arrow)) == null) goto L18;
        r102 = R.id.language_source_selector;
        View r104 = ViewBindings.findChildViewById(r101, R.id.language_source_selector);
        if (r104 == null) goto L18;
        LarusItemActionbarDropdownListBinding r105 = LarusItemActionbarDropdownListBinding.a(r104);
        r102 = R.id.language_target_selector;
        View r106 = ViewBindings.findChildViewById(r101, R.id.language_target_selector);
        if (r106 == null) goto L18;
        LarusItemActionbarDropdownListBinding r107 = LarusItemActionbarDropdownListBinding.a(r106);
        r102 = R.id.mode_selector;
        View r108 = ViewBindings.findChildViewById(r101, R.id.mode_selector);
        if (r108 == null) goto L18;
        LarusItemActionbarDropdownListBinding r109 = LarusItemActionbarDropdownListBinding.a(r108);
        r102 = R.id.translator_sub_title;
        AppCompatTextView r110 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.translator_sub_title);
        if (r110 == null) goto L18;
        return new LarusLayoutActionBarEditorWidgetTranslatorV3Binding(r101, r103, r105, r107, r109, r110);
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L20:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetTranslatorV3Binding(View r100, View r101, LarusItemActionbarDropdownListBinding r102, LarusItemActionbarDropdownListBinding r103, LarusItemActionbarDropdownListBinding r104, AppCompatTextView r105) {
        this.f351602a = r100;
        this.f351603b = r101;
        this.f351604c = r102;
        this.f351605d = r103;
        this.f351606e = r104;
        this.f351607f = r105;
    }
}
