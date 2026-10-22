package com.larus.init.task.imsdk;

import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f351393a = null;

    static {
        int[] r100 = new int[ConnectionState.values().length];
        r100[ConnectionState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r100[ConnectionState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r100[ConnectionState.CONNECT_CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r100[ConnectionState.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f351393a = r100;
    }
}
