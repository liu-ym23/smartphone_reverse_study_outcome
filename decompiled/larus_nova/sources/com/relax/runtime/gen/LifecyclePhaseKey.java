package com.relax.runtime.gen;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum LifecyclePhaseKey extends Enum<LifecyclePhaseKey> {
    public static final LifecyclePhaseKey OnBackground = null;
    public static final LifecyclePhaseKey OnDestroy = null;
    public static final LifecyclePhaseKey OnForeground = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LifecyclePhaseKey[] f405692a = null;
    private final int mValue;

    public static String LifecyclePhaseKeyToString(int r100) {
        if (r100 != 1) goto L5;
        return "onForeground";
    L5:
        if (r100 != 2) goto L7;
        return "onBackground";
    L7:
        if (r100 == 3) goto L10;
        return "";
    L10:
        return LiveCommonConstants.REASON_ON_DEDTROY;
    }

    static {
        LifecyclePhaseKey r100 = new LifecyclePhaseKey("OnForeground", 0, 1);
        OnForeground = r100;
        LifecyclePhaseKey r101 = new LifecyclePhaseKey("OnBackground", 1, 2);
        OnBackground = r101;
        LifecyclePhaseKey r102 = new LifecyclePhaseKey("OnDestroy", 2, 3);
        OnDestroy = r102;
        f405692a = new LifecyclePhaseKey[]{r100, r101, r102};
    }

    public static LifecyclePhaseKey[] values() {
        return (LifecyclePhaseKey[]) f405692a.clone();
    }

    public int getValue() {
        return this.mValue;
    }

    public static LifecyclePhaseKey valueOf(String r100) {
        return (LifecyclePhaseKey) a.a(LifecyclePhaseKey.class, r100);
    }

    public LifecyclePhaseKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
