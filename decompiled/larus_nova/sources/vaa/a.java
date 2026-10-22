package vaa;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.provider.hybrid.m;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n38.k;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q38.b f553983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f553984b;

    @Override // n38.k
    public final void a(n38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        FLogger.f375446a.e("ObricAccountServiceImpl", "switchToPersonalAccount failed, code=" + r100.f516990d + ", msg=" + r100.f516991e);
        this.f553984b.invoke(Boolean.FALSE);
    }

    @Override // n38.k
    public final void b(n38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        FLogger.f375446a.i("ObricAccountServiceImpl", "switchToPersonalAccount success, targetSecUserId: " + this.f553983a.g());
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        AppHost.f326268a.a().finishAllActivities();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        FLogger.f375446a.w("ObricAccountServiceImpl", "finishAllActivities failed: " + r103.getMessage(), r103);
    L10:
        this.f553984b.invoke(Boolean.TRUE);
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public a(q38.b r100, m r101) {
        this.f553983a = r100;
        this.f553984b = r101;
    }
}
