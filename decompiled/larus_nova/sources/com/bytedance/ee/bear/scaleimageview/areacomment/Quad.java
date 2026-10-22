package com.bytedance.ee.bear.scaleimageview.areacomment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class Quad implements Serializable {

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public float f236813x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public float f236814x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public float f236815x3;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public float f236816x4;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public float f236817y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public float f236818y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public float f236819y3;

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public float f236820y4;

    public static class a {
    }

    public Quad copy() {
        Quad r100 = new Quad();
        r100.f236813x1 = this.f236813x1;
        r100.f236817y1 = this.f236817y1;
        r100.f236814x2 = this.f236814x2;
        r100.f236818y2 = this.f236818y2;
        r100.f236815x3 = this.f236815x3;
        r100.f236819y3 = this.f236819y3;
        r100.f236816x4 = this.f236816x4;
        r100.f236820y4 = this.f236820y4;
        return r100;
    }

    public Quad() {
    }

    public Quad(a r100, a r101, a r102, a r103) {
        throw null;
    }
}
