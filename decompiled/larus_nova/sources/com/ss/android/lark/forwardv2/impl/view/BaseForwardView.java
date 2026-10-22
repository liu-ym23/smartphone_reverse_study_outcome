package com.ss.android.lark.forwardv2.impl.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$TenantCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.widget.ChatPicker;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseForwardView implements iib.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f424951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f424952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f424953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public iib.c.a f424954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f424955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f424956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f424957g;

    @BindView(9124)
    ChatPicker mChatPicker;

    @BindView(9802)
    CommonTitleBar mTitleBar;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DIS_MODE {
        public static final int SEARCH = 0;
        public static final int SHOW_RECENT = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SELECT_TYPE {
        public static final int MULTI = 1;
        public static final int SINGLE = 0;
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseForwardView f424958a;

        public a(BaseForwardView r100) {
            this.f424958a = r100;
        }
    }

    public class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f424959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseForwardView f424960b;

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            if (this.f424959a == false) goto L6;
            this.f424960b.f424951a.finish();
            return;
        }

        public b(BaseForwardView r100, boolean r101) {
            this.f424960b = r100;
            this.f424959a = r101;
        }
    }

    public interface c {
        void a(Context r100, String r101);

        void b(String r100);

        void c();

        void d(int r100, Intent r101);

        void e(iib.c r100);

        void f(Bundle r100);

        void finish();

        Context getContext();

        FragmentManager getFragmentManager();

        void setResult(int r100, Intent r101);
    }

    @Override // iib.c
    public abstract void z6(List<SearchBaseInfo> r100);

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f424953c.e(this);
        final d0 r100 = (d0) this;
        if (r100.f424984q == false) goto L6;
        r100.f424956f = 1;
    L6:
        if (r100.f424975h.f424789e.f424862a == true) goto L8;
        r100.mTitleBar.setVisibility(8);
    L17:
        int r101 = lib.a.f509447a;
        BusinessRecentVisitEnableConfig r102 = r100.f424975h.f424786b;
        Intrinsics.checkNotNullParameter(r102, "enableConfig");
        StringBuilder r103 = new StringBuilder();
        Iterator<T> r104 = r102.f424820c.iterator();
    L19:
        if (r104.hasNext() == false) goto L75;
        EntityItem r105 = (EntityItem) r104.next();
        if (r105.f424880a == null) goto L36;
        r103.append("UserConfig: ");
        StringBuilder r106 = new StringBuilder("tenantCondition is ");
        UserConfig r110 = r105.f424880a;
        if (r110 == null) goto L25;
        Condition$TenantCondition r111 = r110.getTenantCondition();
    L26:
        r106.append(r111);
        r106.append(',');
        r103.append(r106.toString());
        StringBuilder r107 = new StringBuilder("userTypeCondition is ");
        UserConfig r112 = r105.f424880a;
        if (r112 == null) goto L29;
        Condition$UserTypeCondition r113 = r112.getUserTypeCondition();
    L30:
        r107.append(r113);
        r107.append(',');
        r103.append(r107.toString());
        StringBuilder r108 = new StringBuilder("shieldTypeCondition is ");
        UserConfig r114 = r105.f424880a;
        if (r114 == null) goto L33;
        Condition$ShieldTypeCondition r115 = r114.getShieldTypeCondition();
    L34:
        r108.append(r115);
        r108.append(",\n");
        r103.append(r108.toString());
        goto L36
    L33:
        r115 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = null;
    L36:
        if (r105.f424881b == null) goto L55;
        r103.append("GroupChatConfig: ");
        StringBuilder r109 = new StringBuilder(" tenantCondition is ");
        GroupChatConfig r116 = r105.f424881b;
        if (r116 == null) goto L40;
        Condition$TenantCondition r117 = r116.getTenantCondition();
    L41:
        r109.append(r117);
        r109.append(',');
        r103.append(r109.toString());
        StringBuilder r118 = new StringBuilder("groupChatTypeCondition is ");
        GroupChatConfig r119 = r105.f424881b;
        if (r119 == null) goto L44;
        Condition$GroupChatTypeCondition r120 = r119.getGroupChatTypeCondition();
    L45:
        r118.append(r120);
        r118.append(',');
        r103.append(r118.toString());
        StringBuilder r121 = new StringBuilder("publicTypeCondition is ");
        GroupChatConfig r122 = r105.f424881b;
        if (r122 == null) goto L48;
        Condition$PublicTypeCondition r123 = r122.getPublicTypeCondition();
    L49:
        r121.append(r123);
        r121.append(',');
        r103.append(r121.toString());
        StringBuilder r124 = new StringBuilder("shieldTypeCondition is ");
        GroupChatConfig r125 = r105.f424881b;
        if (r125 == null) goto L52;
        Condition$ShieldTypeCondition r126 = r125.getShieldTypeCondition();
    L53:
        r124.append(r126);
        r124.append('\n');
        r103.append(r124.toString());
        goto L55
    L52:
        r126 = null;
        goto L53
    L48:
        r123 = null;
        goto L49
    L44:
        r120 = null;
        goto L45
    L40:
        r117 = null;
    L55:
        if (r105.f424883d == null) goto L70;
        r103.append("ThreadConfig: ");
        StringBuilder r127 = new StringBuilder("tenantCondition is ");
        ThreadConfig r128 = r105.f424883d;
        if (r128 == null) goto L59;
        Condition$TenantCondition r129 = r128.getTenantCondition();
    L60:
        r127.append(r129);
        r127.append(',');
        r103.append(r127.toString());
        StringBuilder r130 = new StringBuilder("publicTypeCondition is ");
        ThreadConfig r131 = r105.f424883d;
        if (r131 == null) goto L63;
        Condition$PublicTypeCondition r132 = r131.getPublicTypeCondition();
    L64:
        r130.append(r132);
        r130.append(',');
        r103.append(r130.toString());
        StringBuilder r133 = new StringBuilder("threadTypeCondition is ");
        ThreadConfig r134 = r105.f424883d;
        if (r134 == null) goto L67;
        Condition$ThreadTypeCondition r135 = r134.getThreadTypeCondition();
    L68:
        r133.append(r135);
        r133.append('\n');
        r103.append(r133.toString());
        goto L70
    L67:
        r135 = null;
        goto L68
    L63:
        r132 = null;
        goto L64
    L59:
        r129 = null;
    L70:
        if (r105.f424882c == null) goto L73;
        r103.append("BotConfig: \n");
    L73:
        if (r105.f424884e == null) goto L19;
        r103.append("AIConfig: \n");
        goto L19
    L75:
        Log.i("Android_Recent_Visit", "enableConfigs is\n" + r103);
        WeakReference<Message> r136 = ForwardDataUtils.f425557a;
        com.ss.android.lark.forwardv3.utils.b.d();
        String r137 = UIHelper.getString(R.string.Lark_IM_ForwardToRecentChats_Title);
        Intrinsics.checkNotNull(r137);
        ForwardDataUtils.f425560d = r137;
        int r138 = lib.a.f509447a;
        BusinessRecentVisitIncludeConfig r139 = r100.f424975h.f424785a;
        Intrinsics.checkNotNullParameter(r139, "includeConfig");
        Log.i("Android_Recent_Visit", "start getSearchPickerParams");
        final lib.a.C6699a r140 = new lib.a.C6699a();
        Iterator<T> r141 = r139.f424822a.iterator();
    L77:
        if (r141.hasNext() == false) goto L113;
        EntityItem r142 = (EntityItem) r141.next();
        UserConfig r143 = r142.f424880a;
        if (r143 == null) goto L91;
        Condition$TenantCondition r144 = r143.getTenantCondition();
        if (r144 != null) goto L83;
        int r145 = -1;
    L84:
        if (r145 == 1) goto L90;
        if (r145 == 2) goto L89;
        if (r145 != 3) goto L91;
        Log.i("Android_Recent_Visit", "only include outer users not supported");
        goto L91
    L89:
        r140.f509450c = false;
        goto L91
    L90:
        r140.f509450c = true;
        r140.f509448a = false;
        goto L91
    L83:
        r145 = lib.a.b.f509454a[r144.ordinal()];
    L91:
        GroupChatConfig r146 = r142.f424881b;
        if (r146 == null) goto L105;
        Condition$TenantCondition r147 = r146.getTenantCondition();
        if (r147 != null) goto L96;
        int r148 = -1;
    L97:
        if (r148 == 1) goto L103;
        if (r148 == 2) goto L102;
        if (r148 != 3) goto L105;
        Log.i("Android_Recent_Visit", "only include outer group chats not supported");
        goto L105
    L102:
        r140.f509449b = false;
        goto L105
    L103:
        r140.f509449b = true;
        goto L105
    L96:
        r148 = lib.a.b.f509454a[r147.ordinal()];
    L105:
        if (r142.f424882c == null) goto L108;
        r140.f509451d = true;
    L108:
        if (r142.f424883d == null) goto L111;
        r140.f509452e = true;
    L111:
        if (r142.f424884e == null) goto L77;
        r140.f509453f = true;
        goto L77
    L113:
        Log.i("Android_Recent_Visit", "end getSearchPickerParams, result: \nexcludeOuterUser is " + r140.f509448a + " \nincludeOutGroupChat is " + r140.f509449b + " \nneedSearchOuterTenant is " + r140.f509450c + " \nincludeBot is " + r140.f509451d + " \nincludeThread is " + r140.f509452e);
        r100.mChatPicker.attachMultiple(r100.f424984q).attachPermissions(Collections.singletonList(ActionType.SHARE_MESSAGE_SELECT_USER)).attachOnPickerParamsLoader(new com.ss.android.lark.forwardv2.impl.view.a(r140)).attachDependency(new x(r100)).attachOnPickerNotify(new w(r100)).attachOnBusinessConsumeItem(new t(r100)).attachChatCountStyle(true).attachScene("msg_forward").attachIsEnableChatPreview(r100.f424975h.f424787c.f424835k);
        if (r100.f424975h.f424787c.f424827c == false) goto L196;
        View r149 = View.inflate(r100.f424951a, R.layout.activity_forward_func_panel_item, null);
        boolean r150 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_chat_with_filter", false);
        Log.i("FGUtils", "FG key: lark.forward.create_group_chat_with_filter, is " + r150);
        if (r150 == false) goto L194;
        com.ss.android.lark.forwardv3.plugins.f r151 = r100.f424981n;
        int r152 = lib.a.f509447a;
        ForwardTemplate r153 = r100.f424975h;
        Intrinsics.checkNotNullParameter(r153, "forwardTemplateV2");
        IncludeConfig.a r154 = new IncludeConfig.a();
        Iterator<T> r155 = r153.f424785a.f424822a.iterator();
    L119:
        if (r155.hasNext() == false) goto L155;
        EntityItem r156 = (EntityItem) r155.next();
        UserConfig r157 = r156.f424880a;
        if (r157 == null) goto L133;
        Condition$TenantCondition r158 = r157.getTenantCondition();
        if (r158 != null) goto L125;
        int r159 = -1;
    L126:
        if (r159 == 1) goto L132;
        if (r159 == 2) goto L131;
        if (r159 == 3) goto L130;
        Unit r160 = Unit.INSTANCE;
        goto L133
    L130:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r161 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r162 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r162.b(Condition$Tenant.CROSS_TENANT);
        r161.f(r162.a());
        r154.a(r161.c());
        goto L133
    L131:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r163 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r164 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r164.b(Condition$Tenant.NOT_CROSS_TENANT);
        r163.f(r164.a());
        r154.a(r163.c());
        goto L133
    L132:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r165 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r166 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r166.b(Condition$Tenant.ALL);
        r165.f(r166.a());
        r154.a(r165.c());
        goto L133
    L125:
        r159 = lib.a.b.f509454a[r158.ordinal()];
    L133:
        GroupChatConfig r167 = r156.f424881b;
        if (r167 == null) goto L147;
        Condition$TenantCondition r168 = r167.getTenantCondition();
        if (r168 != null) goto L138;
        int r169 = -1;
    L139:
        if (r169 == 1) goto L145;
        if (r169 == 2) goto L144;
        if (r169 == 3) goto L143;
        Unit r170 = Unit.INSTANCE;
        goto L147
    L143:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r171 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r172 = new GroupConfig.a();
        r172.b(Condition$Tenant.CROSS_TENANT);
        r171.d(r172.a());
        r154.a(r171.c());
        goto L147
    L144:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r173 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r174 = new GroupConfig.a();
        r174.b(Condition$Tenant.NOT_CROSS_TENANT);
        r173.d(r174.a());
        r154.a(r173.c());
        goto L147
    L145:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r175 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r176 = new GroupConfig.a();
        r176.b(Condition$Tenant.ALL);
        r175.d(r176.a());
        r154.a(r175.c());
        goto L147
    L138:
        r169 = lib.a.b.f509454a[r168.ordinal()];
    L147:
        if (r156.f424882c == null) goto L150;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r177 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r177.b(new BotConfig());
        r154.a(r177.c());
    L150:
        if (r156.f424883d == null) goto L153;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r178 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r178.e(new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a().a());
        r154.a(r178.c());
    L153:
        if (r156.f424884e == null) goto L119;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r179 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r179.a(new AIConfig());
        r154.a(r179.c());
        goto L119
    L155:
        DisableConfig.a r180 = new DisableConfig.a();
        if (CollectionUtils.isEmpty(r153.f424786b.f424820c) == true) goto L191;
        Iterator<T> r181 = r153.f424786b.f424820c.iterator();
    L159:
        if (r181.hasNext() == false) goto L191;
        EntityItem r182 = (EntityItem) r181.next();
        UserConfig r183 = r182.f424880a;
        if (r183 == null) goto L171;
        Condition$TenantCondition r184 = r183.getTenantCondition();
        if (r184 != null) goto L165;
        int r185 = -1;
    L166:
        if (r185 == 2) goto L170;
        if (r185 != 3) goto L171;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r186 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r187 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r187.b(Condition$Tenant.NOT_CROSS_TENANT);
        r186.f(r187.a());
        r180.a(r186.c());
        goto L171
    L170:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r188 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r189 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r189.b(Condition$Tenant.CROSS_TENANT);
        r188.f(r189.a());
        r180.a(r188.c());
        goto L171
    L165:
        r185 = lib.a.b.f509454a[r184.ordinal()];
    L171:
        GroupChatConfig r190 = r182.f424881b;
        if (r190 == null) goto L183;
        Condition$TenantCondition r191 = r190.getTenantCondition();
        if (r191 != null) goto L176;
        int r192 = -1;
    L177:
        if (r192 == 2) goto L181;
        if (r192 != 3) goto L183;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r193 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r194 = new GroupConfig.a();
        r194.b(Condition$Tenant.NOT_CROSS_TENANT);
        r193.d(r194.a());
        r180.a(r193.c());
        goto L183
    L181:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r195 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r196 = new GroupConfig.a();
        r196.b(Condition$Tenant.CROSS_TENANT);
        r195.d(r196.a());
        r180.a(r195.c());
        goto L183
    L176:
        r192 = lib.a.b.f509454a[r191.ordinal()];
    L183:
        if (r182.f424882c != null) goto L186;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r197 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r197.b(new BotConfig());
        r180.a(r197.c());
    L186:
        if (r182.f424883d != null) goto L189;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r198 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r198.e(new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a().a());
        r180.a(r198.c());
    L189:
        if (r182.f424884e != null) goto L159;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r199 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r199.a(new AIConfig());
        r180.a(r199.c());
    L191:
        ForwardTargetConfig.a r200 = new ForwardTargetConfig.a();
        IncludeConfig r201 = r154.b();
        Intrinsics.checkNotNullParameter(r201, "includeConfig");
        r200.f425204d = r201;
        DisableConfig r202 = r180.b();
        Intrinsics.checkNotNullParameter(r202, "disableConfig");
        r200.f425205e = r202;
        ForwardTargetConfig r203 = r200.a();
        ForwardTemplateNew.a r204 = new ForwardTemplateNew.a();
        Intrinsics.checkNotNullParameter(r203, "forwardTargetConfig");
        r204.f425206a = r203;
        r151.c("forward_plugin_crate_group_chat", new ForwardCreateGroupChatPlugin(r204.a(), new y(r100)));
        com.ss.android.lark.forwardv3.plugins.i r205 = r100.f424981n.b("forward_plugin_crate_group_chat");
        if (r205 == null) goto L195;
        r205.b((FragmentActivity) r100.f424951a, r100.f424952b, r149);
    L195:
        r100.mChatPicker.attachTopCustomView(r149);
        goto L196
    L194:
        r149.setOnClickListener(new d(r100));
    L196:
        r100.f424975h.f424787c.a();
        Log.i("NewForward", "disable recent forward");
        int r206 = kib.c.f503668a;
        Statistics.sendEvent("public_multi_select_share_view");
        return;
    L8:
        r100.mTitleBar.setVisibility(0);
        r100.mTitleBar.setMainTitleColor(UIUtils.getColor(r100.f424951a, R.color.text_title));
        String r207 = r100.f424975h.f424789e.f424863b;
        CommonTitleBar r208 = r100.mTitleBar;
        if (TextUtils.isEmpty(r207) == false) goto L11;
        r207 = UIUtils.getString(r100.f424951a, R.string.Lark_Legacy_SelectTip);
    L11:
        r208.setTitle(r207);
        r100.mTitleBar.setLeftClickListener(new a0(r100));
        r100.mTitleBar.setLeftImageResource(CommonTitleBarConstants.ICON_CLOSE);
        r100.mTitleBar.setImmersive(true);
        if (r100.f424978k == false) goto L14;
    L15:
        r100.mTitleBar.addAction(new c0(r100, UIUtils.getString(r100.f424951a, R.string.Lark_Legacy_Select)));
        TextView r209 = r100.mTitleBar.getRightText();
        r100.f424955e = r209;
        r209.setPadding(0, 0, UIUtils.dp2px(r100.f424951a, 15.0f), 0);
        int r210 = DesktopUtil.f420394a;
    L16:
        r100.z6(null);
        goto L17
    L14:
        if (r100.f424984q == false) goto L16;
        goto L15
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        this.mChatPicker.destroy();
    }

    @Override // iib.c
    public final void s7(List<SearchBaseInfo> r100) {
        z6(r100);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f424954d = (iib.c.a) r100;
    }

    @Override // iib.c
    public final void L0(String r100, boolean r101) {
        LKUIToast.show(this.f424951a, r100);
        if (r101 == false) goto L6;
        this.f424951a.finish();
        return;
    }

    public BaseForwardView(FragmentActivity r100, Fragment r101, ForwardPickFragment.a r102) {
        this.f424956f = 0;
        this.f424957g = new a(this);
        this.f424951a = r100;
        this.f424952b = r101;
        this.f424953c = r102;
    }

    @Override // iib.c
    public final void e6(String r100, String r101, boolean r102) {
        com.larksuite.component.ui.dialog.d r103 = new com.larksuite.component.ui.dialog.d(this.f424951a);
        r103.f284132c.cancelable(true);
        r103.f284132c.cancelOnTouchOutside(false);
        b r104 = new b(this, r102);
        r103.f284132c.onDismissListener(r104);
        r103.k(r100);
        r103.h(r101);
        r103.a(R.id.lkui_dialog_btn_right, R.string.View_G_OkButton, null);
        r103.i();
    }
}
