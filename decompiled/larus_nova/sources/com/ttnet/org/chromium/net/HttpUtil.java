package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public final class HttpUtil {

    public interface Natives {
        boolean isAllowedHeader(String r100, String r101);
    }

    public HttpUtil() {
    }

    public static boolean isAllowedHeader(String r100, String r101) {
        return HttpUtilJni.get().isAllowedHeader(r100, r101);
    }
}
