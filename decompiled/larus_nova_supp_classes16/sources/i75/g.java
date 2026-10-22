package i75;

import com.bytedance.ee.bear.contract.r0;
import com.bytedance.ee.bear.middleground.drive.export.NetworkLevel;
import com.bytedance.ttnet.TTNetInit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final boolean a() {
        int r0 = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().p().getValue();
        int r1 = TTNetInit.getEffectiveConnectionType();
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L5;
    L15:
        tt5.a.h("DriveComponent", "isUnUsableNetState() true, because netLevel=" + r0 + ", ttNetType=" + r1);
        return true;
    L5:
        if (r0 == NetworkLevel.UNKNOWN.getValue()) goto L15;
        if (r0 == NetworkLevel.NET_UNAVAILABLE.getValue()) goto L15;
        if (r0 == NetworkLevel.SERVICE_UNAVAILABLE.getValue()) goto L15;
        if (r0 == NetworkLevel.OFFLINE.getValue()) goto L15;
        if (r1 <= 1) goto L15;
        return false;
    }

    @JvmStatic
    public static final boolean b() {
        int r0 = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().p().getValue();
        int r1 = TTNetInit.getEffectiveConnectionType();
        if (r0 == NetworkLevel.WEAK.getValue()) goto L11;
        r0.b.a.getClass();
        if (r1 > 4) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        return false;
    L7:
        r2 = false;
    L11:
        tt5.a.h("DriveComponent", "isWeakNetState() true, because netLevel=" + r0 + ", ttNetType=" + r1);
        return true;
    }
}
