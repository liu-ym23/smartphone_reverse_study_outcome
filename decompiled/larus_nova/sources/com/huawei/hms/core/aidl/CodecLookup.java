package com.huawei.hms.core.aidl;

/* JADX INFO: loaded from: classes23.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int r100) {
        if (r100 != 2) goto L7;
        return new MessageCodecV2();
    L7:
        return new MessageCodec();
    }
}
