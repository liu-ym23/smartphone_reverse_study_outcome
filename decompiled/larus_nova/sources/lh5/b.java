package lh5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckRequest;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.dlp.cache.a f509244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f509245b;

    public class a implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a f509246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f509247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f509248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f509249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f509250e;

        public final void a(DlpCheckResult r100) {
            if (r100 != null) goto L5;
            b r101 = this.f509250e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r102 = this.f509246a;
            r101.getClass();
            b.e(r102, 0);
            return;
        L5:
            com.bytedance.ee.bear.middleground.permission.dlp.cache.a r103 = this.f509250e.f509244a;
            String r104 = this.f509247b;
            String r105 = this.f509248c;
            DlpCacheModel.NodeData r106 = r103.f233831b.get(r104);
            if (r106 != null) goto L8;
            r106 = new DlpCacheModel.NodeData();
        L8:
            r106.setCheckResult(r100);
            r106.setToken(r104);
            r106.setEntityType(r105);
            r103.f233831b.put(r104, r106);
            r103.a();
            DlpCacheModel.NodeData r107 = this.f509250e.f509244a.c(this.f509247b);
            b r108 = this.f509250e;
            String r109 = this.f509249d;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r110 = this.f509246a;
            r108.getClass();
            b.c(r107, r109, r110);
        }

        public a(b r100, com.bytedance.ee.bear.middleground_permission_export.model.d.a r101, String r102, String r103, String r104) {
            this.f509250e = r100;
            this.f509246a = r101;
            this.f509247b = r102;
            this.f509248c = r103;
            this.f509249d = r104;
        }
    }

    /* JADX INFO: renamed from: lh5.b$b, reason: collision with other inner class name */
    public class C6694b implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a f509251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f509252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f509253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f509254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f509255e;

        @Override // lh5.h.b
        public final void a(DlpPolicyModel r100) {
            if (r100 != null) goto L5;
        L13:
            b r101 = this.f509255e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r102 = this.f509251a;
            r101.getClass();
            b.e(r102, 0);
            return;
        L5:
            if (r100.getPolicy() == null) goto L13;
            this.f509255e.f509244a.d(r100, this.f509252b, this.f509253c);
            if (r100.getPolicy().isRes() == true) goto L11;
            b r103 = this.f509255e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r104 = this.f509251a;
            r103.getClass();
            b.e(r104, 0);
            return;
        L11:
            this.f509255e.b(this.f509252b, this.f509253c, this.f509254d, this.f509251a);
        }

        public C6694b(b r100, com.bytedance.ee.bear.middleground_permission_export.model.d.a r101, String r102, String r103, String r104) {
            this.f509255e = r100;
            this.f509251a = r101;
            this.f509252b = r102;
            this.f509253c = r103;
            this.f509254d = r104;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f509256a = null;

        static {
            f509256a = new b();
        }
    }

    public b() {
        this.f509244a = new com.bytedance.ee.bear.middleground.permission.dlp.cache.a();
        this.f509245b = new h();
    }

    public static void e(com.bytedance.ee.bear.middleground_permission_export.model.d.a r100, int r101) {
        if (r100 == null) goto L5;
        r100.a(r101);
        return;
    }

    public static int c(DlpCacheModel.NodeData r100, String r101, com.bytedance.ee.bear.middleground_permission_export.model.d.a r102) {
        int r103 = 0;
        if (r100 != null) goto L5;
    L41:
        e(r102, 0);
        return 0;
    L5:
        if (r100.getPolicyModel() == null) goto L41;
        if (TextUtils.isEmpty(r101) == true) goto L41;
        if (r100.getPolicyModel().getPolicy() == null) goto L41;
        if (r100.getPolicyModel().getPolicy().isRes() == true) goto L16;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp close");
        e(r102, 0);
        return 0;
    L16:
        if (r100.getCheckResult() != null) goto L18;
    L39:
        e(r102, 0);
        return 0;
    L18:
        if (r100.getCheckResult().getResultMap() == null) goto L39;
        if (r100.getCheckResult().getResultMap().size() < 0) goto L39;
        DlpCheckResult.DlpResult r104 = r100.getCheckResult().getResultMap().get(r101);
        if (r104 != null) goto L25;
    L37:
        e(r102, r103);
        return r103;
    L25:
        if (r104.isAllow() == true) goto L37;
        if ("DLP_CONTENT_DETECTING".equals(r104.getBizAction()) == false) goto L31;
        r103 = 1;
        goto L37
    L31:
        if ("DLP_CONTENT_SENSITIVE".equals(r104.getBizAction()) == false) goto L34;
    L36:
        r103 = 2;
        goto L37
    L34:
        if ("FILE_BLOCK_COMMON".equals(r104.getBizAction()) == false) goto L36;
        r103 = 3;
        goto L37
    }

    public final void b(String r110, String r111, String r112, com.bytedance.ee.bear.middleground_permission_export.model.d.a r113) {
        h r100 = this.f509245b;
        ArrayList<String> r101 = new ArrayList();
        r101.add("CCM_CONTENT_COPY");
        r101.add("CCM_EXPORT");
        r101.add("CCM_ATTACHMENT_DOWNLOAD");
        r101.add("CCM_CREATE_COPY");
        r101.add("CCM_EXPORT");
        r101.add("CCM_OPEN_EXTERNAL_ACCESS");
        final a r102 = new a(this, r113, r110, r111, r112);
        r100.getClass();
        NetService.d r114 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new nh5.a());
        NetService.f r115 = new NetService.f("/lark/scs/compliance/intercept/ccm/result/");
        String r103 = h.a();
        if (TextUtils.isEmpty(r103) == false) goto L5;
        r102.a(null);
        return;
    L5:
        r115.f216912i = false;
        r115.f216904a = r103;
        r115.f216906c = 1;
        DlpCheckRequest r104 = new DlpCheckRequest();
        r104.setToken(r110);
        r104.setEntityType(r111);
        r104.setEntityOperateList(r101);
        r115.f216913j = JSON.toJSONString(r104);
        r114.a(r115).observeOn(fo5.d.d()).subscribe(new f(r102), new g(r102));
    }

    public final int d(String r110, String r111, String r112, String r210, String r211) {
        DlpCacheModel.NodeData r113 = this.f509244a.c(r110);
        if (r113 != null) goto L5;
    L25:
        tt5.a.b("DlpCheckManager", "getOperateCheckState empty nodedata");
        a(r110, r111, r112, r210, r211, null);
        return 0;
    L5:
        if (r113.getPolicyModel() == null) goto L25;
        if (r113.getPolicyModel().getPolicy() == null) goto L25;
        boolean r114 = r113.getPolicyModel().getPolicy().isRes();
        boolean r100 = lh5.c.c(r113.getPolicyModel());
        boolean r101 = lh5.c.b(r114, r113.getCheckResult(), r112);
        if (r100 == true) goto L13;
        if (r101 == true) goto L13;
        tt5.a.b("DlpCheckManager", "getOperateCheckState all date are out of date or empty");
        a(r110, r111, r112, r210, r211, null);
    L19:
        if (r114 == true) goto L24;
        tt5.a.h("DlpCheckManager", "getOperateCheckState dlp close");
        return 0;
    L24:
        return c(r113, r112, null);
    L13:
        if (r100 == true) goto L16;
        if (r101 == false) goto L16;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp empty");
        h r115 = this.f509245b;
        lh5.a r102 = new lh5.a(this, null, r110, r111, r112);
        r115.getClass();
        h.b(r110, r111, r210, r211, r102);
    L16:
        if (r101 == true) goto L19;
        if (r100 == false) goto L19;
        tt5.a.b("DlpCheckManager", "getOperateCheckState check result empyt");
        b(r110, r111, r112, null);
        goto L19
    }

    public final void f(String r100, String r110, String r111, String r112, com.bytedance.ee.bear.middleground_permission_export.model.d.a r113) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L35:
        tt5.a.b("DlpCheckManager", "syncGetOperateCheckState empty toke or operate");
        e(r113, 0);
        return;
    L5:
        if (TextUtils.isEmpty("CCM_OPEN_EXTERNAL_ACCESS") == true) goto L35;
        DlpCacheModel.NodeData r101 = this.f509244a.c(r100);
        if (r101 != null) goto L10;
    L33:
        tt5.a.b("DlpCheckManager", "syncGetOperateCheckState empty nodedata");
        a(r100, r110, "CCM_OPEN_EXTERNAL_ACCESS", r111, r112, r113);
        return;
    L10:
        if (r101.getPolicyModel() == null) goto L33;
        if (r101.getPolicyModel().getPolicy() == null) goto L33;
        if (j.a.f217090a.getNetworkState().a() == true) goto L18;
        c(r101, "CCM_OPEN_EXTERNAL_ACCESS", r113);
        return;
    L18:
        boolean r102 = r101.getPolicyModel().getPolicy().isRes();
        boolean r103 = lh5.c.c(r101.getPolicyModel());
        boolean r104 = lh5.c.b(r102, r101.getCheckResult(), "CCM_OPEN_EXTERNAL_ACCESS");
        if (r103 == true) goto L23;
        if (r104 == true) goto L23;
        tt5.a.b("DlpCheckManager", "getOperateCheckState all date are out of date or empty");
        a(r100, r110, "CCM_OPEN_EXTERNAL_ACCESS", r111, r112, r113);
        return;
    L23:
        if (r103 == true) goto L27;
        if (r104 == false) goto L27;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp empty");
        h r105 = this.f509245b;
        lh5.a r106 = new lh5.a(this, r113, r100, r110, "CCM_OPEN_EXTERNAL_ACCESS");
        r105.getClass();
        h.b(r100, r110, r111, r112, r106);
        return;
    L27:
        if (r104 == true) goto L31;
        if (r103 == false) goto L31;
        tt5.a.b("DlpCheckManager", "getOperateCheckState check result empyt");
        b(r100, r110, "CCM_OPEN_EXTERNAL_ACCESS", r113);
        return;
    L31:
        c(r101, "CCM_OPEN_EXTERNAL_ACCESS", r113);
    }

    public final void a(String r100, String r110, String r111, String r112, String r113, com.bytedance.ee.bear.middleground_permission_export.model.d.a r114) {
        h r101 = this.f509245b;
        C6694b r102 = new C6694b(this, r114, r100, r110, r111);
        r101.getClass();
        h.b(r100, r110, r112, r113, r102);
    }
}
