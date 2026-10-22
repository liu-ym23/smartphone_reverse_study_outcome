package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageCellPhoneEditPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CellEditDragView f210996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableAtEditText f210997c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210995a;
    }

    public BitablePageCellPhoneEditPanelBinding(FrameLayout r100, UDButton r101, CellEditDragView r102, BitableAtEditText r103) {
        this.f210995a = r100;
        this.f210996b = r102;
        this.f210997c = r103;
    }
}
