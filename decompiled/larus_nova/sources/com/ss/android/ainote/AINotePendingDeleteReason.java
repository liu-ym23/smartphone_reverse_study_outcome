package com.ss.android.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ainote/AINotePendingDeleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_EXPLICIT", "AUTO_EMPTY", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINotePendingDeleteReason extends Enum<AINotePendingDeleteReason> {
    public static final AINotePendingDeleteReason AUTO_EMPTY = null;
    public static final AINotePendingDeleteReason USER_EXPLICIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINotePendingDeleteReason[] f406527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f406528b = null;

    public static EnumEntries<AINotePendingDeleteReason> getEntries() {
        return f406528b;
    }

    static {
        AINotePendingDeleteReason r100 = new AINotePendingDeleteReason("USER_EXPLICIT", 0);
        USER_EXPLICIT = r100;
        AINotePendingDeleteReason r101 = new AINotePendingDeleteReason("AUTO_EMPTY", 1);
        AUTO_EMPTY = r101;
        AINotePendingDeleteReason[] r102 = {r100, r101};
        f406527a = r102;
        f406528b = EnumEntriesKt.enumEntries(r102);
    }

    public static AINotePendingDeleteReason[] values() {
        return (AINotePendingDeleteReason[]) f406527a.clone();
    }

    public static AINotePendingDeleteReason valueOf(String r100) {
        return (AINotePendingDeleteReason) r27.a.a(AINotePendingDeleteReason.class, r100);
    }

    public AINotePendingDeleteReason(String r100, int r101) {
        super(r100, r101);
    }
}
