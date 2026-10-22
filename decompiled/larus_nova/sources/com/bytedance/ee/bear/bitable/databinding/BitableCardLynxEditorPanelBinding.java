package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardLynxEditorPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CellEditDragView f210670b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210669a;
    }

    public BitableCardLynxEditorPanelBinding(FrameLayout r100, CellEditDragView r101) {
        this.f210669a = r100;
        this.f210670b = r101;
    }
}
