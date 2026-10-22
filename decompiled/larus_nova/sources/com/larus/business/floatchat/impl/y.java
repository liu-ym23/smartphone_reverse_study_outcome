package com.larus.business.floatchat.impl;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<ew8.b>> f320458a = null;

    static {
        f320458a = new CopyOnWriteArrayList();
    }

    public static void a(final ew8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "messageLogicAbility");
        CollectionsKt.removeAll(f320458a, new x(r100));
        FLogger.f375446a.i("AIFloatChatWindowEventDispatcher", "unregister messageLogicAbility=".concat(r100.getClass().getSimpleName()));
    }
}
