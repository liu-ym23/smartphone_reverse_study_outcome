package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;

/* JADX INFO: loaded from: classes23.dex */
public final class ConnectionResult implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = null;
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int apiVersion;
    private int connectionErrorCode;
    private String connectionErrorMessage;
    private PendingIntent pendingIntent;

    public class a implements Parcelable.Creator<ConnectionResult> {
        public a() {
        }

        public ConnectionResult a(Parcel r100) {
            return new ConnectionResult(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectionResult createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ConnectionResult[] newArray(int r100) {
            return a(r100);
        }

        public ConnectionResult[] a(int r100) {
            return new ConnectionResult[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.apiVersion), Long.valueOf(getErrorCode()), getErrorMessage(), this.pendingIntent});
    }

    static {
        CREATOR = new a();
    }

    public final boolean isSuccess() {
        if (this.connectionErrorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hasResolution() {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(this.connectionErrorCode, this.pendingIntent);
    }

    public int getErrorCode() {
        return this.connectionErrorCode;
    }

    public final String getErrorMessage() {
        return this.connectionErrorMessage;
    }

    public final PendingIntent getResolution() {
        return this.pendingIntent;
    }

    private ConnectionResult(Parcel r100) {
        this.apiVersion = 1;
        this.pendingIntent = null;
        this.connectionErrorMessage = null;
        this.apiVersion = r100.readInt();
        this.connectionErrorCode = r100.readInt();
        this.connectionErrorMessage = r100.readString();
        Parcelable r101 = (Parcelable) PendingIntent.CREATOR.createFromParcel(r100);
        if (r101 == null) goto L6;
        this.pendingIntent = (PendingIntent) r101;
        return;
    }

    public static String getErrorString(int r100) {
        if (r100 == (-1)) goto L50;
        if (r100 != 0) goto L6;
        return "SUCCESS";
    L6:
        if (r100 != 1) goto L8;
        return "SERVICE_MISSING";
    L8:
        if (r100 != 2) goto L10;
        return "SERVICE_VERSION_UPDATE_REQUIRED";
    L10:
        if (r100 != 3) goto L12;
        return "SERVICE_DISABLED";
    L12:
        if (r100 != 13) goto L14;
        return "CANCELED";
    L14:
        if (r100 != 14) goto L16;
        return "TIMEOUT";
    L16:
        if (r100 != 19) goto L18;
        return "SERVICE_MISSING_PERMISSION";
    L18:
        if (r100 == 21) goto L34;
        switch(r100) {
            case 6: goto L32;
            case 7: goto L30;
            case 8: goto L28;
            case 9: goto L26;
            case 10: goto L24;
            case 11: goto L22;
            default: goto L21;
        };
    L22:
        return "LICENSE_CHECK_FAILED";
    L24:
        return "DEVELOPER_ERROR";
    L26:
        return "SERVICE_INVALID";
    L28:
        return "INTERNAL_ERROR";
    L30:
        return "NETWORK_ERROR";
    L32:
        return "RESOLUTION_REQUIRED";
    L21:
        return "UNKNOWN_ERROR_CODE(" + r100 + ")";
    L34:
        return "API_VERSION_UPDATE_REQUIRED";
    L50:
        return "UNKNOWN";
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L20;
        return true;
    L20:
    L19:
        return false;
    L7:
        if ((r100 instanceof ConnectionResult) == true) goto L9;
    L17:
        return false;
    L9:
        if (this.apiVersion != ((ConnectionResult) r100).apiVersion) goto L17;
        if (this.connectionErrorCode != ((ConnectionResult) r100).connectionErrorCode) goto L17;
        if (this.connectionErrorMessage.equals(((ConnectionResult) r100).connectionErrorMessage) == false) goto L17;
        if (this.pendingIntent.equals(((ConnectionResult) r100).pendingIntent) == false) goto L17;
        return true;
    }

    public ConnectionResult(int r100) {
        this(r100, null);
    }

    public ConnectionResult(int r100, PendingIntent r101) {
        this(r100, r101, null);
    }

    public final void startResolutionForResult(Activity r100, int r101) throws IntentSender.SendIntentException {
        if (hasResolution() == false) goto L6;
        HuaweiApiAvailability.getInstance().resolveError(r100, this.connectionErrorCode, r101, this.pendingIntent);
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.writeInt(this.apiVersion);
        r100.writeInt(this.connectionErrorCode);
        r100.writeString(this.connectionErrorMessage);
        this.pendingIntent.writeToParcel(r100, r101);
    }

    public /* synthetic */ ConnectionResult(Parcel r100, a r101) {
        this(r100);
    }

    public ConnectionResult(int r100, PendingIntent r101, String r102) {
        this(1, r100, r101, r102);
    }

    public ConnectionResult(int r100, int r101, PendingIntent r102, String r103) {
        this.apiVersion = r100;
        this.connectionErrorCode = r101;
        this.pendingIntent = r102;
        this.connectionErrorMessage = r103;
    }
}
