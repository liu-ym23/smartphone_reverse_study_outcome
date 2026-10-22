package og3;

import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<DATA extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f523187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DATA f523188b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f523187a, r101.f523187a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f523188b, r101.f523188b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f523187a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DATA r104 = this.f523188b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GlobalStateStore(pageInfo=" + this.f523187a + ", bizData=" + this.f523188b + ")";
    }

    public b(c r100, DATA r101) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        Intrinsics.checkNotNullParameter(r101, RuleConditionBean.BIZ_DATA_KEY);
        this.f523187a = r100;
        this.f523188b = r101;
    }
}
