package ctc;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f465380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f465381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f465382c;

    public final boolean a() {
        if (this.f465381b <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "HorizontalScrollable(scrollX=" + this.f465380a + ", maxScroll=" + this.f465381b + ')';
    }

    public a() {
        this(0.1f);
    }

    public a(float r100) {
        this.f465382c = r100;
    }

    public final void b(float r100) {
        float r101 = this.f465381b;
        this.f465380a = Math.max((-r101) - (Math.abs(r101) * this.f465382c), Math.min(Math.abs(this.f465381b) * this.f465382c, r100));
    }
}
