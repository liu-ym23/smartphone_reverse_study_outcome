package vd9;

import androidx.collection.LruCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b<F, T> implements c<F, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, F, T> f554244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<String, ? extends T> f554245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f554246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f554247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f554248e;

    public static final class a {
    }

    static {
    }

    @Override // vd9.c
    public final float a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        int r101 = this.f554248e;     // Catch: Throwable -> L9
        if (r101 <= 0) goto L18;
        int r102 = this.f554247d;     // Catch: Throwable -> L9
        if (r102 > 0) goto L8;
        return 0.0f;
    L8:
        return ((int) ((r101 / r102) * 100)) / 100.0f;
    L18:
        return 0.0f;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Object r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        com.larus.im.internal.delegate.a.f348188b.e("ElementConvertor", "getHitCacheRatio failed:" + r105);
        r104 = Float.valueOf(0.0f);
    L15:
        return ((Number) r104).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(final int r100, Function2<? super String, ? super F, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "parser");
        this.f554244a = r101;
        this.f554246c = LazyKt.lazy(new vd9.a(r100));
    }

    @Override // vd9.c
    public final void b(String r100, T r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L13;
        if (r101 == null) goto L14;
        this.f554245b = TuplesKt.to(r100, r101);
        ((LruCache) this.f554246c.getValue()).put(r100, r101);
        return;
    L14:
        return;
    L13:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    @Override // vd9.c
    public final T c(String r100, F r101, boolean r102) {
        T r103 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        wd9.a.f559312a.getClass();
        String r104 = wd9.a.C8097a.a(r100, r101);
        boolean r105 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L38;
        if (r104 != null) goto L15;
    L16:
        r105 = true;
    L17:
        if (r105 == true) goto L38;
        if (r102 == false) goto L38;
        this.f554247d++;
        this.f554248e++;
        Pair<String, ? extends T> r107 = this.f554245b;
        if (r107 == null) goto L23;
        String r108 = r107.getFirst();
    L25:
        if (Intrinsics.areEqual(r108, r104) == false) goto L30;
        Pair<String, ? extends T> r109 = this.f554245b;
        if (r109 != null) goto L29;
        return null;
    L29:
        return r109.getSecond();
    L30:
        Object r110 = ((LruCache) this.f554246c.getValue()).get(r104);
        if (r110 != null) goto L35;
        T r111 = this.f554244a.invoke(r100, r101);
        if (r111 == null) goto L36;
        this.f554248e--;
        ((LruCache) this.f554246c.getValue()).put(r104, r111);
        r103 = r111;
    L36:
        this.f554245b = TuplesKt.to(r104, r103);
        return r103;
    L35:
        r103 = (T) r110;
        goto L36
    L23:
        r108 = null;
        goto L25
    L15:
        if (r104.length() != 0) goto L17;
    L38:
        Function2<String, F, T> r112 = this.f554244a;
        if (r100 != null) goto L42;
        r100 = "";
    L42:
        return r112.invoke(r100, r101);
    L8:
        if (r100.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
