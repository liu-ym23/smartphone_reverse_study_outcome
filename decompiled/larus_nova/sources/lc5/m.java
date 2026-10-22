package lc5;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f508486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Document f508487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f508488g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f508482a, r101.f508482a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508483b, r101.f508483b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508484c, r101.f508484c) == true) goto L18;
        return false;
    L18:
        if (this.f508485d == r101.f508485d) goto L21;
        return false;
    L21:
        if (this.f508486e == r101.f508486e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508487f, r101.f508487f) == true) goto L27;
        return false;
    L27:
        if (this.f508488g == r101.f508488g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f508482a.hashCode() * 31) + this.f508483b.hashCode()) * 31) + this.f508484c.hashCode()) * 31) + this.f508485d) * 31;
        if (this.f508486e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f508487f.hashCode()) * 31) + this.f508488g;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ReportItemClickParam(analyticService=" + this.f508482a + ", module=" + this.f508483b + ", subModule=" + this.f508484c + ", position=" + this.f508485d + ", isGrid=" + this.f508486e + ", item=" + this.f508487f + ", deepIndex=" + this.f508488g + ')';
    }

    public m(com.bytedance.ee.bear.contract.d r100, String r101, String r102, int r103, boolean r104, Document r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "subModule");
        Intrinsics.checkNotNullParameter(r105, MapController.ITEM_LAYER_TAG);
        this.f508482a = r100;
        this.f508483b = r101;
        this.f508484c = r102;
        this.f508485d = r103;
        this.f508486e = r104;
        this.f508487f = r105;
        this.f508488g = r106;
    }
}
