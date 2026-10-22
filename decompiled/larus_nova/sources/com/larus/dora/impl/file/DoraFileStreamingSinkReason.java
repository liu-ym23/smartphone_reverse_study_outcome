package com.larus.dora.impl.file;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileStreamingSinkReason;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "ERROR", "INCOMPLETED", "PAUSED", "FIRST_FRAME_TIMEOUT", "DONE", "NO_ENOUGH_SPACE", "MD5_CHECK_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileStreamingSinkReason extends Enum<DoraFileStreamingSinkReason> {
    public static final DoraFileStreamingSinkReason DONE = null;
    public static final DoraFileStreamingSinkReason ERROR = null;
    public static final DoraFileStreamingSinkReason FIRST_FRAME_TIMEOUT = null;
    public static final DoraFileStreamingSinkReason INCOMPLETED = null;
    public static final DoraFileStreamingSinkReason MD5_CHECK_FAILED = null;
    public static final DoraFileStreamingSinkReason NO_ENOUGH_SPACE = null;
    public static final DoraFileStreamingSinkReason PAUSED = null;
    public static final DoraFileStreamingSinkReason START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraFileStreamingSinkReason[] f335715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335716b = null;

    public static EnumEntries<DoraFileStreamingSinkReason> getEntries() {
        return f335716b;
    }

    static {
        DoraFileStreamingSinkReason r100 = new DoraFileStreamingSinkReason(GXAnimation.STATE_START, 0);
        START = r100;
        DoraFileStreamingSinkReason r101 = new DoraFileStreamingSinkReason("ERROR", 1);
        ERROR = r101;
        DoraFileStreamingSinkReason r102 = new DoraFileStreamingSinkReason("INCOMPLETED", 2);
        INCOMPLETED = r102;
        DoraFileStreamingSinkReason r103 = new DoraFileStreamingSinkReason("PAUSED", 3);
        PAUSED = r103;
        DoraFileStreamingSinkReason r104 = new DoraFileStreamingSinkReason("FIRST_FRAME_TIMEOUT", 4);
        FIRST_FRAME_TIMEOUT = r104;
        DoraFileStreamingSinkReason r105 = new DoraFileStreamingSinkReason("DONE", 5);
        DONE = r105;
        DoraFileStreamingSinkReason r110 = new DoraFileStreamingSinkReason("NO_ENOUGH_SPACE", 6);
        NO_ENOUGH_SPACE = r110;
        DoraFileStreamingSinkReason r111 = new DoraFileStreamingSinkReason("MD5_CHECK_FAILED", 7);
        MD5_CHECK_FAILED = r111;
        DoraFileStreamingSinkReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f335715a = r112;
        f335716b = EnumEntriesKt.enumEntries(r112);
    }

    public static DoraFileStreamingSinkReason[] values() {
        return (DoraFileStreamingSinkReason[]) f335715a.clone();
    }

    public static DoraFileStreamingSinkReason valueOf(String r100) {
        return (DoraFileStreamingSinkReason) r27.a.a(DoraFileStreamingSinkReason.class, r100);
    }

    public DoraFileStreamingSinkReason(String r100, int r101) {
        super(r100, r101);
    }
}
