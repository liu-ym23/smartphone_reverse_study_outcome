package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class ImportantFileWriterAndroid {

    public interface Natives {
        boolean writeFileAtomically(String r100, byte[] r101);
    }

    public ImportantFileWriterAndroid() {
    }

    public static boolean writeFileAtomically(String r100, byte[] r101) {
        return ImportantFileWriterAndroidJni.get().writeFileAtomically(r100, r101);
    }
}
