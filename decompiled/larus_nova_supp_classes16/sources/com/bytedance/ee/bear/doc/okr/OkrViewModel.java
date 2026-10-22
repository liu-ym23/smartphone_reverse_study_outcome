package com.bytedance.ee.bear.doc.okr;

import android.content.Context;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OkrViewModel extends BaseEditPanelViewModel {
    private static final String TAG = "OkrViewModel";

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r1) {
        return 0;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "okr";
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, a r2) {
    }

    public OkrViewModel() {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r2) {
        super.onKeyboardStateChanged(r2);
        if (r2 == 0) goto L5;
        return;
    L5:
        if (getActive().getValue() != null) goto L7;
        return;
    L7:
        if (((Boolean) getActive().getValue()).booleanValue() == false) goto L12;
        tt5.a.h(TAG, "keyboard hide");
        setActive(false);
        return;
    }
}
