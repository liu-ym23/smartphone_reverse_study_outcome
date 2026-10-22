package com.larus.login.impl.lark_discover;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006'"}, d2 = {"Lcom/larus/login/impl/lark_discover/PhoneLoginAccountDiscoverySession;", "Landroid/os/Parcelable;", "mobile", "", "discovery", "Lcom/larus/login/impl/lark_discover/PhoneLoginAccountDiscovery;", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "triggerAppId", "pendingDeeplinkSchema", "<init>", "(Ljava/lang/String;Lcom/larus/login/impl/lark_discover/PhoneLoginAccountDiscovery;Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;Ljava/lang/String;Ljava/lang/String;)V", "getMobile", "()Ljava/lang/String;", "getDiscovery", "()Lcom/larus/login/impl/lark_discover/PhoneLoginAccountDiscovery;", "getSource", "()Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "getTriggerAppId", "getPendingDeeplinkSchema", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneLoginAccountDiscoverySession implements Parcelable {
    public static final Parcelable.Creator<PhoneLoginAccountDiscoverySession> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f357830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhoneLoginAccountDiscovery f357831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhoneLoginAccountDiscoverySource f357832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f357833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f357834e;

    public static final class a implements Parcelable.Creator<PhoneLoginAccountDiscoverySession> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountDiscoverySession createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PhoneLoginAccountDiscoverySession(r100.readString(), PhoneLoginAccountDiscovery.CREATOR.createFromParcel(r100), PhoneLoginAccountDiscoverySource.valueOf(r100.readString()), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountDiscoverySession[] newArray(int r100) {
            return new PhoneLoginAccountDiscoverySession[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneLoginAccountDiscoverySession() {
        this(null, new PhoneLoginAccountDiscovery(0), PhoneLoginAccountDiscoverySource.VERIFICATION_CODE, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneLoginAccountDiscoverySession) == true) goto L8;
        return false;
    L8:
        PhoneLoginAccountDiscoverySession r101 = (PhoneLoginAccountDiscoverySession) r100;
        if (Intrinsics.areEqual(this.f357830a, r101.f357830a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f357831b, r101.f357831b) == true) goto L15;
        return false;
    L15:
        if (this.f357832c == r101.f357832c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f357833d, r101.f357833d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f357834e, r101.f357834e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f357830a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f357831b.hashCode()) * 31) + this.f357832c.hashCode()) * 31;
        String r104 = this.f357833d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f357834e;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhoneLoginAccountDiscoverySession(mobile=" + this.f357830a + ", discovery=" + this.f357831b + ", source=" + this.f357832c + ", triggerAppId=" + this.f357833d + ", pendingDeeplinkSchema=" + this.f357834e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f357830a);
        this.f357831b.writeToParcel(r100, r101);
        r100.writeString(this.f357832c.name());
        r100.writeString(this.f357833d);
        r100.writeString(this.f357834e);
    }

    public PhoneLoginAccountDiscoverySession(String r100, PhoneLoginAccountDiscovery r101, PhoneLoginAccountDiscoverySource r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "discovery");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f357830a = r100;
        this.f357831b = r101;
        this.f357832c = r102;
        this.f357833d = r103;
        this.f357834e = r104;
    }
}
