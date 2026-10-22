package com.bytedance.ee.bear.integrator.di;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends jwc.b {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Level.values().length];
            r0[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Level.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Level.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Level.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public g() {
        super(Level.INFO);
    }

    public final void d(Level r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "level");
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        tt5.a.b("Koin", r4);
        return;
    L5:
        if (r5 != 2) goto L7;
        tt5.a.h("Koin", r4);
        return;
    L7:
        if (r5 != 3) goto L9;
        tt5.a.d("Koin", r4);
        return;
    L9:
        if (r5 != 4) goto L12;
        tt5.a.b("Koin", r4);
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
