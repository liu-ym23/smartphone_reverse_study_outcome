package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class Status extends Result implements Parcelable {
    public static final Parcelable.Creator<Status> CREATOR = null;
    public static final Status CoreException = null;
    public static final Status FAILURE = null;
    public static final Status MessageNotFound = null;
    public static final Status RESULT_CANCELED = null;
    public static final Status RESULT_DEAD_CLIENT = null;
    public static final Status RESULT_INTERNAL_ERROR = null;
    public static final Status RESULT_INTERRUPTED = null;
    public static final Status RESULT_TIMEOUT = null;
    public static final Status SUCCESS = null;

    @Packed
    private Intent intent;

    @Packed
    private PendingIntent pendingIntent;

    @Packed
    private int statusCode;

    @Packed
    private String statusMessage;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public Status a(Parcel r100) {
            return new Status(r100.readInt(), r100.readString(), PendingIntent.readPendingIntentOrNullFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r100) {
            return a(r100);
        }

        public Status[] a(int r100) {
            return new Status[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent, this.intent});
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isInterrupted() {
        return false;
    }

    static {
        SUCCESS = new Status(0);
        FAILURE = new Status(1);
        RESULT_CANCELED = new Status(16);
        RESULT_DEAD_CLIENT = new Status(18);
        RESULT_INTERNAL_ERROR = new Status(8);
        RESULT_INTERRUPTED = new Status(14);
        RESULT_TIMEOUT = new Status(15);
        MessageNotFound = new Status(404);
        CoreException = new Status(500);
        CREATOR = new a();
    }

    public boolean hasResolution() {
        if (this.pendingIntent == null) goto L5;
    L8:
        return true;
    L5:
        if (this.intent != null) goto L8;
        return false;
    }

    public boolean isSuccess() {
        if (this.statusCode > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + this.pendingIntent + ", intent: " + this.intent + ",}";
    }

    public String getErrorString() {
        return getStatusMessage();
    }

    public PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public Intent getResolutionIntent() {
        return this.intent;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Status(int r100) {
        this(r100, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Status) == false) goto L18;
        Status r101 = (Status) r100;
        if (this.statusCode == r101.statusCode) goto L10;
    L16:
        return false;
    L10:
        if (equal(this.statusMessage, r101.statusMessage) == false) goto L16;
        if (equal(this.pendingIntent, r101.pendingIntent) == false) goto L16;
        if (equal(this.intent, r101.intent) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public void setIntent(Intent r100) {
        this.intent = r100;
    }

    public void setPendingIntent(PendingIntent r100) {
        this.pendingIntent = r100;
    }

    public Status(int r100, String r101) {
        this.statusCode = r100;
        this.statusMessage = r101;
    }

    private static boolean equal(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public void startResolutionForResult(Activity r100, int r110) throws IntentSender.SendIntentException {
        if (r100 != null) goto L5;
        return;
    L5:
        if (hasResolution() == false) goto L11;
        PendingIntent r101 = this.pendingIntent;
        if (r101 == null) goto L9;
        r100.startIntentSenderForResult(r101.getIntentSender(), r110, null, 0, 0, 0);
        return;
    L9:
        r100.startActivityForResult(this.intent, r110);
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.writeInt(this.statusCode);
        r100.writeString(this.statusMessage);
        PendingIntent r102 = this.pendingIntent;
        if (r102 == null) goto L7;
        r102.writeToParcel(r100, r101);
    L7:
        PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, r100);
        Intent r103 = this.intent;
        if (r103 == null) goto L11;
        r103.writeToParcel(r100, r101);
        return;
    }

    public Status(int r100, String r101, PendingIntent r102) {
        this.statusCode = r100;
        this.statusMessage = r101;
        this.pendingIntent = r102;
    }

    public Status(int r100, String r101, Intent r102) {
        this.statusCode = r100;
        this.statusMessage = r101;
        this.intent = r102;
    }
}
