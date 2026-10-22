package com.larus.caijing_pay.impl.config;

import android.content.Context;
import bx8.c;
import bx8.d;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.bytedance.caijing.sdk.infra.base.api.router.CJHostRouterService;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJHostRouterServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/router/CJHostRouterService;", "<init>", "()V", "routerInterface", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeWithContextInterface;", "getRouterInterface", "()Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeWithContextInterface;", "routerInterface$delegate", "Lkotlin/Lazy;", "getOpenSchemeWithContextInterface", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJHostRouterServiceImpl implements CJHostRouterService {
    public static final a Companion = null;
    private static final String TAG = "CJHostRouterServiceImpl";
    public static final String URI_KEY_MIX_CONTAINER_TYPE = "mix_container_type";
    public static final String URI_KEY_USE_ANNIEX = "use_anniex";
    public static final String URI_MIX_CONTAINER_ANNIEX = "anniex";
    private final Lazy routerInterface$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ TTCJPayOpenSchemeWithContextInterface E2(CJHostRouterServiceImpl r100) {
        return routerInterface_delegate$lambda$3(r100);
    }

    public static /* synthetic */ void F2(CJHostRouterServiceImpl r100, Context r101, String r102) {
        routerInterface_delegate$lambda$3$lambda$2(r100, r101, r102);
    }

    private final TTCJPayOpenSchemeWithContextInterface getRouterInterface() {
        return (TTCJPayOpenSchemeWithContextInterface) this.routerInterface$delegate.getValue();
    }

    public CJHostRouterServiceImpl() {
        this.routerInterface$delegate = LazyKt.lazy(new c(this));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.router.CJHostRouterService
    public TTCJPayOpenSchemeWithContextInterface getOpenSchemeWithContextInterface() {
        return getRouterInterface();
    }

    private static final TTCJPayOpenSchemeWithContextInterface routerInterface_delegate$lambda$3(final CJHostRouterServiceImpl r100) {
        return new d(r100);
    }

    private static final void routerInterface_delegate$lambda$3$lambda$2(CJHostRouterServiceImpl r100, Context r101, String r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r102 != null) goto L15;
        return;
    L15:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        String r104 = ax8.a.b(r102);     // Catch: Throwable -> L9
        SmartRouter.buildRoute(r101, r104).d();     // Catch: Throwable -> L9
        FLogger.f375446a.d(ax8.a.a(TAG), "CJHostRouterServiceImpl open schemeByAnnieX " + r104);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L17;
        SmartRouter.buildRoute(r101, r102).d();
        FLogger.f375446a.d(ax8.a.a(TAG), "CJHostRouterServiceImpl open schemeBySmartRouter ".concat(r102));
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
