package com.bytedance.locallife.pdp.container.impl;

import com.bytedance.locallife.pdp.settings.PoiGoodsDetailRecoveryPayFooterSetting;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements ww6.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f261178b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3684b f261179a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.pdp.container.impl.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/pdp/container/impl/b$b;", "", "", "clickUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "buttonTitle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "isShow", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "templateUrl", "c", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class C3684b {

        @SerializedName("button_title")
        private final String buttonTitle;

        @SerializedName("click_url")
        private final String clickUrl;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
        private final Boolean isShow;

        @SerializedName("template_url")
        private final String templateUrl;

        public C3684b() {
            this(null, null, null, null);
        }

        public final String a() {
            return this.buttonTitle;
        }

        public final String b() {
            return this.clickUrl;
        }

        public final String c() {
            return this.templateUrl;
        }

        public final Boolean d() {
            return this.isShow;
        }

        public C3684b(String r100, String r101, Boolean r102, String r103) {
            this.clickUrl = r100;
            this.buttonTitle = r101;
            this.isShow = r102;
            this.templateUrl = r103;
        }
    }

    static {
    }

    public b() {
    }

    @Override // ww6.d
    public final String a() {
        C3684b r100 = this.f261179a;
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "aweme://lynxview?channel=groupon_lynx_detail_components&bundle=detail_pay_footer%2Ftemplate.js&dynamic=1&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_detail_components%2Fdetail_pay_footer%2Ftemplate.js";
    }

    @Override // ww6.d
    public final String b() {
        C3684b r100 = this.f261179a;
        if (r100 == null) goto L6;
        String r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "aweme://lynxview/?channel=groupon_lynx_confirm_order_page&surl=https%3A%2F%2Flf-dy-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F1325%2Fgecko%2Fresource%2Fgroupon_lynx_confirm_order_page%2Ftemplate.js&pre_page=detail_page&hide_nav_bar=1&trans_status_bar=1&dynamic=1&use_gecko_first=1&use_bdx_since=16.8.0&bundle=template.js";
    }

    @Override // ww6.d
    public final String c() {
        C3684b r100 = this.f261179a;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "立即购买";
    }

    @Override // ww6.d
    public final boolean d() {
        C3684b r100 = this.f261179a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.d();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    @Override // ww6.d
    public final void e(ww6.n r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        final String r101 = r100.k(UniContext.KEY_OF_BIZ_CODE);
        final String r102 = r100.k("industry_biz_type");
        final String r103 = r100.k("product_type");
        Function3<Boolean, Boolean, Boolean, String> r104 = new DefaultDetailPayFooterRecoverProvider$getRecoveryPayFooterEntity$getRecoverKeyFunctionWrapper$1(this, r101, r102, r103);
        Map r105 = (Map) PoiGoodsDetailRecoveryPayFooterSetting.f261718a.getValue();
        String r106 = null;
        if (r105 == null) goto L6;
        Boolean r107 = Boolean.TRUE;
        Map r108 = (Map) r105.get(r104.invoke(r107, r107, r107));
        if (r108 == null) goto L6;
    L18:
        if (r108 == null) goto L20;
        Object r109 = r108.get("click_url");
    L22:
        if ((r109 instanceof String) == false) goto L24;
        String r110 = (String) r109;
    L25:
        if (r108 == null) goto L27;
        Object r111 = r108.get("button_title");
    L29:
        if ((r111 instanceof String) == false) goto L31;
        String r112 = (String) r111;
    L32:
        if (r108 == null) goto L34;
        Object r113 = r108.get(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW);
    L36:
        if ((r113 instanceof Boolean) == false) goto L38;
        Boolean r114 = (Boolean) r113;
    L39:
        if (r108 == null) goto L41;
        Object r115 = r108.get("template_url");
    L43:
        if ((r115 instanceof String) == false) goto L45;
        r106 = (String) r115;
    L45:
        this.f261179a = new C3684b(r110, r112, r114, r106);
        return;
    L41:
        r115 = null;
        goto L43
    L38:
        r114 = null;
        goto L39
    L34:
        r113 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L27:
        r111 = null;
        goto L29
    L24:
        r110 = null;
        goto L25
    L20:
        r109 = null;
    L6:
        if (r105 == null) goto L8;
        Boolean r116 = Boolean.TRUE;
        r108 = (Map) r105.get(r104.invoke(r116, r116, Boolean.FALSE));
    L9:
        if (r108 != null) goto L18;
        if (r105 == null) goto L12;
        Boolean r117 = Boolean.TRUE;
        Boolean r118 = Boolean.FALSE;
        r108 = (Map) r105.get(r104.invoke(r117, r118, r118));
    L13:
        if (r108 != null) goto L18;
        if (r105 == null) goto L16;
        r108 = (Map) r105.get("default_config");
        goto L18
    L16:
        r108 = null;
        goto L18
    L12:
        r108 = null;
        goto L13
    L8:
        r108 = null;
        goto L9
    }
}
