package com.larus.account.saas.mfa.assist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/account/saas/mfa/assist/bean/MfaMessage;", "Landroid/os/Parcelable;", "", "scene", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "token", "b", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaMessage implements Parcelable {
    public static final Parcelable.Creator<MfaMessage> CREATOR = null;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("user_code")
    private final String token;

    public static final class a implements Parcelable.Creator<MfaMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MfaMessage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MfaMessage(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MfaMessage[] newArray(int r100) {
            return new MfaMessage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MfaMessage() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MfaMessage) == true) goto L8;
        return false;
    L8:
        MfaMessage r101 = (MfaMessage) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.token;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MfaMessage(scene=" + this.scene + ", token=" + this.token + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.scene);
        r100.writeString(this.token);
    }

    public final String a() {
        return this.scene;
    }

    public final String b() {
        return this.token;
    }

    public MfaMessage(String r100, String r101) {
        this.scene = r100;
        this.token = r101;
    }
}
