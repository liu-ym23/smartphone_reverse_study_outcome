package com.bytedance.kmp.ec.yata.chain.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/ec/yata/chain/event/EventState;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "SUCCESS", "FAILED", "yata-chain-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum EventState extends Enum<EventState> {
    public static final EventState FAILED = null;
    public static final EventState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventState[] f251280a = null;
    private final String key;

    public static EventState valueOf(String r100) {
        return (EventState) r27.a.a(EventState.class, r100);
    }

    public static EventState[] values() {
        return (EventState[]) f251280a.clone();
    }

    static {
        EventState r100 = new EventState("SUCCESS", 0, "success");
        SUCCESS = r100;
        EventState r101 = new EventState("FAILED", 1, "failed");
        FAILED = r101;
        f251280a = new EventState[]{r100, r101};
    }

    public final String getKey() {
        return this.key;
    }

    public EventState(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
