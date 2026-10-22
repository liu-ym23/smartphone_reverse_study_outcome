package com.bytedance.android.livesdk.livecommerce.intro.model.vo;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.TrackEventType;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.j0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ql.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\b\b\u0002\u0010n\u001a\u000203¢\u0006\u0004\bo\u0010eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016R\u001a\u0010\u001f\u001a\u00020\u00178\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/\"\u0004\b<\u00101R2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010-\u001a\u0004\b>\u0010/\"\u0004\b?\u00101R$\u0010@\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0019\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010`\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010a\u001a\u0004\bg\u0010c\"\u0004\bh\u0010eR\"\u0010i\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010a\u001a\u0004\bj\u0010c\"\u0004\bk\u0010eR\u0017\u0010l\u001a\u0002038\u0006¢\u0006\f\n\u0004\bl\u0010a\u001a\u0004\bm\u0010cR\u0014\u0010n\u001a\u0002038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bn\u0010a¨\u0006p"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroAuctionPromotionVO;", "Lql/a;", "Luh2/a;", "Ljava/io/Serializable;", "", "getCover", "cover", "", "setCover", "getTitle", "title", "setTitle", LocationMonitorConst.TAG, "", "containsIconTag", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "hotAtmosphere", "updateHotAtmosphere", "getLabelNameLive", "isLottery", "getPrice", "isPreSale", "isCrossborderProduct", "", "getCampainExtraType", "()Ljava/lang/Integer;", "canShowAddCart", "isFlash", "getEcomGoodsStatus", "isAuction", "isAuctionV2", "introType", "I", "getIntroType", "()I", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "control", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "getControl", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "setControl", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;)V", "", "", "rawData", "Ljava/util/Map;", "getRawData", "()Ljava/util/Map;", "setRawData", "(Ljava/util/Map;)V", "", "", "durations", "Ljava/util/List;", "getDurations", "()Ljava/util/List;", "setDurations", "(Ljava/util/List;)V", "uiFrame", "getUiFrame", "setUiFrame", "uiFrameV2", "getUiFrameV2", "setUiFrameV2", "cardType", "Ljava/lang/Integer;", "getCardType", "setCardType", "(Ljava/lang/Integer;)V", "uiTemplate", "Ljava/lang/String;", "getUiTemplate", "()Ljava/lang/String;", "setUiTemplate", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "getProduct", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "setProduct", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "track", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "setTrack", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "cardReqScene", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "getCardReqScene", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "setCardReqScene", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;)V", "exposureTime", "J", "getExposureTime", "()J", "setExposureTime", "(J)V", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "auctionEndTime", "getAuctionEndTime", "setAuctionEndTime", "currentTime", "getCurrentTime", "currentTimeStamp", "<init>", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroAuctionPromotionVO extends a implements uh2.a, Serializable {
    private long auctionEndTime;
    private IntroCardScene cardReqScene;
    private Integer cardType;
    private s0 control;
    private final long currentTime;

    @SerializedName("current_time_stamp")
    private final long currentTimeStamp;
    private List<Long> durations;
    private long exposureTime;
    private final int introType;
    private IntroProduct product;
    private Map<String, ? extends Object> rawData;
    private long showTimestamp;
    private j0 track;
    private Map<String, ? extends Object> uiFrame;
    private Map<String, ? extends Object> uiFrameV2;
    private String uiTemplate;

    public IntroAuctionPromotionVO() {
        long r2 = 0;
        this(r2, 1, null);
    }

    public boolean canShowAddCart() {
        return false;
    }

    public boolean containsIconTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        return false;
    }

    public String getCover() {
        return "";
    }

    public String getPrice() {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public void setCover(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cover");
    }

    public void setTitle(String r1) {
    }

    public String getLabelNameLive() {
        HashSet r0 = new HashSet();
        Map r1 = getRitTag();
        if (r1 == null) goto L12;
        List r2 = (List) r1.get("live_room_good_list_user_right");
        if (r2 == null) goto L12;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        ECRitTag r4 = (ECRitTag) r3.next();
        if (TextUtils.isEmpty(r4.getLabelName()) == true) goto L8;
        addTagToSet(r0, r4.getLabelName());
    L12:
        Map r5 = getRitTag();
        if (r5 == null) goto L22;
        List r6 = (List) r5.get("live_room_good_list_stimulate");
        if (r6 == null) goto L22;
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        ECRitTag r8 = (ECRitTag) r7.next();
        if (TextUtils.isEmpty(r8.getLabelName()) == true) goto L18;
        addTagToSet(r0, r8.getLabelName());
    L22:
        Map r9 = getRitTag();
        if (r9 == null) goto L33;
        List r10 = (List) r9.get("live_room_product_title_before");
        if (r10 == null) goto L33;
        Iterator r11 = r10.iterator();
    L28:
        if (r11.hasNext() == false) goto L33;
        ECRitTag r12 = (ECRitTag) r11.next();
        if (TextUtils.isEmpty(r12.getLabelName()) == true) goto L28;
        addTagToSet(r0, r12.getLabelName());
    L33:
        if (TextUtils.isEmpty(getLiveLabelNameFromEventParams()) == true) goto L37;
        String r13 = getLiveLabelNameFromEventParams();
        if (r13 == null) goto L37;
        addTagToSet(r0, r13);
    L37:
        Map r14 = getEventParams();
        if (r14 == null) goto L55;
        String r15 = (String) r14.get("label_name_live");
        if (r15 == null) goto L55;
        List r16 = StringsKt.split$default(StringsKt.removeSurrounding(r15, "[", "]"), new String[]{","}, false, 0, 6, null);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L43:
        if (r18.hasNext() == false) goto L50;
        Object r19 = r18.next();
        if (((String) r19).length() <= 0) goto L47;
        boolean r20 = true;
    L48:
        if (r20 == false) goto L43;
        r17.add(r19);
        goto L43
    L47:
        r20 = false;
        goto L48
    L50:
        Iterator r21 = r17.iterator();
    L52:
        if (r21.hasNext() == false) goto L55;
        r0.add((String) r21.next());
    L55:
        return tagSetToString(r0);
    }

    public boolean isAuction() {
        IntroProduct r0 = this.product;
        if (r0 != null) goto L5;
    L6:
        IntroProduct r1 = this.product;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.e() != 2) goto L11;
        return true;
    L5:
        if (r0.e() != 1) goto L6;
        return true;
    }

    public boolean isAuctionV2() {
        IntroProduct r0 = this.product;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() != 1) goto L7;
        return true;
    }

    public boolean isLottery() {
        j0 r0 = this.track;
        if (r0 == null) goto L5;
        TrackEventType r1 = r0.b();
    L7:
        if (r1 != TrackEventType.UnRecProduct) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public Integer getCampainExtraType() {
        Map r0 = getEventParams();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("campaign_extra_type");
        if (r1 == null) goto L7;
        return Integer.valueOf(CastIntegerProtector.parseInt(r1));
    L7:
        return null;
    }

    public int getEcomGoodsStatus() {
        Map r0 = getEventParams();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("ecom_goods_status");
        if (r1 == null) goto L7;
        return CastIntegerProtector.parseInt(r1);
    L7:
        return 0;
    }

    public boolean isCrossborderProduct() {
        Map r0 = getEventParams();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("is_crossborder_goods");
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public boolean isFlash() {
        Map r0 = getEventParams();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("live_product_type");
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public boolean isPreSale() {
        Map r0 = getEventParams();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("upfront_presell");
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public final long getAuctionEndTime() {
        return this.auctionEndTime;
    }

    public final IntroCardScene getCardReqScene() {
        return this.cardReqScene;
    }

    public final Integer getCardType() {
        return this.cardType;
    }

    @Override // uh2.a
    public s0 getControl() {
        return this.control;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final List<Long> getDurations() {
        return this.durations;
    }

    public final long getExposureTime() {
        return this.exposureTime;
    }

    @Override // uh2.a
    public int getIntroType() {
        return this.introType;
    }

    public final IntroProduct getProduct() {
        return this.product;
    }

    public final Map<String, Object> getRawData() {
        return this.rawData;
    }

    public final long getShowTimestamp() {
        return this.showTimestamp;
    }

    public final j0 getTrack() {
        return this.track;
    }

    public final Map<String, Object> getUiFrame() {
        return this.uiFrame;
    }

    public final Map<String, Object> getUiFrameV2() {
        return this.uiFrameV2;
    }

    public final String getUiTemplate() {
        return this.uiTemplate;
    }

    public IntroAuctionPromotionVO(long r2) {
        this.currentTimeStamp = r2;
        this.introType = 2;
        this.currentTime = r2;
    }

    public final void setAuctionEndTime(long r1) {
        this.auctionEndTime = r1;
    }

    public final void setCardReqScene(IntroCardScene r1) {
        this.cardReqScene = r1;
    }

    public final void setCardType(Integer r1) {
        this.cardType = r1;
    }

    public void setControl(s0 r1) {
        this.control = r1;
    }

    public final void setDurations(List<Long> r1) {
        this.durations = r1;
    }

    public final void setExposureTime(long r1) {
        this.exposureTime = r1;
    }

    public final void setProduct(IntroProduct r1) {
        this.product = r1;
    }

    public final void setRawData(Map<String, ? extends Object> r1) {
        this.rawData = r1;
    }

    public final void setShowTimestamp(long r1) {
        this.showTimestamp = r1;
    }

    public final void setTrack(j0 r1) {
        this.track = r1;
    }

    public final void setUiFrame(Map<String, ? extends Object> r1) {
        this.uiFrame = r1;
    }

    public final void setUiFrameV2(Map<String, ? extends Object> r1) {
        this.uiFrameV2 = r1;
    }

    public final void setUiTemplate(String r1) {
        this.uiTemplate = r1;
    }

    public void updateHotAtmosphere(ECHotAtmosphere r1) {
        setHotAtmosphere(r1);
    }

    public /* synthetic */ IntroAuctionPromotionVO(long r1, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = System.currentTimeMillis();
    L5:
        this(r1);
    }
}
