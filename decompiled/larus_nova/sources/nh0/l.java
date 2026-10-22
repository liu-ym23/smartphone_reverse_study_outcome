package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatUpdateType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SeatUpdateType f519136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<tf0.d> f519137c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f519135a, r101.f519135a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519136b, r101.f519136b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519137c, r101.f519137c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f519135a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SeatUpdateType r104 = this.f519136b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<tf0.d> r107 = this.f519137c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatExtraObject(bizId=" + this.f519135a + ", type=" + this.f519136b + ", itemList=" + this.f519137c + ")";
    }

    public final SeatUpdateType getType() {
        return this.f519136b;
    }

    public l(String r100, SeatUpdateType r101, List<tf0.d> r102) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "itemList");
        this.f519135a = r100;
        this.f519136b = r101;
        this.f519137c = r102;
    }
}
