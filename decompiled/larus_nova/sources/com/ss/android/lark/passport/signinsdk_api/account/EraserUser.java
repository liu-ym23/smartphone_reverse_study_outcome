package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/account/EraserUser;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "uid", "", "tenantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getTenantId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EraserUser implements Parcelable, Serializable {
    public static final Parcelable.Creator<EraserUser> CREATOR = null;
    private final String tenantId;
    private final String uid;

    public static final class a implements Parcelable.Creator<EraserUser> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EraserUser createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new EraserUser(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final EraserUser[] newArray(int r100) {
            return new EraserUser[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ EraserUser copy$default(EraserUser r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uid;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tenantId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.tenantId;
    }

    public final EraserUser copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
        return new EraserUser(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EraserUser) == true) goto L8;
        return false;
    L8:
        EraserUser r101 = (EraserUser) r100;
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.uid.hashCode() * 31) + this.tenantId.hashCode();
    }

    public String toString() {
        return "EraserUser(uid=" + this.uid + ", tenantId=" + this.tenantId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.uid);
        r100.writeString(this.tenantId);
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUid() {
        return this.uid;
    }

    public EraserUser(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
        this.uid = r100;
        this.tenantId = r101;
    }
}
