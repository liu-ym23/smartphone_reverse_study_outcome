package com.ss.android.lark.opmonitor.config;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class OPMonitorHeartBeatConfig implements Parcelable {
    public static final Parcelable.Creator<OPMonitorHeartBeatConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f437594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f437595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f437596c;

    public class a implements Parcelable.Creator<OPMonitorHeartBeatConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatConfig createFromParcel(Parcel r100) {
            return new OPMonitorHeartBeatConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatConfig[] newArray(int r100) {
            return new OPMonitorHeartBeatConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f437594a), Boolean.valueOf(this.f437595b), Integer.valueOf(this.f437596c)});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "OPMonitorHeartBeatConfig{heartBeatInterval=" + this.f437594a + ", enableHeartBeatMonitor=" + this.f437595b + ", maxReportCount=" + this.f437596c + '}';
    }

    public OPMonitorHeartBeatConfig() {
        this.f437596c = 240;
    }

    public OPMonitorHeartBeatConfig(Parcel r100) {
        this.f437596c = 240;
        this.f437594a = r100.readInt();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.f437595b = r101;
        this.f437596c = r100.readInt();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        OPMonitorHeartBeatConfig r101 = (OPMonitorHeartBeatConfig) r100;
        if (this.f437594a == r101.f437594a) goto L13;
    L17:
        return false;
    L13:
        if (this.f437595b != r101.f437595b) goto L17;
        if (this.f437596c != r101.f437596c) goto L17;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f437594a);
        if (this.f437595b == false) goto L5;
        r100.writeInt(1);
    L6:
        r100.writeInt(this.f437596c);
        return;
    L5:
        r100.writeInt(0);
        goto L6
    }
}
