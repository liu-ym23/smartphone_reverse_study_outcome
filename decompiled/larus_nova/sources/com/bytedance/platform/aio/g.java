package com.bytedance.platform.aio;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f266607b = null;

    public g() {
    }

    @Override // com.bytedance.platform.aio.b
    public final boolean b(Severity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "severity");
        Intrinsics.checkNotNullParameter(r101, "tag");
        return true;
    }

    static {
        f266607b = new g();
    }

    @Override // com.bytedance.platform.aio.b
    public final void a(Severity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "severity");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        int r103 = f.f266606a[r100.ordinal()];
        if (r103 == 1) goto L11;
        if (r103 != 2) goto L6;
        String r104 = "I";
    L12:
        System.out.println("[" + r104 + "] | " + StringsKt.padEnd$default(r101, 24, 0, 2, null) + " | " + r102);
        return;
    L6:
        if (r103 != 3) goto L9;
        r104 = ExifInterface.LONGITUDE_EAST;
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r104 = "D";
        goto L12
    }
}
