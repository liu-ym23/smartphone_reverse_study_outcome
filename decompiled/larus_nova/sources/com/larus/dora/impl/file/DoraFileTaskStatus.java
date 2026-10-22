package com.larus.dora.impl.file;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", GXAnimation.STATE_START, "RUNNING", "PAUSED", "UPLOADING", "DONE", "FAILED", "CANCELED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileTaskStatus extends Enum<DoraFileTaskStatus> {
    public static final DoraFileTaskStatus CANCELED = null;
    public static final DoraFileTaskStatus DONE = null;
    public static final DoraFileTaskStatus FAILED = null;
    public static final DoraFileTaskStatus PAUSED = null;
    public static final DoraFileTaskStatus PENDING = null;
    public static final DoraFileTaskStatus RUNNING = null;
    public static final DoraFileTaskStatus START = null;
    public static final DoraFileTaskStatus UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraFileTaskStatus[] f335717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335718b = null;

    public static EnumEntries<DoraFileTaskStatus> getEntries() {
        return f335718b;
    }

    static {
        DoraFileTaskStatus r100 = new DoraFileTaskStatus("PENDING", 0);
        PENDING = r100;
        DoraFileTaskStatus r101 = new DoraFileTaskStatus(GXAnimation.STATE_START, 1);
        START = r101;
        DoraFileTaskStatus r102 = new DoraFileTaskStatus("RUNNING", 2);
        RUNNING = r102;
        DoraFileTaskStatus r103 = new DoraFileTaskStatus("PAUSED", 3);
        PAUSED = r103;
        DoraFileTaskStatus r104 = new DoraFileTaskStatus("UPLOADING", 4);
        UPLOADING = r104;
        DoraFileTaskStatus r105 = new DoraFileTaskStatus("DONE", 5);
        DONE = r105;
        DoraFileTaskStatus r110 = new DoraFileTaskStatus("FAILED", 6);
        FAILED = r110;
        DoraFileTaskStatus r111 = new DoraFileTaskStatus("CANCELED", 7);
        CANCELED = r111;
        DoraFileTaskStatus[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f335717a = r112;
        f335718b = EnumEntriesKt.enumEntries(r112);
    }

    public static DoraFileTaskStatus[] values() {
        return (DoraFileTaskStatus[]) f335717a.clone();
    }

    public static DoraFileTaskStatus valueOf(String r100) {
        return (DoraFileTaskStatus) r27.a.a(DoraFileTaskStatus.class, r100);
    }

    public DoraFileTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
