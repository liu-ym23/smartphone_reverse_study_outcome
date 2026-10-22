package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonLoadingView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableNativeViewUikitGroupHeaderLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f210981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f210982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonLoadingView f210983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f210984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f210985f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210980a;
    }

    public BitableNativeViewUikitGroupHeaderLayoutBinding(LinearLayout r100, View r101, LinearLayout r102, CommonLoadingView r103, TextView r104, AppCompatImageView r105, CommonLoadingView r106, AppCompatImageView r107, CommonLoadingView r108, View r110) {
        this.f210980a = r100;
        this.f210981b = r101;
        this.f210982c = r102;
        this.f210983d = r103;
        this.f210984e = r104;
        this.f210985f = r110;
    }
}
