package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.luckycat.impl.lynx.Statistics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class i<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f271266j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Statistics f271267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f271268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f271269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f271270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f271271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>> f271272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Function1<T, Unit>> f271273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Function1<d, Unit>> f271274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>, Unit> f271275i;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        List<com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>> r100 = this.f271272f;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a r102 = (com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a) r101.next();
        boolean r103 = r102.b();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("WaitTask", r102.d() + " is ready? " + r103);
        if (r103 == true) goto L9;
        return false;
    L13:
        return true;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public final void c(Statistics.Action r100) {
        this.f271268b.set(false);
        Iterator<T> r101 = this.f271272f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a) r101.next()).g();
        goto L4
    L6:
        Statistics r102 = this.f271267a;
        if (r102 == null) goto L11;
        r102.a(r100);
        return;
    }

    public final void a(final c r110, final Statistics r111) {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("WaitTask", "start wait task");
        j r101 = new j(this, r100);
        List<com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>> r102 = this.f271272f;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(((com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a) r104.next()).d());
        goto L4
    L6:
        Object[] r105 = r103.toArray(new String[0]);
        if (r105 == null) goto L14;
        String[] r106 = (String[]) r105;
        final b r107 = new b(r101, (String[]) Arrays.copyOf(r106, r106.length));
        Iterator<T> r108 = this.f271272f.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        final com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a r112 = (com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a) r108.next();
        r112.f271252b = new LynxWaitQueue$doStartLocked$$inlined$forEach$lambda$1(r112, this, r111, r107, r100, r110);
        new LynxWaitQueue$doStartLocked$$inlined$forEach$lambda$2(r112, this, r111, r107, r100, r110);
        r112.f271251a = new LynxWaitQueue$doStartLocked$$inlined$forEach$lambda$3(r112, this, r111, r107, r100, r110);
        r112.f(r110);
        goto L10
    L12:
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>> r100, List<? extends Function1<? super T, Unit>> r101, List<? extends Function1<? super d, Unit>> r102, Function1<? super Integer, Unit> r103, Function1<? super com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a<T>, Unit> r104) {
        this.f271272f = r100;
        this.f271273g = r101;
        this.f271274h = r102;
        this.f271275i = r104;
        this.f271268b = new AtomicBoolean(false);
        this.f271269c = new l(r100.size(), r103);
        this.f271271e = new Handler(Looper.getMainLooper());
    }
}
