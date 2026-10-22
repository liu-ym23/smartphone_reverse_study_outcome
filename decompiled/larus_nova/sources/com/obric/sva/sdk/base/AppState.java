package com.obric.sva.sdk.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/sva/sdk/base/AppState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UnknownStatus", "BackGroundWithScreenLocked", "BackGroundWithScreenUnLocked", "ForeGroundWithScreenLocked", "ForeGroundWithScreenUnLocked", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppState extends Enum<AppState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppState[] $VALUES = null;
    public static final AppState BackGroundWithScreenLocked = null;
    public static final AppState BackGroundWithScreenUnLocked = null;
    public static final AppState ForeGroundWithScreenLocked = null;
    public static final AppState ForeGroundWithScreenUnLocked = null;
    public static final AppState UnknownStatus = null;
    private final int value;

    private static final /* synthetic */ AppState[] $values() {
        return new AppState[]{UnknownStatus, BackGroundWithScreenLocked, BackGroundWithScreenUnLocked, ForeGroundWithScreenLocked, ForeGroundWithScreenUnLocked};
    }

    public static EnumEntries<AppState> getEntries() {
        return $ENTRIES;
    }

    static {
        UnknownStatus = new AppState("UnknownStatus", 0, 0);
        BackGroundWithScreenLocked = new AppState("BackGroundWithScreenLocked", 1, 1);
        BackGroundWithScreenUnLocked = new AppState("BackGroundWithScreenUnLocked", 2, 2);
        ForeGroundWithScreenLocked = new AppState("ForeGroundWithScreenLocked", 3, 3);
        ForeGroundWithScreenUnLocked = new AppState("ForeGroundWithScreenUnLocked", 4, 4);
        AppState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AppState[] values() {
        return (AppState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppState valueOf(String r100) {
        return (AppState) a.a(AppState.class, r100);
    }

    private AppState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
