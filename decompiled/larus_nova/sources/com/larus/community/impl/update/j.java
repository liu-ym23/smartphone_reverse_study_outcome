package com.larus.community.impl.update;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f329926a;

    public j(String r100) {
        this.f329926a = r100;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (Intrinsics.areEqual(this.f329926a, r100) == false) goto L8;
        FLogger.f375446a.i("CreationLLMUpdateShowHelper", "preLoadVideoModel");
        Lazy r102 = q3.f365794a;
        z3 r103 = q3.a();
        if (r103 == null) goto L9;
        z3.a.a(r103, r101, null, 30720000, null, 26);
        return;
    L9:
        return;
    }
}
