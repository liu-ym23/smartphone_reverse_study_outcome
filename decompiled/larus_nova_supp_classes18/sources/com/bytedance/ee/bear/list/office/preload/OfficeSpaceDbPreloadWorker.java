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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSpaceDbPreloadWorker {
    public static final Handler a = null;

    public static final class a {
        public final boolean a;
        public final int b;
        public final String c;
        public final List<b> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b) * 31;
            String r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return ((r1 + r3) * 31) + this.d.hashCode();
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(success=" + this.a + ", size=" + this.b + ", errorCode=" + this.c + ", tabResults=" + this.d + ')';
        }

        public a(boolean r2, int r3, String r4, List<b> r5) {
            Intrinsics.checkNotNullParameter(r5, "tabResults");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final int c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.c) * 31;
            String r3 = this.d;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "TabResult(tab=" + this.a + ", success=" + this.b + ", size=" + this.c + ", errorCode=" + this.d + ')';
        }

        public b(String r2, boolean r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "tab");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface c {
        void cancel();
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static final void b(Ref.BooleanRef r16, AtomicBoolean r17, Ref.IntRef r18, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r19, String r20, List<b> r21, String r22, long r23, Context r25, Function1<? super a, Unit> r26, boolean r27) {
        if (r16.element == false) goto L5;
        return;
    L5:
        if (r17.get() == true) goto L54;
        if (r27 == false) goto L9;
    L11:
        r16.element = true;
        Iterator<T> r0 = r19.iterator();
    L13:
        if (r0.hasNext() == false) goto L15;
        Pair r3 = (Pair) r0.next();
        ((LiveData) r3.component1()).removeObserver((Observer) r3.component2());
        goto L13
    L15:
        r19.clear();
        a.removeCallbacksAndMessages(r20);
        List<b> r1 = r21;
        ArrayList r12 = new ArrayList();
        Iterator<T> r4 = r1.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (((b) r5).b == false) goto L17;
        r12.add(r5);
        goto L17
    L21:
        Iterator r6 = r12.iterator();
        int r13 = 0;
    L23:
        if (r6.hasNext() == false) goto L25;
        r13 = r13 + ((b) r6.next()).c;
        goto L23
    L25:
        boolean r14 = !r12.isEmpty();
        Iterator<T> r7 = r1.iterator();
    L26:
        String r8 = null;
        if (r7.hasNext() == false) goto L31;
        Object r9 = r7.next();
        if ((!((b) r9).b) == false) goto L26;
    L32:
        b r10 = (b) r9;
        if (r10 == null) goto L35;
        r8 = r10.d;
    L35:
        String r2 = r8;
        if (r14 == false) goto L41;
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_success requestId=" + r20 + " key=" + r22 + " success_tabs=" + CollectionsKt.joinToString$default(r12, null, null, null, 0, null, OfficeSpaceDbPreloadWorker$preloadDb$finishIfNeeded$2.INSTANCE, 31, null) + " total_size=" + r13 + " cost_ms=" + (System.currentTimeMillis() - r23));
        Intrinsics.checkNotNull(r25);
        int r11 = r12.size();
        if (DevEnvUtil.isDebugMode(r25) == false) goto L41;
        a.post(new com.bytedance.ee.bear.list.office.preload.c(r25, r11, r13));
    L41:
        r26.invoke(new a(r14, r13, r2, CollectionsKt.toList(r1)));
        return;
    L31:
        r9 = null;
        goto L32
    L9:
        if (r18.element <= 0) goto L11;
        return;
    }

    public static final void c(Ref.BooleanRef r12, AtomicBoolean r13, List<b> r14, Ref.IntRef r15, String r16, String r17, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r18, long r19, Context r21, Function1<? super a, Unit> r22, b r23) {
        if (r12.element == false) goto L5;
        return;
    L5:
        if (r13.get() == true) goto L15;
        r14.add(r23);
        r15.element--;
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_tab_result requestId=" + r16 + " key=" + r17 + " tab=" + r23.a + " success=" + r23.b + " size=" + r23.c + " error=" + r23.d);
        if (r23.b == true) goto L12;
        String r3 = r23.d;
        if (r3 == null) goto L12;
        ConcurrentHashMap<String, g> r7 = d.a;
        String r1 = r23.a;
        Intrinsics.checkNotNullParameter(r17, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r1, "tab");
        Intrinsics.checkNotNullParameter(r3, "reason");
        d.b.put(d.a(r17, r1), r3);
    L12:
        b(r12, r13, r15, r18, r16, r14, r17, r19, r21, r22, false);
        return;
    }

    public static final void a(final AtomicBoolean r20, final List r21, final String r22, final String r23, final Ref.BooleanRef r24, final List r25, final Ref.IntRef r26, final long r27, final Context r29, final Function1 r30, final long r31, final String r33, final String r34, Function0 r35, final Function1 r36) {
        if (r20.get() == false) goto L17;
        c(r24, r20, r25, r26, r22, r23, r21, r27, r29, r30, new b(r34, false, 0, "FAILED"));
        return;
    L17:
        final LiveData r0 = (LiveData) r35.invoke();     // Catch: Throwable -> L11
        Observer<List<? extends u1>> r13 = new OfficeSpaceDbPreloadWorker$preloadDb$startTab$observer$1(r0, r21, r20, r36, r22, r23, r34, r31, r33, r24, r25, r26, r27, r29, r30);     // Catch: Throwable -> L11
        r21.add(TuplesKt.to(r0, r13));     // Catch: Throwable -> L9
        r0.observeForever(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        tt5.a.e("OfficeSpaceDbPreloadWorker", "office_space_db_preload_tab_failed requestId=" + r22 + " key=" + r23 + " tab=" + r34, th, false);
        c(r24, r20, r25, r26, r22, r23, r21, r27, r29, r30, new b(r34, false, 0, th.getClass().getSimpleName()));
        return;
    L11:
        th = th;
        goto L13
    }
}
