package com.larus.audio.call.play;

/* JADX INFO: loaded from: classes24.dex */
public final class j extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f289340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f289341b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        if (this.f289341b == 0) goto L5;
        this.f289340a = System.currentTimeMillis() - this.f289341b;
        return;
    L5:
        com.larus.audio.call.util.e.f289645a.e("TTSPrepareTimeRecorder", "firstTTSArriveTime invalid");
    }

    public j() {
    }
}
