package com.bytedance.ee.bear.edit.component.document.at;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.atfinder.AtFinderJsCallbackData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.larus.nova.R;
import tb5.n;

/* JADX INFO: loaded from: classes16.dex */
public class AtPanelViewModel extends ViewModel implements g45.a, ocb.a, VcKeyboardChangeEventProducer {
    private static final String TAG = "AtPanel";
    protected MutableLiveData<Boolean> active;
    private MutableLiveData<AtFinderJsCallbackData> atFinderLiveData;
    protected n bridge;
    private EditPanelsManager editPanelsManager;
    private MutableLiveData<Integer> keyboardHeightLiveData;
    private com.bytedance.ee.bear.atfinder.d mDataCallback;
    private com.bytedance.ee.bear.atfinder.e mMentionDelegate;
    private MutableLiveData<Integer> titlebarTopLiveData;

    public static String getTAG() {
        return TAG;
    }

    @Override // g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    public void onDetachFromUI() {
    }

    public String toString() {
        return TAG;
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        if (this.active != null) goto L6;
        this.active = new MutableLiveData();
    L6:
        return this.active;
    }

    public MutableLiveData<AtFinderJsCallbackData> getAtFinderLiveData() {
        if (this.atFinderLiveData != null) goto L6;
        this.atFinderLiveData = new MutableLiveData();
    L6:
        return this.atFinderLiveData;
    }

    public LiveData<Integer> keyboardHeightLiveData() {
        if (this.keyboardHeightLiveData != null) goto L6;
        this.keyboardHeightLiveData = new MutableLiveData();
    L6:
        return this.keyboardHeightLiveData;
    }

    public LiveData<Integer> titleBarLocationLiveData() {
        if (this.titlebarTopLiveData != null) goto L6;
        this.titlebarTopLiveData = new MutableLiveData();
    L6:
        return this.titlebarTopLiveData;
    }

    public AtPanelViewModel() {
        this.atFinderLiveData = null;
    }

    public int getKeyboardHeight() {
        Integer r100 = keyboardHeightLiveData().getValue();
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.intValue();
    }

    public boolean isKeyboardShowing() {
        if (getKeyboardHeight() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public com.bytedance.ee.bear.atfinder.d getDataCallback() {
        return this.mDataCallback;
    }

    public EditPanelsManager getEditPanelsManager() {
        return this.editPanelsManager;
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public com.bytedance.ee.bear.atfinder.e getMentionDelegate() {
        return this.mMentionDelegate;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.core_toolbar_menu_height);
    }

    public void onKeyboardStateChanged(int r100) {
        ((MutableLiveData) keyboardHeightLiveData()).setValue(Integer.valueOf(r100));
        if (isKeyboardShowing() == true) goto L6;
        setActive(false);
        return;
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
        rcb.c.c(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setActive(boolean r100) {
        MutableLiveData r101 = (MutableLiveData) getActive();
        if (r101.getValue() != 0) goto L5;
    L6:
        r101.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (((Boolean) r101.getValue()).booleanValue() != r100) goto L6;
    }

    public void setAtFinderLiveData(AtFinderJsCallbackData r100) {
        getAtFinderLiveData().setValue(r100);
    }

    public void setDataCallback(com.bytedance.ee.bear.atfinder.d r100) {
        this.mDataCallback = r100;
    }

    public void setEditPanelsManager(EditPanelsManager r100) {
        this.editPanelsManager = r100;
    }

    public void setMentionDelegate(com.bytedance.ee.bear.atfinder.e r100) {
        this.mMentionDelegate = r100;
    }

    public void setTitleBarLocation(int r100) {
        ((MutableLiveData) titleBarLocationLiveData()).setValue(Integer.valueOf(r100));
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        onKeyboardStateChanged(r101);
    }
}
