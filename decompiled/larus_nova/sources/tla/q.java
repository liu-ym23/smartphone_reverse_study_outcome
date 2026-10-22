package tla;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f546750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f546751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f546752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f546753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f546754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f546755f;

    public q() {
    }

    public final void a(float r110, float r210, int r211, int r212, float[] r213) {
        float r100 = r213[0];
        float r101 = r213[1];
        float r102 = (r110 - 0.5f) * 2.0f;
        float r103 = (r210 - 0.5f) * 2.0f;
        float r104 = r100 + this.f546752c;
        float r105 = r101 + this.f546753d;
        float r106 = r104 + (this.f546750a * r102);
        float r107 = r105 + (this.f546751b * r103);
        float r108 = (float) Math.toRadians(this.f546755f);
        float r109 = (float) Math.toRadians(this.f546754e);
        double r111 = r108;
        double r112 = r212 * r103;
        float r113 = r106 + (((float) ((((double) ((-r211) * r102)) * Math.sin(r111)) - (Math.cos(r111) * r112))) * r109);
        float r114 = r107 + (r109 * ((float) ((((double) (r211 * r102)) * Math.cos(r111)) - (r112 * Math.sin(r111)))));
        r213[0] = r113;
        r213[1] = r114;
    }
}
