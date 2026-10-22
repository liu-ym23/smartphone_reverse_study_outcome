package kl2;

import com.bytedance.android.ec.core.arch.state.b;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C6568a f503844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f503845b;

    /* JADX INFO: renamed from: kl2.a$a, reason: collision with other inner class name */
    public static final class C6568a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f503846a;

        public C6568a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6568a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f503846a, ((C6568a) r100).f503846a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f503846a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "LynxModel(lynxSchema=" + this.f503846a + ")";
        }

        public C6568a(String r100) {
            this.f503846a = r100;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f503844a, r101.f503844a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f503845b, r101.f503845b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        C6568a r100 = this.f503844a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f503845b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECRankState(lynxModel=" + this.f503844a + ", lynxData=" + this.f503845b + ")";
    }

    public /* synthetic */ a(int r100) {
        this(new C6568a(null), null);
    }

    public a(C6568a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxModel");
        this.f503844a = r100;
        this.f503845b = r101;
    }
}
