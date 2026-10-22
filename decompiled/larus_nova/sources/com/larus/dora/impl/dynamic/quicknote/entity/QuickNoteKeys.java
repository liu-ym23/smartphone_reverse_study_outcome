package com.larus.dora.impl.dynamic.quicknote.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/quicknote/entity/QuickNoteKeys;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEFT_LONG_PRESS", "RIGHT_LONG_PRESS", "LEFT_DOUBLE_CLICK", "RIGHT_DOUBLE_CLICK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickNoteKeys extends Enum<QuickNoteKeys> {
    public static final QuickNoteKeys LEFT_DOUBLE_CLICK = null;
    public static final QuickNoteKeys LEFT_LONG_PRESS = null;
    public static final QuickNoteKeys RIGHT_DOUBLE_CLICK = null;
    public static final QuickNoteKeys RIGHT_LONG_PRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickNoteKeys[] f335262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335263b = null;
    private final String value;

    public static EnumEntries<QuickNoteKeys> getEntries() {
        return f335263b;
    }

    static {
        QuickNoteKeys r100 = new QuickNoteKeys("LEFT_LONG_PRESS", 0, "left_long_press");
        LEFT_LONG_PRESS = r100;
        QuickNoteKeys r101 = new QuickNoteKeys("RIGHT_LONG_PRESS", 1, "right_long_press");
        RIGHT_LONG_PRESS = r101;
        QuickNoteKeys r102 = new QuickNoteKeys("LEFT_DOUBLE_CLICK", 2, "left_double_click");
        LEFT_DOUBLE_CLICK = r102;
        QuickNoteKeys r103 = new QuickNoteKeys("RIGHT_DOUBLE_CLICK", 3, "right_double_click");
        RIGHT_DOUBLE_CLICK = r103;
        QuickNoteKeys[] r104 = {r100, r101, r102, r103};
        f335262a = r104;
        f335263b = EnumEntriesKt.enumEntries(r104);
    }

    public static QuickNoteKeys[] values() {
        return (QuickNoteKeys[]) f335262a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static QuickNoteKeys valueOf(String r100) {
        return (QuickNoteKeys) a.a(QuickNoteKeys.class, r100);
    }

    public QuickNoteKeys(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
