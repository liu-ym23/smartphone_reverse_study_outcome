package com.obric.assistant.wakeup.co_wakeup.dora.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraSwitchState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ON", "OFF", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraSwitchState extends Enum<DoraSwitchState> {
    public static final DoraSwitchState NA = null;
    public static final DoraSwitchState OFF = null;
    public static final DoraSwitchState ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraSwitchState[] f394446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394447b = null;

    public static EnumEntries<DoraSwitchState> getEntries() {
        return f394447b;
    }

    static {
        DoraSwitchState r100 = new DoraSwitchState("NA", 0);
        NA = r100;
        DoraSwitchState r101 = new DoraSwitchState("ON", 1);
        ON = r101;
        DoraSwitchState r102 = new DoraSwitchState("OFF", 2);
        OFF = r102;
        DoraSwitchState[] r103 = {r100, r101, r102};
        f394446a = r103;
        f394447b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraSwitchState[] values() {
        return (DoraSwitchState[]) f394446a.clone();
    }

    public static DoraSwitchState valueOf(String r100) {
        return (DoraSwitchState) a.a(DoraSwitchState.class, r100);
    }

    public DoraSwitchState(String r100, int r101) {
        super(r100, r101);
    }
}
