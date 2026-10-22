package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface z0<T> extends i1<T>, MutableSharedFlow<T> {
    boolean compareAndSet(T r1, T r2);

    @Override // kotlinx.coroutines.flow.i1
    T getValue();

    void setValue(T r1);
}
