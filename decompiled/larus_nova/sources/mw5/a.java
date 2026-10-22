package mw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f515940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515941d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f515938a, r101.f515938a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515939b, r101.f515939b) == true) goto L15;
        return false;
    L15:
        if (this.f515940c == r101.f515940c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515941d, r101.f515941d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f515938a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f515939b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f515940c) * 31;
        String r107 = this.f515941d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAudioLoudnessStrategyConfig(metaData=" + this.f515938a + ", deviceAiData=" + this.f515939b + ", loudNormAlgoType=" + this.f515940c + ", audioDumpPath=" + this.f515941d + ')';
    }

    public a(String r100, String r101, int r102) {
        this.f515938a = r100;
        this.f515939b = r101;
        this.f515940c = r102;
        this.f515941d = "";
    }
}
