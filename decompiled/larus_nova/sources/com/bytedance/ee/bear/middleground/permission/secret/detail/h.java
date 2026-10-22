package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.app.Application;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.middleground.permission.secret.a0;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.DataAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.LeftAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.SecretDetailAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.p;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f234081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f234082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jdb.g f234085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f234086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f234087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f234088h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f234089a;

        public b(h r100) {
            this.f234089a = r100;
        }

        /* JADX WARN: Type inference failed for: r12v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v83 */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            VisibleSecretResult r100 = (VisibleSecretResult) r110;
            d r101 = this.f234089a.f234087g;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r101 = null;
        L5:
            ((BearLottieView) r101.f234066b.findViewById(R.id.loadingView)).setVisibility(8);
            ((BearLottieView) r101.f234066b.findViewById(R.id.loadingView)).cancelAnimation();
            if (CollectionUtils.isEmpty((ArrayList) r100.data) == false) goto L8;
            tt5.a.d("SecretDetailPresenter", "data is null");
            return;
        L8:
            f r102 = this.f234089a.f234086f;
            if (r102 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r102 = null;
        L11:
            jdb.g r103 = this.f234089a.f234085e;
            if (r103 == null) goto L14;
            boolean r104 = r103.isEnable("ccm.admin.department_search_default_setting");
        L15:
            int r105 = this.f234089a.getType();
            r102.getClass();
            boolean r111 = com.bytedance.ee.bear.middleground.permission.b.j();
            boolean r112 = true;
            if (r105 != sbb.e.f541311v.f541317b) goto L18;
            boolean r113 = true;
        L19:
            if (r104 == false) goto L22;
            if (r113 == true) goto L22;
            boolean r106 = true;
        L23:
            ArrayList r114 = new ArrayList();
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(1, false, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_LinkSharing_Title), 8));
            int r115 = 2;
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(2, !r106, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_SharingRange_Title), 8));
            if (r106 == false) goto L26;
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(3, true, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_SearchFor_Title), 8));
        L26:
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(4, false, r102.f234072a.getString(a0.a(r105, R.string.LarkCCM_ChatShare_ExternalSharing_Title, R.string.LarkCCM_Workspace_SecuritySet_ExtSharing_Title)), 8));
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(5, !r111, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_WhoShare_Title), 8));
            if (r111 == false) goto L29;
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(6, true, r102.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTitle_ExternalSharingRange), 8));
        L29:
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(7, true, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_InviteCollab_Title), 8));
            if (r113 == true) goto L32;
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(8, true, r102.f234072a.getString(R.string.LarkCCM_Perms_RecordCopy_Settings_WhoCanCopy), 8));
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(9, true, r102.f234072a.getString(R.string.LarkCCM_Perms_Settings_WhoCanCopyPrintDwld_Descrip), 8));
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(10, true, r102.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Comment_Title), 8));
        L32:
            com.bytedance.ee.bear.appsetting.c r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
            Application r108 = LarkContext.getApplication();
            r107.getClass();
            boolean r109 = ((dn4.a) k.b(((v) k.a(r108, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r108, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.permission.knowledge_ai_search_excluded");
            tt5.a.h("PermFGUtils", "showAISearchDescItem()...enable = " + r109);
            if (r109 == false) goto L36;
            if (r113 == true) goto L36;
            r114.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(11, true, r102.f234072a.getString(R.string.LarkCCM_SecurityLv_KnoAiCanSearch_Title), 8));
        L36:
            f r116 = this.f234089a.f234086f;
            if (r116 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r116 = null;
        L39:
            r116.getClass();
            ArrayList r117 = new ArrayList();
            Iterator r118 = ((ArrayList) r100.data).iterator();
        L41:
            if (r118.hasNext() == false) goto L43;
            r117.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.a(((SecretLevel) r118.next()).getName(), false, false, 6));
            goto L41
        L43:
            f r119 = this.f234089a.f234086f;
            if (r119 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r119 = null;
        L46:
            r119.getClass();
            Intrinsics.checkNotNullParameter(r114, "leftData");
            ArrayList r120 = new ArrayList();
            ArrayList r121 = (ArrayList) r100.data;
            boolean r122 = com.bytedance.ee.bear.middleground.permission.b.j();
            Iterator r123 = r114.iterator();
        L48:
            if (r123.hasNext() == false) goto L50;
            r120.add(new j(((com.bytedance.ee.bear.middleground.permission.secret.detail.b) r123.next()).f234062b, 6));
            goto L48
        L50:
            Iterator r124 = r121.iterator();
        L52:
            if (r124.hasNext() == false) goto L204;
            PermissionControl r125 = ((SecretLevel) r124.next()).getPermissionControl();
            int r126 = r114.size();
            int r127 = 0;
            ?? r128 = r112;
        L54:
            if (r127 >= r126) goto L203;
            com.bytedance.ee.bear.middleground.permission.secret.detail.b r129 = (com.bytedance.ee.bear.middleground.permission.secret.detail.b) CollectionsKt.getOrNull(r114, r127);
            j r130 = (j) CollectionsKt.getOrNull(r120, r127);
            if (r129 == null) goto L201;
            if (r130 == null) goto L201;
            switch(r129.f234061a) {
                case 1: goto L191;
                case 2: goto L166;
                case 3: goto L157;
                case 4: goto L149;
                case 5: goto L127;
                case 6: goto L119;
                case 7: goto L98;
                case 8: goto L87;
                case 9: goto L76;
                case 10: goto L68;
                case 11: goto L63;
                default: goto L61;
            };
        L61:
            com.bytedance.ee.bear.middleground.permission.secret.detail.a r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, false, false, 7);
        L200:
            r130.f234093b.add(r131);
        L202:
            r127 = r127 + 1;
            r128 = 1;
            r115 = 2;
            goto L54
        L157:
            int r132 = r125.getSearchEntity();
            if (r132 != 1) goto L160;
            String r133 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            Intrinsics.checkNotNull(r133);
        L164:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r133, false, false, 6);
            goto L200
        L160:
            if (r132 == 2) goto L162;
            r133 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            Intrinsics.checkNotNull(r133);
            goto L164
        L162:
            r133 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Off_Status);
            Intrinsics.checkNotNull(r133);
            goto L164
        L63:
            if (r125.getDisableAISearchEntity() == r115) goto L65;
            boolean r134 = true;
        L66:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, r128, r134, r128);
            goto L200
        L65:
            r134 = false;
            goto L66
        L68:
            if (r125.onlyCanReadCanComment() == false) goto L71;
            String r135 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanView);
        L74:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r135, false, false, 6);
            goto L200
        L71:
            if (r125.onlyCanEditorCanComment() == false) goto L73;
            r135 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanEdit);
            goto L74
        L73:
            r135 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L74
        L76:
            if (r125.onlyCanCopyAndDownload() == false) goto L79;
            String r136 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanView);
        L85:
            com.bytedance.ee.bear.middleground.permission.secret.detail.a r137 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r136, false, false, 6);
        L117:
            r131 = r137;
            goto L200
        L79:
            if (r125.onlyEditorOrFaCanCopyAndDownload() == false) goto L82;
            r136 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanEdit);
            goto L85
        L82:
            if (r125.onlyFaCanCopyAndDownload() == false) goto L84;
            r136 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanManage);
            goto L85
        L84:
            r136 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L85
        L87:
            if (r125.onlyReadCanCopy() == false) goto L90;
            String r138 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanView);
        L96:
            r137 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r138, false, false, 6);
            goto L117
        L90:
            if (r125.onlyEditorOrFaCanCopy() == false) goto L93;
            r138 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanEdit);
            goto L96
        L93:
            if (r125.onlyFaCanCopy() == false) goto L95;
            r138 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanManage);
            goto L96
        L95:
            r138 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L96
        L98:
            if (r125.onlyCanAddCollaborator() == false) goto L101;
            String r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanView);
        L116:
            r137 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r139, false, false, 6);
            goto L117
        L101:
            if (r125.onlyInternalCanAddCollaborator() == false) goto L104;
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_ViewPermInOrg);
            goto L116
        L104:
            if (r125.onlyCanEditorCanAddCollaborator() == false) goto L107;
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanEdit);
            goto L116
        L107:
            if (r125.onlyInterCanEditorCanAddCollaborator() == false) goto L110;
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_EditPermInOrg);
            goto L116
        L110:
            if (r125.onlyFaCanAddOrManagerCollaborator() == false) goto L113;
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_CanManage);
            goto L116
        L113:
            if (r125.onlyInternalCanAddOrManagerCollaborator() == false) goto L115;
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_OrgManage);
            goto L116
        L115:
            r139 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L116
        L119:
            if (r125.shareExternalNoLimit() == false) goto L122;
            String r140 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
        L125:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r140, false, false, 6);
            goto L200
        L122:
            if (r125.shareExternalOnlyRelated() == false) goto L124;
            r140 = r119.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTxt_WithTrustedPartiesOnly);
            goto L125
        L124:
            r125.denyShareExternal();
            r140 = "-";
            goto L125
        L127:
            if (com.bytedance.ee.bear.middleground.permission.b.j() == false) goto L138;
            if (r125.onlyShareInternalV2() == false) goto L132;
            String r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Off_Status);
        L147:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r141, false, false, 6);
            goto L200
        L132:
            if (r125.onlyFaCanShareExternalV2() == false) goto L135;
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_ManagePerm);
            goto L147
        L135:
            if (r125.onlyCanShowInternalV2() == false) goto L146;
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
        L146:
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L147
        L138:
            if (r125.onlyShareInternal() == false) goto L141;
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Off_Status);
            goto L147
        L141:
            if (r125.onlyFaCanShareExternal() == false) goto L144;
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_ManagePerm);
            goto L147
        L144:
            if (r125.onlyCanShareInternal() == false) goto L146;
            r141 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L147
        L149:
            if (r122 == false) goto L153;
            boolean r142 = r125.allowShareExternal();
        L156:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, true, r142, 1);
            goto L200
        L153:
            if (r125.onlyShareInternal() == true) goto L155;
            r142 = true;
            goto L156
        L155:
            r142 = false;
            goto L156
        L166:
            if (r125.closeLinkShare() == false) goto L169;
            String r143 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Off_Status);
        L189:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r143, false, false, 6);
            goto L200
        L169:
            if (r125.canReadInternalLinkShare() == false) goto L172;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_LinkSharing_AnyWithLinkCanView_Desc_Mob);
            goto L189
        L172:
            if (r125.canEditorInternalLinkShare() == false) goto L175;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_LinkSharing_AnyWithLinkCanEdit_Desc_Mob);
            goto L189
        L175:
            if (r125.canReadLinkShare() == false) goto L178;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTxt_AnyoneWLinkCanView);
            goto L189
        L178:
            if (r125.canEditorLinkShare() == false) goto L181;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTxt_AnyoneWLinkCanEdit);
            goto L189
        L181:
            if (com.bytedance.ee.bear.middleground.permission.b.j() == true) goto L183;
        L188:
            r143 = r119.f234072a.getString(R.string.LarkCCM_Workspace_SecuritySet_Unlimited);
            goto L189
        L183:
            if (r125.canOrgReadLinkShare() == false) goto L186;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTxt_TrustedPartiesWLinkCanView);
            goto L189
        L186:
            if (r125.canOrgEditLinkShare() == false) goto L188;
            r143 = r119.f234072a.getString(R.string.LarkCCM_Security_SecurityLevelSharingScopeTxt_TrustedPartiesWLinkCanEdit);
            goto L189
        L191:
            if (r122 == false) goto L195;
            boolean r144 = r125.allowLinkShare();
        L198:
            r131 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, true, r144, 1);
            goto L200
        L195:
            if (r125.closeLinkShare() == true) goto L197;
            r144 = true;
            goto L198
        L197:
            r144 = false;
        L201:
            tt5.a.h("SecretDetailModel", "getTableData - assemble detail, params invalid, eachLeft: " + r129 + ", eachDetail: " + r130);
            goto L202
        L203:
            r112 = true;
            goto L52
        L204:
            int r145 = r114.size();
            int r146 = 0;
        L205:
            if (r146 >= r145) goto L215;
            int r147 = n.d(r119.f234073b);
            List<com.bytedance.ee.bear.middleground.permission.secret.detail.a> r148 = ((j) ListProtector.get(r120, r146)).f234093b;
            if (CollectionUtils.isEmpty(r148) == true) goto L214;
            Iterator<com.bytedance.ee.bear.middleground.permission.secret.detail.a> r149 = r148.iterator();
        L211:
            if (r149.hasNext() == false) goto L213;
            r147 = Math.max(r147, r119.a(r149.next().f234044a));
            goto L211
        L213:
            r147 = Math.max(r147, r119.a(((com.bytedance.ee.bear.middleground.permission.secret.detail.b) ListProtector.get(r114, r146)).f234063c));
        L214:
            ((com.bytedance.ee.bear.middleground.permission.secret.detail.b) ListProtector.get(r114, r146)).f234064d = r147;
            ((j) ListProtector.get(r120, r146)).f234094c = r147;
            r146 = r146 + 1;
            goto L205
        L215:
            d r150 = this.f234089a.f234087g;
            if (r150 != null) goto L218;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r150 = null;
        L218:
            r150.getClass();
            Intrinsics.checkNotNullParameter(r120, "<set-?>");
            r150.f234067c = r120;
            d r151 = this.f234089a.f234087g;
            if (r151 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r151 = null;
        L221:
            r151.getClass();
            Intrinsics.checkNotNullParameter(r117, "<set-?>");
            r151.f234068d = r117;
            d r152 = this.f234089a.f234087g;
            if (r152 != null) goto L224;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r152 = null;
        L224:
            r152.getClass();
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r152.f234069e = r114;
            d r153 = this.f234089a.f234087g;
            if (r153 != null) goto L227;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r153 = null;
        L227:
            ((LinearLayout) r153.f234066b.findViewById(R.id.horizontal_header_content)).setVisibility(0);
            ((ScrollView) r153.f234066b.findViewById(R.id.scroll_content)).setVisibility(0);
            ((SyncHorizontalScrollView) r153.f234066b.findViewById(R.id.data_horizontal)).setScrollView(r153.f234066b.findViewById(R.id.header_horizontal));
            ((SyncHorizontalScrollView) r153.f234066b.findViewById(R.id.header_horizontal)).setScrollView(r153.f234066b.findViewById(R.id.data_horizontal));
            LeftAdapter r154 = new LeftAdapter(r153.f234069e);
            ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_left)).setLayoutManager(new LinearLayoutManager(r153.f234065a));
            ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_left)).setAdapter(r154);
            SecretDetailAdapter r155 = new SecretDetailAdapter(r153.f234067c);
            ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_data)).setLayoutManager(new LinearLayoutManager(r153.f234065a));
            ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_data)).setAdapter(r155);
            if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()) == true) goto L230;
            ViewGroup.LayoutParams r156 = ((LinearLayout) r153.f234066b.findViewById(R.id.header_permission_text)).getLayoutParams();
            r156.width = n.d(98);
            ((LinearLayout) r153.f234066b.findViewById(R.id.header_permission_text)).setLayoutParams(r156);
            ViewGroup.LayoutParams r157 = ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_left)).getLayoutParams();
            r157.width = n.d(98);
            ((NoscrollRecycleView) r153.f234066b.findViewById(R.id.lv_left)).setLayoutParams(r157);
        L230:
            DataAdapter r158 = new DataAdapter(r153.f234068d, -1, true, r153.f234070f);
            ((RecyclerView) r153.f234066b.findViewById(R.id.header_recycleView)).setLayoutManager(new LinearLayoutManager(r153.f234065a, 0, false));
            ((RecyclerView) r153.f234066b.findViewById(R.id.header_recycleView)).setAdapter(r158);
            return;
        L22:
            r106 = false;
            goto L23
        L18:
            r113 = false;
            goto L19
        L14:
            r104 = false;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f234090a;

        public c(h r100) {
            this.f234090a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("SecretDetailPresenter", "throw error" + ((Throwable) r100));
            d r101 = this.f234090a.f234087g;
            f r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r101 = null;
        L5:
            ((BearLottieView) r101.f234066b.findViewById(R.id.loadingView)).setVisibility(8);
            ((BearLottieView) r101.f234066b.findViewById(R.id.loadingView)).cancelAnimation();
            d r103 = this.f234090a.f234087g;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r103 = null;
        L8:
            ((LinearLayout) r103.f234066b.findViewById(R.id.horizontal_header_content)).setVisibility(8);
            ((ScrollView) r103.f234066b.findViewById(R.id.scroll_content)).setVisibility(8);
            f r104 = this.f234090a.f234086f;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r104 = null;
        L11:
            i r105 = new i(this.f234090a);
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "listener");
            r104.f234079h = r105;
            d r106 = this.f234090a.f234087g;
            if (r106 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r106 = null;
        L14:
            f r107 = this.f234090a.f234086f;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L18:
            String r108 = r102.f234072a.getString(R.string.CreationMobile_PDFPreview_Failed_Placeholder1);
            String r109 = r102.f234072a.getString(R.string.CreationMobile_PDFPreview_Failed_Placeholder2);
            SpannableString r110 = new SpannableString(r108 + r109);
            g r111 = new g(r102);
            ForegroundColorSpan r112 = new ForegroundColorSpan(r102.f234072a.getResources().getColor(R.color.primary_fill_default));
            r110.setSpan(r111, 0, r110.length(), 17);
            r110.setSpan(r112, r110.length() - r109.length(), r110.length(), 17);
            r106.getClass();
            Intrinsics.checkNotNullParameter(r110, "str");
            ((LinearLayout) r106.f234066b.findViewById(R.id.loadingFailedLayout)).setVisibility(0);
            ((TextView) r106.f234066b.findViewById(R.id.fail_text)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) r106.f234066b.findViewById(R.id.fail_text)).setText(r110);
            return;
        L17:
            r102 = r107;
            goto L18
        }
    }

    static {
    }

    public final void a() {
        d r100 = this.f234087g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
        r100 = null;
    L5:
        ((BearLottieView) r100.f234066b.findViewById(R.id.loadingView)).setVisibility(0);
        ((BearLottieView) r100.f234066b.findViewById(R.id.loadingView)).playAnimation();
        CompositeDisposable r101 = this.f234088h;
        int r102 = p.f234126a;
        r101.add(p.a(this.f234083c, this.f234084d).subscribe(new b(this), new c(this)));
    }

    public final Context getContext() {
        return this.f234081a;
    }

    public final int getType() {
        return this.f234084d;
    }

    public h(Context r100, View r101, String r102, int r103, jdb.g r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mRootView");
        Intrinsics.checkNotNullParameter(r102, "token");
        this.f234081a = r100;
        this.f234082b = r101;
        this.f234083c = r102;
        this.f234084d = r103;
        this.f234085e = r104;
        this.f234088h = new CompositeDisposable();
        this.f234086f = new f(r100);
        this.f234087g = new d(r100, r101);
        a();
    }
}
