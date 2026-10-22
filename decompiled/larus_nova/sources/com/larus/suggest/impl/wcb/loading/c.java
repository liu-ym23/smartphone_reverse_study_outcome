package com.larus.suggest.impl.wcb.loading;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, b> f369948a = null;

    static {
        f369948a = new ConcurrentHashMap();
    }

    public static b a(long r100) {
        return f369948a.get(Long.valueOf(r100));
    }

    public static boolean b(long r100, long r101) {
    L2:
        ConcurrentHashMap<Long, b> r102 = f369948a;
        b r103 = r102.get(Long.valueOf(r100));
        if (r103 == null) goto L4;
        if (r103.f369934b != r101) goto L7;
        if (r102.remove(Long.valueOf(r100), r103) == false) goto L2;
        r103.f369947o.complete(Unit.INSTANCE);
        return true;
    L7:
        return false;
    L4:
        return false;
    }
}
