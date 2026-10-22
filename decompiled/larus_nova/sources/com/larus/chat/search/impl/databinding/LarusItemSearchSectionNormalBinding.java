package com.larus.chat.search.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemSearchSectionNormalBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f325579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f325580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RedDotTextView f325581c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325579a;
    }

    public static LarusItemSearchSectionNormalBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_search_section_normal, r101, false);
        int r103 = R.id.section_name_text;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.section_name_text);
        if (r104 == null) goto L9;
        r103 = R.id.section_unread_red_dot;
        RedDotTextView r105 = (RedDotTextView) ViewBindings.findChildViewById(r102, R.id.section_unread_red_dot);
        if (r105 == null) goto L9;
        return new LarusItemSearchSectionNormalBinding((ConstraintLayout) r102, r104, r105);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemSearchSectionNormalBinding(ConstraintLayout r100, AppCompatTextView r101, RedDotTextView r102) {
        this.f325579a = r100;
        this.f325580b = r101;
        this.f325581c = r102;
    }
}
