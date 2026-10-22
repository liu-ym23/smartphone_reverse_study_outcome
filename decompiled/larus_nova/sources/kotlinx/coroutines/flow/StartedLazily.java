package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes42.dex */
public final class StartedLazily implements g1 {
    public StartedLazily() {
    }

    public final String toString() {
        return "SharingStarted.Lazily";
    }

    @Override // kotlinx.coroutines.flow.g1
    public final Flow<SharingCommand> a(i1<Integer> r100) {
        return new c1(new StartedLazily$command$1(r100, null));
    }
}
