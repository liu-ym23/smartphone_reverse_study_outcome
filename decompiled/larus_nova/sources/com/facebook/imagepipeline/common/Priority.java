package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final enum Priority extends Enum<Priority> {
    private static final /* synthetic */ Priority[] $VALUES = null;
    public static final Priority HIGH = null;
    public static final Priority IMMEDIATE = null;
    public static final Priority LOW = null;
    public static final Priority MEDIUM = null;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.common.Priority$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$common$Priority = null;

        static {
            int[] r100 = new int[Priority.values().length];
            $SwitchMap$com$facebook$imagepipeline$common$Priority = r100;
            r100[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        Priority r100 = new Priority("LOW", 0);
        LOW = r100;
        Priority r101 = new Priority("MEDIUM", 1);
        MEDIUM = r101;
        Priority r102 = new Priority("HIGH", 2);
        HIGH = r102;
        Priority r103 = new Priority("IMMEDIATE", 3);
        IMMEDIATE = r103;
        $VALUES = new Priority[]{r100, r101, r102, r103};
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }

    public static int getIntPriorityValue(Priority r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$common$Priority[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 3) goto L7;
        return 2;
    L7:
        if (r101 == 4) goto L9;
        return 1;
    L9:
        return 3;
    }

    public static Priority valueOf(String r100) {
        return (Priority) Enum.valueOf(Priority.class, r100);
    }

    private Priority(String r100, int r101) {
        super(r100, r101);
    }

    public static Priority getHigherPriority(@Nullable Priority r100, @Nullable Priority r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L7;
        return r100;
    L7:
        if (r100.ordinal() <= r101.ordinal()) goto L9;
        return r100;
    L9:
        return r101;
    }

    public static Priority getLowerPriority(@Nullable Priority r100, @Nullable Priority r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L7;
        return r100;
    L7:
        if (r100.ordinal() >= r101.ordinal()) goto L9;
        return r100;
    L9:
        return r101;
    }
}
