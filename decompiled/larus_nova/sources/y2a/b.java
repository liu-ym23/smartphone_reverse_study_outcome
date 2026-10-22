package y2a;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.utils.o0;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static final String b(boolean r100) {
        if (r100 == false) goto L4;
        return BdpAppEventConstant.TRUE;
    L4:
        return BdpAppEventConstant.FALSE;
    }

    public static final String a(String r100) {
        if (o0.d(r100) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L9;
        return "unknown";
    L9:
        return r100;
    }
}
