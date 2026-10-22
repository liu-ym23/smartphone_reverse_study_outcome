package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes23.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = null;
    public static final Status RESULT_CANCELED = null;
    public static final Status RESULT_DEAD_CLIENT = null;
    public static final Status RESULT_INTERNAL_ERROR = null;
    public static final Status RESULT_INTERRUPTED = null;
    public static final Status RESULT_SUCCESS = null;
    public static final Status RESULT_SUCCESS_CACHE = null;
    public static final Status RESULT_TIMEOUT = null;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    public static final Status f274468zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final int f274469zzb;
    private final String zzc;
    private final PendingIntent zzd;
    private final ConnectionResult zze;

    static {
        RESULT_SUCCESS_CACHE = new Status(-1);
        RESULT_SUCCESS = new Status(0);
        RESULT_INTERRUPTED = new Status(14);
        RESULT_INTERNAL_ERROR = new Status(8);
        RESULT_TIMEOUT = new Status(15);
        RESULT_CANCELED = new Status(16);
        f274468zza = new Status(17);
        RESULT_DEAD_CLIENT = new Status(18);
        CREATOR = new b();
    }

    public Status(int r100, String r101, PendingIntent r102, ConnectionResult r103) {
        this.f274469zzb = r100;
        this.zzc = r101;
        this.zzd = r102;
        this.zze = r103;
    }

    public ConnectionResult getConnectionResult() {
        return this.zze;
    }

    public PendingIntent getResolution() {
        return this.zzd;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.f274469zzb;
    }

    public String getStatusMessage() {
        return this.zzc;
    }

    public boolean hasResolution() {
        if (this.zzd == null) goto L6;
        return true;
    L6:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f274469zzb), this.zzc, this.zzd, this.zze});
    }

    public boolean isCanceled() {
        if (this.f274469zzb != 16) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isInterrupted() {
        if (this.f274469zzb != 14) goto L6;
        return true;
    L6:
        return false;
    }

    @CheckReturnValue
    public boolean isSuccess() {
        if (this.f274469zzb > 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String zza() {
        String r100 = this.zzc;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return CommonStatusCodes.getStatusCodeString(this.f274469zzb);
    }

    public String toString() {
        Objects.ToStringHelper r100 = Objects.toStringHelper(this);
        r100.add("statusCode", zza());
        r100.add("resolution", this.zzd);
        return r100.toString();
    }

    public Status(int r100) {
        this(r100, null);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Status) == true) goto L5;
        return false;
    L5:
        Status r101 = (Status) r100;
        if (this.f274469zzb == r101.f274469zzb) goto L8;
    L15:
        return false;
    L8:
        if (Objects.equal(this.zzc, r101.zzc) == false) goto L15;
        if (Objects.equal(this.zzd, r101.zzd) == false) goto L15;
        if (Objects.equal(this.zze, r101.zze) == false) goto L15;
        return true;
    }

    public void startResolutionForResult(ActivityResultLauncher<IntentSenderRequest> r100) {
        if (hasResolution() == true) goto L5;
        return;
    L5:
        PendingIntent r101 = this.zzd;
        Preconditions.checkNotNull(r101);
        r100.launch(new IntentSenderRequest.Builder(r101.getIntentSender()).build());
    }

    public Status(ConnectionResult r100, String r101) {
        this(r100, r101, 17);
    }

    public void startResolutionForResult(Activity r100, int r110) throws IntentSender.SendIntentException {
        if (hasResolution() == true) goto L5;
        return;
    L5:
        PendingIntent r101 = this.zzd;
        Preconditions.checkNotNull(r101);
        r100.startIntentSenderForResult(r101.getIntentSender(), r110, null, 0, 0, 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, getStatusCode());
        SafeParcelWriter.writeString(r100, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(r100, 3, this.zzd, r101, false);
        SafeParcelWriter.writeParcelable(r100, 4, getConnectionResult(), r101, false);
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }

    public Status(int r100, String r101) {
        this(r100, r101, null);
    }

    public Status(ConnectionResult r100, String r101, int r102) {
        this(r102, r101, r100.getResolution(), r100);
    }

    public Status(int r100, String r101, PendingIntent r102) {
        this(r100, r101, r102, null);
    }
}
