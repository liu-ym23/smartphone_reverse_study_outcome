package com.bytedance.android.shopping.mall.feed.holder;

import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010MR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R4\u00101\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\b¨\u0006N"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallPlaceholderCardVO;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getDeliverySessionId", "()Ljava/lang/String;", "setDeliverySessionId", "(Ljava/lang/String;)V", "deliverySessionId", "", "b", "Ljava/lang/Integer;", "getBackgroundResId", "()Ljava/lang/Integer;", "setBackgroundResId", "(Ljava/lang/Integer;)V", "backgroundResId", "", "c", "Ljava/lang/Float;", "getBackgroundResIdRatio", "()Ljava/lang/Float;", "setBackgroundResIdRatio", "(Ljava/lang/Float;)V", "backgroundResIdRatio", "d", "getBackgroundUrl", "setBackgroundUrl", "backgroundUrl", "e", "getBackgroundUrlRatio", "setBackgroundUrlRatio", "backgroundUrlRatio", "Lkotlin/Pair;", "f", "Lkotlin/Pair;", "getBackgroundResIdPair", "()Lkotlin/Pair;", "setBackgroundResIdPair", "(Lkotlin/Pair;)V", "backgroundResIdPair", "g", "getBackgroundResIdRatioPair", "setBackgroundResIdRatioPair", "backgroundResIdRatioPair", "h", "getBackgroundUrlPair", "setBackgroundUrlPair", "backgroundUrlPair", "i", "getBackgroundUrlRatioPair", "setBackgroundUrlRatioPair", "backgroundUrlRatioPair", "", "j", "Z", "getShouldNotifyDelivery", "()Z", "setShouldNotifyDelivery", "(Z)V", "shouldNotifyDelivery", "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "k", "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "getReduceConfig", "()Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "setReduceConfig", "(Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;)V", "reduceConfig", "cover", "getCover", "setCover", "schema", "getSchema", "setSchema", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallPlaceholderCardVO implements Serializable {
    public transient String a;
    public transient Integer b;
    public transient Float c;

    @SerializedName("cover")
    private String cover;
    public transient String d;
    public transient Float e;
    public transient Pair<Integer, Integer> f;
    public transient Pair<Float, Float> g;
    public transient Pair<String, String> h;
    public transient Pair<Float, Float> i;
    public transient boolean j;
    public transient ECMallDeliveryReduceConfig k;

    @SerializedName("schema")
    private String schema;

    public ECMallPlaceholderCardVO() {
    }

    public final Integer getBackgroundResId() {
        return this.b;
    }

    public final Pair<Integer, Integer> getBackgroundResIdPair() {
        return this.f;
    }

    public final Float getBackgroundResIdRatio() {
        return this.c;
    }

    public final Pair<Float, Float> getBackgroundResIdRatioPair() {
        return this.g;
    }

    public final String getBackgroundUrl() {
        return this.d;
    }

    public final Pair<String, String> getBackgroundUrlPair() {
        return this.h;
    }

    public final Float getBackgroundUrlRatio() {
        return this.e;
    }

    public final Pair<Float, Float> getBackgroundUrlRatioPair() {
        return this.i;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDeliverySessionId() {
        return this.a;
    }

    public final ECMallDeliveryReduceConfig getReduceConfig() {
        return this.k;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getShouldNotifyDelivery() {
        return this.j;
    }

    public final void setBackgroundResId(Integer r1) {
        this.b = r1;
    }

    public final void setBackgroundResIdPair(Pair<Integer, Integer> r1) {
        this.f = r1;
    }

    public final void setBackgroundResIdRatio(Float r1) {
        this.c = r1;
    }

    public final void setBackgroundResIdRatioPair(Pair<Float, Float> r1) {
        this.g = r1;
    }

    public final void setBackgroundUrl(String r1) {
        this.d = r1;
    }

    public final void setBackgroundUrlPair(Pair<String, String> r1) {
        this.h = r1;
    }

    public final void setBackgroundUrlRatio(Float r1) {
        this.e = r1;
    }

    public final void setBackgroundUrlRatioPair(Pair<Float, Float> r1) {
        this.i = r1;
    }

    public final void setCover(String r1) {
        this.cover = r1;
    }

    public final void setDeliverySessionId(String r1) {
        this.a = r1;
    }

    public final void setReduceConfig(ECMallDeliveryReduceConfig r1) {
        this.k = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setShouldNotifyDelivery(boolean r1) {
        this.j = r1;
    }
}
