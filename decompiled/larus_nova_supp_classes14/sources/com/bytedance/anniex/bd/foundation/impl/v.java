package com.bytedance.anniex.bd.foundation.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v {
    public final String a;
    public final String b;
    public Map<String, String> c;

    public v(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "baseUrl");
        Intrinsics.checkNotNullParameter(r3, "relativePath");
        Intrinsics.checkNotNullParameter(r4, "queryMap");
        this.a = "";
        this.b = "";
        this.a = r2;
        this.b = r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.c = r4;
    }
}
