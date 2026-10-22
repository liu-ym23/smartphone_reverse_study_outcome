package com.bytedance.mira.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.SafeUtils;

/* JADX INFO: loaded from: classes21.dex */
public class RedirectService extends Service {

    public static final class CodeConst {
        public static final String EXTRA_TARGET_INTENT = "target_intent";

        public CodeConst() {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    public RedirectService() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 == null) goto L9;
        Intent r103 = (Intent) r100.getParcelableExtra("target_intent");
        if (SafeUtils.checkTargetIntentValid(this, r103, true) == false) goto L9;
        startService(r103);     // Catch: IllegalStateException -> L7
    L7:
        e = move-exception;
        MiraLogger.e(RedirectService.class.getName(), e);
    L9:
        stopSelf();
        return 2;
    }
}
