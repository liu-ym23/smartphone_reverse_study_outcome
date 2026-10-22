package com.larus.voicecall.impl.component.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogTriggerTime;", "", "<init>", "(Ljava/lang/String;I)V", "ON_CALL_STARTED", "ON_COMMON_AUDIO_CONFIG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeDialogTriggerTime extends Enum<RealtimeDialogTriggerTime> {
    public static final RealtimeDialogTriggerTime ON_CALL_STARTED = null;
    public static final RealtimeDialogTriggerTime ON_COMMON_AUDIO_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeDialogTriggerTime[] f377420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377421b = null;

    public static EnumEntries<RealtimeDialogTriggerTime> getEntries() {
        return f377421b;
    }

    static {
        RealtimeDialogTriggerTime r100 = new RealtimeDialogTriggerTime("ON_CALL_STARTED", 0);
        ON_CALL_STARTED = r100;
        RealtimeDialogTriggerTime r101 = new RealtimeDialogTriggerTime("ON_COMMON_AUDIO_CONFIG", 1);
        ON_COMMON_AUDIO_CONFIG = r101;
        RealtimeDialogTriggerTime[] r102 = {r100, r101};
        f377420a = r102;
        f377421b = EnumEntriesKt.enumEntries(r102);
    }

    public static RealtimeDialogTriggerTime[] values() {
        return (RealtimeDialogTriggerTime[]) f377420a.clone();
    }

    public static RealtimeDialogTriggerTime valueOf(String r100) {
        return (RealtimeDialogTriggerTime) a.a(RealtimeDialogTriggerTime.class, r100);
    }

    public RealtimeDialogTriggerTime(String r100, int r101) {
        super(r100, r101);
    }
}
