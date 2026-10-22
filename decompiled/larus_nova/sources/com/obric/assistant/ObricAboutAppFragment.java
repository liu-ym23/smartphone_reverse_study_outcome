package com.obric.assistant;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ChatSettingScrollView;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.base.databinding.PageSettingAboutObricPageBinding;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001c\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J+\u0010\u001f\u001a\u00020\u00142!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00140!H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\nH\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000f\u0010*\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006/"}, d2 = {"Lcom/obric/assistant/ObricAboutAppFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "binding", "Lcom/obric/assistant/base/databinding/PageSettingAboutObricPageBinding;", "isManualCheckingUpdate", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "getCurrentPageName", "autoLogEnterPage", "onViewCreated", "view", "setupEcommerce", "setupLocalLife", "obricUpdateListener", "com/obric/assistant/ObricAboutAppFragment$obricUpdateListener$1", "Lcom/obric/assistant/ObricAboutAppFragment$obricUpdateListener$1;", "setupWithdrawPrivacyAgreement", "handleWithdrawPrivacyAgreementClick", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "userConfirmWithdraw", "setupCheckUpdate", "clickCheckAppUpdate", "toastDownloading", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setupModelDetail", "()Lkotlin/Unit;", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "enterSystemPermissionSetting", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAboutAppFragment extends TraceFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f385123i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f385124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PageSettingAboutObricPageBinding f385125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f385126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ObricAboutAppFragment$obricUpdateListener$1 f385127h;

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "about_app";
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.ObricAboutAppFragment$obricUpdateListener$1] */
    public ObricAboutAppFragment() {
        this.f385124e = "ObricAboutAppFragment";
        this.f385127h = new ObricAboutAppFragment$obricUpdateListener$1(this);
    }

    public final boolean U90() {
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L11;
        FLogger.f375446a.i(this.f385124e, "CheckAppUpdate, net not available");
        t19.s r100 = t19.s.f544207a;
        Context r101 = getContext();
        Context r102 = getContext();
        if (r102 == null) goto L8;
        String r103 = r102.getString(R.string.larus_network_error);
        if (r103 == null) goto L8;
    L9:
        r100.getClass();
        t19.s.k(r101, R.drawable.obric_ic_update_toast, r103, 1000);
        return false;
    L8:
        r103 = "";
        goto L9
    L11:
        IObricUpdateService r104 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r104 == null) goto L34;
        int r105 = r104.l();
        if (r105 == (-1)) goto L16;
        int r106 = 1;
    L17:
        IObricUpdateService r107 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r107 == null) goto L21;
        JSONObject r108 = new JSONObject();
        r108.put("has_upgrade_package", r106);
        Unit r109 = Unit.INSTANCE;
        r107.h("obric_upgrade_manual_check", r108);
    L21:
        if (r105 != 2) goto L33;
        IObricBannerService r110 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r110 == null) goto L25;
        r110.a();
    L25:
        Context r111 = getContext();
        if (r111 != null) goto L29;
    L32:
        return false;
    L29:
        if (NetworkUtils.isWifi(r111) == false) goto L31;
        t19.s r112 = t19.s.f544207a;
        String r113 = AppHost.f326268a.getApplication().getString(R.string.obric_update_using_wifi_toast);
        r112.getClass();
        t19.s.k(r111, R.drawable.obric_ic_update_toast, r113, 1000);
        goto L32
    L31:
        t19.s r114 = t19.s.f544207a;
        String r115 = AppHost.f326268a.getApplication().getString(R.string.obric_update_using_mobile_toast);
        r114.getClass();
        t19.s.k(r111, R.drawable.obric_ic_update_toast, r115, 1000);
        goto L32
    L33:
        r104.f(this.f385127h);
        r104.d(false, "obric_about_app");
        goto L34
    L16:
        r106 = 0;
    L34:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        IObricUpdateService r100 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r100 == null) goto L5;
        r100.i(this.f385127h);
    L5:
        this.f385125f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        PageSettingAboutObricPageBinding r112 = this.f385125f;
        Boolean r113 = null;
        if (r112 == null) goto L5;
        NovaTitleBarEx r100 = r112.G;
        NovaTitleBarEx.Y5(r100, getString(R.string.larus_settings_about_app, new Object[]{getString(R.string.app_name_replace)}), null, null, 6);
        NovaTitleBarEx.b6(r100, R.drawable.larus_ic_left_back, false, null, null, new e0(this), 14);
    L5:
        PageSettingAboutObricPageBinding r114 = this.f385125f;
        if (r114 != null) goto L8;
    L29:
        PageSettingAboutObricPageBinding r115 = this.f385125f;
        if (r115 == null) goto L166;
        r115.I.setOnClickListener(new p(this));
        r115.C.setVisibility(8);
        r115.B.setOnClickListener(new k0(this));
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.isOversea() == false) goto L34;
        r115.E.setVisibility(8);
    L36:
        if (r101.isOversea() == false) goto L72;
        PageSettingAboutObricPageBinding r102 = this.f385125f;
        if (r102 == null) goto L42;
        ItemTextArrow r103 = r102.f385894q;
        if (r103 == null) goto L42;
        com.larus.utils.e1.o(r103);
    L42:
        PageSettingAboutObricPageBinding r104 = this.f385125f;
        if (r104 == null) goto L47;
        ItemTextArrow r105 = r104.f385887j;
        if (r105 == null) goto L47;
        com.larus.utils.e1.o(r105);
    L47:
        PageSettingAboutObricPageBinding r106 = this.f385125f;
        if (r106 == null) goto L52;
        ItemTextArrow r107 = r106.f385885h;
        if (r107 == null) goto L52;
        com.larus.utils.e1.o(r107);
    L52:
        PageSettingAboutObricPageBinding r108 = this.f385125f;
        if (r108 == null) goto L57;
        ItemTextArrow r109 = r108.f385886i;
        if (r109 == null) goto L57;
        com.larus.utils.e1.o(r109);
    L57:
        PageSettingAboutObricPageBinding r116 = this.f385125f;
        if (r116 == null) goto L62;
        ItemTextArrow r117 = r116.f385883f;
        if (r117 == null) goto L62;
        com.larus.utils.e1.o(r117);
    L62:
        PageSettingAboutObricPageBinding r118 = this.f385125f;
        if (r118 == null) goto L67;
        ItemTextArrow r119 = r118.D;
        if (r119 == null) goto L67;
        com.larus.utils.e1.o(r119);
    L67:
        PageSettingAboutObricPageBinding r120 = this.f385125f;
        if (r120 == null) goto L156;
        TextView r121 = r120.f385889l;
        if (r121 == null) goto L156;
        com.larus.utils.e1.o(r121);
    L156:
        r115.E.setOnClickListener(new r(this));
        r115.f385888k.setOnClickListener(new s(this));
        r115.H.setOnClickListener(new a0(this));
        if (r101.isOversea() == false) goto L159;
        r115.f385884g.setBackgroundResource(R.drawable.larus_bg_item_selector_last);
    L159:
        r115.f385884g.setOnClickListener(new i0(this));
        if (r101.isOversea() == false) goto L162;
        r115.f385880c.setVisibility(8);
    L164:
        if (r101.isOversea() == false) goto L166;
        r115.f385893p.setVisibility(8);
        goto L166
    L162:
        r115.f385880c.setText(getString(R.string.larus_settings_about_app, new Object[]{getString(R.string.larus_skylark_text)}));
        r115.f385880c.setOnClickListener(new j0(this));
        goto L164
    L72:
        PageSettingAboutObricPageBinding r122 = this.f385125f;
        if (r122 == null) goto L77;
        ItemTextArrow r123 = r122.H;
        if (r123 == null) goto L77;
        com.larus.utils.e1.o(r123);
    L77:
        PageSettingAboutObricPageBinding r124 = this.f385125f;
        if (r124 == null) goto L82;
        ItemTextArrow r125 = r124.f385894q;
        if (r125 == null) goto L82;
        com.larus.utils.e1.x(r125);
    L82:
        PageSettingAboutObricPageBinding r126 = this.f385125f;
        if (r126 == null) goto L87;
        ItemTextArrow r127 = r126.f385887j;
        if (r127 == null) goto L87;
        com.larus.utils.e1.x(r127);
    L87:
        PageSettingAboutObricPageBinding r128 = this.f385125f;
        if (r128 == null) goto L92;
        ItemTextArrow r129 = r128.f385885h;
        if (r129 == null) goto L92;
        com.larus.utils.e1.x(r129);
    L92:
        PageSettingAboutObricPageBinding r130 = this.f385125f;
        if (r130 == null) goto L97;
        ItemTextArrow r131 = r130.f385886i;
        if (r131 == null) goto L97;
        com.larus.utils.e1.x(r131);
    L97:
        PageSettingAboutObricPageBinding r132 = this.f385125f;
        if (r132 == null) goto L102;
        ItemTextArrow r133 = r132.f385883f;
        if (r133 == null) goto L102;
        com.larus.utils.e1.x(r133);
    L102:
        PageSettingAboutObricPageBinding r134 = this.f385125f;
        if (r134 == null) goto L107;
        ItemTextArrow r135 = r134.D;
        if (r135 == null) goto L107;
        com.larus.utils.e1.x(r135);
    L107:
        PageSettingAboutObricPageBinding r136 = this.f385125f;
        if (r136 == null) goto L112;
        TextView r137 = r136.f385889l;
        if (r137 == null) goto L112;
        com.larus.utils.e1.x(r137);
    L112:
        PageSettingAboutObricPageBinding r138 = this.f385125f;
        if (r138 == null) goto L117;
        ItemTextArrow r139 = r138.f385894q;
        if (r139 == null) goto L117;
        com.larus.utils.e1.d(r139, new l0(this));
    L117:
        PageSettingAboutObricPageBinding r140 = this.f385125f;
        if (r140 == null) goto L122;
        ItemTextArrow r141 = r140.f385887j;
        if (r141 == null) goto L122;
        com.larus.utils.e1.d(r141, new m0(this));
    L122:
        e10 r142 = e10.f368561a;
        Boolean r143 = e10.r().b();
        Boolean r144 = Boolean.TRUE;
        if (Intrinsics.areEqual(r143, r144) == false) goto L129;
        PageSettingAboutObricPageBinding r145 = this.f385125f;
        if (r145 == null) goto L137;
        ItemTextArrow r146 = r145.f385885h;
        if (r146 == null) goto L137;
        com.larus.utils.e1.d(r146, new n0(this));
    L137:
        if (Intrinsics.areEqual(e10.r().a(), r144) == false) goto L143;
        PageSettingAboutObricPageBinding r147 = this.f385125f;
        if (r147 == null) goto L150;
        ItemTextArrow r148 = r147.f385886i;
        if (r148 == null) goto L150;
        com.larus.utils.e1.d(r148, new o0(this));
    L150:
        PageSettingAboutObricPageBinding r149 = this.f385125f;
        if (r149 == null) goto L155;
        ItemTextArrow r150 = r149.f385883f;
        if (r150 == null) goto L155;
        com.larus.utils.e1.d(r150, new p0(this));
    L155:
        r115.D.setOnClickListener(new q(this));
        goto L156
    L143:
        PageSettingAboutObricPageBinding r151 = this.f385125f;
        if (r151 == null) goto L150;
        ItemTextArrow r152 = r151.f385886i;
        if (r152 == null) goto L150;
        ImageView r153 = r152.getArrowView();
        if (r153 == null) goto L150;
        com.larus.utils.e1.o(r153);
        goto L150
    L129:
        PageSettingAboutObricPageBinding r154 = this.f385125f;
        if (r154 == null) goto L137;
        ItemTextArrow r155 = r154.f385885h;
        if (r155 == null) goto L137;
        ImageView r156 = r155.getArrowView();
        if (r156 == null) goto L137;
        com.larus.utils.e1.o(r156);
        goto L137
    L34:
        r115.f385884g.setVisibility(8);
    L166:
        final PageSettingAboutObricPageBinding r157 = this.f385125f;
        if (r157 == null) goto L169;
        r157.f385879b.setVisibility(0);
        r157.f385879b.setText(getString(R.string.larus_settings_checkupdates));
        com.larus.utils.e1.a(r157.f385879b, 2000, new u(r157, this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricAboutAppFragment$setupCheckUpdate$1$2(this, r157, null), 2, null);
    L169:
        PageSettingAboutObricPageBinding r158 = this.f385125f;
        if (r158 == null) goto L176;
        ItemTextToggle r159 = r158.f385881d;
        if (r159 == null) goto L176;
        CustomSwitchCompat r160 = r159.getToggleView();
        if (r160 == null) goto L176;
        r160.setChecked(ObricUpdateSettingDelegate.f404037a.a());
    L176:
        PageSettingAboutObricPageBinding r161 = this.f385125f;
        if (r161 == null) goto L183;
        ItemTextToggle r162 = r161.f385881d;
        if (r162 == null) goto L183;
        CustomSwitchCompat r163 = r162.getToggleView();
        if (r163 == null) goto L183;
        r163.setOnCheckedChangeListener(new v(this));
    L183:
        Bundle r164 = getArguments();
        if (r164 == null) goto L187;
        r113 = Boolean.valueOf(r164.getBoolean("obric_auto_check_update", false));
    L187:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L193;
        PageSettingAboutObricPageBinding r165 = this.f385125f;
        if (r165 == null) goto L193;
        ItemTextArrow r166 = r165.f385879b;
        if (r166 == null) goto L193;
        r166.postDelayed(new w(this), 500);
    L193:
        PageSettingAboutObricPageBinding r167 = this.f385125f;
        if (r167 == null) goto L196;
        r167.f385882e.setVisibility(0);
        r167.f385882e.setText(getString(R.string.withdraw_privacy_agreement));
        com.larus.utils.e1.b(r167.f385882e, new t(this));
    L196:
        AppHost.Companion r168 = AppHost.f326268a;
        if (r168.isOversea() == false) goto L208;
        PageSettingAboutObricPageBinding r169 = this.f385125f;
        if (r169 == null) goto L203;
        LinearLayout r170 = r169.f385890m;
        if (r170 == null) goto L203;
        com.larus.utils.e1.o(r170);
    L203:
        PageSettingAboutObricPageBinding r171 = this.f385125f;
        if (r171 == null) goto L239;
        LinearLayout r172 = r171.f385903z;
        if (r172 == null) goto L239;
        com.larus.utils.e1.o(r172);
    L239:
        if (r168.isOversea() == false) goto L245;
        PageSettingAboutObricPageBinding r173 = this.f385125f;
        if (r173 == null) goto L275;
        LinearLayout r174 = r173.f385896s;
        if (r174 == null) goto L275;
        com.larus.utils.e1.o(r174);
    L275:
        PageSettingAboutObricPageBinding r175 = this.f385125f;
        if (r175 == null) goto L281;
        ItemGroup r176 = r175.f385895r;
        if (r176 == null) goto L282;
        r176.c();
        return;
    L282:
        return;
    L281:
        return;
    L245:
        PageSettingAboutObricPageBinding r177 = this.f385125f;
        if (r177 == null) goto L250;
        LinearLayout r178 = r177.f385896s;
        if (r178 == null) goto L250;
        com.larus.utils.e1.x(r178);
    L250:
        PageSettingAboutObricPageBinding r179 = this.f385125f;
        if (r179 == null) goto L255;
        ItemTextArrow r180 = r179.f385899v;
        if (r180 == null) goto L255;
        com.larus.utils.e1.d(r180, new z(this));
    L255:
        PageSettingAboutObricPageBinding r181 = this.f385125f;
        if (r181 == null) goto L260;
        ItemTextArrow r182 = r181.f385901x;
        if (r182 == null) goto L260;
        com.larus.utils.e1.d(r182, new b0(this));
    L260:
        PageSettingAboutObricPageBinding r183 = this.f385125f;
        if (r183 == null) goto L265;
        ItemTextArrow r184 = r183.f385898u;
        if (r184 == null) goto L265;
        com.larus.utils.e1.d(r184, new c0(this));
    L265:
        PageSettingAboutObricPageBinding r185 = this.f385125f;
        if (r185 == null) goto L270;
        ItemTextArrow r186 = r185.f385900w;
        if (r186 == null) goto L270;
        com.larus.utils.e1.d(r186, new d0(this));
    L270:
        PageSettingAboutObricPageBinding r187 = this.f385125f;
        if (r187 == null) goto L275;
        ItemGroup r188 = r187.f385897t;
        if (r188 == null) goto L275;
        r188.c();
        goto L275
    L208:
        PageSettingAboutObricPageBinding r189 = this.f385125f;
        if (r189 == null) goto L213;
        LinearLayout r190 = r189.f385890m;
        if (r190 == null) goto L213;
        com.larus.utils.e1.x(r190);
    L213:
        PageSettingAboutObricPageBinding r191 = this.f385125f;
        if (r191 == null) goto L218;
        LinearLayout r192 = r191.f385903z;
        if (r192 == null) goto L218;
        com.larus.utils.e1.x(r192);
    L218:
        PageSettingAboutObricPageBinding r193 = this.f385125f;
        if (r193 == null) goto L223;
        ItemTextArrow r194 = r193.f385892o;
        if (r194 == null) goto L223;
        com.larus.utils.e1.d(r194, new x(this));
    L223:
        PageSettingAboutObricPageBinding r195 = this.f385125f;
        if (r195 == null) goto L228;
        ItemTextArrow r196 = r195.F;
        if (r196 == null) goto L228;
        com.larus.utils.e1.d(r196, new y(this));
    L228:
        PageSettingAboutObricPageBinding r197 = this.f385125f;
        if (r197 == null) goto L233;
        ItemGroup r198 = r197.f385891n;
        if (r198 == null) goto L233;
        r198.c();
    L233:
        PageSettingAboutObricPageBinding r199 = this.f385125f;
        if (r199 == null) goto L239;
        ItemGroup r1100 = r199.A;
        if (r1100 == null) goto L239;
        r1100.c();
        goto L239
    L8:
        if (AppHost.f326268a.isOversea() == false) goto L10;
        com.larus.utils.e1.o(r114.f385902y);
    L28:
        Unit r1101 = Unit.INSTANCE;
        goto L29
    L10:
        String r200 = t9a.b.a().d();
        int r201 = r200.hashCode();
        if (r201 == (-1048984789)) goto L24;
        if (r201 == (-807117175)) goto L21;
        if (r201 == 1328894480) goto L18;
    L25:
        int r202 = R.string.obric_settings_bottom_model_names_cn_genesis_r;
    L27:
        com.larus.utils.e1.x(r114.f385902y);
        r114.f385902y.setText(r202);
        goto L28
    L18:
        if (r200.equals("nerida-lite") == false) goto L25;
    L26:
        r202 = R.string.obric_settings_bottom_model_names_cn;
        goto L27
    L21:
        if (r200.equals("pacific") == false) goto L25;
    L24:
        if (r200.equals("nerida") == true) goto L26;
        goto L25
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r410, ViewGroup r411, Bundle r412) {
        Intrinsics.checkNotNullParameter(r410, "inflater");
        View r100 = r410.inflate(R.layout.page_setting_about_obric_page, r411, false);
        int r101 = R.id.about_check_app_update;
        ItemTextArrow r102 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.about_check_app_update);
        if (r102 == null) goto L85;
        r101 = R.id.about_sky_luck;
        ItemTextArrow r103 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.about_sky_luck);
        if (r103 == null) goto L85;
        r101 = R.id.about_stop_app_service;
        if (((ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.about_stop_app_service)) == null) goto L85;
        r101 = R.id.about_wifi_auto_download;
        ItemTextToggle r104 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.about_wifi_auto_download);
        if (r104 == null) goto L85;
        r101 = R.id.about_withdraw_privacy_agreement;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.about_withdraw_privacy_agreement);
        if (r105 == null) goto L85;
        r101 = R.id.app_permissions_in_setting;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.app_permissions_in_setting);
        if (r106 == null) goto L85;
        r101 = R.id.bug_submission;
        ItemTextArrow r110 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.bug_submission);
        if (r110 == null) goto L85;
        r101 = R.id.business_ipc_oco;
        ItemTextArrow r111 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.business_ipc_oco);
        if (r111 == null) goto L85;
        r101 = R.id.business_ipc_operate;
        ItemTextArrow r112 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.business_ipc_operate);
        if (r112 == null) goto L85;
        r101 = R.id.business_license;
        ItemTextArrow r113 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.business_license);
        if (r113 == null) goto L85;
        r101 = R.id.community_guidelines;
        ItemTextArrow r114 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.community_guidelines);
        if (r114 == null) goto L85;
        r101 = R.id.default_group;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.default_group)) == null) goto L85;
        r101 = R.id.default_group_header;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.default_group_header);
        if (r115 == null) goto L85;
        r101 = R.id.ecommerce_group;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.ecommerce_group);
        if (r116 == null) goto L85;
        r101 = R.id.ecommerce_group_header;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.ecommerce_group_header)) == null) goto L85;
        r101 = R.id.ecommerce_item_group;
        ItemGroup r117 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.ecommerce_item_group);
        if (r117 == null) goto L85;
        r101 = R.id.ecommerce_qualification_rules;
        ItemTextArrow r118 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.ecommerce_qualification_rules);
        if (r118 == null) goto L85;
        r101 = R.id.hotline;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r100, R.id.hotline);
        if (r119 == null) goto L85;
        r101 = R.id.icp_record;
        ItemTextArrow r210 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.icp_record);
        if (r210 == null) goto L85;
        r101 = R.id.item_group;
        ItemGroup r211 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.item_group);
        if (r211 == null) goto L85;
        r101 = R.id.local_life_group;
        LinearLayout r212 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.local_life_group);
        if (r212 == null) goto L85;
        r101 = R.id.local_life_group_header;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.local_life_group_header)) == null) goto L85;
        r101 = R.id.local_life_item_group;
        ItemGroup r213 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.local_life_item_group);
        if (r213 == null) goto L85;
        r101 = R.id.local_life_privacy_agreement;
        ItemTextArrow r214 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.local_life_privacy_agreement);
        if (r214 == null) goto L85;
        r101 = R.id.local_life_qualification_rules;
        ItemTextArrow r215 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.local_life_qualification_rules);
        if (r215 == null) goto L85;
        r101 = R.id.local_life_rule_center;
        ItemTextArrow r216 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.local_life_rule_center);
        if (r216 == null) goto L85;
        r101 = R.id.local_life_user_agreement;
        ItemTextArrow r217 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.local_life_user_agreement);
        if (r217 == null) goto L85;
        r101 = R.id.model_detail;
        TextView r218 = (TextView) ViewBindings.findChildViewById(r100, R.id.model_detail);
        if (r218 == null) goto L85;
        r101 = R.id.other_group;
        LinearLayout r219 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.other_group);
        if (r219 == null) goto L85;
        r101 = R.id.other_group_header;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.other_group_header)) == null) goto L85;
        r101 = R.id.other_item_group;
        ItemGroup r310 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.other_item_group);
        if (r310 == null) goto L85;
        r101 = R.id.privacy_policy;
        ItemTextArrow r311 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.privacy_policy);
        if (r311 == null) goto L85;
        r101 = R.id.privacy_policy_abs;
        ItemTextArrow r312 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.privacy_policy_abs);
        if (r312 == null) goto L85;
        r101 = R.id.protect_guideline;
        ItemTextArrow r313 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.protect_guideline);
        if (r313 == null) goto L85;
        r101 = R.id.scroll_view;
        if (((ChatSettingScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view)) == null) goto L85;
        r101 = R.id.sensitive_permissions;
        ItemTextArrow r314 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.sensitive_permissions);
        if (r314 == null) goto L85;
        r101 = R.id.shopping_payment_faq;
        ItemTextArrow r315 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.shopping_payment_faq);
        if (r315 == null) goto L85;
        r101 = R.id.title;
        NovaTitleBarEx r316 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r316 == null) goto L85;
        r101 = R.id.trust_center;
        ItemTextArrow r317 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.trust_center);
        if (r317 == null) goto L85;
        r101 = R.id.user_agreement;
        ItemTextArrow r318 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.user_agreement);
        if (r318 == null) goto L85;
        LinearLayout r107 = (LinearLayout) r100;
        this.f385125f = new PageSettingAboutObricPageBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318);
        return r107;
    L85:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
