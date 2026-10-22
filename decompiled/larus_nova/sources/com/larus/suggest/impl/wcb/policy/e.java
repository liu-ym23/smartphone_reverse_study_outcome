package com.larus.suggest.impl.wcb.policy;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f369967a = null;

    static {
        f369967a = new e();
    }

    public e() {
    }

    public final com.larus.suggest.impl.wcb.render.i b(com.larus.suggest.impl.wcb.request.f r100, NexPulseResponseData r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, "response");
        com.larus.suggest.impl.wcb.request.c r102 = r100.f370118f;
        int r103 = r102.f370104f;
        if (r102.f370099a.getKey().f511242b != WcbMode.OFFICE_TASK) goto L5;
        boolean r104 = true;
    L7:
        return new com.larus.suggest.impl.wcb.render.i(r103, r101, WcbRenderStatus.DEPRECATED, r104);
    L5:
        r104 = false;
        goto L7
    }

    public final com.larus.suggest.impl.wcb.render.i a(com.larus.suggest.impl.wcb.request.f r100, NexPulseResponseData r101, com.larus.suggest.impl.wcb.render.h r102) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_ANIMATION);
        Integer r103 = r101.getNexPulseType();
        String r104 = null;
        boolean r105 = true;
        if (r103 != null) goto L6;
    L7:
        Integer r106 = r101.getNexPulseType();
        if (r106 != null) goto L11;
    L12:
        Integer r107 = r101.getNexPulseType();
        if (r107 != null) goto L16;
    L17:
        return null;
    L16:
        if (r107.intValue() != 4) goto L17;
    L19:
        if (r102.f370047a == true) goto L22;
    L25:
        com.larus.suggest.impl.wcb.request.c r108 = r100.f370118f;
        int r109 = r108.f370104f;
        if (r108.f370099a.getKey().f511242b == WcbMode.OFFICE_TASK) goto L30;
        r105 = false;
    L30:
        return new com.larus.suggest.impl.wcb.render.i(r109, r101, r104, r105);
    L22:
        if (r102.f370048b == null) goto L24;
        r104 = WcbRenderStatus.UPDATED;
        goto L25
    L24:
        r104 = "DEFAULT";
        goto L25
    L11:
        if (r106.intValue() == 2) goto L19;
    L6:
        if (r103.intValue() == 1) goto L19;
        goto L7
    }
}
