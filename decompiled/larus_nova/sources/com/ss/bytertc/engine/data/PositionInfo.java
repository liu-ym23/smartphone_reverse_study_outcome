package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class PositionInfo {
    public HumanOrientation orientation;
    public Position position;

    public float getFieldOrientationForwardX() {
        return this.orientation.forward.f456199x;
    }

    public float getFieldOrientationForwardY() {
        return this.orientation.forward.f456200y;
    }

    public float getFieldOrientationForwardZ() {
        return this.orientation.forward.f456201z;
    }

    public float getFieldOrientationRightX() {
        return this.orientation.right.f456199x;
    }

    public float getFieldOrientationRightY() {
        return this.orientation.right.f456200y;
    }

    public float getFieldOrientationRightZ() {
        return this.orientation.right.f456201z;
    }

    public float getFieldOrientationUpX() {
        return this.orientation.f456198up.f456199x;
    }

    public float getFieldOrientationUpY() {
        return this.orientation.f456198up.f456200y;
    }

    public float getFieldOrientationUpZ() {
        return this.orientation.f456198up.f456201z;
    }

    public float getFieldPositionX() {
        return this.position.f456202x;
    }

    public float getFieldPositionY() {
        return this.position.f456203y;
    }

    public float getFieldPositionZ() {
        return this.position.f456204z;
    }

    public PositionInfo(Position r100, HumanOrientation r101) {
        this.position = r100;
        this.orientation = r101;
    }
}
