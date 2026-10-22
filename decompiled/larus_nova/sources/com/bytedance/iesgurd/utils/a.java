package com.bytedance.iesgurd.utils;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<String>> f250878a = null;

    static {
        f250878a = new ConcurrentHashMap();
    }

    public static boolean a(String r100, String r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) f250878a;
        if (r102.isEmpty() == false) goto L5;
        return false;
    L5:
        List r103 = (List) r102.get(r100);
        List r104 = r103;
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        return false;
    L15:
        return r103.contains(r101);
    L8:
        if (r104.isEmpty() == true) goto L11;
        r105 = false;
        goto L12
    }

    public static boolean b(String r100, String r101) {
        if (a(r100, r101) == false) goto L5;
        return true;
    L5:
        AtomicBoolean r102 = GlobalManager.f250632a;
        String r103 = GlobalManager.b(r100);
        if (r103 != null) goto L8;
        return false;
    L8:
        if (AppSettingsManager.b.f245071a.a() == false) goto L14;
        ChannelMeta r104 = com.bytedance.iesgurd.meta.a.c(r100, r101);
        if (r104 == null) goto L14;
        Long r105 = r104.getAccessTime();
        if (r105 == null) goto L14;
        r105.longValue();
        return true;
    L14:
        StringBuilder r106 = new StringBuilder();
        r106.append(r100);
        String r107 = File.separator;
        r106.append(r107);
        r106.append(r101);
        r106.append(r107);
        r106.append(".consumed");
        return new PolarisFileWrapper(r103, r106.toString()).exists();
    }

    public static void c(String r100, String r101) {
        AtomicBoolean r102 = GlobalManager.f250632a;
        String r103 = GlobalManager.b(r100);
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return;
    L11:
        StringBuilder r105 = new StringBuilder();
        r105.append(r100);
        String r106 = File.separator;
        r105.append(r106);
        r105.append(r101);
        r105.append(r106);
        r105.append(".consumed");
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103, r105.toString());
        if (r107.exists() == false) goto L19;
        return;
    L19:
        r107.createNewFile();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        GeckoLogger.w("set channel consumed failed", e);
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
