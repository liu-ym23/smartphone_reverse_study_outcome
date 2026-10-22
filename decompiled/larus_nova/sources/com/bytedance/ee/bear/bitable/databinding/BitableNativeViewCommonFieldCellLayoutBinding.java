package com.bytedance.ee.bear.bitable.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonLoadingView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableNativeViewCommonFieldCellLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonLoadingView f210972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonCellView f210973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f210974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f210975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f210976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f210977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommonLoadingView f210978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f210979i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210971a;
    }

    public static BitableNativeViewCommonFieldCellLayoutBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.bitable_native_view_common_field_cell_layout, r111, false);
        r111.addView(r112);
        int r113 = R.id.cellValueLoading;
        CommonLoadingView r100 = (CommonLoadingView) ViewBindings.findChildViewById(r112, R.id.cellValueLoading);
        if (r100 == null) goto L19;
        r113 = R.id.cellView;
        CommonCellView r101 = (CommonCellView) ViewBindings.findChildViewById(r112, R.id.cellView);
        if (r101 == null) goto L19;
        r113 = R.id.cellViewContainer;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.cellViewContainer);
        if (r102 == null) goto L19;
        LinearLayout r103 = (LinearLayout) r112;
        r113 = R.id.fieldName;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r112, R.id.fieldName);
        if (r104 == null) goto L19;
        r113 = R.id.fieldNameContainer;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.fieldNameContainer);
        if (r105 == null) goto L19;
        r113 = R.id.fieldNameLoading;
        CommonLoadingView r106 = (CommonLoadingView) ViewBindings.findChildViewById(r112, R.id.fieldNameLoading);
        if (r106 == null) goto L19;
        r113 = R.id.horizontalSpace;
        View r114 = ViewBindings.findChildViewById(r112, R.id.horizontalSpace);
        if (r114 == null) goto L19;
        return new BitableNativeViewCommonFieldCellLayoutBinding(r103, r100, r101, r102, r103, r104, r105, r106, r114);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public BitableNativeViewCommonFieldCellLayoutBinding(LinearLayout r100, CommonLoadingView r101, CommonCellView r102, FrameLayout r103, LinearLayout r104, TextView r105, FrameLayout r106, CommonLoadingView r107, View r108) {
        this.f210971a = r100;
        this.f210972b = r101;
        this.f210973c = r102;
        this.f210974d = r103;
        this.f210975e = r104;
        this.f210976f = r105;
        this.f210977g = r106;
        this.f210978h = r107;
        this.f210979i = r108;
    }
}
