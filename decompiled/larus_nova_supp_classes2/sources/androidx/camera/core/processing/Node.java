package androidx.camera.core.processing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface Node<I, O> {
    void release();

    O transform(I r1);
}
