package com.larus.livetutor.impl.tutor.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/LiveTutorEnterState;", "", "info", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "BEGIN_LEARN", "AGAIN_LEARN", "CONTINUE_LEARN", "CLICK_RETRY", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LiveTutorEnterState extends Enum<LiveTutorEnterState> {
    public static final LiveTutorEnterState AGAIN_LEARN = null;
    public static final LiveTutorEnterState BEGIN_LEARN = null;
    public static final LiveTutorEnterState CLICK_RETRY = null;
    public static final LiveTutorEnterState CONTINUE_LEARN = null;
    public static final LiveTutorEnterState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveTutorEnterState[] f356552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356553b = null;
    private final String info;

    public static EnumEntries<LiveTutorEnterState> getEntries() {
        return f356553b;
    }

    static {
        LiveTutorEnterState r100 = new LiveTutorEnterState("BEGIN_LEARN", 0, "begin_learn");
        BEGIN_LEARN = r100;
        LiveTutorEnterState r101 = new LiveTutorEnterState("AGAIN_LEARN", 1, "again_learn");
        AGAIN_LEARN = r101;
        LiveTutorEnterState r102 = new LiveTutorEnterState("CONTINUE_LEARN", 2, "continue_learn");
        CONTINUE_LEARN = r102;
        LiveTutorEnterState r103 = new LiveTutorEnterState("CLICK_RETRY", 3, "click_retry");
        CLICK_RETRY = r103;
        LiveTutorEnterState r104 = new LiveTutorEnterState("UNKNOWN", 4, "");
        UNKNOWN = r104;
        LiveTutorEnterState[] r105 = {r100, r101, r102, r103, r104};
        f356552a = r105;
        f356553b = EnumEntriesKt.enumEntries(r105);
    }

    public static LiveTutorEnterState[] values() {
        return (LiveTutorEnterState[]) f356552a.clone();
    }

    public final String getInfo() {
        return this.info;
    }

    public static LiveTutorEnterState valueOf(String r100) {
        return (LiveTutorEnterState) a.a(LiveTutorEnterState.class, r100);
    }

    public LiveTutorEnterState(String r100, int r101, String r102) {
        super(r100, r101);
        this.info = r102;
    }
}
