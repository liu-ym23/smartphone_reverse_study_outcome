package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: classes42.dex */
public class ArchiveException extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public ArchiveException(String r100) {
        super(r100);
    }

    public ArchiveException(String r100, Exception r101) {
        super(r100);
        initCause(r101);
    }
}
