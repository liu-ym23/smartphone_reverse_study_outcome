package com.obric.assistant.component;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class l1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricIntercomComponent f388676a;

    public /* synthetic */ l1(ObricIntercomComponent r100) {
        this.f388676a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ObricIntercomComponent r101 = this.f388676a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = ObricIntercomComponent.f388071h1;
        r101.getClass();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(com.larus.ui.arch.component.internal.attach.a.b(r101, r101));     // Catch: Throwable -> L5
    L7:
        ex8.a r106 = null;
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = null;
    L10:
        Object r107 = (Fragment) r105;
        if (r107 != null) goto L13;
        FLogger.f375446a.i("OrionIntercomComponent", "getSafeHostFragment null, from = suggestActionBarCallback");
    L13:
        FLogger.f375446a.i("OrionIntercomComponent", "isNotMainBotPage " + r101.X + ' ' + r107);
        if (r107 != null) goto L17;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L29;
        if ((r107 instanceof ex8.a) == false) goto L26;
        r106 = (ex8.a) r107;
    L26:
        if (r106 == null) goto L29;
        r106.bS(r102);
    L29:
        return Unit.INSTANCE;
    L17:
        if (r101.X == false) goto L21;
        if ((r107 instanceof xe8.a) == true) goto L21;
        r108 = true;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
