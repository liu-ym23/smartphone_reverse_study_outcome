package org.apache.commons.compress.archivers.dump;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DumpArchiveException extends IOException {
    private static final long serialVersionUID = 1;

    public DumpArchiveException() {
    }

    public DumpArchiveException(Throwable r100) {
        initCause(r100);
    }

    public DumpArchiveException(String r100) {
        super(r100);
    }

    public DumpArchiveException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
