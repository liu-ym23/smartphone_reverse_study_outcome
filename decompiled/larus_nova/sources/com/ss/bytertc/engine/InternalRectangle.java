package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f456191x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f456192y;

    public InternalRectangle(int r100, int r101, int r102, int r103) {
        this.f456191x = r100;
        this.f456192y = r101;
        this.width = r102;
        this.height = r103;
    }

    public static InternalRectangle create(int r100, int r101, int r102, int r103) {
        return new InternalRectangle(r100, r101, r102, r103);
    }
}
