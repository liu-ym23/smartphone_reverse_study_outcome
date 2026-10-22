package com.bytedance.bdp.serviceapi.defaults.network;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f201573a;

    public static final enum FromSource extends Enum<FromSource> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FromSource[] f201574a = null;

        /* JADX INFO: renamed from: ad, reason: collision with root package name */
        public static final FromSource f201575ad = null;
        public static final FromSource bdp = null;

        /* JADX INFO: renamed from: cp, reason: collision with root package name */
        public static final FromSource f201576cp = null;
        public static final FromSource dns = null;
        public static final FromSource download = null;
        public static final FromSource empty = null;
        public static final FromSource image = null;
        public static final FromSource inner = null;
        public static final FromSource launch = null;
        public static final FromSource loader = null;
        public static final FromSource locate = null;
        public static final FromSource netbus = null;
        public static final FromSource opendata = null;
        public static final FromSource permission = null;
        public static final FromSource platform = null;
        public static final FromSource plugin = null;
        public static final FromSource prefetch = null;
        public static final FromSource requester = null;
        public static final FromSource sentry = null;
        public static final FromSource settings = null;
        public static final FromSource shortcut = null;
        public static final FromSource sonic = null;
        public static final FromSource stream = null;
        public static final FromSource test = null;
        public static final FromSource upload = null;
        private final String fromSource;

        static {
            FromSource r100 = new FromSource("bdp", 0, "bdp");
            bdp = r100;
            FromSource r101 = new FromSource(ErrorType.PREFETCH, 1, ErrorType.PREFETCH);
            prefetch = r101;
            FromSource r102 = new FromSource("cp", 2, "cp");
            f201576cp = r102;
            FromSource r103 = new FromSource(RNParamRegisterEventHandler.SRC_INNER, 3, RNParamRegisterEventHandler.SRC_INNER);
            inner = r103;
            FromSource r104 = new FromSource("download", 4, "download");
            download = r104;
            FromSource r105 = new FromSource("sentry", 5, "sentry");
            sentry = r105;
            FromSource r110 = new FromSource("stream", 6, "stream");
            stream = r110;
            FromSource r111 = new FromSource("image", 7, "image");
            image = r111;
            FromSource r112 = new FromSource("settings", 8, "settings");
            settings = r112;
            FromSource r113 = new FromSource("upload", 9, "upload");
            upload = r113;
            FromSource r114 = new FromSource("ad", 10, "ad");
            f201575ad = r114;
            FromSource r115 = new FromSource("shortcut", 11, "shortcut");
            shortcut = r115;
            FromSource r106 = new FromSource("loader", 12, "loader");
            loader = r106;
            FromSource r107 = new FromSource("locate", 13, "locate");
            locate = r107;
            FromSource r108 = new FromSource(MultiProcessFileUtils.KEY_DNS, 14, MultiProcessFileUtils.KEY_DNS);
            dns = r108;
            FromSource r109 = new FromSource("permission", 15, "permission");
            permission = r109;
            FromSource r116 = new FromSource("platform", 16, "platform");
            platform = r116;
            FromSource r117 = new FromSource("opendata", 17, "opendata");
            opendata = r117;
            FromSource r118 = new FromSource(EventVerify.TYPE_LAUNCH, 18, EventVerify.TYPE_LAUNCH);
            launch = r118;
            FromSource r119 = new FromSource(CloudControlInf.PLUGIN, 19, CloudControlInf.PLUGIN);
            plugin = r119;
            FromSource r120 = new FromSource("netbus", 20, "netbus");
            netbus = r120;
            FromSource r121 = new FromSource("sonic", 21, "sonic");
            sonic = r121;
            FromSource r122 = new FromSource(EffectConstants.CHANNEL_TEST, 22, EffectConstants.CHANNEL_TEST);
            test = r122;
            FromSource r123 = new FromSource("empty", 23, "empty");
            empty = r123;
            FromSource r124 = new FromSource("requester", 24, "requester");
            requester = r124;
            f201574a = new FromSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        }

        public static FromSource[] values() {
            return (FromSource[]) f201574a.clone();
        }

        public String getValue() {
            return this.fromSource;
        }

        public static FromSource valueOf(String r100) {
            return (FromSource) a.a(FromSource.class, r100);
        }

        public FromSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.fromSource = r102;
        }
    }
}
