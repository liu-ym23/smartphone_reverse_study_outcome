package com.bytedance.ee.bear.middleground.permission;

import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class PermissionAnalytic {
    public static final String[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/PermissionAnalytic$OperateItem;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "ManagerCanInvite", "VisitorCanInvite", "MemberCanInvite", "AllCanInvite", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OperateItem extends Enum<OperateItem> {
        public static final OperateItem AllCanInvite = null;
        public static final OperateItem ManagerCanInvite = null;
        public static final OperateItem MemberCanInvite = null;
        public static final OperateItem VisitorCanInvite = null;
        public static final /* synthetic */ OperateItem[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static EnumEntries<OperateItem> getEntries() {
            return b;
        }

        static {
            OperateItem r0 = new OperateItem("ManagerCanInvite", 0, 0);
            ManagerCanInvite = r0;
            OperateItem r1 = new OperateItem("VisitorCanInvite", 1, 1);
            VisitorCanInvite = r1;
            OperateItem r3 = new OperateItem("MemberCanInvite", 2, 2);
            MemberCanInvite = r3;
            OperateItem r5 = new OperateItem("AllCanInvite", 3, 3);
            AllCanInvite = r5;
            OperateItem[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static OperateItem[] values() {
            return (OperateItem[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static OperateItem valueOf(String r1) {
            return (OperateItem) r27.a.a(OperateItem.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public OperateItem(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        a = new String[]{"share", "click_add_collaborate", "click_invite_search_bar", "click_collaborate_inviter_next_step", "click_select_perm_inviter", "click_alter_collaborate_perm", "click_send_invite_btn"};
        b = LazyKt.lazy(PermissionAnalytic$analyticService$2.INSTANCE);
        c = LazyKt.lazy(PermissionAnalytic$infoProvideService$2.INSTANCE);
        d = LazyKt.lazy(PermissionAnalytic$accountService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d b() {
        return (com.bytedance.ee.bear.contract.d) b.getValue();
    }

    public static String a(UserInfo r4) {
        boolean r1 = false;
        if (r4.isUserType() != true) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L27;
        if (r4.getOwnerType() != 17) goto L13;
        return "singleproduct_noreg";
    L13:
        if (TextUtils.isEmpty(r4.getTenant_tag()) == false) goto L16;
        return "0";
    L16:
        if (TextUtils.equals("0", r4.getTenant_tag()) == false) goto L19;
        return "suite_enterprisel_user";
    L19:
        if (TextUtils.equals("", r4.getTenant_tag()) == false) goto L22;
        return "suite_toc_user";
    L22:
        if (r4.isIs_single_product() == false) goto L24;
        return "singleproduct_hasreg";
    L24:
        return "suite_personal_user";
    L27:
        if (r4.getOwnerType() != 2) goto L29;
        r1 = true;
    L29:
        if (r1 == false) goto L32;
        return "chat_group";
    L32:
        return "0";
    L5:
        r0 = false;
        goto L7
    }

    public static String c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return "0";
    L7:
        return du5.b.g(r1);
    }

    public static String d(UserInfo r4) {
        boolean r2 = false;
        if (r4.getOwnerType() != 17) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        int r1 = su5.a.a;
        String r3 = r4.getTempCountryCode();
        String r5 = r4.getTempPhone();
        Intrinsics.checkNotNullParameter(r3, "countryCode");
        Intrinsics.checkNotNullParameter(r5, "mobilePhone");
        if (TextUtils.equals("+86", r3) == false) goto L17;
        Intrinsics.checkNotNullParameter(r5, "input");
        if (r5.length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
    L18:
        if (r2 == false) goto L20;
        return "Phone";
    L15:
        if (Pattern.matches("^[1]\\d{10}$", r5) == false) goto L18;
        r2 = true;
        goto L18
    L12:
        r6 = false;
        goto L13
    L17:
        r2 = su5.a.a(r5);
    L20:
        return "Lark";
    L5:
        r0 = false;
        goto L6
    }

    public static String e(UserInfo r3) {
        if (r3.isUserType() == false) goto L6;
        return "user";
    L6:
        if (r3.getOwnerType() != 2) goto L10;
        return ThumbGlideUrl.SOURCE_CHAT;
    L10:
        if (r3.getOwnerType() != 5) goto L14;
        return "share_space";
    L14:
        if (r3.getOwnerType() != 9) goto L18;
        return "calendar_event";
    L18:
        if (r3.getOwnerType() != 18) goto L21;
        return "organization";
    L21:
        return "user";
    }

    @JvmStatic
    public static final void k(String r3, int r4, UserInfo r5) {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L14
        r1.put("file_id", du5.b.g(r3));     // Catch: Throwable -> L14
        r1.put("file_type", sbb.e.c(r4));     // Catch: Throwable -> L14
        if (r5 == null) goto L7;
        String r6 = r5.getId();     // Catch: Throwable -> L14
        if (r6 == null) goto L7;
    L8:
        r1.put("member_id", r6);     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        Boolean r7 = Boolean.valueOf(r5.isFriend());     // Catch: Throwable -> L14
    L12:
        r1.put("relation_type", r7);     // Catch: Throwable -> L14
        tt5.a.b("PermissionAnalytic", r1.toString());     // Catch: Throwable -> L14
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a("click_share_search_result", r1);     // Catch: Throwable -> L14
        return;
    L11:
        r7 = null;
    L7:
        r6 = "null";
    L14:
        th = move-exception;
        tt5.a.f("PermissionAnalytic", th, false);
    }

    @JvmStatic
    public static final void l(DocPermSetInfo r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        AccountService.Account r0 = ((h0) d.getValue()).G2();
        HashMap r1 = new HashMap();
        if (r7 == null) goto L6;
        r1.putAll(r7);
    L6:
        if (r5.e.getCreateTime().length() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        String r9 = "0";
    L12:
        r1.put("is_owner", String.valueOf(r5.b()));
        r1.put("create_uid", du5.b.g(r5.e.getCreatorUid()));
        r1.put("create_time", r9);
        r1.put("create_date", iu5.e.a(CastLongProtector.parseLong(r9)));
        r1.put("from_create_date", iu5.e.b(CastLongProtector.parseLong(r9)));
        r1.put("file_type", sbb.e.c(r5.getType()));
        r1.put("file_id", du5.b.g(r5.c));
        if (ArraysKt.contains(a, r6) == false) goto L21;
        r1.put("file_tenant_id", du5.b.g(r5.e.getCreatorTenantId()));
        if (r0 == null) goto L21;
        r1.put("file_is_cross_tenant", String.valueOf(!Intrinsics.areEqual(r0.tenantId, r5.e.getCreatorTenantId())));
    L21:
        b().v(r6, r1);     // Catch: RemoteException -> L19
        return;
    L19:
        tt5.a.d("PermissionAnalytic", r6.concat(" report error"));
        return;
    L11:
        r9 = r5.e.getCreateTime();
        goto L12
    L8:
        r8 = false;
        goto L9
    }

    @JvmStatic
    public static final void m(FolderPermSetInfo r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        AccountService.Account r0 = ((h0) d.getValue()).G2();
        HashMap r1 = new HashMap();
        if (r7 == null) goto L6;
        r1.putAll(r7);
    L6:
        if (r5.h.length() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        String r9 = "0";
    L12:
        r1.put("is_owner", String.valueOf(r5.a()));
        r1.put("create_uid", du5.b.g(r5.g));
        r1.put("create_time", r9);
        r1.put("create_date", iu5.e.a(CastLongProtector.parseLong(r9)));
        r1.put("from_create_date", iu5.e.b(CastLongProtector.parseLong(r9)));
        r1.put("file_type", sbb.e.c(r5.getType()));
        r1.put("file_id", du5.b.g(r5.c));
        if (ArraysKt.contains(a, r6) == false) goto L21;
        r1.put("file_tenant_id", du5.b.g(r5.i));
        if (r0 == null) goto L21;
        r1.put("file_is_cross_tenant", String.valueOf(!Intrinsics.areEqual(r0.tenantId, r5.i)));
    L21:
        b().v(r6, r1);     // Catch: RemoteException -> L19
        return;
    L19:
        tt5.a.d("PermissionAnalytic", r6.concat(" report error"));
        return;
    L11:
        r9 = r5.h;
        goto L12
    L8:
        r8 = false;
        goto L9
    }

    @JvmStatic
    public static final void g(int r7, String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "permission");
        f(r7, r8, "send", r9, r10, false);
    }

    @JvmStatic
    public static final void h(int r7, String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "permission");
        f(r7, r8, "send", r9, r10, true);
    }

    @JvmStatic
    public static final void j(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        Intrinsics.checkNotNullParameter(r7, "location");
        HashMap r3 = new HashMap();
        r3.put("reason", r4);
        r3.put("file_id", du5.b.g(r5));
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r3.put("module", r6);
        r3.put("location", r7);
        tt5.a.b("PermissionAnalytic", r3.toString());     // Catch: Throwable -> L8
        b().v("client_auth_error", r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e("PermissionAnalytic", "client_auth_error report error", th, false);
    }

    @JvmStatic
    public static final void p(String r4, String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
        HashMap r1 = new HashMap();
        r1.put("source", "add_cooperator");
        r1.put("module", r5);
        r1.put("file_type", sbb.e.c(r6));
        r1.put("file_id", du5.b.g(r7));
        b().v(r4, r1);     // Catch: RemoteException -> L5
        return;
    L5:
        tt5.a.d("PermissionAnalytic", r4.concat(" report error"));
    }

    public static void q(String r4, String r5, int r6, String r7) {
        HashMap r2 = new HashMap();
        r2.put("file_id", du5.b.g(r5));
        r2.put("file_type", sbb.e.c(r6));
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r2.put("module", r7);
        tt5.a.b("PermissionAnalytic", "eventName: " + r4 + ", params: " + r2);     // Catch: Throwable -> L8
        b().v(r4, r2);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e("PermissionAnalytic", r4.concat(" report error"), th, false);
    }

    @JvmStatic
    public static final void i(String r5, String r6, String r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        HashMap r2 = new HashMap();
        r2.put("action", "share");
        r2.put("source", r6);
        r2.put("module", r7);
        r2.put("file_type", sbb.e.c(r8));
        r2.put("file_id", du5.b.g(r9));
        b().v(r5, r2);     // Catch: RemoteException -> L5
        return;
    L5:
        tt5.a.d("PermissionAnalytic", r5.concat(" report error"));
    }

    @JvmStatic
    public static final void o(List<? extends UserInfo> r7, String r8, int r9, boolean r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "throwable");
        if ((r11 instanceof NetService.ServerErrorException) == false) goto L5;
        NetService.ServerErrorException r12 = (NetService.ServerErrorException) r11;
        String r0 = String.valueOf(r12.getCode());
        String r13 = r12.getMsg().toString();
    L6:
        String r5 = r0;
        n(r7, r8, r9, r10, r5, r13);
        return;
    L5:
        r0 = "999";
        r13 = "Network Failed";
        goto L6
    }

    @JvmStatic
    public static final void f(int r4, String r5, String r6, String r7, boolean r8, boolean r9) {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L14
        r2.put("file_type", sbb.e.c(r4));     // Catch: Throwable -> L14
        r2.put("file_id", du5.b.g(r5));     // Catch: Throwable -> L14
        r2.put("action", r6);     // Catch: Throwable -> L14
        r2.put("permission", r7);     // Catch: Throwable -> L14
        String r10 = "1";
        if (r8 == false) goto L7;
        Object r11 = "1";
    L8:
        r2.put("note", r11);     // Catch: Throwable -> L14
        if (r9 == true) goto L12;
        r10 = "0";
    L12:
        r2.put("status", r10);     // Catch: Throwable -> L14
        tt5.a.b("PermissionAnalytic", "eventName: click_authority_apply_action, reportApplyEditPermission()..." + r2);     // Catch: Throwable -> L14
        b().a("click_authority_apply_action", r2);     // Catch: Throwable -> L14
        return;
    L7:
        r11 = "0";
    L14:
        th = move-exception;
        tt5.a.f("PermissionAnalytic", th, false);
    }

    @JvmStatic
    public static final void n(List<? extends UserInfo> r16, String r17, int r18, boolean r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
        AccountService.Account r0 = ((h0) d.getValue()).G2();     // Catch: Exception -> L36
        HashMap r4 = new HashMap();     // Catch: Exception -> L36
        r4.put("file_id", du5.b.g(r17));     // Catch: Exception -> L36
        r4.put("file_type", sbb.e.c(r18));     // Catch: Exception -> L36
        String r5 = "";
        if (r0 == null) goto L8;
        String r1 = r0.tenantId;     // Catch: Exception -> L36
        if (r1 == null) goto L8;
    L9:
        r4.put("fromuser_collaborate_tenant_id", du5.b.g(r1));     // Catch: Exception -> L36
        if (r16 == null) goto L25;
        Iterator<T> r2 = r16.iterator();     // Catch: Exception -> L36
        String r3 = "";
        String r6 = r3;
        String r7 = r6;
        String r9 = r7;
        String r10 = r9;
        String r12 = r10;
        int r8 = 0;
        int r11 = 0;
    L13:
        if (r2.hasNext() == false) goto L26;
        Object r13 = r2.next();     // Catch: Exception -> L36
        int r14 = r8 + 1;     // Catch: Exception -> L36
        if (r8 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L36
    L17:
        UserInfo r15 = (UserInfo) r13;     // Catch: Exception -> L36
        if (r8 != 0) goto L20;
        r3 = c(r15.getId());     // Catch: Exception -> L36
        r6 = e(r15);     // Catch: Exception -> L36
        r7 = c(r15.getTenantId());     // Catch: Exception -> L36
        String r22 = a(r15);     // Catch: Exception -> L36
        String r23 = String.valueOf(r15.getPermission());     // Catch: Exception -> L36
        r10 = d(r15);     // Catch: Exception -> L36
        r12 = r23;
        r9 = r22;
    L22:
        if (r15.getOwnerType() != 18) goto L24;
        r11 = r11 + 1;     // Catch: Exception -> L36
    L24:
        r8 = r14;
        goto L13
    L20:
        String r24 = r3 + ',' + c(r15.getId());     // Catch: Exception -> L36
        r6 = r6 + ',' + e(r15);     // Catch: Exception -> L36
        r7 = r7 + ',' + c(r15.getTenantId());     // Catch: Exception -> L36
        r9 = r9 + ',' + a(r15);     // Catch: Exception -> L36
        r12 = r12 + ',' + r15.getPermission();     // Catch: Exception -> L36
        r10 = r10 + ',' + d(r15);     // Catch: Exception -> L36
        r3 = r24;
    L26:
        r4.put("collaborate_id", r3);     // Catch: Exception -> L36
        r4.put("collaborate_type", r6);     // Catch: Exception -> L36
        r4.put("collaborate_tenant_id", r7);     // Catch: Exception -> L36
        r4.put("touser_account_type", r9);     // Catch: Exception -> L36
        r4.put("share_method_type", r10);     // Catch: Exception -> L36
        r4.put("collaborate_organization_count", String.valueOf(r11));     // Catch: Exception -> L36
        r4.put("product", "suite");     // Catch: Exception -> L36
        r4.put("perm_set_after", r12);     // Catch: Exception -> L36
        r4.put("lark_inform", String.valueOf(r19));     // Catch: Exception -> L36
        if (r20 != null) goto L29;
        String r25 = "";
    L30:
        r4.put("status_code", r25);     // Catch: Exception -> L36
        if (r21 == null) goto L34;
        r5 = r21;
    L34:
        r4.put("status_name", r5);     // Catch: Exception -> L36
        tt5.a.b("PermissionAnalytic", r4.toString());     // Catch: Exception -> L36
        b().v("click_send_invite_btn", r4);     // Catch: Exception -> L36
        return;
    L29:
        r25 = r20;
        goto L30
    L25:
        r3 = "";
        r6 = r3;
        r7 = r6;
        r9 = r7;
        r10 = r9;
        r12 = r10;
        r11 = 0;
    L8:
        r1 = "";
    L36:
        e = move-exception;
        tt5.a.f("PermissionAnalytic", e, false);
    }
}
