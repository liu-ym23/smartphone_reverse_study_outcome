package gk4;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<f> f481542a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f481543a = null;

        static {
            f481543a = new e();
        }
    }

    public e() {
        this.f481542a = new CopyOnWriteArraySet();
    }

    @Override // gk4.g
    public final void a(f r100) {
        ((CopyOnWriteArraySet) this.f481542a).add(r100);
    }
}
