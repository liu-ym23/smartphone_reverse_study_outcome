package uq6;

import com.amap.api.col.s.ce;
import com.bytedance.locallife.dito.performance.o;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR.\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR.\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR.\u0010/\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR.\u00105\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR.\u0010A\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f¨\u0006D"}, d2 = {"Luq6/c;", "", "", "subType", "Ljava/lang/String;", "getSubType", "()Ljava/lang/String;", "setSubType", "(Ljava/lang/String;)V", "", "componentRenderCreateViewTs", "Ljava/lang/Long;", "getComponentRenderCreateViewTs", "()Ljava/lang/Long;", ce.f26391f, "(Ljava/lang/Long;)V", "", "isLoadInFmp", "Z", "()Z", "m", "(Z)V", "componentParseCreateModelTs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "componentParseCreateModelCost", "getComponentParseCreateModelCost", "e", "componentRenderCreateViewCost", "getComponentRenderCreateViewCost", "setComponentRenderCreateViewCost", "value", "componentRenderViewBindModelTs", "getComponentRenderViewBindModelTs", ce.f26395j, "componentRenderViewBindModelCost", "getComponentRenderViewBindModelCost", "setComponentRenderViewBindModelCost", "componentRenderViewShowTs", "getComponentRenderViewShowTs", ce.f26396k, "componentRenderFcpCost", "getComponentRenderFcpCost", "setComponentRenderFcpCost", "componentRenderTotalFcp", "getComponentRenderTotalFcp", "setComponentRenderTotalFcp", "componentRenderFcpTs", "getComponentRenderFcpTs", "h", "componentRenderViewSizeStableCost", "getComponentRenderViewSizeStableCost", "setComponentRenderViewSizeStableCost", "componentSizeStableTs", "c", "l", "componentGeckoId", "getComponentGeckoId", "d", "componentRenderViewFmpCost", "getComponentRenderViewFmpCost", "setComponentRenderViewFmpCost", "componentRenderTotalFmp", "getComponentRenderTotalFmp", "setComponentRenderTotalFmp", "componentRenderFmpTs", "b", RXScreenCaptureService.KEY_INDEX, "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("gecko_id")
    private String componentGeckoId;

    @SerializedName("component_parse_create_model_cost")
    private Long componentParseCreateModelCost;

    @SerializedName("component_parse_create_model_ts")
    private Long componentParseCreateModelTs;

    @SerializedName("component_render_create_view_cost")
    private Long componentRenderCreateViewCost;

    @SerializedName("component_render_create_view_ts")
    private Long componentRenderCreateViewTs;

    @SerializedName("component_render_fcp_cost")
    private Long componentRenderFcpCost;

    @SerializedName("component_render_fcp_ts")
    private Long componentRenderFcpTs;

    @SerializedName("component_render_fmp_ts")
    private Long componentRenderFmpTs;

    @SerializedName("component_render_total_fcp_cost")
    private Long componentRenderTotalFcp;

    @SerializedName("component_render_total_fmp_cost")
    private Long componentRenderTotalFmp;

    @SerializedName("component_render_view_bind_model_cost")
    private Long componentRenderViewBindModelCost;

    @SerializedName("component_render_view_bind_model_ts")
    private Long componentRenderViewBindModelTs;

    @SerializedName("component_render_fmp_cost")
    private Long componentRenderViewFmpCost;

    @SerializedName("component_render_view_show_ts")
    private Long componentRenderViewShowTs;

    @SerializedName("component_render_size_stable_cost")
    private Long componentRenderViewSizeStableCost;

    @SerializedName("component_render_size_stable_ts")
    private Long componentSizeStableTs;

    @SerializedName("is_load_in_fmp")
    private boolean isLoadInFmp;

    @SerializedName("component_sub_type")
    private String subType;

    public c() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentRenderCreateViewTs, r101.componentRenderCreateViewTs) == true) goto L15;
        return false;
    L15:
        if (this.isLoadInFmp == r101.isLoadInFmp) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.subType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.componentRenderCreateViewTs;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.isLoadInFmp == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoComponentTimingInfo(subType=" + this.subType + ", componentRenderCreateViewTs=" + this.componentRenderCreateViewTs + ", componentParseCreateModelTs=" + this.componentParseCreateModelTs + ", componentParseCreateModelCost=" + this.componentParseCreateModelCost + ", componentRenderCreateViewCost=" + this.componentRenderCreateViewCost + ", componentRenderViewBindModelTs=" + this.componentRenderViewBindModelTs + ", componentRenderViewBindModelCost=" + this.componentRenderViewBindModelCost + ", componentRenderViewShowTs=" + this.componentRenderViewShowTs + ", componentRenderFcpCost=" + this.componentRenderFcpCost + ", componentRenderTotalFcp=" + this.componentRenderTotalFcp + ", componentRenderFcpTs=" + this.componentRenderFcpTs + ", componentRenderViewSizeStableCost=" + this.componentRenderViewSizeStableCost + ", componentSizeStableTs=" + this.componentSizeStableTs + ", componentRenderViewFmpCost=" + this.componentRenderViewFmpCost + ", componentRenderTotalFmp=" + this.componentRenderTotalFmp + ", componentRenderFmpTs=" + this.componentRenderFmpTs + ')';
    }

    public final Long a() {
        return this.componentParseCreateModelTs;
    }

    public final Long b() {
        return this.componentRenderFmpTs;
    }

    public final Long c() {
        return this.componentSizeStableTs;
    }

    public final void d(String r100) {
        this.componentGeckoId = r100;
    }

    public final void e(Long r100) {
        this.componentParseCreateModelCost = r100;
    }

    public final void f(Long r100) {
        this.componentParseCreateModelTs = r100;
    }

    public final void g(Long r100) {
        this.componentRenderCreateViewTs = r100;
    }

    public final void h(Long r100) {
        this.componentRenderFcpTs = r100;
        this.componentRenderFcpCost = o.a(this.componentRenderViewShowTs, r100);
        this.componentRenderTotalFcp = o.a(this.componentRenderCreateViewTs, this.componentRenderFcpTs);
    }

    public final void i(Long r100) {
        this.componentRenderFmpTs = r100;
        this.componentRenderViewFmpCost = o.a(this.componentRenderViewShowTs, r100);
        this.componentRenderTotalFmp = o.a(this.componentRenderCreateViewTs, this.componentRenderFmpTs);
    }

    public final void j(Long r100) {
        this.componentRenderViewBindModelTs = r100;
        if (this.componentRenderCreateViewCost != null) goto L6;
        this.componentRenderCreateViewCost = o.a(this.componentRenderCreateViewTs, r100);
        return;
    }

    public final void k(Long r100) {
        this.componentRenderViewShowTs = r100;
        this.componentRenderViewBindModelCost = o.a(this.componentRenderViewBindModelTs, r100);
    }

    public final void l(Long r100) {
        this.componentSizeStableTs = r100;
        this.componentRenderViewSizeStableCost = o.a(this.componentRenderViewShowTs, r100);
    }

    public final void m(boolean r100) {
        this.isLoadInFmp = r100;
    }

    public c(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.subType = r100;
        this.componentRenderCreateViewTs = null;
        this.isLoadInFmp = false;
    }
}
