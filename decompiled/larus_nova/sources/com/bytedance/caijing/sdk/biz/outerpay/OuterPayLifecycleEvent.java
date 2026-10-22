package com.bytedance.caijing.sdk.biz.outerpay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/outerpay/OuterPayLifecycleEvent;", "", "ACTIVITY_FINISH", "ON_BACK_PRESSED", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_CONFIGURATION_CHANGED", "cjpay-outer-api_release"}, k = 1, mv = {1, 6, 0})
public final enum OuterPayLifecycleEvent extends Enum<OuterPayLifecycleEvent> {
    public static final OuterPayLifecycleEvent ACTIVITY_FINISH = null;
    public static final OuterPayLifecycleEvent ON_BACK_PRESSED = null;
    public static final OuterPayLifecycleEvent ON_CONFIGURATION_CHANGED = null;
    public static final OuterPayLifecycleEvent ON_CREATE = null;
    public static final OuterPayLifecycleEvent ON_DESTROY = null;
    public static final OuterPayLifecycleEvent ON_PAUSE = null;
    public static final OuterPayLifecycleEvent ON_RESUME = null;
    public static final OuterPayLifecycleEvent ON_START = null;
    public static final OuterPayLifecycleEvent ON_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OuterPayLifecycleEvent[] f202201a = null;

    public static OuterPayLifecycleEvent valueOf(String r100) {
        return (OuterPayLifecycleEvent) a.a(OuterPayLifecycleEvent.class, r100);
    }

    public static OuterPayLifecycleEvent[] values() {
        return (OuterPayLifecycleEvent[]) f202201a.clone();
    }

    static {
        OuterPayLifecycleEvent r100 = new OuterPayLifecycleEvent("ACTIVITY_FINISH", 0);
        ACTIVITY_FINISH = r100;
        OuterPayLifecycleEvent r101 = new OuterPayLifecycleEvent("ON_BACK_PRESSED", 1);
        ON_BACK_PRESSED = r101;
        OuterPayLifecycleEvent r102 = new OuterPayLifecycleEvent("ON_CREATE", 2);
        ON_CREATE = r102;
        OuterPayLifecycleEvent r103 = new OuterPayLifecycleEvent("ON_START", 3);
        ON_START = r103;
        OuterPayLifecycleEvent r104 = new OuterPayLifecycleEvent("ON_RESUME", 4);
        ON_RESUME = r104;
        OuterPayLifecycleEvent r105 = new OuterPayLifecycleEvent("ON_PAUSE", 5);
        ON_PAUSE = r105;
        OuterPayLifecycleEvent r110 = new OuterPayLifecycleEvent("ON_STOP", 6);
        ON_STOP = r110;
        OuterPayLifecycleEvent r111 = new OuterPayLifecycleEvent("ON_DESTROY", 7);
        ON_DESTROY = r111;
        OuterPayLifecycleEvent r112 = new OuterPayLifecycleEvent("ON_CONFIGURATION_CHANGED", 8);
        ON_CONFIGURATION_CHANGED = r112;
        f202201a = new OuterPayLifecycleEvent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public OuterPayLifecycleEvent(String r100, int r101) {
        super(r100, r101);
    }
}
