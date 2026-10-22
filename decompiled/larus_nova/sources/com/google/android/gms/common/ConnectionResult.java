package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_DISABLED = 23;
    public static final int API_DISABLED_FOR_CONNECTION = 24;
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = null;
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final ConnectionResult RESULT_SUCCESS = null;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = -1;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    final int f274453zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final int f274454zzb;
    private final PendingIntent zzc;
    private final String zzd;

    static {
        RESULT_SUCCESS = new ConnectionResult(0);
        CREATOR = new a();
    }

    public ConnectionResult(int r100, int r101, PendingIntent r102, String r103) {
        this.f274453zza = r100;
        this.f274454zzb = r101;
        this.zzc = r102;
        this.zzd = r103;
    }

    public int getErrorCode() {
        return this.f274454zzb;
    }

    public String getErrorMessage() {
        return this.zzd;
    }

    public PendingIntent getResolution() {
        return this.zzc;
    }

    public boolean hasResolution() {
        if (this.f274454zzb != 0) goto L5;
        return false;
    L5:
        if (this.zzc == null) goto L10;
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f274454zzb), this.zzc, this.zzd});
    }

    public boolean isSuccess() {
        if (this.f274454zzb != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public String toString() {
        Objects.ToStringHelper r100 = Objects.toStringHelper(this);
        r100.add("statusCode", zza(this.f274454zzb));
        r100.add("resolution", this.zzc);
        r100.add("message", this.zzd);
        return r100.toString();
    }

    public ConnectionResult(int r100) {
        this(r100, null, null);
    }

    public static String zza(int r100) {
        if (r100 != 99) goto L5;
        return "UNFINISHED";
    L5:
        if (r100 == 1500) goto L60;
        switch(r100) {
            case -1: goto L58;
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            case 8: goto L40;
            case 9: goto L38;
            case 10: goto L36;
            case 11: goto L34;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 13: goto L32;
            case 14: goto L30;
            case 15: goto L28;
            case 16: goto L26;
            case 17: goto L24;
            case 18: goto L22;
            case 19: goto L20;
            case 20: goto L18;
            case 21: goto L16;
            case 22: goto L14;
            case 23: goto L12;
            case 24: goto L10;
            default: goto L9;
        };
    L10:
        return "API_DISABLED_FOR_CONNECTION";
    L12:
        return "API_DISABLED";
    L14:
        return "RESOLUTION_ACTIVITY_NOT_FOUND";
    L16:
        return "API_VERSION_UPDATE_REQUIRED";
    L18:
        return "RESTRICTED_PROFILE";
    L20:
        return "SERVICE_MISSING_PERMISSION";
    L22:
        return "SERVICE_UPDATING";
    L24:
        return "SIGN_IN_FAILED";
    L26:
        return "API_UNAVAILABLE";
    L28:
        return "INTERRUPTED";
    L30:
        return "TIMEOUT";
    L32:
        return "CANCELED";
    L9:
        return "UNKNOWN_ERROR_CODE(" + r100 + ")";
    L34:
        return "LICENSE_CHECK_FAILED";
    L36:
        return "DEVELOPER_ERROR";
    L38:
        return "SERVICE_INVALID";
    L40:
        return "INTERNAL_ERROR";
    L42:
        return "NETWORK_ERROR";
    L44:
        return "RESOLUTION_REQUIRED";
    L46:
        return "INVALID_ACCOUNT";
    L48:
        return "SIGN_IN_REQUIRED";
    L50:
        return "SERVICE_DISABLED";
    L52:
        return "SERVICE_VERSION_UPDATE_REQUIRED";
    L54:
        return "SERVICE_MISSING";
    L56:
        return "SUCCESS";
    L58:
        return "UNKNOWN";
    L60:
        return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConnectionResult) == true) goto L8;
        return false;
    L8:
        ConnectionResult r101 = (ConnectionResult) r100;
        if (this.f274454zzb == r101.f274454zzb) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equal(this.zzc, r101.zzc) == false) goto L15;
        if (Objects.equal(this.zzd, r101.zzd) == false) goto L15;
        return true;
    }

    public ConnectionResult(int r100, PendingIntent r101) {
        this(r100, r101, null);
    }

    public void startResolutionForResult(Activity r100, int r110) throws IntentSender.SendIntentException {
        if (hasResolution() == true) goto L5;
        return;
    L5:
        PendingIntent r101 = this.zzc;
        Preconditions.checkNotNull(r101);
        r100.startIntentSenderForResult(r101.getIntentSender(), r110, null, 0, 0, 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = this.f274453zza;
        int r103 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, r102);
        SafeParcelWriter.writeInt(r100, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(r100, 3, getResolution(), r101, false);
        SafeParcelWriter.writeString(r100, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(r100, r103);
    }

    public ConnectionResult(int r100, PendingIntent r101, String r102) {
        this(1, r100, r101, r102);
    }
}
