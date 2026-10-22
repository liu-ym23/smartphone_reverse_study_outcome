package com.larus.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f363945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f363946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f363947c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363948a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.PREPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363948a = r100;
        }
    }

    public final v d() {
        return new v(this.f363945a, this.f363946b, this.f363947c);
    }

    public y() {
        u.c r100 = u.c.f363922b;
        u.c r101 = u.c.f363923c;
        this.f363945a = r101;
        this.f363946b = r101;
        this.f363947c = r101;
    }

    public final u a(LoadType r100) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        int r101 = a.f363948a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return this.f363946b;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.f363947c;
    L13:
        return this.f363945a;
    }

    public final void b(v r100) {
        Intrinsics.checkNotNullParameter(r100, "states");
        this.f363945a = r100.f363925a;
        this.f363947c = r100.f363927c;
        this.f363946b = r100.f363926b;
    }

    public final void c(LoadType r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "state");
        int r102 = a.f363948a[r100.ordinal()];
        if (r102 != 1) goto L5;
        this.f363945a = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        this.f363947c = r101;
        return;
    L7:
        if (r102 != 3) goto L10;
        this.f363946b = r101;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
