package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u00ad\u0001\u0010%\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006+"}, d2 = {"Lcom/larus/platform/model/downgrade/MockDowngradeStrategyConfig;", "", "extraMatchers", "", "", "", "bodyMatchers", "queryMatchers", "forceIgnoreRequest", "", "forceIgnoreCache", "enabledErrorCode", "", "mockResponseJson", "mockPayload", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getExtraMatchers", "()Ljava/util/Map;", "getBodyMatchers", "getQueryMatchers", "getForceIgnoreRequest", "()Z", "getForceIgnoreCache", "getEnabledErrorCode", "()Ljava/util/List;", "getMockResponseJson", "()Ljava/lang/String;", "getMockPayload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MockDowngradeStrategyConfig {

    @SerializedName("body_matchers")
    private final Map<String, List<String>> bodyMatchers;

    @SerializedName("enabled_error_code")
    private final List<Long> enabledErrorCode;

    @SerializedName("extra_matchers")
    private final Map<String, List<String>> extraMatchers;

    @SerializedName("force_ignore_cache")
    private final boolean forceIgnoreCache;

    @SerializedName("force_ignore_request")
    private final boolean forceIgnoreRequest;

    @SerializedName("mock_payload")
    private final String mockPayload;

    @SerializedName("mock_response_json")
    private final String mockResponseJson;

    @SerializedName("query_matchers")
    private final Map<String, List<String>> queryMatchers;

    public MockDowngradeStrategyConfig() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MockDowngradeStrategyConfig copy$default(MockDowngradeStrategyConfig r100, Map r110, Map r111, Map r112, boolean r113, boolean r114, List r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Map r101 = r100.extraMatchers;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Map r102 = r100.bodyMatchers;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Map r103 = r100.queryMatchers;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.forceIgnoreRequest;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.forceIgnoreCache;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = r100.enabledErrorCode;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.mockResponseJson;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.mockPayload;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
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
        return this.forceIgnoreRequest;
    }

    public final boolean component5() {
        return this.forceIgnoreCache;
    }

    public final List<Long> component6() {
        return this.enabledErrorCode;
    }

    public final String component7() {
        return this.mockResponseJson;
    }

    public final String component8() {
        return this.mockPayload;
    }

    public final MockDowngradeStrategyConfig copy(Map<String, ? extends List<String>> r110, Map<String, ? extends List<String>> r111, Map<String, ? extends List<String>> r112, boolean r113, boolean r114, List<Long> r115, String r116, String r117) {
        return new MockDowngradeStrategyConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MockDowngradeStrategyConfig) == true) goto L8;
        return false;
    L8:
        MockDowngradeStrategyConfig r101 = (MockDowngradeStrategyConfig) r100;
        if (Intrinsics.areEqual(this.extraMatchers, r101.extraMatchers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bodyMatchers, r101.bodyMatchers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMatchers, r101.queryMatchers) == true) goto L18;
        return false;
    L18:
        if (this.forceIgnoreRequest == r101.forceIgnoreRequest) goto L21;
        return false;
    L21:
        if (this.forceIgnoreCache == r101.forceIgnoreCache) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enabledErrorCode, r101.enabledErrorCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mockResponseJson, r101.mockResponseJson) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mockPayload, r101.mockPayload) == true) goto L32;
        return false;
    L32:
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
        int r110 = 1231;
        if (this.forceIgnoreRequest == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.forceIgnoreCache == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (r112 + r110) * 31;
        List<Long> r114 = this.enabledErrorCode;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.mockResponseJson;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.mockPayload;
        if (r120 == null) goto L35;
        r101 = r120.hashCode();
    L35:
        return r119 + r101;
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L17:
        r111 = 1237;
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
        return "MockDowngradeStrategyConfig(extraMatchers=" + this.extraMatchers + ", bodyMatchers=" + this.bodyMatchers + ", queryMatchers=" + this.queryMatchers + ", forceIgnoreRequest=" + this.forceIgnoreRequest + ", forceIgnoreCache=" + this.forceIgnoreCache + ", enabledErrorCode=" + this.enabledErrorCode + ", mockResponseJson=" + this.mockResponseJson + ", mockPayload=" + this.mockPayload + ')';
    }

    public final Map<String, List<String>> getBodyMatchers() {
        return this.bodyMatchers;
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

    public final boolean getForceIgnoreRequest() {
        return this.forceIgnoreRequest;
    }

    public final String getMockPayload() {
        return this.mockPayload;
    }

    public final String getMockResponseJson() {
        return this.mockResponseJson;
    }

    public final Map<String, List<String>> getQueryMatchers() {
        return this.queryMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MockDowngradeStrategyConfig(Map<String, ? extends List<String>> r100, Map<String, ? extends List<String>> r101, Map<String, ? extends List<String>> r102, boolean r103, boolean r104, List<Long> r105, String r106, String r107) {
        this.extraMatchers = r100;
        this.bodyMatchers = r101;
        this.queryMatchers = r102;
        this.forceIgnoreRequest = r103;
        this.forceIgnoreCache = r104;
        this.enabledErrorCode = r105;
        this.mockResponseJson = r106;
        this.mockPayload = r107;
    }

    public /* synthetic */ MockDowngradeStrategyConfig(Map r110, Map r111, Map r112, boolean r113, boolean r114, List r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r118 & 2) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r118 & 4) == 0) goto L13;
        Map r102 = MapsKt.emptyMap();
    L14:
        boolean r103 = false;
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r118 & 16) != 0) goto L22;
        r103 = r114;
    L22:
        String r105 = null;
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r105 = r117;
    L34:
        this(r100, r101, r102, r104, r103, r106, r107, r105);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
