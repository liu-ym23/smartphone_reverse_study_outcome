package r17;

import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f535672a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f535673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f535674c;

    public static float b() {
        BigDecimal r100 = new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        long r101 = f535672a;
        if (r101 != (-1)) goto L6;
        r101 = Runtime.getRuntime().maxMemory();
        f535672a = r101;
    L6:
        float r102 = ((float) r100.divide(new BigDecimal(r101), 4, 4).doubleValue()) * 100.0f;
        c.b("currentRate %f", new Object[]{Float.valueOf(r102)});
        return r102;
    }

    public static void a(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L7;
        return;
    L7:
        if (r100.isDirectory() == false) goto L17;
        File[] r101 = r100.listFiles();
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L17;
        File r104 = r101[r103];
        if (r104.isFile() == false) goto L14;
        r104.delete();
    L16:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r100.isDirectory() == false) goto L16;
        a(r104);
    L17:
        r100.delete();
    }
}
