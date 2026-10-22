package com.bytedance.android.shopping.store.router.hybridpage.event;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PageCardEventManager {
    public static final ReentrantReadWriteLock a = null;
    public static final Lazy b = null;

    static {
        a = new ReentrantReadWriteLock();
        b = LazyKt.lazy(PageCardEventManager$dListeners$2.INSTANCE);
    }

    public static void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        final String r1 = "ECShopHybridList";
        Intrinsics.checkNotNullParameter("ECShopHybridList", "hybridListId");
        a(r2, new PageCardEventManager$hybridListRequestLoadMore$1(r1));
    }

    public static void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        final String r1 = "createSearchSlicePageViewInfo return null";
        Intrinsics.checkNotNullParameter("createSearchSlicePageViewInfo return null", "errorMsg");
        a(r2, new PageCardEventManager$sliceLoadError$1(r1));
    }

    public static void l(String r1) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        a(r1, PageCardEventManager$viewDisappeared$1.INSTANCE);
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
        r3.invoke((a) r6.next());
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

    public static void i(String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        a(r1, new PageCardEventManager$sliceFinishLoad$1(r2));
    }

    public static void k(String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        a(r1, new PageCardEventManager$viewAppeared$1(r2));
    }

    public static void b(String r2, final Object r3, final String r4) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        final String r1 = "search";
        Intrinsics.checkNotNullParameter("search", "apiName");
        a(r2, new PageCardEventManager$firstScreenApiCompleted$1(r1, r3, r4));
    }

    public static void g(String r1, final String r2, final Map r3) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        a(r1, new PageCardEventManager$publishXEvent$1(r2, r3));
    }

    public static void h(String r1, final String r2, final String r3, final String r4) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        Intrinsics.checkNotNullParameter(r2, "searchQuery");
        Intrinsics.checkNotNullParameter(r3, "searchSource");
        Intrinsics.checkNotNullParameter(r4, "suggestGroupId");
        a(r1, new PageCardEventManager$searchResultSearch$1(r2, r3, r4));
    }

    public static void d(String r7, final String r8, final int r9, final int r10, final ECHybridListItemVO r11) {
        final int r2 = 2;
        Intrinsics.checkNotNullParameter(r7, "sceneId");
        Intrinsics.checkNotNullParameter(r8, "hybridListId");
        Intrinsics.checkNotNullParameter(r11, "itemModel");
        a(r7, new PageCardEventManager$hybridListCardDisappeared$1(r8, r2, r9, r10, r11));
    }

    public static void e(String r1, final String r2, final int r3, final int r4, final ECHybridListItemVO r5) {
        Intrinsics.checkNotNullParameter(r1, "sceneId");
        Intrinsics.checkNotNullParameter(r2, "hybridListId");
        Intrinsics.checkNotNullParameter(r5, "itemModel");
        a(r1, new PageCardEventManager$hybridListCardSelected$1(r2, r3, r4, r5));
    }

    public static void c(String r8, final String r9, final int r10, final int r11, final ECHybridListItemVO r12, final boolean r13) {
        final int r2 = 2;
        Intrinsics.checkNotNullParameter(r8, "sceneId");
        Intrinsics.checkNotNullParameter(r9, "hybridListId");
        Intrinsics.checkNotNullParameter(r12, "itemModel");
        a(r8, new PageCardEventManager$hybridListCardAppeared$1(r9, r2, r10, r11, r12, r13));
    }
}
