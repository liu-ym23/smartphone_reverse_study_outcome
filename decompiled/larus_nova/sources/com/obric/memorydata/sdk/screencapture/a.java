package com.obric.memorydata.sdk.screencapture;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f397218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenData f397219b;

    public /* synthetic */ a(b r100, ScreenData r101) {
        this.f397218a = r100;
        this.f397219b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        b r100 = this.f397218a;
        ScreenData r101 = this.f397219b;
        r100.f397221b.invoke(r101);     // Catch: Throwable -> L6
        r100.f397222c.invoke();
        return Unit.INSTANCE;
    L6:
        th = move-exception;
        r100.f397222c.invoke();
        throw th;
    }
}
