package com.ss.android.vesdk.audio;

import com.ss.android.vesdk.VEInfo;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f455734a;

    public e(f r100) {
        this.f455734a = r100;
    }

    @Override // com.ss.android.vesdk.audio.d
    public final void onReceive(VEAudioSample r100) {
        d r101 = this.f455734a.f455741g;
        if (r101 == null) goto L6;
        r101.onReceive(r100);
        return;
    }

    @Override // com.ss.android.vesdk.audio.d
    public final void a(int r100, int r101, Object r102) {
        if (r100 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT) goto L8;
        if (r101 == 0) goto L8;
        if (this.f455734a.f455746l <= 0) goto L8;
        return;
    L8:
        d r103 = this.f455734a.f455741g;
        if (r103 == null) goto L12;
        r103.a(r100, r101, r102);
    L12:
        if (r100 != VEInfo.TE_ERROR_RECORD_AUDIO_CAPTURE) goto L15;
        com.ss.android.ttve.monitor.i.f(0, "te_record_audio_mic_running_err", r101);
        return;
    }

    @Override // com.ss.android.vesdk.audio.d
    public final void onError(int r100, int r101, String r102) {
        d r103 = this.f455734a.f455741g;
        if (r103 == null) goto L6;
        r103.onError(r100, r101, r102);
        return;
    }
}
