package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AVSyncEvent extends Enum<AVSyncEvent> {
    private static final /* synthetic */ AVSyncEvent[] $VALUES = null;
    public static final AVSyncEvent INVALID_UID_REPEATED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AVSyncEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent = null;

        static {
            int[] r100 = new int[AVSyncEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent = r100;
            r100[AVSyncEvent.INVALID_UID_REPEATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    static {
        AVSyncEvent r100 = new AVSyncEvent("INVALID_UID_REPEATED", 0, 0);
        INVALID_UID_REPEATED = r100;
        $VALUES = new AVSyncEvent[]{r100};
    }

    public static AVSyncEvent[] values() {
        return (AVSyncEvent[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent[ordinal()] == 1) goto L5;
        return "";
    L5:
        return "kAVSyncEventInvalidUidRepeated";
    }

    public int value() {
        return this.value;
    }

    public static AVSyncEvent fromId(int r100) {
        AVSyncEvent[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AVSyncEvent r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AVSyncEvent valueOf(String r100) {
        return (AVSyncEvent) a.a(AVSyncEvent.class, r100);
    }

    private AVSyncEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
