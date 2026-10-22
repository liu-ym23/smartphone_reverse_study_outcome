package nuc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public class g2 implements luc.f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0<?> f520684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f520685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f520686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f520687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Annotation>[] f520688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Annotation> f520689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f520690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, Integer> f520691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f520692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f520693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f520694l;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public boolean isInline() {
        return false;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.f520685c), ", ", this.f520683a + '(', ")", 0, null, new f2(this), 24, null);
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.f520691i.keySet();
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        List<Annotation> r100 = this.f520689g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        return ((Number) this.f520694l.getValue()).intValue();
    }

    @Override // luc.f
    public final int d() {
        return this.f520685c;
    }

    @Override // luc.f
    public final String f() {
        return this.f520683a;
    }

    @Override // luc.f
    public luc.o getKind() {
        return luc.p.a.f510877a;
    }

    @Override // luc.f
    public final String b(int r100) {
        return this.f520687e[r100];
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        List<Annotation> r101 = this.f520688f[r100];
        if (r101 == null) goto L5;
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof g2) == false) goto L30;
        luc.f r101 = (luc.f) r100;
        if (Intrinsics.areEqual(this.f520683a, r101.f()) == true) goto L11;
        return false;
    L11:
        if (Arrays.equals((luc.f[]) this.f520693k.getValue(), (luc.f[]) ((g2) r100).f520693k.getValue()) == true) goto L14;
        return false;
    L14:
        if (this.f520685c != r101.d()) goto L33;
        int r102 = this.f520685c;
        int r103 = 0;
    L17:
        if (r103 >= r102) goto L25;
        if (Intrinsics.areEqual(h(r103).f(), r101.h(r103).f()) == false) goto L34;
        if (Intrinsics.areEqual(h(r103).getKind(), r101.h(r103).getKind()) == false) goto L35;
        r103 = r103 + 1;
        goto L17
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    L30:
        return false;
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Integer r101 = this.f520691i.get(r100);
        if (r101 != null) goto L7;
        return -3;
    L7:
        return r101.intValue();
    }

    @Override // luc.f
    public luc.f h(int r100) {
        return ((juc.d[]) this.f520692j.getValue())[r100].getDescriptor();
    }

    @Override // luc.f
    public final boolean i(int r100) {
        return this.f520690h[r100];
    }

    public final void k(Annotation r100) {
        Intrinsics.checkNotNullParameter(r100, "annotation");
        List<Annotation> r101 = this.f520688f[this.f520686d];
        if (r101 != null) goto L5;
        r101 = new ArrayList(1);
        this.f520688f[this.f520686d] = r101;
    L5:
        r101.add(r100);
    }

    public final void l(Annotation r100) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        if (this.f520689g != null) goto L5;
        this.f520689g = new ArrayList(1);
    L5:
        List<Annotation> r101 = this.f520689g;
        Intrinsics.checkNotNull(r101);
        r101.add(r100);
    }

    public final void j(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String[] r102 = this.f520687e;
        int r103 = this.f520686d + 1;
        this.f520686d = r103;
        r102[r103] = r100;
        this.f520690h[r103] = r101;
        this.f520688f[r103] = null;
        if (r103 != (this.f520685c - 1)) goto L10;
        HashMap r104 = new HashMap();
        int r105 = this.f520687e.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r104.put(this.f520687e[r106], Integer.valueOf(r106));
        r106 = r106 + 1;
        goto L5
    L7:
        this.f520691i = r104;
        return;
    }

    public g2(String r100, m0<?> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        this.f520683a = r100;
        this.f520684b = r101;
        this.f520685c = r102;
        this.f520686d = -1;
        String[] r103 = new String[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = "[UNINITIALIZED]";
        r104 = r104 + 1;
        goto L3
    L5:
        this.f520687e = r103;
        int r105 = this.f520685c;
        this.f520688f = new List[r105];
        this.f520690h = new boolean[r105];
        this.f520691i = MapsKt.emptyMap();
        LazyThreadSafetyMode r106 = LazyThreadSafetyMode.PUBLICATION;
        this.f520692j = LazyKt.lazy(r106, new c2(this));
        this.f520693k = LazyKt.lazy(r106, new d2(this));
        this.f520694l = LazyKt.lazy(r106, new e2(this));
    }
}
