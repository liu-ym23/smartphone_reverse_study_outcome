package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 P2\u00020\u0001:\u0001PBÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0006j\b\u0012\u0004\u0012\u00020\u0010`\b\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010?\u001a\u00020@2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u0017J\u0006\u0010A\u001a\u00020\u0017J\u0016\u0010B\u001a\u00020@2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0017J\u000e\u0010B\u001a\u00020@2\u0006\u0010<\u001a\u00020\u0017J\u000e\u0010C\u001a\u00020@2\u0006\u0010>\u001a\u00020\u0017J\u0006\u0010>\u001a\u00020\u0017J\u0006\u0010=\u001a\u00020\u0017J\u0006\u0010D\u001a\u00020\u0017J\u0006\u0010E\u001a\u00020\u0017J\u0006\u0010<\u001a\u00020\u0017J\u0006\u0010F\u001a\u00020\u0017J\u0006\u0010G\u001a\u00020\u0019J\u0006\u0010H\u001a\u00020\u0019J\u0006\u0010I\u001a\u00020\u0019J\u0006\u0010J\u001a\u00020\u0017J\u0006\u0010K\u001a\u00020\u0017J\u0013\u0010L\u001a\u00020\u00172\b\u0010M\u001a\u0004\u0018\u00010NH\u0096\u0002J\b\u0010O\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0006j\b\u0012\u0004\u0012\u00020\u0010`\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u00100\"\u0004\b1\u00102R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u001a\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u00100\"\u0004\b7\u00102R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b\u001b\u00108R\u000e\u0010:\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lcom/bytedance/ee/util/io/NonProguard;", "roleId", "", "name", "members", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "baseRule", "Lcom/bytedance/ee/bear/bitable/pro/BaseRule;", "dashboardRule", "Lcom/bytedance/ee/bear/bitable/pro/DashboardRule;", "automationRule", "Lcom/bytedance/ee/bear/bitable/pro/AutomationRule;", "tableRoleList", "Lcom/bytedance/ee/bear/bitable/pro/TableRole;", "dashboardRoleList", "Lcom/bytedance/ee/bear/bitable/pro/BlockRole;", "docxRoleList", "createdTime", "", "isDefault", "", "defaultType", "", "isFaType", "isSoloBaseSuite", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/bytedance/ee/bear/bitable/pro/BaseRule;Lcom/bytedance/ee/bear/bitable/pro/DashboardRule;Lcom/bytedance/ee/bear/bitable/pro/AutomationRule;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;JZIZLjava/lang/Boolean;)V", "getRoleId", "()Ljava/lang/String;", "getName", "getMembers", "()Ljava/util/ArrayList;", "getBaseRule", "()Lcom/bytedance/ee/bear/bitable/pro/BaseRule;", "getDashboardRule", "()Lcom/bytedance/ee/bear/bitable/pro/DashboardRule;", "getAutomationRule", "()Lcom/bytedance/ee/bear/bitable/pro/AutomationRule;", "getTableRoleList", "getDashboardRoleList", "getDocxRoleList", "setDocxRoleList", "(Ljava/util/ArrayList;)V", "getCreatedTime", "()J", "()Z", "setDefault", "(Z)V", "getDefaultType", "()I", "setDefaultType", "(I)V", "setFaType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "rowPermitted", "fieldPermitted", "isPro", "isTemplate", "isDefaultRole", "setCostInfo", "", "hasCostPerm", "setIsPro", "setIsDefaultRole", "disableAddMembers", "disableEditMembers", "hasMembers", "getCanReadTableCount", "getCanEditTableCount", "getCanReadDashboardCount", "isDefaultTypeEdit", "isDefaultTypeRead", "equals", "other", "", "hashCode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Role implements NonProguard {
    public static final a Companion = null;
    public static final int DEFAULT_TYPE_EDIT = 1;
    public static final int DEFAULT_TYPE_READ = 2;
    private final AutomationRule automationRule;
    private final BaseRule baseRule;
    private final long createdTime;
    private final ArrayList<BlockRole> dashboardRoleList;
    private final DashboardRule dashboardRule;
    private int defaultType;
    private ArrayList<BlockRole> docxRoleList;
    private boolean fieldPermitted;
    private boolean isDefault;
    private boolean isDefaultRole;
    private boolean isFaType;
    private boolean isPro;
    private final Boolean isSoloBaseSuite;
    private boolean isTemplate;
    private final ArrayList<UserInfo> members;
    private final String name;
    private final String roleId;
    private boolean rowPermitted;
    private final ArrayList<TableRole> tableRoleList;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Role() {
        this(null, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16383, null);
    }

    public final boolean disableAddMembers() {
        if (this.isPro == true) goto L5;
    L8:
        return true;
    L5:
        if (hasCostPerm() == true) goto L8;
        return false;
    }

    public final boolean disableEditMembers() {
        return !this.isPro;
    }

    public final int getCanEditTableCount() {
        Iterator<TableRole> r100 = this.tableRoleList.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r100.next().canEdit() == false) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    public final int getCanReadDashboardCount() {
        Iterator<BlockRole> r100 = this.dashboardRoleList.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r100.next().canRead() == false) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    public final int getCanReadTableCount() {
        Iterator<TableRole> r100 = this.tableRoleList.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r100.next().canRead() == false) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    public final boolean hasCostPerm() {
        if (this.rowPermitted == true) goto L5;
    L6:
        Iterator<TableRole> r100 = this.tableRoleList.iterator();
        boolean r101 = false;
    L8:
        if (r100.hasNext() == false) goto L21;
        TableRole r102 = r100.next();
        if (this.rowPermitted == true) goto L14;
        if (r102.getRecRule() == null) goto L14;
    L17:
        r101 = true;
    L19:
        if (r101 == false) goto L8;
    L14:
        if (this.fieldPermitted == false) goto L16;
    L18:
        r101 = false;
        goto L19
    L16:
        if (r102.getHasFieldPerm() == false) goto L18;
    L21:
        return r101;
    L5:
        if (this.fieldPermitted == false) goto L6;
        return false;
    }

    public final boolean hasMembers() {
        return !this.members.isEmpty();
    }

    public int hashCode() {
        return this.roleId.hashCode();
    }

    public final boolean isDefaultTypeEdit() {
        if (this.defaultType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isDefaultTypeRead() {
        if (this.defaultType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final AutomationRule getAutomationRule() {
        return this.automationRule;
    }

    public final BaseRule getBaseRule() {
        return this.baseRule;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final ArrayList<BlockRole> getDashboardRoleList() {
        return this.dashboardRoleList;
    }

    public final DashboardRule getDashboardRule() {
        return this.dashboardRule;
    }

    public final int getDefaultType() {
        return this.defaultType;
    }

    public final ArrayList<BlockRole> getDocxRoleList() {
        return this.docxRoleList;
    }

    public final ArrayList<UserInfo> getMembers() {
        return this.members;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoleId() {
        return this.roleId;
    }

    public final ArrayList<TableRole> getTableRoleList() {
        return this.tableRoleList;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean isDefaultRole() {
        return this.isDefaultRole;
    }

    public final boolean isFaType() {
        return this.isFaType;
    }

    public final boolean isPro() {
        return this.isPro;
    }

    public final Boolean isSoloBaseSuite() {
        return this.isSoloBaseSuite;
    }

    public final boolean isTemplate() {
        return this.isTemplate;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Role.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.Role");
        if (Intrinsics.areEqual(this.roleId, ((Role) r100).roleId) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setDefault(boolean r100) {
        this.isDefault = r100;
    }

    public final void setDefaultType(int r100) {
        this.defaultType = r100;
    }

    public final void setDocxRoleList(ArrayList<BlockRole> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docxRoleList = r100;
    }

    public final void setFaType(boolean r100) {
        this.isFaType = r100;
    }

    public final void setIsDefaultRole(boolean r100) {
        this.isDefaultRole = r100;
    }

    public final void setIsPro(boolean r100) {
        this.isPro = r100;
    }

    public final void setCostInfo(boolean r100, boolean r101) {
        this.rowPermitted = r100;
        this.fieldPermitted = r101;
    }

    public final void setIsPro(boolean r100, boolean r101) {
        this.isPro = r100;
        this.isTemplate = r101;
    }

    public Role(String r100, String r110, ArrayList<UserInfo> r111, BaseRule r112, DashboardRule r113, AutomationRule r114, ArrayList<TableRole> r115, ArrayList<BlockRole> r116, ArrayList<BlockRole> r117, long r118, boolean r210, int r211, boolean r212, Boolean r213) {
        Intrinsics.checkNotNullParameter(r100, "roleId");
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "members");
        Intrinsics.checkNotNullParameter(r115, "tableRoleList");
        Intrinsics.checkNotNullParameter(r116, "dashboardRoleList");
        Intrinsics.checkNotNullParameter(r117, "docxRoleList");
        this.roleId = r100;
        this.name = r110;
        this.members = r111;
        this.baseRule = r112;
        this.dashboardRule = r113;
        this.automationRule = r114;
        this.tableRoleList = r115;
        this.dashboardRoleList = r116;
        this.docxRoleList = r117;
        this.createdTime = r118;
        this.isDefault = r210;
        this.defaultType = r211;
        this.isFaType = r212;
        this.isSoloBaseSuite = r213;
        this.isPro = true;
    }

    public /* synthetic */ Role(String r110, String r111, ArrayList r112, BaseRule r210, DashboardRule r211, AutomationRule r212, ArrayList r213, ArrayList r214, ArrayList r215, long r216, boolean r217, int r218, boolean r310, Boolean r311, int r312, DefaultConstructorMarker r313) {
        String r100 = "";
        if ((r312 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r312 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r312 & 4) == 0) goto L13;
        ArrayList r102 = new ArrayList();
    L15:
        if ((r312 & 8) == 0) goto L17;
        BaseRule r103 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        DashboardRule r104 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        AutomationRule r105 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        ArrayList r106 = new ArrayList();
    L31:
        if ((r312 & 128) == 0) goto L33;
        ArrayList r107 = new ArrayList();
    L35:
        if ((r312 & 256) == 0) goto L37;
        ArrayList r113 = new ArrayList();
    L39:
        if ((r312 & 512) == 0) goto L41;
        long r114 = 0;
    L42:
        boolean r115 = false;
        if ((r312 & 1024) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r117 = 0;
    L51:
        if ((r312 & 4096) != 0) goto L55;
        r115 = r310;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Boolean r108 = null;
    L58:
        this(r101, r100, r102, r103, r104, r105, r106, r107, r113, r114, r116, r117, r115, r108);
        return;
    L57:
        r108 = r311;
        goto L58
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L42
    L37:
        r113 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
