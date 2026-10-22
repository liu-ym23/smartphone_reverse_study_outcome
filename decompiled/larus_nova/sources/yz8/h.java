package yz8;

import com.larus.login.impl.b4;
import n38.z;
import wb7.k;
import yb7.j;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f569569a;

    public h(b4 r100) {
        this.f569569a = r100;
    }

    public final void b(ua7.e<k> r100) {
        this.f569569a.onSendSuccess();
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public final void a(ua7.e<k> r100, int r101) {
        z r102 = this.f569569a;
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.f549255i;
    L6:
        if (r100 == null) goto L8;
        Integer r105 = Integer.valueOf(r100.f549254h);
    L9:
        if (r100 == null) goto L11;
        r103 = r100.f549256j;
    L11:
        r102.a(r101, r104, r105, r103);
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
