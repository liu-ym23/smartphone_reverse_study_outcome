package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MediaPlayerCustomSourceStreamType extends Enum<MediaPlayerCustomSourceStreamType> {
    private static final /* synthetic */ MediaPlayerCustomSourceStreamType[] $VALUES = null;
    public static final MediaPlayerCustomSourceStreamType ENCODED = null;
    public static final MediaPlayerCustomSourceStreamType RAW = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceStreamType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType = null;

        static {
            int[] r100 = new int[MediaPlayerCustomSourceStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType = r100;
            r100[MediaPlayerCustomSourceStreamType.RAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[MediaPlayerCustomSourceStreamType.ENCODED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MediaPlayerCustomSourceStreamType r100 = new MediaPlayerCustomSourceStreamType("RAW", 0, 0);
        RAW = r100;
        MediaPlayerCustomSourceStreamType r101 = new MediaPlayerCustomSourceStreamType("ENCODED", 1, 1);
        ENCODED = r101;
        $VALUES = new MediaPlayerCustomSourceStreamType[]{r100, r101};
    }

    public static MediaPlayerCustomSourceStreamType[] values() {
        return (MediaPlayerCustomSourceStreamType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[ordinal()];
        if (r100 != 1) goto L5;
        return "RAW";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "ENCODED";
    }

    public int value() {
        return this.value;
    }

    public static MediaPlayerCustomSourceStreamType fromId(int r100) {
        MediaPlayerCustomSourceStreamType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MediaPlayerCustomSourceStreamType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MediaPlayerCustomSourceStreamType valueOf(String r100) {
        return (MediaPlayerCustomSourceStreamType) a.a(MediaPlayerCustomSourceStreamType.class, r100);
    }

    private MediaPlayerCustomSourceStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
