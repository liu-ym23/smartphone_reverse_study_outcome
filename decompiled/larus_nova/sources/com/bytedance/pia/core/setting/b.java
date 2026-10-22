package com.bytedance.pia.core.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bD\u0010ER$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR8\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR0\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020+\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\r\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\r\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R$\u0010>\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/bytedance/pia/core/setting/b;", "", "", "openOnlineMonitor", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "setOpenOnlineMonitor", "(Ljava/lang/Boolean;)V", "", "", "", "disableFeatures", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setDisableFeatures", "(Ljava/util/Map;)V", "disablePages", "Ljava/util/List;", "b", "()Ljava/util/List;", "setDisablePages", "(Ljava/util/List;)V", "", "openManifestCacheInt", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "setOpenManifestCacheInt", "(Ljava/lang/Integer;)V", "openPIAFastPages", ce.f26396k, "setOpenPIAFastPages", "openParseLink", "l", "setOpenParseLink", "openHTMLSwitchPreload", "f", "setOpenHTMLSwitchPreload", "openHTMLSetCacheKey", "e", "setOpenHTMLSetCacheKey", "", "snapshotExpire", "o", "setSnapshotExpire", "openSSRSnapshot", "m", "setOpenSSRSnapshot", "openNewPortPolyfill", RXScreenCaptureService.KEY_INDEX, "setOpenNewPortPolyfill", "openUpdateServerLogId", OfficeSDKRequestTag.KEY_NEW_USER, "setOpenUpdateServerLogId", "openMainFrameTag", ce.f26391f, "setOpenMainFrameTag", "geckoChannelMapping", "c", "setGeckoChannelMapping", "geckoChannelSwitch", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setGeckoChannelSwitch", "(Ljava/lang/Long;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("disable_features")
    private Map<String, ? extends List<String>> disableFeatures;

    @SerializedName("disable_pages")
    private List<String> disablePages;

    @SerializedName("gecko_channel_mapping")
    private Map<String, String> geckoChannelMapping;

    @SerializedName("gecko_channel_switch")
    private Long geckoChannelSwitch;

    @SerializedName("open_html_set_cache_key")
    private Boolean openHTMLSetCacheKey;

    @SerializedName("open_html_switch_preload")
    private Boolean openHTMLSwitchPreload;

    @SerializedName("open_main_frame_tag")
    private Boolean openMainFrameTag;

    @SerializedName("open_manifest_cache_int")
    private Integer openManifestCacheInt;

    @SerializedName("open_new_port_polyfill")
    private Boolean openNewPortPolyfill;

    @SerializedName("open_online_monitor")
    private Boolean openOnlineMonitor;

    @SerializedName("open_pia_fast_pages")
    private List<String> openPIAFastPages;

    @SerializedName("open_parse_link")
    private Boolean openParseLink;

    @SerializedName("open_ssr_snapshot")
    private Boolean openSSRSnapshot;

    @SerializedName("open_update_server_logid")
    private Boolean openUpdateServerLogId;

    @SerializedName("snapshot_expire")
    private Map<String, Long> snapshotExpire;

    public b() {
    }

    public final Map<String, List<String>> a() {
        return this.disableFeatures;
    }

    public final List<String> b() {
        return this.disablePages;
    }

    public final Map<String, String> c() {
        return this.geckoChannelMapping;
    }

    public final Long d() {
        return this.geckoChannelSwitch;
    }

    public final Boolean e() {
        return this.openHTMLSetCacheKey;
    }

    public final Boolean f() {
        return this.openHTMLSwitchPreload;
    }

    public final Boolean g() {
        return this.openMainFrameTag;
    }

    public final Integer h() {
        return this.openManifestCacheInt;
    }

    public final Boolean i() {
        return this.openNewPortPolyfill;
    }

    public final Boolean j() {
        return this.openOnlineMonitor;
    }

    public final List<String> k() {
        return this.openPIAFastPages;
    }

    public final Boolean l() {
        return this.openParseLink;
    }

    public final Boolean m() {
        return this.openSSRSnapshot;
    }

    public final Boolean n() {
        return this.openUpdateServerLogId;
    }

    public final Map<String, Long> o() {
        return this.snapshotExpire;
    }
}
