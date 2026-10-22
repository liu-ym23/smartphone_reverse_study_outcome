package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LinkIndex extends Enum<LinkIndex> {
    private static final /* synthetic */ LinkIndex[] $VALUES = null;
    public static final LinkIndex LINK_INDEX_MAIN = null;
    public static final LinkIndex LINK_INDEX_STANDBY = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.LinkIndex$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$LinkIndex = null;

        static {
            int[] r100 = new int[LinkIndex.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$LinkIndex = r100;
            r100[LinkIndex.LINK_INDEX_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$LinkIndex[LinkIndex.LINK_INDEX_STANDBY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        LinkIndex r100 = new LinkIndex("LINK_INDEX_MAIN", 0, 0);
        LINK_INDEX_MAIN = r100;
        LinkIndex r101 = new LinkIndex("LINK_INDEX_STANDBY", 1, 1);
        LINK_INDEX_STANDBY = r101;
        $VALUES = new LinkIndex[]{r100, r101};
    }

    public static LinkIndex[] values() {
        return (LinkIndex[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$LinkIndex[ordinal()];
        if (r100 != 1) goto L5;
        return "kLinkIndexMain";
    L5:
        if (r100 == 2) goto L8;
        return "valid";
    L8:
        return "kLinkIndexStandby";
    }

    public int value() {
        return this.value;
    }

    public static LinkIndex fromId(int r100) {
        LinkIndex[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LinkIndex r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LinkIndex valueOf(String r100) {
        return (LinkIndex) a.a(LinkIndex.class, r100);
    }

    private LinkIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
