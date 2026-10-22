package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class BtDeviceInfoExtEvent implements Parcelable {
    public static final Parcelable.Creator<BtDeviceInfoExtEvent> CREATOR = null;
    public static final int INVALID_PRODUCT_ID = 0;
    public static final int TYPE_BAND = 5;
    public static final int TYPE_CARKIT = 2;
    public static final int TYPE_COMPUTER = 6;
    public static final int TYPE_EBIKE = 11;
    public static final int TYPE_GLASS = 12;
    public static final int TYPE_HEADSET = 1;
    public static final int TYPE_KEYBOARD = 8;
    public static final int TYPE_LAPTOP = 14;
    public static final int TYPE_LOUDSPEAKER = 3;
    public static final int TYPE_MICROPHONE = 15;
    public static final int TYPE_MOUSE = 9;
    public static final int TYPE_PAD = 13;
    public static final int TYPE_PERIPHERAL = 10;
    public static final int TYPE_SMART_PHONE = 7;
    public static final int TYPE_TV = 16;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 4;
    private final BluetoothDevice mDevice;
    private final int mDeviceType;
    private final int mProductId;

    public class a implements Parcelable.Creator<BtDeviceInfoExtEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent createFromParcel(Parcel r100) {
            return new BtDeviceInfoExtEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent[] newArray(int r100) {
            return new BtDeviceInfoExtEvent[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public BtDeviceInfoExtEvent(Parcel r100) {
        this.mDevice = (BluetoothDevice) r100.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProductId = r100.readInt();
        this.mDeviceType = r100.readInt();
    }

    public BtDeviceInfoExtEvent(BluetoothDevice r100, int r101) {
        this.mDevice = r100;
        this.mProductId = r101;
        this.mDeviceType = 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mDevice, r101);
        r100.writeInt(this.mProductId);
        r100.writeInt(this.mDeviceType);
    }

    public BtDeviceInfoExtEvent(BluetoothDevice r100, int r101, int r102) {
        this.mDevice = r100;
        this.mProductId = r101;
        this.mDeviceType = r102;
    }
}
