package gw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f483058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483059c;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f483057a == r101.f483057a) goto L12;
        return false;
    L12:
        if (this.f483058b == r101.f483058b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483059c, r101.f483059c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f483057a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f483058b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f483059c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAsrStartSessionConfig(enableAudioInput=" + this.f483057a + ", enableUploadAudio=" + this.f483058b + ", wakeupId=" + this.f483059c + ')';
    }

    public h(int r100) {
        this.f483057a = true;
        this.f483058b = false;
        this.f483059c = null;
    }
}
