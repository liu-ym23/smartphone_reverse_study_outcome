package com.larus.extension.account_auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006+"}, d2 = {"Lcom/larus/extension/account_auth/api/model/TelecomProviderData;", "Landroid/os/Parcelable;", "maskUserMobile", "", "telecomProvider", "Lcom/larus/extension/account_auth/api/model/TelecomProvider;", "networkType", "providerAppId", "telecomPolicy", "telecomPolicyDescription", "token", "<init>", "(Ljava/lang/String;Lcom/larus/extension/account_auth/api/model/TelecomProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMaskUserMobile", "()Ljava/lang/String;", "getTelecomProvider", "()Lcom/larus/extension/account_auth/api/model/TelecomProvider;", BpeaManager.getNetworkType, "getProviderAppId", "getTelecomPolicy", "getTelecomPolicyDescription", "getToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TelecomProviderData implements Parcelable {
    public static final Parcelable.Creator<TelecomProviderData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f342484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TelecomProvider f342485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f342486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f342487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f342488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f342489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f342490g;

    public static final class a implements Parcelable.Creator<TelecomProviderData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TelecomProviderData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new TelecomProviderData(r110.readString(), TelecomProvider.valueOf(r110.readString()), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final TelecomProviderData[] newArray(int r100) {
            return new TelecomProviderData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TelecomProviderData) == true) goto L8;
        return false;
    L8:
        TelecomProviderData r101 = (TelecomProviderData) r100;
        if (Intrinsics.areEqual(this.f342484a, r101.f342484a) == true) goto L12;
        return false;
    L12:
        if (this.f342485b == r101.f342485b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f342486c, r101.f342486c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f342487d, r101.f342487d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f342488e, r101.f342488e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f342489f, r101.f342489f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f342490g, r101.f342490g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f342484a.hashCode() * 31) + this.f342485b.hashCode()) * 31) + this.f342486c.hashCode()) * 31) + this.f342487d.hashCode()) * 31) + this.f342488e.hashCode()) * 31) + this.f342489f.hashCode()) * 31;
        String r101 = this.f342490g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TelecomProviderData(maskUserMobile=" + this.f342484a + ", telecomProvider=" + this.f342485b + ", networkType=" + this.f342486c + ", providerAppId=" + this.f342487d + ", telecomPolicy=" + this.f342488e + ", telecomPolicyDescription=" + this.f342489f + ", token=" + this.f342490g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f342484a);
        r100.writeString(this.f342485b.name());
        r100.writeString(this.f342486c);
        r100.writeString(this.f342487d);
        r100.writeString(this.f342488e);
        r100.writeString(this.f342489f);
        r100.writeString(this.f342490g);
    }

    public TelecomProviderData(String r100, TelecomProvider r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "maskUserMobile");
        Intrinsics.checkNotNullParameter(r101, "telecomProvider");
        Intrinsics.checkNotNullParameter(r102, "networkType");
        Intrinsics.checkNotNullParameter(r103, "providerAppId");
        Intrinsics.checkNotNullParameter(r104, "telecomPolicy");
        Intrinsics.checkNotNullParameter(r105, "telecomPolicyDescription");
        this.f342484a = r100;
        this.f342485b = r101;
        this.f342486c = r102;
        this.f342487d = r103;
        this.f342488e = r104;
        this.f342489f = r105;
        this.f342490g = r106;
    }
}
