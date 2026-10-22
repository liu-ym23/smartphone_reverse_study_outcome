package w48;

import android.content.Context;
import com.bytedance.bdinstall.x0;
import com.larus.common.mssdk.api.SecurityService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements x0 {
    public h() {
    }

    @Override // com.bytedance.bdinstall.x0
    public final String getChannel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 == null) goto L5;
        String r102 = r101.i();
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
