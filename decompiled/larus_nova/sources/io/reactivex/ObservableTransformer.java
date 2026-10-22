package io.reactivex;

/* JADX INFO: loaded from: classes41.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> r100);
}
