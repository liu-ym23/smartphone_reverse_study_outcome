package com.bytedance.ee.bear.bitable.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.panel.InterceptTouchRecyclerView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardSelectEditPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f210672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f210674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f210675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RelativeLayout f210676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f210677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f210678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CellEditDragView f210679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SpaceEmptyState f210680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BearLottieView f210681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearLayout f210682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SelectTextView f210683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SelectTagView f210684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RecyclerView f210685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InterceptTouchRecyclerView f210686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f210687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RelativeLayout f210688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SCEditText f210689s;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210671a;
    }

    public static BitableCardSelectEditPanelBinding a(LayoutInflater r210) {
        View r100 = r210.inflate(R.layout.bitable_card_select_edit_panel, null, false);
        int r101 = R.id.cancelSearchBtn;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.cancelSearchBtn);
        if (r102 == null) goto L43;
        r101 = R.id.clearSearchIcon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.clearSearchIcon);
        if (r103 == null) goto L43;
        r101 = R.id.contentContainer;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.contentContainer);
        if (r104 == null) goto L43;
        r101 = R.id.createNewOptionBtn;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.createNewOptionBtn);
        if (r105 == null) goto L43;
        r101 = R.id.createNewOptionContainer;
        RelativeLayout r106 = (RelativeLayout) ViewBindings.findChildViewById(r100, R.id.createNewOptionContainer);
        if (r106 == null) goto L43;
        r101 = R.id.createOptionTV;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.createOptionTV)) == null) goto L43;
        r101 = R.id.dividerUnderAddoption;
        View r110 = ViewBindings.findChildViewById(r100, R.id.dividerUnderAddoption);
        if (r110 == null) goto L43;
        r101 = R.id.dividerUnderSearch;
        View r111 = ViewBindings.findChildViewById(r100, R.id.dividerUnderSearch);
        if (r111 == null) goto L43;
        r101 = R.id.dragView;
        CellEditDragView r112 = (CellEditDragView) ViewBindings.findChildViewById(r100, R.id.dragView);
        if (r112 == null) goto L43;
        r101 = R.id.emptyView;
        SpaceEmptyState r113 = (SpaceEmptyState) ViewBindings.findChildViewById(r100, R.id.emptyView);
        if (r113 == null) goto L43;
        r101 = R.id.loadingIcon;
        BearLottieView r114 = (BearLottieView) ViewBindings.findChildViewById(r100, R.id.loadingIcon);
        if (r114 == null) goto L43;
        r101 = R.id.loadingLayout;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.loadingLayout);
        if (r115 == null) goto L43;
        r101 = R.id.newOptionTV;
        SelectTextView r116 = (SelectTextView) ViewBindings.findChildViewById(r100, R.id.newOptionTV);
        if (r116 == null) goto L43;
        r101 = R.id.newOptionTVV2;
        SelectTagView r117 = (SelectTagView) ViewBindings.findChildViewById(r100, R.id.newOptionTVV2);
        if (r117 == null) goto L43;
        r101 = R.id.previewItemList;
        RecyclerView r118 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.previewItemList);
        if (r118 == null) goto L43;
        r101 = R.id.recyclerView;
        InterceptTouchRecyclerView r119 = (InterceptTouchRecyclerView) ViewBindings.findChildViewById(r100, R.id.recyclerView);
        if (r119 == null) goto L43;
        r101 = R.id.rightMenuContainer;
        FrameLayout r211 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.rightMenuContainer);
        if (r211 == null) goto L43;
        r101 = R.id.searchContainer;
        RelativeLayout r212 = (RelativeLayout) ViewBindings.findChildViewById(r100, R.id.searchContainer);
        if (r212 == null) goto L43;
        r101 = R.id.searchEditText;
        SCEditText r213 = (SCEditText) ViewBindings.findChildViewById(r100, R.id.searchEditText);
        if (r213 == null) goto L43;
        return new BitableCardSelectEditPanelBinding((FrameLayout) r100, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public BitableCardSelectEditPanelBinding(FrameLayout r100, TextView r101, AppCompatImageView r102, FrameLayout r103, AppCompatImageView r104, RelativeLayout r105, View r106, View r110, CellEditDragView r111, SpaceEmptyState r112, BearLottieView r113, LinearLayout r114, SelectTextView r115, SelectTagView r116, RecyclerView r117, InterceptTouchRecyclerView r118, FrameLayout r119, RelativeLayout r210, SCEditText r211) {
        this.f210671a = r100;
        this.f210672b = r101;
        this.f210673c = r102;
        this.f210674d = r103;
        this.f210675e = r104;
        this.f210676f = r105;
        this.f210677g = r106;
        this.f210678h = r110;
        this.f210679i = r111;
        this.f210680j = r112;
        this.f210681k = r113;
        this.f210682l = r114;
        this.f210683m = r115;
        this.f210684n = r116;
        this.f210685o = r117;
        this.f210686p = r118;
        this.f210687q = r119;
        this.f210688r = r210;
        this.f210689s = r211;
    }
}
