package com.larus.bmhome.chat.trace.appreciable;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f310107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Queue<String> f310108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f310109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f310110d = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            FLogger.f375446a.d("MessageSendFailureTracer", "app destroyed");
            Lazy r100 = b0.f310107a;
            b0.f310109c.clear();
            b0.f310110d.clear();
            ((LinkedList) b0.f310108b).clear();
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Object r102 = ((Pair) r100).getSecond();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            Object r103 = ((Pair) r101).getSecond();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
            return ComparisonsKt.compareValues((Integer) r102, (Integer) r103);
        }
    }

    static {
        f310107a = LazyKt.lazy(new a0());
        LinkedList r100 = new LinkedList();
        f310108b = r100;
        f310109c = new ConcurrentHashMap();
        f310110d = new ConcurrentHashMap();
        AppHost.f326268a.a().j(new a());
        if (r100.isEmpty() == false) goto L22;
        List r101 = MapsKt.toList(b().getAll());
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if ((((Pair) r104).getSecond() instanceof Integer) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        List r105 = CollectionsKt.sortedWith(r102, new b());
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r106.add((String) ((Pair) r107.next()).getFirst());
        goto L12
    L14:
        ((LinkedList) f310108b).addAll(r106);
        return;
    }

    public static Keva b() {
        return (Keva) f310107a.getValue();
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (b().getInt(r100, -1) == (-1)) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void c(String r100) {
        FLogger.f375446a.i("MessageSendFailureTracer", "onMessageResend，localMessageId=" + r100);
        b().erase(r100);
    }
}
