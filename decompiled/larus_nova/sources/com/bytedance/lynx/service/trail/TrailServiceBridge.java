package com.bytedance.lynx.service.trail;

import com.lynx.tasm.service.ILynxTrailService;
import i8a.n;

/* JADX INFO: loaded from: classes21.dex */
public class TrailServiceBridge {
    public TrailServiceBridge() {
    }

    public static native void nativeCleanCache();

    public static String getValueByKey(String r100) {
        ILynxTrailService r101 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.stringValueForTrailKey(r100);
    }
}
