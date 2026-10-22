package com.bytedance.android.shopping.store.home.preload.resource;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.ExecutorType;
import com.bytedance.android.ec.store.utils.taskmanager.c;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreResourcePreloadManager {
    public static final Lazy c = null;
    public final ConcurrentHashMap<Integer, View> a;
    public final List<Integer> b;

    public static final class a {
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreResourcePreloadManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreResourcePreloadManager() {
        this.a = new ConcurrentHashMap();
        List<Integer> r0 = CollectionsKt.mutableListOf(new Integer[]{2131560937, 2131560961, 2131560944, 2131560964, 2131560963, 2131560945});
        r0.add(2131560864);
        r0.add(2131560924);
        r0.add(2131560956);
        r0.add(2131560867);
        r0.add(2131560906);
        r0.add(2131560943);
        r0.add(2131560962);
        r0.add(2131560965);
        r0.add(2131560861);
        r0.add(2131560894);
        Unit r1 = Unit.INSTANCE;
        this.b = r0;
    }

    public static boolean c(ECStoreParam r1, PageType r2) {
        if (r2 != PageType.ISV) goto L5;
    L14:
        return false;
    L5:
        if (r2 == PageType.FEATURED) goto L14;
        if (r1.getTabId() == null) goto L13;
        Integer r3 = r1.getTabId();
        if (r3 == null) goto L14;
        if (r3.intValue() != 3) goto L14;
    L13:
        return true;
    }

    public final View a(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r6 = this.a.remove(Integer.valueOf(r5));
        Context r0 = null;
        if (r6 == null) goto L5;
        Context r1 = r6.getContext();
    L7:
        if ((r1 instanceof MutableContextWrapper) == false) goto L10;
        r0 = r1;
    L10:
        MutableContextWrapper r2 = (MutableContextWrapper) r0;
        if (r2 == null) goto L13;
        r2.setBaseContext(new ContextThemeWrapper(r4, 2131952363));
    L13:
        return r6;
    L5:
        r1 = null;
        goto L7
    }

    public final void b(final Context r2, ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Lazy r4 = ECTaskManager.b;
        ECTaskManager r5 = ECTaskManager.a.a();
        Function0<Unit> r0 = new ECStoreResourcePreloadManager$loadCommonLayouts$1(this, r2);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "runnable");
        int r6 = c.c;
        c.b.a.a(ExecutorType.COMPUTE_HIGH_LEVEL, r0);
    }
}
