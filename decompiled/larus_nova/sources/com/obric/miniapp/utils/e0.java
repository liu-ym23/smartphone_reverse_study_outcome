package com.obric.miniapp.utils;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<hma.c> f398469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f398470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LocalDateTime f398471c;

    public e0(Ref.ObjectRef r100, Context r101, LocalDateTime r102) {
        this.f398469a = r100;
        this.f398470b = r101;
        this.f398471c = r102;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r110) {
        hma.c.b r111 = (hma.c.b) r110;
        Intrinsics.checkNotNullParameter(r111, "picked");
        hma.c r100 = this.f398469a.element;
        if (r100 == null) goto L17;
        a0 r101 = a0.f398434a;
        Context r102 = this.f398470b;
        LocalDateTime r103 = this.f398471c;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        Map<Integer, Integer> r105 = r111.f486026a;     // Catch: Throwable -> L8
        int r106 = r103.getYear();     // Catch: Throwable -> L8
        int r112 = r103.getMonthValue();     // Catch: Throwable -> L8
        r101.getClass();     // Catch: Throwable -> L8
        a0.e(r102, r100, r105, 2001, 2002, 2003, 2010, r106, r112);     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L13;
        FLogger.f375446a.w("DatePickerUtils", "showDateTimePickerV2 adjustDayReelIfNeeded failed: " + r108.getMessage());
    L13:
        FLogger.f375446a.d("DatePickerUtils", "scroll: " + r111);
        return;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
