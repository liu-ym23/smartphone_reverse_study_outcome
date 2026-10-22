package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MutableStateObservable<T> extends StateObservable<T> {
    public static <T> MutableStateObservable<T> withInitialError(Throwable r2) {
        return new MutableStateObservable(r2, true);
    }

    public static <T> MutableStateObservable<T> withInitialState(T r2) {
        return new MutableStateObservable(r2, false);
    }

    public void setError(Throwable r1) {
        updateStateAsError(r1);
    }

    public void setState(T r1) {
        updateState(r1);
    }

    private MutableStateObservable(Object r1, boolean r2) {
        super(r1, r2);
    }
}
