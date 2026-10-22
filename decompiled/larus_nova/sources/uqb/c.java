package uqb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f551352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551354c;

    public c(byte[] r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "templateByteArray");
        this.f551352a = r100;
        this.f551353b = r101;
        this.f551354c = r102;
    }

    public /* synthetic */ c(byte[] r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
