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
public final class LarusLayoutActionBarEditorWidgetTranslatorV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f351598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusItemActionbarDropdownListBinding f351599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusItemActionbarDropdownListBinding f351600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f351601e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351597a;
    }

    public static LarusLayoutActionBarEditorWidgetTranslatorV2Binding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L18;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_translator_v2, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L16;
        r102 = R.id.icon_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.icon_arrow)) == null) goto L16;
        r102 = R.id.language_source_selector;
        View r104 = ViewBindings.findChildViewById(r101, R.id.language_source_selector);
        if (r104 == null) goto L16;
        LarusItemActionbarDropdownListBinding r105 = LarusItemActionbarDropdownListBinding.a(r104);
        r102 = R.id.language_target_selector;
        View r106 = ViewBindings.findChildViewById(r101, R.id.language_target_selector);
        if (r106 == null) goto L16;
        LarusItemActionbarDropdownListBinding r107 = LarusItemActionbarDropdownListBinding.a(r106);
        r102 = R.id.translator_sub_title;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.translator_sub_title);
        if (r108 == null) goto L16;
        return new LarusLayoutActionBarEditorWidgetTranslatorV2Binding(r101, r103, r105, r107, r108);
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L18:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetTranslatorV2Binding(View r100, View r101, LarusItemActionbarDropdownListBinding r102, LarusItemActionbarDropdownListBinding r103, AppCompatTextView r104) {
        this.f351597a = r100;
        this.f351598b = r101;
        this.f351599c = r102;
        this.f351600d = r103;
        this.f351601e = r104;
    }
}
