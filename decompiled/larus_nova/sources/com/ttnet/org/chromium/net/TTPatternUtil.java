package com.ttnet.org.chromium.net;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class TTPatternUtil {
    public TTPatternUtil() {
    }

    public static boolean isPatternStringValid(String r100) {
        PatternProtector.compile(r100);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
