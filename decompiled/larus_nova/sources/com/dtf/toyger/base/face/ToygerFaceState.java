package com.dtf.toyger.base.face;

import com.dtf.toyger.base.algorithm.TGFaceState;
import faceverify.s;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerFaceState extends TGFaceState implements s {
    public ToygerFaceState() {
    }

    public int brightness() {
        return this.brightness;
    }

    public int distance() {
        return this.distance;
    }

    public int getMessageCode() {
        return this.messageCode;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getStaticMessage() {
        return this.staticMessage;
    }

    public int goodPitch() {
        return this.goodPitch;
    }

    public int goodYaw() {
        return this.goodYaw;
    }

    public boolean hasTarget() {
        return this.hasFace;
    }

    public boolean isGoodQuality() {
        return this.goodQuality;
    }

    public boolean isInCenter() {
        return this.faceInCenter;
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public ToygerFaceState(TGFaceState r100) {
        this.hasFace = r100.hasFace;
        this.brightness = r100.brightness;
        this.distance = r100.distance;
        this.faceInCenter = r100.faceInCenter;
        this.goodPitch = r100.goodPitch;
        this.goodYaw = r100.goodYaw;
        this.isMoving = r100.isMoving;
        this.goodQuality = r100.goodQuality;
        this.progress = r100.progress;
        this.messageCode = r100.messageCode;
        this.staticMessage = r100.staticMessage;
        this.targetFaceRegion = r100.targetFaceRegion;
    }
}
