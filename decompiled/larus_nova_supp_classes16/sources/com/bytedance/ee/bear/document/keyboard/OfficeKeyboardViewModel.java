package com.bytedance.ee.bear.document.keyboard;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.a;
import g45.d;
import rcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeKeyboardViewModel extends ViewModel implements a, VcKeyboardChangeEventProducer {
    private static final String TAG = "KeyboardViewModel";
    protected MutableLiveData<Boolean> active;

    @Override // g45.a
    public int getPanelHeight(Context r1) {
        return 0;
    }

    @Override // g45.a
    public String getPanelName() {
        return "keyboard";
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, a r2) {
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
    public void requestNotFocus(Context r1) {
        c.c(r1);
    }

    public void setActive(boolean r3) {
        MutableLiveData r0 = getActive();
        if (r0.getValue() != null) goto L5;
    L6:
        r0.setValue(Boolean.valueOf(r3));
        return;
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != r3) goto L6;
    }
}
