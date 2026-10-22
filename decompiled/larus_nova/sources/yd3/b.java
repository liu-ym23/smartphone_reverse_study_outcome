package yd3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u001c\u0010#\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014¨\u0006'"}, d2 = {"Lyd3/b;", "Lyd3/l;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "expireImg", ce.f26391f, "", "price", "Ljava/lang/Long;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Long;", "setPrice", "(Ljava/lang/Long;)V", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "f", "()Ljava/lang/String;", "subDesc", ce.f26395j, "Lyd3/g;", "linkInfo", "Lyd3/g;", "h", "()Lyd3/g;", "Lyd3/s;", "timeInfo", "Lyd3/s;", ce.f26396k, "()Lyd3/s;", "couponId", "e", "bsk", "d", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends l {

    @SerializedName("bg_img")
    private final ECUrlModel bgUrl;

    @SerializedName("bsk")
    private final String bsk;

    @SerializedName("id")
    private final String couponId;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("expire_img")
    private final ECUrlModel expireImg;

    @SerializedName("link_info")
    private final g linkInfo;

    @SerializedName("price")
    private Long price;

    @SerializedName("sub_desc")
    private final String subDesc;

    @SerializedName("time_info")
    private final s timeInfo;

    public b() {
    }

    public final ECUrlModel c() {
        return this.bgUrl;
    }

    public final String d() {
        return this.bsk;
    }

    public final String e() {
        return this.couponId;
    }

    public final String f() {
        return this.desc;
    }

    public final ECUrlModel g() {
        return this.expireImg;
    }

    public final g h() {
        return this.linkInfo;
    }

    public final Long i() {
        return this.price;
    }

    public final String j() {
        return this.subDesc;
    }

    public final s k() {
        return this.timeInfo;
    }
}
