package com.ss.android.ugc.aweme.ec.search.common;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes40.dex */
public class RequestLog {

    @SerializedName("other")
    public Other other;

    @SerializedName("timing")
    public Timing timing;

    public static class DetailedDuration {

        @SerializedName("body_recv")
        public String bodyRecv;

        @SerializedName(MultiProcessFileUtils.KEY_DNS)
        public String dns;

        @SerializedName("edge")
        public String edge;

        @SerializedName(RNParamRegisterEventHandler.SRC_INNER)
        public String inner;

        @SerializedName(PlayerResolution.SDKKEY.ORIGIN)
        public String origin;

        @SerializedName("rtt")
        public String rtt;

        @SerializedName("send")
        public String send;

        @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_SSL)
        public String ssl;

        @SerializedName("tcp")
        public String tcp;

        @SerializedName(MonitorConstants.TTFB)
        public String ttfb;

        public DetailedDuration() {
        }
    }

    public static class Other {

        @SerializedName("libcore")
        public String libcore;

        public Other() {
        }
    }

    public static class Timing {

        @SerializedName("detailed_duration")
        public DetailedDuration detailedDuration;

        public Timing() {
        }
    }

    public RequestLog() {
    }
}
