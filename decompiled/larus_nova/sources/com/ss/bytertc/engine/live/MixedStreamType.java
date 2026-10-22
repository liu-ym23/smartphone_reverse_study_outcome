package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamType extends Enum<MixedStreamType> {
    private static final /* synthetic */ MixedStreamType[] $VALUES = null;
    public static final MixedStreamType MIXED_STREAM_TYPE_BY_CLIENT = null;
    public static final MixedStreamType MIXED_STREAM_TYPE_BY_SERVER = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.live.MixedStreamType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType = null;

        static {
            int[] r100 = new int[MixedStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType = r100;
            r100[MixedStreamType.MIXED_STREAM_TYPE_BY_SERVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType[MixedStreamType.MIXED_STREAM_TYPE_BY_CLIENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MixedStreamType r100 = new MixedStreamType("MIXED_STREAM_TYPE_BY_SERVER", 0, 0);
        MIXED_STREAM_TYPE_BY_SERVER = r100;
        MixedStreamType r101 = new MixedStreamType("MIXED_STREAM_TYPE_BY_CLIENT", 1, 1);
        MIXED_STREAM_TYPE_BY_CLIENT = r101;
        $VALUES = new MixedStreamType[]{r100, r101};
    }

    public static MixedStreamType[] values() {
        return (MixedStreamType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$MixedStreamType[ordinal()];
        if (r100 != 1) goto L5;
        return "MIXED_STREAM_TYPE_BY_SERVER";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "MIXED_STREAM_TYPE_BY_CLIENT";
    }

    public int value() {
        return this.value;
    }

    public static MixedStreamType fromId(int r100) {
        MixedStreamType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MixedStreamType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MixedStreamType valueOf(String r100) {
        return (MixedStreamType) a.a(MixedStreamType.class, r100);
    }

    private MixedStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
