package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018¨\u0006!"}, d2 = {"Lyd3/m;", "Lyd3/l;", "", "panelLayoutMode", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "promotions", "Ljava/util/List;", "h", "()Ljava/util/List;", "i", "(Ljava/util/List;)V", "Lyd3/c;", "decoration", "Lyd3/c;", "e", "()Lyd3/c;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "background", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "priceImg", "g", "descImg", "getDescImg", "creditImg", "d", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m extends l {

    @SerializedName("background")
    private final ECUrlModel background;

    @SerializedName("credit_img")
    private final ECUrlModel creditImg;

    @SerializedName("decoration")
    private final c decoration;

    @SerializedName("descImg")
    private final ECUrlModel descImg;

    @SerializedName("layout")
    private final Integer panelLayoutMode;

    @SerializedName("price_img")
    private final ECUrlModel priceImg;

    @SerializedName("promotions")
    private List<Promotion> promotions;

    public m() {
    }

    public final ECUrlModel c() {
        return this.background;
    }

    public final ECUrlModel d() {
        return this.creditImg;
    }

    public final c e() {
        return this.decoration;
    }

    public final Integer f() {
        return this.panelLayoutMode;
    }

    public final ECUrlModel g() {
        return this.priceImg;
    }

    public final List<Promotion> h() {
        return this.promotions;
    }

    public final void i(List<Promotion> r1) {
        this.promotions = r1;
    }
}
