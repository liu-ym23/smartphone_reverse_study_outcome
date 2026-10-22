package com.ss.android.lark.passport.signinsdk_api.debug;

import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MockModeUserEnvRefine extends Enum<MockModeUserEnvRefine> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MockModeUserEnvRefine[] f438071a = null;
    public static final MockModeUserEnvRefine failForApplogDomain = null;
    public static final MockModeUserEnvRefine failForFetchDidByUnit = null;
    public static final MockModeUserEnvRefine failForRustOffline = null;
    public static final MockModeUserEnvRefine failForRustOnline = null;
    public static final MockModeUserEnvRefine failForRustSetDeviceInfo = null;
    public static final MockModeUserEnvRefine failForRustSetEnv = null;
    public static final MockModeUserEnvRefine failForSwitchIdentify = null;

    static {
        MockModeUserEnvRefine r100 = new MockModeUserEnvRefine("failForApplogDomain", 0);
        failForApplogDomain = r100;
        MockModeUserEnvRefine r101 = new MockModeUserEnvRefine("failForFetchDidByUnit", 1);
        failForFetchDidByUnit = r101;
        MockModeUserEnvRefine r102 = new MockModeUserEnvRefine("failForSwitchIdentify", 2);
        failForSwitchIdentify = r102;
        MockModeUserEnvRefine r103 = new MockModeUserEnvRefine("failForRustOffline", 3);
        failForRustOffline = r103;
        MockModeUserEnvRefine r104 = new MockModeUserEnvRefine("failForRustSetEnv", 4);
        failForRustSetEnv = r104;
        MockModeUserEnvRefine r105 = new MockModeUserEnvRefine("failForRustSetDeviceInfo", 5);
        failForRustSetDeviceInfo = r105;
        MockModeUserEnvRefine r110 = new MockModeUserEnvRefine("failForRustOnline", 6);
        failForRustOnline = r110;
        f438071a = new MockModeUserEnvRefine[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static MockModeUserEnvRefine[] values() {
        return (MockModeUserEnvRefine[]) f438071a.clone();
    }

    public static MockModeUserEnvRefine valueOf(String r100) {
        return (MockModeUserEnvRefine) a.a(MockModeUserEnvRefine.class, r100);
    }

    public MockModeUserEnvRefine(String r100, int r101) {
        super(r100, r101);
    }
}
