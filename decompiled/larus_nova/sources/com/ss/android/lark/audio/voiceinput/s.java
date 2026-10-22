package com.ss.android.lark.audio.voiceinput;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f409392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f409393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f409394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f409395f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f409390a, r101.f409390a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409391b, r101.f409391b) == true) goto L15;
        return false;
    L15:
        if (this.f409392c == r101.f409392c) goto L18;
        return false;
    L18:
        if (Double.compare(this.f409393d, r101.f409393d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f409394e, r101.f409394e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409395f, r101.f409395f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f409390a.hashCode() * 31) + this.f409391b.hashCode()) * 31) + this.f409392c) * 31;
        long r101 = Double.doubleToLongBits(this.f409393d);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f409394e);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f409395f;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceRecordEntity(audioFileName=" + this.f409390a + ", cid=" + this.f409391b + ", duration=" + this.f409392c + ", volume=" + this.f409393d + ", db=" + this.f409394e + ", uploadId=" + this.f409395f + ')';
    }

    public s(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "audioFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        this.f409390a = r100;
        this.f409391b = r101;
        this.f409392c = 0;
        this.f409393d = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f409394e = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f409395f = r102;
    }
}
