package pn5;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements a {
    public final DocViewModel a;
    public final boolean b;

    public final String b() {
        DocViewModel r1 = this.a;
        if (r1 != null) goto L5;
        return "";
    L5:
        if (r1.getDocumentInfoData() != null) goto L24;
        return "";
    L24:
        int r2 = sbb.e.g(this.a.getDocumentType());     // Catch: Throwable -> L20
        String r3 = this.a.getDocumentInfoData().getCreatorTenantId();     // Catch: Throwable -> L20
        String r4 = this.a.getToken();     // Catch: Throwable -> L20
        BlockInfo r5 = this.a.getCurrentRefBlockInfo();     // Catch: Throwable -> L20
        if (r5 != null) goto L10;
    L18:
        int r6 = r2;
        String r8 = r3;
        return ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).a(r4, r6, "CCM_CONTENT_COPY", "", r8);
    L10:
        if (this.b == false) goto L18;
        tt5.a.h("SheetPermDelegate", "getDlpMsg use RefBlockInfo");     // Catch: Throwable -> L20
        if (r5.getType() == null) goto L14;
        r2 = r5.getType().intValue();     // Catch: Throwable -> L20
    L15:
        r4 = r5.getToken();     // Catch: Throwable -> L20
        BlockInfo r7 = this.a.getDocumentInfoData().getBlockInfo(r5.getToken());     // Catch: Throwable -> L20
        if (r7 == null) goto L18;
        r3 = r7.getCreatorTenantId();     // Catch: Throwable -> L20
        goto L18
    L14:
        r2 = 0;
    L20:
        th = move-exception;
        tt5.a.e("SheetPermDelegate", "getDlpMsg error", th, false);
        return "";
    }

    public final boolean c() {
        DocViewModel r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getDocumentInfoData() == null) goto L14;
        DocumentInfo r1 = this.a.getDocumentInfoData();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L11;
        PermissionRequest r2 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).b("COPY_BY_LEADER");
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(r2, new UserPermissionEntity(r1.getDocPermission().a, null)).getAllow();
    L11:
        return r1.getDocPermission().a.isCopyAuthByLeader();
    L14:
        return false;
    }

    public j(DocViewModel r3) {
        this.a = null;
        this.b = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docs.all.synced_block_enable");
        this.a = r3;
    }

    public final PermissionResponse a(boolean r15) {
        DocViewModel r1 = this.a;
        if (r1 != null) goto L5;
    L43:
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.a();
    L5:
        if (r1.getDocumentInfoData() == null) goto L43;
        int r2 = sbb.e.g(this.a.getDocumentType());     // Catch: Throwable -> L38
        String r3 = this.a.getDocumentInfoData().getCreatorTenantId();     // Catch: Throwable -> L38
        String r4 = this.a.getToken();     // Catch: Throwable -> L38
        String r5 = this.a.getOwnerUserId();     // Catch: Throwable -> L38
        if (this.a.getDocumentInfoData() == null) goto L10;
        IDocUserPermission r6 = this.a.getDocumentInfoData().getDocPermission().a;     // Catch: Throwable -> L38
    L11:
        BlockInfo r8 = this.a.getCurrentRefBlockInfo();     // Catch: Throwable -> L38
        if (r8 != null) goto L14;
    L25:
        String r10 = r3;
        String r9 = r4;
        String r13 = r5;
        if (r15 == false) goto L28;
        IDocUserPermission r12 = r6;
    L29:
        if (r6 != null) goto L31;
    L40:
        int r16 = f35.b.a;     // Catch: Throwable -> L38
        return f35.b.d(r9, sbb.e.d(r2), r10, BizDomain.FileBizDomainCCM, r12, r13);
    L31:
        if (r6.isCopyAuthByKp() == false) goto L40;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();     // Catch: Throwable -> L38
        jg5.e r17 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.a() == false) goto L40;
        PermissionResponse.Companion.getClass();     // Catch: Throwable -> L38
        return PermissionResponse.a.b();
    L28:
        r12 = null;
        goto L29
    L14:
        if (this.b == false) goto L25;
        tt5.a.h("SheetPermDelegate", "getPermissionResponse use RefBlockInfo");     // Catch: Throwable -> L38
        if (r8.getType() == null) goto L18;
        r2 = r8.getType().intValue();     // Catch: Throwable -> L38
    L19:
        r4 = r8.getToken();     // Catch: Throwable -> L38
        BlockInfo r11 = this.a.getDocumentInfoData().getBlockInfo(r8.getToken());     // Catch: Throwable -> L38
        if (r11 == null) goto L23;
        r3 = r11.getCreatorTenantId();     // Catch: Throwable -> L38
        r5 = r11.getOwnerUserId();     // Catch: Throwable -> L38
    L23:
        if (this.a.getDocumentInfoData() == null) goto L25;
        r6 = this.a.getDocumentInfoData().getDocPermissionByToken(r8.getToken());     // Catch: Throwable -> L38
        goto L25
    L18:
        r2 = 0;
        goto L19
    L10:
        r6 = null;
    L38:
        th = move-exception;
        tt5.a.f("SheetPermDelegate", th, false);
        goto L43
    }
}
