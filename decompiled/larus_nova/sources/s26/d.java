package s26;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f540305c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f540306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f540307b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f540308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f540309b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f540308a, r101.f540308a) == true) goto L12;
            return false;
        L12:
            if (this.f540309b == r101.f540309b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f540308a.hashCode() * 31;
            if (this.f540309b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "InitializeState(method=" + this.f540308a + ", shouldInvoke=" + this.f540309b + ')';
        }

        public b(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            this.f540308a = r100;
            this.f540309b = true;
        }
    }

    static {
        f540305c = new d();
    }

    public d() {
        this.f540306a = new ConcurrentHashMap();
        this.f540307b = new ConcurrentHashMap();
    }

    public final e b(String r100) {
        e r101 = this.f540306a.get(r100);
        if (r101 != null) goto L6;
        e.a r102 = new e.a();
        Intrinsics.checkNotNullParameter(r100, "bid");
        r102.f540313b = r100;
        e r103 = new e(r102);
        this.f540306a.put(r100, r103);
        e(r100);
        return r103;
    L6:
        return r101;
    }

    public final <T extends q26.c> T c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) d("default_bid", r100);
    }

    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        b r101 = this.f540307b.get(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.f540309b == false) goto L9;
        r101.f540309b = false;
        r101.f540308a.invoke();
        return true;
    L9:
        return false;
    }

    public final <T extends q26.c> T d(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        e r102 = b(r100);
        String r103 = r101.getName();
        Intrinsics.checkNotNullParameter(r103, "clazzName");
        T r104 = (T) r102.f540310a.get(r103);
        if ((r104 instanceof f) == false) goto L6;
        T r105 = (T) ((f) r104).G0();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.bytedance.ies.bullet.service.base.impl.ServiceCenter.get");
        b(r100).a(r101.getName(), r105);
        return r105;
    L6:
        if (r104 != null) goto L13;
        e r106 = b("default_bid");
        String r107 = r101.getName();
        Intrinsics.checkNotNullParameter(r107, "clazzName");
        T r108 = (T) r106.f540310a.get(r107);
        if ((r108 instanceof q26.c) == true) goto L14;
        return null;
    L14:
        return r108;
    L13:
        return r104;
    }

    public final d a(String r100, Class r101, q26.c r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "serviceInst");
        b(r100).a(r101.getName(), r102);
        return this;
    }
}
