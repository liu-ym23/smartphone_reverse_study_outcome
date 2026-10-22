package lc5;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Document f508434e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f508430a, r101.f508430a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508431b, r101.f508431b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508432c, r101.f508432c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508433d, r101.f508433d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508434e, r101.f508434e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f508430a.hashCode() * 31) + this.f508431b.hashCode()) * 31) + this.f508432c.hashCode()) * 31) + this.f508433d.hashCode()) * 31) + this.f508434e.hashCode();
    }

    public final String toString() {
        return "CollectStarOrPinParams(analyticService=" + this.f508430a + ", source=" + this.f508431b + ", module=" + this.f508432c + ", tag=" + this.f508433d + ", item=" + this.f508434e + ')';
    }

    public a(com.bytedance.ee.bear.contract.d r100, String r101, String r102, String r103, Document r104) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "tag");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        this.f508430a = r100;
        this.f508431b = r101;
        this.f508432c = r102;
        this.f508433d = r103;
        this.f508434e = r104;
    }
}
