package com.larus.account.saas.mfa.assist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larus/account/saas/mfa/assist/bean/MfaPushCodeResponse;", "Landroid/os/Parcelable;", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaPushCodeResponse implements Parcelable {
    public static final Parcelable.Creator<MfaPushCodeResponse> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f286418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f286420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f286421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f286422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f286423g;

    public static final class a implements Parcelable.Creator<MfaPushCodeResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MfaPushCodeResponse createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r101 = null;
        L7:
            return new MfaPushCodeResponse(r100, r101, r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        L5:
            r101 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MfaPushCodeResponse[] newArray(int r100) {
            return new MfaPushCodeResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MfaPushCodeResponse() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MfaPushCodeResponse) == true) goto L8;
        return false;
    L8:
        MfaPushCodeResponse r101 = (MfaPushCodeResponse) r100;
        if (Intrinsics.areEqual(this.f286417a, r101.f286417a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286418b, r101.f286418b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286419c, r101.f286419c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f286420d, r101.f286420d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f286421e, r101.f286421e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f286422f, r101.f286422f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f286423g, r101.f286423g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f286417a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f286418b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f286419c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f286420d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f286421e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f286422f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f286423g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MfaPushCodeResponse(code=" + this.f286417a + ", expireTime=" + this.f286418b + ", title=" + this.f286419c + ", allowPopMessage=" + this.f286420d + ", codePopMessage=" + this.f286421e + ", loginLocation=" + this.f286422f + ", loginDeviceName=" + this.f286423g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.f286417a);
        Long r102 = this.f286418b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f286419c);
        r100.writeString(this.f286420d);
        r100.writeString(this.f286421e);
        r100.writeString(this.f286422f);
        r100.writeString(this.f286423g);
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public MfaPushCodeResponse(String r100, Long r101, String r102, String r103, String r104, String r105, String r106) {
        this.f286417a = r100;
        this.f286418b = r101;
        this.f286419c = r102;
        this.f286420d = r103;
        this.f286421e = r104;
        this.f286422f = r105;
        this.f286423g = r106;
    }
}
