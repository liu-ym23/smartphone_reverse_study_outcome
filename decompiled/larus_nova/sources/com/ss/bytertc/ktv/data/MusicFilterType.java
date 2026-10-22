package com.ss.bytertc.ktv.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MusicFilterType extends Enum<MusicFilterType> {
    private static final /* synthetic */ MusicFilterType[] $VALUES = null;
    public static final MusicFilterType NONE = null;
    public static final MusicFilterType UNSUPPORTED_ACCOMPANY = null;
    public static final MusicFilterType UNSUPPORTED_CLIMAX = null;
    public static final MusicFilterType UNSUPPORTED_SCORE = null;
    public static final MusicFilterType WITHOUT_LYRIC = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.MusicFilterType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType = null;

        static {
            int[] r100 = new int[MusicFilterType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType = r100;
            r100[MusicFilterType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.WITHOUT_LYRIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_SCORE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_ACCOMPANY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_CLIMAX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        MusicFilterType r100 = new MusicFilterType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        MusicFilterType r101 = new MusicFilterType("WITHOUT_LYRIC", 1, 1);
        WITHOUT_LYRIC = r101;
        MusicFilterType r102 = new MusicFilterType("UNSUPPORTED_SCORE", 2, 2);
        UNSUPPORTED_SCORE = r102;
        MusicFilterType r103 = new MusicFilterType("UNSUPPORTED_ACCOMPANY", 3, 4);
        UNSUPPORTED_ACCOMPANY = r103;
        MusicFilterType r104 = new MusicFilterType("UNSUPPORTED_CLIMAX", 4, 8);
        UNSUPPORTED_CLIMAX = r104;
        $VALUES = new MusicFilterType[]{r100, r101, r102, r103, r104};
    }

    public static MusicFilterType[] values() {
        return (MusicFilterType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[ordinal()];
        if (r100 != 1) goto L5;
        return "MUSIC_FILTER_TYPE_NONE";
    L5:
        if (r100 != 2) goto L7;
        return "MUSIC_FILTER_TYPE_WITHOUT_LYRIC";
    L7:
        if (r100 != 3) goto L9;
        return "MUSIC_FILTER_TYPE_UNSUPPORTED_SCORE";
    L9:
        if (r100 != 4) goto L11;
        return "MUSIC_FILTER_TYPE_UNSUPPORTED_ACCOMPANY";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "MUSIC_FILTER_TYPE_UNSUPPORTED_CLIMAX";
    }

    public int value() {
        return this.value;
    }

    public static MusicFilterType fromId(int r100) {
        MusicFilterType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MusicFilterType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MusicFilterType valueOf(String r100) {
        return (MusicFilterType) a.a(MusicFilterType.class, r100);
    }

    private MusicFilterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
