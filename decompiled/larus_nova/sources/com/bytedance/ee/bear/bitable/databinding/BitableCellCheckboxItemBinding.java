package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.checkbox.InterruptCheckableCheckbox;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCellCheckboxItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterruptCheckableCheckbox f210728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f210729c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210727a;
    }

    public BitableCellCheckboxItemBinding(LinearLayout r100, InterruptCheckableCheckbox r101, LinearLayout r102) {
        this.f210727a = r100;
        this.f210728b = r101;
        this.f210729c = r102;
    }
}
