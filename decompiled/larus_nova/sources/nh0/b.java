package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AnimUpdateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimUpdateType f519107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f519110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f519111e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f519107a, r101.f519107a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519108b, r101.f519108b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519109c, r101.f519109c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519110d, r101.f519110d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f519111e, r101.f519111e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        AnimUpdateType r100 = this.f519107a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f519108b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f519109c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.f519110d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f519111e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "AnimExtraObject(type=" + this.f519107a + ", itemId=" + this.f519108b + ", webpUrl=" + this.f519109c + ", frame=" + this.f519110d + ", uid=" + this.f519111e + ")";
    }

    public final AnimUpdateType getType() {
        return this.f519107a;
    }

    public b(AnimUpdateType r100, String r101, String r102, a r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r102, "webpUrl");
        this.f519107a = r100;
        this.f519108b = r101;
        this.f519109c = r102;
        this.f519110d = r103;
        this.f519111e = r104;
    }
}
