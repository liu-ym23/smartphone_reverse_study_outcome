package com.larus.av_call.view;

import android.os.Handler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<T, Integer, Unit> f290687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super T, ? super Integer, Unit> f290688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super T, ? super Integer, Unit> f290689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f290690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends T> f290691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f290692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f290693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f290694h;

    public final void a() {
        Handler r100 = this.f290690d;
        if (r100 != null) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        com.larus.utils.l0.b(new j(r100));
        this.f290687a.invoke(null, -1);
        this.f290693g = 0;
        List<? extends T> r101 = this.f290691e;
        if (r101.isEmpty() == false) goto L11;
        return;
    L11:
        long r102 = this.f290692f;
        if (r102 > 0) goto L14;
        return;
    L14:
        b(r100, r101, r102);
    }

    public o(f r100) {
        Intrinsics.checkNotNullParameter(r100, "onUpdateText");
        this.f290687a = r100;
        this.f290688b = new l();
        this.f290689c = new m();
        this.f290691e = CollectionsKt.emptyList();
        this.f290692f = 5000;
        this.f290694h = new n(this);
    }

    public final void b(final Handler r100, final List<? extends T> r101, final long r110) {
        int r102 = this.f290693g;
        this.f290693g = r102 + 1;
        int r103 = r102 % r101.size();
        Function2<T, Integer, Unit> r104 = this.f290687a;
        Object r105 = ListProtector.get(r101, r103);
        T r106 = (T) r105;
        r104.invoke(r106, Integer.valueOf(r103));
        this.f290689c.invoke((Object) ListProtector.get(r101, r103), Integer.valueOf(r103));
        if (this.f290693g < r101.size()) goto L5;
        this.f290693g = 0;
    L5:
        r100.postDelayed(new k(this, r100, r101, r110), r110);
    }
}
