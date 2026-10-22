package com.larus.dora.impl.device.settings.lab.env.override;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/override/EnvObserveOverrideChangeReason;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVATED", "EXPIRED", "CONNECTION", "USER_SETTING", "UNWORN_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveOverrideChangeReason extends Enum<EnvObserveOverrideChangeReason> {
    public static final EnvObserveOverrideChangeReason ACTIVATED = null;
    public static final EnvObserveOverrideChangeReason CONNECTION = null;
    public static final EnvObserveOverrideChangeReason EXPIRED = null;
    public static final EnvObserveOverrideChangeReason UNWORN_TIMEOUT = null;
    public static final EnvObserveOverrideChangeReason USER_SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvObserveOverrideChangeReason[] f334625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334626b = null;

    public static EnumEntries<EnvObserveOverrideChangeReason> getEntries() {
        return f334626b;
    }

    static {
        EnvObserveOverrideChangeReason r100 = new EnvObserveOverrideChangeReason("ACTIVATED", 0);
        ACTIVATED = r100;
        EnvObserveOverrideChangeReason r101 = new EnvObserveOverrideChangeReason("EXPIRED", 1);
        EXPIRED = r101;
        EnvObserveOverrideChangeReason r102 = new EnvObserveOverrideChangeReason("CONNECTION", 2);
        CONNECTION = r102;
        EnvObserveOverrideChangeReason r103 = new EnvObserveOverrideChangeReason("USER_SETTING", 3);
        USER_SETTING = r103;
        EnvObserveOverrideChangeReason r104 = new EnvObserveOverrideChangeReason("UNWORN_TIMEOUT", 4);
        UNWORN_TIMEOUT = r104;
        EnvObserveOverrideChangeReason[] r105 = {r100, r101, r102, r103, r104};
        f334625a = r105;
        f334626b = EnumEntriesKt.enumEntries(r105);
    }

    public static EnvObserveOverrideChangeReason[] values() {
        return (EnvObserveOverrideChangeReason[]) f334625a.clone();
    }

    public static EnvObserveOverrideChangeReason valueOf(String r100) {
        return (EnvObserveOverrideChangeReason) a.a(EnvObserveOverrideChangeReason.class, r100);
    }

    public EnvObserveOverrideChangeReason(String r100, int r101) {
        super(r100, r101);
    }
}
