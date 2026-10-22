package com.ss.android.ainote.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ainote/model/AINoteListState;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "EMPTY", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteListState extends Enum<AINoteListState> {
    public static final AINoteListState CONTENT = null;
    public static final AINoteListState EMPTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteListState[] f407141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407142b = null;

    public static EnumEntries<AINoteListState> getEntries() {
        return f407142b;
    }

    static {
        AINoteListState r100 = new AINoteListState("CONTENT", 0);
        CONTENT = r100;
        AINoteListState r101 = new AINoteListState("EMPTY", 1);
        EMPTY = r101;
        AINoteListState[] r102 = {r100, r101};
        f407141a = r102;
        f407142b = EnumEntriesKt.enumEntries(r102);
    }

    public static AINoteListState[] values() {
        return (AINoteListState[]) f407141a.clone();
    }

    public static AINoteListState valueOf(String r100) {
        return (AINoteListState) a.a(AINoteListState.class, r100);
    }

    public AINoteListState(String r100, int r101) {
        super(r100, r101);
    }
}
