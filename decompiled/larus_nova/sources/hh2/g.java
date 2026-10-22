package hh2;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import el2.o;
import kotlin.Metadata;
import sg2.x;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b9\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00104\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR$\u00107\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR$\u0010:\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR$\u0010=\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000f¨\u0006B"}, d2 = {"Lhh2/g;", "", "", "host", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "", "needAdOpenId", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "B", "(Ljava/lang/Boolean;)V", "isSaasMessageCheck", "p", ExifInterface.LONGITUDE_EAST, "eventNamePrefix", "f", "w", "localSpFileName", RXScreenCaptureService.KEY_INDEX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "enableFastEntry", "e", BaseSwitches.V, "useSaasStartLiveStrategy", "m", FaceService.neutralLabel, "useSaasUrl", OfficeSDKRequestTag.KEY_NEW_USER, "I", "enableAuthorDetailPage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "r", "enableCardOpt", "b", "s", "enableDeviceDegrade", "d", "u", "isPreloadGeckoChannel", "o", "D", "isToBSaaSCoupon", "q", "G", "enableDetailLiveDegrade", "c", "t", "forceUseShoppingPlayback", ce.f26391f, "x", "saasUseAuthorOpenId", "l", FaceService.girlLabel, "playbackJustUseTTVideoEngine", ce.f26396k, "C", "loadShopVip", "getLoadShopVip", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient x f485168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient o f485169b;

    @SerializedName("enable_author_detail_page")
    private Boolean enableAuthorDetailPage;

    @SerializedName("enable_card_opt")
    private Boolean enableCardOpt;

    @SerializedName("enable_detail_live_degrade")
    private Boolean enableDetailLiveDegrade;

    @SerializedName("enable_device_degrade")
    private Boolean enableDeviceDegrade;

    @SerializedName("enable_fast_entry")
    private Boolean enableFastEntry;

    @SerializedName("event_prefix")
    private String eventNamePrefix;

    @SerializedName("force_use_shopping_playback")
    private Boolean forceUseShoppingPlayback;

    @SerializedName("host")
    private String host;

    @SerializedName("is_preload_gecko_channel")
    private Boolean isPreloadGeckoChannel;

    @SerializedName("is_saas_message_check")
    private Boolean isSaasMessageCheck;

    @SerializedName("is_tob_saas_coupon")
    private Boolean isToBSaaSCoupon;

    @SerializedName("load_shop_vip")
    private Boolean loadShopVip;

    @SerializedName("local_sp_file_name")
    private String localSpFileName;

    @SerializedName("need_ad_open_id")
    private Boolean needAdOpenId;

    @SerializedName("playback_just_use_tt_video_engine")
    private Boolean playbackJustUseTTVideoEngine;

    @SerializedName("saas_use_author_open_id")
    private Boolean saasUseAuthorOpenId;

    @SerializedName("use_saas_start_live_strategy")
    private Boolean useSaasStartLiveStrategy;

    @SerializedName("use_saas_url")
    private Boolean useSaasUrl;

    public g() {
    }

    public final String toString() {
        return super.toString();
    }

    public final Boolean a() {
        return this.enableAuthorDetailPage;
    }

    public final Boolean b() {
        return this.enableCardOpt;
    }

    public final Boolean c() {
        return this.enableDetailLiveDegrade;
    }

    public final Boolean d() {
        return this.enableDeviceDegrade;
    }

    public final Boolean e() {
        return this.enableFastEntry;
    }

    public final String f() {
        return this.eventNamePrefix;
    }

    public final Boolean g() {
        return this.forceUseShoppingPlayback;
    }

    public final String h() {
        return this.host;
    }

    public final String i() {
        return this.localSpFileName;
    }

    public final Boolean j() {
        return this.needAdOpenId;
    }

    public final Boolean k() {
        return this.playbackJustUseTTVideoEngine;
    }

    public final Boolean l() {
        return this.saasUseAuthorOpenId;
    }

    public final Boolean m() {
        return this.useSaasStartLiveStrategy;
    }

    public final Boolean n() {
        return this.useSaasUrl;
    }

    public final Boolean o() {
        return this.isPreloadGeckoChannel;
    }

    public final Boolean p() {
        return this.isSaasMessageCheck;
    }

    public final Boolean q() {
        return this.isToBSaaSCoupon;
    }

    public final void A(String r100) {
        this.localSpFileName = r100;
    }

    public final void B(Boolean r100) {
        this.needAdOpenId = r100;
    }

    public final void C(Boolean r100) {
        this.playbackJustUseTTVideoEngine = r100;
    }

    public final void D(Boolean r100) {
        this.isPreloadGeckoChannel = r100;
    }

    public final void E(Boolean r100) {
        this.isSaasMessageCheck = r100;
    }

    public final void F(Boolean r100) {
        this.saasUseAuthorOpenId = r100;
    }

    public final void G(Boolean r100) {
        this.isToBSaaSCoupon = r100;
    }

    public final void H(Boolean r100) {
        this.useSaasStartLiveStrategy = r100;
    }

    public final void I(Boolean r100) {
        this.useSaasUrl = r100;
    }

    public final void r(Boolean r100) {
        this.enableAuthorDetailPage = r100;
    }

    public final void s(Boolean r100) {
        this.enableCardOpt = r100;
    }

    public final void t(Boolean r100) {
        this.enableDetailLiveDegrade = r100;
    }

    public final void u(Boolean r100) {
        this.enableDeviceDegrade = r100;
    }

    public final void v(Boolean r100) {
        this.enableFastEntry = r100;
    }

    public final void w(String r100) {
        this.eventNamePrefix = r100;
    }

    public final void x(Boolean r100) {
        this.forceUseShoppingPlayback = r100;
    }

    public final void y(String r100) {
        this.host = r100;
    }

    public final void z(Boolean r100) {
        this.loadShopVip = r100;
    }
}
