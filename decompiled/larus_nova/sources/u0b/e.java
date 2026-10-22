package u0b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import java.util.HashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends a {
    public e() {
    }

    public final String e(ChameleonConfig r100) {
        if (r100 == null) goto L10;
        ResConfig r101 = r100.getResConfig();
        if (r101 == null) goto L10;
        ResGeckoConfig r102 = r101.getGeckoConfig();
        if (r102 == null) goto L10;
        HashMap<String, String> r103 = r102.getChannels();
        if (r103 == null) goto L10;
        return r103.get(GeckoConst.HOTFIX);
    L10:
        return null;
    }

    @Override // u0b.a
    public final boolean d(Context r100, ChameleonConfig r101) {
        int r102 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.f411278a;
        return !TextUtils.isEmpty(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r101, e(r101))));
    }

    @Override // u0b.a
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        int r104 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.f411278a;
        String r105 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r101, e(r101)));
        j.e(ChameleonAbsResInterceptor.TAG, "getResource, hotfix version: " + r105);
        VFSFile r106 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r101, e(r101));     // Catch: Exception -> L13
        String r107 = "";
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        String r108 = e(r101);     // Catch: Exception -> L13
        if (r108 == null) goto L11;
        r107 = r108;
    L11:
        return c(r101, r106, r105, r107);
    L13:
        e = move-exception;
        j.c(ChameleonAbsResInterceptor.TAG, "getResource error", e);
        return a(r100, r101, false, null);
    }
}
