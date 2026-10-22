package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J¡\u0001\u0010#\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/larus/platform/model/downgrade/ToastDowngradeStrategyConfig;", "", "extraMatchers", "", "", "", "bodyMatchers", "queryMatchers", "forceIgnoreCache", "", "enabledErrorCode", "", "debounceGapMs", "defaultToastText", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/util/List;JLjava/lang/String;)V", "getExtraMatchers", "()Ljava/util/Map;", "getBodyMatchers", "getQueryMatchers", "getForceIgnoreCache", "()Z", "getEnabledErrorCode", "()Ljava/util/List;", "getDebounceGapMs", "()J", "getDefaultToastText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastDowngradeStrategyConfig {

    @SerializedName("body_matchers")
    private final Map<String, List<String>> bodyMatchers;

    @SerializedName("debounce_gap_ms")
    private final long debounceGapMs;

    @SerializedName("default_toast_text")
    private final String defaultToastText;

    @SerializedName("enabled_error_code")
    private final List<Long> enabledErrorCode;

    @SerializedName("extra_matchers")
    private final Map<String, List<String>> extraMatchers;

    @SerializedName("force_ignore_cache")
    private final boolean forceIgnoreCache;

    @SerializedName("query_matchers")
    private final Map<String, List<String>> queryMatchers;

    public ToastDowngradeStrategyConfig() {
        this(null, null, null, false, null, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToastDowngradeStrategyConfig copy$default(ToastDowngradeStrategyConfig r100, Map r110, Map r111, Map r112, boolean r113, List r114, long r115, String r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        Map r101 = r100.extraMatchers;
    L7:
        if ((r117 & 2) == 0) goto L9;
        Map r102 = r100.bodyMatchers;
    L11:
        if ((r117 & 4) == 0) goto L13;
        Map r103 = r100.queryMatchers;
    L15:
        if ((r117 & 8) == 0) goto L17;
        boolean r104 = r100.forceIgnoreCache;
    L19:
        if ((r117 & 16) == 0) goto L21;
        List r105 = r100.enabledErrorCode;
    L23:
        if ((r117 & 32) == 0) goto L25;
        long r106 = r100.debounceGapMs;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r107 = r100.defaultToastText;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Map<String, List<String>> component1() {
        return this.extraMatchers;
    }

    public final Map<String, List<String>> component2() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> component3() {
        return this.queryMatchers;
    }

    public final boolean component4() {
        return this.forceIgnoreCache;
    }

    public final List<Long> component5() {
        return this.enabledErrorCode;
    }

    public final long component6() {
        return this.debounceGapMs;
    }

    public final String component7() {
        return this.defaultToastText;
    }

    public final ToastDowngradeStrategyConfig copy(Map<String, ? extends List<String>> r110, Map<String, ? extends List<String>> r111, Map<String, ? extends List<String>> r112, boolean r113, List<Long> r114, long r115, String r116) {
        return new ToastDowngradeStrategyConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ToastDowngradeStrategyConfig) == true) goto L8;
        return false;
    L8:
        ToastDowngradeStrategyConfig r101 = (ToastDowngradeStrategyConfig) r100;
        if (Intrinsics.areEqual(this.extraMatchers, r101.extraMatchers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bodyMatchers, r101.bodyMatchers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMatchers, r101.queryMatchers) == true) goto L18;
        return false;
    L18:
        if (this.forceIgnoreCache == r101.forceIgnoreCache) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enabledErrorCode, r101.enabledErrorCode) == true) goto L24;
        return false;
    L24:
        if (this.debounceGapMs == r101.debounceGapMs) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.defaultToastText, r101.defaultToastText) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Map<String, List<String>> r100 = this.extraMatchers;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.bodyMatchers;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, List<String>> r107 = this.queryMatchers;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.forceIgnoreCache == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        List<Long> r112 = this.enabledErrorCode;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        long r115 = this.debounceGapMs;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.defaultToastText;
        if (r117 == null) goto L27;
        r101 = r117.hashCode();
    L27:
        return r116 + r101;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ToastDowngradeStrategyConfig(extraMatchers=" + this.extraMatchers + ", bodyMatchers=" + this.bodyMatchers + ", queryMatchers=" + this.queryMatchers + ", forceIgnoreCache=" + this.forceIgnoreCache + ", enabledErrorCode=" + this.enabledErrorCode + ", debounceGapMs=" + this.debounceGapMs + ", defaultToastText=" + this.defaultToastText + ')';
    }

    public final Map<String, List<String>> getBodyMatchers() {
        return this.bodyMatchers;
    }

    public final long getDebounceGapMs() {
        return this.debounceGapMs;
    }

    public final String getDefaultToastText() {
        return this.defaultToastText;
    }

    public final List<Long> getEnabledErrorCode() {
        return this.enabledErrorCode;
    }

    public final Map<String, List<String>> getExtraMatchers() {
        return this.extraMatchers;
    }

    public final boolean getForceIgnoreCache() {
        return this.forceIgnoreCache;
    }

    public final Map<String, List<String>> getQueryMatchers() {
        return this.queryMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToastDowngradeStrategyConfig(Map<String, ? extends List<String>> r100, Map<String, ? extends List<String>> r101, Map<String, ? extends List<String>> r102, boolean r103, List<Long> r104, long r105, String r106) {
        this.extraMatchers = r100;
        this.bodyMatchers = r101;
        this.queryMatchers = r102;
        this.forceIgnoreCache = r103;
        this.enabledErrorCode = r104;
        this.debounceGapMs = r105;
        this.defaultToastText = r106;
    }

    public /* synthetic */ ToastDowngradeStrategyConfig(Map r110, Map r111, Map r112, boolean r113, List r114, long r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r117 & 2) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r117 & 4) == 0) goto L13;
        Map r102 = MapsKt.emptyMap();
    L15:
        if ((r117 & 8) == 0) goto L17;
        boolean r103 = false;
    L18:
        String r104 = null;
        if ((r117 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r117 & 32) == 0) goto L25;
        long r106 = 0;
    L27:
        if ((r117 & 64) != 0) goto L30;
        r104 = r116;
    L30:
        this(r100, r101, r102, r103, r105, r106, r104);
        return;
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
