package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public final class GURLUtils {

    public interface Natives {
        String getOrigin(String r100);
    }

    public GURLUtils() {
    }

    public static String getOrigin(String r100) {
        return GURLUtilsJni.get().getOrigin(r100);
    }
}
