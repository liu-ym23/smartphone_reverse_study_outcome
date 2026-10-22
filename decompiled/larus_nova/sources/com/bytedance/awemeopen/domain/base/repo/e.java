package com.bytedance.awemeopen.domain.base.repo;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n14.a;

/* JADX INFO: loaded from: classes44.dex */
public class e<T extends n14.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f198243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Exception f198244b;

    public e(T r100, Exception r101) {
        this.f198243a = r100;
        this.f198244b = r101;
    }

    public final void a(Function1<? super T, Unit> r100, Function2<? super Exception, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "success");
        Intrinsics.checkNotNullParameter(r101, "fail");
        T r102 = this.f198243a;
        Exception r103 = this.f198244b;
        if (r102 == null) goto L8;
        if (r103 != null) goto L8;
        if (r102.a() != 0) goto L8;
        r100.invoke(r102);
        return;
    L8:
        if (r102 == null) goto L10;
        int r104 = r102.a();
    L11:
        r101.invoke(r103, Integer.valueOf(r104));
        return;
    L10:
        r104 = -1;
        goto L11
    }

    public final void b(Function1<? super T, Unit> r100, Function2<? super Exception, ? super Integer, Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "success");
        Intrinsics.checkNotNullParameter(r101, "fail");
        Intrinsics.checkNotNullParameter(r102, "needLogin");
        T r103 = this.f198243a;
        Exception r104 = this.f198244b;
        if (r103 == null) goto L8;
        if (r104 != null) goto L8;
        if (r103.a() != 0) goto L8;
        r100.invoke(r103);
        return;
    L8:
        if (r103 != null) goto L10;
    L12:
        if (r103 == null) goto L14;
        int r105 = r103.a();
    L15:
        r101.invoke(r104, Integer.valueOf(r105));
        return;
    L14:
        r105 = -1;
        goto L15
    L10:
        if (r103.a() != 12001) goto L12;
        r102.invoke();
    }
}
