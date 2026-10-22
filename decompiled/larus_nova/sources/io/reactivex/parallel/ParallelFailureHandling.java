package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum ParallelFailureHandling extends Enum<ParallelFailureHandling> implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    public static final ParallelFailureHandling ERROR = null;
    public static final ParallelFailureHandling RETRY = null;
    public static final ParallelFailureHandling SKIP = null;
    public static final ParallelFailureHandling STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParallelFailureHandling[] f495073a = null;

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ParallelFailureHandling apply2(Long r100, Throwable r101) {
        return this;
    }

    static {
        ParallelFailureHandling r100 = new ParallelFailureHandling("STOP", 0);
        STOP = r100;
        ParallelFailureHandling r101 = new ParallelFailureHandling("ERROR", 1);
        ERROR = r101;
        ParallelFailureHandling r102 = new ParallelFailureHandling("SKIP", 2);
        SKIP = r102;
        ParallelFailureHandling r103 = new ParallelFailureHandling("RETRY", 3);
        RETRY = r103;
        f495073a = new ParallelFailureHandling[]{r100, r101, r102, r103};
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) f495073a.clone();
    }

    public static ParallelFailureHandling valueOf(String r100) {
        return (ParallelFailureHandling) a.a(ParallelFailureHandling.class, r100);
    }

    public ParallelFailureHandling(String r100, int r101) {
        super(r100, r101);
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ ParallelFailureHandling apply(Long r100, Throwable r101) throws Exception {
        return apply2(r100, r101);
    }
}
