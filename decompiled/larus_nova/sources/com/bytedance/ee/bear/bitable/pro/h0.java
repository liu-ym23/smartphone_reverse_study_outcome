package com.bytedance.ee.bear.bitable.pro;

import android.text.TextUtils;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class h0 implements NetService.c<RoleResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<BlockSimpleInfo> f215179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<BlockSimpleInfo> f215180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f215181c;

    public final ArrayList<BlockSimpleInfo> a() {
        ArrayList<BlockSimpleInfo> r100 = this.f215180b;
        Collection r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if (((BlockSimpleInfo) r103).isTable().booleanValue() == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        if (r101.isEmpty() == false) goto L12;
        r101 = this.f215179a;
    L12:
        return new ArrayList(r101);
    }

    public static AutomationRule b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "roleObj");
        JSONObject r101 = r100.optJSONObject("automationRule");
        if (r101 == null) goto L12;
        HashMap r102 = new HashMap();
        JSONObject r103 = r101.optJSONObject("actionRuleMap");
        if (r103 == null) goto L11;
        Iterator<String> r104 = r103.keys();
    L8:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        r102.put(r105, Integer.valueOf(r101.optInt(r105)));
    L11:
        return new AutomationRule(r101.optBoolean("isEnable"), r102);
    L12:
        return null;
    }

    public static BaseRule c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "roleObj");
        JSONObject r101 = r100.optJSONObject("baseRule");
        if (r101 == null) goto L10;
        BaseRule r102 = new BaseRule();
        Iterator<String> r103 = r101.keys();
        if (r103 != null) goto L7;
    L9:
        return r102;
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();
        r102.put(r104, Integer.valueOf(r101.optInt(r104)));
        goto L7
    L10:
        return null;
    }

    public static DashboardRule d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "roleObj");
        JSONObject r101 = r100.optJSONObject("dashboardRule");
        if (r101 == null) goto L12;
        HashMap r102 = new HashMap();
        JSONObject r103 = r101.optJSONObject("actionRuleMap");
        if (r103 == null) goto L11;
        Iterator<String> r104 = r103.keys();
    L8:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        r102.put(r105, Integer.valueOf(r101.optInt(r105)));
    L11:
        return new DashboardRule(r101.optBoolean("isEnable"), r102);
    L12:
        return null;
    }

    public static ArrayList g(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        JSONObject r104 = r100.optJSONObject(r103);
        UserInfo r105 = new UserInfo();
        r105.setAvatarUrl(r104.optString("memberAvatarUrl", ""));
        r105.setLabel(r104.optString("memberDepartmentName", ""));
        r105.setEnName(r104.optString("memberEnName", ""));
        r105.setId(r104.optString("memberId", ""));
        r105.setName(r104.optString("memberName", ""));
        r105.setCnName(r105.getName());
        r105.setOwnerType(r104.optInt("memberType", 0));
        r105.setDisplayName(r104.optString("memberDisplayName", ""));
        r105.setExternal(r104.optBoolean("isExternal"));
        JSONObject r106 = r104.optJSONObject("displayTag");
        if (r106 == null) goto L7;
        String r107 = r106.optString("tag_value");
    L8:
        r105.setOrganizationTagValue(r107);
        r101.add(r105);
        r103 = r103 + 1;
        goto L3
    L7:
        r107 = null;
        goto L8
    L9:
        return r101;
    }

    public final ArrayList<BlockRole> e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "roleObj");
        ArrayList<BlockRole> r101 = new ArrayList();
        JSONObject r102 = r100.optJSONObject("blockRoleMap");
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        ArrayList<BlockSimpleInfo> r103 = this.f215180b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((BlockSimpleInfo) r106).isDashboard().booleanValue() == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        Iterator r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L18;
        BlockSimpleInfo r108 = (BlockSimpleInfo) r107.next();
        String r109 = r108.getId();
        JSONObject r110 = r102.optJSONObject(r109);
        if (r110 != null) goto L17;
        r110 = new JSONObject();
    L17:
        Intrinsics.checkNotNull(r109);
        r101.add(new BlockRole(r109, r108.getName(), r110.optInt("perm")));
        goto L13
    L18:
        return r101;
    }

    public final ArrayList<BlockRole> f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "roleObj");
        ArrayList<BlockRole> r101 = new ArrayList();
        JSONObject r102 = r100.optJSONObject("blockRoleMap");
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        ArrayList<BlockSimpleInfo> r103 = this.f215180b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((BlockSimpleInfo) r106).isDocx().booleanValue() == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        Iterator r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L18;
        BlockSimpleInfo r108 = (BlockSimpleInfo) r107.next();
        String r109 = r108.getId();
        JSONObject r110 = r102.optJSONObject(r109);
        if (r110 != null) goto L17;
        r110 = new JSONObject();
    L17:
        Intrinsics.checkNotNull(r109);
        r101.add(new BlockRole(r109, r108.getName(), r110.optInt("perm")));
        goto L13
    L18:
        return r101;
    }

    public final ArrayList<TableRole> h(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "roleObj");
        ArrayList r100 = new ArrayList();
        JSONObject r111 = r110.optJSONObject("tableRoleMap");
        if (r111 != null) goto L5;
        r111 = new JSONObject();
    L5:
        Iterator<String> r101 = r111.keys();
    L6:
        RecRule r102 = null;
        if (r101.hasNext() == false) goto L30;
        String r103 = r101.next();
        JSONObject r104 = r111.optJSONObject(r103);
        if (r104 != null) goto L11;
        r104 = new JSONObject();
    L11:
        JSONObject r105 = r104.optJSONObject("recRule");
        if (r105 == null) goto L14;
        RecRule r106 = new RecRule(r105.optInt("perm"), r105.optInt("otherPerm"));
    L15:
        JSONObject r107 = r104.optJSONObject("otherRecRule");
        if (r107 == null) goto L18;
        r102 = new RecRule(r107.optInt("perm"), r107.optInt("otherPerm"));
    L18:
        RecRule r112 = r102;
        if (r104.optJSONObject("fieldPerm") == null) goto L21;
        boolean r108 = true;
    L22:
        Intrinsics.checkNotNull(r103);
        Iterator<BlockSimpleInfo> r109 = a().iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        BlockSimpleInfo r113 = r109.next();
        if (TextUtils.equals(r103, r113.getId()) == false) goto L24;
        String r114 = r113.getName();
    L29:
        r100.add(new TableRole(r103, r114, r104.optInt("perm"), r106, r108, r112));
        goto L6
    L28:
        r114 = "";
        goto L29
    L21:
        r108 = false;
        goto L22
    L14:
        r106 = null;
        goto L15
    L30:
        ArrayList<TableRole> r115 = new ArrayList();
        Iterator<BlockSimpleInfo> r116 = a().iterator();
    L32:
        if (r116.hasNext() == false) goto L43;
        BlockSimpleInfo r117 = r116.next();
        String r118 = r117.getId();
        Iterator r119 = r100.iterator();
    L35:
        if (r119.hasNext() == false) goto L39;
        TableRole r120 = (TableRole) r119.next();
        if (TextUtils.equals(r120.getTableId(), r118) == false) goto L35;
    L40:
        if (r120 != null) goto L41;
        r115.add(new TableRole(r117.getId(), r117.getName(), 0, null, false, null));
        goto L32
    L41:
        r115.add(r120);
        goto L32
    L39:
        r120 = null;
        goto L40
    L43:
        return r115;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r410) {
    L70:
        th = move-exception;
        tt5.a.l(this.f215181c, "BitableRoleResultParser.parse() error...", th);
        return new RoleResult(null, null, null, null, 15, null);
    L4:
        String r100 = "";
        if (r410 != null) goto L7;
        String r101 = "";
    L8:
        JSONObject r102 = new JSONObject(r101).optJSONObject("data");     // Catch: Throwable -> L70
        if (r102 != null) goto L11;
        r102 = new JSONObject();     // Catch: Throwable -> L70
    L11:
        JSONObject r103 = r102.optJSONObject("roleMap");     // Catch: Throwable -> L70
        if (r103 != null) goto L14;
        r103 = new JSONObject();     // Catch: Throwable -> L70
    L14:
        HashMap r104 = new HashMap();     // Catch: Throwable -> L70
        Iterator<String> r105 = r103.keys();     // Catch: Throwable -> L70
    L16:
        if (r105.hasNext() == false) goto L24;
        String r106 = r105.next();     // Catch: Throwable -> L70
        JSONObject r107 = r103.optJSONObject(r106);     // Catch: Throwable -> L70
        if (r107 != null) goto L20;
        r107 = new JSONObject();     // Catch: Throwable -> L70
    L20:
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L70
        String r108 = r107.optString("name");     // Catch: Throwable -> L70
        JSONArray r109 = r107.optJSONArray("members");     // Catch: Throwable -> L70
        if (r109 != null) goto L23;
        r109 = new JSONArray();     // Catch: Throwable -> L70
    L23:
        r104.put(r106, new Role(r106, r108, g(r109), c(r107), d(r107), b(r107), h(r107), e(r107), f(r107), r107.optLong("createdTime", 0), false, 0, false, null, 15360, null));     // Catch: Throwable -> L70
        r103 = r103;
        r100 = r100;
        r105 = r105;
        goto L16
    L24:
        String r210 = r100;
        JSONObject r110 = r102.optJSONObject("defaultEditRole");     // Catch: Throwable -> L70
        DefaultConfig r111 = null;
        if (r110 == null) goto L41;
        String r112 = r110.optString("roleId");     // Catch: Throwable -> L70
        if (r112 != null) goto L30;
        r112 = r210;
    L30:
        Role r113 = (Role) r104.get(r112);     // Catch: Throwable -> L70
        if (r113 != null) goto L33;
        r113 = new Role(r112, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16382, null);     // Catch: Throwable -> L70
    L33:
        r113.setDefault(true);     // Catch: Throwable -> L70
        r113.setDefaultType(1);     // Catch: Throwable -> L70
        r104.remove(r112);     // Catch: Throwable -> L70
        JSONObject r114 = r102.optJSONObject("extraMembers");     // Catch: Throwable -> L70
        if (r114 == null) goto L39;
        JSONArray r115 = r114.optJSONArray("editMembers");     // Catch: Throwable -> L70
        if (r115 == null) goto L39;
        ArrayList r116 = g(r115);     // Catch: Throwable -> L70
    L40:
        r113.getMembers().addAll(r116);     // Catch: Throwable -> L70
    L42:
        JSONObject r117 = r102.optJSONObject("defaultReadRole");     // Catch: Throwable -> L70
        if (r117 == null) goto L58;
        String r118 = r117.optString("roleId");     // Catch: Throwable -> L70
        if (r118 != null) goto L47;
        r118 = r210;
    L47:
        Role r119 = (Role) r104.get(r118);     // Catch: Throwable -> L70
        if (r119 != null) goto L50;
        r119 = new Role(r118, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16382, null);     // Catch: Throwable -> L70
    L50:
        r119.setDefault(true);     // Catch: Throwable -> L70
        r119.setDefaultType(2);     // Catch: Throwable -> L70
        r104.remove(r118);     // Catch: Throwable -> L70
        JSONObject r120 = r102.optJSONObject("extraMembers");     // Catch: Throwable -> L70
        if (r120 == null) goto L56;
        JSONArray r121 = r120.optJSONArray("readMembers");     // Catch: Throwable -> L70
        if (r121 == null) goto L56;
        ArrayList r122 = g(r121);     // Catch: Throwable -> L70
    L57:
        r119.getMembers().addAll(r122);     // Catch: Throwable -> L70
    L59:
        ArrayList r123 = new ArrayList(r104.values());     // Catch: Throwable -> L70
        JSONObject r124 = r102.optJSONObject("accessConfig");     // Catch: Throwable -> L70
        if (r124 == null) goto L62;
        JSONObject r125 = r124.optJSONObject("defaultConfig");     // Catch: Throwable -> L70
    L63:
        if (r125 == null) goto L68;
        int r126 = r125.optInt("accessStrategy", 0);     // Catch: Throwable -> L70
        String r127 = r125.optString("roleId");     // Catch: Throwable -> L70
        if (r127 != null) goto L67;
        r127 = r210;
    L67:
        r111 = new DefaultConfig(r126, r127, r125.optBoolean("enableSysRole"));     // Catch: Throwable -> L70
    L68:
        return new RoleResult(r113, r119, r123, r111);
    L62:
        r125 = null;
    L56:
        r122 = new ArrayList();     // Catch: Throwable -> L70
        goto L57
    L58:
        r119 = null;
    L39:
        r116 = new ArrayList();     // Catch: Throwable -> L70
        goto L40
    L41:
        r113 = null;
        goto L42
    L7:
        r101 = r410;
        goto L8
    }

    public h0(ArrayList<BlockSimpleInfo> r100, ArrayList<BlockSimpleInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "tableList");
        Intrinsics.checkNotNullParameter(r101, "blockList");
        this.f215179a = r100;
        this.f215180b = r101;
        this.f215181c = "BitableRoleResultParser";
    }
}
