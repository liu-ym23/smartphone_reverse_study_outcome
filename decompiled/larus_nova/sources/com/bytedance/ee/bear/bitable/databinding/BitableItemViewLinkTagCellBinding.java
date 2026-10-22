package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewLinkTagCellBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f210864b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210863a;
    }

    public BitableItemViewLinkTagCellBinding(LinearLayout r100, FrameLayout r101, LinearLayout r102, MutilCellLayout r103) {
        this.f210863a = r100;
        this.f210864b = r101;
    }
}
