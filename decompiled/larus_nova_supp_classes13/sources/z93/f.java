package z93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u00017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00100\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R\u001a\u00103\u001a\u0002028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lz93/f;", "", "", "preloadTiming", "I", "getPreloadTiming", "()I", "", "", "allowPreloadPage", "Ljava/util/List;", "getAllowPreloadPage", "()Ljava/util/List;", "allowPreloadGeckoMinVersion", "Ljava/lang/String;", "getAllowPreloadGeckoMinVersion", "()Ljava/lang/String;", "Lz93/e;", "preCreateLynxView", "Lz93/e;", "getPreCreateLynxView", "()Lz93/e;", "Lz93/c;", "preDecodeTemplate", "Lz93/c;", "getPreDecodeTemplate", "()Lz93/c;", "preLoadTemplate", "getPreLoadTemplate", "Lz93/d;", "preRenderTemplate", "Lz93/d;", "getPreRenderTemplate", "()Lz93/d;", "Lz93/b;", "preDecodeComponent", "Lz93/b;", "getPreDecodeComponent", "()Lz93/b;", "preloadLynxEnv", "getPreloadLynxEnv", "", "checkLynxEnvInterval", "J", "getCheckLynxEnvInterval", "()J", "maxThreadNum", "getMaxThreadNum", "coreThreadNum", "getCoreThreadNum", "", "forceExecute", "Z", "getForceExecute", "()Z", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("allow_preload_gecko_min_version")
    private final String allowPreloadGeckoMinVersion;

    @SerializedName("allow_preload_page")
    private final List<String> allowPreloadPage;

    @SerializedName("check_lynx_env_interval")
    private final long checkLynxEnvInterval;

    @SerializedName("thread_core_num")
    private final int coreThreadNum;

    @SerializedName("force_execute")
    private final boolean forceExecute;

    @SerializedName("thread_max_num")
    private final int maxThreadNum;

    @SerializedName("create_lynx_view")
    private final e preCreateLynxView;

    @SerializedName("decode_components_template")
    private final b preDecodeComponent;

    @SerializedName("decode_template")
    private final c preDecodeTemplate;

    @SerializedName("load_template")
    private final e preLoadTemplate;

    @SerializedName("render_template")
    private final d preRenderTemplate;

    @SerializedName("preload_lynx_env")
    private final int preloadLynxEnv;

    @SerializedName("mall_preload_timing")
    private final int preloadTiming;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L32;
        f r7 = (f) r6;
        if (this.preloadTiming == r7.preloadTiming) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.allowPreloadPage, r7.allowPreloadPage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.allowPreloadGeckoMinVersion, r7.allowPreloadGeckoMinVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preCreateLynxView, r7.preCreateLynxView) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preDecodeTemplate, r7.preDecodeTemplate) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preLoadTemplate, r7.preLoadTemplate) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preRenderTemplate, r7.preRenderTemplate) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.preDecodeComponent, r7.preDecodeComponent) == true) goto L22;
        return false;
    L22:
        if (this.preloadLynxEnv == r7.preloadLynxEnv) goto L24;
        return false;
    L24:
        if (this.checkLynxEnvInterval == r7.checkLynxEnvInterval) goto L26;
        return false;
    L26:
        if (this.maxThreadNum == r7.maxThreadNum) goto L28;
        return false;
    L28:
        if (this.coreThreadNum == r7.coreThreadNum) goto L30;
        return false;
    L30:
        if (this.forceExecute == r7.forceExecute) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v33 */
    public final int hashCode() {
        int r0 = this.preloadTiming * 31;
        List<String> r1 = this.allowPreloadPage;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.allowPreloadGeckoMinVersion;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        e r8 = this.preCreateLynxView;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        c r11 = this.preDecodeTemplate;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        e r14 = this.preLoadTemplate;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        d r17 = this.preRenderTemplate;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        b r20 = this.preDecodeComponent;
        if (r20 == null) goto L29;
        r2 = r20.hashCode();
    L29:
        int r21 = (((r19 + r2) * 31) + this.preloadLynxEnv) * 31;
        long r22 = this.checkLynxEnvInterval;
        int r23 = (((((r21 + ((int) (r22 ^ (r22 >>> 32)))) * 31) + this.maxThreadNum) * 31) + this.coreThreadNum) * 31;
        boolean r24 = this.forceExecute;
        ?? r25 = r24;
        if (r24 == false) goto L33;
        r25 = 1;
    L33:
        return r23 + r25;
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "MallPreloadConfig(preloadTiming=" + this.preloadTiming + ", allowPreloadPage=" + this.allowPreloadPage + ", allowPreloadGeckoMinVersion=" + this.allowPreloadGeckoMinVersion + ", preCreateLynxView=" + this.preCreateLynxView + ", preDecodeTemplate=" + this.preDecodeTemplate + ", preLoadTemplate=" + this.preLoadTemplate + ", preRenderTemplate=" + this.preRenderTemplate + ", preDecodeComponent=" + this.preDecodeComponent + ", preloadLynxEnv=" + this.preloadLynxEnv + ", checkLynxEnvInterval=" + this.checkLynxEnvInterval + ", maxThreadNum=" + this.maxThreadNum + ", coreThreadNum=" + this.coreThreadNum + ", forceExecute=" + this.forceExecute + ")";
    }

    public f(Object r3) {
        this.preloadTiming = 0;
        this.allowPreloadPage = null;
        this.allowPreloadGeckoMinVersion = null;
        this.preCreateLynxView = null;
        this.preDecodeTemplate = null;
        this.preLoadTemplate = null;
        this.preRenderTemplate = null;
        this.preDecodeComponent = null;
        this.preloadLynxEnv = 0;
        this.checkLynxEnvInterval = 5000;
        this.maxThreadNum = 10;
        this.coreThreadNum = 5;
        this.forceExecute = false;
    }
}
