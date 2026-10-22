package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemSpotlightLoadingBinding implements ViewBinding {
    public final LinearLayout pickerNetLoadingFail;
    public final AppCompatImageView pickerNetLoadingFailIcon;
    public final LinearLayout pickerSpotlightLoading;
    private final FrameLayout rootView;
    public final FrameLayout searchLoadingContainer;
    public final AppCompatImageView searchNetLoadingIv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemSpotlightLoadingBinding bind(View r100) {
        int r101 = R.id.picker_net_loading_fail;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.picker_net_loading_fail);
        if (r102 == null) goto L13;
        r101 = R.id.picker_net_loading_fail_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.picker_net_loading_fail_icon);
        if (r103 == null) goto L13;
        r101 = R.id.picker_spotlight_loading;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.picker_spotlight_loading);
        if (r104 == null) goto L13;
        FrameLayout r105 = (FrameLayout) r100;
        r101 = R.id.search_net_loading_iv;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.search_net_loading_iv);
        if (r106 == null) goto L13;
        return new ItemSpotlightLoadingBinding(r105, r102, r103, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ItemSpotlightLoadingBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ItemSpotlightLoadingBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_spotlight_loading, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ItemSpotlightLoadingBinding(FrameLayout r100, LinearLayout r101, AppCompatImageView r102, LinearLayout r103, FrameLayout r104, AppCompatImageView r105) {
        this.rootView = r100;
        this.pickerNetLoadingFail = r101;
        this.pickerNetLoadingFailIcon = r102;
        this.pickerSpotlightLoading = r103;
        this.searchLoadingContainer = r104;
        this.searchNetLoadingIv = r105;
    }
}
