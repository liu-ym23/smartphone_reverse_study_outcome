package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;
    private final Intent mData;
    private final int mResultCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public ActivityResult(Parcel r2) {
        this.mResultCode = r2.readInt();
        if (r2.readInt() != 0) goto L5;
        Intent r3 = null;
    L6:
        this.mData = r3;
        return;
    L5:
        r3 = (Intent) Intent.CREATOR.createFromParcel(r2);
        goto L6
    }

    public static String resultCodeToString(int r1) {
        if (r1 == (-1)) goto L9;
        if (r1 != 0) goto L6;
        return "RESULT_CANCELED";
    L6:
        return String.valueOf(r1);
    L9:
        return "RESULT_OK";
    }

    public ActivityResult(int r1, Intent r2) {
        this.mResultCode = r1;
        this.mData = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.mResultCode);
        if (this.mData != null) goto L5;
        int r0 = 0;
    L6:
        r2.writeInt(r0);
        Intent r1 = this.mData;
        if (r1 == null) goto L10;
        r1.writeToParcel(r2, r3);
        return;
    L10:
        return;
    L5:
        r0 = 1;
        goto L6
    }
}
