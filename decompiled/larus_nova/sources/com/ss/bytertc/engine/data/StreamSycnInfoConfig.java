package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class StreamSycnInfoConfig {
    public int repeatCount;
    public StreamIndex streamIndex;
    public SyncInfoStreamType streamType;

    public static final enum SyncInfoStreamType extends Enum<SyncInfoStreamType> {
        private static final /* synthetic */ SyncInfoStreamType[] $VALUES = null;
        public static final SyncInfoStreamType SYNC_INFO_STREAM_TYPE_AUDIO = null;

        static {
            SyncInfoStreamType r100 = new SyncInfoStreamType("SYNC_INFO_STREAM_TYPE_AUDIO", 0);
            SYNC_INFO_STREAM_TYPE_AUDIO = r100;
            $VALUES = new SyncInfoStreamType[]{r100};
        }

        public static SyncInfoStreamType[] values() {
            return (SyncInfoStreamType[]) $VALUES.clone();
        }

        public static SyncInfoStreamType valueOf(String r100) {
            return (SyncInfoStreamType) a.a(SyncInfoStreamType.class, r100);
        }

        private SyncInfoStreamType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "StreamSycnInfoConfig{ streamIndex='" + this.streamIndex.toString() + "'repeatCount='" + this.repeatCount + "'streamType=Audio }";
    }

    public StreamSycnInfoConfig(StreamIndex r100, int r101, SyncInfoStreamType r102) {
        this.streamIndex = r100;
        this.repeatCount = r101;
        this.streamType = r102;
    }
}
