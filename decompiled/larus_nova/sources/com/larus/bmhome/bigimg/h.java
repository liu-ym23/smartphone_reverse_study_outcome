package com.larus.bmhome.bigimg;

import android.view.View;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements j19.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f295988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<Pair<Integer, View>> f295989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, List<Pair<Integer, View>>> f295990c;

    @Override // j19.e
    public final View d(int r100) {
        Function1<Integer, Unit> r101 = this.f295988a;
        if (r101 == null) goto L8;
        if (r101 == null) goto L7;
        r101.invoke(Integer.valueOf(r100));
    L7:
        return k.a(this.f295989b, r100);
    L8:
        Function1<Integer, List<Pair<Integer, View>>> r102 = this.f295990c;
        if (r102 == null) goto L13;
        return k.a(r102.invoke(Integer.valueOf(r100)), r100);
    L13:
        return k.a(this.f295989b, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super Integer, Unit> r100, List<? extends Pair<Integer, ? extends View>> r101, Function1<? super Integer, ? extends List<? extends Pair<Integer, ? extends View>>> r102) {
        this.f295988a = r100;
        this.f295989b = r101;
        this.f295990c = r102;
    }
}
