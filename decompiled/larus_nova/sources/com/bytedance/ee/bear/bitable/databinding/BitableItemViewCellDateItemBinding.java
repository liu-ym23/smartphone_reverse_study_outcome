package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewCellDateItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableAtEditText f210839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210840c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210838a;
    }

    public BitableItemViewCellDateItemBinding(LinearLayout r100, BitableAtEditText r101, AppCompatImageView r102) {
        this.f210838a = r100;
        this.f210839b = r101;
        this.f210840c = r102;
    }
}
