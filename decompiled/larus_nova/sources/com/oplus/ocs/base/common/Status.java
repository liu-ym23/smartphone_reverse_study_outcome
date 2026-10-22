package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.ocs.base.common.constant.CommonStatusCodes;
import com.oplus.ocs.base.internal.safeparcel.AbstractSafeParcelable;
import com.oplus.ocs.base.utils.e;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public class Status extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f404150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f404151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f404152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PendingIntent f404153d;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f404150a), Integer.valueOf(this.f404151b), this.f404152c, this.f404153d});
    }

    static {
        CREATOR = new b();
    }

    public String toString() {
        e.a r100 = e.a(this);
        String r101 = this.f404152c;
        if (r101 != null) goto L7;
        r101 = CommonStatusCodes.getStatusCodeString(this.f404151b);
    L7:
        return r100.a("statusCode", r101).a("resolution", this.f404153d).toString();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Status) == false) goto L13;
        Status r101 = (Status) r100;
        if (this.f404150a != r101.f404150a) goto L13;
        if (this.f404151b != r101.f404151b) goto L13;
        if (e.a(this.f404152c, r101.f404152c) == false) goto L13;
        if (e.a(this.f404153d, r101.f404153d) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = com.oplus.ocs.base.internal.safeparcel.b.b(r100, 20293);
        com.oplus.ocs.base.internal.safeparcel.b.a(r100, 1, this.f404151b);
        com.oplus.ocs.base.internal.safeparcel.b.a(r100, 1000, this.f404150a);
        String r103 = this.f404152c;
        if (r103 == null) goto L5;
        int r104 = com.oplus.ocs.base.internal.safeparcel.b.b(r100, 2);
        r100.writeString(r103);
        com.oplus.ocs.base.internal.safeparcel.b.a(r100, r104);
    L5:
        PendingIntent r105 = this.f404153d;
        if (r105 == null) goto L8;
        int r106 = com.oplus.ocs.base.internal.safeparcel.b.b(r100, 3);
        r105.writeToParcel(r100, r101);
        com.oplus.ocs.base.internal.safeparcel.b.a(r100, r106);
    L8:
        com.oplus.ocs.base.internal.safeparcel.b.a(r100, r102);
    }

    public Status(int r100, int r101, String r102, PendingIntent r103) {
        this.f404150a = r100;
        this.f404151b = r101;
        this.f404152c = r102;
        this.f404153d = r103;
    }
}
