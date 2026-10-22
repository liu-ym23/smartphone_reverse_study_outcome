package com.volcengine.zeus.oat;

import android.os.Build;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements f.b {
    public e() {
    }

    @Override // com.volcengine.zeus.oat.f.b
    public final boolean a(String r110, int r111) {
        String r100 = dqc.c.h(r110, r111, false);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:" + r100);
        String r112 = dqc.c.c(r110, r111);
        StringBuilder r113 = new StringBuilder();
        r113.append(r112);
        String r101 = File.separator;
        r113.append(r101);
        r113.append("compFully");
        String r102 = r100.substring(r100.lastIndexOf("."));
        int r103 = Build.VERSION.SDK_INT;
        String r104 = Dex2OatHelper.ODEX_SUFFIX;
        if (r103 < 26) goto L5;
        String r105 = Dex2OatHelper.ODEX_SUFFIX;
    L7:
        if (Dex2OatHelper.DEX_SUFFIX.equals(r102) == false) goto L10;
    L16:
        r113.append(r102);
        String r114 = r113.toString();
        String r115 = r112 + r101 + d.d(r100);
        boolean r106 = b.b(d.c(r100, r114, 2));     // Catch: Exception -> L19
    L20:
        if (r106 == false) goto L33;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r114);
        if (r107.exists() == false) goto L25;
        r107.renameTo(new PolarisFileWrapper(r115));
    L25:
        if (Build.VERSION.SDK_INT >= 26) goto L28;
        r104 = Dex2OatHelper.DEX_SUFFIX;
    L28:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r114.replace(r104, Dex2OatHelper.VDEX_SUFFIX));
        if (r108.exists() == false) goto L31;
        r108.renameTo(new PolarisFileWrapper(r115.replace(r104, Dex2OatHelper.VDEX_SUFFIX)));
    L31:
        boolean r116 = d.e(new String[]{r115});
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:" + r116);
        return r116;
    L33:
        return false;
    L19:
        r106 = false;
        goto L20
    L10:
        if (".zip".equals(r102) == false) goto L12;
    L15:
        r102 = r105;
        goto L16
    L12:
        if (".apk".equals(r102) == true) goto L15;
        r102 = r100.concat(r105);
        goto L16
    L5:
        r105 = Dex2OatHelper.DEX_SUFFIX;
        goto L7
    }
}
