package me7;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes22.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f513554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.a f513555b;

    public q(s r100, b.C6810b r101) {
        this.f513554a = r100;
        this.f513555b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        Pair r102 = TuplesKt.to(0, "unknown case");
    L14:
        int r103 = ((Number) r102.component1()).intValue();
        String r104 = (String) r102.component2();
        s r105 = this.f513554a;
        b.a r106 = this.f513555b;
        r105.getClass();
        s.f(r106, r103, r104);
        return;
    L11:
        if (r101.intValue() != 0) goto L13;
        r102 = TuplesKt.to(1, "");
        goto L14
    L6:
        if (r101.intValue() != (-1)) goto L8;
        r102 = TuplesKt.to(0, "forest not init");
        goto L14
    }
}
