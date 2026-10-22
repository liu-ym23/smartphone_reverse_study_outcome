package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum EnqueueType extends Enum<EnqueueType> {
    private static final /* synthetic */ EnqueueType[] $VALUES = null;
    public static final EnqueueType ENQUEUE_HEAD = null;
    public static final EnqueueType ENQUEUE_NONE = null;
    public static final EnqueueType ENQUEUE_TAIL = null;
    public static final EnqueueType NEW_ENQUEUE_IMMEDIATE = null;
    public static final EnqueueType NEW_ENQUEUE_NORMAL = null;

    static {
        EnqueueType r100 = new EnqueueType("ENQUEUE_NONE", 0);
        ENQUEUE_NONE = r100;
        EnqueueType r101 = new EnqueueType("ENQUEUE_HEAD", 1);
        ENQUEUE_HEAD = r101;
        EnqueueType r102 = new EnqueueType("ENQUEUE_TAIL", 2);
        ENQUEUE_TAIL = r102;
        EnqueueType r103 = new EnqueueType("NEW_ENQUEUE_NORMAL", 3);
        NEW_ENQUEUE_NORMAL = r103;
        EnqueueType r104 = new EnqueueType("NEW_ENQUEUE_IMMEDIATE", 4);
        NEW_ENQUEUE_IMMEDIATE = r104;
        $VALUES = new EnqueueType[]{r100, r101, r102, r103, r104};
    }

    public static EnqueueType[] values() {
        return (EnqueueType[]) $VALUES.clone();
    }

    public static EnqueueType valueOf(String r100) {
        return (EnqueueType) a.a(EnqueueType.class, r100);
    }

    private EnqueueType(String r100, int r101) {
        super(r100, r101);
    }
}
