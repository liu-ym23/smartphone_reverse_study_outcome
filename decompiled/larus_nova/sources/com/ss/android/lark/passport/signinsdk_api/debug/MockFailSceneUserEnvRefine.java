package com.ss.android.lark.passport.signinsdk_api.debug;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MockFailSceneUserEnvRefine extends Enum<MockFailSceneUserEnvRefine> {
    public static final MockFailSceneUserEnvRefine CrossEnvSecond = null;
    public static final MockFailSceneUserEnvRefine NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MockFailSceneUserEnvRefine[] f438070a = null;

    static {
        MockFailSceneUserEnvRefine r100 = new MockFailSceneUserEnvRefine(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        MockFailSceneUserEnvRefine r101 = new MockFailSceneUserEnvRefine("CrossEnvSecond", 1);
        CrossEnvSecond = r101;
        f438070a = new MockFailSceneUserEnvRefine[]{r100, r101};
    }

    public static MockFailSceneUserEnvRefine[] values() {
        return (MockFailSceneUserEnvRefine[]) f438070a.clone();
    }

    public static MockFailSceneUserEnvRefine valueOf(String r100) {
        return (MockFailSceneUserEnvRefine) a.a(MockFailSceneUserEnvRefine.class, r100);
    }

    public MockFailSceneUserEnvRefine(String r100, int r101) {
        super(r100, r101);
    }
}
