package com.bytedance.locallife.dito.common.experiment;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Dito r101 = Dito.f257280a;
        jq6.a r102 = l.a();
        if (r102 == null) goto L8;
        Integer r103 = (Integer) ((en6.f) r102).a("dito_preset_opt_config_" + r100, Integer.TYPE, 0);
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.intValue();
    L8:
        return 0;
    }
}
