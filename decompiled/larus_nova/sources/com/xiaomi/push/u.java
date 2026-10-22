package com.xiaomi.push;

import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f464368a = null;

    static {
        HashMap<String, String> r100 = new HashMap();
        f464368a = r100;
        r100.put("FFD8FF", "jpg");
        r100.put("89504E47", LoadParams.ImageFormat.PNG);
        r100.put("47494638", "gif");
        r100.put("474946", "gif");
        r100.put("424D", "bmp");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9432a(File r100) {
        if (r100 != null) goto L19;
        return false;
    L19:
    L16:
        e = move-exception;
        e.getMessage();
        return false;
    L6:
        if (r100.exists() == true) goto L8;
        return true;
    L8:
        if (r100.isDirectory() == false) goto L10;
        long r101 = a(r100);     // Catch: Exception -> L16
    L12:
        if (r101 >= j0.G2_OTA_SPACE_CHECK_BYTES) goto L20;
        return true;
    L20:
        return false;
    L10:
        r101 = r100.length();     // Catch: Exception -> L16
        goto L12
    }

    public static long a(File r100) {
        long r101 = 0;
        File[] r102 = r100.listFiles();     // Catch: Exception -> L11
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L13;
        if (r102[r103].isDirectory() == false) goto L9;
        long r104 = a(r102[r103]);     // Catch: Exception -> L11
    L10:
        r101 = r101 + r104;
        r103 = r103 + 1;
        goto L4
    L9:
        r104 = r102[r103].length();     // Catch: Exception -> L11
    L13:
        return r101;
    L11:
        e = move-exception;
        e.getMessage();
        goto L13
    }
}
