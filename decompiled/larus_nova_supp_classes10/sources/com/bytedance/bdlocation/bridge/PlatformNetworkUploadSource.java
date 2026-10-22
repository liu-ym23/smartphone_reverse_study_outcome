package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PlatformNetworkUploadSource {
    public static final int TYPE_BYTES = 0;
    public static final int TYPE_FILE_PATH = 1;
    public final long byteCount;
    public final long byteOffset;
    public final byte[] bytes;
    public final String filePath;
    public final int type;

    public PlatformNetworkUploadSource(int r1, byte[] r2, String r3, long r4, long r6) {
        this.type = r1;
        if (r2 != null) goto L5;
        r2 = new byte[0];
    L5:
        this.bytes = r2;
        this.filePath = r3;
        this.byteOffset = r4;
        this.byteCount = r6;
    }
}
