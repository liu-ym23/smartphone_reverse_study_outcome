package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class MemoryLimitException extends IOException {
    private static final long serialVersionUID = 1;
    private final int memoryLimitInKb;
    private final long memoryNeededInKb;

    public int getMemoryLimitInKb() {
        return this.memoryLimitInKb;
    }

    public long getMemoryNeededInKb() {
        return this.memoryNeededInKb;
    }

    public MemoryLimitException(long r100, int r101) {
        super(buildMessage(r100, r101));
        this.memoryNeededInKb = r100;
        this.memoryLimitInKb = r101;
    }

    private static String buildMessage(long r100, int r101) {
        return r100 + " kb of memory would be needed; limit was " + r101 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }

    public MemoryLimitException(long r100, int r101, Exception r102) {
        super(buildMessage(r100, r101), r102);
        this.memoryNeededInKb = r100;
        this.memoryLimitInKb = r101;
    }
}
