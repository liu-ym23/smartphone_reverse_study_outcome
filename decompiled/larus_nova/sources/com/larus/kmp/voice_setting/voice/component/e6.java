package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352239e;

    public e6() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e6) == true) goto L8;
        return false;
    L8:
        e6 r101 = (e6) r100;
        if (Intrinsics.areEqual(this.f352235a, r101.f352235a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352236b, r101.f352236b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352237c, r101.f352237c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352238d, r101.f352238d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352239e, r101.f352239e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f352235a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f352236b.hashCode()) * 31;
        String r104 = this.f352237c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f352238d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f352239e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceSelectedVoiceMeta(voiceId=" + this.f352235a + ", voiceName=" + this.f352236b + ", styleId=" + this.f352237c + ", previewUrl=" + this.f352238d + ", previewMd5=" + this.f352239e + ')';
    }

    public /* synthetic */ e6(String r100, int r110) {
        String r101 = null;
        if ((r110 & 1) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = "";
    L9:
        this(r102, r101, null, null, null);
        return;
    L5:
        r102 = r100;
        goto L7
    }

    public e6(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        this.f352235a = r100;
        this.f352236b = r101;
        this.f352237c = r102;
        this.f352238d = r103;
        this.f352239e = r104;
    }
}
