package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StreamRemoveReason extends Enum<StreamRemoveReason> {
    private static final /* synthetic */ StreamRemoveReason[] $VALUES = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_CLIENT_DISCONNECTED = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_KEEP_LIVE_FAILED = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_OTHER = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_PUBLISH_FAILED = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_REPUBLISH = null;
    public static final StreamRemoveReason STREAM_REMOVE_REASON_UNPUBLISH = null;
    private final int value;

    static {
        StreamRemoveReason r100 = new StreamRemoveReason("STREAM_REMOVE_REASON_UNPUBLISH", 0, 0);
        STREAM_REMOVE_REASON_UNPUBLISH = r100;
        StreamRemoveReason r101 = new StreamRemoveReason("STREAM_REMOVE_REASON_PUBLISH_FAILED", 1, 1);
        STREAM_REMOVE_REASON_PUBLISH_FAILED = r101;
        StreamRemoveReason r102 = new StreamRemoveReason("STREAM_REMOVE_REASON_KEEP_LIVE_FAILED", 2, 2);
        STREAM_REMOVE_REASON_KEEP_LIVE_FAILED = r102;
        StreamRemoveReason r103 = new StreamRemoveReason("STREAM_REMOVE_REASON_CLIENT_DISCONNECTED", 3, 3);
        STREAM_REMOVE_REASON_CLIENT_DISCONNECTED = r103;
        StreamRemoveReason r104 = new StreamRemoveReason("STREAM_REMOVE_REASON_REPUBLISH", 4, 4);
        STREAM_REMOVE_REASON_REPUBLISH = r104;
        StreamRemoveReason r105 = new StreamRemoveReason("STREAM_REMOVE_REASON_OTHER", 5, 5);
        STREAM_REMOVE_REASON_OTHER = r105;
        StreamRemoveReason r110 = new StreamRemoveReason("STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED", 6, 6);
        STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED = r110;
        $VALUES = new StreamRemoveReason[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static StreamRemoveReason[] values() {
        return (StreamRemoveReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static StreamRemoveReason fromId(int r100) {
        StreamRemoveReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        StreamRemoveReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return STREAM_REMOVE_REASON_UNPUBLISH;
    }

    public static StreamRemoveReason valueOf(String r100) {
        return (StreamRemoveReason) a.a(StreamRemoveReason.class, r100);
    }

    private StreamRemoveReason(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private StreamRemoveReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
