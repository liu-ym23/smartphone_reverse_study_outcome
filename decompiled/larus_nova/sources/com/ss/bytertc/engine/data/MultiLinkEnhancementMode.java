package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MultiLinkEnhancementMode extends Enum<MultiLinkEnhancementMode> {
    private static final /* synthetic */ MultiLinkEnhancementMode[] $VALUES = null;
    public static final MultiLinkEnhancementMode MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE = null;
    public static final MultiLinkEnhancementMode MULTI_LINK_ENHANCEMENT_MODE_FORCE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MultiLinkEnhancementMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode = null;

        static {
            int[] r100 = new int[MultiLinkEnhancementMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode = r100;
            r100[MultiLinkEnhancementMode.MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode[MultiLinkEnhancementMode.MULTI_LINK_ENHANCEMENT_MODE_FORCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MultiLinkEnhancementMode r100 = new MultiLinkEnhancementMode("MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE", 0, 0);
        MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE = r100;
        MultiLinkEnhancementMode r101 = new MultiLinkEnhancementMode("MULTI_LINK_ENHANCEMENT_MODE_FORCE", 1, 1);
        MULTI_LINK_ENHANCEMENT_MODE_FORCE = r101;
        $VALUES = new MultiLinkEnhancementMode[]{r100, r101};
    }

    public static MultiLinkEnhancementMode[] values() {
        return (MultiLinkEnhancementMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode[ordinal()];
        if (r100 != 1) goto L5;
        return "kMultiLinkEnhancementModeAdaptive";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kMultiLinkEnhancementModeForce";
    }

    public int value() {
        return this.value;
    }

    public static MultiLinkEnhancementMode fromId(int r100) {
        MultiLinkEnhancementMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MultiLinkEnhancementMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MultiLinkEnhancementMode valueOf(String r100) {
        return (MultiLinkEnhancementMode) a.a(MultiLinkEnhancementMode.class, r100);
    }

    private MultiLinkEnhancementMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
