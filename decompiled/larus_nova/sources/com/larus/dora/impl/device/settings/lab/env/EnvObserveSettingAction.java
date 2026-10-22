package com.larus.dora.impl.device.settings.lab.env;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveSettingAction;", "", "<init>", "(Ljava/lang/String;I)V", "ENV_SWITCH", "TIMER_SWITCH", "START_TIME", "END_TIME", "CONFIG_REFRESH", "APP_FOREGROUND", "SCENE_CHANGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveSettingAction extends Enum<EnvObserveSettingAction> {
    public static final EnvObserveSettingAction APP_FOREGROUND = null;
    public static final EnvObserveSettingAction CONFIG_REFRESH = null;
    public static final EnvObserveSettingAction END_TIME = null;
    public static final EnvObserveSettingAction ENV_SWITCH = null;
    public static final EnvObserveSettingAction SCENE_CHANGE = null;
    public static final EnvObserveSettingAction START_TIME = null;
    public static final EnvObserveSettingAction TIMER_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvObserveSettingAction[] f334610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334611b = null;

    public static EnumEntries<EnvObserveSettingAction> getEntries() {
        return f334611b;
    }

    static {
        EnvObserveSettingAction r100 = new EnvObserveSettingAction("ENV_SWITCH", 0);
        ENV_SWITCH = r100;
        EnvObserveSettingAction r101 = new EnvObserveSettingAction("TIMER_SWITCH", 1);
        TIMER_SWITCH = r101;
        EnvObserveSettingAction r102 = new EnvObserveSettingAction("START_TIME", 2);
        START_TIME = r102;
        EnvObserveSettingAction r103 = new EnvObserveSettingAction("END_TIME", 3);
        END_TIME = r103;
        EnvObserveSettingAction r104 = new EnvObserveSettingAction("CONFIG_REFRESH", 4);
        CONFIG_REFRESH = r104;
        EnvObserveSettingAction r105 = new EnvObserveSettingAction("APP_FOREGROUND", 5);
        APP_FOREGROUND = r105;
        EnvObserveSettingAction r110 = new EnvObserveSettingAction("SCENE_CHANGE", 6);
        SCENE_CHANGE = r110;
        EnvObserveSettingAction[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f334610a = r111;
        f334611b = EnumEntriesKt.enumEntries(r111);
    }

    public static EnvObserveSettingAction[] values() {
        return (EnvObserveSettingAction[]) f334610a.clone();
    }

    public static EnvObserveSettingAction valueOf(String r100) {
        return (EnvObserveSettingAction) r27.a.a(EnvObserveSettingAction.class, r100);
    }

    public EnvObserveSettingAction(String r100, int r101) {
        super(r100, r101);
    }
}
