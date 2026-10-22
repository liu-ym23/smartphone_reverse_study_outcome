package com.larus.login.impl.lark_discover;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/larus/login/impl/lark_discover/PhoneLoginAccountDiscovery;", "Landroid/os/Parcelable;", "mobileTicket", "", "smsCodeKey", "existDoubaoAccount", "", "description", "accounts", "", "Lcom/larus/login/impl/lark_discover/PhoneLoginAccountCandidate;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getMobileTicket", "()Ljava/lang/String;", "getSmsCodeKey", "getExistDoubaoAccount", "()Z", "getDescription", "getAccounts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneLoginAccountDiscovery implements Parcelable {
    public static final Parcelable.Creator<PhoneLoginAccountDiscovery> CREATOR = null;

    @SerializedName("sub_account")
    private final List<PhoneLoginAccountCandidate> accounts;

    @SerializedName("description")
    private final String description;

    @SerializedName("exist_doubao_account")
    private final boolean existDoubaoAccount;

    @SerializedName("mobile_ticket")
    private final String mobileTicket;

    @SerializedName("sms_code_key")
    private final String smsCodeKey;

    public static final class a implements Parcelable.Creator<PhoneLoginAccountDiscovery> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountDiscovery createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            int r102 = 0;
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L6:
            String r104 = r110.readString();
            ArrayList r105 = null;
            if (r110.readInt() == 0) goto L18;
            int r106 = r110.readInt();
            ArrayList r107 = new ArrayList(r106);
        L10:
            if (r102 == r106) goto L16;
            if (r110.readInt() != 0) goto L14;
            PhoneLoginAccountCandidate r108 = null;
        L15:
            r107.add(r108);
            r102 = r102 + 1;
            goto L10
        L14:
            r108 = PhoneLoginAccountCandidate.CREATOR.createFromParcel(r110);
            goto L15
        L16:
            r105 = r107;
        L18:
            return new PhoneLoginAccountDiscovery(r100, r101, r103, r104, r105);
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountDiscovery[] newArray(int r100) {
            return new PhoneLoginAccountDiscovery[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneLoginAccountDiscovery() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneLoginAccountDiscovery) == true) goto L8;
        return false;
    L8:
        PhoneLoginAccountDiscovery r101 = (PhoneLoginAccountDiscovery) r100;
        if (Intrinsics.areEqual(this.mobileTicket, r101.mobileTicket) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.smsCodeKey, r101.smsCodeKey) == true) goto L15;
        return false;
    L15:
        if (this.existDoubaoAccount == r101.existDoubaoAccount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.accounts, r101.accounts) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.mobileTicket;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.smsCodeKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.existDoubaoAccount == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        String r109 = this.description;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<PhoneLoginAccountCandidate> r112 = this.accounts;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhoneLoginAccountDiscovery(mobileTicket=" + this.mobileTicket + ", smsCodeKey=" + this.smsCodeKey + ", existDoubaoAccount=" + this.existDoubaoAccount + ", description=" + this.description + ", accounts=" + this.accounts + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.mobileTicket);
        r100.writeString(this.smsCodeKey);
        r100.writeInt(this.existDoubaoAccount ? 1 : 0);
        r100.writeString(this.description);
        List<PhoneLoginAccountCandidate> r102 = this.accounts;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<PhoneLoginAccountCandidate> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        PhoneLoginAccountCandidate r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final List<PhoneLoginAccountCandidate> a() {
        return this.accounts;
    }

    public final String b() {
        return this.description;
    }

    public final boolean c() {
        return this.existDoubaoAccount;
    }

    public final String d() {
        return this.mobileTicket;
    }

    public final String e() {
        return this.smsCodeKey;
    }

    public /* synthetic */ PhoneLoginAccountDiscovery(int r100) {
        this(null, null, false, null, null);
    }

    public PhoneLoginAccountDiscovery(String r100, String r101, boolean r102, String r103, List<PhoneLoginAccountCandidate> r104) {
        this.mobileTicket = r100;
        this.smsCodeKey = r101;
        this.existDoubaoAccount = r102;
        this.description = r103;
        this.accounts = r104;
    }
}
