package com.bytedance.ee.bear.integrator.di;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends jwc.b {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227132a = null;

        static {
            int[] r100 = new int[Level.values().length];
            r100[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Level.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Level.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Level.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f227132a = r100;
        }
    }

    static {
    }

    public g() {
        super(Level.INFO);
    }

    @Override // jwc.b
    public final void d(Level r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = b.f227132a[r100.ordinal()];
        if (r102 != 1) goto L5;
        tt5.a.b("Koin", r101);
        return;
    L5:
        if (r102 != 2) goto L7;
        tt5.a.h("Koin", r101);
        return;
    L7:
        if (r102 != 3) goto L9;
        tt5.a.d("Koin", r101);
        return;
    L9:
        if (r102 != 4) goto L12;
        tt5.a.b("Koin", r101);
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
