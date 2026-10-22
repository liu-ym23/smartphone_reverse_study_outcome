package e98;

import buc.b;
import buc.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<C5759a> f471533a = null;

    /* JADX INFO: renamed from: e98.a$a, reason: collision with other inner class name */
    public static final class C5759a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471534a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5759a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471534a, ((C5759a) r100).f471534a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471534a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "BusinessIntent(action=" + this.f471534a + ')';
        }

        public C5759a(String r100) {
            this.f471534a = r100;
        }
    }

    static {
        f471533a = b.d(null);
    }
}
