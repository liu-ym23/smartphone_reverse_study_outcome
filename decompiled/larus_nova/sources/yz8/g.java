package yz8;

import n38.z;
import wb7.k;
import yb7.j;

/* JADX INFO: loaded from: classes27.dex */
public final class g extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f569568a;

    public g(z r100) {
        this.f569568a = r100;
    }

    public final void b(ua7.e<k> r100) {
        this.f569568a.onSendSuccess();
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public final void a(ua7.e<k> r100, int r101) {
        z r102 = this.f569568a;
        if (r100 == null) goto L5;
        String r103 = r100.f549255i;
    L6:
        r102.a(r101, r103, null, null);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
