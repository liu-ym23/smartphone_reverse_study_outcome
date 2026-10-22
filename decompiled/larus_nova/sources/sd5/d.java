package sd5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderRouteBean;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ww4.a f541458b;

    public d() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/list/folder/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (this.f541458b != null) goto L6;
        this.f541458b = (ww4.a) org.koin.java.a.a(ww4.a.class);
    L6:
        if (this.f541458b.a().d().f217118a == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r101.f222560a, sbb.e.f541295f.getType()) == true) goto L11;
    L22:
        return false;
    L11:
        if (TextUtils.isEmpty(r101.f222561b) == true) goto L22;
        if (g(r100, r101, r102) == true) goto L21;
        tt5.a.h("FolderInterceptor", "dispatchUrl()..." + r101.f222560a);
        if ((r102 instanceof FolderRouteBean) == false) goto L20;
        FolderRouteBean r103 = (FolderRouteBean) r102;
        if (FolderVersion.isNewShareFolder(r103.f228006z) == false) goto L19;
        ((h) org.koin.java.a.a(h.class)).K8();
        goto L21
    L19:
        h r104 = (h) org.koin.java.a.a(h.class);
        RouteBean r105 = new RouteBean();
        r105.a(r103.f236651p);
        r104.yd("/list/folder/activity", r105).i("url", r101.f222564e).i("token", r101.f222561b).i("source", r101.f222565f).i("title", r103.f236641f).j("owner_type", r103.A).j(ToygerFaceAlgorithmConfig.DEPTH, r103.f228002v).i("parent_space_id", r103.f228003w).i("current_module", r103.f228004x).j("permission", r103.f228005y).l("is_external", r103.B).l("is_personal_folder", r103.C).i(DocViewModel.EXTRA_PARENT_TOKEN, r103.D).e();
        goto L21
    L20:
        ((h) org.koin.java.a.a(h.class)).w2("/list/folder/activity").i("url", r101.f222564e).i("token", r101.f222561b).l("open_route", true).e();
    L21:
        return true;
    }
}
