package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public PlayerBlock a;
    public final String b;
    public final int c;

    public final String getType() {
        return this.b;
    }

    public p(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.b = r2;
        this.c = r3;
    }
}
