package me7;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes22.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f513556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.a f513557b;

    public r(s r100, b.C6810b r101) {
        this.f513556a = r100;
        this.f513557b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        s r101 = this.f513556a;
        b.a r102 = this.f513557b;
        String r103 = ((Throwable) r100).getMessage();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r101.getClass();
        s.f(r102, 0, r103);
    }
}
