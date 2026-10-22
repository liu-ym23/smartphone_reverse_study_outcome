package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StreamIndex extends Enum<StreamIndex> {
    private static final /* synthetic */ StreamIndex[] $VALUES = null;
    public static final StreamIndex STREAM_INDEX_3RD = null;
    public static final StreamIndex STREAM_INDEX_4TH = null;
    public static final StreamIndex STREAM_INDEX_5TH = null;
    public static final StreamIndex STREAM_INDEX_6TH = null;
    public static final StreamIndex STREAM_INDEX_7TH = null;
    public static final StreamIndex STREAM_INDEX_MAIN = null;
    public static final StreamIndex STREAM_INDEX_MAX = null;
    public static final StreamIndex STREAM_INDEX_SCREEN = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.StreamIndex$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$StreamIndex = null;

        static {
            int[] r100 = new int[StreamIndex.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex = r100;
            r100[StreamIndex.STREAM_INDEX_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_SCREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_3RD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_4TH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_5TH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_6TH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$StreamIndex[StreamIndex.STREAM_INDEX_7TH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        StreamIndex r100 = new StreamIndex("STREAM_INDEX_MAIN", 0, 0);
        STREAM_INDEX_MAIN = r100;
        StreamIndex r101 = new StreamIndex("STREAM_INDEX_SCREEN", 1, 1);
        STREAM_INDEX_SCREEN = r101;
        StreamIndex r102 = new StreamIndex("STREAM_INDEX_3RD", 2, 2);
        STREAM_INDEX_3RD = r102;
        StreamIndex r103 = new StreamIndex("STREAM_INDEX_4TH", 3, 3);
        STREAM_INDEX_4TH = r103;
        StreamIndex r104 = new StreamIndex("STREAM_INDEX_5TH", 4, 4);
        STREAM_INDEX_5TH = r104;
        StreamIndex r105 = new StreamIndex("STREAM_INDEX_6TH", 5, 5);
        STREAM_INDEX_6TH = r105;
        StreamIndex r110 = new StreamIndex("STREAM_INDEX_7TH", 6, 6);
        STREAM_INDEX_7TH = r110;
        StreamIndex r111 = new StreamIndex("STREAM_INDEX_MAX", 7, 7);
        STREAM_INDEX_MAX = r111;
        $VALUES = new StreamIndex[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static StreamIndex[] values() {
        return (StreamIndex[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$StreamIndex[ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return "valid";
    L6:
        return "kStreamIndex7th";
    L8:
        return "kStreamIndex6th";
    L10:
        return "kStreamIndex5th";
    L12:
        return "kStreamIndex4th";
    L14:
        return "kStreamIndex3rd";
    L16:
        return "kStreamIndexScreen";
    L18:
        return "kStreamIndexMain";
    }

    public int value() {
        return this.value;
    }

    public static StreamIndex fromId(int r100) {
        StreamIndex[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        StreamIndex r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static StreamIndex valueOf(String r100) {
        return (StreamIndex) a.a(StreamIndex.class, r100);
    }

    private StreamIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
