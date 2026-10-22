package io.reactivex.internal.operators.observable;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes41.dex */
final enum ObservableInternalHelper$MapToInt extends Enum<ObservableInternalHelper$MapToInt> implements Function<Object, Object> {
    public static final ObservableInternalHelper$MapToInt INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObservableInternalHelper$MapToInt[] f494073a = null;

    static {
        ObservableInternalHelper$MapToInt r100 = new ObservableInternalHelper$MapToInt();
        INSTANCE = r100;
        f494073a = new ObservableInternalHelper$MapToInt[]{r100};
    }

    public ObservableInternalHelper$MapToInt() {
        super("INSTANCE", 0);
    }

    public static ObservableInternalHelper$MapToInt[] values() {
        return (ObservableInternalHelper$MapToInt[]) f494073a.clone();
    }

    public static ObservableInternalHelper$MapToInt valueOf(String r100) {
        return (ObservableInternalHelper$MapToInt) r27.a.a(ObservableInternalHelper$MapToInt.class, r100);
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object r100) throws Exception {
        return 0;
    }
}
