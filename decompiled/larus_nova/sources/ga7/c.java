package ga7;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements v97.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<T> f480573b;

    @Override // v97.d
    public final T getValue() {
        return this.f480573b.invoke();
    }

    @Override // v97.d
    public final String name() {
        return this.f480572a;
    }

    public c(String r100, Function0 r101) {
        this.f480572a = r100;
        this.f480573b = r101;
    }
}
