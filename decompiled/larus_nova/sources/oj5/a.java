package oj5;

import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class a implements c {
    public boolean A;
    public ArrayList<BlockSimpleInfo> B;
    public ArrayList<BlockSimpleInfo> C;
    public int D;
    public String E;
    public String F;
    public Boolean G;
    public d H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Map<String, Boolean> f523529J;
    public String K;
    public boolean L;
    public boolean M;
    public String N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f523530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f523531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f523532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f523533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f523534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f523535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DocMetaInfo f523536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DocObjInfo f523537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DocPermission f523538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DocVersion f523539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f523540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f523541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f523542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f523543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f523544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f523545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f523546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f523547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IDocUserPermission f523548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ShareFolderUserPermission f523549t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f523550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f523551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, String> f523552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String[] f523553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String[] f523554y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String[] f523555z;

    public a() {
        this(0, null, null, null, false, false, null, null, null, null, false, null, 16383);
    }

    @Override // oj5.c
    public final String getSpaceId() {
        return "";
    }

    @Override // oj5.c
    public final boolean isShareFolder() {
        return false;
    }

    @Override // oj5.c
    public final Integer A() {
        if (this.f523539j.getNil() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(this.f523539j.getOwnerType());
    }

    @Override // oj5.c
    public final int C() {
        return this.f523539j.getOwnerType();
    }

    @Override // oj5.c
    public final boolean D() {
        if (this.f523536g.isStared() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f523537h.isStared() == true) goto L8;
        return false;
    }

    @Override // oj5.c
    public final String L() {
        return this.f523538i.f234419a.getReportJson();
    }

    @Override // oj5.c
    public final boolean P() {
        return this.f523537h.isSubscribeComment();
    }

    @Override // oj5.c
    public final boolean Q() {
        return this.f523538i.f234419a.canManagePermissionMeta();
    }

    @Override // oj5.c
    public final DocUpgradeInfo R() {
        return this.f523536g.getDocUpgradeInfo();
    }

    @Override // oj5.c
    public final String a() {
        return this.f523536g.getCreatorTenantId();
    }

    @Override // oj5.c
    public final String b() {
        return this.f523536g.getSubType();
    }

    @Override // oj5.c
    public final boolean canOperateEntity() {
        return this.f523538i.f234419a.canOperateEntity();
    }

    @Override // oj5.c
    public final String d() {
        return this.f523536g.getCreatorUid();
    }

    @Override // oj5.c
    public final String f() {
        DocMetaInfo r100 = this.f523536g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIcon_info();
    }

    @Override // oj5.c
    public final String getAppId() {
        return this.f523536g.getAppId();
    }

    @Override // oj5.c
    public final String getContainerUrl() {
        String r100 = this.E;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f523531b;
    }

    @Override // oj5.c
    public final String getCreateTime() {
        return this.f523536g.getCreateTime();
    }

    @Override // oj5.c
    public final String getOwnerName() {
        return this.f523536g.getOwnerName();
    }

    @Override // oj5.c
    public final int getTemplateType() {
        return this.f523536g.getTemplate_type();
    }

    @Override // oj5.c
    public final String getTitle() {
        String r100 = this.F;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        return r100;
    L12:
        return this.f523536g.getTitle();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // oj5.c
    public final int i() {
        int r100 = this.f523530a;
        if (r100 == sbb.e.f541303n.f541317b) goto L5;
        return r100;
    L5:
        return this.f523536g.getRealType();
    }

    @Override // oj5.c
    public final boolean isOwner() {
        return this.f523538i.f234420b.isOwner();
    }

    @Override // oj5.c
    public final boolean isSecretFileCopy() {
        return this.f523538i.f234419a.isSecretFileCopy();
    }

    @Override // oj5.c
    public final boolean isSecretFileEdit() {
        return this.f523538i.f234419a.isSecretFileEdit();
    }

    @Override // oj5.c
    public final boolean isSecretFileExport() {
        return this.f523538i.f234419a.isSecretFileExport();
    }

    @Override // oj5.c
    public final boolean isSecretFileView() {
        return this.f523538i.f234419a.isSecretFileView();
    }

    @Override // oj5.c
    public final boolean isSubscribe() {
        return this.f523537h.isSubscribed();
    }

    @Override // oj5.c
    public final boolean k() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L7;
        return this.f523537h.isPined();
    L7:
        return this.f523536g.isPined();
    }

    @Override // oj5.c
    public final boolean n() {
        return this.f523538i.f234419a.canEdit();
    }

    @Override // oj5.c
    public final boolean o() {
        int r100 = this.D;
        int r101 = com.bytedance.ee.bear.a.f206186a;
        if (r100 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // oj5.c
    public final boolean p() {
        return this.f523538i.f234419a.canExport();
    }

    @Override // oj5.c
    public final boolean q() {
        return this.f523538i.f234419a.canCreateCopy();
    }

    @Override // oj5.c
    public final String t() {
        return this.f523536g.getOwnerUid();
    }

    @Override // oj5.c
    public final boolean w() {
        Boolean r100 = this.G;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // oj5.c
    public final boolean y() {
        return this.f523538i.f234419a.canCopy();
    }

    @Override // oj5.c
    public final String[] B() {
        return this.f523551v;
    }

    @Override // oj5.c
    public final boolean E() {
        return this.f523545p;
    }

    @Override // oj5.c
    public final boolean F() {
        return this.f523534e;
    }

    @Override // oj5.c
    public final String H() {
        return this.f523547r;
    }

    @Override // oj5.c
    public final String I() {
        return this.K;
    }

    @Override // oj5.c
    public final Map<String, Boolean> K() {
        return this.f523529J;
    }

    @Override // oj5.c
    public final Map<String, String> M() {
        return this.f523552w;
    }

    @Override // oj5.c
    public final String N() {
        return this.N;
    }

    @Override // oj5.c
    public final String[] O() {
        return this.f523553x;
    }

    @Override // oj5.c
    public final DocPermission c() {
        return this.f523538i;
    }

    @Override // oj5.c
    public final boolean e() {
        return this.f523541l;
    }

    @Override // oj5.c
    public final String getToken() {
        return this.f523532c;
    }

    @Override // oj5.c
    public int getType() {
        return this.f523530a;
    }

    @Override // oj5.c
    public final String getUrl() {
        return this.f523531b;
    }

    @Override // oj5.c
    public final boolean h() {
        return this.M;
    }

    @Override // oj5.c
    public final boolean j() {
        return this.f523535f;
    }

    @Override // oj5.c
    public final String[] l() {
        return this.f523555z;
    }

    @Override // oj5.c
    public final boolean m() {
        return this.f523540k;
    }

    @Override // oj5.c
    public final boolean s() {
        return this.L;
    }

    @Override // oj5.c
    public final String[] u() {
        return this.f523554y;
    }

    @Override // oj5.c
    public boolean v() {
        return this.f523542m;
    }

    @Override // oj5.c
    public final String x() {
        return this.f523533d;
    }

    @Override // oj5.c
    public final void G(boolean r100) {
        this.f523537h.setSubscribeComment(r100);
    }

    @Override // oj5.c
    public final void J(boolean r100) {
        this.f523535f = r100;
    }

    public final void S(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemHasBenefitMap");
        this.f523529J = r100;
    }

    @Override // oj5.c
    public final void g(boolean r100) {
        this.f523537h.setSubscribed(r100);
    }

    @Override // oj5.c
    public final void r(DocPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "docPermission");
        this.f523538i = r100;
    }

    @Override // oj5.c
    public final void z(int r100) {
        this.f523536g.setTemplate_type(r100);
    }

    public /* synthetic */ a(int r510, String r511, String r512, String r513, boolean r514, boolean r515, DocMetaInfo r610, DocObjInfo r611, DocPermission r612, DocVersion r613, boolean r614, String r615, int r616) {
        if ((r616 & 1) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r616 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r616 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r616 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r616 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r616 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r616 & 64) == 0) goto L29;
        DocMetaInfo r106 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L31:
        if ((r616 & 128) == 0) goto L33;
        DocObjInfo r110 = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    L35:
        if ((r616 & 256) == 0) goto L37;
        DocPermission r111 = new DocPermission(null, 3);
    L39:
        if ((r616 & 512) == 0) goto L41;
        DocVersion r112 = new DocVersion(0, 1, null);
    L43:
        if ((r616 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r616 & 8192) == 0) goto L49;
        String r114 = null;
    L50:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, false, false, r114);
        return;
    L49:
        r114 = r615;
        goto L50
    L45:
        r113 = r614;
        goto L47
    L41:
        r112 = r613;
        goto L43
    L37:
        r111 = r612;
        goto L39
    L33:
        r110 = r611;
        goto L35
    L29:
        r106 = r610;
        goto L31
    L25:
        r105 = r515;
        goto L27
    L21:
        r104 = r514;
        goto L23
    L17:
        r103 = r513;
        goto L19
    L13:
        r102 = r512;
        goto L15
    L9:
        r101 = r511;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    public a(int r100, String r101, String r102, String r103, boolean r104, boolean r105, DocMetaInfo r106, DocObjInfo r107, DocPermission r110, DocVersion r111, boolean r112, boolean r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r106, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r107, "docObjInfo");
        Intrinsics.checkNotNullParameter(r110, "docPermission");
        Intrinsics.checkNotNullParameter(r111, "version");
        this.f523530a = r100;
        this.f523531b = r101;
        this.f523532c = r102;
        this.f523533d = r103;
        this.f523534e = r104;
        this.f523535f = r105;
        this.f523536g = r106;
        this.f523537h = r107;
        this.f523538i = r110;
        this.f523539j = r111;
        this.f523540k = r112;
        this.f523541l = r113;
        this.f523542m = r114;
        this.f523543n = r115;
        this.f523544o = "";
        this.f523548s = new DefaultDocUserPermission();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = -1;
        this.f523529J = new LinkedHashMap();
    }
}
