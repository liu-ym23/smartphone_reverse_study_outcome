package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "", "<init>", "(Ljava/lang/String;I)V", "BUSINESS", "MESSAGE", "STREAM", "DEEP_THINK", "COMPLEX_TASK", "TTS", "CLICK_TALK", "REALTIME_CALL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModeRefreshSource extends Enum<ModeRefreshSource> {
    public static final ModeRefreshSource BUSINESS = null;
    public static final ModeRefreshSource CLICK_TALK = null;
    public static final ModeRefreshSource COMPLEX_TASK = null;
    public static final ModeRefreshSource DEEP_THINK = null;
    public static final ModeRefreshSource MESSAGE = null;
    public static final ModeRefreshSource REALTIME_CALL = null;
    public static final ModeRefreshSource STREAM = null;
    public static final ModeRefreshSource TTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModeRefreshSource[] f392953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392954b = null;

    public static EnumEntries<ModeRefreshSource> getEntries() {
        return f392954b;
    }

    static {
        ModeRefreshSource r100 = new ModeRefreshSource("BUSINESS", 0);
        BUSINESS = r100;
        ModeRefreshSource r101 = new ModeRefreshSource("MESSAGE", 1);
        MESSAGE = r101;
        ModeRefreshSource r102 = new ModeRefreshSource("STREAM", 2);
        STREAM = r102;
        ModeRefreshSource r103 = new ModeRefreshSource("DEEP_THINK", 3);
        DEEP_THINK = r103;
        ModeRefreshSource r104 = new ModeRefreshSource("COMPLEX_TASK", 4);
        COMPLEX_TASK = r104;
        ModeRefreshSource r105 = new ModeRefreshSource("TTS", 5);
        TTS = r105;
        ModeRefreshSource r110 = new ModeRefreshSource("CLICK_TALK", 6);
        CLICK_TALK = r110;
        ModeRefreshSource r111 = new ModeRefreshSource("REALTIME_CALL", 7);
        REALTIME_CALL = r111;
        ModeRefreshSource[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f392953a = r112;
        f392954b = EnumEntriesKt.enumEntries(r112);
    }

    public static ModeRefreshSource[] values() {
        return (ModeRefreshSource[]) f392953a.clone();
    }

    public static ModeRefreshSource valueOf(String r100) {
        return (ModeRefreshSource) a.a(ModeRefreshSource.class, r100);
    }

    public ModeRefreshSource(String r100, int r101) {
        super(r100, r101);
    }
}
