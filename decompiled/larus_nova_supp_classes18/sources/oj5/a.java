package oj5;

import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public Map<String, Boolean> J;
    public String K;
    public boolean L;
    public boolean M;
    public String N;
    public int a;
    public String b;
    public String c;
    public final String d;
    public boolean e;
    public boolean f;
    public DocMetaInfo g;
    public DocObjInfo h;
    public DocPermission i;
    public DocVersion j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final String n;
    public String o;
    public boolean p;
    public boolean q;
    public String r;
    public IDocUserPermission s;
    public ShareFolderUserPermission t;
    public String u;
    public String[] v;
    public Map<String, String> w;
    public String[] x;
    public String[] y;
    public String[] z;

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
        if (this.j.getNil() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(this.j.getOwnerType());
    }

    @Override // oj5.c
    public final int C() {
        return this.j.getOwnerType();
    }

    @Override // oj5.c
    public final boolean D() {
        if (this.g.isStared() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.h.isStared() == true) goto L8;
        return false;
    }

    @Override // oj5.c
    public final String L() {
        return this.i.a.getReportJson();
    }

    @Override // oj5.c
    public final boolean P() {
        return this.h.isSubscribeComment();
    }

    @Override // oj5.c
    public final boolean Q() {
        return this.i.a.canManagePermissionMeta();
    }

    @Override // oj5.c
    public final DocUpgradeInfo R() {
        return this.g.getDocUpgradeInfo();
    }

    @Override // oj5.c
    public final String a() {
        return this.g.getCreatorTenantId();
    }

    @Override // oj5.c
    public final String b() {
        return this.g.getSubType();
    }

    @Override // oj5.c
    public final boolean canOperateEntity() {
        return this.i.a.canOperateEntity();
    }

    @Override // oj5.c
    public final String d() {
        return this.g.getCreatorUid();
    }

    @Override // oj5.c
    public final String f() {
        DocMetaInfo r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getIcon_info();
    }

    @Override // oj5.c
    public final String getAppId() {
        return this.g.getAppId();
    }

    @Override // oj5.c
    public final String getContainerUrl() {
        String r0 = this.E;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.b;
    }

    @Override // oj5.c
    public final String getCreateTime() {
        return this.g.getCreateTime();
    }

    @Override // oj5.c
    public final String getOwnerName() {
        return this.g.getOwnerName();
    }

    @Override // oj5.c
    public final int getTemplateType() {
        return this.g.getTemplate_type();
    }

    @Override // oj5.c
    public final String getTitle() {
        String r0 = this.F;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return r0;
    L12:
        return this.g.getTitle();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // oj5.c
    public final int i() {
        int r0 = this.a;
        if (r0 == sbb.e.n.b) goto L5;
        return r0;
    L5:
        return this.g.getRealType();
    }

    @Override // oj5.c
    public final boolean isOwner() {
        return this.i.b.isOwner();
    }

    @Override // oj5.c
    public final boolean isSecretFileCopy() {
        return this.i.a.isSecretFileCopy();
    }

    @Override // oj5.c
    public final boolean isSecretFileEdit() {
        return this.i.a.isSecretFileEdit();
    }

    @Override // oj5.c
    public final boolean isSecretFileExport() {
        return this.i.a.isSecretFileExport();
    }

    @Override // oj5.c
    public final boolean isSecretFileView() {
        return this.i.a.isSecretFileView();
    }

    @Override // oj5.c
    public final boolean isSubscribe() {
        return this.h.isSubscribed();
    }

    @Override // oj5.c
    public final boolean k() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L7;
        return this.h.isPined();
    L7:
        return this.g.isPined();
    }

    @Override // oj5.c
    public final boolean n() {
        return this.i.a.canEdit();
    }

    @Override // oj5.c
    public final boolean o() {
        int r0 = this.D;
        int r1 = com.bytedance.ee.bear.a.a;
        if (r0 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // oj5.c
    public final boolean p() {
        return this.i.a.canExport();
    }

    @Override // oj5.c
    public final boolean q() {
        return this.i.a.canCreateCopy();
    }

    @Override // oj5.c
    public final String t() {
        return this.g.getOwnerUid();
    }

    @Override // oj5.c
    public final boolean w() {
        Boolean r0 = this.G;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // oj5.c
    public final boolean y() {
        return this.i.a.canCopy();
    }

    @Override // oj5.c
    public final String[] B() {
        return this.v;
    }

    @Override // oj5.c
    public final boolean E() {
        return this.p;
    }

    @Override // oj5.c
    public final boolean F() {
        return this.e;
    }

    @Override // oj5.c
    public final String H() {
        return this.r;
    }

    @Override // oj5.c
    public final String I() {
        return this.K;
    }

    @Override // oj5.c
    public final Map<String, Boolean> K() {
        return this.J;
    }

    @Override // oj5.c
    public final Map<String, String> M() {
        return this.w;
    }

    @Override // oj5.c
    public final String N() {
        return this.N;
    }

    @Override // oj5.c
    public final String[] O() {
        return this.x;
    }

    @Override // oj5.c
    public final DocPermission c() {
        return this.i;
    }

    @Override // oj5.c
    public final boolean e() {
        return this.l;
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
    public final boolean h() {
        return this.M;
    }

    @Override // oj5.c
    public final boolean j() {
        return this.f;
    }

    @Override // oj5.c
    public final String[] l() {
        return this.z;
    }

    @Override // oj5.c
    public final boolean m() {
        return this.k;
    }

    @Override // oj5.c
    public final boolean s() {
        return this.L;
    }

    @Override // oj5.c
    public final String[] u() {
        return this.y;
    }

    @Override // oj5.c
    public boolean v() {
        return this.m;
    }

    @Override // oj5.c
    public final String x() {
        return this.d;
    }

    @Override // oj5.c
    public final void G(boolean r2) {
        this.h.setSubscribeComment(r2);
    }

    @Override // oj5.c
    public final void J(boolean r1) {
        this.f = r1;
    }

    public final void S(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemHasBenefitMap");
        this.J = r2;
    }

    @Override // oj5.c
    public final void g(boolean r2) {
        this.h.setSubscribed(r2);
    }

    @Override // oj5.c
    public final void r(DocPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "docPermission");
        this.i = r2;
    }

    @Override // oj5.c
    public final void z(int r2) {
        this.g.setTemplate_type(r2);
    }

    public /* synthetic */ a(int r54, String r55, String r56, String r57, boolean r58, boolean r59, DocMetaInfo r60, DocObjInfo r61, DocPermission r62, DocVersion r63, boolean r64, String r65, int r66) {
        if ((r66 & 1) == 0) goto L5;
        int r3 = -1;
    L7:
        if ((r66 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r66 & 4) == 0) goto L13;
        String r5 = "";
    L14:
        IDocUserPermission r2 = null;
        if ((r66 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r66 & 16) == 0) goto L21;
        boolean r1 = false;
    L23:
        if ((r66 & 32) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r66 & 64) == 0) goto L29;
        DocMetaInfo r9 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L31:
        if ((r66 & 128) == 0) goto L33;
        DocObjInfo r10 = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    L35:
        if ((r66 & 256) == 0) goto L37;
        DocPermission r11 = new DocPermission(r2, 3);
    L39:
        if ((r66 & 512) == 0) goto L41;
        DocVersion r12 = new DocVersion(0, 1, null);
    L43:
        if ((r66 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r66 & 8192) == 0) goto L49;
        String r16 = null;
    L50:
        this(r3, r4, r5, r6, r1, r8, r9, r10, r11, r12, r13, false, false, r16);
        return;
    L49:
        r16 = r65;
        goto L50
    L45:
        r13 = r64;
        goto L47
    L41:
        r12 = r63;
        goto L43
    L37:
        r11 = r62;
        goto L39
    L33:
        r10 = r61;
        goto L35
    L29:
        r9 = r60;
        goto L31
    L25:
        r8 = r59;
        goto L27
    L21:
        r1 = r58;
        goto L23
    L17:
        r6 = r57;
        goto L19
    L13:
        r5 = r56;
        goto L14
    L9:
        r4 = r55;
        goto L11
    L5:
        r3 = r54;
        goto L7
    }

    public a(int r2, String r3, String r4, String r5, boolean r6, boolean r7, DocMetaInfo r8, DocObjInfo r9, DocPermission r10, DocVersion r11, boolean r12, boolean r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r9, "docObjInfo");
        Intrinsics.checkNotNullParameter(r10, "docPermission");
        Intrinsics.checkNotNullParameter(r11, "version");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
        this.o = "";
        this.s = new DefaultDocUserPermission();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = -1;
        this.J = new LinkedHashMap();
    }
}
