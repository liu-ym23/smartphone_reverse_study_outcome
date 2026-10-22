package s17;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f540156a;

    public b() {
    }

    public static void a(File r100) {
        int r101 = 0;
        if (r100.isFile() == false) goto L12;
        r17.c.b("lastModified %d now %d", new Object[]{Long.valueOf(r100.lastModified()), Long.valueOf(System.currentTimeMillis())});
        if ((System.currentTimeMillis() - r100.lastModified()) <= 604800000) goto L7;
        r101 = 1;
    L7:
        if (r101 == 0) goto L9;
    L10:
        r100.delete();
        return;
    L9:
        if (r100.length() == 0) goto L10;
        return;
    L12:
        if (r100.isDirectory() == false) goto L23;
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.length <= 0) goto L25;
        int r103 = r102.length;
    L18:
        if (r101 >= r103) goto L26;
        a(r102[r101]);
        r101 = r101 + 1;
        goto L18
    L26:
        return;
    L25:
        return;
    }
}
