package com.bytedance.locallife.dito.common.experiment;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final boolean a() {
        Dito r100 = Dito.f257280a;
        jq6.a r101 = l.a();
        if (r101 == null) goto L11;
        en6.f r102 = (en6.f) r101;
        Integer r103 = (Integer) r102.a("dito_lynx_data_deserialization_1", Integer.TYPE, 0);
        if (r103 != null) goto L8;
        return false;
    L8:
        if (r103.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}
