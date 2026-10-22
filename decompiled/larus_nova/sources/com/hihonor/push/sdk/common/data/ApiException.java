package com.hihonor.push.sdk.common.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class ApiException extends Exception implements Parcelable {
    public static final Parcelable.Creator<ApiException> CREATOR = null;
    public int errorCode;
    public String message;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ApiException(int r100) {
        initData(r100, null);
    }

    public ApiException(int r100, String r101) {
        initData(r100, r101);
    }

    public ApiException(Parcel r100) {
        this.errorCode = r100.readInt();
        this.message = r100.readString();
    }

    private void initData(int r100, String r101) {
        this.errorCode = r100;
        this.message = r101;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.errorCode);
        r100.writeString(this.message);
    }
}
