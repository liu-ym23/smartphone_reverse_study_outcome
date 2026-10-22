package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import android.content.Context;
import cz3.g;
import cz3.i;
import cz3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ManagerContext extends wy3.a {
    public hy3.b g;
    public bz3.b h;
    public boolean i;
    public final List<dz3.a> j;
    public q14.a k;
    public cz3.a l;
    public cz3.d m;
    public i n;
    public g o;
    public l p;
    public final Lazy q;

    public final Integer a() {
        hy3.b r0 = this.g;
        if (r0 == null) goto L7;
        hy3.c r1 = r0.b;
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return null;
    }

    public final iy3.a<?> b() {
        hy3.b r0 = this.g;
        if (r0 == null) goto L24;
        hy3.c r1 = r0.b;
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.a() == null) goto L26;
        r14.c r2 = r1.a();
        if (r2 == null) goto L13;
        String r3 = r2.c();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L23;
        return null;
    L23:
        return new iy3.a(r3);
    L16:
        if (r3.length() == 0) goto L19;
        r4 = false;
        goto L20
    L13:
        r3 = null;
        goto L14
    L26:
        return null;
    L24:
        return null;
    }

    public final String c() {
        iy3.a<?> r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // wy3.a, wy3.c
    public Context getContext() {
        return this.a;
    }

    public ManagerContext(Context r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        super(r2, r3);
        this.j = new ArrayList();
        this.q = LazyKt.lazy(new ManagerContext$commentInputContentViewModel$2(this));
    }
}
