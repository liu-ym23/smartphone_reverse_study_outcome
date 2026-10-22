package com.bytedance.ee.bear.bitable.lynx.pro;

import android.content.Context;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bitable.lynx.BitableCCMLynxPlugin;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.bitable.pro.h0;
import com.bytedance.ee.bear.bitable.pro.roledetail.BitableProRoleDetailFragmentV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.templates.g;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.utils.ApkUtil;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin;", "Lcom/bytedance/ee/bear/bitable/lynx/BitableCCMLynxPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "GetNativeInfoHandler", "AddMembersHandler", "RoleDescHandler", "BizAlertModel", "BizAlertHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProLynxPlugin extends BitableCCMLynxPlugin {
    private static final String ADV_ADD_MEMBER = null;
    private static final String ADV_OPEN_MEMBER_LIST = null;
    private static final String ADV_PERM_PANEL = null;
    private static final String ADV_ROLE_DESC = null;
    public static final c Companion = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin$BizAlertModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin$BizAlertModel$Data;", "getData", "()Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin$BizAlertModel$Data;", "setData", "(Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin$BizAlertModel$Data;)V", "Data", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BizAlertModel implements NonProguard {
        private Data data;
        private String type;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/pro/BitableProLynxPlugin$BizAlertModel$Data;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isSystemRole", "", "()Ljava/lang/Boolean;", "setSystemRole", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Data implements NonProguard {
            private Boolean isSystemRole;

            public Data() {
                this.isSystemRole = Boolean.FALSE;
            }

            public final Boolean isSystemRole() {
                return this.isSystemRole;
            }

            public final void setSystemRole(Boolean r100) {
                this.isSystemRole = r100;
            }
        }

        public BizAlertModel() {
        }

        public final Data getData() {
            return this.data;
        }

        public final String getType() {
            return this.type;
        }

        public final void setData(Data r100) {
            this.data = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }
    }

    public final class a implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f214633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f214634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableProLynxPlugin f214635c;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableProLynxPlugin r100) {
            this.f214635c = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            String r112 = (String) r110;
            BitableProLynxPlugin.Companion.getClass();
            String r100 = BitableProLynxPlugin.access$getADV_ADD_MEMBER$cp();
            StringBuilder r101 = new StringBuilder("handle: dataLength=");
            if (r112 == null) goto L5;
            int r102 = r112.length();
        L6:
            r101.append(r102);
            tt5.a.h(r100, r101.toString());
            JSONObject r103 = new JSONObject(r112);     // Catch: Exception -> L23
            int r113 = r103.optInt("action");     // Catch: Exception -> L23
            boolean r104 = r103.optBoolean("result");     // Catch: Exception -> L23
            if (r113 != 1) goto L14;
            JSONArray r114 = JSONObjectProtectorUtils.getJSONArray(r103, "selectedMembers");     // Catch: Exception -> L23
            JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r103, "wikiMembers");     // Catch: Exception -> L23
            JSONArray r106 = JSONObjectProtectorUtils.getJSONArray(r103, "admines");     // Catch: Exception -> L23
            if (com.bytedance.ee.bear.bitable.c.j() == false) goto L12;
            Fragment r107 = ((DocumentPluginHost) this.f214635c.getHost()).getHostFragment();     // Catch: Exception -> L23
        L13:
            cj5.c r108 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);     // Catch: Exception -> L23
            FragmentActivity r109 = BitableProLynxPlugin.access$getActivity(this.f214635c);     // Catch: Exception -> L23
            String r115 = BitableProLynxPlugin.access$getDocViewModel(this.f214635c).getOwnerUserId();     // Catch: Exception -> L23
            String r116 = BitableProLynxPlugin.access$getDocViewModel(this.f214635c).getCreatorTenantId();     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r114);     // Catch: Exception -> L23
            ArrayList<UserInfo> r117 = com.bytedance.ee.bear.bitable.lynx.pro.c.a(r114);     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r105);     // Catch: Exception -> L23
            ArrayList<UserInfo> r118 = com.bytedance.ee.bear.bitable.lynx.pro.c.a(r105);     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r106);     // Catch: Exception -> L23
            r108.xe(r109, r107, r115, r116, r117, r118, com.bytedance.ee.bear.bitable.lynx.pro.c.a(r106), new com.bytedance.ee.bear.bitable.lynx.pro.d(this, r111));     // Catch: Exception -> L23
            return;
        L12:
            r107 = null;
            goto L13
        L14:
            if (r104 == false) goto L18;
            Runnable r119 = this.f214633a;     // Catch: Exception -> L23
            if (r119 == null) goto L21;
            r119.run();     // Catch: Exception -> L23
        L21:
            this.f214633a = null;     // Catch: Exception -> L23
            this.f214634b = null;     // Catch: Exception -> L23
            return;
        L18:
            Runnable r120 = this.f214634b;     // Catch: Exception -> L23
            if (r120 == null) goto L21;
            r120.run();     // Catch: Exception -> L23
        L23:
            e = move-exception;
            BitableProLynxPlugin.Companion.getClass();
            tt5.a.e(BitableProLynxPlugin.access$getADV_ADD_MEMBER$cp(), "error.", e, false);
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public final class b implements i<BizAlertModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableProLynxPlugin f214636a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableProLynxPlugin r100) {
            this.f214636a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, final m r101) {
            BizAlertModel r102 = (BizAlertModel) r100;
            Boolean r103 = null;
            if (r102 == null) goto L5;
            String r104 = r102.getType();
        L7:
            if (Intrinsics.areEqual(r104, "advPermCloseAlert") == false) goto L26;
            Context r105 = BitableProLynxPlugin.access$getContext(this.f214636a);
            if (r102 == null) goto L13;
            BizAlertModel.Data r106 = r102.getData();
            if (r106 == null) goto L13;
            r103 = r106.isSystemRole();
        L13:
            Function0<Unit> r107 = new BitableProLynxPlugin$BizAlertHandler$handle$1(r101);
            BitableProLynxPlugin$BizAlertHandler$handle$2 r108 = BitableProLynxPlugin$BizAlertHandler$handle$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r107, "confirm");
            Intrinsics.checkNotNullParameter(r108, "cancel");
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L16;
            int r109 = R.string.Bitable_AdvancedPerm_SystemRole_SystemAndCustomRolePerminvalidOnceDisabled_Desc;
        L17:
            hp5.a r110 = new hp5.a(r105).title(R.string.Bitable_AdvancedPermission_DisablePopupTitle).titleSize(17).message(r109).messageGravity(GravityCompat.START).messageTextSize(16);
            String r111 = r105.getString(R.string.Bitable_AdvancedPermission_DisablePopupContent2);
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "value");
            r110.f486431b = r111;
            r110.f486433d = R.color.text_caption;
            r110.f486434e = true;
            r110.f486430a = false;
            UDDialog r112 = r110.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Bitable_Common_ButtonConfirm_Mobile).onClickListener(new com.bytedance.ee.bear.bitable.lynx.pro.a(r107))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Bitable_Common_ButtonCancel).onClickListener(new com.bytedance.ee.bear.bitable.lynx.pro.b(r108)).textColorRes(R.color.text_title)).cancelOnTouchOutside(false).build();
            if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L24;
            DialogLancet.handleBlockedDialogShow(r112);
            return;
        L24:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
        L21:
            DialogLancet.beforeDialogShow(r112);
            r112.show();
            DialogLancet.afterDialogShow(r112);
            return;
        L16:
            r109 = R.string.Bitable_AdvancedPermission_DisablePopupContent1;
            goto L17
        L26:
            return;
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class c {
        public c() {
        }
    }

    public final class d implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableProLynxPlugin f214637a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(BitableProLynxPlugin r100) {
            this.f214637a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            com.alibaba.fastjson.JSONObject r103 = new com.alibaba.fastjson.JSONObject();
            BitableProLynxPlugin r104 = this.f214637a;
            r103.put2("version", ApkUtil.getAppVersionName(LarkContext.getApplication()));
            int r105 = g.f239075a;
            DocViewModel r106 = BitableProLynxPlugin.access$getDocViewModel(r104);
            int r107 = 0;
            if (r106 == null) goto L9;
            DocumentInfo r108 = r106.getDocumentInfoData();
            if (r108 == null) goto L9;
            DocMetaInfo r109 = r108.getDocMetaInfo();
            if (r109 == null) goto L9;
            int r110 = r109.getTemplate_type();
        L10:
            r103.put2("isTemplate", Boolean.valueOf(g.a(r110)));
            DocViewModel r111 = BitableProLynxPlugin.access$getDocViewModel(r104);
            if (r111 == null) goto L21;
            DocumentInfo r112 = r111.getDocumentInfoData();
            if (r112 == null) goto L21;
            DocPermission r113 = r112.getDocPermission();
            if (r113 == null) goto L21;
            IDocPublicPermission r114 = r113.f234420b;
            if (r114 == null) goto L21;
            Integer r115 = r114.getLinkShareEntityV2();
            if (r115 == null) goto L21;
            r107 = r115.intValue();
        L21:
            r103.put2("linkShareEntity", Integer.valueOf(r107));
            DocViewModel r116 = BitableProLynxPlugin.access$getDocViewModel(r104);
            if (r116 == null) goto L24;
            Boolean r117 = Boolean.valueOf(r116.isType(sbb.e.f541303n));
        L25:
            r103.put2("isWiki", r117);
            if (r101 == null) goto L29;
            r101.b(r103);
            return;
        L29:
            return;
        L24:
            r117 = null;
        L9:
            r110 = 0;
            goto L10
        }
    }

    public final class e implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BitableProRoleDetailFragmentV2 f214638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableProLynxPlugin f214639b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(BitableProLynxPlugin r100) {
            this.f214639b = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r210, m r211) {
            BitableProLynxPlugin.Companion.getClass();
            tt5.a.h(BitableProLynxPlugin.access$getADV_ROLE_DESC$cp(), "handle.");
            JSONObject r100 = new JSONObject((String) r210);
            ArrayList r101 = new ArrayList();
            JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r100, "blockInfo");
            int r103 = r102.length();
            int r104 = 0;
        L4:
            if (r104 >= r103) goto L10;
            JSONObject r105 = r102.optJSONObject(r104);
            if (r105 == null) goto L9;
            BlockSimpleInfo r106 = new BlockSimpleInfo();
            r106.setId(r105.optString("id"));
            r106.setName(r105.optString("name"));
            r106.setType(r105.optString("type"));
            r101.add(r106);
        L9:
            r104 = r104 + 1;
            goto L4
        L10:
            int r107 = r100.optInt("action");
            boolean r108 = r100.optBoolean("shouldShowNoPermissionNotice");
            h0 r109 = new h0(new ArrayList(), r101);
            JSONObject r110 = JSONObjectProtectorUtils.getJSONObject(r100, "roleData");
            String r111 = r110.optString("roleId");
            String r112 = r110.optString("name");
            JSONArray r113 = r110.optJSONArray("members");
            if (r113 != null) goto L13;
            r113 = new JSONArray();
        L13:
            ArrayList<UserInfo> r114 = com.bytedance.ee.bear.bitable.lynx.pro.c.a(r113);
            Intrinsics.checkNotNull(r110);
            Role r115 = new Role(r111, r112, r114, h0.c(r110), h0.d(r110), h0.b(r110), r109.h(r110), r109.e(r110), r109.f(r110), r110.optLong("createdTime", 0), false, 0, false, Boolean.valueOf(r100.optBoolean("isSoloBaseSuite")), 7168, null);
            FragmentTransaction r116 = BitableProLynxPlugin.access$getUIContainer(this.f214639b).getFragmentManager().beginTransaction();
            s r117 = s.a(R.anim.facade_slide_right_in_300, R.anim.facade_slide_left_out, R.anim.facade_slide_left_in, R.anim.facade_slide_right_out);
            f r118 = new f(this, r108, r211);
            if (r107 != 1) goto L20;
            BitableProRoleDetailFragmentV2 r119 = new BitableProRoleDetailFragmentV2();
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r119.f215234f = r115;
            r119.f215235g = true;
            r119.f215236h = r118;
            this.f214638a = r119;
            r116.setCustomAnimations(r117.f216644a, r117.f216645b, r117.f216646c, r117.f216647d);
            BitableProLynxPlugin.Companion.getClass();
            String r120 = BitableProLynxPlugin.access$getADV_ROLE_DESC$cp();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r116, r119, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r120, R.id.pluginUIContainer) == true) goto L19;
            r116.add(R.id.pluginUIContainer, r119, r120);
        L19:
            r116.commitAllowingStateLoss();
            return;
        L20:
            BitableProRoleDetailFragmentV2 r121 = this.f214638a;
            if (r121 == null) goto L28;
            r121.update(r115, r118);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.BitableCCMLynxPlugin, com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    static {
        Companion = new c();
        ADV_PERM_PANEL = "biz.bitable.openAdvPermPanel";
        ADV_ADD_MEMBER = "biz.bitable.addMembers";
        ADV_ROLE_DESC = "biz.bitable.openRoleDesPanel";
        ADV_OPEN_MEMBER_LIST = "biz.bitable.openMemberList";
    }

    public BitableProLynxPlugin() {
    }

    public static final /* synthetic */ String access$getADV_ADD_MEMBER$cp() {
        return ADV_ADD_MEMBER;
    }

    public static final /* synthetic */ String access$getADV_OPEN_MEMBER_LIST$cp() {
        return ADV_OPEN_MEMBER_LIST;
    }

    public static final /* synthetic */ String access$getADV_PERM_PANEL$cp() {
        return ADV_PERM_PANEL;
    }

    public static final /* synthetic */ String access$getADV_ROLE_DESC$cp() {
        return ADV_ROLE_DESC;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(BitableProLynxPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(BitableProLynxPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(BitableProLynxPlugin r100) {
        return r100.getDocViewModel();
    }

    public static final /* synthetic */ t access$getUIContainer(BitableProLynxPlugin r100) {
        return r100.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        String r101 = ADV_PERM_PANEL;
        r100.put(r101, new BitableCCMLynxPlugin.a(this, r101, 7, R.color.bg_base));
        if (com.bytedance.ee.bear.bitable.c.x() == true) goto L5;
        String r102 = ADV_OPEN_MEMBER_LIST;
        r100.put(r102, new BitableCCMLynxPlugin.a(this, r102, 8, R.color.bg_body));
    L5:
        r100.put(ADV_ADD_MEMBER, new a(this));
        r100.put(ADV_ROLE_DESC, new e(this));
        r100.put("biz.bitable.getNativeInfo", new d(this));
        r100.put("biz.bitable.businessAlert", new b(this));
    }
}
