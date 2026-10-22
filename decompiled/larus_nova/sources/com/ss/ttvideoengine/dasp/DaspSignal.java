package com.ss.ttvideoengine.dasp;

/* JADX INFO: loaded from: classes34.dex */
public class DaspSignal {
    public final String name;
    public final Object value;

    public DaspSignal(String r100, double r101) {
        this.name = r100;
        this.value = Double.valueOf(r101);
    }

    public DaspSignal(String r100, float r101) {
        this.name = r100;
        this.value = Float.valueOf(r101);
    }

    public DaspSignal(String r100, int r101) {
        this.name = r100;
        this.value = Integer.valueOf(r101);
    }

    public DaspSignal(String r100, long r101) {
        this.name = r100;
        this.value = Long.valueOf(r101);
    }

    public DaspSignal(String r100, boolean r101) {
        this.name = r100;
        this.value = Boolean.valueOf(r101);
    }

    public DaspSignal(String r100, String r101) {
        this.name = r100;
        this.value = r101;
    }
}
