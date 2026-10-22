package com.bytedance.ee.bear.scaleimageview.areacomment;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Quad implements Serializable {
    public float x1;
    public float x2;
    public float x3;
    public float x4;
    public float y1;
    public float y2;
    public float y3;
    public float y4;

    public static class a {
    }

    public Quad copy() {
        Quad r0 = new Quad();
        r0.x1 = this.x1;
        r0.y1 = this.y1;
        r0.x2 = this.x2;
        r0.y2 = this.y2;
        r0.x3 = this.x3;
        r0.y3 = this.y3;
        r0.x4 = this.x4;
        r0.y4 = this.y4;
        return r0;
    }

    public Quad() {
    }

    public Quad(a r1, a r2, a r3, a r4) {
        throw null;
    }
}
