package com.bytedance.ee.bear.middleground.permission.secret;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground_permission_export.model.secret.SecretApprovalApplinkConfig;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[EntityType.values().length];
            r0[EntityType.LINK_SHARE_ORGANIZATION_READABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L79:
            r0[EntityType.LINK_SHARE_ORGANIZATION_EDITABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L89:
            r0[EntityType.LINK_SHARE_ANYONE_READABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L57:
            r0[EntityType.LINK_SHARE_PARTNER_TENANT_READABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L59:
            r0[EntityType.LINK_SHARE_ANYONE_EDITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L73:
            r0[EntityType.LINK_SHARE_PARTNER_TENANT_EDITABLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L14:
            a = r0;
            int[] r1 = new int[SceneType.values().length];
            r1[SceneType.ESCAPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L63:
            r1[SceneType.INVITE_EXTERNAL_MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L75:
            r1[SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L85:
            r1[SceneType.PERMISSION_SETTINGS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L51:
            r1[SceneType.IM_SHARE_EXTERNAL_MEMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L41
        L61:
            r1[SceneType.IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L42
        L77:
            r1[SceneType.CALENDER_DOC_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L43
        L55:
            r1[SceneType.QQ_SHARE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L44
        L69:
            r1[SceneType.WECHAT_SHARE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L45
        L71:
            r1[SceneType.WECHAT_MOMENTS_SHARE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L46
        L87:
            r1[SceneType.WEIBO_SHARE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L47
        L67:
            r1[SceneType.MORE_SHARE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L48
        L81:
            r1[SceneType.PASSWORD_SHARE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L49
        L83:
            r1[SceneType.LINK_SHARE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L50
        L29:
            b = r1;
        }
    }

    static {
    }

    @JvmStatic
    public static final int b(int r6) {
        int r0 = cu5.c.b(56);
        int r1 = cu5.c.b(10);
        cu5.c.b(90);
        int r3 = cu5.c.b(40);
        int r4 = cu5.c.d();
        if (r6 != 1) goto L5;
        int r7 = r4 - r0;
    L9:
        int r8 = r7 - r3;
        if (r8 < 0) goto L13;
        if (r8 > r4) goto L13;
        return r8;
    L13:
        return cu5.c.b(90);
    L5:
        if (r6 == 2) goto L7;
        r7 = ((r4 - r0) - (r1 * 2)) / 3;
        goto L9
    L7:
        r7 = ((r4 - r0) - r1) / 2;
        goto L9
    }

    @JvmStatic
    public static final void d(String r9) {
        Intrinsics.checkNotNullParameter(r9, "code");
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        int r0 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).getEnv();
        SecretApprovalApplinkConfig r3 = (SecretApprovalApplinkConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("approve_record_process_url", SecretApprovalApplinkConfig.class, new SecretApprovalApplinkConfig());
        String r4 = jcb.b.c().a("applink");
        String r5 = "https://" + r4 + "/client/mini_program/open?mode=appCenter&appId=cli_9cb844403dbb9108&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        String r7 = "https://" + r4 + "/client/mini_program/open?mode=appCenter&appId=cli_9c7cc8a9a9edd105&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        String r6 = "https://" + r4 + "/client/mini_program/open?mode=appCenter&appId=cli_9f3ca97534f4901b&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        if (r3 == null) goto L8;
        r5 = r3.getApprove_record_process_url();
    L17:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r5 + r9);
        return;
    L8:
        if (r0 != 2) goto L10;
        r5 = r6;
        goto L17
    L10:
        if (r0 != 4) goto L12;
    L14:
        r5 = r7;
        goto L17
    L12:
        if (r0 == 5) goto L14;
        goto L14
    }

    @JvmStatic
    public static final SecretReviewModel a(SecretApprovalInstanceModel r5, SecretLevel r6) {
        Intrinsics.checkNotNullParameter(r6, "secretLevl");
        String r0 = r6.getId();
        SecretReviewModel r1 = new SecretReviewModel();
        ArrayList<SecretApprovalInstanceModel.Instance> r2 = new ArrayList();
        if (r5 == null) goto L5;
        ArrayList<SecretApprovalInstanceModel.Instance> r3 = r5.getInstances();
    L6:
        if (r3 != null) goto L8;
    L16:
        r1.setSecretLevel(r6);
        return r1;
    L8:
        if (r5.getInstances().isEmpty() == true) goto L16;
        Iterator<SecretApprovalInstanceModel.Instance> r7 = r5.getInstances().iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        SecretApprovalInstanceModel.Instance r4 = r7.next();
        if (r0.equals(r4.getApply_sec_label_id()) == false) goto L11;
        r2.add(r4);
        goto L11
    L15:
        r1.setInstanceArrayList(r2);
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final List<SecretLevel> c(List<SecretLevel> r8, SceneType r9, EntityType r10) {
        Intrinsics.checkNotNullParameter(r8, "secretList");
        Intrinsics.checkNotNullParameter(r9, "sceneType");
        if (hu5.a.d(r8) == true) goto L5;
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L55;
        Object r1 = r11.next();
        SecretLevel r2 = (SecretLevel) r1;
        boolean r4 = true;
        if (r2.getEnableProtect() == true) goto L13;
    L53:
        if (r4 == false) goto L8;
        r0.add(r1);
        goto L8
    L13:
        switch(a.b[r9.ordinal()]) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L52;
            case 4: goto L52;
            case 5: goto L52;
            case 6: goto L52;
            case 7: goto L52;
            case 8: goto L46;
            case 9: goto L46;
            case 10: goto L46;
            case 11: goto L46;
            case 12: goto L46;
            case 13: goto L46;
            case 14: goto L16;
            default: goto L15;
        };
    L16:
        if (r10 == null) goto L53;
        switch(a.a[r10.ordinal()]) {
            case 1: goto L41;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L22;
            case 6: goto L22;
            default: goto L20;
        };
    L20:
        r4 = false;
        goto L53
    L22:
        if (r2.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r2.getPermissionControl().getLinkShareEntity() > 4) goto L53;
        if (r2.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L29:
        if (r2.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r2.getPermissionControl().getLinkShareEntity() > 3) goto L53;
        if (r2.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L36:
        if (r2.getPermissionControl().getLinkShareEntity() > 2) goto L53;
        if (r2.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L41:
        if (r2.getPermissionControl().getLinkShareEntity() > 1) goto L53;
        if (r2.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L52:
        r4 = r2.getPermissionControl().getExternalAccessSwitch();
        goto L53
    L46:
        if (r2.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r2.getPermissionControl().getLinkShareEntity() > 3) goto L53;
        if (r2.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L15:
        throw new NoWhenBranchMatchedException();
    L55:
        return r0;
    L5:
        return new ArrayList();
    }

    @JvmStatic
    public static final SecretReviewModel e(SecretApprovalInstanceModel r6, SecretLevel r7, SecretApprovalDefModel r8, SecretLevel r9) {
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "secretLevl");
        Intrinsics.checkNotNullParameter(r8, "defModel");
        Intrinsics.checkNotNullParameter(r9, "metaSecretLevl");
        SecretReviewModel r1 = a(r6, r7);
        Intrinsics.checkNotNullParameter(r8, "defModel");
        if (r8.isIs_open() == false) goto L47;
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permisson.degrade_approval") == false) goto L47;
        int r3 = 1;
        if (r8.getApproval_detail() == null) goto L36;
        SecretApprovalDefModel.ApprovalDetail r10 = r8.getApproval_detail();
        Intrinsics.checkNotNullParameter(r10, "approvalDetail");
        Intrinsics.checkNotNullParameter(r9, "metaLevel");
        Intrinsics.checkNotNullParameter(r7, "selectedLevel");
        if (r10.isIs_for_all() == false) goto L13;
    L31:
        boolean r11 = true;
    L33:
        if (r11 == true) goto L36;
        tt5.a.b("", "handleApplySecretApprove pass fail");
        return null;
    L13:
        if (r10.getFrom_label_ids() == null) goto L23;
        if ((!r10.getFrom_label_ids().isEmpty()) == false) goto L23;
        Iterator<String> r2 = r10.getFrom_label_ids().iterator();
    L18:
        if (r2.hasNext() == false) goto L23;
        if (r2.next().equals(r9.getId()) == false) goto L18;
    L23:
        if (r10.getTo_label_ids() != null) goto L25;
    L32:
        r11 = false;
        goto L33
    L25:
        if ((!r10.getTo_label_ids().isEmpty()) == false) goto L32;
        Iterator<String> r12 = r10.getTo_label_ids().iterator();
    L28:
        if (r12.hasNext() == false) goto L32;
        if (r12.next().equals(r7.getId()) == false) goto L28;
    L36:
        ArrayList<SecretApprovalInstanceModel.Instance> r13 = new ArrayList();
        if (r6.getMy_instance() == null) goto L40;
        r13.add(r6.getMy_instance());
    L45:
        r1.setSecretLevel(r7);
        r1.setState(r3);
        r1.setInstanceArrayList(r13);
        return r1;
    L40:
        if (r1.getInstanceArrayList() != null) goto L42;
    L44:
        r3 = 3;
        goto L45
    L42:
        if (r1.getInstanceArrayList().size() <= 0) goto L44;
        r13.addAll(r6.getInstances());
        r3 = 2;
    L47:
        return null;
    }
}
