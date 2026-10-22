package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes15.dex */
public class NewMsgTimeHolder implements Parcelable {
    public static final Parcelable.Creator<NewMsgTimeHolder> CREATOR = null;
    public final long endDecodeTs;
    public final long receiveRawDataTs;
    public final long startDecodeTs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public NewMsgTimeHolder(Parcel r100) {
        this.receiveRawDataTs = r100.readLong();
        this.startDecodeTs = r100.readLong();
        this.endDecodeTs = r100.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.receiveRawDataTs);
        r100.writeLong(this.startDecodeTs);
        r100.writeLong(this.endDecodeTs);
    }

    public NewMsgTimeHolder(long r100, long r101, long r102) {
        this.receiveRawDataTs = r100;
        this.startDecodeTs = r101;
        this.endDecodeTs = r102;
    }
}
