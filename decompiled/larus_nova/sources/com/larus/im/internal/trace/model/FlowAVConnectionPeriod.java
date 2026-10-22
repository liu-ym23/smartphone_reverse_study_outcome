package com.larus.im.internal.trace.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/trace/model/FlowAVConnectionPeriod;", "", "<init>", "(Ljava/lang/String;I)V", "Connection", "Calling", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAVConnectionPeriod extends Enum<FlowAVConnectionPeriod> {
    public static final FlowAVConnectionPeriod Calling = null;
    public static final FlowAVConnectionPeriod Connection = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAVConnectionPeriod[] f350161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350162b = null;

    public static EnumEntries<FlowAVConnectionPeriod> getEntries() {
        return f350162b;
    }

    static {
        FlowAVConnectionPeriod r100 = new FlowAVConnectionPeriod("Connection", 0);
        Connection = r100;
        FlowAVConnectionPeriod r101 = new FlowAVConnectionPeriod("Calling", 1);
        Calling = r101;
        FlowAVConnectionPeriod[] r102 = {r100, r101};
        f350161a = r102;
        f350162b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowAVConnectionPeriod[] values() {
        return (FlowAVConnectionPeriod[]) f350161a.clone();
    }

    public static FlowAVConnectionPeriod valueOf(String r100) {
        return (FlowAVConnectionPeriod) a.a(FlowAVConnectionPeriod.class, r100);
    }

    public FlowAVConnectionPeriod(String r100, int r101) {
        super(r100, r101);
    }
}
