package xja;

import com.obric.datatransfer.logger.TransferLogger;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TransferLogger f564111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f564112b = null;

    static {
        com.obric.datatransfer.logger.a r100 = TransferLogger.f396682b;
        f564111a = TransferLogger.a.a("DataTransferUtils");
        f564112b = new CopyOnWriteArraySet();
    }

    public static void a(File r100) {
    L5:
        if (f564112b.contains(r100.getCanonicalPath()) == false) goto L8;
        TransferLogger.c(f564111a, "Skip deleting protected directory " + r100);
        return;
    L8:
        TransferLogger r101 = f564111a;
        TransferLogger.c(r101, "Deleting file " + r100);
        if (r100.isDirectory() == false) goto L26;
        TransferLogger.c(r101, "Deleting directory " + r100);
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L26;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L26;
        a(r102[r104]);
        r104 = r104 + 1;
    L26:
        boolean r105 = r100.delete();     // Catch: SecurityException -> L17
        TransferLogger.c(f564111a, "delete " + r100 + " status = " + r105);     // Catch: SecurityException -> L17
        return;
    L17:
        e = move-exception;
        f564111a.b("Error deleting file " + r100, e);
        return;
    L23:
        e = move-exception;
        f564111a.b("Error getting canonical path for " + r100, e);
        return;
    L20:
        e = move-exception;
        f564111a.b("Error getting canonical path for " + r100, e);
    }
}
