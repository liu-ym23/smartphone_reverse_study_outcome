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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public com.bytedance.ee.bear.middleground.permission.dlp.cache.a a;
    public h b;

    public class a implements h.a {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b e;

        public final void a(DlpCheckResult r5) {
            if (r5 != null) goto L5;
            b r6 = this.e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r0 = this.a;
            r6.getClass();
            b.e(r0, 0);
            return;
        L5:
            com.bytedance.ee.bear.middleground.permission.dlp.cache.a r1 = this.e.a;
            String r2 = this.b;
            String r3 = this.c;
            DlpCacheModel.NodeData r4 = r1.b.get(r2);
            if (r4 != null) goto L8;
            r4 = new DlpCacheModel.NodeData();
        L8:
            r4.setCheckResult(r5);
            r4.setToken(r2);
            r4.setEntityType(r3);
            r1.b.put(r2, r4);
            r1.a();
            DlpCacheModel.NodeData r7 = this.e.a.c(this.b);
            b r8 = this.e;
            String r9 = this.d;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r10 = this.a;
            r8.getClass();
            b.c(r7, r9, r10);
        }

        public a(b r1, com.bytedance.ee.bear.middleground_permission_export.model.d.a r2, String r3, String r4, String r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX INFO: renamed from: lh5.b$b, reason: collision with other inner class name */
    public class C0261b implements h.b {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b e;

        @Override // lh5.h.b
        public final void a(DlpPolicyModel r5) {
            if (r5 != null) goto L5;
        L13:
            b r6 = this.e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r1 = this.a;
            r6.getClass();
            b.e(r1, 0);
            return;
        L5:
            if (r5.getPolicy() == null) goto L13;
            this.e.a.d(r5, this.b, this.c);
            if (r5.getPolicy().isRes() == true) goto L11;
            b r7 = this.e;
            com.bytedance.ee.bear.middleground_permission_export.model.d.a r2 = this.a;
            r7.getClass();
            b.e(r2, 0);
            return;
        L11:
            this.e.b(this.b, this.c, this.d, this.a);
        }

        public C0261b(b r1, com.bytedance.ee.bear.middleground_permission_export.model.d.a r2, String r3, String r4, String r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static class c {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
        this.a = new com.bytedance.ee.bear.middleground.permission.dlp.cache.a();
        this.b = new h();
    }

    public static void e(com.bytedance.ee.bear.middleground_permission_export.model.d.a r0, int r1) {
        if (r0 == null) goto L5;
        r0.a(r1);
        return;
    }

    public static int c(DlpCacheModel.NodeData r2, String r3, com.bytedance.ee.bear.middleground_permission_export.model.d.a r4) {
        int r0 = 0;
        if (r2 != null) goto L5;
    L41:
        e(r4, 0);
        return 0;
    L5:
        if (r2.getPolicyModel() == null) goto L41;
        if (TextUtils.isEmpty(r3) == true) goto L41;
        if (r2.getPolicyModel().getPolicy() == null) goto L41;
        if (r2.getPolicyModel().getPolicy().isRes() == true) goto L16;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp close");
        e(r4, 0);
        return 0;
    L16:
        if (r2.getCheckResult() != null) goto L18;
    L39:
        e(r4, 0);
        return 0;
    L18:
        if (r2.getCheckResult().getResultMap() == null) goto L39;
        if (r2.getCheckResult().getResultMap().size() < 0) goto L39;
        DlpCheckResult.DlpResult r5 = r2.getCheckResult().getResultMap().get(r3);
        if (r5 != null) goto L25;
    L37:
        e(r4, r0);
        return r0;
    L25:
        if (r5.isAllow() == true) goto L37;
        if ("DLP_CONTENT_DETECTING".equals(r5.getBizAction()) == false) goto L31;
        r0 = 1;
        goto L37
    L31:
        if ("DLP_CONTENT_SENSITIVE".equals(r5.getBizAction()) == false) goto L34;
    L36:
        r0 = 2;
        goto L37
    L34:
        if ("FILE_BLOCK_COMMON".equals(r5.getBizAction()) == false) goto L36;
        r0 = 3;
        goto L37
    }

    public final void b(String r10, String r11, String r12, com.bytedance.ee.bear.middleground_permission_export.model.d.a r13) {
        h r0 = this.b;
        ArrayList<String> r1 = new ArrayList();
        r1.add("CCM_CONTENT_COPY");
        r1.add("CCM_EXPORT");
        r1.add("CCM_ATTACHMENT_DOWNLOAD");
        r1.add("CCM_CREATE_COPY");
        r1.add("CCM_EXPORT");
        r1.add("CCM_OPEN_EXTERNAL_ACCESS");
        final a r2 = new a(this, r13, r10, r11, r12);
        r0.getClass();
        NetService.d r14 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new nh5.a());
        NetService.f r15 = new NetService.f("/lark/scs/compliance/intercept/ccm/result/");
        String r3 = h.a();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r2.a(null);
        return;
    L5:
        ((NetService.e) r15).i = false;
        ((NetService.e) r15).a = r3;
        ((NetService.e) r15).c = 1;
        DlpCheckRequest r4 = new DlpCheckRequest();
        r4.setToken(r10);
        r4.setEntityType(r11);
        r4.setEntityOperateList(r1);
        ((NetService.e) r15).j = JSON.toJSONString(r4);
        r14.a(r15).observeOn(fo5.d.d()).subscribe(new f(r2), new g(r2));
    }

    public final int d(String r17, String r18, String r19, String r20, String r21) {
        DlpCacheModel.NodeData r10 = this.a.c(r17);
        if (r10 != null) goto L5;
    L25:
        tt5.a.b("DlpCheckManager", "getOperateCheckState empty nodedata");
        a(r17, r18, r19, r20, r21, null);
        return 0;
    L5:
        if (r10.getPolicyModel() == null) goto L25;
        if (r10.getPolicyModel().getPolicy() == null) goto L25;
        boolean r13 = r10.getPolicyModel().getPolicy().isRes();
        boolean r0 = lh5.c.c(r10.getPolicyModel());
        boolean r1 = lh5.c.b(r13, r10.getCheckResult(), r19);
        if (r0 == true) goto L13;
        if (r1 == true) goto L13;
        tt5.a.b("DlpCheckManager", "getOperateCheckState all date are out of date or empty");
        a(r17, r18, r19, r20, r21, null);
    L19:
        if (r13 == true) goto L24;
        tt5.a.h("DlpCheckManager", "getOperateCheckState dlp close");
        return 0;
    L24:
        return c(r10, r19, null);
    L13:
        if (r0 == true) goto L16;
        if (r1 == false) goto L16;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp empty");
        h r15 = this.b;
        lh5.a r5 = new lh5.a(this, null, r17, r18, r19);
        r15.getClass();
        h.b(r17, r18, r20, r21, r5);
    L16:
        if (r1 == true) goto L19;
        if (r0 == false) goto L19;
        tt5.a.b("DlpCheckManager", "getOperateCheckState check result empyt");
        b(r17, r18, r19, null);
        goto L19
    }

    public final void f(String r9, String r10, String r11, String r12, com.bytedance.ee.bear.middleground_permission_export.model.d.a r13) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L35:
        tt5.a.b("DlpCheckManager", "syncGetOperateCheckState empty toke or operate");
        e(r13, 0);
        return;
    L5:
        if (TextUtils.isEmpty("CCM_OPEN_EXTERNAL_ACCESS") == true) goto L35;
        DlpCacheModel.NodeData r0 = this.a.c(r9);
        if (r0 != null) goto L10;
    L33:
        tt5.a.b("DlpCheckManager", "syncGetOperateCheckState empty nodedata");
        a(r9, r10, "CCM_OPEN_EXTERNAL_ACCESS", r11, r12, r13);
        return;
    L10:
        if (r0.getPolicyModel() == null) goto L33;
        if (r0.getPolicyModel().getPolicy() == null) goto L33;
        if (j.a.a.getNetworkState().a() == true) goto L18;
        c(r0, "CCM_OPEN_EXTERNAL_ACCESS", r13);
        return;
    L18:
        boolean r2 = r0.getPolicyModel().getPolicy().isRes();
        boolean r3 = lh5.c.c(r0.getPolicyModel());
        boolean r4 = lh5.c.b(r2, r0.getCheckResult(), "CCM_OPEN_EXTERNAL_ACCESS");
        if (r3 == true) goto L23;
        if (r4 == true) goto L23;
        tt5.a.b("DlpCheckManager", "getOperateCheckState all date are out of date or empty");
        a(r9, r10, "CCM_OPEN_EXTERNAL_ACCESS", r11, r12, r13);
        return;
    L23:
        if (r3 == true) goto L27;
        if (r4 == false) goto L27;
        tt5.a.b("DlpCheckManager", "getOperateCheckState dlp empty");
        h r6 = this.b;
        lh5.a r7 = new lh5.a(this, r13, r9, r10, "CCM_OPEN_EXTERNAL_ACCESS");
        r6.getClass();
        h.b(r9, r10, r11, r12, r7);
        return;
    L27:
        if (r4 == true) goto L31;
        if (r3 == false) goto L31;
        tt5.a.b("DlpCheckManager", "getOperateCheckState check result empyt");
        b(r9, r10, "CCM_OPEN_EXTERNAL_ACCESS", r13);
        return;
    L31:
        c(r0, "CCM_OPEN_EXTERNAL_ACCESS", r13);
    }

    public final void a(String r9, String r10, String r11, String r12, String r13, com.bytedance.ee.bear.middleground_permission_export.model.d.a r14) {
        h r0 = this.b;
        C0261b r7 = new C0261b(this, r14, r9, r10, r11);
        r0.getClass();
        h.b(r9, r10, r12, r13, r7);
    }
}
