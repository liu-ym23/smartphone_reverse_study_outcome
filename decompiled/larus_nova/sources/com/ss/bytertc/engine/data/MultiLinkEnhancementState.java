package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MultiLinkEnhancementState extends Enum<MultiLinkEnhancementState> {
    private static final /* synthetic */ MultiLinkEnhancementState[] $VALUES = null;
    public static final MultiLinkEnhancementState MULTI_LINK_ENHANCEMENT_STATE_CONNECTED = null;
    public static final MultiLinkEnhancementState MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MultiLinkEnhancementState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState = null;

        static {
            int[] r100 = new int[MultiLinkEnhancementState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState = r100;
            r100[MultiLinkEnhancementState.MULTI_LINK_ENHANCEMENT_STATE_CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState[MultiLinkEnhancementState.MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MultiLinkEnhancementState r100 = new MultiLinkEnhancementState("MULTI_LINK_ENHANCEMENT_STATE_CONNECTED", 0, 0);
        MULTI_LINK_ENHANCEMENT_STATE_CONNECTED = r100;
        MultiLinkEnhancementState r101 = new MultiLinkEnhancementState("MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED", 1, 1);
        MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED = r101;
        $VALUES = new MultiLinkEnhancementState[]{r100, r101};
    }

    public static MultiLinkEnhancementState[] values() {
        return (MultiLinkEnhancementState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState[ordinal()];
        if (r100 != 1) goto L5;
        return "kMultiLinkEnhancementStateConnected";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kMultiLinkEnhancementStateDisconnected";
    }

    public int value() {
        return this.value;
    }

    public static MultiLinkEnhancementState fromId(int r100) {
        MultiLinkEnhancementState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MultiLinkEnhancementState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MultiLinkEnhancementState valueOf(String r100) {
        return (MultiLinkEnhancementState) a.a(MultiLinkEnhancementState.class, r100);
    }

    private MultiLinkEnhancementState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
