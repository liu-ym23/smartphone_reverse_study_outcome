package com.ss.videoarch.strategy.featureCenter.featureType;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.ss.videoarch.strategy.network.NetworkMonitorLoader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TypeNetworkFeaturesCollector extends BaseTypeFeaturesCollector {
    private static final String TAG = "TypeNetworkFeaturesCollector";
    private static volatile TypeNetworkFeaturesCollector sInstance;

    public static TypeNetworkFeaturesCollector inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TypeNetworkFeaturesCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TypeNetworkFeaturesCollector();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TypeNetworkFeaturesCollector.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TypeNetworkFeaturesCollector() {
        this.mTypeKey = "TypeNetworkFeature";
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L6;
        r100.mFeatureTypeName = "TypeNetworkFeature";
        return;
    }

    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputFeatures(JSONObject r100, JSONArray r101, String r102, String r103, JSONObject r104) {
        int r105 = 0;
    L4:
        if (r105 >= r101.length()) goto L52;
        String r106 = r101.optString(r105);
        int r107 = -1;
        switch(r106.hashCode()) {
            case -195699446: goto L28;
            case 212132371: goto L25;
            case 894047505: goto L22;
            case 1266276899: goto L19;
            case 1890703221: goto L16;
            case 2087921555: goto L13;
            case 2133555472: goto L10;
            default: goto L30;
        };     // Catch: JSONException -> L49
    L30:
        byte r108 = -1;
    L31:
        switch(r108) {
            case 0: goto L44;
            case 1: goto L41;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L37;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L51;
        };     // Catch: JSONException -> L49
    L33:
        r100.put(r106, NetworkMonitorLoader.inst().getNetworkType());     // Catch: JSONException -> L49
        goto L51
    L34:
        if (r104 == null) goto L36;
        r107 = r104.optInt("recommend_bitrate", -1);     // Catch: JSONException -> L49
    L36:
        r100.put(r106, r107);     // Catch: JSONException -> L49
        goto L51
    L37:
        r100.put(r106, -1);     // Catch: JSONException -> L49
        goto L51
    L38:
        if (r104 == null) goto L40;
        r107 = r104.optInt("video_download_speed", -1);     // Catch: JSONException -> L49
    L40:
        r100.put(r106, r107);     // Catch: JSONException -> L49
        goto L51
    L41:
        if (r104 == null) goto L43;
        r107 = r104.optInt("tcp_rtt", -1);     // Catch: JSONException -> L49
    L43:
        r100.put(r106, r107);     // Catch: JSONException -> L49
        goto L51
    L44:
        if (r104 == null) goto L46;
        int r109 = r104.optInt("net_effective_connection_type", -1);     // Catch: JSONException -> L49
    L47:
        r100.put(r106, r109);     // Catch: JSONException -> L49
        goto L51
    L46:
        r109 = 0;
    L51:
        r105 = r105 + 1;
        goto L4
    L10:
        if (r106.equals("NETWORK-RecommendBitrate") == false) goto L30;
        r108 = 5;
        goto L31
    L13:
        if (r106.equals("NETWORK-VodDownloadSpeed") == false) goto L30;
        r108 = 2;
        goto L31
    L16:
        if (r106.equals("NETWORK-NetworkLevel") == false) goto L30;
        r108 = 0;
        goto L31
    L19:
        if (r106.equals("NETWORK-Access") == false) goto L30;
        r108 = 6;
        goto L31
    L22:
        if (r106.equals("NETWORK-BestMtuLength") == false) goto L30;
        r108 = 3;
        goto L31
    L25:
        if (r106.equals("NETWORK-RTT") == false) goto L30;
        r108 = 1;
        goto L31
    L28:
        if (r106.equals("NETWORK-PacketLossRate") == false) goto L30;
        r108 = 4;
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L51
    L52:
        return r100;
    }
}
