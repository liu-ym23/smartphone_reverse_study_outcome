package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveWrappedStreamSycnInfoConfig {
    public final LiveWrappedStreamIndex a;
    public final int b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamSycnInfoConfig$LiveWrappedSyncInfoStreamType;", "", "SYNC_INFO_STREAM_TYPE_AUDIO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedSyncInfoStreamType extends Enum<LiveWrappedSyncInfoStreamType> {
        public static final LiveWrappedSyncInfoStreamType SYNC_INFO_STREAM_TYPE_AUDIO = null;
        public static final /* synthetic */ LiveWrappedSyncInfoStreamType[] a = null;

        static {
            LiveWrappedSyncInfoStreamType r1 = new LiveWrappedSyncInfoStreamType();
            SYNC_INFO_STREAM_TYPE_AUDIO = r1;
            a = new LiveWrappedSyncInfoStreamType[]{r1};
        }

        public static LiveWrappedSyncInfoStreamType valueOf(String r1) {
            return (LiveWrappedSyncInfoStreamType) a.a(LiveWrappedSyncInfoStreamType.class, r1);
        }

        public static LiveWrappedSyncInfoStreamType[] values() {
            return (LiveWrappedSyncInfoStreamType[]) a.clone();
        }

        public LiveWrappedSyncInfoStreamType() {
            super("SYNC_INFO_STREAM_TYPE_AUDIO", 0);
        }
    }

    public final String toString() {
        return "StreamSycnInfoConfig{ streamIndex='" + this.a.toString() + "'repeatCount='" + this.b + "'streamType=Audio }";
    }

    public LiveWrappedStreamSycnInfoConfig(LiveWrappedStreamIndex r2, LiveWrappedSyncInfoStreamType r3) {
        Intrinsics.checkNotNullParameter(r2, "streamIndex");
        Intrinsics.checkNotNullParameter(r3, "streamType");
        this.a = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        LiveWrappedSyncInfoStreamType r4 = LiveWrappedSyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO;
        this.a = r2;
        this.b = 0;
    }
}
