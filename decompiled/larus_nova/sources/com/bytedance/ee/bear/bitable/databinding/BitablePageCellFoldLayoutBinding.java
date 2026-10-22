package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageCellFoldLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f210992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f210994d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210991a;
    }

    public BitablePageCellFoldLayoutBinding(LinearLayout r100, View r101, AppCompatImageView r102, AppCompatTextView r103) {
        this.f210991a = r100;
        this.f210992b = r101;
        this.f210993c = r102;
        this.f210994d = r103;
    }
}
