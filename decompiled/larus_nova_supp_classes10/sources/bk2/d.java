package bk2;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface d {
    Disposable add(Disposable r1);

    void clearDisposable();

    Disposable ignore(Disposable r1);

    void remove(Disposable r1);
}
