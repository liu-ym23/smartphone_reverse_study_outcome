package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    public interface Natives {
        void override(int r100, String r101);
    }

    private PathService() {
    }

    public static void override(int r100, String r101) {
        PathServiceJni.get().override(r100, r101);
    }
}
