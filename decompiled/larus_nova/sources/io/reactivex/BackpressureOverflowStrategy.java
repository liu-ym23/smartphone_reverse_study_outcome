package io.reactivex;

/* JADX INFO: loaded from: classes41.dex */
public final enum BackpressureOverflowStrategy extends Enum<BackpressureOverflowStrategy> {
    public static final BackpressureOverflowStrategy DROP_LATEST = null;
    public static final BackpressureOverflowStrategy DROP_OLDEST = null;
    public static final BackpressureOverflowStrategy ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackpressureOverflowStrategy[] f492815a = null;

    static {
        BackpressureOverflowStrategy r100 = new BackpressureOverflowStrategy("ERROR", 0);
        ERROR = r100;
        BackpressureOverflowStrategy r101 = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
        DROP_OLDEST = r101;
        BackpressureOverflowStrategy r102 = new BackpressureOverflowStrategy("DROP_LATEST", 2);
        DROP_LATEST = r102;
        f492815a = new BackpressureOverflowStrategy[]{r100, r101, r102};
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[]) f492815a.clone();
    }

    public static BackpressureOverflowStrategy valueOf(String r100) {
        return (BackpressureOverflowStrategy) r27.a.a(BackpressureOverflowStrategy.class, r100);
    }

    public BackpressureOverflowStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
