package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class BdimPredictEvent implements Parcelable {
    public static final Parcelable.Creator<BdimPredictEvent> CREATOR = null;
    private final String mActualCodType;
    private final String mAddress;
    private final String mCod;
    private final BluetoothDevice mDevice;
    private final String mIoCapability;
    private final String mManuf;
    private final String mMethod;
    private final String mName;
    private final String mServiceInfo;

    public class a implements Parcelable.Creator<BdimPredictEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent createFromParcel(Parcel r100) {
            return new BdimPredictEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent[] newArray(int r100) {
            return new BdimPredictEvent[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getActualCodType() {
        return this.mActualCodType;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getCod() {
        return this.mCod;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public String getIoCapability() {
        return this.mIoCapability;
    }

    public String getManuf() {
        return this.mManuf;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public String getName() {
        return this.mName;
    }

    public String getServiceInfo() {
        return this.mServiceInfo;
    }

    public BdimPredictEvent(Parcel r100) {
        this.mDevice = (BluetoothDevice) r100.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mAddress = r100.readString();
        this.mName = r100.readString();
        this.mServiceInfo = r100.readString();
        this.mMethod = r100.readString();
        this.mIoCapability = r100.readString();
        this.mCod = r100.readString();
        this.mManuf = r100.readString();
        this.mActualCodType = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mDevice, r101);
        r100.writeString(this.mAddress);
        r100.writeString(this.mName);
        r100.writeString(this.mServiceInfo);
        r100.writeString(this.mMethod);
        r100.writeString(this.mIoCapability);
        r100.writeString(this.mCod);
        r100.writeString(this.mManuf);
        r100.writeString(this.mActualCodType);
    }

    public BdimPredictEvent(BluetoothDevice r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.mDevice = r100;
        this.mAddress = r101;
        this.mName = r102;
        this.mServiceInfo = r103;
        this.mMethod = r104;
        this.mIoCapability = r105;
        this.mCod = r106;
        this.mManuf = r107;
        this.mActualCodType = r108;
    }
}
