package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends j {
    public final String e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r0 = d();
        if (r0 == null) goto L7;
        Map<String, Boolean> r1 = r0.K();
        if (r1 == null) goto L7;
        boolean r2 = Intrinsics.areEqual(r1.get(this.e), Boolean.FALSE);
    L9:
        return !r2;
    L7:
        r2 = false;
        goto L9
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        this.e = r2;
    }
}
