package yd3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\f)B\u0007¢\u0006\u0004\b[\u0010\\R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010\u0014\u001a\u0004\bL\u0010\u0016R\u001c\u0010M\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010\u0014\u001a\u0004\bN\u0010\u0016R\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010U\u001a\u0004\u0018\u00010T8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010T8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010X¨\u0006]"}, d2 = {"Lyd3/p;", "", "", "type", "I", "getType", "()I", "position", "m", "t", "(I)V", "abvpos", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "schema", "Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "e", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lyd3/f;", "headerNode", "Lyd3/f;", "h", "()Lyd3/f;", "Lyd3/m;", "panelsNode", "Lyd3/m;", "l", "()Lyd3/m;", "Lyd3/r;", "shopNode", "Lyd3/r;", "p", "()Lyd3/r;", "Lyd3/a;", "buttonNode", "Lyd3/a;", "b", "()Lyd3/a;", "Lyd3/k;", "lynxNode", "Lyd3/k;", ce.f26396k, "()Lyd3/k;", "Lyd3/h;", "listNode", "Lyd3/h;", RXScreenCaptureService.KEY_INDEX, "()Lyd3/h;", "Lyd3/b;", "couponNode", "Lyd3/b;", "d", "()Lyd3/b;", "Lyd3/q;", "searchNode", "Lyd3/q;", "o", "()Lyd3/q;", "Lyd3/u;", "windowNode", "Lyd3/u;", "r", "()Lyd3/u;", "Lyd3/p$b;", "extra", "Lyd3/p$b;", ce.f26391f, "()Lyd3/p$b;", "s", "(Lyd3/p$b;)V", "priceImg", "getPriceImg", "bigImg", "getBigImg", "Lyd3/i;", "lynxCommonCard", "Lyd3/i;", ce.f26395j, "()Lyd3/i;", "Lyd3/d;", "showFreqInfo", "Lyd3/d;", "q", "()Lyd3/d;", "clickFreqInfo", "c", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f567303a;

    @SerializedName("abvpos")
    private final int abvpos;

    @SerializedName("big_img")
    private final ECUrlModel bigImg;

    @SerializedName("button_node")
    private final yd3.a buttonNode;

    @SerializedName("click_frequency_control")
    private final d clickFreqInfo;

    @SerializedName("coupon_node")
    private final yd3.b couponNode;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("extra")
    private b extra;

    @SerializedName("header_node")
    private final f headerNode;

    @SerializedName("list_node")
    private final h listNode;

    @SerializedName("lynx_common_card")
    private final i lynxCommonCard;

    @SerializedName("lynx_node")
    private final k lynxNode;

    @SerializedName("panels_node")
    private final m panelsNode;

    @SerializedName("position")
    private int position;

    @SerializedName("price_img")
    private final ECUrlModel priceImg;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("search_node")
    private final q searchNode;

    @SerializedName("shop_node")
    private final r shopNode;

    @SerializedName("show_frequency_control")
    private final d showFreqInfo;

    @SerializedName("type")
    private final int type;

    @SerializedName("window_node")
    private final u windowNode;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lyd3/p$b;", "", "", "sessionTime", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSessionTime", "(Ljava/lang/String;)V", "noFrequencyControl", "b", "setNoFrequencyControl", "resourceId", "c", "mallEnterFrom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("mall_enter_from")
        private final String mallEnterFrom;

        @SerializedName("no_frequency_control")
        private String noFrequencyControl;

        @SerializedName("resource_id")
        private final String resourceId;

        @SerializedName("session_time")
        private String sessionTime;

        public b() {
        }

        public final String a() {
            return this.mallEnterFrom;
        }

        public final String b() {
            return this.noFrequencyControl;
        }

        public final String c() {
            return this.resourceId;
        }

        public final String d() {
            return this.sessionTime;
        }
    }

    static {
    }

    public final String f() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        return "store_card";
    L5:
        if (r100 != 2) goto L7;
        return "rank_card";
    L7:
        if (r100 != 3) goto L9;
        return "channel_card";
    L9:
        if (r100 != 4) goto L11;
        return AnchorBenefitToast.TYPE_COUPON;
    L11:
        if (r100 != 6) goto L13;
        return "new_channel";
    L13:
        if (r100 != 7) goto L15;
        return "big_sale";
    L15:
        if (r100 == 20) goto L17;
        return "";
    L17:
        return "legou_guide";
    }

    public p() {
        this.f567303a = -1;
    }

    public final int a() {
        return this.abvpos;
    }

    public final yd3.a b() {
        return this.buttonNode;
    }

    public final d c() {
        return this.clickFreqInfo;
    }

    public final yd3.b d() {
        return this.couponNode;
    }

    public final ECUrlModel e() {
        return this.cover;
    }

    public final b g() {
        return this.extra;
    }

    public final int getType() {
        return this.type;
    }

    public final f h() {
        return this.headerNode;
    }

    public final h i() {
        return this.listNode;
    }

    public final i j() {
        return this.lynxCommonCard;
    }

    public final k k() {
        return this.lynxNode;
    }

    public final m l() {
        return this.panelsNode;
    }

    public final int m() {
        return this.position;
    }

    public final String n() {
        return this.schema;
    }

    public final q o() {
        return this.searchNode;
    }

    public final r p() {
        return this.shopNode;
    }

    public final d q() {
        return this.showFreqInfo;
    }

    public final u r() {
        return this.windowNode;
    }

    public final void s(b r100) {
        this.extra = r100;
    }

    public final void t(int r100) {
        this.position = r100;
    }
}
