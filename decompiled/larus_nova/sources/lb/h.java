package lb;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f508289a;

    public h(Collection<? extends T> r100) {
        this.f508289a = new LinkedHashSet(r100);
    }
}
