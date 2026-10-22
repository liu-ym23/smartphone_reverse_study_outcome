package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final enum FlowableInternalHelper$RequestMax extends Enum<FlowableInternalHelper$RequestMax> implements Consumer<wwc.c> {
    public static final FlowableInternalHelper$RequestMax INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowableInternalHelper$RequestMax[] f493143a = null;

    static {
        FlowableInternalHelper$RequestMax r100 = new FlowableInternalHelper$RequestMax();
        INSTANCE = r100;
        f493143a = new FlowableInternalHelper$RequestMax[]{r100};
    }

    public FlowableInternalHelper$RequestMax() {
        super("INSTANCE", 0);
    }

    public static FlowableInternalHelper$RequestMax[] values() {
        return (FlowableInternalHelper$RequestMax[]) f493143a.clone();
    }

    public static FlowableInternalHelper$RequestMax valueOf(String r100) {
        return (FlowableInternalHelper$RequestMax) r27.a.a(FlowableInternalHelper$RequestMax.class, r100);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(wwc.c r100) throws Exception {
        r100.request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(wwc.c r100) throws Exception {
        accept2(r100);
    }
}
