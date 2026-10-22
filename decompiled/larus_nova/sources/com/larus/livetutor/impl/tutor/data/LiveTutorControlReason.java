package com.larus.livetutor.impl.tutor.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/LiveTutorControlReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RESTART_LEARN", "UPDATE_SPEED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LiveTutorControlReason extends Enum<LiveTutorControlReason> {
    public static final LiveTutorControlReason RESTART_LEARN = null;
    public static final LiveTutorControlReason UPDATE_SPEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveTutorControlReason[] f356550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356551b = null;
    private final int value;

    public static EnumEntries<LiveTutorControlReason> getEntries() {
        return f356551b;
    }

    static {
        LiveTutorControlReason r100 = new LiveTutorControlReason("RESTART_LEARN", 0, -1);
        RESTART_LEARN = r100;
        LiveTutorControlReason r101 = new LiveTutorControlReason("UPDATE_SPEED", 1, -2);
        UPDATE_SPEED = r101;
        LiveTutorControlReason[] r102 = {r100, r101};
        f356550a = r102;
        f356551b = EnumEntriesKt.enumEntries(r102);
    }

    public static LiveTutorControlReason[] values() {
        return (LiveTutorControlReason[]) f356550a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LiveTutorControlReason valueOf(String r100) {
        return (LiveTutorControlReason) a.a(LiveTutorControlReason.class, r100);
    }

    public LiveTutorControlReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
