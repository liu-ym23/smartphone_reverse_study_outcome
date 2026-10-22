package if4;

import android.app.Application;
import cd4.q;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.storage.utils.d;
import com.bytedance.sdk.xbridge.cn.utils.g;
import kotlin.jvm.internal.Intrinsics;
import ve4.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f489574a = null;

    static {
        f489574a = new a();
    }

    public a() {
    }

    @Override // cd4.q
    public final Object a() {
        Intrinsics.checkNotNullParameter("insurance_zy_rrp", "key");
        Intrinsics.checkNotNullParameter("caijing_insurance_rrp", "biz");
        CJHostService r100 = (CJHostService) b.b(CJHostService.class);
        Object r101 = null;
        if (r100 == null) goto L5;
        Application r102 = r100.getHostApplication();
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        boolean r103 = true;
        if ("insurance_zy_rrp".length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        return null;
    L15:
        if ("caijing_insurance_rrp".length() > 0) goto L19;
        r103 = false;
    L19:
        if (r103 == false) goto L24;
        com.bytedance.sdk.xbridge.cn.storage.utils.b r105 = d.a(r102);
        if ((r105 instanceof com.bytedance.sdk.xbridge.cn.storage.utils.a) == false) goto L33;
        return ((com.bytedance.sdk.xbridge.cn.storage.utils.a) r105).d("caijing_insurance_rrp", "insurance_zy_rrp", "", "");
    L33:
        return r105.e("insurance_zy_rrp", "", "");
    L24:
        Object r106 = d.a(r102).e("insurance_zy_rrp", "", "");
        if (r106 != null) goto L29;
        IHostExternalStorageDepend r107 = g.b();
        if (r107 == null) goto L31;
        r101 = r107.readStorageValue("insurance_zy_rrp");
    L31:
        return r101;
    L29:
        r101 = r106;
        goto L31
    L11:
        r104 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // cd4.q
    public final boolean b(Object r110) {
        Intrinsics.checkNotNullParameter("insurance_zy_rrp", "key");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter("caijing_insurance_rrp", "biz");
        CJHostService r100 = (CJHostService) b.b(CJHostService.class);
        if (r100 == null) goto L5;
        Application r101 = r100.getHostApplication();
    L6:
        boolean r102 = false;
        if (r101 != null) goto L10;
        return false;
    L10:
        if ("insurance_zy_rrp".length() != 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return false;
    L15:
        com.bytedance.sdk.xbridge.cn.storage.utils.b r104 = d.a(r101);
        if ((r104 instanceof com.bytedance.sdk.xbridge.cn.storage.utils.a) == false) goto L18;
        boolean r105 = ((com.bytedance.sdk.xbridge.cn.storage.utils.a) r104).f("caijing_insurance_rrp", "insurance_zy_rrp", r110, null, "", "");
    L20:
        if ("caijing_insurance_rrp".length() != 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == true) goto L25;
        return r105;
    L25:
        if ((r110 instanceof String) == false) goto L36;
        IHostExternalStorageDepend r107 = g.b();
        if (r107 == null) goto L29;
        boolean r111 = r107.setStorageValue("insurance_zy_rrp", r110);
    L30:
        if (r111 == true) goto L32;
        if (r105 == true) goto L32;
    L34:
        return r102;
    L32:
        r102 = true;
        goto L34
    L29:
        r111 = false;
        goto L30
    L36:
        return r105;
    L22:
        r106 = false;
        goto L23
    L18:
        r105 = r104.g("insurance_zy_rrp", r110, null, "", "");
        goto L20
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }
}
