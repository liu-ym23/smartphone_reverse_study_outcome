package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class WebFollowCursorDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f216493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CursorPosData f216494b;

    public interface a {
        void a(CursorPosData r100);
    }

    static {
        f216493a = new ArrayList();
    }

    public static void b() {
        CollectionsKt.removeAll(f216493a, WebFollowCursorDispatcher$removeAllListener$1.INSTANCE);
    }

    public static void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ArrayList<a> r101 = f216493a;
        a r102 = (a) CollectionsKt.lastOrNull(r101);
        if (r102 == null) goto L5;
        r102.a(new CursorPosData(Float.valueOf(0.0f), Float.valueOf(0.0f), true));
    L5:
        r101.remove(r100);
        r101.add(r100);
        CursorPosData r103 = f216494b;
        if (r103 == null) goto L9;
        r100.a(r103);
        return;
    }
}
