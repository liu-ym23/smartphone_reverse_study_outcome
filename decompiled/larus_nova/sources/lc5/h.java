package lc5;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Document f508454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508455e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f508451a, r101.f508451a) == true) goto L12;
        return false;
    L12:
        if (this.f508452b == r101.f508452b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508453c, r101.f508453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508454d, r101.f508454d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508455e, r101.f508455e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508451a.hashCode() * 31;
        if (this.f508452b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + this.f508453c.hashCode()) * 31) + this.f508454d.hashCode()) * 31) + this.f508455e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ReportAddManualLineParam(analyticService=" + this.f508451a + ", isGrid=" + this.f508452b + ", module=" + this.f508453c + ", item=" + this.f508454d + ", result=" + this.f508455e + ')';
    }

    public h(com.bytedance.ee.bear.contract.d r100, boolean r101, String r102, Document r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r104, "result");
        this.f508451a = r100;
        this.f508452b = r101;
        this.f508453c = r102;
        this.f508454d = r103;
        this.f508455e = r104;
    }
}
