package com.bytedance.jedi.model.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class SynckerImpl$sync$5 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public static final SynckerImpl$sync$5 INSTANCE = null;

    static {
        INSTANCE = new SynckerImpl$sync$5();
    }

    public SynckerImpl$sync$5() {
        super(1, Throwable.class, "printStackTrace", "printStackTrace()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        r100.printStackTrace();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
