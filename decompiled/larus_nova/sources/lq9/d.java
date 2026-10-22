package lq9;

import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final String a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L6;
        r100.d();
        String r101 = com.larus.home.impl.sdk.h.f346181a.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "mcRPQyXTQo";
    }
}
