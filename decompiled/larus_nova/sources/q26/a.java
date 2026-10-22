package q26;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f531440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f531441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s26.b f531442c;

    @Override // q26.h
    public final Map<Class<?>, Object> getAllDependency() {
        return this.f531442c.b();
    }

    @Override // q26.h
    public final s26.b b() {
        return this.f531442c;
    }

    @Override // q26.h
    public Context getContext() {
        return this.f531440a;
    }

    @Override // q26.h
    public final boolean isDebug() {
        return this.f531441b;
    }

    @Override // q26.h
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f531442c.a(r100);
    }

    public a(Context r100, boolean r101) {
        this.f531440a = r100;
        this.f531441b = r101;
        this.f531442c = new s26.b();
    }

    @Override // q26.h
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f531442c.c(r100, r101);
    }
}
