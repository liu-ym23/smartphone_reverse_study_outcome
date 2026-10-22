package com.ttnet.org.chromium.url;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.IDN;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("url::android")
public class IDNStringUtil {
    public IDNStringUtil() {
    }

    private static String idnToASCII(String r100) {
        return IDN.toASCII(r100, 2);
    L5:
        return null;
    }
}
