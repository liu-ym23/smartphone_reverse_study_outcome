package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = null;
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    public BaseException() {
        this.extraInfo = "";
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public BaseException(Parcel r100) {
        this.extraInfo = "";
        readFromParcel(r100);
    }

    public void readFromParcel(Parcel r100) {
        this.errorCode = r100.readInt();
        this.errorMsg = r100.readString();
        this.extraInfo = r100.readString();
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setExtraInfo(String r100) {
        this.extraInfo = r100;
    }

    public BaseException(int r100, String r101) {
        super(TAG + r101);
        this.extraInfo = "";
        this.errorMsg = TAG + r101;
        this.errorCode = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.errorCode);
        r100.writeString(this.errorMsg);
        r100.writeString(this.extraInfo);
    }

    public BaseException(int r100, Throwable r101) {
        this(r100, DownloadUtils.getThrowableMsg(r101));
    }

    public BaseException(int r100, String r101, Throwable r102) {
        super(TAG + r101, r102);
        this.extraInfo = "";
        this.errorMsg = TAG + r101;
        this.errorCode = r100;
    }
}
