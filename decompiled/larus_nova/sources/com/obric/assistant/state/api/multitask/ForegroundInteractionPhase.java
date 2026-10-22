package com.obric.assistant.state.api.multitask;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Activate", "Connecting", "Listen", "Thinking", "Generating", "Generated", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForegroundInteractionPhase extends Enum<ForegroundInteractionPhase> {
    public static final ForegroundInteractionPhase Activate = null;
    public static final ForegroundInteractionPhase Connecting = null;
    public static final ForegroundInteractionPhase Generated = null;
    public static final ForegroundInteractionPhase Generating = null;
    public static final ForegroundInteractionPhase Idle = null;
    public static final ForegroundInteractionPhase Listen = null;
    public static final ForegroundInteractionPhase Thinking = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForegroundInteractionPhase[] f392939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392940b = null;

    public static EnumEntries<ForegroundInteractionPhase> getEntries() {
        return f392940b;
    }

    static {
        ForegroundInteractionPhase r100 = new ForegroundInteractionPhase("Idle", 0);
        Idle = r100;
        ForegroundInteractionPhase r101 = new ForegroundInteractionPhase("Activate", 1);
        Activate = r101;
        ForegroundInteractionPhase r102 = new ForegroundInteractionPhase("Connecting", 2);
        Connecting = r102;
        ForegroundInteractionPhase r103 = new ForegroundInteractionPhase("Listen", 3);
        Listen = r103;
        ForegroundInteractionPhase r104 = new ForegroundInteractionPhase("Thinking", 4);
        Thinking = r104;
        ForegroundInteractionPhase r105 = new ForegroundInteractionPhase("Generating", 5);
        Generating = r105;
        ForegroundInteractionPhase r110 = new ForegroundInteractionPhase("Generated", 6);
        Generated = r110;
        ForegroundInteractionPhase[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f392939a = r111;
        f392940b = EnumEntriesKt.enumEntries(r111);
    }

    public static ForegroundInteractionPhase[] values() {
        return (ForegroundInteractionPhase[]) f392939a.clone();
    }

    public static ForegroundInteractionPhase valueOf(String r100) {
        return (ForegroundInteractionPhase) a.a(ForegroundInteractionPhase.class, r100);
    }

    public ForegroundInteractionPhase(String r100, int r101) {
        super(r100, r101);
    }
}
