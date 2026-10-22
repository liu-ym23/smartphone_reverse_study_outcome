package com.bytedance.locallife.groupon.host.halfscreen;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/host/halfscreen/StartState;", "", "", "state", "I", "getState", "()I", "ON_CREATE", "ON_RESUME", FlowDoraWifiScene.OTHER, "ON_PRE_JUMP", "locallife-groupon-host-api_release"}, k = 1, mv = {1, 4, 3})
public final enum StartState extends Enum<StartState> {
    public static final StartState ON_CREATE = null;
    public static final StartState ON_PRE_JUMP = null;
    public static final StartState ON_RESUME = null;
    public static final StartState OTHER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StartState[] f258803a = null;
    private final int state;

    public static StartState valueOf(String r100) {
        return (StartState) a.a(StartState.class, r100);
    }

    public static StartState[] values() {
        return (StartState[]) f258803a.clone();
    }

    static {
        StartState r100 = new StartState("ON_CREATE", 0, 0);
        ON_CREATE = r100;
        StartState r101 = new StartState("ON_RESUME", 1, 1);
        ON_RESUME = r101;
        StartState r102 = new StartState(FlowDoraWifiScene.OTHER, 2, 2);
        OTHER = r102;
        StartState r103 = new StartState("ON_PRE_JUMP", 3, 3);
        ON_PRE_JUMP = r103;
        f258803a = new StartState[]{r100, r101, r102, r103};
    }

    public final int getState() {
        return this.state;
    }

    public StartState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
