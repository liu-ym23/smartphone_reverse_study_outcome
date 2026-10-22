package com.bytedance.frameworks.baselib.network.asynctask;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum NetworkAsyncTaskType extends Enum<NetworkAsyncTaskType> {
    public static final NetworkAsyncTaskType NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkAsyncTaskType[] f244635a = null;

    static {
        NetworkAsyncTaskType r100 = new NetworkAsyncTaskType();
        NETWORK = r100;
        f244635a = new NetworkAsyncTaskType[]{r100};
    }

    public NetworkAsyncTaskType() {
        super("NETWORK", 0);
    }

    public static NetworkAsyncTaskType[] values() {
        return (NetworkAsyncTaskType[]) f244635a.clone();
    }

    public static NetworkAsyncTaskType valueOf(String r100) {
        return (NetworkAsyncTaskType) a.a(NetworkAsyncTaskType.class, r100);
    }
}
