package u0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;
import swb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f548210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f548211c;

    public d() {
        this.f548210b = new e();
        this.f548211c = new c();
    }

    @Override // u0b.a
    public final boolean d(Context r100, ChameleonConfig r101) {
        if (r101 == null) goto L11;
        ResConfig r102 = r101.getResConfig();
        if (r102 == null) goto L11;
        ResGeckoConfig r103 = r102.getGeckoConfig();
        if (r103 == null) goto L11;
        if (r103.getEnable() != true) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        return false;
    L14:
        boolean r105 = this.f548210b.d(r100, r101);
        boolean r106 = this.f548211c.d(r100, r101);
        if (r105 == true) goto L20;
        if (r106 == true) goto L21;
        return false;
    L21:
        return true;
    L20:
        return true;
    L11:
        r104 = false;
        goto L12
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        boolean r104 = this.f548210b.d(r100, r101);
        boolean r105 = this.f548211c.d(r100, r101);
        if (r104 == false) goto L9;
        if (r105 == false) goto L9;
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r106 = this.f548210b.b(r100, r101, r102, null);
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r107 = this.f548211c.b(r100, r101, r102, null);
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, there are both hotfix and fullPkg resource, compare version");
        if (g.b(r106.f411280b, r107.f411280b) >= 0) goto L8;
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use fullPkg");
        return r107;
    L8:
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use hotfix");
        return r106;
    L9:
        if (r104 == false) goto L11;
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use hotfix");
        return this.f548210b.b(r100, r101, r102, null);
    L11:
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, use fullPkg");
        return this.f548211c.b(r100, r101, r102, null);
    }
}
