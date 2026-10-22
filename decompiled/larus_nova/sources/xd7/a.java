package xd7;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    static {
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, int r105) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "level");
        Intrinsics.checkNotNullParameter(r103, "file");
        Intrinsics.checkNotNullParameter(r104, "function");
        StringBuilder r106 = new StringBuilder(r100.length() + 100);
        r106.append("[");
        r106.append(r103);
        r106.append(", ");
        r106.append(r104);
        r106.append(", ");
        r106.append(r105);
        r106.append("]");
        r106.append(r100);
        String r107 = r106.toString();
        String r108 = "web_" + r101;
        switch(r102.hashCode()) {
            case 3237038: goto L21;
            case 3641990: goto L18;
            case 95458899: goto L15;
            case 96784904: goto L12;
            case 351107458: goto L6;
            default: goto L25;
        };
    L6:
        if (r102.equals("verbose") == false) goto L25;
        UGLogger.c r109 = UGLogger.f270252a;
        Intrinsics.checkNotNullParameter(r108, "tag");
        Intrinsics.checkNotNullParameter(r107, "msg");
        HybridLogger r110 = HybridLogger.f246343a;
        if (HybridLogger.c(r108, r107, LogLevel.V) == true) goto L30;
        ALog.v(r108, r107);
        return;
    L30:
        return;
    L12:
        if (r102.equals("error") == false) goto L25;
        UGLogger.f270252a.b(r108, r107);
        return;
    L15:
        if (r102.equals("debug") == false) goto L25;
        UGLogger.f270252a.a(r108, r107);
        return;
    L18:
        if (r102.equals("warn") == false) goto L25;
        UGLogger.f270252a.d(r108, r107);
        return;
    L21:
        if (r102.equals("info") == false) goto L25;
        UGLogger.f270252a.c(r108, r107);
        return;
    L25:
        throw new IllegalArgumentException("Illegal level!");
    }
}
