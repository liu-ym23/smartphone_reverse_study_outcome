package pqb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    static {
    }

    public static String a(com.ss.android.lark.log.f r100) {
        if (r100 == null) goto L6;
        StringBuilder r101 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r100, "logConfig");
        r101.append(r100.f431389e + "alog/");
        r101.append(r100.f431387c);
        r101.append('/');
        String r102 = r101.toString();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == true) goto L8;
        r103.mkdirs();
        return r102;
    L8:
        return r102;
    L6:
        return "";
    }
}
