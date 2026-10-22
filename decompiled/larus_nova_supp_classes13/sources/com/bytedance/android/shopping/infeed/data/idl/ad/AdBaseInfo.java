package com.bytedance.android.shopping.infeed.data.idl.ad;

import com.bytedance.android.shopping.anchorv3.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR$\u0010(\u001a\u0004\u0018\u00010'8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00138F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;", "Ljava/io/Serializable;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "showAdTag", "Z", "getShowAdTag", "()Z", "setShowAdTag", "(Z)V", "adPackCell", "getAdPackCell", "setAdPackCell", "", "adSource", "Ljava/lang/Integer;", "getAdSource", "()Ljava/lang/Integer;", "setAdSource", "(Ljava/lang/Integer;)V", "isFromOuter", "setFromOuter", "isSameRit", "setSameRit", "creativeId", "getCreativeId", "setCreativeId", "groupId", "getGroupId", "setGroupId", "logExtra", "getLogExtra", "setLogExtra", "Lorg/json/JSONObject;", "adOpenUrlParams", "Lorg/json/JSONObject;", "getAdOpenUrlParams", "()Lorg/json/JSONObject;", "setAdOpenUrlParams", "(Lorg/json/JSONObject;)V", "pricingType", "getPricingType", "setPricingType", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdBaseInfo implements Serializable {
    private JSONObject adOpenUrlParams;

    @SerializedName("AdPackCell")
    private String adPackCell;

    @SerializedName("ad_source")
    private Integer adSource;
    private String creativeId;
    private String groupId;

    @SerializedName("id")
    private String id;
    private boolean isFromOuter;
    private boolean isSameRit;
    private String logExtra;
    private Integer pricingType;

    @SerializedName("show_ad_tag")
    private boolean showAdTag;

    public final JSONObject a() {
        if (a.b(this.adPackCell) == true) goto L17;
    L8:
        JSONObject r2 = null;
    L9:
        if (r2 != null) goto L11;
        return null;
    L11:
        if (r2.has("raw_ad_data") == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L16;
        return null;
    L16:
        return r2.optJSONObject("raw_ad_data");
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        r2 = new JSONObject(new JSONObject(this.adPackCell).optString("raw_data"));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONObject getAdOpenUrlParams() {
        JSONObject r0 = this.adOpenUrlParams;
        if (r0 != null) goto L11;
        JSONObject r1 = a();
        JSONObject r2 = null;
        if (r1 == null) goto L9;
        JSONObject r3 = r1.optJSONObject("ad_open_url_params");
        if (r3 == null) goto L9;
        r2 = r3.optJSONObject("meta_params");
    L9:
        JSONObject r4 = r2;
        this.adOpenUrlParams = r4;
        return r4;
    L11:
        return r0;
    }

    public final String getCreativeId() {
        String r0 = this.creativeId;
        if (r0 != null) goto L9;
        JSONObject r1 = a();
        if (r1 == null) goto L7;
        r0 = r1.optString("creative_id");
    L8:
        this.creativeId = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final String getGroupId() {
        String r0 = this.groupId;
        if (r0 != null) goto L9;
        JSONObject r1 = a();
        if (r1 == null) goto L7;
        r0 = r1.optString("group_id");
    L8:
        this.groupId = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final String getLogExtra() {
        String r0 = this.logExtra;
        if (r0 != null) goto L9;
        JSONObject r1 = a();
        if (r1 == null) goto L7;
        r0 = r1.optString("log_extra");
    L8:
        this.logExtra = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final Integer getPricingType() {
        Integer r0 = this.pricingType;
        if (r0 != null) goto L9;
        JSONObject r1 = a();
        if (r1 == null) goto L7;
        r0 = Integer.valueOf(r1.optInt("pricing_type"));
    L8:
        this.pricingType = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public AdBaseInfo() {
        this.adSource = 0;
    }

    public final String getAdPackCell() {
        return this.adPackCell;
    }

    public final Integer getAdSource() {
        return this.adSource;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getShowAdTag() {
        return this.showAdTag;
    }

    public final boolean isFromOuter() {
        return this.isFromOuter;
    }

    public final boolean isSameRit() {
        return this.isSameRit;
    }

    public final void setAdOpenUrlParams(JSONObject r1) {
        this.adOpenUrlParams = r1;
    }

    public final void setAdPackCell(String r1) {
        this.adPackCell = r1;
    }

    public final void setAdSource(Integer r1) {
        this.adSource = r1;
    }

    public final void setCreativeId(String r1) {
        this.creativeId = r1;
    }

    public final void setFromOuter(boolean r1) {
        this.isFromOuter = r1;
    }

    public final void setGroupId(String r1) {
        this.groupId = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLogExtra(String r1) {
        this.logExtra = r1;
    }

    public final void setPricingType(Integer r1) {
        this.pricingType = r1;
    }

    public final void setSameRit(boolean r1) {
        this.isSameRit = r1;
    }

    public final void setShowAdTag(boolean r1) {
        this.showAdTag = r1;
    }
}
