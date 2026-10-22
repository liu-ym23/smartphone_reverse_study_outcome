package com.bytedance.forest.model;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f244336a = null;

    static {
        int[] r100 = new int[ErrorInfo.Type.values().length];
        f244336a = r100;
        r100[ErrorInfo.Type.Memory.ordinal()] = 1;
        r100[ErrorInfo.Type.Gecko.ordinal()] = 2;
        r100[ErrorInfo.Type.Builtin.ordinal()] = 3;
        r100[ErrorInfo.Type.CDN.ordinal()] = 4;
        r100[ErrorInfo.Type.PostProcess.ordinal()] = 5;
        r100[ErrorInfo.Type.CustomFetcher.ordinal()] = 6;
    }
}
