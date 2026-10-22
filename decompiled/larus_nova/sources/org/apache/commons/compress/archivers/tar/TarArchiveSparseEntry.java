package org.apache.commons.compress.archivers.tar;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class TarArchiveSparseEntry {
    private final boolean isExtended;

    public boolean isExtended() {
        return this.isExtended;
    }

    public TarArchiveSparseEntry(byte[] r100) throws IOException {
        this.isExtended = TarUtils.parseBoolean(r100, 504);
    }
}
