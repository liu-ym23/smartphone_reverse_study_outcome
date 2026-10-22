package tba;

import com.obric.assistant.component.z3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<LinkedHashMap<Integer, Integer>> f545328h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f545329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f545331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f545332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f545333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f545334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f545335g;

    public static final class a {
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f545329a == r101.f545329a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545330b, r101.f545330b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545331c, r101.f545331c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f545332d, r101.f545332d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f545333e, r101.f545333e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f545334f, r101.f545334f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f545335g, r101.f545335g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f545329a * 31;
        String r101 = this.f545330b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f545331c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f545332d.hashCode()) * 31;
        Function1<String, Unit> r108 = this.f545333e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function0<Unit> r111 = this.f545334f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Function0<Boolean> r114 = this.f545335g;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricBanner(bannerType=" + this.f545329a + ", bannerContent=" + this.f545330b + ", bannerSubContent=" + this.f545331c + ", ext=" + this.f545332d + ", onBusinessButtonClick=" + this.f545333e + ", onCloseButtonClick=" + this.f545334f + ", canShow=" + this.f545335g + ')';
    }

    static {
        f545328h = LazyKt.lazy(new tba.a());
    }

    public b(int r100, String r101, String r102, Map r103, Function1 r104, Function0 r105, z3 r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = MapsKt.emptyMap();
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r106 = null;
    L20:
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.f545329a = r100;
        this.f545330b = r101;
        this.f545331c = r102;
        this.f545332d = r103;
        this.f545333e = r104;
        this.f545334f = r105;
        this.f545335g = r106;
    }
}
