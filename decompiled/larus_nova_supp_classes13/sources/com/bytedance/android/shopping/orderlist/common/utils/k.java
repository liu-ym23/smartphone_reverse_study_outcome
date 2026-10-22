package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.b1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public final a a;
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.a b;
    public final Context c;

    public static final class a implements b1 {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "filePath");
            this.a.b.a();
        }
    }

    public final Context getContext() {
        return this.c;
    }

    public k(com.bytedance.android.shopping.orderlist.common.monitor.error.a r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "tracker");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r2;
        this.c = r3;
        this.a = new a(this);
    }
}
