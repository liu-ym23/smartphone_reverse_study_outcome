package com.bytedance.push.interfaze;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum IPushService$PushType extends Enum<IPushService$PushType> {
    public static final IPushService$PushType OPPO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPushService$PushType[] f266882a = null;
    private final int type;

    static {
        IPushService$PushType r100 = new IPushService$PushType();
        OPPO = r100;
        f266882a = new IPushService$PushType[]{r100};
    }

    public IPushService$PushType() {
        super("OPPO", 0);
        this.type = 10;
    }

    public static IPushService$PushType[] values() {
        return (IPushService$PushType[]) f266882a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static IPushService$PushType valueOf(String r100) {
        return (IPushService$PushType) a.a(IPushService$PushType.class, r100);
    }
}
