package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes37.dex */
public final class ViewSearchResultBinding implements ViewBinding {
    public final LinearLayout llTopTips;
    public final RelativeLayout resultLayout;
    private final RelativeLayout rootView;
    public final FrameLayout searchResultHeadContainer;
    public final LinearLayout searchResultLoading;
    public final ImageView searchResultLoadingImg;
    public final TextView searchResultLoadingTxt;
    public final LKUIPtrClassicFrameLayout searchResultPtrFl;
    public final CommonRecyclerView searchResultRv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewSearchResultBinding bind(View r110) {
        int r100 = R.id.ll_top_tips;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.ll_top_tips);
        if (r101 == null) goto L19;
        RelativeLayout r102 = (RelativeLayout) r110;
        r100 = R.id.search_result_head_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.search_result_head_container);
        if (r103 == null) goto L19;
        r100 = R.id.search_result_loading;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.search_result_loading);
        if (r104 == null) goto L19;
        r100 = R.id.search_result_loading_img;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r110, R.id.search_result_loading_img);
        if (r105 == null) goto L19;
        r100 = R.id.search_result_loading_txt;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r110, R.id.search_result_loading_txt);
        if (r106 == null) goto L19;
        r100 = R.id.search_result_ptr_fl;
        LKUIPtrClassicFrameLayout r111 = (LKUIPtrClassicFrameLayout) ViewBindings.findChildViewById(r110, R.id.search_result_ptr_fl);
        if (r111 == null) goto L19;
        r100 = R.id.search_result_rv;
        CommonRecyclerView r112 = (CommonRecyclerView) ViewBindings.findChildViewById(r110, R.id.search_result_rv);
        if (r112 == null) goto L19;
        return new ViewSearchResultBinding(r102, r101, r102, r103, r104, r105, r106, r111, r112);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public static ViewSearchResultBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ViewSearchResultBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_search_result, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ViewSearchResultBinding(RelativeLayout r100, LinearLayout r101, RelativeLayout r102, FrameLayout r103, LinearLayout r104, ImageView r105, TextView r106, LKUIPtrClassicFrameLayout r107, CommonRecyclerView r108) {
        this.rootView = r100;
        this.llTopTips = r101;
        this.resultLayout = r102;
        this.searchResultHeadContainer = r103;
        this.searchResultLoading = r104;
        this.searchResultLoadingImg = r105;
        this.searchResultLoadingTxt = r106;
        this.searchResultPtrFl = r107;
        this.searchResultRv = r108;
    }
}
