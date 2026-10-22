package com.bytedance.ee.bear.doc.equation;

import android.content.Context;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: classes16.dex */
public class EquationViewModel extends BaseEditPanelViewModel {
    private static final String TAG = "EquationViewModel";

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        return 0;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "equation";
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, a r101) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, a r101) {
    }

    public EquationViewModel() {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r100) {
        super.onKeyboardStateChanged(r100);
        if (r100 == 0) goto L5;
        return;
    L5:
        if (getActive().getValue() != null) goto L7;
        return;
    L7:
        if (getActive().getValue().booleanValue() == false) goto L12;
        tt5.a.h(TAG, "keyboard hide");
        setActive(false);
        return;
    }
}
