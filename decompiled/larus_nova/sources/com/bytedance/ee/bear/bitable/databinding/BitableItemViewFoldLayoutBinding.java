package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewFoldLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f210858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f210860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f210861e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210857a;
    }

    public BitableItemViewFoldLayoutBinding(LinearLayout r100, AppCompatImageView r101, AppCompatImageView r102, AppCompatImageView r103, AppCompatTextView r104) {
        this.f210857a = r100;
        this.f210858b = r101;
        this.f210859c = r102;
        this.f210860d = r103;
        this.f210861e = r104;
    }
}
