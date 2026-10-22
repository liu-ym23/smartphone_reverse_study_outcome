package com.larus.suggest.impl.wcb.policy;

import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f369961a = null;

    static {
        f369961a = new b();
    }

    public b() {
    }

    public final String a(com.larus.suggest.impl.wcb.request.f r100, hx9.l r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.f370118f.f370100b != WcbRequestTrigger.REGENERATE) goto L6;
        return null;
    L6:
        if (r101.d() == false) goto L9;
        return "minor mode";
    L9:
        wc9.e r102 = r101.O8();
        if (r102 != null) goto L14;
        return "conversation unavailable";
    L14:
        if (Intrinsics.areEqual(r102.f559198a, r100.f370114b) == true) goto L18;
        return "new conversation changed";
    L18:
        return null;
    }
}
