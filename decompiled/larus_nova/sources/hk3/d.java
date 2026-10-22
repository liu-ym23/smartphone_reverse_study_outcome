package hk3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lhk3/d;", "", "Lhk3/c;", "updateDataOpt", "Lhk3/c;", "m", "()Lhk3/c;", "perfSamplingRate", "l", "naPrefetchSyncUpdate", ce.f26395j, "annieXForce", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "disablePageViewEvent", "e", "disableRenderCache", "f", "disableRenderCacheV2", ce.f26391f, "anniexLynxPreCreate", "c", "anniexLynxPreCreateModel", "d", "anniexLynxCodeCache", "b", "genTemplateDataOpt", "h", "injectCacheAsync", RXScreenCaptureService.KEY_INDEX, "pageRecreateOpt", ce.f26396k, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("anniex_force")
    private final c annieXForce;

    @SerializedName("anniex_lynx_code_cache")
    private final c anniexLynxCodeCache;

    @SerializedName("anniex_lynx_pre_create")
    private final c anniexLynxPreCreate;

    @SerializedName("anniex_lynx_pre_create_model")
    private final c anniexLynxPreCreateModel;

    @SerializedName("disable_page_view_event")
    private final c disablePageViewEvent;

    @SerializedName("disable_render_cache")
    private final c disableRenderCache;

    @SerializedName("disable_render_cache_v2")
    private final c disableRenderCacheV2;

    @SerializedName("gen_template_data_opt")
    private final c genTemplateDataOpt;

    @SerializedName("inject_cache_async")
    private final c injectCacheAsync;

    @SerializedName("na_prefetch_sync_update")
    private final c naPrefetchSyncUpdate;

    @SerializedName("page_recreate_opt")
    private final c pageRecreateOpt;

    @SerializedName("performance_sampling_rate")
    private final c perfSamplingRate;

    @SerializedName("update_data_opt")
    private final c updateDataOpt;

    public static final class a {
    }

    static {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L32;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.updateDataOpt, r101.updateDataOpt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.perfSamplingRate, r101.perfSamplingRate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.naPrefetchSyncUpdate, r101.naPrefetchSyncUpdate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.annieXForce, r101.annieXForce) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.disablePageViewEvent, r101.disablePageViewEvent) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.disableRenderCache, r101.disableRenderCache) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disableRenderCacheV2, r101.disableRenderCacheV2) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.anniexLynxPreCreate, r101.anniexLynxPreCreate) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.anniexLynxPreCreateModel, r101.anniexLynxPreCreateModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anniexLynxCodeCache, r101.anniexLynxCodeCache) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.genTemplateDataOpt, r101.genTemplateDataOpt) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.injectCacheAsync, r101.injectCacheAsync) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageRecreateOpt, r101.pageRecreateOpt) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        c r100 = this.updateDataOpt;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.perfSamplingRate;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.naPrefetchSyncUpdate;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.annieXForce;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        c r113 = this.disablePageViewEvent;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        c r116 = this.disableRenderCache;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        c r119 = this.disableRenderCacheV2;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        c r122 = this.anniexLynxPreCreate;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        c r125 = this.anniexLynxPreCreateModel;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        c r128 = this.anniexLynxCodeCache;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        c r131 = this.genTemplateDataOpt;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        c r134 = this.injectCacheAsync;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        c r137 = this.pageRecreateOpt;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        return r136 + r101;
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabSettings(updateDataOpt=" + this.updateDataOpt + ", perfSamplingRate=" + this.perfSamplingRate + ", naPrefetchSyncUpdate=" + this.naPrefetchSyncUpdate + ", annieXForce=" + this.annieXForce + ", disablePageViewEvent=" + this.disablePageViewEvent + ", disableRenderCache=" + this.disableRenderCache + ", disableRenderCacheV2=" + this.disableRenderCacheV2 + ", anniexLynxPreCreate=" + this.anniexLynxPreCreate + ", anniexLynxPreCreateModel=" + this.anniexLynxPreCreateModel + ", anniexLynxCodeCache=" + this.anniexLynxCodeCache + ", genTemplateDataOpt=" + this.genTemplateDataOpt + ", injectCacheAsync=" + this.injectCacheAsync + ", pageRecreateOpt=" + this.pageRecreateOpt + ")";
    }

    public final c a() {
        return this.annieXForce;
    }

    public final c b() {
        return this.anniexLynxCodeCache;
    }

    public final c c() {
        return this.anniexLynxPreCreate;
    }

    public final c d() {
        return this.anniexLynxPreCreateModel;
    }

    public final c e() {
        return this.disablePageViewEvent;
    }

    public final c f() {
        return this.disableRenderCache;
    }

    public final c g() {
        return this.disableRenderCacheV2;
    }

    public final c h() {
        return this.genTemplateDataOpt;
    }

    public final c i() {
        return this.injectCacheAsync;
    }

    public final c j() {
        return this.naPrefetchSyncUpdate;
    }

    public final c k() {
        return this.pageRecreateOpt;
    }

    public final c l() {
        return this.perfSamplingRate;
    }

    public final c m() {
        return this.updateDataOpt;
    }

    public d(int r100) {
        this.updateDataOpt = null;
        this.perfSamplingRate = null;
        this.naPrefetchSyncUpdate = null;
        this.annieXForce = null;
        this.disablePageViewEvent = null;
        this.disableRenderCache = null;
        this.disableRenderCacheV2 = null;
        this.anniexLynxPreCreate = null;
        this.anniexLynxPreCreateModel = null;
        this.anniexLynxCodeCache = null;
        this.genTemplateDataOpt = null;
        this.injectCacheAsync = null;
        this.pageRecreateOpt = null;
    }
}
