package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "pageTrigger", "Lcom/bytedance/ee/bear/bitable/pro/IBitableProPageTrigger;", "<init>", "(Lcom/bytedance/ee/bear/bitable/pro/IBitableProPageTrigger;)V", "convert", "", "helper", "role", "AvatarListAdapter", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProAdapter extends BaseQuickAdapter<Role, BaseViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f215048b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f215049a;

    public static final class a extends UDAvatarList.AvatarAdapter<UserInfo> {
        public a() {
            super(-3, null, 2, null);
        }

        @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
        public final void onItemCreated(UDAvatar r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "avatar");
            UserInfo r102 = getItem(r101);
            if (r102 == null) goto L6;
            pg5.a.b(r100, r102);
            return;
        }
    }

    public static final class b {
        public static String a(Context r110, Role r111) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "role");
            int r100 = r111.getCanEditTableCount();
            int r101 = r111.getCanReadTableCount();
            String r102 = r110.getString(R.string.CreationMobile_common_punctuation_comma);
            int r112 = r111.getCanReadDashboardCount();
            if (r112 <= 0) goto L5;
            String r113 = r110.getResources().getQuantityString(R.plurals.Bitable_AdvancedPermissions_Dashboard_ViewNumDashboards_Desc_Mob, r112, new Object[]{Integer.valueOf(r112)}) + r102;
        L7:
            if (r100 <= 0) goto L10;
            if (r101 <= 0) goto L10;
            String r114 = r110.getResources().getQuantityString(R.plurals.Bitable_AdvancedPermission_CanEditNumTable, r100, new Object[]{Integer.valueOf(r100)}) + r102 + r110.getResources().getQuantityString(R.plurals.Bitable_AdvancedPermission_CanViewNumTable, r101, new Object[]{Integer.valueOf(r101)});
        L16:
            return r113 + r114;
        L10:
            if (r100 <= 0) goto L12;
            r114 = r110.getResources().getQuantityString(R.plurals.Bitable_AdvancedPermission_CanEditNumTable, r100, new Object[]{Integer.valueOf(r100)});
            Intrinsics.checkNotNull(r114);
            goto L16
        L12:
            if (r101 <= 0) goto L14;
            r114 = r110.getResources().getQuantityString(R.plurals.Bitable_AdvancedPermission_CanViewNumTable, r101, new Object[]{Integer.valueOf(r101)});
            Intrinsics.checkNotNull(r114);
            goto L16
        L14:
            r114 = r110.getString(R.string.Bitable_AdvancedPermission_NoAccessToAnyTable);
            Intrinsics.checkNotNull(r114);
            goto L16
        L5:
            r113 = "";
            goto L7
        }
    }

    static {
    }

    public BitableProAdapter(i0 r100) {
        super(R.layout.bitable_pro_card_item_v2);
        this.f215049a = r100;
    }

    public static final /* synthetic */ Context y2(BitableProAdapter r100) {
        return r100.mContext;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, Role r111) {
        Role r100 = r111;
        Intrinsics.checkNotNullParameter(r110, "helper");
        Intrinsics.checkNotNullParameter(r100, "role");
        boolean r101 = r100.isFaType();
        int r102 = R.color.icon_disable;
        int r103 = R.color.icon_n1;
        int r112 = R.color.text_title;
        if (r101 == false) goto L5;
        r110.setGone(R.id.managers_layout, true);
        r110.setGone(R.id.roleTitle, false).setGone(R.id.inviteMemberLayout, false).setGone(R.id.managerMemberLayout, true).setGone(R.id.template_pro_tips, false);
        r110.setText(R.id.roleDesc, R.string.Bitable_AdvancedPermission_WhoCanManageDesc);
    L30:
        if (r100.isFaType() == false) goto L32;
    L35:
        boolean r104 = true;
    L36:
        ImageView r113 = (ImageView) r110.getView(R.id.managerMemberIcon);
        if (r104 == false) goto L39;
        r103 = R.color.icon_disable;
    L39:
        com.bytedance.ee.util.ui.l.c(r113, r103);
        ImageView r114 = (ImageView) r110.getView(R.id.managerMemberArrowIcon);
        if (r104 == true) goto L43;
        r102 = R.color.icon_n3;
    L43:
        com.bytedance.ee.util.ui.l.c(r114, r102);
        Resources r105 = r110.itemView.getResources();
        if (r104 == false) goto L46;
        r112 = R.color.text_disable;
    L46:
        r110.setTextColor(R.id.managerMemberText, r105.getColor(r112));
        if (r100.getMembers().isEmpty() == false) goto L49;
        r110.setVisible(R.id.managerMemberArrowIcon, true).setGone(R.id.memberAvatarList, false);
    L54:
        r110.itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.pro.b(r100, this));
        r110.getView(R.id.inviteMemberLayout).setOnClickListener(new c(r100, this));
        return;
    L49:
        r110.setGone(R.id.managerMemberArrowIcon, false).setVisible(R.id.memberAvatarList, true);
        a r106 = new a();
        r106.setData(r100.getMembers());
        ((UDAvatarList) r110.getView(R.id.memberAvatarList)).setAdapter(r106);
        UDAvatarList r107 = (UDAvatarList) r110.getView(R.id.memberAvatarList);
        if (r104 == false) goto L52;
        float r108 = 0.3f;
    L53:
        r107.setAlpha(r108);
        goto L54
    L52:
        r108 = 1.0f;
        goto L53
    L32:
        if (r100.disableEditMembers() == true) goto L35;
        r104 = false;
        goto L36
    L5:
        r110.setGone(R.id.managers_layout, false);
        if (r100.isTemplate() == false) goto L8;
        r110.setGone(R.id.inviteMemberLayout, false).setGone(R.id.managerMemberLayout, false).setVisible(R.id.template_pro_tips, true);
    L9:
        String r109 = b.a(this.mContext, r100);
        DefaultTagTitleView r115 = (DefaultTagTitleView) r110.getView(R.id.roleTitle);
        r115.setTitle(r100.getName());
        boolean r116 = r100.isDefault();
        TextView r117 = r115.f215101b;
        if (r116 == false) goto L12;
        int r118 = 0;
    L13:
        r117.setVisibility(r118);
        r115.f215101b.setText(R.string.Bitable_AdvancedPermission_DefaultPermission);
        if (r100.hasCostPerm() == false) goto L16;
        r115.f215101b.setVisibility(0);
        r115.f215101b.setText(R.string.Bitable_AdvancedPermission_PremiumFeatureIncludedTag);
        r115.setBackground(R.drawable.bitable_pro_cost_tag_bg);
        r115.setTagTextColor(R.color.udtoken_tag_text_s_orange);
    L16:
        r110.setText(R.id.roleDesc, r109);
        r110.getView(R.id.managerMemberLayout).setOnClickListener(new com.bytedance.ee.bear.bitable.pro.a(r100, this));
        ImageView r119 = (ImageView) r110.getView(R.id.inviteMemberIcon);
        if (r100.disableAddMembers() == false) goto L19;
        int r120 = R.color.icon_disable;
    L20:
        com.bytedance.ee.util.ui.l.c(r119, r120);
        ImageView r121 = (ImageView) r110.getView(R.id.inviteMemberArrowIcon);
        if (r100.disableAddMembers() == false) goto L23;
        int r122 = R.color.icon_disable;
    L24:
        com.bytedance.ee.util.ui.l.c(r121, r122);
        Resources r123 = r110.itemView.getResources();
        if (r100.disableAddMembers() == false) goto L27;
        int r124 = R.color.text_disable;
    L28:
        r110.setTextColor(R.id.inviteMemberText, r123.getColor(r124));
        goto L30
    L27:
        r124 = R.color.text_title;
        goto L28
    L23:
        r122 = R.color.icon_n3;
        goto L24
    L19:
        r120 = R.color.icon_n1;
        goto L20
    L12:
        r118 = 8;
        goto L13
    L8:
        r110.setVisible(R.id.inviteMemberLayout, true).setVisible(R.id.managerMemberLayout, true).setGone(R.id.template_pro_tips, false);
        goto L9
    }
}
