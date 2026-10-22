package y9;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes43.dex */
public final class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f566945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f566946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Type f566947d;

    public i() {
        throw null;
    }

    public final T a() {
        T r100 = (T) h.c(this.f566944a, this.f566947d, this.f566946c);
        this.f566945b = r100;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f566946c;
    }

    public Type getType() {
        return this.f566947d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(String r100, Object r101, int r102) {
        Class<?> r103 = r101.getClass();
        this.f566944a = r100;
        this.f566946c = r101;
        this.f566947d = r103;
    }
}
