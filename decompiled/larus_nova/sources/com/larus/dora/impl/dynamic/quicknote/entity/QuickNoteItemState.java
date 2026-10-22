package com.larus.dora.impl.dynamic.quicknote.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/dynamic/quicknote/entity/QuickNoteItemState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SELECTED", "CONFIRMED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickNoteItemState extends Enum<QuickNoteItemState> {
    public static final QuickNoteItemState CONFIRMED = null;
    public static final QuickNoteItemState IDLE = null;
    public static final QuickNoteItemState SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QuickNoteItemState[] f335260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335261b = null;

    public static EnumEntries<QuickNoteItemState> getEntries() {
        return f335261b;
    }

    static {
        QuickNoteItemState r100 = new QuickNoteItemState("IDLE", 0);
        IDLE = r100;
        QuickNoteItemState r101 = new QuickNoteItemState("SELECTED", 1);
        SELECTED = r101;
        QuickNoteItemState r102 = new QuickNoteItemState("CONFIRMED", 2);
        CONFIRMED = r102;
        QuickNoteItemState[] r103 = {r100, r101, r102};
        f335260a = r103;
        f335261b = EnumEntriesKt.enumEntries(r103);
    }

    public static QuickNoteItemState[] values() {
        return (QuickNoteItemState[]) f335260a.clone();
    }

    public static QuickNoteItemState valueOf(String r100) {
        return (QuickNoteItemState) a.a(QuickNoteItemState.class, r100);
    }

    public QuickNoteItemState(String r100, int r101) {
        super(r100, r101);
    }
}
