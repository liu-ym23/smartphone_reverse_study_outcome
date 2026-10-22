package com.bytedance.crash;

import com.bytedance.crash.util.ListMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppDataCenter extends ListMap<CrashType, AttachUserData> {
    public AppDataCenter() {
    }

    public List<AttachUserData> getAttachUserData(CrashType r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f203291c.d(r100);
    }
}
