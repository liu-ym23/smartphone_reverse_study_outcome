package com.larus.multitask_management.impl;

import com.larus.office.minutes.impl.applet.RecordMultiTaskInitEventImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import ll9.a0;
import ll9.r;
import ll9.t;
import ll9.v;
import ll9.x;
import ll9.y;
import ll9.z;

/* JADX INFO: loaded from: classes4.dex */
public final class QuickAccessManager implements il9.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final QuickAccessManager f359425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<il9.h> f359426c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<il9.g> f359427d = null;

    public QuickAccessManager() {
    }

    static {
        f359425b = new QuickAccessManager();
        f359426c = new CopyOnWriteArrayList();
        f359427d = new CopyOnWriteArrayList();
    }

    @Override // il9.b
    public final v M2() {
        QuickAccessRepo.f359428a.getClass();
        return QuickAccessRepo.b("keva_key_discover_list");
    }

    @Override // il9.b
    public final v U() {
        QuickAccessRepo.f359428a.getClass();
        return QuickAccessRepo.b("keva_key_recent_access_list");
    }

    @Override // il9.b
    public final v g2() {
        QuickAccessRepo.f359428a.getClass();
        return QuickAccessRepo.b("keva_key_pinned_list");
    }

    @Override // il9.b
    public final void F(RecordMultiTaskInitEventImpl.b r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        f359427d.add(r100);
    }

    @Override // il9.b
    public final void I1(v r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheData");
        QuickAccessRepo.f359428a.getClass();
        QuickAccessRepo.k("keva_key_discover_list", r100);
    }

    @Override // il9.b
    public final void U0(v r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheData");
        QuickAccessRepo.f359428a.getClass();
        QuickAccessRepo.k("keva_key_recent_access_list", r100);
    }

    @Override // il9.b
    public final void s2(il9.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f359426c.add(r100);
    }

    @Override // il9.b
    public final void w0(il9.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f359426c.remove(r100);
    }

    @Override // il9.b
    public final void z(v r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheData");
        QuickAccessRepo.f359428a.getClass();
        QuickAccessRepo.k("keva_key_pinned_list", r100);
    }

    @Override // il9.b
    public final Object H0(ll9.g r100, Continuation<? super r> r101) {
        return QuickAccessRepo.f359428a.e(r100, r101);
    }

    @Override // il9.b
    public final Object R1(ll9.h r110, Continuation<? super r> r111) {
        if ((r111 instanceof QuickAccessManager$getPinnedList$1) == false) goto L7;
        QuickAccessManager$getPinnedList$1 r100 = (QuickAccessManager$getPinnedList$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        List r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        r r114 = (r) r112;
        ArrayList r104 = null;
        if (r114 != null) goto L21;
        return null;
    L21:
        if (r113.isEmpty() == true) goto L43;
        List<t> r105 = r114.f509767b;
        if (r105 == null) goto L41;
        r104 = new ArrayList();
        Iterator<T> r106 = r105.iterator();
    L27:
        if (r106.hasNext() == false) goto L41;
        Object r107 = r106.next();
        t r108 = (t) r107;
        List r109 = r113;
        if ((r109 instanceof Collection) == true) goto L31;
    L33:
        Iterator r115 = r109.iterator();
    L35:
        if (r115.hasNext() == false) goto L32;
        if (((il9.g) r115.next()).a(r108) == true) goto L35;
        boolean r116 = false;
    L39:
        if (r116 == false) goto L27;
        r104.add(r107);
    L32:
        r116 = true;
        goto L39
    L31:
        if (r109.isEmpty() == false) goto L33;
    L41:
        Long r117 = r114.f509766a;
        r114 = new r(r117, r104, r114.f509768c, r114.f509769d, r114.f509770e);
    L43:
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        List r118 = a.e(f359427d);
        QuickAccessRepo r119 = QuickAccessRepo.f359428a;
        r100.L$0 = r118;
        r100.label = 1;
        Object r120 = r119.c(r110, r100);
        if (r120 != r102) goto L17;
        return r102;
    L17:
        r112 = r120;
        r113 = r118;
    L7:
        r100 = new QuickAccessManager$getPinnedList$1(this, r111);
        goto L8
    }

    @Override // il9.b
    public final Object V1(ll9.o r100, Continuation<? super r> r101) {
        if ((r101 instanceof QuickAccessManager$pin$1) == false) goto L7;
        QuickAccessManager$pin$1 r102 = (QuickAccessManager$pin$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (ll9.o) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        r r107 = (r) r104;
        if (r107 == null) goto L20;
        Long r108 = r107.f509766a;
    L21:
        if (r108 == null) goto L26;
        Iterator<il9.h> r109 = f359426c.iterator();
    L24:
        if (r109.hasNext() == false) goto L26;
        r109.next().b(r100.f509760a, r100.f509761b);
    L26:
        return r107;
    L20:
        r108 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        QuickAccessRepo r110 = QuickAccessRepo.f359428a;
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r110.g(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new QuickAccessManager$pin$1(this, r101);
        goto L8
    }

    @Override // il9.b
    public final Object W2(ll9.j r100, Continuation<? super x> r110) {
        if ((r110 instanceof QuickAccessManager$getRecentAccessList$1) == false) goto L7;
        QuickAccessManager$getRecentAccessList$1 r101 = (QuickAccessManager$getRecentAccessList$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        List r105 = (List) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        x r112 = (x) r111;
        ArrayList r106 = null;
        if (r112 != null) goto L21;
        return null;
    L21:
        if (r105.isEmpty() == true) goto L43;
        List<t> r107 = r112.f509793b;
        if (r107 == null) goto L41;
        r106 = new ArrayList();
        Iterator<T> r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L41;
        Object r109 = r108.next();
        t r113 = (t) r109;
        List r114 = r105;
        if ((r114 instanceof Collection) == true) goto L31;
    L33:
        Iterator r115 = r114.iterator();
    L35:
        if (r115.hasNext() == false) goto L32;
        if (((il9.g) r115.next()).a(r113) == true) goto L35;
        boolean r116 = false;
    L39:
        if (r116 == false) goto L27;
        r106.add(r109);
    L32:
        r116 = true;
        goto L39
    L31:
        if (r114.isEmpty() == false) goto L33;
    L41:
        r112 = new x(r112.f509792a, r106, r112.f509794c, r112.f509795d);
    L43:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        List r117 = a.e(f359427d);
        QuickAccessRepo r118 = QuickAccessRepo.f359428a;
        r101.L$0 = r117;
        r101.label = 1;
        Object r119 = r118.d(r100, r101);
        if (r119 != r103) goto L17;
        return r103;
    L17:
        r111 = r119;
        r105 = r117;
    L7:
        r101 = new QuickAccessManager$getRecentAccessList$1(this, r110);
        goto L8
    }

    @Override // il9.b
    public final Object d0(z r100, Continuation<? super x> r101) {
        return QuickAccessRepo.f359428a.i(r100, r101);
    }

    @Override // il9.b
    public final Object h2(a0 r100, Continuation<? super r> r101) {
        if ((r101 instanceof QuickAccessManager$unpin$1) == false) goto L7;
        QuickAccessManager$unpin$1 r102 = (QuickAccessManager$unpin$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (a0) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        r r107 = (r) r104;
        if (r107 == null) goto L20;
        Long r108 = r107.f509766a;
    L21:
        if (r108 == null) goto L26;
        Iterator<il9.h> r109 = f359426c.iterator();
    L24:
        if (r109.hasNext() == false) goto L26;
        r109.next().c(r100.f509714a, r100.f509715b);
    L26:
        return r107;
    L20:
        r108 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        QuickAccessRepo r110 = QuickAccessRepo.f359428a;
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r110.l(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new QuickAccessManager$unpin$1(this, r101);
        goto L8
    }

    @Override // il9.b
    public final Object t2(y r100, Continuation<? super x> r101) {
        return QuickAccessRepo.f359428a.h(r100, r101);
    }

    @Override // il9.b
    public final Object w1(ll9.c r100, Continuation<? super ll9.e> r110) {
        if ((r110 instanceof QuickAccessManager$getDiscoverList$1) == false) goto L7;
        QuickAccessManager$getDiscoverList$1 r101 = (QuickAccessManager$getDiscoverList$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        List r105 = (List) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        ll9.e r112 = (ll9.e) r111;
        ArrayList r106 = null;
        if (r112 != null) goto L21;
        return null;
    L21:
        if (r105.isEmpty() == true) goto L43;
        List<t> r107 = r112.f509726a;
        if (r107 == null) goto L41;
        r106 = new ArrayList();
        Iterator<T> r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L41;
        Object r109 = r108.next();
        t r113 = (t) r109;
        List r114 = r105;
        if ((r114 instanceof Collection) == true) goto L31;
    L33:
        Iterator r115 = r114.iterator();
    L35:
        if (r115.hasNext() == false) goto L32;
        if (((il9.g) r115.next()).a(r113) == true) goto L35;
        boolean r116 = false;
    L39:
        if (r116 == false) goto L27;
        r106.add(r109);
    L32:
        r116 = true;
        goto L39
    L31:
        if (r114.isEmpty() == false) goto L33;
    L41:
        r112 = new ll9.e(r106, r112.f509727b, r112.f509728c);
    L43:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        List r117 = a.e(f359427d);
        QuickAccessRepo r118 = QuickAccessRepo.f359428a;
        r101.L$0 = r117;
        r101.label = 1;
        Object r119 = r118.a(r100, r101);
        if (r119 != r103) goto L17;
        return r103;
    L17:
        r111 = r119;
        r105 = r117;
    L7:
        r101 = new QuickAccessManager$getDiscoverList$1(this, r110);
        goto L8
    }
}
