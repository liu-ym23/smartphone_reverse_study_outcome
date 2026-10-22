package q26;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f531444b;

    @Override // q26.j
    public final Map<Class<?>, Object> getAllDependency() {
        return getServiceContext().getAllDependency();
    }

    @Override // q26.j
    public final String getBid() {
        return this.f531443a;
    }

    @Override // q26.j
    public final h getServiceContext() {
        return this.f531444b;
    }

    @Override // q26.j
    public final <T> T a(Class<T> r100) {
        return (T) j.a.a(this, r100);
    }

    @Override // q26.j
    public final <T extends c> T getService(Class<T> r100) {
        return (T) j.a.b(this, r100);
    }

    public b(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "businessId");
        Intrinsics.checkNotNullParameter(r101, "serviceContext");
        this.f531443a = r100;
        this.f531444b = r101;
    }
}
