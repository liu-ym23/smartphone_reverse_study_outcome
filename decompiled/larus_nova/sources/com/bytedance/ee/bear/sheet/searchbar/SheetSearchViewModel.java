package com.bytedance.ee.bear.sheet.searchbar;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.search.SearchViewModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: classes18.dex */
public class SheetSearchViewModel extends SearchViewModel implements VcKeyboardChangeEventProducer {
    private MutableLiveData<Boolean> focusStatus;
    private boolean shouldDisableLandscapeInVc;

    @Override // com.bytedance.ee.bear.document.search.SearchViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, a r101) {
    }

    public SheetSearchViewModel() {
        this.focusStatus = new MutableLiveData();
        this.shouldDisableLandscapeInVc = false;
    }

    public MutableLiveData<Boolean> getFocusStatus() {
        return this.focusStatus;
    }

    @Override // com.bytedance.ee.bear.document.search.SearchViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ALWAYS_PORTRAIT;
    }

    public boolean getShouldDisableLandscapeInVc() {
        return this.shouldDisableLandscapeInVc;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    private boolean shouldExitSearch(a r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getPanelName().equals("oppanel") == false) goto L8;
    L11:
        return true;
    L8:
        if (r100.getPanelName().equals("sheet_editor") == true) goto L11;
        if (r100.getPanelName().equals("comment") == true) goto L11;
        return false;
    }

    public void setFocusStatus(boolean r100) {
        this.focusStatus.setValue(Boolean.valueOf(r100));
    }

    public void setShouldDisableLandscapeInVc(boolean r100) {
        this.shouldDisableLandscapeInVc = r100;
    }

    @Override // com.bytedance.ee.bear.document.search.SearchViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void onBecomeInactive(d r100, a r101) {
        if (shouldExitSearch(r101) == false) goto L6;
        setActive(false);
        return;
    }
}
