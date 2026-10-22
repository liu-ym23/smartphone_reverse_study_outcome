package com.bytedance.android.shopping.store.mall.follows.apidata;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final void delete(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Keva.getRepo("follow_store", 1).storeString(r3, null);
    }

    public final String query(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Keva.getRepo("follow_store", 1).getString(r3, null);
    }
}
