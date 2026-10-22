package m9c;

import com.ss.android.lark.pb.ug_reach.MaterialBase;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C6784a f512662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaterialBase f512663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f512664e;

    /* JADX INFO: renamed from: m9c.a$a, reason: collision with other inner class name */
    public static final class C6784a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f512665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f512666b;

        /* JADX INFO: renamed from: m9c.a$a$a, reason: collision with other inner class name */
        public static final class C6785a {
        }

        static {
        }

        public /* synthetic */ C6784a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6784a) == true) goto L8;
            return false;
        L8:
            C6784a r101 = (C6784a) r100;
            if (Intrinsics.areEqual(this.f512665a, r101.f512665a) == true) goto L12;
            return false;
        L12:
            if (this.f512666b == r101.f512666b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f512665a.hashCode() * 31;
            if (this.f512666b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Event(name=" + this.f512665a + ", status=" + this.f512666b + ')';
        }

        public C6784a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f512665a = r100;
            this.f512666b = r101;
        }
    }

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f512660a, r101.f512660a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512661b, r101.f512661b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512662c, r101.f512662c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512663d, r101.f512663d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f512664e, r101.f512664e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f512660a.hashCode() * 31) + this.f512661b.hashCode()) * 31) + this.f512662c.hashCode()) * 31;
        MaterialBase r101 = this.f512663d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, String> r105 = this.f512664e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachPointEvent(reachPointId=" + this.f512660a + ", reachPointType=" + this.f512661b + ", event=" + this.f512662c + ", materialBase=" + this.f512663d + ", extra=" + this.f512664e + ')';
    }

    public a(String r100, String r101, C6784a r102, MaterialBase r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter(r101, "reachPointType");
        Intrinsics.checkNotNullParameter(r102, "event");
        this.f512660a = r100;
        this.f512661b = r101;
        this.f512662c = r102;
        this.f512663d = r103;
        this.f512664e = null;
    }
}
