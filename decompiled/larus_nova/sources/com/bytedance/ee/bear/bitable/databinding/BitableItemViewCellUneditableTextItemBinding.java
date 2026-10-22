package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewCellUneditableTextItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableAtEditText f210847b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210846a;
    }

    public BitableItemViewCellUneditableTextItemBinding(LinearLayout r100, BitableAtEditText r101) {
        this.f210846a = r100;
        this.f210847b = r101;
    }
}
