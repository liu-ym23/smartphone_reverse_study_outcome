package gsc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f482484b;

    public a(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "regexRaw");
        if (r102 == false) goto L5;
        r100 = "(" + r100 + ')';
    L5:
        this.f482483a = r100;
        if (r102 == false) goto L8;
        r101 = r101 + 1;
    L8:
        this.f482484b = r101;
    }

    public /* synthetic */ a(String r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101, false);
    }
}
