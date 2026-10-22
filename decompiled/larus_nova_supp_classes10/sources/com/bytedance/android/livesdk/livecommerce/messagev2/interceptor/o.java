package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o extends a {
    public o() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        sg2.b r0 = r8.getCommon();
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L6:
        sg2.b r2 = r8.getCommon();
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        sg2.b r4 = r8.getCommon();
        if (r4 == null) goto L13;
        boolean r5 = r4.f;
    L14:
        xh.b.d r6 = new xh.b.d();
        sg2.b r7 = r8.getCommon();
        if (r7 == null) goto L18;
        String r9 = r7.e;
        if (r9 == null) goto L18;
    L19:
        r6.d(r9);
        r6.c(r3);
        r6.b(r5);
        if (ECAppInfoService.e.isLocalTest() == true) goto L23;
        r8 = null;
    L23:
        r6.a(r8);
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"LiveInteractionMessage", "ProductListUpdateMessage", "ProductUpdateMessage"}), r1) == false) goto L26;
        int r10 = 3;
    L27:
        xh.c.a("Live").h(null, r1, r6, r10);
        return false;
    L26:
        r10 = 4;
    L18:
        r9 = "";
        goto L19
    L13:
        r5 = false;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
