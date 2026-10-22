package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements a {
    public final List<String> a;
    public final List<String> b;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.select.a
    public final List<String> a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.select.a
    public final List<String> b() {
        return this.a;
    }

    public j(List<String> r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "originDataList");
        Intrinsics.checkNotNullParameter(r3, "selectedDataList");
        this.a = r2;
        this.b = r3;
    }
}
