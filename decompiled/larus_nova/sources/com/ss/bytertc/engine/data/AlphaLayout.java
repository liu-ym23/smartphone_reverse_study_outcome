package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AlphaLayout extends Enum<AlphaLayout> {
    private static final /* synthetic */ AlphaLayout[] $VALUES = null;
    public static final AlphaLayout BOTTOM = null;
    public static final AlphaLayout LEFT = null;
    public static final AlphaLayout RIGHT = null;
    public static final AlphaLayout TOP = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AlphaLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout = null;

        static {
            int[] r100 = new int[AlphaLayout.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout = r100;
            r100[AlphaLayout.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[AlphaLayout.RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        AlphaLayout r100 = new AlphaLayout("TOP", 0, 0);
        TOP = r100;
        AlphaLayout r101 = new AlphaLayout("BOTTOM", 1, 1);
        BOTTOM = r101;
        AlphaLayout r102 = new AlphaLayout("LEFT", 2, 2);
        LEFT = r102;
        AlphaLayout r103 = new AlphaLayout("RIGHT", 3, 3);
        RIGHT = r103;
        $VALUES = new AlphaLayout[]{r100, r101, r102, r103};
    }

    public static AlphaLayout[] values() {
        return (AlphaLayout[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AlphaLayout[ordinal()];
        if (r100 != 1) goto L5;
        return "TOP";
    L5:
        if (r100 != 2) goto L7;
        return "BOTTOM";
    L7:
        if (r100 != 3) goto L9;
        return "LEFT";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "RIGHT";
    }

    public int value() {
        return this.value;
    }

    public static AlphaLayout fromId(int r100) {
        AlphaLayout[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AlphaLayout r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AlphaLayout valueOf(String r100) {
        return (AlphaLayout) a.a(AlphaLayout.class, r100);
    }

    private AlphaLayout(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
