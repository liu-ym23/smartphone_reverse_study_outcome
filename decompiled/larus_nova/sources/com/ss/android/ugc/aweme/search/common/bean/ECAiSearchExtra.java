package com.ss.android.ugc.aweme.search.common.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/bean/ECAiSearchExtra;", "Ljava/io/Serializable;", "extraRequestParams", "", "", "", "originAiProductInfo", "preAiPageType", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getExtraRequestParams", "()Ljava/util/Map;", "setExtraRequestParams", "(Ljava/util/Map;)V", "getOriginAiProductInfo", "()Ljava/lang/String;", "setOriginAiProductInfo", "(Ljava/lang/String;)V", "getPreAiPageType", "setPreAiPageType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAiSearchExtra implements Serializable {

    @SerializedName("extra_request_params_str")
    private Map<String, ? extends Object> extraRequestParams;

    @SerializedName("product_info")
    private String originAiProductInfo;

    @SerializedName("pre_ai_page_type")
    private String preAiPageType;

    public ECAiSearchExtra() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECAiSearchExtra copy$default(ECAiSearchExtra r100, Map r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.extraRequestParams;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.originAiProductInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.preAiPageType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, Object> component1() {
        return this.extraRequestParams;
    }

    public final String component2() {
        return this.originAiProductInfo;
    }

    public final String component3() {
        return this.preAiPageType;
    }

    public final ECAiSearchExtra copy(Map<String, ? extends Object> r100, String r101, String r102) {
        return new ECAiSearchExtra(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAiSearchExtra) == false) goto L12;
        ECAiSearchExtra r101 = (ECAiSearchExtra) r100;
        if (Intrinsics.areEqual(this.extraRequestParams, r101.extraRequestParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originAiProductInfo, r101.originAiProductInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preAiPageType, r101.preAiPageType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Map<String, ? extends Object> r100 = this.extraRequestParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.originAiProductInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.preAiPageType;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECAiSearchExtra(extraRequestParams=" + this.extraRequestParams + ", originAiProductInfo=" + this.originAiProductInfo + ", preAiPageType=" + this.preAiPageType + ")";
    }

    public final Map<String, Object> getExtraRequestParams() {
        return this.extraRequestParams;
    }

    public final String getOriginAiProductInfo() {
        return this.originAiProductInfo;
    }

    public final String getPreAiPageType() {
        return this.preAiPageType;
    }

    public final void setExtraRequestParams(Map<String, ? extends Object> r100) {
        this.extraRequestParams = r100;
    }

    public final void setOriginAiProductInfo(String r100) {
        this.originAiProductInfo = r100;
    }

    public final void setPreAiPageType(String r100) {
        this.preAiPageType = r100;
    }

    public ECAiSearchExtra(Map<String, ? extends Object> r100, String r101, String r102) {
        this.extraRequestParams = r100;
        this.originAiProductInfo = r101;
        this.preAiPageType = r102;
    }

    public /* synthetic */ ECAiSearchExtra(Map r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
