package com.larus.office.plugins.titlebar;

import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f363492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f363493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f363494c;

    public final void a() {
        d r100 = this.f363493b;
        if (r100.f363506a == true) goto L5;
    L11:
        boolean r101 = false;
    L13:
        if (Intrinsics.areEqual(this.f363494c, Boolean.valueOf(r101)) == false) goto L15;
        return;
    L15:
        this.f363494c = Boolean.valueOf(r101);
        this.f363492a.invoke(Boolean.valueOf(r101));
        return;
    L5:
        if (r100.f363507b == false) goto L11;
        if (r100.f363508c == true) goto L11;
        if (r100.f363509d.isEmpty() == false) goto L11;
        r101 = true;
        goto L13
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "onVisibilityChanged");
        this.f363492a = r100;
        this.f363493b = new d(0);
    }

    public final void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentKey");
        d r102 = this.f363493b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "fragmentKey");
        Set r103 = CollectionsKt.toMutableSet(r102.f363509d);
        if (r101 == false) goto L5;
        r103.add(r100);
    L6:
        this.f363493b = d.a(r102, false, false, false, r103, 7);
        a();
        return;
    L5:
        r103.remove(r100);
        goto L6
    }
}
