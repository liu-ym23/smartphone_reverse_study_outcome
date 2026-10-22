package com.ss.bytertc.engine.utils;

/* JADX INFO: loaded from: classes40.dex */
public class DevicePerformanceInfo {
    public int cpuCores;
    public float cpuFrequency;
    public String cpuModel;
    public int cpuThreads;
    public String deviceModel;
    public String gpuModel;
    public float memory;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    public String f456226os;
    public String osVersion;

    public DevicePerformanceInfo(float r100, int r101, int r102, float r103, String r104, String r105, String r106, String r107, String r108) {
        this.memory = r100;
        this.cpuCores = r101;
        this.cpuThreads = r102;
        this.cpuFrequency = r103;
        this.cpuModel = r104;
        this.gpuModel = r105;
        this.f456226os = r106;
        this.osVersion = r107;
        this.deviceModel = r108;
    }

    private static DevicePerformanceInfo create(float r110, int r111, int r112, float r113, String r114, String r115, String r116, String r117, String r118) {
        return new DevicePerformanceInfo(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
