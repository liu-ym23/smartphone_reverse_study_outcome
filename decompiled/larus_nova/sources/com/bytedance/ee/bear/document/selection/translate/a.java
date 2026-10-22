package com.bytedance.ee.bear.document.selection.translate;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.d;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements g45.a, VcKeyboardChangeEventProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f221716a;

    @Override // g45.a
    public final int getPanelHeight(Context r100) {
        return 0;
    }

    @Override // g45.a
    public final String getPanelName() {
        return "WordTranslation";
    }

    @Override // g45.a
    public final /* synthetic */ void onBecomeActive(d r100, g45.a r101) {
    }

    @Override // g45.a
    public final /* synthetic */ void onBecomeInactive(d r100, g45.a r101) {
    }

    @Override // g45.a
    public final void requestNotFocus(Context r100) {
    }

    public a() {
        this.f221716a = new MutableLiveData();
    }

    @Override // g45.a
    public final LiveData<Boolean> getActive() {
        return this.f221716a;
    }

    @Override // g45.a
    public final KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public final VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ALWAYS_PORTRAIT;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public final VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }
}
