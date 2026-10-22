package com.bytedance.awemeopen.apps.framework.card.video;

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
public final class h implements r34.f {
    public final /* synthetic */ FeedVideoItemView a;
    public final /* synthetic */ int b;

    public h(FeedVideoItemView r1) {
        this.a = r1;
        this.b = 0;
    }

    public final void a(Exception r3, int r4) {
        AoLogger.b("FeedViewItemView", new Object[]{this.a.f + " fetchAweme onFail videoState = " + this.a.d + ", pendingSate = " + this.a.e});
        this.a.i.d();
        k54.d r5 = this.a.g.e;
        if (r5 == null) goto L6;
        r5.c(String.valueOf(r4));
        return;
    }

    public final void b(List<r14.c> r9, r r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        AoLogger.b("FeedViewItemView", new Object[]{this.a.f + " fetchAweme onSuccess videoState = " + this.a.d + ", pendingSate = " + this.a.e});
        if (r9.isEmpty() == false) goto L8;
        AoLogger.b("FeedViewItemView", new Object[]{this.a.f + " fetchAweme onSuccess data is empty"});
        this.a.i.d();
        k54.d r11 = this.a.g.e;
        if (r11 == null) goto L43;
        r11.c("empty");
        return;
    L43:
        return;
    L8:
        Object r0 = CollectionsKt.first(r9);
        FeedVideoItemView r3 = this.a;
        int r4 = this.b;
        r14.c r1 = (r14.c) r0;
        AosPreloadHelper r5 = AosPreloadHelper.a;
        Intrinsics.checkNotNullParameter(r1, "aweme");
        AosPreloadHelper.d.c(r1);
        if (FeedVideoItemView.a(r3) == false) goto L11;
        FeedVideoItemView.b(r3, r1, r4);
    L12:
        ArrayList r2 = new ArrayList();
        Iterator<T> r12 = r9.iterator();
    L14:
        if (r12.hasNext() == false) goto L36;
        r14.c r6 = (r14.c) r12.next();
        User r7 = r6.f();
        a24.a r8 = null;
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
        r8 = new a24.a(r13, r15, r16.Q());
    L34:
        if (r8 == null) goto L14;
        r2.add(r8);
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
        b14.a.a(a34.a.class).A2(r2);
        return;
    L11:
        AoLogger.b("FeedViewItemView", new Object[]{r3.f + " ensureParentSize"});
        r3.b.addOnLayoutChangeListener(new g(r3, r1, r4));
        goto L12
    }
}
