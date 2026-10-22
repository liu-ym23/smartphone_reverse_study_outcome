package com.obric.miniapp.lynx;

import android.app.Dialog;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h1 implements xla.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxMiniAppSheetUI f398139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f6 f398140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a6 f398141c;

    @Override // xla.b
    public final void onShowAnimEnd(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        LynxMiniAppSheetUI r101 = this.f398139a;
        if (r101.f397850o == false) goto L6;
        r101.f397850o = false;
        r101.Q("show");
        return;
    }

    @Override // xla.b
    public final void onShowAnimStart(Dialog r110) {
        Intrinsics.checkNotNullParameter(r110, "dialog");
        LynxMiniAppSheetUI r100 = this.f398139a;
        int r101 = LynxMiniAppSheetUI.f397835p;
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L30
        Method[] r103 = r110.getClass().getMethods();     // Catch: Throwable -> L30
        int r104 = r103.length;     // Catch: Throwable -> L30
        int r105 = 0;
    L4:
        Integer r106 = null;
        if (r105 >= r104) goto L18;
        Method r107 = r103[r105];     // Catch: Throwable -> L30
        if (Intrinsics.areEqual(r107.getName(), "getMaxBodyHeight") == false) goto L14;
        boolean r108 = true;
        if (r107.getParameterTypes().length != 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == false) goto L14;
    L15:
        if (r108 == true) goto L19;
        r105 = r105 + 1;     // Catch: Throwable -> L30
    L19:
        if (r107 == null) goto L21;
        Object r111 = r107.invoke(r110, new Object[0]);     // Catch: Throwable -> L30
    L23:
        if ((r111 instanceof Integer) == false) goto L25;
        r106 = (Integer) r111;     // Catch: Throwable -> L30
    L25:
        if (r106 == null) goto L27;
        int r112 = r106.intValue();     // Catch: Throwable -> L30
    L28:
        Object r113 = Result.m9449constructorimpl(Integer.valueOf(r112));     // Catch: Throwable -> L30
    L32:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L36;
        FLogger.f375446a.w("LynxMiniAppSheetUI", "resolveMaxBodyHeight failed: " + r114.getMessage());
        r113 = 0;
    L36:
        r100.f397848m = ((Number) r113).intValue();
        final f6 r115 = this.f398140b;
        final LynxMiniAppSheetUI r116 = this.f398139a;
        final a6 r117 = this.f398141c;
        r115.post(new e1(r116, r115, r117));
        return;
    L27:
        r112 = 0;
        goto L28
    L21:
        r111 = null;
        goto L23
    L11:
        r109 = false;
    L14:
        r108 = false;
        goto L15
    L18:
        r107 = null;
    L30:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    }

    public h1(LynxMiniAppSheetUI r100, f6 r101, a6 r102) {
        this.f398139a = r100;
        this.f398140b = r101;
        this.f398141c = r102;
    }
}
