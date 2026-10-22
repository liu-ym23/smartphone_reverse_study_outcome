package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemCardRecommendHeaderForListPickerBaseBinding implements ViewBinding {
    public final AppCompatImageView more;
    private final RelativeLayout rootView;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding bind(View r100) {
        int r101 = R.id.more;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.more);
        if (r102 == null) goto L9;
        r101 = R.id.title;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r103 == null) goto L9;
        return new ItemCardRecommendHeaderForListPickerBaseBinding((RelativeLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private ItemCardRecommendHeaderForListPickerBaseBinding(RelativeLayout r100, AppCompatImageView r101, TextView r102) {
        this.rootView = r100;
        this.more = r101;
        this.title = r102;
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_card_recommend_header_for_list_picker_base, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
