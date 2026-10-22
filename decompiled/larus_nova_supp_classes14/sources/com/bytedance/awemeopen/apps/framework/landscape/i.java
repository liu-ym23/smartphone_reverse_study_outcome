package com.bytedance.awemeopen.apps.framework.landscape;

import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;
import r14.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements r34.f {
    public final /* synthetic */ LandscapeVideoItemView a;
    public final /* synthetic */ int b;

    public i(LandscapeVideoItemView r1) {
        this.a = r1;
        this.b = 0;
    }

    public final void a(Exception r3, int r4) {
        AoLogger.b("LandscapeVideoItemView", new Object[]{this.a.f + " fetchAweme onFail videoState = " + this.a.d + ", pendingSate = " + this.a.e});
        k54.d r5 = this.a.h.e;
        if (r5 == null) goto L6;
        r5.c(String.valueOf(r4));
        return;
    }

    public final void b(List<r14.c> r8, r r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        AoLogger.b("LandscapeVideoItemView", new Object[]{this.a.f + " fetchAweme onSuccess videoState = " + this.a.d + ", pendingSate = " + this.a.e});
        if (r8.isEmpty() == false) goto L8;
        AoLogger.b("LandscapeVideoItemView", new Object[]{this.a.f + " fetchAweme onSuccess data is empty"});
        k54.d r10 = this.a.h.e;
        if (r10 == null) goto L43;
        r10.c("empty");
        return;
    L43:
        return;
    L8:
        Object r0 = CollectionsKt.first(r8);
        LandscapeVideoItemView r1 = this.a;
        int r3 = this.b;
        r14.c r2 = (r14.c) r0;
        AosPreloadHelper r4 = AosPreloadHelper.a;
        Intrinsics.checkNotNullParameter(r2, "aweme");
        AosPreloadHelper.d.c(r2);
        if (r1.d() == false) goto L11;
        LandscapeVideoItemView.a(r1, r2, r3);
    L12:
        ArrayList r5 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L14:
        if (r11.hasNext() == false) goto L36;
        r14.c r6 = (r14.c) r11.next();
        User r7 = r6.f();
        a24.a r12 = null;
        if (r7 == null) goto L18;
        String r13 = r7.u();
    L19:
        a0 r14 = r6.d;
        if (r14 == null) goto L22;
        String r15 = r14.a();
    L23:
        User r16 = r6.f();
        if (r13 != null) goto L26;
    L29:
        boolean r17 = true;
    L30:
        if (r17 == true) goto L34;
        if (r15 == null) goto L34;
        if (r16 == null) goto L34;
        r12 = new a24.a(r13, r15, r16.Q());
    L34:
        if (r12 == null) goto L14;
        r5.add(r12);
        goto L14
    L26:
        if (r13.length() == 0) goto L29;
        r17 = false;
        goto L30
    L22:
        r15 = null;
        goto L23
    L18:
        r13 = null;
        goto L19
    L36:
        d14.a r18 = b14.a.a;
        b14.a.a(a34.a.class).A2(r5);
        return;
    L11:
        r1.c(r2, r3);
        goto L12
    }
}
