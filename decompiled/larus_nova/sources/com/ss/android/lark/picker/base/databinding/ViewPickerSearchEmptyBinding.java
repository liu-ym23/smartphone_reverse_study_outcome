package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ViewPickerSearchEmptyBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView searchEmptyHint;
    public final AppCompatImageView searchEmptyIv;
    public final LinearLayout searchResultEmpty;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPickerSearchEmptyBinding bind(View r100) {
        int r101 = R.id.search_empty_hint;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.search_empty_hint);
        if (r102 == null) goto L9;
        r101 = R.id.search_empty_iv;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.search_empty_iv);
        if (r103 == null) goto L9;
        LinearLayout r104 = (LinearLayout) r100;
        return new ViewPickerSearchEmptyBinding(r104, r102, r103, r104);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ViewPickerSearchEmptyBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ViewPickerSearchEmptyBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_picker_search_empty, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ViewPickerSearchEmptyBinding(LinearLayout r100, TextView r101, AppCompatImageView r102, LinearLayout r103) {
        this.rootView = r100;
        this.searchEmptyHint = r101;
        this.searchEmptyIv = r102;
        this.searchResultEmpty = r103;
    }
}
