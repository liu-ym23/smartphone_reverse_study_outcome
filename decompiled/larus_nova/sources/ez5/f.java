package ez5;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static List a(PolarisFileWrapper r100) {
        File[] r101 = r100.listFiles(new e());
        if (r101 != null) goto L5;
    L12:
        return null;
    L5:
        if (r101.length == 0) goto L12;
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L19;
        r102.add(Long.valueOf(CastLongProtector.valueOf(r101[r104].getName()).longValue()));     // Catch: Exception -> L14
    L11:
        r104 = r104 + 1;
        goto L8
    L19:
        return r102;
    }

    public static Long b(PolarisFileWrapper r100) {
        String[] r101 = r100.getAbsolutePath().split(HTTP.URL_DEFAULT);
        String r102 = r101[r101.length - 2];
        String r103 = r101[r101.length - 1];
        return c(r100);
    }

    public static Long c(PolarisFileWrapper r100) {
        String[] r101 = r100.getAbsolutePath().split(HTTP.URL_DEFAULT);
        if (r101.length >= 2) goto L5;
        return null;
    L5:
        String r102 = r101[r101.length - 2];
        String r103 = r101[r101.length - 1];
        ChannelMeta r104 = com.bytedance.iesgurd.meta.a.c(r102, r103);
        if (r104 != null) goto L8;
        return null;
    L8:
        return com.bytedance.iesgurd.meta.a.a(r102, r103, r104, "channelDir: " + r100.getAbsolutePath());
    }
}
