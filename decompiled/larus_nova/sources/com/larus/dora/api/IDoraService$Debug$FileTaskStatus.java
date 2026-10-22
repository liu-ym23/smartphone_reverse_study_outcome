package com.larus.dora.api;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/api/IDoraService$Debug$FileTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", GXAnimation.STATE_START, "RUNNING", "PAUSED", "UPLOADING", "DONE", "FAILED", "CANCELED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IDoraService$Debug$FileTaskStatus extends Enum<IDoraService$Debug$FileTaskStatus> {
    public static final IDoraService$Debug$FileTaskStatus CANCELED = null;
    public static final IDoraService$Debug$FileTaskStatus DONE = null;
    public static final IDoraService$Debug$FileTaskStatus FAILED = null;
    public static final IDoraService$Debug$FileTaskStatus PAUSED = null;
    public static final IDoraService$Debug$FileTaskStatus PENDING = null;
    public static final IDoraService$Debug$FileTaskStatus RUNNING = null;
    public static final IDoraService$Debug$FileTaskStatus START = null;
    public static final IDoraService$Debug$FileTaskStatus UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IDoraService$Debug$FileTaskStatus[] f331722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331723b = null;

    public static EnumEntries<IDoraService$Debug$FileTaskStatus> getEntries() {
        return f331723b;
    }

    static {
        IDoraService$Debug$FileTaskStatus r100 = new IDoraService$Debug$FileTaskStatus("PENDING", 0);
        PENDING = r100;
        IDoraService$Debug$FileTaskStatus r101 = new IDoraService$Debug$FileTaskStatus(GXAnimation.STATE_START, 1);
        START = r101;
        IDoraService$Debug$FileTaskStatus r102 = new IDoraService$Debug$FileTaskStatus("RUNNING", 2);
        RUNNING = r102;
        IDoraService$Debug$FileTaskStatus r103 = new IDoraService$Debug$FileTaskStatus("PAUSED", 3);
        PAUSED = r103;
        IDoraService$Debug$FileTaskStatus r104 = new IDoraService$Debug$FileTaskStatus("UPLOADING", 4);
        UPLOADING = r104;
        IDoraService$Debug$FileTaskStatus r105 = new IDoraService$Debug$FileTaskStatus("DONE", 5);
        DONE = r105;
        IDoraService$Debug$FileTaskStatus r110 = new IDoraService$Debug$FileTaskStatus("FAILED", 6);
        FAILED = r110;
        IDoraService$Debug$FileTaskStatus r111 = new IDoraService$Debug$FileTaskStatus("CANCELED", 7);
        CANCELED = r111;
        IDoraService$Debug$FileTaskStatus[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f331722a = r112;
        f331723b = EnumEntriesKt.enumEntries(r112);
    }

    public static IDoraService$Debug$FileTaskStatus[] values() {
        return (IDoraService$Debug$FileTaskStatus[]) f331722a.clone();
    }

    public static IDoraService$Debug$FileTaskStatus valueOf(String r100) {
        return (IDoraService$Debug$FileTaskStatus) a.a(IDoraService$Debug$FileTaskStatus.class, r100);
    }

    public IDoraService$Debug$FileTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
