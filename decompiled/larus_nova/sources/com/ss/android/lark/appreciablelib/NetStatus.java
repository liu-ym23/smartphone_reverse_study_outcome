package com.ss.android.lark.appreciablelib;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/appreciablelib/NetStatus;", "", "", "value", "I", "getValue", "()I", "EXCELLENT", "EVALUATING", "WEAK", "NET_UNAVAILABLE", "SERVICE_UNAVAILABLE", "OFFLINE", "appreciablelib_release"}, k = 1, mv = {1, 4, 0})
public final enum NetStatus extends Enum<NetStatus> {
    public static final NetStatus EVALUATING = null;
    public static final NetStatus EXCELLENT = null;
    public static final NetStatus NET_UNAVAILABLE = null;
    public static final NetStatus OFFLINE = null;
    public static final NetStatus SERVICE_UNAVAILABLE = null;
    public static final NetStatus WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetStatus[] f408929a = null;
    private final int value;

    static {
        NetStatus r100 = new NetStatus("EXCELLENT", 0, 1);
        EXCELLENT = r100;
        NetStatus r101 = new NetStatus("EVALUATING", 1, 2);
        EVALUATING = r101;
        NetStatus r102 = new NetStatus("WEAK", 2, 3);
        WEAK = r102;
        NetStatus r103 = new NetStatus("NET_UNAVAILABLE", 3, 4);
        NET_UNAVAILABLE = r103;
        NetStatus r104 = new NetStatus("SERVICE_UNAVAILABLE", 4, 5);
        SERVICE_UNAVAILABLE = r104;
        NetStatus r105 = new NetStatus("OFFLINE", 5, 6);
        OFFLINE = r105;
        f408929a = new NetStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static NetStatus valueOf(String r100) {
        return (NetStatus) a.a(NetStatus.class, r100);
    }

    public static NetStatus[] values() {
        return (NetStatus[]) f408929a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NetStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
