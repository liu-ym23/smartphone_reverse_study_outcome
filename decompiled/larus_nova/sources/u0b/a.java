package u0b;

import android.app.Application;
import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import swb.g;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChameleonDefaultResFetcher f548209a;

    /* JADX INFO: renamed from: u0b.a$a, reason: collision with other inner class name */
    public static final class C7816a {
    }

    static {
    }

    public abstract com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r100, ChameleonConfig r101, boolean r102, String r103);

    public abstract boolean d(Context r100, ChameleonConfig r101);

    public a() {
        this.f548209a = new ChameleonDefaultResFetcher();
    }

    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d a(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        if (r102 == false) goto L4;
        VFSPath r104 = this.f548209a.b(r101, r100, r103);
    L6:
        if (r101 == null) goto L10;
        ResConfig r105 = r101.getResConfig();
        if (r105 == null) goto L10;
        String r106 = r105.getResVersion();
    L12:
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(r104, r106);
    L10:
        r106 = null;
        goto L12
    L4:
        r104 = this.f548209a.a(r101, r100, r103);
        goto L6
    }

    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d c(ChameleonConfig r110, VFSFile r111, String r112, String r113) throws IOException {
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "version");
        Intrinsics.checkNotNullParameter(r113, "channel");
        int r100 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        Application r101 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        VFSPath r114 = r111.getVfsPath().subPath(r112);
        if (r110 == null) goto L12;
        ResConfig r102 = r110.getResConfig();
        if (r102 == null) goto L12;
        String r103 = r102.getOfflineZipName();
        if (r103 == null) goto L12;
        List r104 = StringsKt.split$default(r103, new String[]{"."}, false, 0, 6, null);
        if (r104 == null) goto L12;
        String r105 = (String) ListProtector.get(r104, 0);
        if (r105 == null) goto L12;
    L13:
        VFSPath r106 = r114.subPath(r105);
        j.e(ChameleonAbsResInterceptor.TAG, "getResourceInternal, res = " + r106.getRealPath());
        boolean r107 = g.a(r106);
        j.e(ChameleonAbsResInterceptor.TAG, "getResourceInternal, check completion = " + r107);
        if (r107 == true) goto L43;
        int r108 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.f411278a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        j.e(ChameleonResUtils.TAG, "clearGeckoResourceByChannel, channel = ".concat(r113));
        if (r110 == null) goto L22;
        ResConfig r109 = r110.getResConfig();
        if (r109 == null) goto L22;
        ResGeckoConfig r115 = r109.getGeckoConfig();
        if (r115 == null) goto L22;
        String r116 = s0b.a.a(r101, r115);
    L23:
        boolean r117 = true;
        if (r116 != null) goto L26;
    L31:
        boolean r118 = false;
    L32:
        if (r118 == true) goto L34;
    L42:
        swb.j.g(r114);
        goto L43
    L34:
        if (r113.length() <= 0) goto L36;
        boolean r119 = true;
    L37:
        if (r119 == true) goto L40;
        r117 = false;
    L40:
        if (r117 == false) goto L42;
        swb.j.h(s0b.a.b().getVfsPath().subPath(r116).subPath(r113));
        goto L42
    L36:
        r119 = false;
        goto L37
    L26:
        if (r116.length() <= 0) goto L28;
        boolean r120 = true;
    L29:
        if (r120 != true) goto L31;
        r118 = true;
        goto L32
    L28:
        r120 = false;
    L22:
        r116 = null;
    L43:
        if (r107 == false) goto L46;
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(r106, r112);
    L46:
        return a(r101, r110, false, null);
    L12:
        r105 = "";
        goto L13
    }
}
