package com.ss.android.lark.opmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes37.dex */
public class OPMonitorHeartBeatMonitorData implements Parcelable {
    public static final Parcelable.Creator<OPMonitorHeartBeatMonitorData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f437599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f437600d;

    public class a implements Parcelable.Creator<OPMonitorHeartBeatMonitorData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatMonitorData createFromParcel(Parcel r100) {
            return new OPMonitorHeartBeatMonitorData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatMonitorData[] newArray(int r100) {
            return new OPMonitorHeartBeatMonitorData[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public OPMonitorHeartBeatMonitorData(Parcel r100) {
        this.f437600d = 0;
        this.f437598b = r100.readString();
        this.f437597a = r100.readString();
        this.f437599c = r100.readInt();
        this.f437600d = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f437598b);
        r100.writeString(this.f437597a);
        r100.writeInt(this.f437599c);
        r100.writeInt(this.f437600d);
    }
}
