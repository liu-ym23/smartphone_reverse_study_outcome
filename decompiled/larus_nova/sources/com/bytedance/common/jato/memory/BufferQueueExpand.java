package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class BufferQueueExpand {
    public BufferQueueExpand() {
    }

    public static native boolean doCodecInputBufferQueueExpandOpt(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}
