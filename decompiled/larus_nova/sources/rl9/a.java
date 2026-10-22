package rl9;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final int a(int r100) {
        if (r100 != 0) goto L4;
    L15:
        return 0;
    L4:
        if (r100 != 5) goto L6;
    L14:
        return -2;
    L6:
        if (r100 == 7) goto L14;
        if (r100 == 12) goto L14;
        if (r100 == 101) goto L13;
        switch(r100) {
            case 1030: goto L15;
            case 1031: goto L13;
            case 1032: goto L13;
            case 1033: goto L13;
            default: goto L12;
        };
    L12:
        return -1;
    L13:
        return -3;
    }

    public static final int b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getInt("code");
    }
}
