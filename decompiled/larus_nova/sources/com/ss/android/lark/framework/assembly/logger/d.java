package com.ss.android.lark.framework.assembly.logger;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements com.suite.component.logger.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f425663a;

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f425663a = r100;
    }

    @Override // com.suite.component.logger.api.d
    public final void a(com.suite.component.logger.api.d.a r100, com.suite.component.logger.b r101, com.suite.component.logger.c r102) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "entity");
        String r103 = this.f425663a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("@userID", "key");
        if (r102.f460130p != null) goto L5;
        r102.f460130p = new HashMap(4);
    L5:
        HashMap<String, Object> r104 = r102.f460130p;
        if (r104 == null) goto L8;
        r104.put("@userID", r103);
    L8:
        r100.a(r101, r102);
    }
}
