package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes42.dex */
public final class h1 implements g1 {
    public h1() {
    }

    public final String toString() {
        return "SharingStarted.Eagerly";
    }

    @Override // kotlinx.coroutines.flow.g1
    public final Flow<SharingCommand> a(i1<Integer> r100) {
        return new n(SharingCommand.START);
    }
}
