package com.larus.dora.obric.device_management.explore;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes27.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f339590a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339591a = null;

        static {
            int[] r100 = new int[DoraObricGlassesImagePageType.values().length];
            r100[DoraObricGlassesImagePageType.EXPLORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DoraObricGlassesImagePageType.DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DoraObricGlassesImagePageType.BASIC_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f339591a = r100;
        }
    }

    static {
        f339590a = new t0();
    }

    public t0() {
    }

    public static Object a(Context r100, d1 r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r100.getString(r101.f339511a));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L10;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "resolve local string failed: resId=" + r101.f339511a);
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        return "";
    L15:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
