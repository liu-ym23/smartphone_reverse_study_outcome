package com.ss.android.vesdk;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes40.dex */
public final class i implements com.bytedance.bpea.entry.api.ve.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRecord f455857a;

    @Override // com.bytedance.bpea.entry.api.ve.a
    public final Object invoke() {
        AudioRecord r100 = this.f455857a;
        if (fna.g.d() == true) goto L5;
        a(r100);
        return null;
    L5:
        a(r100);
        if ((r100 instanceof AudioRecord) == false) goto L11;
        hna.a.c(r100.hashCode());
        return null;
    L11:
        return null;
    }

    public i(AudioRecord r100) {
        this.f455857a = r100;
    }

    public static void a(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }
}
