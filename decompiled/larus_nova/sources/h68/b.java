package h68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f483929c;

    public b() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f483927a, r101.f483927a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483928b, r101.f483928b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483929c, r101.f483929c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f483927a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f483928b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f483929c;
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
        return "AsrStreamSentenceResp(streamingSentence=" + this.f483927a + ", definiteSentence=" + this.f483928b + ", isInterim=" + this.f483929c + ')';
    }

    public b(String r100, String r101, Boolean r102) {
        this.f483927a = r100;
        this.f483928b = r101;
        this.f483929c = r102;
    }
}
