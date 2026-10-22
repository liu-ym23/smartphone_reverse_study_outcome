package com.bytedance.upc.common.activity;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ActivityLifeObserver$onAppEnterBackgroundOb$1 extends Lambda implements Function0<Unit> {
    public static final ActivityLifeObserver$onAppEnterBackgroundOb$1 INSTANCE = null;

    static {
        INSTANCE = new ActivityLifeObserver$onAppEnterBackgroundOb$1();
    }

    public ActivityLifeObserver$onAppEnterBackgroundOb$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        int r101 = ActivityLifeObserver.f272458a;     // Catch: Throwable -> L12
        Iterator r102 = ((List) ActivityLifeObserver.f272460c.getValue()).iterator();     // Catch: Throwable -> L12
    L4:
        if (r102.hasNext() == false) goto L10;
        Function1 r103 = (Function1) r102.next();     // Catch: Throwable -> L12
        int r104 = ActivityLifeObserver.f272458a;     // Catch: Throwable -> L12
        if (ActivityLifeObserver.f272459b == true) goto L8;
        boolean r105 = true;
    L9:
        r103.invoke(Boolean.valueOf(r105));     // Catch: Throwable -> L12
        goto L4
    L8:
        r105 = false;
        goto L9
    L10:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
