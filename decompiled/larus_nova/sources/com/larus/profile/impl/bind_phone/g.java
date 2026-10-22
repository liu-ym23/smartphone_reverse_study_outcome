package com.larus.profile.impl.bind_phone;

import com.google.gson.annotations.SerializedName;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/profile/impl/bind_phone/GetUserPhoneBindInfoData;", "", "bindStatus", "", "phoneNumberMask", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getBindStatus", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPhoneNumberMask", "()Ljava/lang/String;", "shouldShowDialog", "", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/profile/impl/bind_phone/GetUserPhoneBindInfoData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("bind_status")
    private final Long bindStatus;

    @SerializedName("phone_number_mask")
    private final String phoneNumberMask;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.bindStatus, r101.bindStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneNumberMask, r101.phoneNumberMask) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.bindStatus;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.phoneNumberMask;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetUserPhoneBindInfoData(bindStatus=" + this.bindStatus + ", phoneNumberMask=" + this.phoneNumberMask + ')';
    }

    public final boolean b() {
        Long r100 = this.bindStatus;
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.longValue() != 2) goto L10;
        if (o0.d(this.phoneNumberMask) == false) goto L10;
        return true;
    }

    public g() {
        this.bindStatus = null;
        this.phoneNumberMask = null;
    }

    public final String a() {
        return this.phoneNumberMask;
    }
}
