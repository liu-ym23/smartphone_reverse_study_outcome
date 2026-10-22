package com.ss.android.lark.passportc.convention;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f438136a;

    @Override // com.ss.android.lark.passportc.convention.a
    public final UserSession b() {
        UserSession r100 = this.f438136a.b();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ContainerConstsKt.a();
    }

    @Inject
    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f438136a = r100;
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final void a(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        UserSession r101 = this.f438136a.b();
        if (r101 != null) goto L5;
        r101 = ContainerConstsKt.a();
    L5:
        PassportcConvention.g(r100, r101);
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final UserSession c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        List<f0c.b> r101 = this.f438136a.a();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        String r104 = null;
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        g r106 = ((f0c.b) r105).a();
        if (r106 == null) goto L11;
        UserSession r107 = r106.f475034b;
        if (r107 == null) goto L11;
        r104 = r107.f438138b;
    L11:
        if (Intrinsics.areEqual(r104, r100) == false) goto L3;
        r102.add(r105);
        goto L3
    L13:
        Iterator r108 = r102.iterator();
    L15:
        if (r108.hasNext() == false) goto L22;
        Object r109 = r108.next();
        if (((f0c.b) r109).f475024b.f475035a != UserState.ONLINE) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L15;
    L23:
        f0c.b r111 = (f0c.b) r109;
        if (r111 != null) goto L26;
        r111 = (f0c.b) CollectionsKt.firstOrNull(r102);
    L26:
        if (r111 == null) goto L41;
        g r112 = r111.a();
        if (r112 != null) goto L30;
        return null;
    L30:
        return r112.f475034b;
    L41:
        return null;
    L19:
        r110 = false;
        goto L20
    L22:
        r109 = null;
        goto L23
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final void d(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        UserSession r101 = this.f438136a.b();
        if (r101 != null) goto L5;
        r101 = ContainerConstsKt.a();
    L5:
        PassportcConvention.h(r100, r101);
    }
}
