package com.facebook.common.file;

import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtils {

    /* JADX INFO: loaded from: classes22.dex */
    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String r100) {
            super(r100);
        }

        public CreateDirectoryException(String r100, Throwable r101) {
            super(r100);
            initCause(r101);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class FileDeleteException extends IOException {
        public FileDeleteException(String r100) {
            super(r100);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String r100) {
            super(r100);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class RenameException extends IOException {
        public RenameException(String r100) {
            super(r100);
        }

        public RenameException(String r100, Throwable r101) {
            super(r100);
            initCause(r101);
        }
    }

    public FileUtils() {
    }

    public static void mkdirs(File r100) throws CreateDirectoryException {
        if (r100.exists() == false) goto L13;
        if (r100.isDirectory() == false) goto L8;
        return;
    L8:
        if (r100.delete() == true) goto L13;
        throw new CreateDirectoryException(r100.getAbsolutePath(), new FileDeleteException(r100.getAbsolutePath()));
    L13:
        if (r100.mkdirs() == false) goto L15;
        return;
    L15:
        if (r100.isDirectory() == false) goto L18;
        return;
    L18:
        throw new CreateDirectoryException(r100.getAbsolutePath());
    }

    public static void rename(File r100, File r101) throws RenameException {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        r101.delete();
        if (r100.renameTo(r101) == false) goto L6;
        return;
    L6:
        if (r101.exists() == false) goto L8;
        Throwable r102 = new FileDeleteException(r101.getAbsolutePath());
    L16:
        throw new RenameException("Unknown error renaming " + r100.getAbsolutePath() + " to " + r101.getAbsolutePath(), r102);
    L8:
        if (r100.getParentFile().exists() == true) goto L10;
        r102 = new ParentDirNotFoundException(r100.getAbsolutePath());
        goto L16
    L10:
        if (r100.exists() == true) goto L12;
        r102 = new FileNotFoundException(r100.getAbsolutePath());
        goto L16
    L12:
        r102 = null;
        goto L16
    }
}
