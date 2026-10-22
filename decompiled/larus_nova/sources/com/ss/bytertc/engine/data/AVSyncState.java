package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AVSyncState extends Enum<AVSyncState> {
    private static final /* synthetic */ AVSyncState[] $VALUES = null;
    public static final AVSyncState AV_SYNC_STATE_AUDIO_STREAM_REMOVE = null;
    public static final AVSyncState AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID = null;
    public static final AVSyncState AV_SYNC_STATE_STREAM_SYNC_BEGIN = null;
    public static final AVSyncState AV_SYNC_STATE_VIDEO_STREAM_REMOVE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AVSyncState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AVSyncState = null;

        static {
            int[] r100 = new int[AVSyncState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncState = r100;
            r100[AVSyncState.AV_SYNC_STATE_STREAM_SYNC_BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_AUDIO_STREAM_REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_VIDEO_STREAM_REMOVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        AVSyncState r100 = new AVSyncState("AV_SYNC_STATE_STREAM_SYNC_BEGIN", 0, 0);
        AV_SYNC_STATE_STREAM_SYNC_BEGIN = r100;
        AVSyncState r101 = new AVSyncState("AV_SYNC_STATE_AUDIO_STREAM_REMOVE", 1, 1);
        AV_SYNC_STATE_AUDIO_STREAM_REMOVE = r101;
        AVSyncState r102 = new AVSyncState("AV_SYNC_STATE_VIDEO_STREAM_REMOVE", 2, 2);
        AV_SYNC_STATE_VIDEO_STREAM_REMOVE = r102;
        AVSyncState r103 = new AVSyncState("AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID", 3, 3);
        AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID = r103;
        $VALUES = new AVSyncState[]{r100, r101, r102, r103};
    }

    public static AVSyncState[] values() {
        return (AVSyncState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AVSyncState[ordinal()];
        if (r100 != 1) goto L5;
        return "AV_SYNC_STATE_STREAM_SYNC_BEGIN";
    L5:
        if (r100 != 2) goto L7;
        return "AV_SYNC_STATE_AUDIO_STREAM_REMOVE";
    L7:
        if (r100 != 3) goto L9;
        return "AV_SYNC_STATE_VIDEO_STREAM_REMOVE";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID";
    }

    public int value() {
        return this.value;
    }

    public static AVSyncState fromId(int r100) {
        AVSyncState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AVSyncState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AVSyncState valueOf(String r100) {
        return (AVSyncState) a.a(AVSyncState.class, r100);
    }

    private AVSyncState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
