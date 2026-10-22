package com.ss.android.lark.appreciablelib;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/appreciablelib/CacheStatus;", "", "STARTED", "PAUSED", "RESUMED", GXAnimation.STATE_END, "appreciablelib_release"}, k = 1, mv = {1, 4, 0})
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus END = null;
    public static final CacheStatus PAUSED = null;
    public static final CacheStatus RESUMED = null;
    public static final CacheStatus STARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStatus[] f408928a = null;

    static {
        CacheStatus r100 = new CacheStatus("STARTED", 0);
        STARTED = r100;
        CacheStatus r101 = new CacheStatus("PAUSED", 1);
        PAUSED = r101;
        CacheStatus r102 = new CacheStatus("RESUMED", 2);
        RESUMED = r102;
        CacheStatus r103 = new CacheStatus(GXAnimation.STATE_END, 3);
        END = r103;
        f408928a = new CacheStatus[]{r100, r101, r102, r103};
    }

    public static CacheStatus valueOf(String r100) {
        return (CacheStatus) a.a(CacheStatus.class, r100);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) f408928a.clone();
    }

    public CacheStatus(String r100, int r101) {
        super(r100, r101);
    }
}
