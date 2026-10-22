package com.larus.business.arc.api;

import kotlin.NoWhenBranchMatchedException;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f319885a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f319886b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319887a = null;

        static {
            int[] r100 = new int[ArcStage.values().length];
            r100[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f319887a = r100;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.arc.api.d] */
    static {
        f319885a = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        f319886b = new d();
    }

    public static final ArcFrameworkFailure a(ArcStage r100) {
        int r101 = a.f319887a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;
    L13:
        return ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;
    }
}
