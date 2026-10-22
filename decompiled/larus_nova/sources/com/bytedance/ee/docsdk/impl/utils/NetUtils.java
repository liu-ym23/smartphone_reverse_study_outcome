package com.bytedance.ee.docsdk.impl.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/NetUtils;", "", "()V", "isValidUrl", "", "url", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetUtils {
    public static final NetUtils INSTANCE = null;

    static {
        INSTANCE = new NetUtils();
    }

    private NetUtils() {
    }

    public final boolean isValidUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.startsWith$default(r100, "http://", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r100, "https://", false, 2, null) == true) goto L6;
        return false;
    }
}
