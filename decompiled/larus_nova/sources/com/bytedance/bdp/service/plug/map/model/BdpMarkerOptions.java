package com.bytedance.bdp.service.plug.map.model;

import android.graphics.Bitmap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class BdpMarkerOptions {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public BdpCustomInfoWindowOptions customInfoWindowOptions;
    public Bitmap icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f201551id;
    public BdpInfoWindowOptions infoWindowOptions;
    public AtomicBoolean isInterrupt;
    public AtomicBoolean isMoving;
    public BdpInfoWindowOptions labelOptions;
    private final Object lock;
    public BdpLatLng position;
    public float rotate;
    public String title;
    public float zIndex;

    public void checkAndInterrupt() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.isMoving.get() == false) goto L7;
        this.isInterrupt.set(true);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public BdpMarkerOptions() {
        this.alpha = 1.0f;
        this.anchorX = 0.5f;
        this.anchorY = 1.0f;
        this.infoWindowOptions = new BdpInfoWindowOptions(null);
        this.customInfoWindowOptions = null;
        this.isInterrupt = new AtomicBoolean(false);
        this.isMoving = new AtomicBoolean(false);
        this.lock = new Object();
    }

    public BdpMarkerOptions alpha(float r100) {
        this.alpha = r100;
        return this;
    }

    public BdpMarkerOptions anchorX(float r100) {
        this.anchorX = r100;
        return this;
    }

    public BdpMarkerOptions anchorY(float r100) {
        this.anchorY = r100;
        return this;
    }

    public BdpMarkerOptions bdpCustomInfoWindowOptions(BdpCustomInfoWindowOptions r100) {
        this.customInfoWindowOptions = r100;
        return this;
    }

    public BdpMarkerOptions bdpInfoWindowOptions(BdpInfoWindowOptions r100) {
        this.infoWindowOptions = r100;
        return this;
    }

    public BdpMarkerOptions bdpLabelOptions(BdpInfoWindowOptions r100) {
        this.labelOptions = r100;
        return this;
    }

    public BdpMarkerOptions icon(Bitmap r100) {
        this.icon = r100;
        return this;
    }

    public BdpMarkerOptions id(String r100) {
        this.f201551id = r100;
        return this;
    }

    public BdpMarkerOptions position(BdpLatLng r100) {
        this.position = r100;
        return this;
    }

    public BdpMarkerOptions rotate(float r100) {
        this.rotate = r100;
        return this;
    }

    public void setMovingState(boolean r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        this.isMoving.set(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BdpMarkerOptions title(String r100) {
        this.title = r100;
        return this;
    }

    public BdpMarkerOptions zIndex(double r100) {
        this.zIndex = (float) r100;
        return this;
    }
}
