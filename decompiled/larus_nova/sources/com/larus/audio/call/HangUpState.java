package com.larus.audio.call;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/call/HangUpState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAIT_LAST_AUDIO", "SEND_EVENT", "FINISH", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HangUpState extends Enum<HangUpState> {
    public static final HangUpState FINISH = null;
    public static final HangUpState IDLE = null;
    public static final HangUpState SEND_EVENT = null;
    public static final HangUpState WAIT_LAST_AUDIO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HangUpState[] f288732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288733b = null;

    public static EnumEntries<HangUpState> getEntries() {
        return f288733b;
    }

    static {
        HangUpState r100 = new HangUpState("IDLE", 0);
        IDLE = r100;
        HangUpState r101 = new HangUpState("WAIT_LAST_AUDIO", 1);
        WAIT_LAST_AUDIO = r101;
        HangUpState r102 = new HangUpState("SEND_EVENT", 2);
        SEND_EVENT = r102;
        HangUpState r103 = new HangUpState("FINISH", 3);
        FINISH = r103;
        HangUpState[] r104 = {r100, r101, r102, r103};
        f288732a = r104;
        f288733b = EnumEntriesKt.enumEntries(r104);
    }

    public static HangUpState[] values() {
        return (HangUpState[]) f288732a.clone();
    }

    public static HangUpState valueOf(String r100) {
        return (HangUpState) r27.a.a(HangUpState.class, r100);
    }

    public HangUpState(String r100, int r101) {
        super(r100, r101);
    }
}
