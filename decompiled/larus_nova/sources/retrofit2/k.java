package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f537503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f537504b;

    public final String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f537503a.getDeclaringClass().getName(), this.f537503a.getName(), this.f537504b});
    }

    public k(Method r100, List<?> r101) {
        this.f537503a = r100;
        this.f537504b = Collections.unmodifiableList(r101);
    }
}
