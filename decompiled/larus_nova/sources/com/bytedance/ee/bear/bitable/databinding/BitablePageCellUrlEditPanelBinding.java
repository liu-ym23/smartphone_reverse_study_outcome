package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageCellUrlEditPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f211003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CellEditDragView f211004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableAtEditText f211005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableAtEditText f211006d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211003a;
    }

    public BitablePageCellUrlEditPanelBinding(FrameLayout r100, CellEditDragView r101, KeyboardPlaceholderView r102, BitableAtEditText r103, BitableAtEditText r104) {
        this.f211003a = r100;
        this.f211004b = r101;
        this.f211005c = r103;
        this.f211006d = r104;
    }
}
