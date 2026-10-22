package ot3;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements FileFilter {
    public c() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r110) {
        boolean r100 = true;
        String r101 = r110.getName();     // Catch: Throwable -> L14
        int r102 = r101.lastIndexOf(".bin");     // Catch: Throwable -> L14
        if (r102 == (-1)) goto L15;
        String r103 = r101.substring(0, r102);     // Catch: Throwable -> L14
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L14
        long r105 = CastLongProtector.parseLong(r103);     // Catch: Throwable -> L14
        long r106 = 0;
        if (r105 < 0) goto L11;
        r106 = r105 >> 16;
    L11:
        if ((r104 - r106) >= 604800000) goto L15;
        r100 = false;
    L15:
        if (r100 == true) goto L17;
    L20:
        return false;
    L17:
        if (xu3.a.a() == false) goto L19;
        List<String> r107 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "deleteExpireHeader:" + r110.getName());
    L19:
        xu3.b.a(r110);
        goto L20
    }
}
