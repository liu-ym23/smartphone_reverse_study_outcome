package com.bytedance.android.shopping.sameproduct.helper;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public JSONObject a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }
}
