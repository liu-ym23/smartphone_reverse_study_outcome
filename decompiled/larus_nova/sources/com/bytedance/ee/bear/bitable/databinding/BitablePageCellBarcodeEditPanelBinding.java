package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageCellBarcodeEditPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CellEditDragView f210988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableAtEditText f210989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f210990d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210987a;
    }

    public BitablePageCellBarcodeEditPanelBinding(FrameLayout r100, CellEditDragView r101, BitableAtEditText r102, FrameLayout r103, UDButton r104) {
        this.f210987a = r100;
        this.f210988b = r101;
        this.f210989c = r102;
        this.f210990d = r103;
    }
}
