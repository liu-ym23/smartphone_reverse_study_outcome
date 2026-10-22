package com.bytedance.helios.sdk.engine;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.helios.sdk.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends v97.b {
    public d() {
        super(LocationMonitorConst.IS_BACKGROUND);
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        if (r100.isEmpty() == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L11;
        Integer r103 = (Integer) ListProtector.get(r100, 0);
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        int r105 = r104 * 1000;
        Long r106 = p.f245593n.f245602i;
        if (r106 != null) goto L15;
    L17:
        r101 = false;
    L19:
        return Boolean.valueOf(r101);
    L15:
        if ((System.currentTimeMillis() - r106.longValue()) <= r105) goto L17;
    L11:
        r104 = 1;
        goto L12
    L5:
        r102 = false;
        goto L6
    }
}
