package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldHeaderView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableGridViewContainerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridFieldHeaderView f210816b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210815a;
    }

    public BitableGridViewContainerLayoutBinding(LinearLayout r100, GridFieldHeaderView r101) {
        this.f210815a = r100;
        this.f210816b = r101;
    }
}
