package com.larus.dora.impl.device.settings.lab.env;

/* JADX INFO: loaded from: classes27.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f334704a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334705a = null;

        static {
            int[] r100 = new int[EnvObserveSettingAction.values().length];
            r100[EnvObserveSettingAction.ENV_SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[EnvObserveSettingAction.TIMER_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[EnvObserveSettingAction.START_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[EnvObserveSettingAction.END_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[EnvObserveSettingAction.CONFIG_REFRESH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[EnvObserveSettingAction.APP_FOREGROUND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[EnvObserveSettingAction.SCENE_CHANGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f334705a = r100;
        }
    }

    static {
    }
}
