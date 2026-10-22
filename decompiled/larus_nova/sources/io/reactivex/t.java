package io.reactivex;

/* JADX INFO: loaded from: classes41.dex */
public interface t<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> r100);
}
