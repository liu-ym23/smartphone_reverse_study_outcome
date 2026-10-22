package com.bytedance.ee.bear.sheet.searchbar;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.search.SearchViewModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetSearchViewModel extends SearchViewModel implements VcKeyboardChangeEventProducer {
    private MutableLiveData<Boolean> focusStatus;
    private boolean shouldDisableLandscapeInVc;

    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    public SheetSearchViewModel() {
        this.focusStatus = new MutableLiveData();
        this.shouldDisableLandscapeInVc = false;
    }

    public MutableLiveData<Boolean> getFocusStatus() {
        return this.focusStatus;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ALWAYS_PORTRAIT;
    }

    public boolean getShouldDisableLandscapeInVc() {
        return this.shouldDisableLandscapeInVc;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    private boolean shouldExitSearch(a r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getPanelName().equals("oppanel") == false) goto L8;
    L11:
        return true;
    L8:
        if (r4.getPanelName().equals("sheet_editor") == true) goto L11;
        if (r4.getPanelName().equals("comment") == true) goto L11;
        return false;
    }

    public void setFocusStatus(boolean r2) {
        this.focusStatus.setValue(Boolean.valueOf(r2));
    }

    public void setShouldDisableLandscapeInVc(boolean r1) {
        this.shouldDisableLandscapeInVc = r1;
    }

    public void onBecomeInactive(d r1, a r2) {
        if (shouldExitSearch(r2) == false) goto L6;
        setActive(false);
        return;
    }
}
