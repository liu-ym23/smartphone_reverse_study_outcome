package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.r;
import f0c.d;
import f0c.g;
import f0c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class AllUserState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f438283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f438284b;

    public final List<f0c.b> c() {
        List<d> r100 = this.f438283a;
        monitor-enter(r100);
        List<d> r101 = this.f438283a;     // Catch: Throwable -> L17
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L17
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();     // Catch: Throwable -> L17
        if ((!((d) r104).f475029d) == false) goto L6;
        r102.add(r104);     // Catch: Throwable -> L17
        goto L6
    L11:
        monitor-exit(r100);
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r106 = r102.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r105.add(a((d) r106.next()));
        goto L14
    L16:
        return r105;
    L17:
        th = move-exception;
        throw th;
    }

    public final f0c.b d() {
        List<d> r100 = this.f438283a;
        monitor-enter(r100);
        Iterator<T> r101 = this.f438283a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();     // Catch: Throwable -> L17
        if (((d) r102).f475029d == false) goto L6;
    L11:
        d r103 = (d) r102;     // Catch: Throwable -> L17
        monitor-exit(r100);
        if (r103 == null) goto L16;
        return a(r103);
    L16:
        return new f0c.a(null, UserState.ABSENT, r.f438480a);
    L10:
        r102 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final int hashCode() {
        return this.f438283a.hashCode();
    }

    public final String toString() {
        List r100 = CollectionsKt.toMutableList(this.f438283a);
        CollectionsKt.sort(r100);
        return "[" + CollectionsKt.joinToString$default(r100, "\n", null, null, 0, null, new AnonymousClass1(this), 30, null) + ']';
    }

    public final f0c.b a(d r100) {
        UserSession r101 = r100.f475026a;
        User r102 = this.f438284b.a(r100.f475027b);
        if (r102 != null) goto L5;
        r102 = r100.f475030e.getUser();
    L5:
        g r103 = new g(r102, r101);
        UserState r104 = UserState.ABSENT;
        h r105 = r100.f475028c;
        return f0c.b.a.a(r103, r104, r105, r105.getContext());
    }

    public final d e(Function1<? super d, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "find");
        List<d> r101 = this.f438283a;
        monitor-enter(r101);
        Iterator<T> r102 = this.f438283a.iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (r100.invoke(r103).booleanValue() == false) goto L6;
    L11:
        d r104 = (d) r103;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return r104;
    L10:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AllUserState) == true) goto L8;
        return false;
    L8:
        AllUserState r101 = (AllUserState) r100;
        if (this.f438283a.size() == r101.f438283a.size()) goto L11;
        return false;
    L11:
        List<d> r102 = this.f438283a;
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        r103.put(((d) r105).f475026a.f438138b, r105);
        goto L13
    L15:
        Iterator r106 = r103.entrySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L37;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        d r109 = (d) r107.getValue();
        Iterator<T> r110 = r101.f438283a.iterator();
    L20:
        if (r110.hasNext() == false) goto L24;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((d) r111).f475026a.f438138b, r108) == false) goto L20;
    L25:
        d r112 = (d) r111;
        if (r112 == null) goto L27;
        if (r109.f475029d != r112.f475029d) goto L30;
        if (r109.f475028c.f475035a != r112.f475028c.f475035a) goto L33;
        if (Intrinsics.areEqual(r109.f475026a, r112.f475026a) == true) goto L17;
        return false;
    L33:
        return false;
    L30:
        return false;
    L27:
        return false;
    L24:
        r111 = null;
        goto L25
    L37:
        return true;
    }

    public AllUserState(List<d> r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "stateContextList");
        Intrinsics.checkNotNullParameter(r101, "userDataSource");
        this.f438283a = r100;
        this.f438284b = r101;
    }

    public static AllUserState b(AllUserState r100, List r101) {
        p r102 = r100.f438284b;
        Intrinsics.checkNotNullParameter(r101, "stateContextList");
        Intrinsics.checkNotNullParameter(r102, "userDataSource");
        return new AllUserState(r101, r102);
    }
}
