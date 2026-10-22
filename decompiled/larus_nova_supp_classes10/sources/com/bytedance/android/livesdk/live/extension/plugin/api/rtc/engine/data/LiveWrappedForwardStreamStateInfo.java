package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveWrappedForwardStreamStateInfo {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedForwardStreamStateInfo$LiveWrappedForwardStreamError;", "", "", "value", "I", "Companion", "a", "FORWARD_STREAM_ERROR_OK", "FORWARD_STREAM_ERROR_INVALID_ARGUMENT", "FORWARD_STREAM_ERROR_INVALID_TOKEN", "FORWARD_STREAM_ERROR_RESPONSE", "FORWARD_STREAM_ERROR_REMOTE_KICKED", "FORWARD_STREAM_ERROR_NOT_SUPPORT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedForwardStreamError extends Enum<LiveWrappedForwardStreamError> {
        public static final a Companion = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_INVALID_ARGUMENT = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_INVALID_TOKEN = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_NOT_SUPPORT = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_OK = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_REMOTE_KICKED = null;
        public static final LiveWrappedForwardStreamError FORWARD_STREAM_ERROR_RESPONSE = null;
        public static final /* synthetic */ LiveWrappedForwardStreamError[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedForwardStreamError r1 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_OK", 0, 0);
            FORWARD_STREAM_ERROR_OK = r1;
            LiveWrappedForwardStreamError r2 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_INVALID_ARGUMENT", 1, 1201);
            FORWARD_STREAM_ERROR_INVALID_ARGUMENT = r2;
            LiveWrappedForwardStreamError r3 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_INVALID_TOKEN", 2, 1202);
            FORWARD_STREAM_ERROR_INVALID_TOKEN = r3;
            LiveWrappedForwardStreamError r4 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_RESPONSE", 3, 1203);
            FORWARD_STREAM_ERROR_RESPONSE = r4;
            LiveWrappedForwardStreamError r5 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_REMOTE_KICKED", 4, 1204);
            FORWARD_STREAM_ERROR_REMOTE_KICKED = r5;
            LiveWrappedForwardStreamError r6 = new LiveWrappedForwardStreamError("FORWARD_STREAM_ERROR_NOT_SUPPORT", 5, 1205);
            FORWARD_STREAM_ERROR_NOT_SUPPORT = r6;
            a = new LiveWrappedForwardStreamError[]{r1, r2, r3, r4, r5, r6};
            Companion = new a();
        }

        public static LiveWrappedForwardStreamError valueOf(String r1) {
            return (LiveWrappedForwardStreamError) r27.a.a(LiveWrappedForwardStreamError.class, r1);
        }

        public static LiveWrappedForwardStreamError[] values() {
            return (LiveWrappedForwardStreamError[]) a.clone();
        }

        public final int value() {
            return this.value;
        }

        public LiveWrappedForwardStreamError(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedForwardStreamStateInfo$LiveWrappedForwardStreamState;", "", "", "value", "I", "Companion", "a", "FORWARD_STREAM_STATE_IDLE", "FORWARD_STREAM_STATE_SUCCESS", "FORWARD_STREAM_STATE_FAILURE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedForwardStreamState extends Enum<LiveWrappedForwardStreamState> {
        public static final a Companion = null;
        public static final LiveWrappedForwardStreamState FORWARD_STREAM_STATE_FAILURE = null;
        public static final LiveWrappedForwardStreamState FORWARD_STREAM_STATE_IDLE = null;
        public static final LiveWrappedForwardStreamState FORWARD_STREAM_STATE_SUCCESS = null;
        public static final /* synthetic */ LiveWrappedForwardStreamState[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedForwardStreamState r1 = new LiveWrappedForwardStreamState("FORWARD_STREAM_STATE_IDLE", 0, 0);
            FORWARD_STREAM_STATE_IDLE = r1;
            LiveWrappedForwardStreamState r2 = new LiveWrappedForwardStreamState("FORWARD_STREAM_STATE_SUCCESS", 1, 1);
            FORWARD_STREAM_STATE_SUCCESS = r2;
            LiveWrappedForwardStreamState r3 = new LiveWrappedForwardStreamState("FORWARD_STREAM_STATE_FAILURE", 2, 2);
            FORWARD_STREAM_STATE_FAILURE = r3;
            a = new LiveWrappedForwardStreamState[]{r1, r2, r3};
            Companion = new a();
        }

        public static LiveWrappedForwardStreamState valueOf(String r1) {
            return (LiveWrappedForwardStreamState) r27.a.a(LiveWrappedForwardStreamState.class, r1);
        }

        public static LiveWrappedForwardStreamState[] values() {
            return (LiveWrappedForwardStreamState[]) a.clone();
        }

        public final int value() {
            return this.value;
        }

        public LiveWrappedForwardStreamState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }
}
