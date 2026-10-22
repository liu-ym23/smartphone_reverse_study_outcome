package com.bytedance.ee.bear.document.ai.inlineai;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.d;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements g45.a, VcKeyboardChangeEventProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f218814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f218815b;

    @Override // g45.a
    public final String getPanelName() {
        return "inlineAI";
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
        this.f218815b = new MutableLiveData();
    }

    @Override // g45.a
    public final LiveData<Boolean> getActive() {
        return this.f218815b;
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
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_SHOW;
    }

    @Override // g45.a
    public final int getPanelHeight(Context r100) {
        return this.f218814a;
    }
}
