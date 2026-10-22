package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PluginService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.util.TimeoutManager;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import h16.e;
import ia.c;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m16.b;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/annie_container/view/CJBankTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "Landroid/net/Uri;", "getSchema", "", "getLayoutId", "schema", "", "setPopUpStyle", "setFullPageStyle", "Lkotlin/Function0;", "action", "setCloseAction", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class CJBankTitleBar extends FrameLayout implements ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f202451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f202452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f202453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f202454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f202455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f202456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f202457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Uri f202458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f202459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f202460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f202461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f202462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<kd4.b, Unit> f202463m;

    public static final class a {
    }

    static {
    }

    private final int getLayoutId() {
        return R.layout.cj_pay_bank_titlebar_layout;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "CJBankTitleBar";
    }

    private final Uri getSchema() {
        Uri r100 = this.f202458h;
        if (r100 != null) goto L20;
        b r101 = this.f202460j;
        if (r101 == null) goto L11;
        BulletContext r102 = (BulletContext) r101.c(BulletContext.class);
        if (r102 == null) goto L11;
        d r103 = r102.f246437e;
        if (r103 == null) goto L11;
        Uri r104 = r103.getOriginUrl();
    L12:
        if (r104 != null) goto L21;
        b r105 = this.f202460j;
        if (r105 == null) goto L19;
        kb.a r106 = (kb.a) r105.c(kb.a.class);
        if (r106 == null) goto L19;
        return r106.f502200a;
    L19:
        return null;
    L21:
        return r104;
    L11:
        r104 = null;
        goto L12
    L20:
        return r100;
    }

    public final void c() {
        View r100 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        RelativeLayout r101 = null;
        if (r100 == null) goto L5;
        RelativeLayout r102 = (RelativeLayout) r100.findViewById(R.id.cj_pay_titlebar_layout);
    L6:
        this.f202451a = r102;
        if (r100 == null) goto L9;
        ImageView r103 = (ImageView) r100.findViewById(R.id.cj_pay_back_view);
    L10:
        this.f202452b = r103;
        if (r100 == null) goto L13;
        ImageView r104 = (ImageView) r100.findViewById(R.id.cj_pay_brand_icon);
    L14:
        this.f202453c = r104;
        if (r100 == null) goto L17;
        TextView r105 = (TextView) r100.findViewById(R.id.cj_pay_title_view);
    L18:
        this.f202454d = r105;
        if (r100 == null) goto L21;
        TextView r106 = (TextView) r100.findViewById(R.id.cj_pay_h5_subtitle);
    L22:
        this.f202455e = r106;
        if (r100 == null) goto L25;
        ImageView r107 = (ImageView) r100.findViewById(R.id.cj_pay_right_view);
    L25:
        if (r100 == null) goto L27;
        LinearLayout r108 = (LinearLayout) r100.findViewById(R.id.cj_pay_title_content_layout);
    L28:
        this.f202456f = r108;
        if (r100 == null) goto L31;
        r101 = (RelativeLayout) r100.findViewById(R.id.cj_pay_title_bar);
    L31:
        this.f202457g = r101;
        return;
    L27:
        r108 = null;
        goto L28
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public CJBankTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f202461k = "";
        this.f202462l = new CJBankTitleBar$closeAction$1(this);
        this.f202463m = new CJBankTitleBar$eventSubscriber$1(this);
        c();
    }

    public static final void a(CJBankTitleBar r100) {
        Uri r101 = r100.getSchema();
        h16.d r102 = null;
        if (r101 == null) goto L5;
        String r103 = UriProtector.getQueryParameter(r101, "cj_session_id");
    L7:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        cf4.a.f23507a.a("cjpay_event_fe2native", r100.f202463m);
        Lazy<Map<Integer, Map<String, TimeoutManager>>> r104 = TimeoutManager.f202430l;
        Map r105 = (Map) TimeoutManager.a.a().get(0);
        if (r105 == null) goto L17;
        TimeoutManager r106 = (TimeoutManager) r105.get(r103);
        if (r106 == null) goto L17;
        TimeoutManager.b r107 = r106.f202432b;
        if (r107 == null) goto L16;
        r107.cancel();
    L16:
        r106.f202432b = null;
        r106.f202433c = false;
        r106.f202434d = 0;
        r106.f202440j = false;
        r106.f202438h = null;
        r106.f202437g = "";
    L17:
        Map r108 = (Map) TimeoutManager.a.a().get(0);
        if (r108 == null) goto L20;
        TimeoutManager r109 = (TimeoutManager) r108.remove(r103);
    L20:
        Map r110 = (Map) TimeoutManager.a.a().get(1);
        if (r110 == null) goto L28;
        TimeoutManager r111 = (TimeoutManager) r110.get(r103);
        if (r111 == null) goto L28;
        TimeoutManager.b r112 = r111.f202432b;
        if (r112 == null) goto L27;
        r112.cancel();
    L27:
        r111.f202432b = null;
        r111.f202433c = false;
        r111.f202434d = 0;
        r111.f202440j = false;
        r111.f202438h = null;
        r111.f202437g = "";
    L28:
        Map r113 = (Map) TimeoutManager.a.a().get(1);
        if (r113 == null) goto L31;
        TimeoutManager r114 = (TimeoutManager) r113.remove(r103);
    L31:
        b r115 = r100.f202460j;
        if (r115 == null) goto L36;
        e r116 = (e) r115.c(e.class);
        if (r116 == null) goto L36;
        r102 = r116.getActivityWrapper();
    L36:
        if (r102 == null) goto L38;
        r102.finish();
        return;
    L38:
        c r117 = r100.f202459i;
        if (r117 == null) goto L41;
        r117.close();
        return;
    L41:
        r100.f202462l.invoke();
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static final /* synthetic */ Uri b(CJBankTitleBar r100) {
        return r100.getSchema();
    }

    public static boolean g(Uri r100) {
        if (r100 == null) goto L4;
        String r101 = UriProtector.getQueryParameter(r100, "bank_title_style");
    L6:
        return Intrinsics.areEqual(r101, "1");
    L4:
        r101 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    public final void setCloseAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f202462l = r100;
    }

    public final void setFullPageStyle(Uri r100) {
        ImageView r101 = this.f202452b;
        if (r101 == null) goto L6;
        r101.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_icon_titlebar_left_arrow));
    L6:
        if (g(r100) == false) goto L13;
        ImageView r102 = this.f202452b;
        if (r102 == null) goto L10;
        r102.setBackgroundColor(ColorProtector.parseColor("#ffffff"));
    L10:
        RelativeLayout r103 = this.f202451a;
        if (r103 == null) goto L17;
        r103.setBackgroundColor(ColorProtector.parseColor("#ffffff"));
    L17:
        if (r100 == null) goto L47;
        String r104 = UriProtector.getQueryParameter(r100, AppConstants.TRANS_STATUS_BAR);
        if (r104 == null) goto L48;
        ViewGroup.LayoutParams r105 = null;
        if (Intrinsics.areEqual("1", r104) == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L49;
        ve4.a.f554342a.getClass();
        PluginService r106 = (PluginService) ve4.a.a(PluginService.class);
        if (r106 == null) goto L28;
        int r107 = r106.getStatusBarHeight(getContext());
    L29:
        RelativeLayout r108 = this.f202451a;
        if (r108 == null) goto L32;
        r105 = r108.getLayoutParams();
    L32:
        if (r105 != null) goto L35;
    L39:
        RelativeLayout r109 = this.f202451a;
        if (r109 == null) goto L43;
        r109.setLayoutParams(r105);
    L43:
        RelativeLayout r110 = this.f202457g;
        if (r110 == null) goto L50;
        CJPayViewExtensionsKt.setTopMargin(r110, r107);
        return;
    L50:
        return;
    L35:
        if (g(r100) == false) goto L37;
        int r111 = 44;
    L38:
        r105.height = CJPayBasicExtensionKt.dp(r111) + r107;
        goto L39
    L37:
        r111 = 80;
        goto L38
    L28:
        r107 = 0;
        goto L29
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L13:
        RelativeLayout r112 = this.f202451a;
        if (r112 == null) goto L17;
        r112.setBackground(getContext().getDrawable(R.drawable.cj_pay_bind_card_safe_light_bg));
        goto L17
    }

    public final void setPopUpStyle(Uri r100) {
        ImageView r101 = this.f202452b;
        if (r101 == null) goto L6;
        r101.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_icon_x_close));
    L6:
        if (g(r100) == false) goto L11;
        RelativeLayout r102 = this.f202451a;
        if (r102 == null) goto L15;
        r102.setBackground(getContext().getDrawable(R.drawable.cj_pay_bind_card_light_bg_half_page));
    L15:
        RelativeLayout r103 = this.f202451a;
        if (r103 == null) goto L18;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L19:
        if (r104 != null) goto L22;
    L26:
        RelativeLayout r105 = this.f202451a;
        if (r105 == null) goto L30;
        r105.setLayoutParams(r104);
    L30:
        RelativeLayout r106 = this.f202451a;
        if (r106 == null) goto L34;
        r106.setPadding(0, 0, 0, 0);
        return;
    L34:
        return;
    L22:
        if (g(r100) == false) goto L24;
        int r107 = 44;
    L25:
        r104.height = CJPayBasicExtensionKt.dp(r107);
        goto L26
    L24:
        r107 = 80;
        goto L25
    L18:
        r104 = null;
        goto L19
    L11:
        RelativeLayout r108 = this.f202451a;
        if (r108 == null) goto L15;
        r108.setBackground(getContext().getDrawable(R.drawable.cj_pay_bind_card_safe_light_bg_half_page));
        goto L15
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public CJBankTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f202461k = "";
        this.f202462l = new CJBankTitleBar$closeAction$1(this);
        this.f202463m = new CJBankTitleBar$eventSubscriber$1(this);
        c();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public final void f(Uri r110, c r111, b r112) {
        this.f202458h = r110;
        this.f202459i = r111;
        this.f202460j = r112;
        Uri r113 = getSchema();
        String r114 = null;
        if (r113 == null) goto L7;
        String r115 = UriProtector.getQueryParameter(r113, "bank_name");
        if (r115 == null) goto L7;
        String r116 = URLDecoder.decode(r115, "UTF-8");
    L8:
        if (r116 != null) goto L10;
        r116 = "银行";
    L10:
        this.f202461k = r116;
        Uri r117 = getSchema();
        if (r117 == null) goto L13;
        UriProtector.getQueryParameter(r117, "back_hook_action");
    L13:
        Uri r118 = getSchema();
        if (r118 == null) goto L17;
        UriProtector.getQueryParameter(r118, "open_page_container_id");
    L17:
        if (g(getSchema()) == false) goto L62;
        TextView r119 = this.f202454d;
        if (r119 == null) goto L32;
        Uri r100 = getSchema();
        if (r100 == null) goto L30;
        String r101 = UriProtector.getQueryParameter(r100, "bank_title_text");
        if (r101 == null) goto L30;
        if (StringsKt.isBlank(r101) == false) goto L28;
        r101 = this.f202461k + "官方验证";
    L28:
        if (r101 == null) goto L30;
    L31:
        r119.setText(r101);
    L30:
        r101 = this.f202461k + "官方验证";
    L32:
        TextView r120 = this.f202454d;
        if (r120 == null) goto L35;
        r120.setTextSize(1, 16.0f);
    L35:
        TextView r121 = this.f202454d;
        if (r121 == null) goto L38;
        r121.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r121.getPaint().setStrokeWidth(0.5f);
    L38:
        ImageView r122 = this.f202453c;
        if (r122 == null) goto L41;
        r122.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_bank_titlebar_safe_icon));
    L41:
        Uri r123 = getSchema();
        if (r123 == null) goto L48;
        String r124 = UriProtector.getQueryParameter(r123, "bank_title_icon");
        if (r124 == null) goto L48;
        ve4.a.f554342a.getClass();
        PlugInContainerService r102 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        if (r102 == null) goto L48;
        r102.loadImage(r124, new CJBankTitleBar$initView$2$1(this));
    L48:
        ImageView r125 = this.f202453c;
        if (r125 == null) goto L51;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
    L52:
        if (r126 == null) goto L55;
        r126.width = CJPayBasicExtensionKt.dp(20);
    L55:
        if (r126 == null) goto L58;
        r126.height = CJPayBasicExtensionKt.dp(20);
    L58:
        ImageView r103 = this.f202453c;
        if (r103 == null) goto L98;
        r103.setLayoutParams(r126);
    L98:
        cf4.a.f23507a.b("cjpay_event_fe2native", this.f202463m);
        ImageView r127 = this.f202452b;
        if (r127 == null) goto L101;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r127, new CJBankTitleBar$initAction$1(this));
    L101:
        int r104 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r105 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ImageView r106 = this.f202452b;
        if (r106 == null) goto L104;
        r106.measure(r104, r105);
    L104:
        ImageView r107 = this.f202452b;
        if (r107 == null) goto L107;
        int r108 = r107.getMeasuredWidth();
    L108:
        ImageView r109 = this.f202452b;
        if (r109 == null) goto L111;
        ViewGroup.LayoutParams r128 = r109.getLayoutParams();
    L113:
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L115;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L116:
        if (r129 == null) goto L118;
        int r130 = r129.leftMargin;
    L119:
        if (r108 <= 0) goto L124;
        if (r130 <= 0) goto L124;
        int r131 = r108 + r130;
        LinearLayout r132 = this.f202456f;
        if (r132 == null) goto L124;
        CJPayViewExtensionsKt.setMargins(r132, r131, 0, r131, 0);
    L124:
        Uri r133 = getSchema();
        if (r133 == null) goto L127;
        String r134 = UriProtector.getQueryParameter(r133, "cj_session_id");
    L128:
        if (r134 != null) goto L131;
        r134 = "";
    L131:
        if (StringsKt.isBlank(r134) == false) goto L133;
        ICJTag.DefaultImpls.i(this, "schemaSessionId is blank, skip initTimeoutManager");
        return;
    L133:
        Uri r135 = getSchema();
        if (r135 == null) goto L136;
        String r136 = UriProtector.getQueryParameter(r135, "bankh5_backpress_timeout_mode");
    L137:
        if (r136 != null) goto L139;
    L149:
        int r137 = 0;
    L150:
        if (r137 == 0) goto L161;
        Uri r138 = getSchema();
        if (r138 == null) goto L154;
        String r139 = UriProtector.getQueryParameter(r138, "bankh5_backpress_timeout");
    L155:
        if (r139 == null) goto L161;
        if ((!StringsKt.isBlank(r139)) == false) goto L159;
        r114 = r139;
    L159:
        if (r114 == null) goto L161;
        long r140 = CastLongProtector.parseLong(r114);
    L162:
        long r141 = r140;
        Lazy<Map<Integer, Map<String, TimeoutManager>>> r142 = TimeoutManager.f202430l;
        Map r143 = TimeoutManager.a.a();
        Object r144 = r143.get(0);
        if (r144 != null) goto L165;
        r144 = new LinkedHashMap();
        r143.put(0, r144);
    L165:
        Map r145 = (Map) r144;
        Object r146 = r145.get(r134);
        if (r146 != null) goto L168;
        r146 = new TimeoutManager();
        r145.put(r134, r146);
    L168:
        TimeoutManager r147 = (TimeoutManager) r146;
        Map r148 = (Map) TimeoutManager.a.a().get(0);
        if (r148 == null) goto L173;
        TimeoutManager r149 = (TimeoutManager) r148.get(r134);
        if (r149 == null) goto L173;
        r149.a(getSchema(), "bankh5_backpress", r137, r141, "cjpay_bankh5_backpress_timeout", new CJBankTitleBar$initTimeoutManager$5(this));
    L173:
        Map r150 = TimeoutManager.a.a();
        Object r151 = r150.get(1);
        if (r151 != null) goto L176;
        r151 = new LinkedHashMap();
        r150.put(1, r151);
    L176:
        Map r152 = (Map) r151;
        Object r153 = r152.get(r134);
        if (r153 != null) goto L179;
        r153 = new TimeoutManager();
        r152.put(r134, r153);
    L179:
        TimeoutManager r154 = (TimeoutManager) r153;
        Map r155 = (Map) TimeoutManager.a.a().get(1);
        if (r155 == null) goto L186;
        TimeoutManager r156 = (TimeoutManager) r155.get(r134);
        if (r156 == null) goto L187;
        r156.a(getSchema(), "bankh5_close", 1, 2000, "cjpay_bankh5_close_timeout", CJBankTitleBar$initTimeoutManager$8.INSTANCE);
        return;
    L187:
        return;
    L186:
        return;
    L154:
        r139 = null;
    L161:
        r140 = 2000;
        goto L162
    L139:
        if ((!StringsKt.isBlank(r136)) == true) goto L142;
        r136 = null;
    L142:
        if (r136 == null) goto L149;
        int r157 = CastIntegerProtector.parseInt(r136);
        if (r157 != 1) goto L146;
    L148:
        r137 = r157;
        goto L150
    L146:
        if (r157 == 2) goto L148;
        r157 = 0;
        goto L148
    L136:
        r136 = null;
        goto L137
    L127:
        r134 = null;
        goto L128
    L118:
        r130 = 0;
        goto L119
    L115:
        r129 = null;
        goto L116
    L111:
        r128 = null;
        goto L113
    L107:
        r108 = 0;
        goto L108
    L51:
        r126 = null;
        goto L52
    L62:
        TextView r158 = this.f202454d;
        if (r158 == null) goto L66;
        r158.setText(this.f202461k);
    L66:
        TextView r159 = this.f202454d;
        if (r159 == null) goto L69;
        r159.setTextSize(1, 16.0f);
    L69:
        TextView r160 = this.f202454d;
        if (r160 == null) goto L73;
        r160.setMaxEms(9);
    L73:
        TextView r161 = this.f202454d;
        if (r161 == null) goto L77;
        r161.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    L77:
        TextView r162 = this.f202455e;
        if (r162 == null) goto L81;
        r162.setText("本服务由" + this.f202461k + "提供");
    L81:
        ImageView r163 = this.f202453c;
        if (r163 == null) goto L84;
        r163.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_quick_bind_pay_brand_title));
    L84:
        ImageView r164 = this.f202453c;
        if (r164 == null) goto L87;
        ViewGroup.LayoutParams r165 = r164.getLayoutParams();
    L88:
        if (r165 == null) goto L91;
        r165.width = CJPayBasicExtensionKt.dp(87);
    L91:
        if (r165 == null) goto L94;
        r165.height = CJPayBasicExtensionKt.dp(20);
    L94:
        ImageView r166 = this.f202453c;
        if (r166 == null) goto L98;
        r166.setLayoutParams(r165);
        goto L98
    L87:
        r165 = null;
    L7:
        r116 = null;
        goto L8
    }
}
