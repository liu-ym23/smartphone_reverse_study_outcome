package com.obric.assistant.remote_card_container.manager;

import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<a> f391288a = null;

    public interface a {
        void a(String r100);
    }

    static {
        f391288a = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(final String r100, final String r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "cardUri");
        p9a.e r103 = p9a.b.f528329a;
        p9a.b.a("CardChangeListener", "notifyCardChanged: cardUri = " + r100 + ", extraParams = " + r101 + ", updateExtraParams = " + r102);
        CardCacheManager r104 = CardCacheManager.f391235a;
        Runnable r105 = new com.obric.assistant.remote_card_container.manager.a(r100, r102, r101);
        Intrinsics.checkNotNullParameter(r105, "action");
        monitor-enter(r104);
        r105.run();     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r104);
        Iterator<T> r107 = f391288a.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        ((a) r107.next()).a(r100);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
