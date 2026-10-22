package com.ss.android.lark.optrace.extension.clientduration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class TracingClientDurationEvent implements Serializable, Parcelable {
    public static final Parcelable.Creator<TracingClientDurationEvent> CREATOR = null;
    private volatile boolean finished;
    private final long startTime;

    public class a implements Parcelable.Creator<TracingClientDurationEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationEvent createFromParcel(Parcel r100) {
            return new TracingClientDurationEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationEvent[] newArray(int r100) {
            return new TracingClientDurationEvent[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void finish() {
        this.finished = true;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "TracingClientDurationEvent{finished=" + this.finished + ", startTime=" + this.startTime + '}';
    }

    public TracingClientDurationEvent() {
        this.startTime = SystemClock.elapsedRealtime();
        this.finished = false;
    }

    public long duration() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public TracingClientDurationEvent(Parcel r100) {
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.finished = r101;
        this.startTime = r100.readLong();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.finished ? 1 : 0);
        r100.writeLong(this.startTime);
    }
}
