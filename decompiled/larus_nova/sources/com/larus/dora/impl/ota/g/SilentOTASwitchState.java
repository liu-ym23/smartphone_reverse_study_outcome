package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g/SilentOTASwitchState;", "", "<init>", "(Ljava/lang/String;I)V", "Unsupported", "On", "Off", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SilentOTASwitchState extends Enum<SilentOTASwitchState> {
    public static final SilentOTASwitchState Off = null;
    public static final SilentOTASwitchState On = null;
    public static final SilentOTASwitchState Unsupported = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SilentOTASwitchState[] f337529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337530b = null;

    public static EnumEntries<SilentOTASwitchState> getEntries() {
        return f337530b;
    }

    static {
        SilentOTASwitchState r100 = new SilentOTASwitchState("Unsupported", 0);
        Unsupported = r100;
        SilentOTASwitchState r101 = new SilentOTASwitchState("On", 1);
        On = r101;
        SilentOTASwitchState r102 = new SilentOTASwitchState("Off", 2);
        Off = r102;
        SilentOTASwitchState[] r103 = {r100, r101, r102};
        f337529a = r103;
        f337530b = EnumEntriesKt.enumEntries(r103);
    }

    public static SilentOTASwitchState[] values() {
        return (SilentOTASwitchState[]) f337529a.clone();
    }

    public static SilentOTASwitchState valueOf(String r100) {
        return (SilentOTASwitchState) r27.a.a(SilentOTASwitchState.class, r100);
    }

    public SilentOTASwitchState(String r100, int r101) {
        super(r100, r101);
    }
}
