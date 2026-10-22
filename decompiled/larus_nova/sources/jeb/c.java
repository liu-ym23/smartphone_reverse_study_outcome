package jeb;

import com.larksuite.framework.utils.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends c0c.b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f498838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f498839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<d> f498840d;

    public static final class a {
    }

    static {
    }

    @Override // jeb.d
    public final void Xa() {
        this.f498838b.Xa();
    }

    @Override // jeb.d
    public final void g5(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f498838b.g5(r100);
    }

    @Override // jeb.d
    public final void k4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        this.f498838b.k4(r100);
    }

    @Override // jeb.d
    public final void od(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f498838b.od(r100);
    }

    @Override // jeb.d
    public final String q3() {
        return this.f498838b.q3();
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        Log.w("FeedClickDataCacheProxy", "init feed click data cache failed, userSession is invalid");
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), d.class), d.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f498838b = r103.b();
        this.f498839c = r101;
        this.f498840d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        if (r101 == null) goto L6;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L6;
    L7:
        d r103 = (d) k.b(this.f498839c.c(r102), d.class);
        StringBuilder r104 = new StringBuilder("FeedClickDataCacheProxy, onUserChanged, new=");
        r104.append(w.a(r103));
        r104.append(", old=");
        Provider<d> r105 = this.f498840d.f438126a;
        if (r105 != null) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L13;
        String r106 = w.a(r105);
        if (r106 == null) goto L13;
    L14:
        r104.append(r106);
        Log.i("FeedClickDataCacheProxy", r104.toString());
        this.f498840d.e(r103);
        return;
    L13:
        r106 = "";
    L6:
        Log.w("FeedClickDataCacheProxy", "onUserChanged currentUserSession is invalid.");
        r102 = ContainerConstsKt.a();
        goto L7
    }
}
