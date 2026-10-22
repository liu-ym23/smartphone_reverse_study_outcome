package com.bytedance.lbs.trace.contract;

import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import ye6.c;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/lbs/trace/contract/TraceLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARNING", "ERROR", "Companion", "bdlbs-trace_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum TraceLevel extends Enum<TraceLevel> {
    public static final a Companion = null;

    @SerialName("error")
    public static final TraceLevel ERROR = null;

    @SerialName("Info")
    public static final TraceLevel INFO = null;

    @SerialName("warning")
    public static final TraceLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>> f254479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TraceLevel[] f254480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254481c = null;

    public static final class a {
        public a() {
        }

        public final d<TraceLevel> serializer() {
            return (d) TraceLevel.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<TraceLevel> getEntries() {
        return f254481c;
    }

    static {
        TraceLevel r100 = new TraceLevel("INFO", 0);
        INFO = r100;
        TraceLevel r101 = new TraceLevel("WARNING", 1);
        WARNING = r101;
        TraceLevel r102 = new TraceLevel("ERROR", 2);
        ERROR = r102;
        TraceLevel[] r103 = {r100, r101, r102};
        f254480b = r103;
        f254481c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f254479a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c());
    }

    public static TraceLevel[] values() {
        return (TraceLevel[]) f254480b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f254479a;
    }

    public static TraceLevel valueOf(String r100) {
        return (TraceLevel) r27.a.a(TraceLevel.class, r100);
    }

    public TraceLevel(String r100, int r101) {
        super(r100, r101);
    }
}
