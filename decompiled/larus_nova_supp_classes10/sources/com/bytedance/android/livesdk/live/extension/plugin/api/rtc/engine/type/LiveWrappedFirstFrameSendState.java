package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedFirstFrameSendState;", "", "", "value", BaseCoreViewModel.CORE_TAG_STATE, "I", "Companion", "a", "FIRST_FRAME_SEND_STATE_SENDING", "FIRST_FRAME_SEND_STATE_SENT", "FIRST_FRAME_SEND_STAT_END", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedFirstFrameSendState extends Enum<LiveWrappedFirstFrameSendState> {
    public static final a Companion = null;
    public static final LiveWrappedFirstFrameSendState FIRST_FRAME_SEND_STATE_SENDING = null;
    public static final LiveWrappedFirstFrameSendState FIRST_FRAME_SEND_STATE_SENT = null;
    public static final LiveWrappedFirstFrameSendState FIRST_FRAME_SEND_STAT_END = null;
    public static final /* synthetic */ LiveWrappedFirstFrameSendState[] a = null;
    private int state;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedFirstFrameSendState$a] */
    static {
        LiveWrappedFirstFrameSendState r1 = new LiveWrappedFirstFrameSendState("FIRST_FRAME_SEND_STATE_SENDING", 0, 0);
        FIRST_FRAME_SEND_STATE_SENDING = r1;
        LiveWrappedFirstFrameSendState r2 = new LiveWrappedFirstFrameSendState("FIRST_FRAME_SEND_STATE_SENT", 1, 1);
        FIRST_FRAME_SEND_STATE_SENT = r2;
        LiveWrappedFirstFrameSendState r3 = new LiveWrappedFirstFrameSendState("FIRST_FRAME_SEND_STAT_END", 2, 2);
        FIRST_FRAME_SEND_STAT_END = r3;
        a = new LiveWrappedFirstFrameSendState[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedFirstFrameSendState valueOf(String r1) {
        return (LiveWrappedFirstFrameSendState) r27.a.a(LiveWrappedFirstFrameSendState.class, r1);
    }

    public static LiveWrappedFirstFrameSendState[] values() {
        return (LiveWrappedFirstFrameSendState[]) a.clone();
    }

    public final int value() {
        return this.state;
    }

    public LiveWrappedFirstFrameSendState(String r1, int r2, int r3) {
        super(r1, r2);
        this.state = r3;
    }
}
