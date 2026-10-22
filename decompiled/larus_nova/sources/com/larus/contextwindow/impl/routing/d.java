package com.larus.contextwindow.impl.routing;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.common.apphost.AppHost;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Context, ContextWindowEntryRequest, Boolean> f330414a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function2<? super Context, ? super ContextWindowEntryRequest, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "openRoute");
        this.f330414a = r100;
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        boolean r101 = false;
        if (r100 == null) goto L23;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L23;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r102.getScheme(), AppConstants.SCHEME_SS_LOCAL) == true) goto L10;
    L14:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L16
    L18:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L22;
        r104 = r105;
    L22:
        return ((Boolean) r104).booleanValue();
    L10:
        if (Intrinsics.areEqual(r102.getHost(), BytedCertConstant.CertKey.FLOW) == false) goto L14;
        if (Intrinsics.areEqual(r102.getPath(), "/context_window_usage") == false) goto L14;
        r101 = true;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        return false;
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r101 == null) goto L24;
        Uri r102 = r101.f267530d;
        if (r102 == null) goto L28;
        if (r100 != null) goto L8;
        r100 = AppHost.f326268a.getApplication();
    L8:
        Context r103 = r100;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(v29.b.d(r102));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = null;
    L16:
        ContextWindowEntryRequest r106 = (ContextWindowEntryRequest) r105;
        if (r106 != null) goto L21;
        FLogger.f375446a.w("ContextWindowRouter", "invalid explicit context window route");
        s.j(s.f544207a, r103, r103.getString(R.string.larus_context_window_unavailable), null, false, 28);
        return true;
    L21:
        if (this.f330414a.invoke(r103, r106).booleanValue() == true) goto L23;
        s.j(s.f544207a, r103, r103.getString(R.string.larus_context_window_unavailable), null, false, 28);
    L23:
        return true;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L28:
        return false;
    L24:
        return false;
    }
}
