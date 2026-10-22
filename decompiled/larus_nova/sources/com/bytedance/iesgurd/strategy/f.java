package com.bytedance.iesgurd.strategy;

import android.os.Environment;
import android.os.StatFs;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.iesgurd.meta.PrepareMeta;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f250865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f250866b;

    public static void b() {
        long r100 = System.currentTimeMillis();
        if ((r100 - f250866b) <= 15000) goto L15;
        File r101 = Environment.getDataDirectory();
        if (r101 != null) goto L13;
    L10:
        long r102 = -1;
    L11:
        f250865a = (int) (r102 / ((long) 1048576));
        f250866b = r100;
        return;
    L13:
        StatFs r103 = new StatFs(r101.getPath());     // Catch: IllegalArgumentException -> L8
        r102 = r103.getBlockSizeLong() * r103.getAvailableBlocksLong();
    L8:
        e = move-exception;
        GeckoLogger.w("getAvailableSize error: " + e);
        goto L10
    }

    static {
    }

    public static boolean a(PrepareMeta r100) {
        b();
        if (f250865a >= 30) goto L6;
        return false;
    L6:
        if (r100.getIgnoreStorage() == false) goto L8;
        return true;
    L8:
        String r101 = r100.getAccessKey();
        String r102 = r100.getChannel();
        List<String> r103 = r100.getGroups();
        boolean r104 = com.bytedance.iesgurd.utils.a.b(r101, r102);
        if (r100.getUpdateWithPatch() == false) goto L12;
        if (r104 == false) goto L12;
        return true;
    L12:
        Pair<Integer, Integer> r105 = com.bytedance.iesgurd.core.f.f250668i.b();
        int r106 = r105.getFirst().intValue();
        int r107 = r105.getSecond().intValue();
        if (r106 > 0) goto L15;
    L22:
        if (r107 > 0) goto L24;
    L31:
        return true;
    L24:
        if (f250865a >= r107) goto L31;
        Resources r108 = (Resources) ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.f250662c).get(r101);
        if (r108 != null) goto L28;
    L29:
        return true;
    L28:
        if (r108.isHit$geckox_noasanRelease(r103, r102) != true) goto L29;
        return false;
    L15:
        if (f250865a >= r106) goto L22;
        Resources r109 = (Resources) ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.f250661b).get(r101);
        if (r109 != null) goto L19;
        return false;
    L19:
        if (r109.isHit$geckox_noasanRelease(r103, r102) != true) goto L33;
        return true;
    L33:
        return false;
    }
}
