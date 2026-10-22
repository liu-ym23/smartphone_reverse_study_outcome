package c68;

import com.larus.audio.utils.f0;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.k;
import m58.l;
import m58.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final l a = null;

    static {
        m r0 = h.j;
        if (r0 == null) goto L5;
        f0 r1 = r0.create();
    L6:
        a = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static k a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "what");
        l r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(3, r2);
    }

    public static k b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "what");
        l r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(6, r2);
    }

    public static k c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "what");
        l r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(4, r2);
    }

    public static k d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "what");
        l r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(5, r2);
    }
}
