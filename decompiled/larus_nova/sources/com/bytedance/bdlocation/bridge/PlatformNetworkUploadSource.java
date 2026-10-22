package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkUploadSource {
    public static final int TYPE_BYTES = 0;
    public static final int TYPE_FILE_PATH = 1;
    public final long byteCount;
    public final long byteOffset;
    public final byte[] bytes;
    public final String filePath;
    public final int type;

    public PlatformNetworkUploadSource(int r100, byte[] r101, String r102, long r103, long r104) {
        this.type = r100;
        if (r101 != null) goto L5;
        r101 = new byte[0];
    L5:
        this.bytes = r101;
        this.filePath = r102;
        this.byteOffset = r103;
        this.byteCount = r104;
    }
}
