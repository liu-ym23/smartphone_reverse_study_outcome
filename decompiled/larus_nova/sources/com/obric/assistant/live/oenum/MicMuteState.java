package com.obric.assistant.live.oenum;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/live/oenum/MicMuteState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "UNMUTE", "MUTE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MicMuteState extends Enum<MicMuteState> {
    public static final MicMuteState MUTE = null;
    public static final MicMuteState NA = null;
    public static final MicMuteState UNMUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MicMuteState[] f390154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390155b = null;

    public static EnumEntries<MicMuteState> getEntries() {
        return f390155b;
    }

    static {
        MicMuteState r100 = new MicMuteState("NA", 0);
        NA = r100;
        MicMuteState r101 = new MicMuteState("UNMUTE", 1);
        UNMUTE = r101;
        MicMuteState r102 = new MicMuteState("MUTE", 2);
        MUTE = r102;
        MicMuteState[] r103 = {r100, r101, r102};
        f390154a = r103;
        f390155b = EnumEntriesKt.enumEntries(r103);
    }

    public static MicMuteState[] values() {
        return (MicMuteState[]) f390154a.clone();
    }

    public static MicMuteState valueOf(String r100) {
        return (MicMuteState) a.a(MicMuteState.class, r100);
    }

    public MicMuteState(String r100, int r101) {
        super(r100, r101);
    }
}
