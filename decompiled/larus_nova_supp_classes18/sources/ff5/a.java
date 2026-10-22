package ff5;

import gf5.c;
import gf5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<T extends c> implements e<c> {

    /* JADX INFO: renamed from: ff5.a$a, reason: collision with other inner class name */
    public static final class C0229a {
    }

    static {
    }

    public a() {
    }

    public abstract void b(T r1);

    @Override // gf5.e
    public final /* synthetic */ void getPriority() {
    }

    @Override // gf5.e
    public final void a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        b(r2);
    }
}
