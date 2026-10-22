package com.bytedance.ies.util.thread;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ApiThread$Priority extends Enum<ApiThread$Priority> {
    public static final ApiThread$Priority HIGH = null;
    public static final ApiThread$Priority IMMEDIATE = null;
    public static final ApiThread$Priority LOW = null;
    public static final ApiThread$Priority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApiThread$Priority[] f249250a = null;

    static {
        ApiThread$Priority r100 = new ApiThread$Priority("LOW", 0);
        LOW = r100;
        ApiThread$Priority r101 = new ApiThread$Priority(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        ApiThread$Priority r102 = new ApiThread$Priority("HIGH", 2);
        HIGH = r102;
        ApiThread$Priority r103 = new ApiThread$Priority("IMMEDIATE", 3);
        IMMEDIATE = r103;
        f249250a = new ApiThread$Priority[]{r100, r101, r102, r103};
    }

    public static ApiThread$Priority[] values() {
        return (ApiThread$Priority[]) f249250a.clone();
    }

    public static ApiThread$Priority valueOf(String r100) {
        return (ApiThread$Priority) a.a(ApiThread$Priority.class, r100);
    }

    public ApiThread$Priority(String r100, int r101) {
        super(r100, r101);
    }
}
