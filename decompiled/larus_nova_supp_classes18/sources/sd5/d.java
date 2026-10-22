package sd5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderRouteBean;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.route.b {
    public ww4.a b;

    public d() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/list/folder/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r7, BearUrl r8, RouteBean r9) {
        if (this.b != null) goto L6;
        this.b = (ww4.a) org.koin.java.a.a(ww4.a.class);
    L6:
        if (this.b.a().d().a == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r8.a, sbb.e.f.getType()) == true) goto L11;
    L22:
        return false;
    L11:
        if (TextUtils.isEmpty(r8.b) == true) goto L22;
        if (g(r7, r8, r9) == true) goto L21;
        tt5.a.h("FolderInterceptor", "dispatchUrl()..." + r8.a);
        if ((r9 instanceof FolderRouteBean) == false) goto L20;
        FolderRouteBean r10 = (FolderRouteBean) r9;
        if (FolderVersion.isNewShareFolder(r10.z) == false) goto L19;
        ((h) org.koin.java.a.a(h.class)).K8();
        goto L21
    L19:
        h r11 = (h) org.koin.java.a.a(h.class);
        RouteBean r4 = new RouteBean();
        r4.a(r10.p);
        r11.yd("/list/folder/activity", r4).i(ResourceData.KEY_URL, r8.e).i(ResourceData.KEY_TOKEN, r8.b).i("source", r8.f).i("title", r10.f).j("owner_type", r10.A).j("depth", r10.v).i("parent_space_id", r10.w).i("current_module", r10.x).j("permission", r10.y).l("is_external", r10.B).l("is_personal_folder", r10.C).i("parent_token", r10.D).e();
        goto L21
    L20:
        ((h) org.koin.java.a.a(h.class)).w2("/list/folder/activity").i(ResourceData.KEY_URL, r8.e).i(ResourceData.KEY_TOKEN, r8.b).l("open_route", true).e();
    L21:
        return true;
    }
}
