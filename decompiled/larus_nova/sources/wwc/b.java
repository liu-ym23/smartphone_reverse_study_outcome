package wwc;

/* JADX INFO: loaded from: classes42.dex */
public interface b<T> {
    void onComplete();

    void onError(Throwable r100);

    void onNext(T r100);

    void onSubscribe(c r100);
}
