package com.bytedance.bdp.appbase.network;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b:\b\u0087\u0001\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001<B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;¨\u0006="}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "", "from", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "merge", "bdp", ErrorType.PREFETCH, "cp", "inner_bundle", "download_cp", "download_inner", "preconnect_cp", "preconnect_sdk", "sentry", "normal_pkg", "async_pkg", "preload_pkg", "silence_pkg", "image", "settings", "upload_cp", "upload_inner", "ad", "shortcut", "loader", "locate", MultiProcessFileUtils.KEY_DNS, "permission", "platform", "opendata", EventVerify.TYPE_LAUNCH, CloudControlInf.PLUGIN, "netbus", EffectConstants.CHANNEL_TEST, "lynx", "empty", "unisus", "unisus_basebundle", "unisus_settings", "unisus_cloud", AppConstants.API_HOST_SI_PREFIX, "host", "cdn", "timeline", "onecard", "iframe", "requester", "share_video", "cp_http_secure", "web_resource", "call_container", "inner_gateway_request", "sonic", "krypton", "cloud_upload", "cloud_download", "cloud_websocket_extension", "Companion", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final enum BdpFromSource extends Enum<BdpFromSource> {
    private static final /* synthetic */ BdpFromSource[] $VALUES = null;
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    public static final BdpFromSource f200852ad = null;
    public static final BdpFromSource async_pkg = null;
    public static final BdpFromSource bdp = null;
    public static final BdpFromSource call_container = null;
    public static final BdpFromSource cdn = null;
    public static final BdpFromSource cloud_download = null;
    public static final BdpFromSource cloud_upload = null;
    public static final BdpFromSource cloud_websocket_extension = null;

    /* JADX INFO: renamed from: cp, reason: collision with root package name */
    public static final BdpFromSource f200853cp = null;
    public static final BdpFromSource cp_http_secure = null;
    public static final BdpFromSource dns = null;
    public static final BdpFromSource download_cp = null;
    public static final BdpFromSource download_inner = null;
    public static final BdpFromSource empty = null;
    public static final BdpFromSource host = null;
    public static final BdpFromSource iframe = null;
    public static final BdpFromSource image = null;
    public static final BdpFromSource inner_bundle = null;
    public static final BdpFromSource inner_gateway_request = null;
    public static final BdpFromSource krypton = null;
    public static final BdpFromSource launch = null;
    public static final BdpFromSource loader = null;
    public static final BdpFromSource locate = null;
    public static final BdpFromSource lynx = null;
    public static final BdpFromSource merge = null;
    public static final BdpFromSource netbus = null;
    public static final BdpFromSource normal_pkg = null;
    public static final BdpFromSource onecard = null;
    public static final BdpFromSource opendata = null;
    public static final BdpFromSource permission = null;
    public static final BdpFromSource platform = null;
    public static final BdpFromSource plugin = null;
    public static final BdpFromSource preconnect_cp = null;
    public static final BdpFromSource preconnect_sdk = null;
    public static final BdpFromSource prefetch = null;
    public static final BdpFromSource preload_pkg = null;
    public static final BdpFromSource requester = null;

    /* JADX INFO: renamed from: security, reason: collision with root package name */
    public static final BdpFromSource f200854security = null;
    public static final BdpFromSource sentry = null;
    public static final BdpFromSource settings = null;
    public static final BdpFromSource share_video = null;
    public static final BdpFromSource shortcut = null;
    public static final BdpFromSource silence_pkg = null;
    public static final BdpFromSource sonic = null;
    public static final BdpFromSource test = null;
    public static final BdpFromSource timeline = null;
    public static final BdpFromSource unisus = null;
    public static final BdpFromSource unisus_basebundle = null;
    public static final BdpFromSource unisus_cloud = null;
    public static final BdpFromSource unisus_settings = null;
    public static final BdpFromSource upload_cp = null;
    public static final BdpFromSource upload_inner = null;
    public static final BdpFromSource web_resource = null;
    private final String from;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpFromSource$Companion;", "", "()V", "from", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "name", "", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final BdpFromSource from(String r100) {
            BdpFromSource[] r101 = BdpFromSource.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            BdpFromSource r104 = r101[r103];
            if (StringsKt.equals(r104.getFrom(), r100, true) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    @JvmStatic
    public static final BdpFromSource from(String r100) {
        return Companion.from(r100);
    }

    public static BdpFromSource valueOf(String r100) {
        return (BdpFromSource) r27.a.a(BdpFromSource.class, r100);
    }

    public static BdpFromSource[] values() {
        return (BdpFromSource[]) $VALUES.clone();
    }

    static {
        BdpFromSource r100 = new BdpFromSource("merge", 0, "merge");
        merge = r100;
        BdpFromSource r101 = new BdpFromSource("bdp", 1, "bdp");
        bdp = r101;
        BdpFromSource r102 = new BdpFromSource(ErrorType.PREFETCH, 2, ErrorType.PREFETCH);
        prefetch = r102;
        BdpFromSource r103 = new BdpFromSource("cp", 3, "cp");
        f200853cp = r103;
        BdpFromSource r104 = new BdpFromSource("inner_bundle", 4, "inner_bundle");
        inner_bundle = r104;
        BdpFromSource r105 = new BdpFromSource("download_cp", 5, "download_cp");
        download_cp = r105;
        BdpFromSource r106 = new BdpFromSource("download_inner", 6, "download_inner");
        download_inner = r106;
        BdpFromSource r107 = new BdpFromSource("preconnect_cp", 7, "preconnect_cp");
        preconnect_cp = r107;
        BdpFromSource r108 = new BdpFromSource("preconnect_sdk", 8, "preconnect_sdk");
        preconnect_sdk = r108;
        BdpFromSource r109 = new BdpFromSource("sentry", 9, "sentry");
        sentry = r109;
        BdpFromSource r110 = new BdpFromSource("normal_pkg", 10, "normal_pkg");
        normal_pkg = r110;
        BdpFromSource r111 = new BdpFromSource("async_pkg", 11, "async_pkg");
        async_pkg = r111;
        BdpFromSource r112 = new BdpFromSource("preload_pkg", 12, "preload_pkg");
        preload_pkg = r112;
        BdpFromSource r113 = new BdpFromSource("silence_pkg", 13, "silence_pkg");
        silence_pkg = r113;
        BdpFromSource r114 = new BdpFromSource("image", 14, "image");
        image = r114;
        BdpFromSource r115 = new BdpFromSource("settings", 15, "settings");
        settings = r115;
        BdpFromSource r116 = new BdpFromSource("upload_cp", 16, "upload_cp");
        upload_cp = r116;
        BdpFromSource r117 = new BdpFromSource("upload_inner", 17, "upload_inner");
        upload_inner = r117;
        BdpFromSource r118 = new BdpFromSource("ad", 18, "ad");
        f200852ad = r118;
        BdpFromSource r119 = new BdpFromSource("shortcut", 19, "shortcut");
        shortcut = r119;
        BdpFromSource r120 = new BdpFromSource("loader", 20, "loader");
        loader = r120;
        BdpFromSource r121 = new BdpFromSource("locate", 21, "locate");
        locate = r121;
        BdpFromSource r122 = new BdpFromSource(MultiProcessFileUtils.KEY_DNS, 22, MultiProcessFileUtils.KEY_DNS);
        dns = r122;
        BdpFromSource r123 = new BdpFromSource("permission", 23, "permission");
        permission = r123;
        BdpFromSource r124 = new BdpFromSource("platform", 24, "platform");
        platform = r124;
        BdpFromSource r125 = new BdpFromSource("opendata", 25, "opendata");
        opendata = r125;
        BdpFromSource r126 = new BdpFromSource(EventVerify.TYPE_LAUNCH, 26, EventVerify.TYPE_LAUNCH);
        launch = r126;
        BdpFromSource r127 = new BdpFromSource(CloudControlInf.PLUGIN, 27, CloudControlInf.PLUGIN);
        plugin = r127;
        BdpFromSource r128 = new BdpFromSource("netbus", 28, "netbus");
        netbus = r128;
        BdpFromSource r129 = new BdpFromSource(EffectConstants.CHANNEL_TEST, 29, EffectConstants.CHANNEL_TEST);
        test = r129;
        BdpFromSource r130 = new BdpFromSource("lynx", 30, "lynx");
        lynx = r130;
        BdpFromSource r131 = new BdpFromSource("empty", 31, "empty");
        empty = r131;
        BdpFromSource r132 = new BdpFromSource("unisus", 32, "unisus");
        unisus = r132;
        BdpFromSource r133 = new BdpFromSource("unisus_basebundle", 33, "unisus_basebundle");
        unisus_basebundle = r133;
        BdpFromSource r134 = new BdpFromSource("unisus_settings", 34, "unisus_settings");
        unisus_settings = r134;
        BdpFromSource r135 = new BdpFromSource("unisus_cloud", 35, "unisus_cloud");
        unisus_cloud = r135;
        BdpFromSource r136 = new BdpFromSource(AppConstants.API_HOST_SI_PREFIX, 36, AppConstants.API_HOST_SI_PREFIX);
        f200854security = r136;
        BdpFromSource r137 = new BdpFromSource("host", 37, "host");
        host = r137;
        BdpFromSource r138 = new BdpFromSource("cdn", 38, "cdn");
        cdn = r138;
        BdpFromSource r139 = new BdpFromSource("timeline", 39, "timeline");
        timeline = r139;
        BdpFromSource r140 = new BdpFromSource("onecard", 40, "onecard");
        onecard = r140;
        BdpFromSource r141 = new BdpFromSource("iframe", 41, "iframe");
        iframe = r141;
        BdpFromSource r142 = new BdpFromSource("requester", 42, "requester");
        requester = r142;
        BdpFromSource r143 = new BdpFromSource("share_video", 43, "share_video");
        share_video = r143;
        BdpFromSource r144 = new BdpFromSource("cp_http_secure", 44, "cp_http_secure");
        cp_http_secure = r144;
        BdpFromSource r145 = new BdpFromSource("web_resource", 45, "web_resource");
        web_resource = r145;
        BdpFromSource r146 = new BdpFromSource("call_container", 46, "call_container");
        call_container = r146;
        BdpFromSource r147 = new BdpFromSource("inner_gateway_request", 47, "inner_gateway_request");
        inner_gateway_request = r147;
        BdpFromSource r148 = new BdpFromSource("sonic", 48, "sonic");
        sonic = r148;
        BdpFromSource r149 = new BdpFromSource("krypton", 49, "krypton");
        krypton = r149;
        BdpFromSource r150 = new BdpFromSource("cloud_upload", 50, "cloud_upload");
        cloud_upload = r150;
        BdpFromSource r151 = new BdpFromSource("cloud_download", 51, "cloud_download");
        cloud_download = r151;
        BdpFromSource r152 = new BdpFromSource("cloud_websocket_extension", 52, "cloud_wesocket_extension");
        cloud_websocket_extension = r152;
        $VALUES = new BdpFromSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152};
        Companion = new Companion(null);
    }

    public final String getFrom() {
        return this.from;
    }

    private BdpFromSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
