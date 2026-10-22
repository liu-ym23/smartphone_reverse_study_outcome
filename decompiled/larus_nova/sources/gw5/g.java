package gw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483056c;

    public static final class a {
    }

    static {
    }

    public g() {
        String r100 = null;
        this(r100, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f483054a, r101.f483054a) == true) goto L12;
        return false;
    L12:
        if (this.f483055b == r101.f483055b) goto L15;
        return false;
    L15:
        if (this.f483056c == r101.f483056c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f483054a.hashCode() * 31;
        long r101 = this.f483055b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f483056c == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "FlowAsrRecordingConfig(filePath=" + this.f483054a + ", minRecordDurationMs=" + this.f483055b + ", removeAudioFileAfterFinish=" + this.f483056c + ')';
    }

    public /* synthetic */ g(String r100, long r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 500;
    L9:
        if ((r102 & 4) == 0) goto L11;
        boolean r103 = true;
    L12:
        this(r100, r101, r103);
        return;
    L11:
        r103 = false;
        goto L12
    }

    public g(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f483054a = r100;
        this.f483055b = r101;
        this.f483056c = r102;
    }

    public static g a(g r100, String r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f483054a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        long r104 = r100.f483055b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f483056c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "filePath");
        return new g(r101, r104, r102);
    L8:
        r104 = 0;
        goto L10
    }
}
