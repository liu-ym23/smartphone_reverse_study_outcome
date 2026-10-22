package com.hihonor.mcs.system.diagnosis.core.pressure;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class PressurePayload implements Parcelable {
    public static final Parcelable.Creator<PressurePayload> CREATOR = null;
    private CpuWatchPoint cpuWatchPoint;
    private IoWatchPoint ioWatchPoint;
    private MemoryWatchPoint memoryWatchPoint;
    private TemperatureWatchPoint temperatureWatchPoint;

    static {
        CREATOR = new AnonymousClass1();
    }

    public PressurePayload() {
        this.temperatureWatchPoint = new TemperatureWatchPoint();
        this.memoryWatchPoint = new MemoryWatchPoint();
        this.cpuWatchPoint = new CpuWatchPoint();
        this.ioWatchPoint = new IoWatchPoint();
    }

    public PressurePayload(Parcel r100) {
        this.temperatureWatchPoint = new TemperatureWatchPoint();
        this.memoryWatchPoint = new MemoryWatchPoint();
        this.cpuWatchPoint = new CpuWatchPoint();
        this.ioWatchPoint = new IoWatchPoint();
        this.temperatureWatchPoint = (TemperatureWatchPoint) r100.readSerializable();
        this.memoryWatchPoint = (MemoryWatchPoint) r100.readSerializable();
        this.cpuWatchPoint = (CpuWatchPoint) r100.readSerializable();
        this.ioWatchPoint = (IoWatchPoint) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CpuWatchPoint getCpuWatchPoint() {
        return this.cpuWatchPoint;
    }

    public IoWatchPoint getIoWatchPoint() {
        return this.ioWatchPoint;
    }

    public MemoryWatchPoint getMemoryWatchPoint() {
        return this.memoryWatchPoint;
    }

    public TemperatureWatchPoint getTemperatureWatchPoint() {
        return this.temperatureWatchPoint;
    }

    public void readFromParcel(Parcel r100) {
        this.temperatureWatchPoint = (TemperatureWatchPoint) r100.readSerializable();
        this.memoryWatchPoint = (MemoryWatchPoint) r100.readSerializable();
        this.cpuWatchPoint = (CpuWatchPoint) r100.readSerializable();
        this.ioWatchPoint = (IoWatchPoint) r100.readSerializable();
    }

    public void setCpuWatchPoint(CpuWatchPoint r100) {
        this.cpuWatchPoint = r100;
    }

    public void setIoWatchPoint(IoWatchPoint r100) {
        this.ioWatchPoint = r100;
    }

    public void setMemoryMonitor(MemoryWatchPoint r100) {
        this.memoryWatchPoint = r100;
    }

    public void setTemperatureMonitor(TemperatureWatchPoint r100) {
        this.temperatureWatchPoint = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.temperatureWatchPoint);
        r100.writeSerializable(this.memoryWatchPoint);
        r100.writeSerializable(this.cpuWatchPoint);
        r100.writeSerializable(this.ioWatchPoint);
    }
}
