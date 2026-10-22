package oj5;

import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f523558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f523559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f523560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f523561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f523562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f523563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f523564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f523565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f523566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f523567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f523568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f523569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FolderVersion f523570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f523571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f523572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f523573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f523574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ShareFolderUserPermission f523575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public IDocUserPermission f523576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f523577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, String> f523578w;

    public b() {
        this(0, "", "", "", "", "", "", "", "", "", null, false, false, false, new FolderVersion(0, 0, false, 7, null), false);
    }

    @Override // oj5.c
    public final boolean F() {
        return false;
    }

    @Override // oj5.c
    public final void G(boolean r100) {
    }

    @Override // oj5.c
    public final String I() {
        return "";
    }

    @Override // oj5.c
    public final void J(boolean r100) {
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
    public final void g(boolean r100) {
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
    public final void r(DocPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "docPermission");
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
    public final void z(int r100) {
    }

    @Override // oj5.c
    public final Integer A() {
        return Integer.valueOf(this.f523570o.getOwnerType());
    }

    @Override // oj5.c
    public final int C() {
        return this.f523570o.getOwnerType();
    }

    @Override // oj5.c
    public final String L() {
        ShareFolderUserPermission r100 = this.f523575t;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getReportJson();
    }

    @Override // oj5.c
    public final boolean Q() {
        ShareFolderUserPermission r100 = this.f523575t;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return true;
    L11:
        if (this.f523567l == true) goto L13;
        return false;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.mobile.folder_permission_setting_manage_meta_check_disable") == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r100.canManagePermissionMeta(this.f523567l) != true) goto L7;
        r101 = true;
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
        return this.f523577v;
    }

    @Override // oj5.c
    public final boolean D() {
        return this.f523569n;
    }

    @Override // oj5.c
    public final boolean E() {
        return this.f523572q;
    }

    @Override // oj5.c
    public final String H() {
        return this.f523574s;
    }

    @Override // oj5.c
    public final Map<String, String> M() {
        return this.f523578w;
    }

    @Override // oj5.c
    public final String a() {
        return this.f523563h;
    }

    @Override // oj5.c
    public final boolean canOperateEntity() {
        return this.f523567l;
    }

    @Override // oj5.c
    public final String d() {
        return this.f523561f;
    }

    @Override // oj5.c
    public final String getContainerUrl() {
        return this.f523557b;
    }

    @Override // oj5.c
    public final String getCreateTime() {
        return this.f523564i;
    }

    @Override // oj5.c
    public final String getOwnerName() {
        return this.f523562g;
    }

    @Override // oj5.c
    public final String getSpaceId() {
        return this.f523565j;
    }

    @Override // oj5.c
    public final String getTitle() {
        return this.f523559d;
    }

    @Override // oj5.c
    public final String getToken() {
        return this.f523558c;
    }

    @Override // oj5.c
    public int getType() {
        return this.f523556a;
    }

    @Override // oj5.c
    public final String getUrl() {
        return this.f523557b;
    }

    @Override // oj5.c
    public final int i() {
        return this.f523556a;
    }

    @Override // oj5.c
    public final boolean isOwner() {
        return this.f523567l;
    }

    @Override // oj5.c
    public final boolean isShareFolder() {
        return this.f523571p;
    }

    @Override // oj5.c
    public final boolean k() {
        return this.f523568m;
    }

    @Override // oj5.c
    public final String t() {
        return this.f523560e;
    }

    @Override // oj5.c
    public final String x() {
        return this.f523566k;
    }

    public b(int r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, FolderVersion r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "token");
        Intrinsics.checkNotNullParameter(r113, "title");
        Intrinsics.checkNotNullParameter(r114, "ownerUid");
        Intrinsics.checkNotNullParameter(r115, "creatorUid");
        Intrinsics.checkNotNullParameter(r116, "creatorName");
        Intrinsics.checkNotNullParameter(r210, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r211, "createTime");
        Intrinsics.checkNotNullParameter(r212, "spaceId");
        Intrinsics.checkNotNullParameter(r217, "version");
        this.f523556a = r110;
        this.f523557b = r111;
        this.f523558c = r112;
        this.f523559d = r113;
        this.f523560e = r114;
        this.f523561f = r115;
        this.f523562g = r116;
        this.f523563h = r210;
        this.f523564i = r211;
        this.f523565j = r212;
        this.f523566k = r213;
        this.f523567l = r214;
        this.f523568m = r215;
        this.f523569n = r216;
        this.f523570o = r217;
        this.f523571p = r218;
    }
}
