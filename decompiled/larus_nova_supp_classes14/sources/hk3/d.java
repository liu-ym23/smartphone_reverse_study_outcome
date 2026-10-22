package hk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lhk3/d;", "", "Lhk3/c;", "updateDataOpt", "Lhk3/c;", "m", "()Lhk3/c;", "perfSamplingRate", "l", "naPrefetchSyncUpdate", "j", "annieXForce", "a", "disablePageViewEvent", "e", "disableRenderCache", "f", "disableRenderCacheV2", "g", "anniexLynxPreCreate", "c", "anniexLynxPreCreateModel", "d", "anniexLynxCodeCache", "b", "genTemplateDataOpt", "h", "injectCacheAsync", "i", "pageRecreateOpt", "k", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L32;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.updateDataOpt, r4.updateDataOpt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.perfSamplingRate, r4.perfSamplingRate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.naPrefetchSyncUpdate, r4.naPrefetchSyncUpdate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.annieXForce, r4.annieXForce) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.disablePageViewEvent, r4.disablePageViewEvent) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.disableRenderCache, r4.disableRenderCache) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.disableRenderCacheV2, r4.disableRenderCacheV2) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.anniexLynxPreCreate, r4.anniexLynxPreCreate) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.anniexLynxPreCreateModel, r4.anniexLynxPreCreateModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anniexLynxCodeCache, r4.anniexLynxCodeCache) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.genTemplateDataOpt, r4.genTemplateDataOpt) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.injectCacheAsync, r4.injectCacheAsync) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageRecreateOpt, r4.pageRecreateOpt) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        c r0 = this.updateDataOpt;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        c r4 = this.perfSamplingRate;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        c r7 = this.naPrefetchSyncUpdate;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        c r10 = this.annieXForce;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        c r13 = this.disablePageViewEvent;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        c r16 = this.disableRenderCache;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        c r19 = this.disableRenderCacheV2;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        c r22 = this.anniexLynxPreCreate;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        c r25 = this.anniexLynxPreCreateModel;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        c r28 = this.anniexLynxCodeCache;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        c r31 = this.genTemplateDataOpt;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        c r34 = this.injectCacheAsync;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        c r37 = this.pageRecreateOpt;
        if (r37 == null) goto L54;
        r1 = r37.hashCode();
    L54:
        return r36 + r1;
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public d(int r1) {
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
