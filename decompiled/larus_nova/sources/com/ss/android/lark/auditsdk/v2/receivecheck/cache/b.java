package com.ss.android.lark.auditsdk.v2.receivecheck.cache;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends c0c.b implements com.ss.android.lark.auditsdk.v2.receivecheck.cache.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.auditsdk.v2.receivecheck.cache.a f409650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f409651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.auditsdk.v2.receivecheck.cache.a> f409652d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.auditsdk.v2.receivecheck.cache.a
    public final boolean H1(ImFileAsyncRecordCache.ImFileAsyncRecord.EntityType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        return this.f409650b.H1(r100, r101);
    }

    @Override // com.ss.android.lark.auditsdk.v2.receivecheck.cache.a
    public final void h9(ImFileAsyncRecordCache.ImFileAsyncRecord r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        this.f409650b.h9(r100);
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        Log.w("ImFileAsyncRecordProxy", "init file async record cache failed, userSession is invalid");
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.auditsdk.v2.receivecheck.cache.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class), com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f409650b = r103.b();
        this.f409651c = r101;
        this.f409652d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        if (r101 == null) goto L6;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L6;
    L7:
        com.ss.android.lark.auditsdk.v2.receivecheck.cache.a r103 = (com.ss.android.lark.auditsdk.v2.receivecheck.cache.a) k.b(this.f409651c.c(r102), com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class);
        Log.i("ImFileAsyncRecordProxy", "onUserChanged, new=" + r103 + ", old=" + this.f409652d.c());
        this.f409652d.e(r103);
        return;
    L6:
        Log.w("ImFileAsyncRecordProxy", "onUserChanged toUserSession is invalid.");
        r102 = ContainerConstsKt.a();
        goto L7
    }
}
