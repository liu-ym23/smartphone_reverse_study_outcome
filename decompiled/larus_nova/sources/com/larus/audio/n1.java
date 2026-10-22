package com.larus.audio;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICoreLogCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 implements SAMICoreLogCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f289771a = null;

    static {
        f289771a = new n1();
    }

    public n1() {
    }

    @Override // com.mammon.audiosdk.SAMICoreLogCallback
    public final void onHandle(int r100, String r101) {
        FLogger.f375446a.i("SAMIReport", g2a.d.c("type: " + r100 + ", msg: " + r101));
    }
}
