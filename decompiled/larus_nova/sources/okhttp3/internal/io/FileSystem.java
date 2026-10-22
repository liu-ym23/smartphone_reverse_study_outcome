package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes42.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = null;

    public static class a implements FileSystem {
        public a() {
        }

        @Override // okhttp3.internal.io.FileSystem
        public final Sink appendingSink(File r100) throws FileNotFoundException {
            return Okio.appendingSink(r100);
        L4:
            r100.getParentFile().mkdirs();
            return Okio.appendingSink(r100);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(File r100) throws IOException {
            if (r100.delete() == false) goto L5;
            return;
        L5:
            if (r100.exists() == true) goto L8;
            return;
        L8:
            throw new IOException("failed to delete " + r100);
        }

        @Override // okhttp3.internal.io.FileSystem
        public final void deleteContents(File r100) throws IOException {
            File[] r101 = r100.listFiles();
            if (r101 == null) goto L16;
            int r102 = r101.length;
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L14;
            File r104 = r101[r103];
            if (r104.isDirectory() == false) goto L10;
            deleteContents(r104);
        L10:
            if (r104.delete() == false) goto L13;
            r103 = r103 + 1;
            goto L5
        L13:
            throw new IOException("failed to delete " + r104);
        L14:
            return;
        L16:
            throw new IOException("not a readable directory: " + r100);
        }

        @Override // okhttp3.internal.io.FileSystem
        public final boolean exists(File r100) {
            return r100.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public final Sink sink(File r100) throws FileNotFoundException {
            return Okio.sink(r100);
        L4:
            r100.getParentFile().mkdirs();
            return Okio.sink(r100);
        }

        @Override // okhttp3.internal.io.FileSystem
        public final long size(File r100) {
            return r100.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public final Source source(File r100) throws FileNotFoundException {
            return Okio.source(r100);
        }

        @Override // okhttp3.internal.io.FileSystem
        public final void rename(File r100, File r101) throws IOException {
            delete(r101);
            if (r100.renameTo(r101) == false) goto L6;
            return;
        L6:
            throw new IOException("failed to rename " + r100 + " to " + r101);
        }
    }

    Sink appendingSink(File r100) throws FileNotFoundException;

    void delete(File r100) throws IOException;

    void deleteContents(File r100) throws IOException;

    boolean exists(File r100);

    void rename(File r100, File r101) throws IOException;

    Sink sink(File r100) throws FileNotFoundException;

    long size(File r100);

    Source source(File r100) throws FileNotFoundException;

    static {
        SYSTEM = new a();
    }
}
