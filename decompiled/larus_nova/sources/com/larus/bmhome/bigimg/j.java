package com.larus.bmhome.bigimg;

import android.view.View;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class j implements j19.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, List<Pair<Integer, View>>> f295999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<Pair<Integer, View>> f296000b;

    @Override // j19.e
    public final View d(int r100) {
        Function1<Integer, List<Pair<Integer, View>>> r101 = this.f295999a;
        if (r101 == null) goto L7;
        return k.a(r101.invoke(Integer.valueOf(r100)), r100);
    L7:
        return k.a(this.f296000b, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super Integer, ? extends List<? extends Pair<Integer, ? extends View>>> r100, List<? extends Pair<Integer, ? extends View>> r101) {
        this.f295999a = r100;
        this.f296000b = r101;
    }
}
