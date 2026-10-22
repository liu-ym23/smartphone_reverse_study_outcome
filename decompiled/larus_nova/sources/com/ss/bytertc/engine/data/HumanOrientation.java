package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class HumanOrientation {
    public Orientation forward;
    public Orientation right;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    public Orientation f456198up;

    public HumanOrientation() {
        this.forward = new Orientation(1.0f, 0.0f, 0.0f);
        this.right = new Orientation(0.0f, 1.0f, 0.0f);
        this.f456198up = new Orientation(0.0f, 0.0f, 1.0f);
    }

    public HumanOrientation(Orientation r100, Orientation r101, Orientation r102) {
        this.forward = r100;
        this.right = r101;
        this.f456198up = r102;
    }
}
