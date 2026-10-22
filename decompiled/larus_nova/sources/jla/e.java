package jla;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f499595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f499596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f499597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f499598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f499599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f499600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f499601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f499602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f499603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.h f499604j;

    public e() {
        this.f499595a = Math.sqrt(1500.0d);
        this.f499596b = 0.5d;
        this.f499597c = false;
        this.f499603i = Double.MAX_VALUE;
        this.f499604j = new b.h();
    }

    public final b.h a(double r110, double r111, long r210) {
        if (this.f499597c == false) goto L6;
    L16:
        double r100 = r210 / 1000.0d;
        double r101 = r110 - this.f499603i;
        double r102 = this.f499596b;
        if (r102 <= 1.0d) goto L20;
        double r103 = this.f499601g;
        double r112 = this.f499600f;
        double r104 = r101 - (((r103 * r101) - r111) / (r103 - r112));
        double r105 = ((r101 * r103) - r111) / (r103 - r112);
        double r106 = (Math.pow(2.718281828459045d, r103 * r100) * r104) + (Math.pow(2.718281828459045d, this.f499600f * r100) * r105);
        double r113 = this.f499601g;
        double r107 = (r104 * r113) * Math.pow(2.718281828459045d, r113 * r100);
        double r114 = this.f499600f;
        double r108 = r107 + ((r105 * r114) * Math.pow(2.718281828459045d, r114 * r100));
    L23:
        b.h r109 = this.f499604j;
        r109.f499590a = (float) (r106 + this.f499603i);
        r109.f499591b = (float) r108;
        return r109;
    L20:
        if (r102 != 1.0d) goto L22;
        double r115 = this.f499595a;
        double r116 = r111 + (r115 * r101);
        double r117 = r101 + (r116 * r100);
        r106 = Math.pow(2.718281828459045d, (-r115) * r100) * r117;
        double r118 = r117 * Math.pow(2.718281828459045d, (-this.f499595a) * r100);
        double r119 = this.f499595a;
        r108 = (r116 * Math.pow(2.718281828459045d, (-r119) * r100)) + (r118 * (-r119));
        goto L23
    L22:
        double r120 = 1.0d / this.f499602h;
        double r121 = this.f499595a;
        double r122 = r120 * (((r102 * r121) * r101) + r111);
        double r123 = Math.pow(2.718281828459045d, ((-r102) * r121) * r100) * ((Math.cos(this.f499602h * r100) * r101) + (Math.sin(this.f499602h * r100) * r122));
        double r124 = this.f499595a;
        double r125 = this.f499596b;
        double r126 = ((-r124) * r123) * r125;
        double r127 = Math.pow(2.718281828459045d, ((-r125) * r124) * r100);
        double r128 = this.f499602h;
        double r129 = ((-r128) * r101) * Math.sin(r128 * r100);
        double r130 = this.f499602h;
        r108 = r126 + (r127 * (r129 + ((r122 * r130) * Math.cos(r130 * r100))));
        r106 = r123;
        goto L23
    L6:
        if (this.f499603i == Double.MAX_VALUE) goto L26;
        double r131 = this.f499596b;
        if (r131 <= 1.0d) goto L11;
        double r132 = this.f499595a;
        this.f499600f = ((-r131) * r132) + (r132 * Math.sqrt((r131 * r131) - 1.0d));
        double r133 = this.f499596b;
        double r134 = this.f499595a;
        this.f499601g = ((-r133) * r134) - (r134 * Math.sqrt((r133 * r133) - 1.0d));
    L15:
        this.f499597c = true;
        goto L16
    L11:
        if (r131 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        if (r131 >= 1.0d) goto L15;
        this.f499602h = this.f499595a * Math.sqrt(1.0d - (r131 * r131));
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
