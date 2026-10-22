package com.larksuite.framework.launch.task;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum LaunchMode extends Enum<LaunchMode> {
    public static final LaunchMode ALL = null;
    public static final LaunchMode NORMAL = null;
    public static final LaunchMode SIMPLE = null;
    public static final LaunchMode UNAUTHORIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchMode[] f285671a = null;
    private int value;

    static {
        LaunchMode r100 = new LaunchMode(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        LaunchMode r101 = new LaunchMode("SIMPLE", 1, 1);
        SIMPLE = r101;
        LaunchMode r102 = new LaunchMode("UNAUTHORIZED", 2, 2);
        UNAUTHORIZED = r102;
        LaunchMode r103 = new LaunchMode(AccountType.ALL, 3, 3);
        ALL = r103;
        f285671a = new LaunchMode[]{r100, r101, r102, r103};
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) f285671a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static LaunchMode forNumber(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return NORMAL;
    L11:
        return ALL;
    L13:
        return SIMPLE;
    L15:
        return UNAUTHORIZED;
    }

    public static LaunchMode valueOf(String r100) {
        return (LaunchMode) a.a(LaunchMode.class, r100);
    }

    public LaunchMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
