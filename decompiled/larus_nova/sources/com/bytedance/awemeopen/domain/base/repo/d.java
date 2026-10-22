package com.bytedance.awemeopen.domain.base.repo;

import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final String a(AoNetResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getHeaderString(NetResponse.HEADER_KEY_LOG_ID);
    L5:
        return null;
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = UriProtector.parse(r100).getPath();     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        r100 = r101;
    L9:
        if (StringsKt.startsWith(r100, "/aweme/open/export_sdk/", true) == true) goto L11;
        return r100;
    L11:
        return r100.substring(23);
    }

    public static final Exception c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Exception) == false) goto L6;
        return (Exception) r100;
    L6:
        return new Exception(r100);
    }
}
