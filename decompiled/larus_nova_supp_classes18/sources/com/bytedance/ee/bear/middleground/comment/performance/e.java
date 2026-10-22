package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final String a;
    public final String b;
    public final long c;

    public final String getType() {
        return this.a;
    }

    public e(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter("part_comment", "domain");
        this.a = r3;
        this.b = "part_comment";
        this.c = System.currentTimeMillis();
    }
}
