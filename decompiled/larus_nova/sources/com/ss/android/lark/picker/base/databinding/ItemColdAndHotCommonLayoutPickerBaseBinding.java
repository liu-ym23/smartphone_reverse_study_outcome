package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.CommonIconFrontTextView;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemColdAndHotCommonLayoutPickerBaseBinding implements ViewBinding {
    public final ProgressBar coldAndHotLoadingProgressbar;
    public final CommonIconFrontTextView coldAndHotTipText;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding bind(View r100) {
        int r101 = R.id.cold_and_hot_loading_progressbar;
        ProgressBar r102 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.cold_and_hot_loading_progressbar);
        if (r102 == null) goto L9;
        r101 = R.id.cold_and_hot_tip_text;
        CommonIconFrontTextView r103 = (CommonIconFrontTextView) ViewBindings.findChildViewById(r100, R.id.cold_and_hot_tip_text);
        if (r103 == null) goto L9;
        return new ItemColdAndHotCommonLayoutPickerBaseBinding((ConstraintLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private ItemColdAndHotCommonLayoutPickerBaseBinding(ConstraintLayout r100, ProgressBar r101, CommonIconFrontTextView r102) {
        this.rootView = r100;
        this.coldAndHotLoadingProgressbar = r101;
        this.coldAndHotTipText = r102;
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_cold_and_hot_common_layout_picker_base, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
