package com.larus.trace;

import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/trace/RealTimeNavEndReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARRIVE", "JSB", "STATUS_ERROR", "NEW_NAV", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealTimeNavEndReason extends Enum<RealTimeNavEndReason> {
    public static final RealTimeNavEndReason ARRIVE = null;
    public static final RealTimeNavEndReason JSB = null;
    public static final RealTimeNavEndReason NEW_NAV = null;
    public static final RealTimeNavEndReason STATUS_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeNavEndReason[] f370143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370144b = null;
    private final String value;

    public static EnumEntries<RealTimeNavEndReason> getEntries() {
        return f370144b;
    }

    static {
        RealTimeNavEndReason r100 = new RealTimeNavEndReason("ARRIVE", 0, "arrive");
        ARRIVE = r100;
        RealTimeNavEndReason r101 = new RealTimeNavEndReason("JSB", 1, PrefetchTiming.JSB);
        JSB = r101;
        RealTimeNavEndReason r102 = new RealTimeNavEndReason("STATUS_ERROR", 2, "status_error");
        STATUS_ERROR = r102;
        RealTimeNavEndReason r103 = new RealTimeNavEndReason("NEW_NAV", 3, "new_nav");
        NEW_NAV = r103;
        RealTimeNavEndReason[] r104 = {r100, r101, r102, r103};
        f370143a = r104;
        f370144b = EnumEntriesKt.enumEntries(r104);
    }

    public static RealTimeNavEndReason[] values() {
        return (RealTimeNavEndReason[]) f370143a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavEndReason valueOf(String r100) {
        return (RealTimeNavEndReason) a.a(RealTimeNavEndReason.class, r100);
    }

    public RealTimeNavEndReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
