package nv6;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.gson.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u001c\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001c\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001a\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R2\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0006\u001a\u0004\b1\u0010\b\"\u0004\b2\u00103R*\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010B\u001a\u0004\u0018\u00010A8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lnv6/r;", "", "", "", "Lnv6/n;", "cardInfos", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "Lcom/bytedance/android/live/base/model/UrlModel;", "dynamicIconUrl", "Lcom/bytedance/android/live/base/model/UrlModel;", "c", "()Lcom/bytedance/android/live/base/model/UrlModel;", "iconUrl", "getIconUrl", "Lnv6/t;", "extra", "Lnv6/t;", "d", "()Lnv6/t;", "logExtra", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "Lnv6/u;", "native_site_config", "Lnv6/u;", "h", "()Lnv6/u;", "roomId", "getRoomId", "webTitle", "l", NativeDownloadModel.JsonKey.WEB_URL, "m", "anchorId", "getAnchorId", "", "serverTime", "J", ce.f26396k, "()J", "Lnv6/c;", "aggPreloadConfig", "Lnv6/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/c;", "perfLog", ce.f26395j, "setPerfLog", "(Ljava/util/Map;)V", "", "Lnv6/z;", "lifeComponentAtmosphere", "Ljava/util/List;", "f", "()Ljava/util/List;", "setLifeComponentAtmosphere", "(Ljava/util/List;)V", "Lnv6/y;", "levelConfig", "Lnv6/y;", "e", "()Lnv6/y;", "Lnv6/h0;", "packConfig", "Lnv6/h0;", RXScreenCaptureService.KEY_INDEX, "()Lnv6/h0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("agg_preload_config")
    private final c aggPreloadConfig;

    @SerializedName("anchor_id")
    private final String anchorId;

    @SerializedName("card_infos")
    private final Map<String, n> cardInfos;

    @SerializedName("dynamic_icon_url")
    private final UrlModel dynamicIconUrl;

    @SerializedName("extra")
    private final t extra;

    @SerializedName("icon_url")
    private final UrlModel iconUrl;

    @SerializedName("level_config")
    private final y levelConfig;

    @SerializedName("life_component_atmosphere")
    private List<z> lifeComponentAtmosphere;

    @SerializedName("log_extra")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String logExtra;

    @SerializedName("native_site_config")
    private final u native_site_config;

    @SerializedName("pack_config")
    private final h0 packConfig;

    @SerializedName("perf_log")
    private Map<String, ? extends Object> perfLog;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName(BytedCertConstant.WebInfo.WEB_TITLE)
    private final String webTitle;

    @SerializedName("web_url")
    private final String webUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.cardInfos, r101.cardInfos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicIconUrl, r101.dynamicIconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.native_site_config, r101.native_site_config) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.webTitle, r101.webTitle) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L39;
        return false;
    L39:
        if (this.serverTime == r101.serverTime) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aggPreloadConfig, r101.aggPreloadConfig) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.perfLog, r101.perfLog) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.lifeComponentAtmosphere, r101.lifeComponentAtmosphere) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.levelConfig, r101.levelConfig) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.packConfig, r101.packConfig) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        Map<String, n> r100 = this.cardInfos;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlModel r104 = this.dynamicIconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.iconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        t r110 = this.extra;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.logExtra;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        u r116 = this.native_site_config;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.roomId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.webTitle;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.webUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.anchorId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        long r131 = this.serverTime;
        int r132 = (r130 + ((int) (r131 ^ (r131 >>> 32)))) * 31;
        c r133 = this.aggPreloadConfig;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        Map<String, ? extends Object> r136 = this.perfLog;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        List<z> r139 = this.lifeComponentAtmosphere;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        y r142 = this.levelConfig;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        h0 r145 = this.packConfig;
        if (r145 == null) goto L63;
        r101 = r145.hashCode();
    L63:
        return r144 + r101;
    L57:
        r143 = r142.hashCode();
        goto L58
    L53:
        r140 = r139.hashCode();
        goto L54
    L49:
        r137 = r136.hashCode();
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GroupPurchaseComponentInfo(cardInfos=" + this.cardInfos + ", dynamicIconUrl=" + this.dynamicIconUrl + ", iconUrl=" + this.iconUrl + ", extra=" + this.extra + ", logExtra=" + this.logExtra + ", native_site_config=" + this.native_site_config + ", roomId=" + this.roomId + ", webTitle=" + this.webTitle + ", webUrl=" + this.webUrl + ", anchorId=" + this.anchorId + ", serverTime=" + this.serverTime + ", aggPreloadConfig=" + this.aggPreloadConfig + ", perfLog=" + this.perfLog + ", lifeComponentAtmosphere=" + this.lifeComponentAtmosphere + ", levelConfig=" + this.levelConfig + ", packConfig=" + this.packConfig + ')';
    }

    public final c a() {
        return this.aggPreloadConfig;
    }

    public final Map<String, n> b() {
        return this.cardInfos;
    }

    public final UrlModel c() {
        return this.dynamicIconUrl;
    }

    public final t d() {
        return this.extra;
    }

    public final y e() {
        return this.levelConfig;
    }

    public final List<z> f() {
        return this.lifeComponentAtmosphere;
    }

    public final String g() {
        return this.logExtra;
    }

    public final u h() {
        return this.native_site_config;
    }

    public final h0 i() {
        return this.packConfig;
    }

    public final Map<String, Object> j() {
        return this.perfLog;
    }

    public final long k() {
        return this.serverTime;
    }

    public final String l() {
        return this.webTitle;
    }

    public final String m() {
        return this.webUrl;
    }
}
