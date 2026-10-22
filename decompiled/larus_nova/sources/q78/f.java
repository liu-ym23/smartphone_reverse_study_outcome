package q78;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes24.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f531987a;

    public abstract void a(List<c> r100);

    public f() {
        this.f531987a = LazyKt.lazy(new d(this));
    }
}
