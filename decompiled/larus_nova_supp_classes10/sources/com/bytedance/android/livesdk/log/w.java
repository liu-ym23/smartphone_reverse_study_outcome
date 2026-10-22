package com.bytedance.android.livesdk.log;

import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.config.h70;
import com.bytedance.android.livesdkapi.model.LiveLogFlushConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w {
    public static final void a(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        LiveLogFlushConfig r0 = (LiveLogFlushConfig) h70.a.getValue();
        if (r2 != 1) goto L7;
        boolean r3 = r0.mEnableDrawExitRoom;
    L11:
        if (r3 == false) goto L14;
        jc1.k.n(IHostLog.class).flush();
        return;
    L14:
        return;
    L7:
        if (r2 == 2) goto L9;
        r3 = false;
        goto L11
    L9:
        r3 = r0.mEnableDrawDurationOnemin;
        goto L11
    }
}
