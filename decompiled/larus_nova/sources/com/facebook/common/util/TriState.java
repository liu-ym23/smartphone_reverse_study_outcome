package com.facebook.common.util;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public final enum TriState extends Enum<TriState> {
    private static final /* synthetic */ TriState[] $VALUES = null;
    public static final TriState NO = null;
    public static final TriState UNSET = null;
    public static final TriState YES = null;

    /* JADX INFO: renamed from: com.facebook.common.util.TriState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$common$util$TriState = null;

        static {
            int[] r100 = new int[TriState.values().length];
            $SwitchMap$com$facebook$common$util$TriState = r100;
            r100[TriState.YES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$facebook$common$util$TriState[TriState.NO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$common$util$TriState[TriState.UNSET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        TriState r100 = new TriState("YES", 0);
        YES = r100;
        TriState r101 = new TriState("NO", 1);
        NO = r101;
        TriState r102 = new TriState("UNSET", 2);
        UNSET = r102;
        $VALUES = new TriState[]{r100, r101, r102};
    }

    public static TriState[] values() {
        return (TriState[]) $VALUES.clone();
    }

    public boolean asBoolean() {
        int r100 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return false;
    L7:
        if (r100 == 3) goto L11;
        throw new IllegalStateException("Unrecognized TriState value: " + this);
    L11:
        throw new IllegalStateException("No boolean equivalent for UNSET");
    }

    @Nullable
    public Boolean asBooleanObject() {
        int r100 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 != 3) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Unrecognized TriState value: " + this);
    L13:
        return Boolean.FALSE;
    L15:
        return Boolean.TRUE;
    }

    public int getDbValue() {
        int r100 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        int r101 = 1;
        if (r100 == 1) goto L8;
        r101 = 2;
        if (r100 == 2) goto L8;
        return 3;
    L8:
        return r101;
    }

    public boolean isSet() {
        if (this == UNSET) goto L5;
        return true;
    L5:
        return false;
    }

    public static TriState fromDbValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return UNSET;
    L9:
        return NO;
    L11:
        return YES;
    }

    public static TriState valueOf(Boolean r100) {
        if (r100 == null) goto L5;
        return valueOf(r100.booleanValue());
    L5:
        return UNSET;
    }

    public boolean asBoolean(boolean r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 != 2) goto L7;
        return false;
    L7:
        if (r101 != 3) goto L10;
        return r100;
    L10:
        throw new IllegalStateException("Unrecognized TriState value: " + this);
    }

    public static TriState valueOf(String r100) {
        return (TriState) Enum.valueOf(TriState.class, r100);
    }

    public static TriState valueOf(boolean r100) {
        if (r100 == false) goto L5;
        return YES;
    L5:
        return NO;
    }

    private TriState(String r100, int r101) {
        super(r100, r101);
    }
}
