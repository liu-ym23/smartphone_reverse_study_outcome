package com.bytedance.bdp.service.plug.map.model;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class BdpMarkerAction {
    public boolean autoRotate;
    public int duration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f201550id;
    public boolean moveWithRotate;
    public List<BdpLatLng> path;
    public float rotate;

    public BdpMarkerAction() {
        this.duration = 1000;
    }

    public BdpMarkerAction autoRotate(boolean r100) {
        this.autoRotate = r100;
        return this;
    }

    public BdpMarkerAction duration(int r100) {
        this.duration = r100;
        return this;
    }

    public BdpMarkerAction id(String r100) {
        this.f201550id = r100;
        return this;
    }

    public BdpMarkerAction moveWithRotate(boolean r100) {
        this.moveWithRotate = r100;
        return this;
    }

    public BdpMarkerAction path(List<BdpLatLng> r100) {
        this.path = r100;
        return this;
    }

    public BdpMarkerAction rotate(float r100) {
        this.rotate = r100;
        return this;
    }
}
