package com.larus.voicecall.impl.component.interview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/component/interview/RealtimeInterviewPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Initialized", "Preparing", "Planning", "Interviewing", "Error", "Ended", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeInterviewPhase extends Enum<RealtimeInterviewPhase> {
    public static final RealtimeInterviewPhase Ended = null;
    public static final RealtimeInterviewPhase Error = null;
    public static final RealtimeInterviewPhase Initialized = null;
    public static final RealtimeInterviewPhase Interviewing = null;
    public static final RealtimeInterviewPhase Planning = null;
    public static final RealtimeInterviewPhase Preparing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeInterviewPhase[] f377536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377537b = null;

    public static EnumEntries<RealtimeInterviewPhase> getEntries() {
        return f377537b;
    }

    static {
        RealtimeInterviewPhase r100 = new RealtimeInterviewPhase("Initialized", 0);
        Initialized = r100;
        RealtimeInterviewPhase r101 = new RealtimeInterviewPhase("Preparing", 1);
        Preparing = r101;
        RealtimeInterviewPhase r102 = new RealtimeInterviewPhase("Planning", 2);
        Planning = r102;
        RealtimeInterviewPhase r103 = new RealtimeInterviewPhase("Interviewing", 3);
        Interviewing = r103;
        RealtimeInterviewPhase r104 = new RealtimeInterviewPhase("Error", 4);
        Error = r104;
        RealtimeInterviewPhase r105 = new RealtimeInterviewPhase("Ended", 5);
        Ended = r105;
        RealtimeInterviewPhase[] r110 = {r100, r101, r102, r103, r104, r105};
        f377536a = r110;
        f377537b = EnumEntriesKt.enumEntries(r110);
    }

    public static RealtimeInterviewPhase[] values() {
        return (RealtimeInterviewPhase[]) f377536a.clone();
    }

    public static RealtimeInterviewPhase valueOf(String r100) {
        return (RealtimeInterviewPhase) a.a(RealtimeInterviewPhase.class, r100);
    }

    public RealtimeInterviewPhase(String r100, int r101) {
        super(r100, r101);
    }
}
