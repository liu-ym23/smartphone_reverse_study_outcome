package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableGridFieldAddFieldViewLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f210792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f210793c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210791a;
    }

    public BitableGridFieldAddFieldViewLayoutBinding(LinearLayout r100, AppCompatImageView r101, TextView r102) {
        this.f210791a = r100;
        this.f210792b = r101;
        this.f210793c = r102;
    }
}
