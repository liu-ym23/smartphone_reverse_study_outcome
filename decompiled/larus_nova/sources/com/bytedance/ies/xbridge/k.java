package com.bytedance.ies.xbridge;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/ies/xbridge/k;", "", "", "mode", "Ljava/lang/Integer;", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "position", "getPosition", "setPosition", "", "after_follow", "Ljava/lang/Boolean;", "getAfter_follow", "()Ljava/lang/Boolean;", "setAfter_follow", "(Ljava/lang/Boolean;)V", "", "source_page", "Ljava/lang/String;", "getSource_page", "()Ljava/lang/String;", "setSource_page", "(Ljava/lang/String;)V", ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, "getApply_source", "setApply_source", "click_source", "getClick_source", "setClick_source", "paid_count", "c", "setPaid_count", "limit_time", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLimit_time", "reason", "d", "setReason", "use_member_benefits", "e", "setUse_member_benefits", "member_discount_amount", "b", "setMember_discount_amount", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k {

    @SerializedName("after_follow")
    private Boolean after_follow;

    @SerializedName(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE)
    private Integer apply_source;

    @SerializedName("click_source")
    private String click_source;

    @SerializedName("limit_time")
    private Integer limit_time;

    @SerializedName("member_discount_amount")
    private Integer member_discount_amount;

    @SerializedName("mode")
    private Integer mode;

    @SerializedName("paid_count")
    private Integer paid_count;

    @SerializedName("position")
    private Integer position;

    @SerializedName("reason")
    private String reason;

    @SerializedName("source_page")
    private String source_page;

    @SerializedName("use_member_benefits")
    private Boolean use_member_benefits;

    public k() {
    }

    public final Integer a() {
        return this.limit_time;
    }

    public final Integer b() {
        return this.member_discount_amount;
    }

    public final Integer c() {
        return this.paid_count;
    }

    public final String d() {
        return this.reason;
    }

    public final Boolean e() {
        return this.use_member_benefits;
    }
}
