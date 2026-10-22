package com.larus.im.internal.tracking.network;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f350432a = null;

    static {
        int[] r100 = new int[NetworkTrackColdStartStep.values().length];
        r100[NetworkTrackColdStartStep.MAIN_CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[NetworkTrackColdStartStep.CMD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[NetworkTrackColdStartStep.RECENT_CONVERSATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f350432a = r100;
    }
}
