package i41;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488190a;

    public n(a r100) {
        this.f488190a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        long r101 = ((Number) r100).longValue();
        return Long.valueOf(((long) this.f488190a.f488156b) - r101);
    }
}
