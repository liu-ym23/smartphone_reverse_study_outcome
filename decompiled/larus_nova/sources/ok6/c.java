package ok6;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends mf6.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nf6.b f523680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f523681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f523682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f523683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f523684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeInterpolator f523685i;

    @Override // mf6.a
    public final void d(float r100) {
        nf6.b r101 = this.f523680d;
        if (r101 == null) goto L9;
        TimeInterpolator r102 = this.f523685i;
        float r103 = this.f523681e;
        float r104 = this.f523682f;
        float r105 = this.f523683g;
        float r106 = this.f523684h;
        if (r102 == null) goto L7;
        r100 = r102.getInterpolation(r100);
    L7:
        r101.f518953a = r103 + ((r105 - r103) * r100);
        r101.f518954b = r104 + ((r106 - r104) * r100);
        return;
    }

    public c(long r100, nf6.b r101, float r102, float r103, float r104, float r105, TimeInterpolator r106) {
        super(r100);
        this.f523680d = r101;
        this.f523681e = r102;
        this.f523682f = r103;
        this.f523683g = r104;
        this.f523684h = r105;
        this.f523685i = r106;
    }
}
