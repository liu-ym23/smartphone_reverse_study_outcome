package com.ss.android.lark.movable.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/MovableLongPressBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "PARTIAL_SELECTION", "SELECT_ALL_AND_DISPATCH", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MovableLongPressBehavior extends Enum<MovableLongPressBehavior> {
    public static final MovableLongPressBehavior PARTIAL_SELECTION = null;
    public static final MovableLongPressBehavior SELECT_ALL_AND_DISPATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MovableLongPressBehavior[] f432723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432724b = null;

    public static EnumEntries<MovableLongPressBehavior> getEntries() {
        return f432724b;
    }

    static {
        MovableLongPressBehavior r100 = new MovableLongPressBehavior("PARTIAL_SELECTION", 0);
        PARTIAL_SELECTION = r100;
        MovableLongPressBehavior r101 = new MovableLongPressBehavior("SELECT_ALL_AND_DISPATCH", 1);
        SELECT_ALL_AND_DISPATCH = r101;
        MovableLongPressBehavior[] r102 = {r100, r101};
        f432723a = r102;
        f432724b = EnumEntriesKt.enumEntries(r102);
    }

    public static MovableLongPressBehavior[] values() {
        return (MovableLongPressBehavior[]) f432723a.clone();
    }

    public static MovableLongPressBehavior valueOf(String r100) {
        return (MovableLongPressBehavior) r27.a.a(MovableLongPressBehavior.class, r100);
    }

    public MovableLongPressBehavior(String r100, int r101) {
        super(r100, r101);
    }
}
