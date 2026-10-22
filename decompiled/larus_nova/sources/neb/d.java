package neb;

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
public final class d extends c0c.b implements neb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ neb.a f518915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f518916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<neb.a> f518917d;

    public static final class a {
    }

    static {
    }

    @Override // neb.a
    public final boolean e1() {
        return this.f518915b.e1();
    }

    @Override // neb.a
    public final void qe(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        this.f518915b.qe(r100);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        Log.w("PriorityDataCacheProxy", "init feed priority cache failed, userSession is invalid");
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<neb.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), neb.a.class), neb.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f518915b = r103.b();
        this.f518916c = r101;
        this.f518917d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        if (r101 == null) goto L6;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L6;
    L7:
        neb.a r103 = (neb.a) k.b(this.f518916c.c(r102), neb.a.class);
        StringBuilder r104 = new StringBuilder("PriorityDataCacheProxy, onUserChanged, new=");
        r104.append(w.a(r103));
        r104.append(", old=");
        Provider<neb.a> r105 = this.f518917d.f438126a;
        if (r105 != null) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L13;
        String r106 = w.a(r105);
        if (r106 == null) goto L13;
    L14:
        r104.append(r106);
        Log.i("PriorityDataCacheProxy", r104.toString());
        this.f518917d.e(r103);
        return;
    L13:
        r106 = "";
    L6:
        Log.w("PriorityDataCacheProxy", "onUserChanged currentUserSession is invalid.");
        r102 = ContainerConstsKt.a();
        goto L7
    }
}
