package com.bytedance.jedi.model.guava.cache;

import com.bytedance.jedi.model.guava.base.MoreObjects;
import com.bytedance.jedi.model.guava.base.Preconditions;
import com.bytedance.jedi.model.guava.base.Ticker;
import java.util.logging.Logger;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class CacheBuilder<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Ticker f251083h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f251084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f251085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f251086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f251087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f251088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f251089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f251090g;

    public static final enum NullListener extends Enum<NullListener> implements RemovalListener<Object, Object> {
        public static final NullListener INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NullListener[] f251091a = null;

        @Override // com.bytedance.jedi.model.guava.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> r100) {
        }

        static {
            NullListener r100 = new NullListener();
            INSTANCE = r100;
            f251091a = new NullListener[]{r100};
        }

        public NullListener() {
            super("INSTANCE", 0);
        }

        public static NullListener[] values() {
            return (NullListener[]) f251091a.clone();
        }

        public static NullListener valueOf(String r100) {
            return (NullListener) a.a(NullListener.class, r100);
        }
    }

    public static final enum OneWeigher extends Enum<OneWeigher> implements Weigher<Object, Object> {
        public static final OneWeigher INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OneWeigher[] f251092a = null;

        @Override // com.bytedance.jedi.model.guava.cache.Weigher
        public int weigh(Object r100, Object r101) {
            return 1;
        }

        static {
            OneWeigher r100 = new OneWeigher();
            INSTANCE = r100;
            f251092a = new OneWeigher[]{r100};
        }

        public OneWeigher() {
            super("INSTANCE", 0);
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) f251092a.clone();
        }

        public static OneWeigher valueOf(String r100) {
            return (OneWeigher) a.a(OneWeigher.class, r100);
        }
    }

    static {
        f251083h = new AnonymousClass1();
        Logger.getLogger(CacheBuilder.class.getName());
    }

    public static CacheBuilder<Object, Object> c() {
        return new CacheBuilder();
    }

    public final <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        boolean r100 = false;
        if (this.f251087d != (-1)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        if (this.f251090g != (-1)) goto L10;
        r100 = true;
    L10:
        if (r100 == false) goto L14;
        return new LocalCache.LocalManualCache(this);
    L14:
        throw new IllegalStateException("refreshAfterWrite requires a LoadingCache");
    L16:
        throw new IllegalStateException("maximumWeight requires weigher");
    L5:
        r101 = false;
        goto L6
    }

    public final String toString() {
        MoreObjects.ToStringHelper r100 = new MoreObjects.ToStringHelper("CacheBuilder");
        int r101 = this.f251084a;
        if (r101 == (-1)) goto L5;
        r100.a("initialCapacity", String.valueOf(r101));
    L5:
        int r102 = this.f251085b;
        if (r102 == (-1)) goto L8;
        r100.a("concurrencyLevel", String.valueOf(r102));
    L8:
        long r103 = this.f251086c;
        if (r103 == (-1)) goto L11;
        r100.a("maximumSize", String.valueOf(r103));
    L11:
        long r104 = this.f251087d;
        if (r104 == (-1)) goto L15;
        r100.a("maximumWeight", String.valueOf(r104));
    L15:
        if (this.f251088e == (-1)) goto L18;
        r100.a("expireAfterWrite", this.f251088e + "ns");
    L18:
        if (this.f251089f == (-1)) goto L21;
        r100.a("expireAfterAccess", this.f251089f + "ns");
    L21:
        return r100.toString();
    }

    private CacheBuilder() {
        this.f251084a = -1;
        this.f251085b = -1;
        this.f251086c = -1;
        this.f251087d = -1;
        this.f251088e = -1;
        this.f251089f = -1;
        this.f251090g = -1;
    }

    public final void b(long r100) {
        long r101 = this.f251086c;
        boolean r102 = false;
        if (r101 != (-1)) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.a(r103, "maximum size was already set to %s", r101);
        long r104 = this.f251087d;
        if (r104 != (-1)) goto L9;
        boolean r105 = true;
    L10:
        Preconditions.a(r105, "maximum weight was already set to %s", r104);
        if (r100 < 0) goto L13;
        r102 = true;
    L13:
        if (r102 == false) goto L17;
        this.f251086c = r100;
        return;
    L17:
        throw new IllegalArgumentException("maximum size must not be negative");
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
