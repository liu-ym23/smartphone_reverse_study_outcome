package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import cz3.g;
import cz3.i;
import cz3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ManagerContext extends wy3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public hy3.b f194409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bz3.b f194410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f194411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<dz3.a> f194412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q14.a f194413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public cz3.a f194414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public cz3.d f194415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i f194416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f194417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l f194418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f194419q;

    public final Integer a() {
        hy3.b r100 = this.f194409g;
        if (r100 == null) goto L7;
        hy3.c r101 = r100.f487631b;
        if (r101 == null) goto L7;
        return r101.b();
    L7:
        return null;
    }

    public final iy3.a<?> b() {
        hy3.b r100 = this.f194409g;
        if (r100 == null) goto L24;
        hy3.c r101 = r100.f487631b;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.a() == null) goto L26;
        r14.c r102 = r101.a();
        if (r102 == null) goto L13;
        String r103 = r102.c();
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == false) goto L23;
        return null;
    L23:
        return new iy3.a(r103);
    L16:
        if (r103.length() == 0) goto L19;
        r104 = false;
        goto L20
    L13:
        r103 = null;
        goto L14
    L26:
        return null;
    L24:
        return null;
    }

    public final String c() {
        iy3.a<?> r100 = b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f496476a;
    }

    @Override // wy3.a, wy3.c
    public Context getContext() {
        return this.f561863a;
    }

    public ManagerContext(Context r100, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageOwner");
        super(r100, r101);
        this.f194412j = new ArrayList();
        this.f194419q = LazyKt.lazy(new ManagerContext$commentInputContentViewModel$2(this));
    }
}
