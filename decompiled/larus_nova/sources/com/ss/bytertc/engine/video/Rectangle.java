package com.ss.bytertc.engine.video;

/* JADX INFO: loaded from: classes40.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f456260x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f456261y;

    public String toString() {
        return "Rectangle{x=" + this.f456260x + ", y=" + this.f456261y + ", width=" + this.width + ", height=" + this.height + '}';
    }

    public Rectangle(int r100, int r101, int r102, int r103) {
        this.f456260x = r100;
        this.f456261y = r101;
        this.width = r102;
        this.height = r103;
    }
}
