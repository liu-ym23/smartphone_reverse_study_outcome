package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.SyncType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 extends f {
    public static final a m = null;
    public final String j;
    public final int k;
    public final SyncType l;

    public static final class a {
        public a() {
        }
    }

    static {
        m = new a();
    }

    public k0(String r2, int r3, SyncType r4) {
        Intrinsics.checkNotNullParameter(r2, "notice");
        super(3005);
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }
}
