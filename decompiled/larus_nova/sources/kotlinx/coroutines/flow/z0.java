package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes.dex */
public interface z0<T> extends i1<T>, MutableSharedFlow<T> {
    boolean compareAndSet(T r100, T r101);

    @Override // kotlinx.coroutines.flow.i1
    T getValue();

    void setValue(T r100);
}
