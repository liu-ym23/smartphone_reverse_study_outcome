package com.bytedance.pia.core.utils;

import android.webkit.WebResourceResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    public static final WebResourceResponse a(i47.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new WebResourceResponse(r100.getMimeType(), r100.getEncoding(), r100.getStatusCode(), r100.getReasonPhrase(), r100.getHeaders(), r100.getData());
    }
}
