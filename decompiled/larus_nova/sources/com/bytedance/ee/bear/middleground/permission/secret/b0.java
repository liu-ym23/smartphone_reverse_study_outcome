package com.bytedance.ee.bear.middleground.permission.secret;

import android.text.TextUtils;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground_permission_export.model.secret.SecretApprovalApplinkConfig;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f234026a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f234027a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f234028b = null;

        static {
            int[] r100 = new int[EntityType.values().length];
            r100[EntityType.LINK_SHARE_ORGANIZATION_READABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L79:
            r100[EntityType.LINK_SHARE_ORGANIZATION_EDITABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L89:
            r100[EntityType.LINK_SHARE_ANYONE_READABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L57:
            r100[EntityType.LINK_SHARE_PARTNER_TENANT_READABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L59:
            r100[EntityType.LINK_SHARE_ANYONE_EDITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L73:
            r100[EntityType.LINK_SHARE_PARTNER_TENANT_EDITABLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L14:
            f234027a = r100;
            int[] r101 = new int[SceneType.values().length];
            r101[SceneType.ESCAPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L63:
            r101[SceneType.INVITE_EXTERNAL_MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L75:
            r101[SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L85:
            r101[SceneType.PERMISSION_SETTINGS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L51:
            r101[SceneType.IM_SHARE_EXTERNAL_MEMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L41
        L61:
            r101[SceneType.IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L42
        L77:
            r101[SceneType.CALENDER_DOC_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L43
        L55:
            r101[SceneType.QQ_SHARE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L44
        L69:
            r101[SceneType.WECHAT_SHARE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L45
        L71:
            r101[SceneType.WECHAT_MOMENTS_SHARE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L46
        L87:
            r101[SceneType.WEIBO_SHARE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L47
        L67:
            r101[SceneType.MORE_SHARE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L48
        L81:
            r101[SceneType.PASSWORD_SHARE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L49
        L83:
            r101[SceneType.LINK_SHARE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L50
        L29:
            f234028b = r101;
        }
    }

    static {
    }

    @JvmStatic
    public static final int b(int r100) {
        int r101 = cu5.c.b(56);
        int r102 = cu5.c.b(10);
        cu5.c.b(90);
        int r103 = cu5.c.b(40);
        int r104 = cu5.c.d();
        if (r100 != 1) goto L5;
        int r105 = r104 - r101;
    L9:
        int r106 = r105 - r103;
        if (r106 < 0) goto L13;
        if (r106 > r104) goto L13;
        return r106;
    L13:
        return cu5.c.b(90);
    L5:
        if (r100 == 2) goto L7;
        r105 = ((r104 - r101) - (r102 * 2)) / 3;
        goto L9
    L7:
        r105 = ((r104 - r101) - r102) / 2;
        goto L9
    }

    @JvmStatic
    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).getEnv();
        SecretApprovalApplinkConfig r102 = (SecretApprovalApplinkConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("approve_record_process_url", SecretApprovalApplinkConfig.class, new SecretApprovalApplinkConfig());
        String r103 = jcb.b.c().a("applink");
        String r104 = "https://" + r103 + "/client/mini_program/open?mode=appCenter&appId=cli_9cb844403dbb9108&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        String r105 = "https://" + r103 + "/client/mini_program/open?mode=appCenter&appId=cli_9c7cc8a9a9edd105&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        String r106 = "https://" + r103 + "/client/mini_program/open?mode=appCenter&appId=cli_9f3ca97534f4901b&path=pages%2Fdetail%2Findex%3FinstanceId%3D";
        if (r102 == null) goto L8;
        r104 = r102.getApprove_record_process_url();
    L17:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r104 + r100);
        return;
    L8:
        if (r101 != 2) goto L10;
        r104 = r106;
        goto L17
    L10:
        if (r101 != 4) goto L12;
    L14:
        r104 = r105;
        goto L17
    L12:
        if (r101 == 5) goto L14;
        goto L14
    }

    @JvmStatic
    public static final SecretReviewModel a(SecretApprovalInstanceModel r100, SecretLevel r101) {
        Intrinsics.checkNotNullParameter(r101, "secretLevl");
        String r102 = r101.getId();
        SecretReviewModel r103 = new SecretReviewModel();
        ArrayList<SecretApprovalInstanceModel.Instance> r104 = new ArrayList();
        if (r100 == null) goto L5;
        ArrayList<SecretApprovalInstanceModel.Instance> r105 = r100.getInstances();
    L6:
        if (r105 != null) goto L8;
    L16:
        r103.setSecretLevel(r101);
        return r103;
    L8:
        if (r100.getInstances().isEmpty() == true) goto L16;
        Iterator<SecretApprovalInstanceModel.Instance> r106 = r100.getInstances().iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        SecretApprovalInstanceModel.Instance r107 = r106.next();
        if (r102.equals(r107.getApply_sec_label_id()) == false) goto L11;
        r104.add(r107);
        goto L11
    L15:
        r103.setInstanceArrayList(r104);
        goto L16
    L5:
        r105 = null;
        goto L6
    }

    @JvmStatic
    public static final List<SecretLevel> c(List<SecretLevel> r100, SceneType r101, EntityType r110) {
        Intrinsics.checkNotNullParameter(r100, "secretList");
        Intrinsics.checkNotNullParameter(r101, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        if (hu5.a.d(r100) == true) goto L5;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L55;
        Object r104 = r103.next();
        SecretLevel r105 = (SecretLevel) r104;
        boolean r106 = true;
        if (r105.getEnableProtect() == true) goto L13;
    L53:
        if (r106 == false) goto L8;
        r102.add(r104);
        goto L8
    L13:
        switch(a.f234028b[r101.ordinal()]) {
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
        if (r110 == null) goto L53;
        switch(a.f234027a[r110.ordinal()]) {
            case 1: goto L41;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L22;
            case 6: goto L22;
            default: goto L20;
        };
    L20:
        r106 = false;
        goto L53
    L22:
        if (r105.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r105.getPermissionControl().getLinkShareEntity() > 4) goto L53;
        if (r105.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L29:
        if (r105.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r105.getPermissionControl().getLinkShareEntity() > 3) goto L53;
        if (r105.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L36:
        if (r105.getPermissionControl().getLinkShareEntity() > 2) goto L53;
        if (r105.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L41:
        if (r105.getPermissionControl().getLinkShareEntity() > 1) goto L53;
        if (r105.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L52:
        r106 = r105.getPermissionControl().getExternalAccessSwitch();
        goto L53
    L46:
        if (r105.getPermissionControl().getExternalAccessSwitch() == false) goto L20;
        if (r105.getPermissionControl().getLinkShareEntity() > 3) goto L53;
        if (r105.getPermissionControl().getLinkShareEntity() != 0) goto L20;
    L15:
        throw new NoWhenBranchMatchedException();
    L55:
        return r102;
    L5:
        return new ArrayList();
    }

    @JvmStatic
    public static final SecretReviewModel e(SecretApprovalInstanceModel r100, SecretLevel r101, SecretApprovalDefModel r102, SecretLevel r103) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "secretLevl");
        Intrinsics.checkNotNullParameter(r102, "defModel");
        Intrinsics.checkNotNullParameter(r103, "metaSecretLevl");
        SecretReviewModel r104 = a(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "defModel");
        if (r102.isIs_open() == false) goto L47;
        int r105 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.permisson.degrade_approval") == false) goto L47;
        int r106 = 1;
        if (r102.getApproval_detail() == null) goto L36;
        SecretApprovalDefModel.ApprovalDetail r107 = r102.getApproval_detail();
        Intrinsics.checkNotNullParameter(r107, "approvalDetail");
        Intrinsics.checkNotNullParameter(r103, "metaLevel");
        Intrinsics.checkNotNullParameter(r101, "selectedLevel");
        if (r107.isIs_for_all() == false) goto L13;
    L31:
        boolean r108 = true;
    L33:
        if (r108 == true) goto L36;
        tt5.a.b("", "handleApplySecretApprove pass fail");
        return null;
    L13:
        if (r107.getFrom_label_ids() == null) goto L23;
        if ((!r107.getFrom_label_ids().isEmpty()) == false) goto L23;
        Iterator<String> r109 = r107.getFrom_label_ids().iterator();
    L18:
        if (r109.hasNext() == false) goto L23;
        if (r109.next().equals(r103.getId()) == false) goto L18;
    L23:
        if (r107.getTo_label_ids() != null) goto L25;
    L32:
        r108 = false;
        goto L33
    L25:
        if ((!r107.getTo_label_ids().isEmpty()) == false) goto L32;
        Iterator<String> r110 = r107.getTo_label_ids().iterator();
    L28:
        if (r110.hasNext() == false) goto L32;
        if (r110.next().equals(r101.getId()) == false) goto L28;
    L36:
        ArrayList<SecretApprovalInstanceModel.Instance> r111 = new ArrayList();
        if (r100.getMy_instance() == null) goto L40;
        r111.add(r100.getMy_instance());
    L45:
        r104.setSecretLevel(r101);
        r104.setState(r106);
        r104.setInstanceArrayList(r111);
        return r104;
    L40:
        if (r104.getInstanceArrayList() != null) goto L42;
    L44:
        r106 = 3;
        goto L45
    L42:
        if (r104.getInstanceArrayList().size() <= 0) goto L44;
        r111.addAll(r100.getInstances());
        r106 = 2;
    L47:
        return null;
    }
}
