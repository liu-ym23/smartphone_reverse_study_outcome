package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.t;
import com.google.common.base.v;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final t<? extends com.google.common.cache.b> f274742q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f274743r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f274744s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f274745t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f274746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f274748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f274749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f274750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @CheckForNull
    public m<? super K, ? super V> f274751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @CheckForNull
    public LocalCache.Strength f274752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @CheckForNull
    public LocalCache.Strength f274753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f274754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f274755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f274756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @CheckForNull
    public Equivalence<Object> f274757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @CheckForNull
    public Equivalence<Object> f274758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @CheckForNull
    public l<? super K, ? super V> f274759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @CheckForNull
    public v f274760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t<? extends com.google.common.cache.b> f274761p;

    public static final enum NullListener extends Enum<NullListener> implements l<Object, Object> {
        public static final NullListener INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NullListener[] f274762a = null;

        @Override // com.google.common.cache.l
        public void onRemoval(RemovalNotification<Object, Object> r100) {
        }

        static {
            NullListener r100 = new NullListener();
            INSTANCE = r100;
            f274762a = new NullListener[]{r100};
        }

        public NullListener() {
            super("INSTANCE", 0);
        }

        public static NullListener[] values() {
            return (NullListener[]) f274762a.clone();
        }

        public static NullListener valueOf(String r100) {
            return (NullListener) r27.a.a(NullListener.class, r100);
        }
    }

    public static final enum OneWeigher extends Enum<OneWeigher> implements m<Object, Object> {
        public static final OneWeigher INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OneWeigher[] f274763a = null;

        @Override // com.google.common.cache.m
        public int weigh(Object r100, Object r101) {
            return 1;
        }

        static {
            OneWeigher r100 = new OneWeigher();
            INSTANCE = r100;
            f274763a = new OneWeigher[]{r100};
        }

        public OneWeigher() {
            super("INSTANCE", 0);
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) f274763a.clone();
        }

        public static OneWeigher valueOf(String r100) {
            return (OneWeigher) r27.a.a(OneWeigher.class, r100);
        }
    }

    public class a implements com.google.common.cache.b {
        public a() {
        }

        @Override // com.google.common.cache.b
        public final void a(int r100) {
        }

        @Override // com.google.common.cache.b
        public final void b() {
        }

        @Override // com.google.common.cache.b
        public final void c(long r100) {
        }

        @Override // com.google.common.cache.b
        public final void d(int r100) {
        }

        @Override // com.google.common.cache.b
        public final void e(long r100) {
        }

        @Override // com.google.common.cache.b
        public final e snapshot() {
            return CacheBuilder.f274743r;
        }
    }

    public class b extends v {
        @Override // com.google.common.base.v
        public final long a() {
            return 0;
        }

        public b() {
        }
    }

    static {
        f274742q = Suppliers.a(new a());
        f274743r = new e(0, 0, 0, 0, 0, 0);
        f274744s = new b();
        f274745t = Logger.getLogger(CacheBuilder.class.getName());
    }

    public final void a() {
        boolean r100 = true;
        if (this.f274751f != null) goto L10;
        if (this.f274750e == (-1)) goto L8;
        r100 = false;
    L8:
        com.google.common.base.m.p(r100, "maximumWeight requires weigher");
        return;
    L10:
        if (this.f274746a == false) goto L17;
        if (this.f274750e != (-1)) goto L15;
        r100 = false;
    L15:
        com.google.common.base.m.p(r100, "weigher requires maximumWeight");
        return;
    L17:
        if (this.f274750e != (-1)) goto L22;
        f274745t.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        return;
    }

    public CacheBuilder() {
        this.f274746a = true;
        this.f274747b = -1;
        this.f274748c = -1;
        this.f274749d = -1;
        this.f274750e = -1;
        this.f274754i = -1;
        this.f274755j = -1;
        this.f274756k = -1;
        this.f274761p = f274742q;
    }

    public final String toString() {
        com.google.common.base.j.a r100 = com.google.common.base.j.b(this);
        int r101 = this.f274747b;
        if (r101 == (-1)) goto L5;
        r100.c("initialCapacity", String.valueOf(r101));
    L5:
        int r102 = this.f274748c;
        if (r102 == (-1)) goto L8;
        r100.c("concurrencyLevel", String.valueOf(r102));
    L8:
        long r103 = this.f274749d;
        if (r103 == (-1)) goto L11;
        r100.a("maximumSize", r103);
    L11:
        long r104 = this.f274750e;
        if (r104 == (-1)) goto L15;
        r100.a("maximumWeight", r104);
    L15:
        if (this.f274754i == (-1)) goto L18;
        r100.b("expireAfterWrite", this.f274754i + "ns");
    L18:
        if (this.f274755j == (-1)) goto L20;
        r100.b("expireAfterAccess", this.f274755j + "ns");
    L20:
        LocalCache.Strength r105 = this.f274752g;
        if (r105 == null) goto L23;
        r100.b("keyStrength", com.google.common.base.a.a(r105.toString()));
    L23:
        LocalCache.Strength r106 = this.f274753h;
        if (r106 == null) goto L27;
        r100.b("valueStrength", com.google.common.base.a.a(r106.toString()));
    L27:
        if (this.f274757l == null) goto L30;
        r100.d("keyEquivalence");
    L30:
        if (this.f274758m == null) goto L33;
        r100.d("valueEquivalence");
    L33:
        if (this.f274759n == null) goto L36;
        r100.d("removalListener");
    L36:
        return r100.toString();
    }
}
