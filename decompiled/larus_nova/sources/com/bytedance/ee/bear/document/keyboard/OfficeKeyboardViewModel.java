package com.bytedance.ee.bear.document.keyboard;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.obric.trace.ObricActionBarTrackType;
import g45.a;
import g45.d;
import rcb.c;

/* JADX INFO: loaded from: classes16.dex */
public class OfficeKeyboardViewModel extends ViewModel implements a, VcKeyboardChangeEventProducer {
    private static final String TAG = "KeyboardViewModel";
    protected MutableLiveData<Boolean> active;

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        return 0;
    }

    @Override // g45.a
    public String getPanelName() {
        return ObricActionBarTrackType.KEY_BOARD;
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, a r101) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, a r101) {
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        if (this.active != null) goto L6;
        this.active = new MutableLiveData();
    L6:
        return this.active;
    }

    public OfficeKeyboardViewModel() {
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
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
    public void requestNotFocus(Context r100) {
        c.c(r100);
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
}
