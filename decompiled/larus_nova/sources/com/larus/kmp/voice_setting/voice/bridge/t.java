package com.larus.kmp.voice_setting.voice.bridge;

/* JADX INFO: loaded from: classes30.dex */
public final class t implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f351906a;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L9;
        return false;
    L9:
        if (this.f351906a == ((t) r100).f351906a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f351906a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "VoicePlatformEffectBridgeUiState(isReady=" + this.f351906a + ')';
    }

    public t(int r100) {
        this.f351906a = false;
    }
}
