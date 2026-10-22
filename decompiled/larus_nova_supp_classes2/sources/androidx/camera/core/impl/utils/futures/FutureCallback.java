package androidx.camera.core.impl.utils.futures;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable r1);

    void onSuccess(V r1);
}
