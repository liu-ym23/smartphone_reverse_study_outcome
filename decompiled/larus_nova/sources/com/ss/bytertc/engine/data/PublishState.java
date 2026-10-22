package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PublishState extends Enum<PublishState> {
    private static final /* synthetic */ PublishState[] $VALUES = null;
    public static final PublishState PUBLISHED = null;
    public static final PublishState UNPUBLISHED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.PublishState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PublishState = null;

        static {
            int[] r100 = new int[PublishState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PublishState = r100;
            r100[PublishState.PUBLISHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$PublishState[PublishState.UNPUBLISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        PublishState r100 = new PublishState("PUBLISHED", 0, 0);
        PUBLISHED = r100;
        PublishState r101 = new PublishState("UNPUBLISHED", 1, 1);
        UNPUBLISHED = r101;
        $VALUES = new PublishState[]{r100, r101};
    }

    public static PublishState[] values() {
        return (PublishState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PublishState[ordinal()];
        if (r100 != 1) goto L5;
        return "kPublishStatePublished";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kPublishStateUnpublished";
    }

    public int value() {
        return this.value;
    }

    public static PublishState fromId(int r100) {
        PublishState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PublishState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PublishState valueOf(String r100) {
        return (PublishState) a.a(PublishState.class, r100);
    }

    private PublishState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
