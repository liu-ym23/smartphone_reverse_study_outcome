package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes37.dex */
public final class ViewPickerSelectedMoreBinding implements ViewBinding {
    public final CommonRecyclerView moreList;
    private final LinearLayout rootView;
    public final CommonTitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPickerSelectedMoreBinding bind(View r100) {
        int r101 = R.id.more_list;
        CommonRecyclerView r102 = (CommonRecyclerView) ViewBindings.findChildViewById(r100, R.id.more_list);
        if (r102 == null) goto L9;
        r101 = R.id.title_bar;
        CommonTitleBar r103 = (CommonTitleBar) ViewBindings.findChildViewById(r100, R.id.title_bar);
        if (r103 == null) goto L9;
        return new ViewPickerSelectedMoreBinding((LinearLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ViewPickerSelectedMoreBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private ViewPickerSelectedMoreBinding(LinearLayout r100, CommonRecyclerView r101, CommonTitleBar r102) {
        this.rootView = r100;
        this.moreList = r101;
        this.titleBar = r102;
    }

    public static ViewPickerSelectedMoreBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_picker_selected_more, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
