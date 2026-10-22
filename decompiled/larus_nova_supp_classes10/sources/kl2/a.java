package kl2;

import com.bytedance.android.ec.core.arch.state.b;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public final C0150a a;
    public final Map<String, Object> b;

    /* JADX INFO: renamed from: kl2.a$a, reason: collision with other inner class name */
    public static final class C0150a {
        public final String a;

        public C0150a() {
            this(null);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof C0150a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((C0150a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "LynxModel(lynxSchema=" + this.a + ")";
        }

        public C0150a(String r1) {
            this.a = r1;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        C0150a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECRankState(lynxModel=" + this.a + ", lynxData=" + this.b + ")";
    }

    public /* synthetic */ a(int r2) {
        this(new C0150a(null), null);
    }

    public a(C0150a r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxModel");
        this.a = r2;
        this.b = r3;
    }
}
