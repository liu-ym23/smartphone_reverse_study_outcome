package com.obric.miniapp.utils;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i0 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f398489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f398490b;

    public i0(AtomicBoolean r100, g r101) {
        this.f398489a = r100;
        this.f398490b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        Throwable r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        FLogger.f375446a.e("DatePickerUtils", "showDateTimePickerV2 show() failed: " + r101.getMessage());
        a0.t(this.f398489a, this.f398490b, null);
        return Unit.INSTANCE;
    }
}
