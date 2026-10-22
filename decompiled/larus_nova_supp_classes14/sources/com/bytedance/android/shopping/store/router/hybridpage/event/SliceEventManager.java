package com.bytedance.android.shopping.store.router.hybridpage.event;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SliceEventManager {
    public static final ReentrantReadWriteLock a = null;
    public static final Lazy b = null;

    static {
        a = new ReentrantReadWriteLock();
        b = LazyKt.lazy(SliceEventManager$dListeners$2.INSTANCE);
    }

    public static void a(String r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        Intrinsics.checkNotNullParameter(r3, "block");
        ReentrantReadWriteLock.ReadLock r0 = a.readLock();
        r0.lock();
        Set r4 = (Set) ((Map) b.getValue()).get(r2);     // Catch: Throwable -> L13
        if (r4 == null) goto L7;
        List r5 = CollectionsKt.toList(r4);     // Catch: Throwable -> L13
        if (r5 == null) goto L7;
    L8:
        r0.unlock();
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r3.invoke((b) r6.next());
        goto L10
    L12:
        return;
    L7:
        r5 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static void b(String r1, final Map r2) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        a(r1, new SliceEventManager$onBindSliceDataSource$1(r2));
    }

    public static ECHybridListDTO c(String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        Intrinsics.checkNotNullParameter(r3, "hybridListId");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        a(r2, new SliceEventManager$onGetHybridListDTO$1(r0, r3));
        return (ECHybridListDTO) r0.element;
    }
}
