package com.bytedance.android.shopping.store.moments.dto.card;

import com.bytedance.android.ec.store.repository.dto.l;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\"\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R2\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R2\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101¨\u00067"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/card/ShortVideoDTO;", "Ljava/io/Serializable;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "", "modelType", "", "titleText", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/store/repository/dto/l;", "product", "Lcom/bytedance/android/ec/store/repository/dto/l;", "getProduct", "()Lcom/bytedance/android/ec/store/repository/dto/l;", "setProduct", "(Lcom/bytedance/android/ec/store/repository/dto/l;)V", "feedData", "getFeedData", "setFeedData", "momentTime", "getMomentTime", "setMomentTime", "momentId", "I", "getMomentId", "()I", "momentIdStr", "getMomentIdStr", "setMomentIdStr", "momentType", "getMomentType", "setMomentType", "(I)V", "", "autoPlay", "Z", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "", "bizExtra", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "logExtra", "getLogExtra", "setLogExtra", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortVideoDTO implements Serializable, QModel {

    @SerializedName("auto_play")
    private boolean autoPlay;

    @SerializedName("biz_extra")
    private Map<String, String> bizExtra;

    @SerializedName("feed_data")
    private String feedData;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;
    private final int momentId;

    @SerializedName("moment_id_str")
    private String momentIdStr;

    @SerializedName("moment_time")
    private String momentTime;

    @SerializedName("moment_type")
    private int momentType;

    @SerializedName("product")
    private l product;

    @SerializedName("title_text")
    private String titleText;

    public int modelType() {
        return 1;
    }

    public ShortVideoDTO() {
        this.momentId = hashCode();
        this.autoPlay = true;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final String getFeedData() {
        return this.feedData;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final int getMomentId() {
        return this.momentId;
    }

    public final String getMomentIdStr() {
        return this.momentIdStr;
    }

    public final String getMomentTime() {
        return this.momentTime;
    }

    public final int getMomentType() {
        return this.momentType;
    }

    public final l getProduct() {
        return this.product;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setAutoPlay(boolean r1) {
        this.autoPlay = r1;
    }

    public final void setBizExtra(Map<String, String> r1) {
        this.bizExtra = r1;
    }

    public final void setFeedData(String r1) {
        this.feedData = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setMomentIdStr(String r1) {
        this.momentIdStr = r1;
    }

    public final void setMomentTime(String r1) {
        this.momentTime = r1;
    }

    public final void setMomentType(int r1) {
        this.momentType = r1;
    }

    public final void setProduct(l r1) {
        this.product = r1;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
    }
}
