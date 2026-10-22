package dx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470409c;

    public final String toString() {
        return "LatchLogModel(level='" + this.f470408b + "', tag='" + this.f470409c + "', message='" + this.f470407a + "')";
    }

    public b(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "tag");
        this.f470407a = r100;
        this.f470408b = r101;
        this.f470409c = r102;
    }

    public /* synthetic */ b(String r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = 1;
    L6:
        if ((r102 & 4) == 0) goto L8;
        String r103 = "Internal";
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
