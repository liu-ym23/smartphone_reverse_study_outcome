package nh0;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StageUpdateType f519142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f519145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayerIndex f519146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f519147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f519148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f519149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f519150i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L24;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f519142a, r101.f519142a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519143b, r101.f519143b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519144c, r101.f519144c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519145d, r101.f519145d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f519146e, r101.f519146e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f519147f, r101.f519147f) == true) goto L18;
        return false;
    L18:
        if (this.f519148g == r101.f519148g) goto L20;
        return false;
    L20:
        if (this.f519149h == r101.f519149h) goto L22;
        return false;
    L22:
        if (this.f519150i == r101.f519150i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        StageUpdateType r100 = this.f519142a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f519143b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f519144c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f519145d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        LayerIndex r113 = this.f519146e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        n r116 = this.f519147f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        long r118 = this.f519148g;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        boolean r120 = this.f519149h;
        ?? r121 = 1;
        ?? r122 = r120;
        if (r120 == false) goto L28;
        r122 = 1;
    L28:
        int r123 = (r119 + r122) * 31;
        boolean r124 = this.f519150i;
        if (r124 == true) goto L33;
        r121 = r124;
    L33:
        return r123 + r121;
    L21:
        r114 = 0;
        goto L22
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
        return "StageExtraObject(type=" + this.f519142a + ", itemId=" + this.f519143b + ", lynxSchema=" + this.f519144c + ", lynxUrl=" + this.f519145d + ", layer=" + this.f519146e + ", frame=" + this.f519147f + ", time=" + this.f519148g + ", useSchema=" + this.f519149h + ", needSendEvent=" + this.f519150i + ")";
    }

    public final StageUpdateType getType() {
        return this.f519142a;
    }

    public o(StageUpdateType r100, String r101, String r102, String r103, LayerIndex r104, n r105, long r106, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r102, "lynxSchema");
        Intrinsics.checkNotNullParameter(r103, "lynxUrl");
        Intrinsics.checkNotNullParameter(r104, GXTemplateKey.GAIAX_LAYER);
        this.f519142a = r100;
        this.f519143b = r101;
        this.f519144c = r102;
        this.f519145d = r103;
        this.f519146e = r104;
        this.f519147f = r105;
        this.f519148g = r106;
        this.f519149h = r110;
        this.f519150i = r111;
    }
}
