package oj5;

import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements c {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final FolderVersion o;
    public final boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public ShareFolderUserPermission t;
    public IDocUserPermission u;
    public String[] v;
    public Map<String, String> w;

    public b() {
        this(0, "", "", "", "", "", "", "", "", "", null, false, false, false, new FolderVersion(0, 0, false, 7, null), false);
    }

    @Override // oj5.c
    public final boolean F() {
        return false;
    }

    @Override // oj5.c
    public final void G(boolean r1) {
    }

    @Override // oj5.c
    public final String I() {
        return "";
    }

    @Override // oj5.c
    public final void J(boolean r1) {
    }

    @Override // oj5.c
    public final /* synthetic */ String N() {
        return null;
    }

    @Override // oj5.c
    public final /* synthetic */ String[] O() {
        return null;
    }

    @Override // oj5.c
    public final boolean P() {
        return false;
    }

    @Override // oj5.c
    public final DocUpgradeInfo R() {
        return null;
    }

    @Override // oj5.c
    public final String b() {
        return "";
    }

    @Override // oj5.c
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // oj5.c
    public final String f() {
        return "";
    }

    @Override // oj5.c
    public final void g(boolean r1) {
    }

    @Override // oj5.c
    public final String getAppId() {
        return "";
    }

    @Override // oj5.c
    public final int getTemplateType() {
        return -1;
    }

    @Override // oj5.c
    public final /* synthetic */ boolean h() {
        return false;
    }

    @Override // oj5.c
    public final boolean isSecretFileCopy() {
        return false;
    }

    @Override // oj5.c
    public final boolean isSecretFileEdit() {
        return false;
    }

    @Override // oj5.c
    public final boolean isSecretFileExport() {
        return false;
    }

    @Override // oj5.c
    public final boolean isSecretFileView() {
        return false;
    }

    @Override // oj5.c
    public final boolean isSubscribe() {
        return false;
    }

    @Override // oj5.c
    public final boolean j() {
        return false;
    }

    @Override // oj5.c
    public final /* synthetic */ String[] l() {
        return null;
    }

    @Override // oj5.c
    public final boolean m() {
        return false;
    }

    @Override // oj5.c
    public final boolean n() {
        return false;
    }

    @Override // oj5.c
    public final boolean o() {
        return false;
    }

    @Override // oj5.c
    public final boolean p() {
        return false;
    }

    @Override // oj5.c
    public final boolean q() {
        return false;
    }

    @Override // oj5.c
    public final void r(DocPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "docPermission");
    }

    @Override // oj5.c
    public final /* synthetic */ boolean s() {
        return false;
    }

    @Override // oj5.c
    public final /* synthetic */ String[] u() {
        return null;
    }

    @Override // oj5.c
    public final boolean v() {
        return false;
    }

    @Override // oj5.c
    public final boolean w() {
        return false;
    }

    @Override // oj5.c
    public final boolean y() {
        return false;
    }

    @Override // oj5.c
    public final void z(int r1) {
    }

    @Override // oj5.c
    public final Integer A() {
        return Integer.valueOf(this.o.getOwnerType());
    }

    @Override // oj5.c
    public final int C() {
        return this.o.getOwnerType();
    }

    @Override // oj5.c
    public final String L() {
        ShareFolderUserPermission r0 = this.t;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getReportJson();
    }

    @Override // oj5.c
    public final boolean Q() {
        ShareFolderUserPermission r0 = this.t;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return true;
    L11:
        if (this.l == true) goto L13;
        return false;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.folder_permission_setting_manage_meta_check_disable") == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r0.canManagePermissionMeta(this.l) != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // oj5.c
    public final DocPermission c() {
        return new DocPermission(null, 3);
    }

    @Override // oj5.c
    public final Map<String, Boolean> K() {
        return MapsKt.emptyMap();
    }

    @Override // oj5.c
    public final String[] B() {
        return this.v;
    }

    @Override // oj5.c
    public final boolean D() {
        return this.n;
    }

    @Override // oj5.c
    public final boolean E() {
        return this.q;
    }

    @Override // oj5.c
    public final String H() {
        return this.s;
    }

    @Override // oj5.c
    public final Map<String, String> M() {
        return this.w;
    }

    @Override // oj5.c
    public final String a() {
        return this.h;
    }

    @Override // oj5.c
    public final boolean canOperateEntity() {
        return this.l;
    }

    @Override // oj5.c
    public final String d() {
        return this.f;
    }

    @Override // oj5.c
    public final String getContainerUrl() {
        return this.b;
    }

    @Override // oj5.c
    public final String getCreateTime() {
        return this.i;
    }

    @Override // oj5.c
    public final String getOwnerName() {
        return this.g;
    }

    @Override // oj5.c
    public final String getSpaceId() {
        return this.j;
    }

    @Override // oj5.c
    public final String getTitle() {
        return this.d;
    }

    @Override // oj5.c
    public final String getToken() {
        return this.c;
    }

    @Override // oj5.c
    public int getType() {
        return this.a;
    }

    @Override // oj5.c
    public final String getUrl() {
        return this.b;
    }

    @Override // oj5.c
    public final int i() {
        return this.a;
    }

    @Override // oj5.c
    public final boolean isOwner() {
        return this.l;
    }

    @Override // oj5.c
    public final boolean isShareFolder() {
        return this.p;
    }

    @Override // oj5.c
    public final boolean k() {
        return this.m;
    }

    @Override // oj5.c
    public final String t() {
        return this.e;
    }

    @Override // oj5.c
    public final String x() {
        return this.k;
    }

    public b(int r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25, boolean r26, FolderVersion r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "ownerUid");
        Intrinsics.checkNotNullParameter(r18, "creatorUid");
        Intrinsics.checkNotNullParameter(r19, "creatorName");
        Intrinsics.checkNotNullParameter(r20, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r21, "createTime");
        Intrinsics.checkNotNullParameter(r22, "spaceId");
        Intrinsics.checkNotNullParameter(r27, "version");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
        this.m = r25;
        this.n = r26;
        this.o = r27;
        this.p = r28;
    }
}
