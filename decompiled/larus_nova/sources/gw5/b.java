package gw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f483035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f483036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f483037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f483038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f483039g;

    public static final class a {
    }

    static {
    }

    public b() {
        this(null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f483033a == r101.f483033a) goto L12;
        return false;
    L12:
        if (this.f483034b == r101.f483034b) goto L15;
        return false;
    L15:
        if (this.f483035c == r101.f483035c) goto L18;
        return false;
    L18:
        if (this.f483036d == r101.f483036d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f483037e, r101.f483037e) == true) goto L24;
        return false;
    L24:
        if (this.f483038f == r101.f483038f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f483039g, r101.f483039g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f483033a * 31) + this.f483034b) * 31) + this.f483035c) * 31) + this.f483036d) * 31;
        Boolean r101 = this.f483037e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f483038f) * 31;
        String r105 = this.f483039g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAsrContextConfig(enableAudioCache=" + this.f483033a + ", enablePunctuation=" + this.f483034b + ", enableRemoveFirstAudioData=" + this.f483035c + ", audioCacheSize=" + this.f483036d + ", enableNetTransportCompress=" + this.f483037e + ", audioSrc=" + this.f483038f + ", extra=" + this.f483039g + ')';
    }

    public static b a(b r100) {
        int r101 = r100.f483033a;
        int r102 = r100.f483034b;
        int r103 = r100.f483035c;
        int r104 = r100.f483036d;
        Boolean r105 = r100.f483037e;
        String r106 = r100.f483039g;
        r100.getClass();
        return new b(r101, r102, r103, r104, r105, 2, r106);
    }

    public /* synthetic */ b(String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r111 & 2) == 0) goto L9;
        int r101 = 1;
    L11:
        if ((r111 & 8) == 0) goto L13;
        int r102 = 1920000;
    L15:
        if ((r111 & 32) == 0) goto L17;
        int r103 = 1;
    L19:
        if ((r111 & 64) == 0) goto L21;
        r110 = null;
    L21:
        this(r100, r101, 0, r102, null, r103, r110);
        return;
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public b(int r100, int r101, int r102, int r103, Boolean r104, int r105, String r106) {
        this.f483033a = r100;
        this.f483034b = r101;
        this.f483035c = r102;
        this.f483036d = r103;
        this.f483037e = r104;
        this.f483038f = r105;
        this.f483039g = r106;
    }
}
