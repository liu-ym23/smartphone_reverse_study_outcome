package org.apache.commons.net.io;

import java.util.EventObject;

/* JADX INFO: loaded from: classes42.dex */
public class CopyStreamEvent extends EventObject {
    public static final long UNKNOWN_STREAM_SIZE = -1;
    private static final long serialVersionUID = -964927635655051867L;
    private final int bytesTransferred;
    private final long streamSize;
    private final long totalBytesTransferred;

    @Override // java.util.EventObject
    public String toString() {
        return getClass().getName() + "[source=" + ((EventObject) this).source + ", total=" + this.totalBytesTransferred + ", bytes=" + this.bytesTransferred + ", size=" + this.streamSize + "]";
    }

    public int getBytesTransferred() {
        return this.bytesTransferred;
    }

    public long getStreamSize() {
        return this.streamSize;
    }

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }

    public CopyStreamEvent(Object r100, long r101, int r102, long r103) {
        super(r100);
        this.bytesTransferred = r102;
        this.totalBytesTransferred = r101;
        this.streamSize = r103;
    }
}
