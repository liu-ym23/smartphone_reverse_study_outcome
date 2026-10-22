package com.larus.ugc.feed.impl.spi;

import com.larus.common.pollingconfig.api.PollingConfigService;
import g0a.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements d {

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.spi.a$a, reason: collision with other inner class name */
    public static final class C4514a {
    }

    static {
    }

    public a() {
    }

    @Override // g0a.d
    public final boolean zF() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(PollingConfigService.f326423a.f("cre_tab_ent_dg"), "1")));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
