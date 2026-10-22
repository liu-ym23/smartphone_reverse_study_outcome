package com.ss.android.lark.ug.scheduler.common.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/common/entity/ReachPointState;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER", "SHOW", "HIDE", "LEAVE", "CONSUME", "REMOVE", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachPointState extends Enum<ReachPointState> {
    public static final ReachPointState CONSUME = null;
    public static final ReachPointState ENTER = null;
    public static final ReachPointState HIDE = null;
    public static final ReachPointState LEAVE = null;
    public static final ReachPointState REMOVE = null;
    public static final ReachPointState SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachPointState[] f444459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444460b = null;

    public static EnumEntries<ReachPointState> getEntries() {
        return f444460b;
    }

    static {
        ReachPointState r100 = new ReachPointState("ENTER", 0);
        ENTER = r100;
        ReachPointState r101 = new ReachPointState("SHOW", 1);
        SHOW = r101;
        ReachPointState r102 = new ReachPointState("HIDE", 2);
        HIDE = r102;
        ReachPointState r103 = new ReachPointState("LEAVE", 3);
        LEAVE = r103;
        ReachPointState r104 = new ReachPointState("CONSUME", 4);
        CONSUME = r104;
        ReachPointState r105 = new ReachPointState("REMOVE", 5);
        REMOVE = r105;
        ReachPointState[] r110 = {r100, r101, r102, r103, r104, r105};
        f444459a = r110;
        f444460b = EnumEntriesKt.enumEntries(r110);
    }

    public static ReachPointState[] values() {
        return (ReachPointState[]) f444459a.clone();
    }

    public static ReachPointState valueOf(String r100) {
        return (ReachPointState) a.a(ReachPointState.class, r100);
    }

    public ReachPointState(String r100, int r101) {
        super(r100, r101);
    }
}
