package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WebFollowCursorDispatcher {
    public static final ArrayList<a> a = null;
    public static CursorPosData b;

    public interface a {
        void a(CursorPosData r1);
    }

    static {
        a = new ArrayList();
    }

    public static void b() {
        CollectionsKt.removeAll(a, WebFollowCursorDispatcher$removeAllListener$1.INSTANCE);
    }

    public static void a(a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        ArrayList<a> r0 = a;
        a r1 = (a) CollectionsKt.lastOrNull(r0);
        if (r1 == null) goto L5;
        r1.a(new CursorPosData(Float.valueOf(0.0f), Float.valueOf(0.0f), true));
    L5:
        r0.remove(r6);
        r0.add(r6);
        CursorPosData r2 = b;
        if (r2 == null) goto L9;
        r6.a(r2);
        return;
    }
}
