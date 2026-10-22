package com.ss.bytertc.ktv.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LyricStatus extends Enum<LyricStatus> {
    private static final /* synthetic */ LyricStatus[] $VALUES = null;
    public static final LyricStatus KRC = null;
    public static final LyricStatus KRC_AND_LRC = null;
    public static final LyricStatus LRC = null;
    public static final LyricStatus NONE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.LyricStatus$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus = null;

        static {
            int[] r100 = new int[LyricStatus.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus = r100;
            r100[LyricStatus.KRC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.LRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.KRC_AND_LRC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[LyricStatus.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        LyricStatus r100 = new LyricStatus(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        LyricStatus r101 = new LyricStatus("KRC", 1, 1);
        KRC = r101;
        LyricStatus r102 = new LyricStatus("LRC", 2, 2);
        LRC = r102;
        LyricStatus r103 = new LyricStatus("KRC_AND_LRC", 3, 4);
        KRC_AND_LRC = r103;
        $VALUES = new LyricStatus[]{r100, r101, r102, r103};
    }

    public static LyricStatus[] values() {
        return (LyricStatus[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$LyricStatus[ordinal()];
        if (r100 != 1) goto L5;
        return "LYRIC_STATUS_KRC";
    L5:
        if (r100 != 2) goto L7;
        return "LYRIC_STATUS_LRC";
    L7:
        if (r100 != 3) goto L9;
        return "LYRIC_STATUS_KRC_AND_LRC";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "LYRIC_STATUS_NONE";
    }

    public int value() {
        return this.value;
    }

    public static LyricStatus fromId(int r100) {
        LyricStatus[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LyricStatus r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LyricStatus valueOf(String r100) {
        return (LyricStatus) a.a(LyricStatus.class, r100);
    }

    private LyricStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
