package hh2;

import com.google.gson.annotations.SerializedName;
import el2.o;
import kotlin.Metadata;
import sg2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b9\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00104\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR$\u00107\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR$\u0010:\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR$\u0010=\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000f¨\u0006B"}, d2 = {"Lhh2/g;", "", "", "host", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "", "needAdOpenId", "Ljava/lang/Boolean;", "j", "()Ljava/lang/Boolean;", "B", "(Ljava/lang/Boolean;)V", "isSaasMessageCheck", "p", "E", "eventNamePrefix", "f", "w", "localSpFileName", "i", "A", "enableFastEntry", "e", "v", "useSaasStartLiveStrategy", "m", "H", "useSaasUrl", "n", "I", "enableAuthorDetailPage", "a", "r", "enableCardOpt", "b", "s", "enableDeviceDegrade", "d", "u", "isPreloadGeckoChannel", "o", "D", "isToBSaaSCoupon", "q", "G", "enableDetailLiveDegrade", "c", "t", "forceUseShoppingPlayback", "g", "x", "saasUseAuthorOpenId", "l", "F", "playbackJustUseTTVideoEngine", "k", "C", "loadShopVip", "getLoadShopVip", "z", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {
    public transient x a;
    public transient o b;

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

    public final void A(String r1) {
        this.localSpFileName = r1;
    }

    public final void B(Boolean r1) {
        this.needAdOpenId = r1;
    }

    public final void C(Boolean r1) {
        this.playbackJustUseTTVideoEngine = r1;
    }

    public final void D(Boolean r1) {
        this.isPreloadGeckoChannel = r1;
    }

    public final void E(Boolean r1) {
        this.isSaasMessageCheck = r1;
    }

    public final void F(Boolean r1) {
        this.saasUseAuthorOpenId = r1;
    }

    public final void G(Boolean r1) {
        this.isToBSaaSCoupon = r1;
    }

    public final void H(Boolean r1) {
        this.useSaasStartLiveStrategy = r1;
    }

    public final void I(Boolean r1) {
        this.useSaasUrl = r1;
    }

    public final void r(Boolean r1) {
        this.enableAuthorDetailPage = r1;
    }

    public final void s(Boolean r1) {
        this.enableCardOpt = r1;
    }

    public final void t(Boolean r1) {
        this.enableDetailLiveDegrade = r1;
    }

    public final void u(Boolean r1) {
        this.enableDeviceDegrade = r1;
    }

    public final void v(Boolean r1) {
        this.enableFastEntry = r1;
    }

    public final void w(String r1) {
        this.eventNamePrefix = r1;
    }

    public final void x(Boolean r1) {
        this.forceUseShoppingPlayback = r1;
    }

    public final void y(String r1) {
        this.host = r1;
    }

    public final void z(Boolean r1) {
        this.loadShopVip = r1;
    }
}
