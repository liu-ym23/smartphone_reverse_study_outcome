package com.bytedance.awemeopen.servicesapi.network;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
public final enum AoRequest$FromSource extends Enum<AoRequest$FromSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AoRequest$FromSource[] f199001a = null;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    public static final AoRequest$FromSource f199002ad = null;
    public static final AoRequest$FromSource bdp = null;

    /* JADX INFO: renamed from: cp, reason: collision with root package name */
    public static final AoRequest$FromSource f199003cp = null;
    public static final AoRequest$FromSource dns = null;
    public static final AoRequest$FromSource download = null;
    public static final AoRequest$FromSource empty = null;
    public static final AoRequest$FromSource image = null;
    public static final AoRequest$FromSource inner = null;
    public static final AoRequest$FromSource launch = null;
    public static final AoRequest$FromSource loader = null;
    public static final AoRequest$FromSource locate = null;
    public static final AoRequest$FromSource netbus = null;
    public static final AoRequest$FromSource opendata = null;
    public static final AoRequest$FromSource permission = null;
    public static final AoRequest$FromSource platform = null;
    public static final AoRequest$FromSource plugin = null;
    public static final AoRequest$FromSource prefetch = null;
    public static final AoRequest$FromSource sentry = null;
    public static final AoRequest$FromSource settings = null;
    public static final AoRequest$FromSource shortcut = null;
    public static final AoRequest$FromSource sonic = null;
    public static final AoRequest$FromSource stream = null;
    public static final AoRequest$FromSource test = null;
    public static final AoRequest$FromSource upload = null;
    private final String fromSource;

    static {
        AoRequest$FromSource r100 = new AoRequest$FromSource("bdp", 0, "bdp");
        bdp = r100;
        AoRequest$FromSource r101 = new AoRequest$FromSource(ErrorType.PREFETCH, 1, ErrorType.PREFETCH);
        prefetch = r101;
        AoRequest$FromSource r102 = new AoRequest$FromSource("cp", 2, "cp");
        f199003cp = r102;
        AoRequest$FromSource r103 = new AoRequest$FromSource(RNParamRegisterEventHandler.SRC_INNER, 3, RNParamRegisterEventHandler.SRC_INNER);
        inner = r103;
        AoRequest$FromSource r104 = new AoRequest$FromSource("download", 4, "download");
        download = r104;
        AoRequest$FromSource r105 = new AoRequest$FromSource("sentry", 5, "sentry");
        sentry = r105;
        AoRequest$FromSource r110 = new AoRequest$FromSource("stream", 6, "stream");
        stream = r110;
        AoRequest$FromSource r111 = new AoRequest$FromSource("image", 7, "image");
        image = r111;
        AoRequest$FromSource r112 = new AoRequest$FromSource("settings", 8, "settings");
        settings = r112;
        AoRequest$FromSource r113 = new AoRequest$FromSource("upload", 9, "upload");
        upload = r113;
        AoRequest$FromSource r114 = new AoRequest$FromSource("ad", 10, "ad");
        f199002ad = r114;
        AoRequest$FromSource r115 = new AoRequest$FromSource("shortcut", 11, "shortcut");
        shortcut = r115;
        AoRequest$FromSource r106 = new AoRequest$FromSource("loader", 12, "loader");
        loader = r106;
        AoRequest$FromSource r107 = new AoRequest$FromSource("locate", 13, "locate");
        locate = r107;
        AoRequest$FromSource r108 = new AoRequest$FromSource(MultiProcessFileUtils.KEY_DNS, 14, MultiProcessFileUtils.KEY_DNS);
        dns = r108;
        AoRequest$FromSource r109 = new AoRequest$FromSource("permission", 15, "permission");
        permission = r109;
        AoRequest$FromSource r116 = new AoRequest$FromSource("platform", 16, "platform");
        platform = r116;
        AoRequest$FromSource r117 = new AoRequest$FromSource("opendata", 17, "opendata");
        opendata = r117;
        AoRequest$FromSource r118 = new AoRequest$FromSource(EventVerify.TYPE_LAUNCH, 18, EventVerify.TYPE_LAUNCH);
        launch = r118;
        AoRequest$FromSource r119 = new AoRequest$FromSource(CloudControlInf.PLUGIN, 19, CloudControlInf.PLUGIN);
        plugin = r119;
        AoRequest$FromSource r120 = new AoRequest$FromSource("netbus", 20, "netbus");
        netbus = r120;
        AoRequest$FromSource r121 = new AoRequest$FromSource("sonic", 21, "sonic");
        sonic = r121;
        AoRequest$FromSource r122 = new AoRequest$FromSource(EffectConstants.CHANNEL_TEST, 22, EffectConstants.CHANNEL_TEST);
        test = r122;
        AoRequest$FromSource r123 = new AoRequest$FromSource("empty", 23, "empty");
        empty = r123;
        f199001a = new AoRequest$FromSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public static AoRequest$FromSource[] values() {
        return (AoRequest$FromSource[]) f199001a.clone();
    }

    public String getValue() {
        return this.fromSource;
    }

    public static AoRequest$FromSource valueOf(String r100) {
        return (AoRequest$FromSource) a.a(AoRequest$FromSource.class, r100);
    }

    public AoRequest$FromSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.fromSource = r102;
    }
}
