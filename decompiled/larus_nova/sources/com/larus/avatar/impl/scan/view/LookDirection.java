package com.larus.avatar.impl.scan.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/avatar/impl/scan/view/LookDirection;", "", "<init>", "(Ljava/lang/String;I)V", "FRONT", "LEFT", "RIGHT", "UP", "DOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LookDirection extends Enum<LookDirection> {
    public static final LookDirection DOWN = null;
    public static final LookDirection FRONT = null;
    public static final LookDirection LEFT = null;
    public static final LookDirection RIGHT = null;
    public static final LookDirection UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LookDirection[] f291173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291174b = null;

    public static EnumEntries<LookDirection> getEntries() {
        return f291174b;
    }

    static {
        LookDirection r100 = new LookDirection("FRONT", 0);
        FRONT = r100;
        LookDirection r101 = new LookDirection("LEFT", 1);
        LEFT = r101;
        LookDirection r102 = new LookDirection("RIGHT", 2);
        RIGHT = r102;
        LookDirection r103 = new LookDirection("UP", 3);
        UP = r103;
        LookDirection r104 = new LookDirection("DOWN", 4);
        DOWN = r104;
        LookDirection[] r105 = {r100, r101, r102, r103, r104};
        f291173a = r105;
        f291174b = EnumEntriesKt.enumEntries(r105);
    }

    public static LookDirection[] values() {
        return (LookDirection[]) f291173a.clone();
    }

    public static LookDirection valueOf(String r100) {
        return (LookDirection) r27.a.a(LookDirection.class, r100);
    }

    public LookDirection(String r100, int r101) {
        super(r100, r101);
    }
}
