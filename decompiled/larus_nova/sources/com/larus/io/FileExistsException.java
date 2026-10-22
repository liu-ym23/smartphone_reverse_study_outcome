package com.larus.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes30.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File r100) {
        super("File " + r100 + " exists");
    }

    public FileExistsException(String r100) {
        super(r100);
    }
}
