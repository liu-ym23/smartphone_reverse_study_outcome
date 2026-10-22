package qo9;

import com.larus.office.OfficeInputParam;
import com.larus.platform.service.e2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeInputParam> f534276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f534277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f534278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<a, Unit> f534279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f534280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, Boolean> f534281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f534282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f534283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f534284i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f534285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f534286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f534287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f534288d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f534285a == r101.f534285a) goto L12;
            return false;
        L12:
            if (this.f534286b == r101.f534286b) goto L15;
            return false;
        L15:
            if (this.f534287c == r101.f534287c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f534288d, r101.f534288d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f534285a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f534286b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f534287c == true) goto L15;
            r100 = 1237;
        L15:
            return ((r104 + r100) * 31) + this.f534288d.hashCode();
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(visible=" + this.f534285a + ", embeddedHostVisible=" + this.f534286b + ", changed=" + this.f534287c + ", reason=" + this.f534288d + ')';
        }

        public a(boolean r100, boolean r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "reason");
            this.f534285a = r100;
            this.f534286b = r101;
            this.f534287c = r102;
            this.f534288d = r103;
        }
    }

    public final void a(String r100) {
        OfficeInputParam r101 = this.f534276a.invoke();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L19;
        if (r101 == null) goto L11;
        int r104 = r101.getResourceVersion();
    L12:
        if (r104 < 0) goto L14;
    L18:
        boolean r105 = false;
    L21:
        if (this.f534280e == false) goto L38;
        Collection<Boolean> r106 = this.f534281f.values();
        if (r106.isEmpty() == false) goto L25;
    L24:
        boolean r107 = true;
    L31:
        if (r107 == false) goto L38;
        if (this.f534282g == false) goto L38;
        if (this.f534277b.invoke().booleanValue() == false) goto L38;
        if (r105 == false) goto L38;
        boolean r108 = true;
    L39:
        if (r108 == true) goto L41;
    L43:
        boolean r109 = false;
    L45:
        if (this.f534284i != r109) goto L48;
        r102 = false;
    L48:
        this.f534284i = r109;
        this.f534279d.invoke(new a(r109, r108, r102, r100));
        return;
    L41:
        if (this.f534278c.invoke().booleanValue() == true) goto L43;
        r109 = true;
        goto L45
    L25:
        Iterator<T> r110 = r106.iterator();
    L27:
        if (r110.hasNext() == false) goto L24;
        Boolean r111 = (Boolean) r110.next();
        Intrinsics.checkNotNull(r111);
        if (r111.booleanValue() == true) goto L27;
        r107 = false;
    L38:
        r108 = false;
        goto L39
    L14:
        if (e2.f365734a.isPad() == true) goto L19;
        if (this.f534283h == true) goto L18;
    L11:
        r104 = -1;
    L19:
        r105 = true;
        goto L21
    L5:
        if (r101.getResourceType() != 12) goto L7;
        r103 = true;
        goto L8
    }

    public final void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f534281f.put(r100, Boolean.valueOf(r101));
        a("host_source#" + r100);
    }

    public f(com.larus.office.plugins.inputv2.h r100, com.larus.office.plugins.inputv2.i r101, com.larus.office.plugins.inputv2.j r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "paramsProvider");
        Intrinsics.checkNotNullParameter(r101, "canReadProvider");
        Intrinsics.checkNotNullParameter(r102, "embeddedSuppressedProvider");
        Intrinsics.checkNotNullParameter(r103, "onResolved");
        this.f534276a = r100;
        this.f534277b = r101;
        this.f534278c = r102;
        this.f534279d = r103;
        this.f534280e = true;
        this.f534281f = new LinkedHashMap();
        this.f534282g = true;
    }
}
