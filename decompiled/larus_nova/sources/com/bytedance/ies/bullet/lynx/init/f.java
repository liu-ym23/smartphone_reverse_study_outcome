package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f247348a = null;

    static {
        f247348a = new f();
    }

    public f() {
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map<? extends String, ? extends String> getUserData(CrashType r100) {
        HashMap r101 = new HashMap();
        String r102 = LynxEnv.inst().getLastUrl();
        if (r102 != null) goto L5;
        r102 = "no lynx url";
    L5:
        r101.put("last_lynx_url", r102);
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        return r101;
    }
}
