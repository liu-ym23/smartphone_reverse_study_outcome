package qs6;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f534672a = null;

    static {
        f534672a = new a();
    }

    public a() {
    }

    @Override // qs6.b
    public final void a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        FLogger.f375446a.e("GoodsBizCodeUtil", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // qs6.b
    public final void d(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.d(r100, r101);
    }

    @Override // qs6.b
    public final void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, "tr");
        FLogger.f375446a.e(r100, "", r101);
    }

    @Override // qs6.b
    public final void i(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.i(r100, r101);
    }

    @Override // qs6.b
    public final void j(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        FLogger.f375446a.i(r100, r101);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // qs6.b
    public final void v(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.v(r100, r101);
    }

    @Override // qs6.b
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, "tr");
        FLogger.f375446a.w("CollectActionHelper", r100, r101);
    }

    @Override // qs6.b
    public final void e(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.e(r100, r101);
    }

    @Override // qs6.b
    public final void w(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.w(r100, r101);
    }

    @Override // qs6.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "tr");
        FLogger.f375446a.e(r100, r101, r102);
    }

    @Override // qs6.b
    public final void log(int r100, String r101, String r102) {
        if (r100 != 2) goto L5;
        FLogger r103 = FLogger.f375446a;
        if (r101 != null) goto L35;
        r101 = "";
    L35:
        r103.v(r101, r102);
        return;
    L5:
        if (r100 != 3) goto L7;
        FLogger r104 = FLogger.f375446a;
        if (r101 != null) goto L31;
        r101 = "";
    L31:
        r104.d(r101, r102);
        return;
    L7:
        if (r100 != 4) goto L9;
        FLogger r105 = FLogger.f375446a;
        if (r101 != null) goto L27;
        r101 = "";
    L27:
        r105.i(r101, r102);
        return;
    L9:
        if (r100 != 5) goto L11;
        FLogger r106 = FLogger.f375446a;
        if (r101 != null) goto L23;
        r101 = "";
    L23:
        r106.w(r101, r102);
        return;
    L11:
        if (r100 == 6) goto L16;
        FLogger r107 = FLogger.f375446a;
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        r107.v(r101, r102);
        return;
    L16:
        FLogger r108 = FLogger.f375446a;
        if (r101 != null) goto L19;
        r101 = "";
    L19:
        r108.e(r101, r102);
    }
}
