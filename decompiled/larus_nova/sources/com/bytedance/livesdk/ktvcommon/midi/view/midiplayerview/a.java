package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiDataProcessor f256207a;

    public a(KtvMidiDataProcessor r100) {
        this.f256207a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<bl6.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        KtvMidiDataProcessor r101 = this.f256207a;
        bl6.f r102 = r101.f256178d.f((int) r101.f256176b);
        if (r102 == null) goto L5;
        r100.onSuccess(r102);
        return;
    L5:
        r100.onError(new Throwable("MidiSegment not found at time " + this.f256207a.f256176b));
    }
}
