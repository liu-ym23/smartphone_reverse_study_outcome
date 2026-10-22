package com.larus.suggest.impl.wcb.policy;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f369969a = null;

    static {
        f369969a = new f();
    }

    public f() {
    }

    public final com.larus.suggest.impl.wcb.render.o a(com.larus.suggest.impl.wcb.request.f r100, NexPulseResponseData r101, com.larus.suggest.impl.wcb.render.h r102) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_ANIMATION);
        com.larus.suggest.impl.wcb.request.c r103 = r100.f370118f;
        com.larus.suggest.impl.wcb.render.p r104 = r103.f370103e;
        if (r103.f370100b != WcbRequestTrigger.REGENERATE) goto L8;
        if (r104 == null) goto L7;
        return new com.larus.suggest.impl.wcb.render.o.c(r104);
    L7:
        return new com.larus.suggest.impl.wcb.render.o.b();
    L8:
        boolean r105 = r102.f370047a;
        if (r105 == false) goto L13;
        if (r104 == null) goto L13;
        return new com.larus.suggest.impl.wcb.render.o.c(r104);
    L13:
        if (r105 == false) goto L24;
        Integer r106 = r101.getNexPulseType();
        if (r106 == null) goto L24;
        if (r106.intValue() != 1) goto L24;
        com.larus.suggest.impl.wcb.render.p r107 = r102.f370048b;
        if (r107 == null) goto L24;
        return new com.larus.suggest.impl.wcb.render.o.c(r107);
    L24:
        return com.larus.suggest.impl.wcb.render.o.a.f370065a;
    }
}
