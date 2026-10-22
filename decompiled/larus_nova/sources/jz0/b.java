package jz0;

import com.bytedance.keva.Keva;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements iz0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f501094a;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f501095a;

        public a(b r100) {
            this.f501095a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Map<String, ?> call() {
            return this.f501095a.f501094a.getAll();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    @Override // iz0.a
    public final Completable clear() {
        this.f501094a.clear();
        return Completable.complete();
    }

    @Override // iz0.a
    public final Single<Map<String, ?>> getAll() {
        return Single.fromCallable(new a(this));
    }

    @Override // iz0.a
    public final Single getString() {
        Intrinsics.checkNotNullParameter("__version__", "key");
        Intrinsics.checkNotNullParameter("", "defValue");
        return Single.fromCallable(new c(this));
    }

    public b(Keva r100) {
        Intrinsics.checkNotNullParameter(r100, "kevaImpl");
        this.f501094a = r100;
    }

    @Override // iz0.a
    public final Completable c(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r100, "value");
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L55;
        Map.Entry<String, ?> r102 = r101.next();
        Object r103 = r102.getValue();
        if ((r103 instanceof Boolean) == true) goto L7;
        if ((r103 instanceof String) == true) goto L14;
        if ((r103 instanceof byte[]) == true) goto L21;
        if ((r103 instanceof Integer) == true) goto L28;
        if ((r103 instanceof Long) == true) goto L35;
        if ((r103 instanceof Float) == true) goto L42;
        if ((r103 instanceof Double) == false) goto L4;
        Keva r104 = this.f501094a;
        String r105 = r102.getKey();
        Object r106 = r102.getValue();
        if (r106 == null) goto L53;
        r104.storeDouble(r105, ((Double) r106).doubleValue());
        goto L4
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L42:
        Keva r107 = this.f501094a;
        String r108 = r102.getKey();
        Object r109 = r102.getValue();
        if (r109 == null) goto L46;
        r107.storeFloat(r108, ((Float) r109).floatValue());
        goto L4
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L35:
        Keva r110 = this.f501094a;
        String r111 = r102.getKey();
        Object r112 = r102.getValue();
        if (r112 == null) goto L39;
        r110.storeLong(r111, ((Long) r112).longValue());
        goto L4
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L28:
        Keva r113 = this.f501094a;
        String r114 = r102.getKey();
        Object r115 = r102.getValue();
        if (r115 == null) goto L32;
        r113.storeInt(r114, ((Integer) r115).intValue());
        goto L4
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L21:
        Keva r116 = this.f501094a;
        String r117 = r102.getKey();
        Object r118 = r102.getValue();
        if (r118 == null) goto L25;
        r116.storeBytes(r117, (byte[]) r118);
        goto L4
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
    L14:
        Keva r119 = this.f501094a;
        String r120 = r102.getKey();
        Object r121 = r102.getValue();
        if (r121 == null) goto L18;
        r119.storeString(r120, (String) r121);
        goto L4
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L7:
        Keva r122 = this.f501094a;
        String r123 = r102.getKey();
        Object r124 = r102.getValue();
        if (r124 == null) goto L11;
        r122.storeBoolean(r123, ((Boolean) r124).booleanValue());
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L55:
        return Completable.complete();
    }

    @Override // iz0.a
    public final Completable f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f501094a.storeBoolean(r100, true);
        return Completable.complete();
    }

    @Override // iz0.a
    public final Completable g(String r100) {
        Intrinsics.checkNotNullParameter("__version__", "key");
        a("__version__", r100);
        return Completable.complete();
    }

    @Override // iz0.a
    public final boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f501094a.getBoolean(r100, false);
    }

    @Override // iz0.a
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f501094a.erase(r100);
    }

    @Override // iz0.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f501094a.storeString(r100, r101);
    }

    @Override // iz0.a
    public final void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f501094a.storeLong(r100, r101);
    }

    @Override // iz0.a
    public final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return this.f501094a.getString(r100, r101);
    }

    @Override // iz0.a
    public final long e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f501094a.getLong(r100, r101);
    }
}
