package com.bytedance.rts.foundation;

import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes10.dex */
public final class w {
    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "uriComponent");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r110, StandardCharsets.UTF_8.name()), Marker.ANY_NON_NULL_MARKER, "%20", false, 4, null), "*", "%2A", false, 4, null), "%7E", Constants.WAVE_SEPARATOR, false, 4, null);
    }
}
