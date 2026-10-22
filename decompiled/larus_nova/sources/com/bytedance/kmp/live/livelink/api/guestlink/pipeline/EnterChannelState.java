package com.bytedance.kmp.live.livelink.api.guestlink.pipeline;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/guestlink/pipeline/EnterChannelState;", "", "STATE_LEAVE", "STATE_ENTER", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EnterChannelState extends Enum<EnterChannelState> {
    public static final EnterChannelState STATE_ENTER = null;
    public static final EnterChannelState STATE_LEAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterChannelState[] f252200a = null;

    static {
        EnterChannelState r100 = new EnterChannelState("STATE_LEAVE", 0);
        STATE_LEAVE = r100;
        EnterChannelState r101 = new EnterChannelState("STATE_ENTER", 1);
        STATE_ENTER = r101;
        f252200a = new EnterChannelState[]{r100, r101};
    }

    public static EnterChannelState valueOf(String r100) {
        return (EnterChannelState) a.a(EnterChannelState.class, r100);
    }

    public static EnterChannelState[] values() {
        return (EnterChannelState[]) f252200a.clone();
    }

    public EnterChannelState(String r100, int r101) {
        super(r100, r101);
    }
}
