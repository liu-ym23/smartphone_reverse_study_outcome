package ie1;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends b<Integer, Unit> {

    /* JADX INFO: renamed from: ie1.a$a, reason: collision with other inner class name */
    public static final class C6256a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f489464b;

        public C6256a(int r100) {
            this.f489464b = r100;
        }

        @Override // ie1.b
        public final Integer a(Unit r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            return Integer.valueOf(this.f489464b);
        }
    }
}
