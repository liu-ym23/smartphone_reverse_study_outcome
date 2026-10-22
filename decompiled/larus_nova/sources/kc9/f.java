package kc9;

import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.q4;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes29.dex */
public final class f {
    static {
    }

    public static q4 a() {
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L7;
        q4 r101 = r100.z0();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new q4(false, false, false);
    }
}
