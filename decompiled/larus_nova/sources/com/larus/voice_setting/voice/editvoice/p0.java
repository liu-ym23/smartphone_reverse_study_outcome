package com.larus.voice_setting.voice.editvoice;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpeakerVoiceEditModel f376802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f376803b;

    public /* synthetic */ p0(SpeakerVoiceEditModel r100, float r101) {
        this.f376802a = r100;
        this.f376803b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpeakerVoiceEditModel r100 = this.f376802a;
        float r101 = this.f376803b;
        MutableLiveData<b1> r102 = r100.B;
        b1 r103 = r102.getValue();
        if (r103 == null) goto L5;
        b1 r104 = b1.a(r103, r101, 0.0f, 2);
    L6:
        r102.setValue(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
