package androidx.camera.core.internal.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface RingBuffer<T> {

    public interface OnRemoveCallback<T> {
        void onRemove(T r1);
    }

    T dequeue();

    void enqueue(T r1);

    int getMaxCapacity();

    boolean isEmpty();
}
