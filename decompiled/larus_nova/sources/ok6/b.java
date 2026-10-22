package ok6;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends mf6.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nf6.c f523678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f523679e;

    @Override // mf6.a
    public final void d(float r100) {
        nf6.c r101 = this.f523678d;
        if (r101 == null) goto L9;
        TimeInterpolator r102 = this.f523679e;
        if (r102 == null) goto L7;
        float r103 = r102.getInterpolation(r100);
    L8:
        r101.f518955a = (r103 * 1.0f) + 0.0f;
        goto L9
    L7:
        r103 = r100;
    L9:
        nf6.c r104 = this.f523678d;
        if (r104 == null) goto L16;
        TimeInterpolator r105 = this.f523679e;
        if (r105 == null) goto L14;
        r100 = r105.getInterpolation(r100);
    L14:
        r104.f518956b = (r100 * 1.0f) + 0.0f;
        return;
    }

    public b(long r100, nf6.c r101, TimeInterpolator r102) {
        super(r100);
        this.f523678d = r101;
        this.f523679e = r102;
    }
}
