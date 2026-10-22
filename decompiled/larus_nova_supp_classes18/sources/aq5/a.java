package aq5;

import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public final String toString() {
        return "BannerContentParams{width=" + this.a + ", height=" + this.b + ", marginStart=" + this.c + ", marginMid=" + this.d + ", scrollOffset=" + this.e + '}';
    }

    public a() {
        float r0 = n.v();
        float r1 = (0.8613333f * r0) / 3.1f;
        this.a = r1;
        this.b = (4.0f * r1) / 3.0f;
        this.c = 0.042666666f * r0;
        float r2 = r0 * 0.032f;
        this.d = r2;
        this.e = -((r1 * 0.07f) + r2);
        tt5.a.h("BannerContentParams", "BannerContentParams init " + toString());
    }
}
