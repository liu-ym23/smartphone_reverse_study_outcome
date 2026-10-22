package z48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a58.a f570033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b58.a f570034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b58.a f570035c;

    public a() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570033a, r101.f570033a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570034b, r101.f570034b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570035c, r101.f570035c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a58.a r100 = this.f570033a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b58.a r104 = this.f570034b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b58.a r107 = this.f570035c;
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
        return "ChatSpeakerUIConfig(pressHintUIConfig=" + this.f570033a + ", cancelGroupUIConfig=" + this.f570034b + ", speechGroupUIConfig=" + this.f570035c + ')';
    }

    public a(a58.a r100, b58.a r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this.f570033a = r100;
        this.f570034b = null;
        this.f570035c = r101;
    }
}
