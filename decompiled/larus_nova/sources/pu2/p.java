package pu2;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.common.PaidPreloadDataType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PaidSceneEnum f530718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PaidPreloadDataType f530719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f530720d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f530717a, r101.f530717a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f530718b, r101.f530718b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f530719c, r101.f530719c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530720d, r101.f530720d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f530717a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PaidSceneEnum r104 = this.f530718b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        PaidPreloadDataType r107 = this.f530719c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f530720d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenWithDataInfo(sceneEnum=" + this.f530718b + ", dataType=" + this.f530719c + ", ticketEntrance='" + this.f530720d + "')";
    }

    public p(String r100, PaidSceneEnum r101, PaidPreloadDataType r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "urlString");
        Intrinsics.checkNotNullParameter(r101, "sceneEnum");
        Intrinsics.checkNotNullParameter(r102, "dataType");
        Intrinsics.checkNotNullParameter(r103, "ticketEntrance");
        this.f530717a = r100;
        this.f530718b = r101;
        this.f530719c = r102;
        this.f530720d = r103;
    }
}
