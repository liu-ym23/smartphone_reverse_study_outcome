package com.larus.dora.impl.device.settings.lab.env.override;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/override/EnvObserveWearState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "WORN", "UNWORN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveWearState extends Enum<EnvObserveWearState> {
    public static final EnvObserveWearState UNKNOWN = null;
    public static final EnvObserveWearState UNWORN = null;
    public static final EnvObserveWearState WORN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvObserveWearState[] f334627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334628b = null;

    public static EnumEntries<EnvObserveWearState> getEntries() {
        return f334628b;
    }

    static {
        EnvObserveWearState r100 = new EnvObserveWearState("UNKNOWN", 0);
        UNKNOWN = r100;
        EnvObserveWearState r101 = new EnvObserveWearState("WORN", 1);
        WORN = r101;
        EnvObserveWearState r102 = new EnvObserveWearState("UNWORN", 2);
        UNWORN = r102;
        EnvObserveWearState[] r103 = {r100, r101, r102};
        f334627a = r103;
        f334628b = EnumEntriesKt.enumEntries(r103);
    }

    public static EnvObserveWearState[] values() {
        return (EnvObserveWearState[]) f334627a.clone();
    }

    public static EnvObserveWearState valueOf(String r100) {
        return (EnvObserveWearState) a.a(EnvObserveWearState.class, r100);
    }

    public EnvObserveWearState(String r100, int r101) {
        super(r100, r101);
    }
}
