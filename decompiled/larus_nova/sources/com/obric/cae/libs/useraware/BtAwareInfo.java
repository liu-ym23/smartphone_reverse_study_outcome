package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class BtAwareInfo implements Parcelable {
    public static final Parcelable.Creator<BtAwareInfo> CREATOR = null;
    private static final int VERSION = 2;
    private final String mAddress;
    private final int mAddressType;
    private final boolean mConnected;
    private final int mDeviceClass;
    private final int mDeviceType;
    private final String mManufacturer;
    private final String mName;
    private final int mRssi;
    private final long mTimestamp;
    private final ParcelUuid[] mUuids;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<BtAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo createFromParcel(Parcel r100) {
            return new BtAwareInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo[] newArray(int r100) {
            return new BtAwareInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 2;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        ParcelUuid[] r100 = this.mUuids;
        if (r100 != null) goto L5;
    L13:
        String r101 = "";
    L15:
        return "BtAwareInfo:[2, timestamp=" + this.mTimestamp + ", address=" + this.mAddress + ", addressType=" + this.mAddressType + ", deviceType=" + this.mDeviceType + ", name=" + this.mName + ", deviceClass=" + this.mDeviceClass + ", manufacturer=" + this.mManufacturer + ", rssi=" + this.mRssi + ", connected=" + this.mConnected + ", uuids=(" + r101 + ")]";
    L5:
        if (r100.length <= 0) goto L13;
        CharSequence[] r102 = (CharSequence[]) Arrays.stream(r100).map(new com.obric.cae.libs.useraware.a()).toArray(new b());
        StringBuilder r103 = new StringBuilder();
        if (r102.length <= 0) goto L12;
        r103.append(r102[0]);
        int r104 = 1;
    L10:
        if (r104 >= r102.length) goto L12;
        r103.append(",");
        r103.append(r102[r104]);
        r104 = r104 + 1;
    L12:
        r101 = r103.toString();
        goto L15
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDeviceClass() {
        return this.mDeviceClass;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getName() {
        return this.mName;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ParcelUuid[] getUuids() {
        return this.mUuids;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public BtAwareInfo(Parcel r100) {
        this.mTimestamp = r100.readLong();
        this.mAddress = r100.readString();
        this.mAddressType = r100.readInt();
        this.mDeviceType = r100.readInt();
        this.mName = r100.readString();
        this.mDeviceClass = r100.readInt();
        this.mManufacturer = r100.readString();
        this.mRssi = (short) r100.readInt();
        this.mConnected = r100.readBoolean();
        this.mUuids = (ParcelUuid[]) r100.createTypedArray(ParcelUuid.CREATOR);
    }

    public static /* synthetic */ String[] a(int r100) {
        return new String[r100];
    }

    public boolean compareTo(BtAwareInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Objects.equals(this.mName, r100.mName) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mAddress, r100.mAddress) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(Integer.valueOf(this.mAddressType), Integer.valueOf(r100.mAddressType)) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(Integer.valueOf(this.mRssi), Integer.valueOf(r100.mRssi)) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(Boolean.valueOf(this.mConnected), Boolean.valueOf(r100.mConnected)) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(Integer.valueOf(this.mDeviceType), Integer.valueOf(r100.mDeviceType)) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(Integer.valueOf(this.mDeviceClass), Integer.valueOf(r100.mDeviceClass)) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.mManufacturer, r100.mManufacturer) == false) goto L30;
        return true;
    L30:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mTimestamp);
        r100.writeString(this.mAddress);
        r100.writeInt(this.mAddressType);
        r100.writeInt(this.mDeviceType);
        r100.writeString(this.mName);
        r100.writeInt(this.mDeviceClass);
        r100.writeString(this.mManufacturer);
        r100.writeInt(this.mRssi);
        r100.writeBoolean(this.mConnected);
        r100.writeTypedArray(this.mUuids, r101);
    }

    public BtAwareInfo(String r100, int r101, int r102, String r103, int r104, String r105, int r106, boolean r110, ParcelUuid[] r111) {
        this.mTimestamp = System.currentTimeMillis();
        this.mAddress = r100;
        this.mAddressType = r101;
        this.mDeviceType = r102;
        this.mName = r103;
        this.mDeviceClass = r104;
        this.mManufacturer = r105;
        this.mRssi = r106;
        this.mConnected = r110;
        this.mUuids = r111;
    }
}
