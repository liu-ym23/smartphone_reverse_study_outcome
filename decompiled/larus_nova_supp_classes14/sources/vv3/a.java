package vv3;

import com.larus.music.i;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.c0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final c0 a() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.K0();
        return i.a;
    L6:
        return b.a;
    }
}
