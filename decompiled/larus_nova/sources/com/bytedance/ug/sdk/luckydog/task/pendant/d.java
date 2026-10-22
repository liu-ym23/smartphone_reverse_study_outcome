package com.bytedance.ug.sdk.luckydog.task.pendant;

import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantState;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272221a = null;

    static {
        int[] r100 = new int[PendantState.values().length];
        f272221a = r100;
        r100[PendantState.NEED_LOGIN.ordinal()] = 1;
        r100[PendantState.COUNT_DOWN.ordinal()] = 2;
        r100[PendantState.FINISHED.ordinal()] = 3;
    }
}
