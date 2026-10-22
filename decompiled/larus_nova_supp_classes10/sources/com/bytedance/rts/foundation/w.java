package com.bytedance.rts.foundation;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w {
    public static final String a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "uriComponent");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r13, StandardCharsets.UTF_8.name()), "+", "%20", false, 4, null), "*", "%2A", false, 4, null), "%7E", "~", false, 4, null);
    }
}
