package com.google.archivepatcher.applier;

import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class PatchFormatException extends IOException {
    public PatchFormatException(String r100) {
        super(r100);
    }

    public PatchFormatException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
