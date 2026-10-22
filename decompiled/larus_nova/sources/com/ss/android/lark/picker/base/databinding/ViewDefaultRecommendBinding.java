package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ViewDefaultRecommendBinding implements ViewBinding {
    public final ImageView loadingIv;
    public final TextView loadingTv;
    public final LinearLayout loadingView;
    public final RelativeLayout recommendLayout;
    public final LKUIPtrClassicFrameLayout recommendPtrLayout;
    public final CommonRecyclerView recommendRv;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDefaultRecommendBinding bind(View r110) {
        int r100 = R.id.loading_iv;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r110, R.id.loading_iv);
        if (r101 == null) goto L15;
        r100 = R.id.loading_tv;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r110, R.id.loading_tv);
        if (r102 == null) goto L15;
        r100 = R.id.loading_view;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.loading_view);
        if (r103 == null) goto L15;
        RelativeLayout r104 = (RelativeLayout) r110;
        r100 = R.id.recommend_ptr_layout;
        LKUIPtrClassicFrameLayout r105 = (LKUIPtrClassicFrameLayout) ViewBindings.findChildViewById(r110, R.id.recommend_ptr_layout);
        if (r105 == null) goto L15;
        r100 = R.id.recommend_rv;
        CommonRecyclerView r106 = (CommonRecyclerView) ViewBindings.findChildViewById(r110, R.id.recommend_rv);
        if (r106 == null) goto L15;
        return new ViewDefaultRecommendBinding(r104, r101, r102, r103, r104, r105, r106);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public static ViewDefaultRecommendBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ViewDefaultRecommendBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_default_recommend, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ViewDefaultRecommendBinding(RelativeLayout r100, ImageView r101, TextView r102, LinearLayout r103, RelativeLayout r104, LKUIPtrClassicFrameLayout r105, CommonRecyclerView r106) {
        this.rootView = r100;
        this.loadingIv = r101;
        this.loadingTv = r102;
        this.loadingView = r103;
        this.recommendLayout = r104;
        this.recommendPtrLayout = r105;
        this.recommendRv = r106;
    }
}
