package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class HarMonitorParams implements Parcelable {
    public static final Parcelable.Creator<HarMonitorParams> CREATOR = null;
    public int accStateDurationThreshold;
    public int accStateDurationThreshold2;
    public int accStateMonitorWindow;
    public int accelOccurrenceThreshold;
    public int runningContinuousThreshold;
    public int runningStateDurationThreshold;
    public int runningStateDurationThreshold2;
    public int runningStateMonitorWindow;
    public int stateVoteWindowSize;
    public int stationaryOccurrenceThreshold;
    public int walkingContinuousThreshold;
    public int walkingStateDurationThreshold;
    public int walkingStateDurationThreshold2;
    public int walkingStateMonitorWindow;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<HarMonitorParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParams createFromParcel(Parcel r100) {
            return new HarMonitorParams(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParams[] newArray(int r100) {
            return new HarMonitorParams[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public HarMonitorParams() {
        this.stateVoteWindowSize = 5;
        this.walkingContinuousThreshold = 2;
        this.runningContinuousThreshold = 3;
        this.accelOccurrenceThreshold = 4;
        this.stationaryOccurrenceThreshold = 3;
        this.accStateDurationThreshold = 10;
        this.accStateMonitorWindow = 15;
        this.accStateDurationThreshold2 = 12;
        this.runningStateDurationThreshold = 10;
        this.runningStateMonitorWindow = 15;
        this.runningStateDurationThreshold2 = 12;
        this.walkingStateMonitorWindow = 15;
        this.walkingStateDurationThreshold = 10;
        this.walkingStateDurationThreshold2 = 12;
    }

    public HarMonitorParams(Parcel r100) {
        this.stateVoteWindowSize = r100.readInt();
        this.walkingContinuousThreshold = r100.readInt();
        this.runningContinuousThreshold = r100.readInt();
        this.accelOccurrenceThreshold = r100.readInt();
        this.stationaryOccurrenceThreshold = r100.readInt();
        this.accStateDurationThreshold = r100.readInt();
        this.accStateMonitorWindow = r100.readInt();
        this.accStateDurationThreshold2 = r100.readInt();
        this.runningStateDurationThreshold = r100.readInt();
        this.runningStateMonitorWindow = r100.readInt();
        this.runningStateDurationThreshold2 = r100.readInt();
        this.walkingStateMonitorWindow = r100.readInt();
        this.walkingStateDurationThreshold = r100.readInt();
        this.walkingStateDurationThreshold2 = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.stateVoteWindowSize);
        r100.writeInt(this.walkingContinuousThreshold);
        r100.writeInt(this.runningContinuousThreshold);
        r100.writeInt(this.accelOccurrenceThreshold);
        r100.writeInt(this.stationaryOccurrenceThreshold);
        r100.writeInt(this.accStateDurationThreshold);
        r100.writeInt(this.accStateMonitorWindow);
        r100.writeInt(this.accStateDurationThreshold2);
        r100.writeInt(this.runningStateDurationThreshold);
        r100.writeInt(this.runningStateMonitorWindow);
        r100.writeInt(this.runningStateDurationThreshold2);
        r100.writeInt(this.walkingStateMonitorWindow);
        r100.writeInt(this.walkingStateDurationThreshold);
        r100.writeInt(this.walkingStateDurationThreshold2);
    }
}
