package com.obric.assistant.view.continuespeech;

import com.mammon.audiosdk.session.type.RequestEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/view/continuespeech/RealtimeCallLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "SpeechStarted", "Thingking", "QueryRejected", "TTSEnd", RequestEvent.FinishSession, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeCallLifeState extends Enum<RealtimeCallLifeState> {
    public static final RealtimeCallLifeState FinishSession = null;
    public static final RealtimeCallLifeState QueryRejected = null;
    public static final RealtimeCallLifeState SpeechStarted = null;
    public static final RealtimeCallLifeState TTSEnd = null;
    public static final RealtimeCallLifeState Thingking = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeCallLifeState[] f394116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394117b = null;

    public static EnumEntries<RealtimeCallLifeState> getEntries() {
        return f394117b;
    }

    static {
        RealtimeCallLifeState r100 = new RealtimeCallLifeState("SpeechStarted", 0);
        SpeechStarted = r100;
        RealtimeCallLifeState r101 = new RealtimeCallLifeState("Thingking", 1);
        Thingking = r101;
        RealtimeCallLifeState r102 = new RealtimeCallLifeState("QueryRejected", 2);
        QueryRejected = r102;
        RealtimeCallLifeState r103 = new RealtimeCallLifeState("TTSEnd", 3);
        TTSEnd = r103;
        RealtimeCallLifeState r104 = new RealtimeCallLifeState(RequestEvent.FinishSession, 4);
        FinishSession = r104;
        RealtimeCallLifeState[] r105 = {r100, r101, r102, r103, r104};
        f394116a = r105;
        f394117b = EnumEntriesKt.enumEntries(r105);
    }

    public static RealtimeCallLifeState[] values() {
        return (RealtimeCallLifeState[]) f394116a.clone();
    }

    public static RealtimeCallLifeState valueOf(String r100) {
        return (RealtimeCallLifeState) r27.a.a(RealtimeCallLifeState.class, r100);
    }

    public RealtimeCallLifeState(String r100, int r101) {
        super(r100, r101);
    }
}
