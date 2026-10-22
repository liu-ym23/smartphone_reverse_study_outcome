package com.bytedance.keva.ext.fast;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes19.dex */
public class ValueWrapper implements Parcelable {
    static final int BLOCK_TYPE_BYTES = 0;
    static final int BLOCK_TYPE_OBJECT = 4;
    static final int BLOCK_TYPE_STRING_ARRAY = 3;
    static final int BLOCK_TYPE_STRING_UTF16 = 2;
    static final int BLOCK_TYPE_STRING_UTF8 = 1;
    public static final Parcelable.Creator<ValueWrapper> CREATOR = null;
    static final int EXT_TYPE_BYTES = 7;
    static final int EXT_TYPE_OBJECT = 71;
    static final int EXT_TYPE_STRING_ARRAY = 55;
    static final int EXT_TYPE_STRING_UTF16 = 39;
    static final int EXT_TYPE_STRING_UTF8 = 23;
    static final int TYPE_BOOL = 2;
    static final int TYPE_BYTES = 7;
    static final int TYPE_DOUBLE = 5;
    static final int TYPE_FLOAT = 4;
    static final int TYPE_INT = 1;
    static final int TYPE_INVALID = 0;
    static final int TYPE_LONG = 3;
    static final int TYPE_STRING = 6;
    public byte[] bArrayValue;
    public String key;
    public double numValue;
    public String[] sArrayValue;
    public String sValue;
    public int valueType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ValueWrapper() {
    }

    private ValueWrapper(Parcel r100) {
        this.key = r100.readString();
        this.valueType = r100.readInt();
        this.numValue = r100.readDouble();
        this.sValue = r100.readString();
        this.bArrayValue = r100.createByteArray();
        this.sArrayValue = r100.createStringArray();
    }

    public /* synthetic */ ValueWrapper(Parcel r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.key);
        r100.writeInt(this.valueType);
        r100.writeDouble(this.numValue);
        r100.writeString(this.sValue);
        r100.writeByteArray(this.bArrayValue);
        r100.writeStringArray(this.sArrayValue);
    }
}
