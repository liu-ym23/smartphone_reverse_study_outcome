package com.bytedance.applet.aibridge;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements l4 {
    public final /* synthetic */ AbsAIBridgePreloadMediaResourceMethodIDL.a a;
    public final /* synthetic */ f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> b;
    public final /* synthetic */ z3 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public final void a(String r8, com.larus.video.impl.sdk.a r9) {
        if (Intrinsics.areEqual(this.a.getResource(), r8) == false) goto L8;
        if (r9 == null) goto L8;
        z3.a.a(this.c, r9, this.d, this.e, new AIBridgePreloadMediaResourceMethod.b(this.b), 8);
        return;
    L8:
        f3.h.a.a(this.b, "getVideoModel fails", null, null, 14);
    }

    public k(AbsAIBridgePreloadMediaResourceMethodIDL.a r1, f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r2, z3 r3, String r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
