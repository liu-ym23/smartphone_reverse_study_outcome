package com.bytedance.ee.plugin.common.pdftron.wrapper;

import java.io.Serializable;

/* JADX INFO: loaded from: classes19.dex */
public class Quad implements Serializable {

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public float f243055x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public float f243056x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public float f243057x3;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public float f243058x4;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public float f243059y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public float f243060y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public float f243061y3;

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public float f243062y4;

    public static class Point {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public float f243063x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f243064y;

        public String toString() {
            return "Point{x=" + this.f243063x + ", y=" + this.f243064y + '}';
        }

        public Point() {
        }

        public Point(float r100, float r101) {
            this.f243063x = r100;
            this.f243064y = r101;
        }
    }

    public Quad() {
    }

    public Quad(Point r100, Point r101, Point r102, Point r103) {
        this.f243055x1 = r100.f243063x;
        this.f243059y1 = r100.f243064y;
        this.f243056x2 = r101.f243063x;
        this.f243060y2 = r101.f243064y;
        this.f243057x3 = r102.f243063x;
        this.f243061y3 = r102.f243064y;
        this.f243058x4 = r103.f243063x;
        this.f243062y4 = r103.f243064y;
    }
}
