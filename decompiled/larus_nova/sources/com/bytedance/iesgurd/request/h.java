package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.core.ReqType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f250831a = null;

    static {
        int[] r100 = new int[ReqType.values().length];
        f250831a = r100;
        r100[ReqType.QUEUE.ordinal()] = 1;
        r100[ReqType.REGISTER_LATE.ordinal()] = 2;
        r100[ReqType.PROBE.ordinal()] = 3;
        r100[ReqType.POLLING.ordinal()] = 4;
    }
}
