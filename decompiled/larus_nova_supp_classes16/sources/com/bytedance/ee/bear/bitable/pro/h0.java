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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h0 implements NetService.c<RoleResult> {
    public final ArrayList<BlockSimpleInfo> a;
    public final ArrayList<BlockSimpleInfo> b;
    public final String c;

    public final ArrayList<BlockSimpleInfo> a() {
        ArrayList<BlockSimpleInfo> r0 = this.b;
        Collection r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();
        if (((BlockSimpleInfo) r3).isTable().booleanValue() == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        if (r1.isEmpty() == false) goto L12;
        r1 = this.a;
    L12:
        return new ArrayList(r1);
    }

    public static AutomationRule b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "roleObj");
        JSONObject r5 = r4.optJSONObject("automationRule");
        if (r5 == null) goto L12;
        HashMap r0 = new HashMap();
        JSONObject r1 = r5.optJSONObject("actionRuleMap");
        if (r1 == null) goto L11;
        Iterator<String> r2 = r1.keys();
    L8:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        r0.put(r3, Integer.valueOf(r5.optInt(r3)));
    L11:
        return new AutomationRule(r5.optBoolean("isEnable"), r0);
    L12:
        return null;
    }

    public static BaseRule c(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "roleObj");
        JSONObject r5 = r4.optJSONObject("baseRule");
        if (r5 == null) goto L10;
        BaseRule r0 = new BaseRule();
        Iterator<String> r1 = r5.keys();
        if (r1 != null) goto L7;
    L9:
        return r0;
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        r0.put(r2, Integer.valueOf(r5.optInt(r2)));
        goto L7
    L10:
        return null;
    }

    public static DashboardRule d(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "roleObj");
        JSONObject r5 = r4.optJSONObject("dashboardRule");
        if (r5 == null) goto L12;
        HashMap r0 = new HashMap();
        JSONObject r1 = r5.optJSONObject("actionRuleMap");
        if (r1 == null) goto L11;
        Iterator<String> r2 = r1.keys();
    L8:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        r0.put(r3, Integer.valueOf(r5.optInt(r3)));
    L11:
        return new DashboardRule(r5.optBoolean("isEnable"), r0);
    L12:
        return null;
    }

    public static ArrayList g(JSONArray r8) {
        ArrayList r0 = new ArrayList();
        int r1 = r8.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        JSONObject r4 = r8.optJSONObject(r3);
        UserInfo r5 = new UserInfo();
        r5.setAvatarUrl(r4.optString("memberAvatarUrl", ""));
        r5.setLabel(r4.optString("memberDepartmentName", ""));
        r5.setEnName(r4.optString("memberEnName", ""));
        r5.setId(r4.optString("memberId", ""));
        r5.setName(r4.optString("memberName", ""));
        r5.setCnName(r5.getName());
        r5.setOwnerType(r4.optInt("memberType", 0));
        r5.setDisplayName(r4.optString("memberDisplayName", ""));
        r5.setExternal(r4.optBoolean("isExternal"));
        JSONObject r6 = r4.optJSONObject("displayTag");
        if (r6 == null) goto L7;
        String r7 = r6.optString("tag_value");
    L8:
        r5.setOrganizationTagValue(r7);
        r0.add(r5);
        r3 = r3 + 1;
        goto L3
    L7:
        r7 = null;
        goto L8
    L9:
        return r0;
    }

    public final ArrayList<BlockRole> e(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "roleObj");
        ArrayList<BlockRole> r0 = new ArrayList();
        JSONObject r9 = r8.optJSONObject("blockRoleMap");
        if (r9 != null) goto L5;
        r9 = new JSONObject();
    L5:
        ArrayList<BlockSimpleInfo> r1 = this.b;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((BlockSimpleInfo) r4).isDashboard().booleanValue() == false) goto L7;
        r2.add(r4);
        goto L7
    L11:
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L18;
        BlockSimpleInfo r6 = (BlockSimpleInfo) r5.next();
        String r7 = r6.getId();
        JSONObject r10 = r9.optJSONObject(r7);
        if (r10 != null) goto L17;
        r10 = new JSONObject();
    L17:
        Intrinsics.checkNotNull(r7);
        r0.add(new BlockRole(r7, r6.getName(), r10.optInt("perm")));
        goto L13
    L18:
        return r0;
    }

    public final ArrayList<BlockRole> f(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "roleObj");
        ArrayList<BlockRole> r0 = new ArrayList();
        JSONObject r9 = r8.optJSONObject("blockRoleMap");
        if (r9 != null) goto L5;
        r9 = new JSONObject();
    L5:
        ArrayList<BlockSimpleInfo> r1 = this.b;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((BlockSimpleInfo) r4).isDocx().booleanValue() == false) goto L7;
        r2.add(r4);
        goto L7
    L11:
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L18;
        BlockSimpleInfo r6 = (BlockSimpleInfo) r5.next();
        String r7 = r6.getId();
        JSONObject r10 = r9.optJSONObject(r7);
        if (r10 != null) goto L17;
        r10 = new JSONObject();
    L17:
        Intrinsics.checkNotNull(r7);
        r0.add(new BlockRole(r7, r6.getName(), r10.optInt("perm")));
        goto L13
    L18:
        return r0;
    }

    public final ArrayList<TableRole> h(JSONObject r16) {
        Intrinsics.checkNotNullParameter(r16, "roleObj");
        ArrayList r0 = new ArrayList();
        JSONObject r17 = r16.optJSONObject("tableRoleMap");
        if (r17 != null) goto L5;
        r17 = new JSONObject();
    L5:
        Iterator<String> r1 = r17.keys();
    L6:
        RecRule r3 = null;
        if (r1.hasNext() == false) goto L30;
        String r5 = r1.next();
        JSONObject r2 = r17.optJSONObject(r5);
        if (r2 != null) goto L11;
        r2 = new JSONObject();
    L11:
        JSONObject r4 = r2.optJSONObject("recRule");
        if (r4 == null) goto L14;
        RecRule r8 = new RecRule(r4.optInt("perm"), r4.optInt("otherPerm"));
    L15:
        JSONObject r6 = r2.optJSONObject("otherRecRule");
        if (r6 == null) goto L18;
        r3 = new RecRule(r6.optInt("perm"), r6.optInt("otherPerm"));
    L18:
        RecRule r10 = r3;
        if (r2.optJSONObject("fieldPerm") == null) goto L21;
        boolean r9 = true;
    L22:
        Intrinsics.checkNotNull(r5);
        Iterator<BlockSimpleInfo> r7 = a().iterator();
    L24:
        if (r7.hasNext() == false) goto L28;
        BlockSimpleInfo r11 = r7.next();
        if (TextUtils.equals(r5, r11.getId()) == false) goto L24;
        String r12 = r11.getName();
    L29:
        r0.add(new TableRole(r5, r12, r2.optInt("perm"), r8, r9, r10));
        goto L6
    L28:
        r12 = "";
        goto L29
    L21:
        r9 = false;
        goto L22
    L14:
        r8 = null;
        goto L15
    L30:
        ArrayList<TableRole> r18 = new ArrayList();
        Iterator<BlockSimpleInfo> r13 = a().iterator();
    L32:
        if (r13.hasNext() == false) goto L43;
        BlockSimpleInfo r14 = r13.next();
        String r19 = r14.getId();
        Iterator r20 = r0.iterator();
    L35:
        if (r20.hasNext() == false) goto L39;
        TableRole r21 = (TableRole) r20.next();
        if (TextUtils.equals(r21.getTableId(), r19) == false) goto L35;
    L40:
        if (r21 != null) goto L41;
        r18.add(new TableRole(r14.getId(), r14.getName(), 0, null, false, null));
        goto L32
    L41:
        r18.add(r21);
        goto L32
    L39:
        r21 = null;
        goto L40
    L43:
        return r18;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r46) {
    L70:
        th = move-exception;
        tt5.a.l(this.c, "BitableRoleResultParser.parse() error...", th);
        return new RoleResult(null, null, null, null, 15, null);
    L4:
        String r2 = "";
        if (r46 != null) goto L7;
        String r3 = "";
    L8:
        JSONObject r0 = new JSONObject(r3).optJSONObject("data");     // Catch: Throwable -> L70
        if (r0 != null) goto L11;
        r0 = new JSONObject();     // Catch: Throwable -> L70
    L11:
        JSONObject r4 = r0.optJSONObject("roleMap");     // Catch: Throwable -> L70
        if (r4 != null) goto L14;
        r4 = new JSONObject();     // Catch: Throwable -> L70
    L14:
        HashMap r5 = new HashMap();     // Catch: Throwable -> L70
        Iterator<String> r6 = r4.keys();     // Catch: Throwable -> L70
    L16:
        if (r6.hasNext() == false) goto L24;
        String r7 = r6.next();     // Catch: Throwable -> L70
        JSONObject r8 = r4.optJSONObject(r7);     // Catch: Throwable -> L70
        if (r8 != null) goto L20;
        r8 = new JSONObject();     // Catch: Throwable -> L70
    L20:
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L70
        String r9 = r8.optString("name");     // Catch: Throwable -> L70
        JSONArray r10 = r8.optJSONArray("members");     // Catch: Throwable -> L70
        if (r10 != null) goto L23;
        r10 = new JSONArray();     // Catch: Throwable -> L70
    L23:
        r5.put(r7, new Role(r7, r9, g(r10), c(r8), d(r8), b(r8), h(r8), e(r8), f(r8), r8.optLong("createdTime", 0), false, 0, false, null, 15360, null));     // Catch: Throwable -> L70
        r4 = r4;
        r2 = r2;
        r6 = r6;
        goto L16
    L24:
        String r26 = r2;
        JSONObject r11 = r0.optJSONObject("defaultEditRole");     // Catch: Throwable -> L70
        DefaultConfig r12 = null;
        if (r11 == null) goto L41;
        String r13 = r11.optString("roleId");     // Catch: Throwable -> L70
        if (r13 != null) goto L30;
        r13 = r26;
    L30:
        Role r14 = (Role) r5.get(r13);     // Catch: Throwable -> L70
        if (r14 != null) goto L33;
        r14 = new Role(r13, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16382, null);     // Catch: Throwable -> L70
    L33:
        r14.setDefault(true);     // Catch: Throwable -> L70
        r14.setDefaultType(1);     // Catch: Throwable -> L70
        r5.remove(r13);     // Catch: Throwable -> L70
        JSONObject r16 = r0.optJSONObject("extraMembers");     // Catch: Throwable -> L70
        if (r16 == null) goto L39;
        JSONArray r17 = r16.optJSONArray("editMembers");     // Catch: Throwable -> L70
        if (r17 == null) goto L39;
        ArrayList r18 = g(r17);     // Catch: Throwable -> L70
    L40:
        r14.getMembers().addAll(r18);     // Catch: Throwable -> L70
    L42:
        JSONObject r19 = r0.optJSONObject("defaultReadRole");     // Catch: Throwable -> L70
        if (r19 == null) goto L58;
        String r20 = r19.optString("roleId");     // Catch: Throwable -> L70
        if (r20 != null) goto L47;
        r20 = r26;
    L47:
        Role r21 = (Role) r5.get(r20);     // Catch: Throwable -> L70
        if (r21 != null) goto L50;
        r21 = new Role(r20, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16382, null);     // Catch: Throwable -> L70
    L50:
        r21.setDefault(true);     // Catch: Throwable -> L70
        r21.setDefaultType(2);     // Catch: Throwable -> L70
        r5.remove(r20);     // Catch: Throwable -> L70
        JSONObject r22 = r0.optJSONObject("extraMembers");     // Catch: Throwable -> L70
        if (r22 == null) goto L56;
        JSONArray r23 = r22.optJSONArray("readMembers");     // Catch: Throwable -> L70
        if (r23 == null) goto L56;
        ArrayList r24 = g(r23);     // Catch: Throwable -> L70
    L57:
        r21.getMembers().addAll(r24);     // Catch: Throwable -> L70
    L59:
        ArrayList r27 = new ArrayList(r5.values());     // Catch: Throwable -> L70
        JSONObject r1 = r0.optJSONObject("accessConfig");     // Catch: Throwable -> L70
        if (r1 == null) goto L62;
        JSONObject r28 = r1.optJSONObject("defaultConfig");     // Catch: Throwable -> L70
    L63:
        if (r28 == null) goto L68;
        int r29 = r28.optInt("accessStrategy", 0);     // Catch: Throwable -> L70
        String r30 = r28.optString("roleId");     // Catch: Throwable -> L70
        if (r30 != null) goto L67;
        r30 = r26;
    L67:
        r12 = new DefaultConfig(r29, r30, r28.optBoolean("enableSysRole"));     // Catch: Throwable -> L70
    L68:
        return new RoleResult(r14, r21, r27, r12);
    L62:
        r28 = null;
    L56:
        r24 = new ArrayList();     // Catch: Throwable -> L70
        goto L57
    L58:
        r21 = null;
    L39:
        r18 = new ArrayList();     // Catch: Throwable -> L70
        goto L40
    L41:
        r14 = null;
        goto L42
    L7:
        r3 = r46;
        goto L8
    }

    public h0(ArrayList<BlockSimpleInfo> r2, ArrayList<BlockSimpleInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "tableList");
        Intrinsics.checkNotNullParameter(r3, "blockList");
        this.a = r2;
        this.b = r3;
        this.c = "BitableRoleResultParser";
    }
}
