package com.bytedance.ee.bear.bitable.baseadd.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.baseadd.FastAddErrorCode;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u001e\u0010%\u001a\u00020\u00182\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010'H\u0002J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/view/BitableFastAddTipsFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "scene", "", "errCode", "", "Ljava/lang/Integer;", "baseToken", "quitView", "Landroid/view/View;", "fgCloseTipsView", "noAccessTipsView", "fastAddSubmitTimeoutTipsView", "noReadAccessTipsView", "continueFastAddView", "gotoBitableView", "fastAddRetryTipsView", "retryView", "noShareTokenAfterFastAddTipsView", "delegate", "Lcom/bytedance/ee/bear/bitable/baseadd/view/BitableFastAddTipsFragment$Delegate;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "initView", "view", "handleTipsByErrCode", "", "handleGotoBitable", "query", "", "setDelegate", "Companion", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFastAddTipsFragment extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f207021s = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f207022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f207023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f207024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f207025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f207026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f207027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f207028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f207029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f207030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f207031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f207032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f207033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f207034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f207035r;

    public static final class a {
        public static BitableFastAddTipsFragment a(int r100, String r101) {
            BitableFastAddTipsFragment r102 = new BitableFastAddTipsFragment();
            Bundle r103 = new Bundle();
            r103.putInt("err_code", r100);
            r103.putString(BitableResourceData.KEY_BASE_TOKEN, r101);
            r102.setArguments(r103);
            return r102;
        }
    }

    public interface b {
        void N0();

        void X0();

        BitableAnalytic q0();

        void q1();
    }

    static {
    }

    public BitableFastAddTipsFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f207022e = r101.getString("scene");
        this.f207024g = r101.getString(BitableResourceData.KEY_BASE_TOKEN);
        this.f207023f = Integer.valueOf(r101.getInt("err_code"));
        return;
    }

    public static final void U90(BitableFastAddTipsFragment r100, Map r101) {
        r100.getClass();
        t45.c r102 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        String r103 = sbb.e.f541298i.getType();
        String r104 = r100.f207024g;
        if (r101 == null) goto L5;
        Map<String, String> r105 = MapsKt.toMap(r101);
    L6:
        String r106 = r102.Le(r103, r104, r105);
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r106);
        FragmentActivity r107 = r100.getActivity();
        if (r107 == null) goto L10;
        r107.finish();
        return;
    L10:
        return;
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v35, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r10v42, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v37, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v44, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v49, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v55, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v65, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.CharSequence] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.bitable_fast_add_tips_fragment, r111, false);
        Intrinsics.checkNotNull(r100);
        View r101 = r100.findViewById(R.id.quitView);
        r101.setOnClickListener(new h(this));
        this.f207025h = r101;
        Integer r102 = this.f207023f;
        String r112 = null;
        if (r102 == null) goto L119;
        int r103 = r102.intValue();
        if (r103 != 0) goto L7;
        boolean r104 = false;
    L117:
        r112 = Boolean.valueOf(r104);
        goto L119
    L7:
        tt5.a.h("BitableFastAddTipsFragment", "handleTipsByErrCode errCode=" + r103);
        SettingsBitableConfig r105 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        if (r105 != null) goto L10;
        r105 = new SettingsBitableConfig();
    L10:
        tt4.a r106 = r105.b();
        if (r106 == null) goto L15;
        Map<String, String> r107 = r106.a();
        if (r107 == null) goto L15;
        r112 = r107.get(String.valueOf(r103));
    L15:
        ?? r108 = r112;
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_FG_CLOSE.getCode()) goto L23;
        View r109 = r100.findViewById(R.id.fastAddFgCloseTipsView);
        r109.setVisibility(0);
        this.f207026i = r109;
        if (r108 == 0) goto L116;
        ?? r113 = (TextView) r109.findViewById(R.id.fastAddFgCloseTipsTv);
        if (r113 == 0) goto L116;
        r113.setText(r108);
    L116:
        r104 = true;
        goto L117
    L23:
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_NO_ADD_ACCESS.getCode()) goto L25;
    L100:
        b r114 = this.f207035r;
        if (r114 == null) goto L108;
        BitableAnalytic r115 = r114.q0();
        if (r115 == null) goto L108;
        HashMap r116 = new HashMap();
        String r117 = r115.f209805a.getDocType();
        if (r117 == null) goto L107;
        r116.put("file_id", r117);
    L107:
        r115.L();
        r115.t("ccm_bitable_no_permission_add_record_view", r116);
    L108:
        View r118 = r100.findViewById(R.id.fastAddNoAccessTipsView);
        r118.setVisibility(0);
        View r119 = r118.findViewById(R.id.gotoTableView1);
        this.f207031n = r119;
        if (r119 == null) goto L111;
        r119.setOnClickListener(new com.bytedance.ee.bear.bitable.baseadd.view.b(this));
    L111:
        if (r108 == 0) goto L115;
        ?? r120 = (TextView) r118.findViewById(R.id.fastAddNoAccessTipsTv);
        if (r120 == 0) goto L115;
        r120.setText(r108);
    L115:
        this.f207027j = r118;
        goto L116
    L25:
        if (r103 == FastAddErrorCode.FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1.getCode()) goto L100;
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER.getCode()) goto L46;
        b r121 = this.f207035r;
        if (r121 == null) goto L34;
        BitableAnalytic r122 = r121.q0();
        if (r122 == null) goto L34;
        r122.t("ccm_bitable_add_record_timeout_view", new HashMap());
    L34:
        View r123 = r100.findViewById(R.id.fastAddSubmitTimeoutTipsView);
        r123.setVisibility(0);
        View r124 = r123.findViewById(R.id.continueFastAddView2);
        this.f207030m = r124;
        if (r124 == null) goto L37;
        r124.setOnClickListener(new c(this));
    L37:
        View r125 = r123.findViewById(R.id.gotoTableView2);
        this.f207031n = r125;
        if (r125 == null) goto L40;
        r125.setOnClickListener(new d(this));
    L40:
        if (r108 == 0) goto L44;
        ?? r126 = (TextView) r123.findViewById(R.id.fastAddSubmitTimeoutTipsTv);
        if (r126 == 0) goto L44;
        r126.setText(r108);
    L44:
        this.f207028k = r123;
        goto L116
    L46:
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_NO_READ_ACCESS.getCode()) goto L59;
        View r127 = r100.findViewById(R.id.fastAddNoReadAccessTipsView);
        r127.setVisibility(0);
        View r128 = r127.findViewById(R.id.continueFastAddView3);
        this.f207030m = r128;
        if (r128 == null) goto L50;
        r128.setOnClickListener(new e(this));
    L50:
        View r129 = r127.findViewById(R.id.gotoTableView3);
        this.f207031n = r129;
        if (r129 == null) goto L53;
        r129.setOnClickListener(new xo4.e(this));
    L53:
        if (r108 == 0) goto L57;
        ?? r130 = (TextView) r127.findViewById(R.id.fastAddNoReadAccessTipsTv);
        if (r130 == 0) goto L57;
        r130.setText(r108);
    L57:
        this.f207029l = r127;
        goto L116
    L59:
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_META_REQUEST_FAILED.getCode()) goto L61;
    L92:
        View r131 = r100.findViewById(R.id.fastAddRetryTipsView);
        r131.setVisibility(0);
        View r132 = r131.findViewById(R.id.retryView);
        this.f207033p = r132;
        if (r132 == null) goto L95;
        r132.setOnClickListener(new f(this));
    L95:
        if (r108 == 0) goto L99;
        ?? r133 = (TextView) r131.findViewById(R.id.fastAddRetryTipsTv);
        if (r133 == 0) goto L99;
        r133.setText(r108);
    L99:
        this.f207032o = r131;
        goto L116
    L61:
        if (r103 == FastAddErrorCode.FAST_ADD_ERR_CODE_META_REQUEST_EXCEPTION.getCode()) goto L92;
        if (r103 == FastAddErrorCode.FAST_ADD_ERR_CODE_META_RESPONSE_DATA_IS_NULL.getCode()) goto L92;
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_TABLE_NOT_EXIST.getCode()) goto L68;
    L86:
        View r134 = r100.findViewById(R.id.tableNotExistTipsView);
        r134.setVisibility(0);
        if (r108 == 0) goto L91;
        ?? r135 = (TextView) r134.findViewById(R.id.tableNotExistTipsTv);
        if (r135 == 0) goto L91;
        r135.setText(r108);
    L91:
        this.f207032o = r134;
        goto L116
    L68:
        if (r103 == FastAddErrorCode.FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_1.getCode()) goto L86;
        if (r103 == FastAddErrorCode.FAST_ADD_ERR_CODE_TABLE_NOT_EXIST_2.getCode()) goto L86;
        if (r103 != FastAddErrorCode.FAST_ADD_ERR_CODE_NO_SHARE_TOKEN_AFTER_SUBMIT.getCode()) goto L85;
        View r136 = r100.findViewById(R.id.noShareTokenAfterFastAddTipsView);
        r136.setVisibility(0);
        View r137 = r136.findViewById(R.id.continueFastAddView4);
        this.f207030m = r137;
        if (r137 == null) goto L77;
        r137.setOnClickListener(new g(this));
    L77:
        View r138 = r136.findViewById(R.id.gotoTableView4);
        this.f207031n = r138;
        if (r138 == null) goto L80;
        r138.setOnClickListener(new xo4.f(this));
    L80:
        if (r108 == 0) goto L84;
        ?? r139 = (TextView) r136.findViewById(R.id.noShareTokenAfterFastAddTipsTv);
        if (r139 == 0) goto L84;
        r139.setText(r108);
    L84:
        this.f207034q = r136;
        goto L116
    L85:
        tt5.a.d("BitableFastAddTipsFragment", "invalid scene");
    L119:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == true) goto L192;
        String r140 = this.f207022e;
        if (r140 == null) goto L192;
        switch(r140.hashCode()) {
            case 274028207: goto L182;
            case 1313346625: goto L178;
            case 1411119354: goto L174;
            case 1800903707: goto L164;
            case 1850624000: goto L149;
            case 1866832954: goto L134;
            case 1988585804: goto L127;
            default: goto L191;
        };
    L191:
        tt5.a.d("BitableFastAddTipsFragment", "invalid scene");
        goto L192
    L127:
        if (r140.equals("open_failed_can_retry") == false) goto L191;
        View r141 = r100.findViewById(R.id.fastAddRetryTipsView);
        r141.setVisibility(0);
        View r142 = r141.findViewById(R.id.retryView);
        this.f207033p = r142;
        if (r142 == null) goto L132;
        r142.setOnClickListener(new m(this));
    L132:
        this.f207032o = r141;
        goto L192
    L134:
        if (r140.equals("submit_timeout") == false) goto L191;
        b r143 = this.f207035r;
        if (r143 == null) goto L141;
        BitableAnalytic r144 = r143.q0();
        if (r144 == null) goto L141;
        r144.t("ccm_bitable_add_record_timeout_view", new HashMap());
    L141:
        View r145 = r100.findViewById(R.id.fastAddSubmitTimeoutTipsView);
        r145.setVisibility(0);
        View r146 = r145.findViewById(R.id.continueFastAddView2);
        this.f207030m = r146;
        if (r146 == null) goto L144;
        r146.setOnClickListener(new j(this));
    L144:
        View r147 = r145.findViewById(R.id.gotoTableView2);
        this.f207031n = r147;
        if (r147 == null) goto L147;
        r147.setOnClickListener(new k(this));
    L147:
        this.f207028k = r145;
        goto L192
    L149:
        if (r140.equals("no_add_access") == false) goto L191;
        b r148 = this.f207035r;
        if (r148 == null) goto L159;
        BitableAnalytic r149 = r148.q0();
        if (r149 == null) goto L159;
        HashMap r150 = new HashMap();
        String r151 = r149.f209805a.getDocType();
        if (r151 == null) goto L158;
        r150.put("file_id", r151);
    L158:
        r149.L();
        r149.t("ccm_bitable_no_permission_add_record_view", r150);
    L159:
        View r152 = r100.findViewById(R.id.fastAddNoAccessTipsView);
        r152.setVisibility(0);
        View r153 = r152.findViewById(R.id.gotoTableView1);
        this.f207031n = r153;
        if (r153 == null) goto L162;
        r153.setOnClickListener(new i(this));
    L162:
        this.f207027j = r152;
        goto L192
    L164:
        if (r140.equals("no_share_token") == false) goto L191;
        View r154 = r100.findViewById(R.id.noShareTokenAfterFastAddTipsView);
        r154.setVisibility(0);
        View r155 = r154.findViewById(R.id.continueFastAddView4);
        this.f207030m = r155;
        if (r155 == null) goto L169;
        r155.setOnClickListener(new n(this));
    L169:
        View r156 = r154.findViewById(R.id.gotoTableView4);
        this.f207031n = r156;
        if (r156 == null) goto L172;
        r156.setOnClickListener(new xo4.h(this));
    L172:
        this.f207034q = r154;
        goto L192
    L174:
        if (r140.equals("fg_close") == false) goto L191;
        View r157 = r100.findViewById(R.id.fastAddFgCloseTipsView);
        r157.setVisibility(0);
        this.f207026i = r157;
        goto L192
    L178:
        if (r140.equals("origin_table_not_exist") == false) goto L191;
        View r158 = r100.findViewById(R.id.tableNotExistTipsView);
        r158.setVisibility(0);
        this.f207032o = r158;
        goto L192
    L182:
        if (r140.equals("no_read_access") == false) goto L191;
        View r159 = r100.findViewById(R.id.fastAddNoReadAccessTipsView);
        r159.setVisibility(0);
        View r160 = r159.findViewById(R.id.continueFastAddView3);
        this.f207030m = r160;
        if (r160 == null) goto L187;
        r160.setOnClickListener(new l(this));
    L187:
        View r161 = r159.findViewById(R.id.gotoTableView3);
        this.f207031n = r161;
        if (r161 == null) goto L190;
        r161.setOnClickListener(new xo4.g(this));
    L190:
        this.f207029l = r159;
    L192:
        return r100;
    }
}
