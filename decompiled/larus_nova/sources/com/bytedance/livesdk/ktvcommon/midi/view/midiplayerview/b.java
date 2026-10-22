package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiDataProcessor f256208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f256209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f256210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f256211d;

    public b(KtvMidiDataProcessor r100, long r101, long r102, long r103) {
        this.f256208a = r100;
        this.f256209b = r101;
        this.f256210c = r102;
        this.f256211d = r103;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<List<bl6.f>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        zk6.c r101 = this.f256208a.f256178d;
        long r102 = this.f256209b;
        r100.onSuccess(r101.b(((int) r102) - ((int) this.f256210c), ((int) r102) + ((int) this.f256211d)));
    }
}
