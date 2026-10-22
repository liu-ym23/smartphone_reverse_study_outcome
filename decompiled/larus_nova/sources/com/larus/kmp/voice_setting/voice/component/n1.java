package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n1 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceDialogKind f352393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f352394b;

    public n1() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (this.f352393a == r101.f352393a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352394b, r101.f352394b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f352393a.hashCode() * 31) + this.f352394b.hashCode();
    }

    public final String toString() {
        return "VoiceDialogSheetStateData(activeDialogKind=" + this.f352393a + ", hostRequest=" + this.f352394b + ')';
    }

    public n1(VoiceDialogKind r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = VoiceDialogKind.NONE;
    L6:
        if ((r101 & 2) == 0) goto L8;
        f0 r102 = new f0(null, 0, null, 15);
    L9:
        Intrinsics.checkNotNullParameter(r100, "activeDialogKind");
        Intrinsics.checkNotNullParameter(r102, "hostRequest");
        this.f352393a = r100;
        this.f352394b = r102;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
