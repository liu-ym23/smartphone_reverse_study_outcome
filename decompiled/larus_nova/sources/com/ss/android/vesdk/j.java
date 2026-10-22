package com.ss.android.vesdk;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes40.dex */
public final class j implements com.bytedance.bpea.entry.api.ve.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRecord f455858a;

    @Override // com.bytedance.bpea.entry.api.ve.a
    public final Object invoke() {
        AudioRecord r100 = this.f455858a;
        f06.c r101 = new f06.c();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        if (r101.b(100403, "android/media/AudioRecord", "release", r100, r110, "void", r111).f474982a == false) goto L5;
        r101.a(100403, "android/media/AudioRecord", "release", r100, r110, null, r111, false);
        return null;
    L5:
        r100.release();
        r101.a(100403, "android/media/AudioRecord", "release", r100, r110, null, r111, true);
        return null;
    }

    public j(AudioRecord r100) {
        this.f455858a = r100;
    }
}
