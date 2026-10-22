package com.ss.android.ugc.aweme.trade.goods.entity;

import com.alipay.sdk.m.p.e;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/PreRequestProtocol;", "", "", "ignoreGeckoIdCheck", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "", "bundle", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", ce.f26396k, "geckoId", "f", "channel", "c", "", "schemaQuery", "[Ljava/lang/String;", ce.f26395j, "()[Ljava/lang/String;", "commonQuery", "d", "getProductRequestBlackList", ce.f26391f, "alias", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, e.f25671s, RXScreenCaptureService.KEY_INDEX, "filterRequestByQuery", "e", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PreRequestProtocol {

    @SerializedName("alias")
    private final String alias;

    @SerializedName("bundle")
    private final String bundle;

    @SerializedName("channel")
    private final String channel;

    @SerializedName("common_query")
    private final String[] commonQuery;

    @SerializedName("filter_request_by_query")
    private final String filterRequestByQuery;

    @SerializedName("gecko_id")
    private final String geckoId;

    @SerializedName("get_product_request_black_list")
    private final String[] getProductRequestBlackList;

    @SerializedName("ignore_gecko_id_check")
    private final Boolean ignoreGeckoIdCheck;

    @SerializedName(e.f25671s)
    private final String method;

    @SerializedName("schema_query")
    private final String[] schemaQuery;

    @SerializedName("url")
    private final String url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreRequestProtocol) == true) goto L8;
        return false;
    L8:
        PreRequestProtocol r101 = (PreRequestProtocol) r100;
        if (Intrinsics.areEqual(this.ignoreGeckoIdCheck, r101.ignoreGeckoIdCheck) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.geckoId, r101.geckoId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.schemaQuery, r101.schemaQuery) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.commonQuery, r101.commonQuery) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.getProductRequestBlackList, r101.getProductRequestBlackList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.alias, r101.alias) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.filterRequestByQuery, r101.filterRequestByQuery) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.ignoreGeckoIdCheck;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bundle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.geckoId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.channel;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String[] r116 = this.schemaQuery;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String[] r119 = this.commonQuery;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String[] r122 = this.getProductRequestBlackList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.alias;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.method;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.filterRequestByQuery;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = Arrays.hashCode(r122);
        goto L34
    L29:
        r120 = Arrays.hashCode(r119);
        goto L30
    L25:
        r117 = Arrays.hashCode(r116);
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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

    public final String toString() {
        return "PreRequestProtocol(ignoreGeckoIdCheck=" + this.ignoreGeckoIdCheck + ", bundle=" + this.bundle + ", url=" + this.url + ", geckoId=" + this.geckoId + ", channel=" + this.channel + ", schemaQuery=" + Arrays.toString(this.schemaQuery) + ", commonQuery=" + Arrays.toString(this.commonQuery) + ", getProductRequestBlackList=" + Arrays.toString(this.getProductRequestBlackList) + ", alias=" + this.alias + ", method=" + this.method + ", filterRequestByQuery=" + this.filterRequestByQuery + ')';
    }

    public PreRequestProtocol() {
        this.ignoreGeckoIdCheck = Boolean.FALSE;
        this.bundle = "";
        this.url = "";
        this.geckoId = "";
        this.channel = "";
        this.schemaQuery = new String[0];
        this.commonQuery = new String[0];
        this.getProductRequestBlackList = new String[0];
        this.alias = "";
        this.method = "GET";
        this.filterRequestByQuery = "";
    }

    public final String a() {
        return this.alias;
    }

    public final String b() {
        return this.bundle;
    }

    public final String c() {
        return this.channel;
    }

    public final String[] d() {
        return this.commonQuery;
    }

    public final String e() {
        return this.filterRequestByQuery;
    }

    public final String f() {
        return this.geckoId;
    }

    public final String[] g() {
        return this.getProductRequestBlackList;
    }

    public final Boolean h() {
        return this.ignoreGeckoIdCheck;
    }

    public final String i() {
        return this.method;
    }

    public final String[] j() {
        return this.schemaQuery;
    }

    public final String k() {
        return this.url;
    }
}
