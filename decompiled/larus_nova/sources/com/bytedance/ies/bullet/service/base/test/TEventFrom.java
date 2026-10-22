package com.bytedance.ies.bullet.service.base.test;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/test/TEventFrom;", "", "NATIVE", "FRONT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TEventFrom extends Enum<TEventFrom> {
    public static final TEventFrom FRONT = null;
    public static final TEventFrom NATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TEventFrom[] f247913a = null;

    public static TEventFrom valueOf(String r100) {
        return (TEventFrom) a.a(TEventFrom.class, r100);
    }

    public static TEventFrom[] values() {
        return (TEventFrom[]) f247913a.clone();
    }

    static {
        TEventFrom r100 = new TEventFrom("NATIVE", 0);
        NATIVE = r100;
        TEventFrom r101 = new TEventFrom("FRONT", 1);
        FRONT = r101;
        f247913a = new TEventFrom[]{r100, r101};
    }

    public TEventFrom(String r100, int r101) {
        super(r100, r101);
    }
}
