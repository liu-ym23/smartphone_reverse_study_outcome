package com.larus.av_call.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/av_call/model/RealtimePageMode;", "", "<init>", "(Ljava/lang/String;I)V", "HALF_SCREEN", "FULL_SCREEN", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimePageMode extends Enum<RealtimePageMode> {
    public static final RealtimePageMode FULL_SCREEN = null;
    public static final RealtimePageMode HALF_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimePageMode[] f290563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290564b = null;

    public static EnumEntries<RealtimePageMode> getEntries() {
        return f290564b;
    }

    static {
        RealtimePageMode r100 = new RealtimePageMode("HALF_SCREEN", 0);
        HALF_SCREEN = r100;
        RealtimePageMode r101 = new RealtimePageMode("FULL_SCREEN", 1);
        FULL_SCREEN = r101;
        RealtimePageMode[] r102 = {r100, r101};
        f290563a = r102;
        f290564b = EnumEntriesKt.enumEntries(r102);
    }

    public static RealtimePageMode[] values() {
        return (RealtimePageMode[]) f290563a.clone();
    }

    public static RealtimePageMode valueOf(String r100) {
        return (RealtimePageMode) a.a(RealtimePageMode.class, r100);
    }

    public RealtimePageMode(String r100, int r101) {
        super(r100, r101);
    }
}
