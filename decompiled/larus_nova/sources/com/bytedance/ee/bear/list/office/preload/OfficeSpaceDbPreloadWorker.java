package com.bytedance.ee.bear.list.office.preload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.DevEnvUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mc5.u1;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeSpaceDbPreloadWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f229096a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f229097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f229098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f229099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<b> f229100d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f229097a == r101.f229097a) goto L12;
            return false;
        L12:
            if (this.f229098b == r101.f229098b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f229099c, r101.f229099c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f229100d, r101.f229100d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f229097a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f229098b) * 31;
            String r102 = this.f229099c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return ((r101 + r103) * 31) + this.f229100d.hashCode();
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(success=" + this.f229097a + ", size=" + this.f229098b + ", errorCode=" + this.f229099c + ", tabResults=" + this.f229100d + ')';
        }

        public a(boolean r100, int r101, String r102, List<b> r103) {
            Intrinsics.checkNotNullParameter(r103, "tabResults");
            this.f229097a = r100;
            this.f229098b = r101;
            this.f229099c = r102;
            this.f229100d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f229101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f229102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f229103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f229104d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f229101a, r101.f229101a) == true) goto L12;
            return false;
        L12:
            if (this.f229102b == r101.f229102b) goto L15;
            return false;
        L15:
            if (this.f229103c == r101.f229103c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f229104d, r101.f229104d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f229101a.hashCode() * 31;
            if (this.f229102b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f229103c) * 31;
            String r103 = this.f229104d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "TabResult(tab=" + this.f229101a + ", success=" + this.f229102b + ", size=" + this.f229103c + ", errorCode=" + this.f229104d + ')';
        }

        public b(String r100, boolean r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            this.f229101a = r100;
            this.f229102b = r101;
            this.f229103c = r102;
            this.f229104d = r103;
        }
    }

    public interface c {
        void cancel();
    }

    static {
        f229096a = new Handler(Looper.getMainLooper());
    }

    public static final void b(Ref.BooleanRef r110, AtomicBoolean r111, Ref.IntRef r112, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r113, String r210, List<b> r211, String r212, long r213, Context r214, Function1<? super a, Unit> r215, boolean r216) {
        if (r110.element == false) goto L5;
        return;
    L5:
        if (r111.get() == true) goto L54;
        if (r216 == false) goto L9;
    L11:
        r110.element = true;
        Iterator<T> r100 = r113.iterator();
    L13:
        if (r100.hasNext() == false) goto L15;
        Pair r101 = (Pair) r100.next();
        ((LiveData) r101.component1()).removeObserver((Observer) r101.component2());
        goto L13
    L15:
        r113.clear();
        f229096a.removeCallbacksAndMessages(r210);
        List<b> r102 = r211;
        ArrayList r114 = new ArrayList();
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L21;
        Object r104 = r103.next();
        if (((b) r104).f229102b == false) goto L17;
        r114.add(r104);
        goto L17
    L21:
        Iterator r105 = r114.iterator();
        int r115 = 0;
    L23:
        if (r105.hasNext() == false) goto L25;
        r115 = r115 + ((b) r105.next()).f229103c;
        goto L23
    L25:
        boolean r116 = !r114.isEmpty();
        Iterator<T> r106 = r102.iterator();
    L26:
        String r107 = null;
        if (r106.hasNext() == false) goto L31;
        Object r108 = r106.next();
        if ((!((b) r108).f229102b) == false) goto L26;
    L32:
        b r109 = (b) r108;
        if (r109 == null) goto L35;
        r107 = r109.f229104d;
    L35:
        String r117 = r107;
        if (r116 == false) goto L41;
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_success requestId=" + r210 + " key=" + r212 + " success_tabs=" + CollectionsKt.joinToString$default(r114, null, null, null, 0, null, OfficeSpaceDbPreloadWorker$preloadDb$finishIfNeeded$2.INSTANCE, 31, null) + " total_size=" + r115 + " cost_ms=" + (System.currentTimeMillis() - r213));
        Intrinsics.checkNotNull(r214);
        int r118 = r114.size();
        if (DevEnvUtil.isDebugMode(r214) == false) goto L41;
        f229096a.post(new com.bytedance.ee.bear.list.office.preload.c(r214, r118, r115));
    L41:
        r215.invoke(new a(r116, r115, r117, CollectionsKt.toList(r102)));
        return;
    L31:
        r108 = null;
        goto L32
    L9:
        if (r112.element <= 0) goto L11;
        return;
    }

    public static final void c(Ref.BooleanRef r110, AtomicBoolean r111, List<b> r112, Ref.IntRef r113, String r114, String r115, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r116, long r117, Context r210, Function1<? super a, Unit> r211, b r212) {
        if (r110.element == false) goto L5;
        return;
    L5:
        if (r111.get() == true) goto L15;
        r112.add(r212);
        r113.element--;
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_tab_result requestId=" + r114 + " key=" + r115 + " tab=" + r212.f229101a + " success=" + r212.f229102b + " size=" + r212.f229103c + " error=" + r212.f229104d);
        if (r212.f229102b == true) goto L12;
        String r100 = r212.f229104d;
        if (r100 == null) goto L12;
        ConcurrentHashMap<String, g> r101 = d.f229150a;
        String r102 = r212.f229101a;
        Intrinsics.checkNotNullParameter(r115, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r102, "tab");
        Intrinsics.checkNotNullParameter(r100, "reason");
        d.f229151b.put(d.a(r115, r102), r100);
    L12:
        b(r110, r111, r113, r116, r114, r112, r115, r117, r210, r211, false);
        return;
    }

    public static final void a(final AtomicBoolean r210, final List r211, final String r212, final String r213, final Ref.BooleanRef r214, final List r215, final Ref.IntRef r216, final long r217, final Context r218, final Function1 r310, final long r311, final String r312, final String r313, Function0 r314, final Function1 r315) {
        if (r210.get() == false) goto L17;
        c(r214, r210, r215, r216, r212, r213, r211, r217, r218, r310, new b(r313, false, 0, "FAILED"));
        return;
    L17:
        final LiveData r100 = (LiveData) r314.invoke();     // Catch: Throwable -> L11
        Observer<List<? extends u1>> r110 = new OfficeSpaceDbPreloadWorker$preloadDb$startTab$observer$1(r100, r211, r210, r315, r212, r213, r313, r311, r312, r214, r215, r216, r217, r218, r310);     // Catch: Throwable -> L11
        r211.add(TuplesKt.to(r100, r110));     // Catch: Throwable -> L9
        r100.observeForever(r110);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        tt5.a.e("OfficeSpaceDbPreloadWorker", "office_space_db_preload_tab_failed requestId=" + r212 + " key=" + r213 + " tab=" + r313, th, false);
        c(r214, r210, r215, r216, r212, r213, r211, r217, r218, r310, new b(r313, false, 0, th.getClass().getSimpleName()));
        return;
    L11:
        th = th;
        goto L13
    }
}
