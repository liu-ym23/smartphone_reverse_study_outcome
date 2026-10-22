package com.bytedance.lark.policy.event;

import com.bytedance.lark.policy.utils.Logger;
import java.util.concurrent.CopyOnWriteArraySet;
import ke6.d;
import kotlin.jvm.internal.Intrinsics;
import ne6.e;

/* JADX INFO: loaded from: classes20.dex */
public final class EventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f253801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f253802b = null;

    static {
        f253801a = new CopyOnWriteArraySet();
        f253802b = new CopyOnWriteArraySet();
    }

    public static void a(final Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = Logger.f253883a;
        Logger.c("EventManager", "on event: " + r100);
        d.f503032a.getClass();
        e r102 = d.d();
        if (r102 == null) goto L6;
        r102.c(new EventManager$postEvent$1(r100));
        return;
    }

    public static void b(final InnerEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "innerEvent");
        int r101 = Logger.f253883a;
        Logger.c("EventManager", "on inner event: " + r100);
        d.f503032a.getClass();
        e r102 = d.d();
        if (r102 == null) goto L6;
        r102.c(new EventManager$postInnerEvent$1(r100));
        return;
    }
}
