package com.ss.ttvideoengine.utils;

import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class Inspector {
    private static final String TAG = "Inspector";
    private String mHost;
    private final TTHTTPNetwork mNetworkSession;

    public static class Holder {
        private static final Inspector instance = null;

        private Holder() {
        }

        static {
            instance = new Inspector();
        }

        public static /* synthetic */ Inspector access$000() {
            return instance;
        }
    }

    public void inspectEvent(String r100, JSONObject r101) {
    }

    public Inspector() {
        this.mNetworkSession = new TTHTTPNetwork();
    }

    public static Inspector share() {
        return Holder.access$000();
    }

    public String getHost() {
        return this.mHost;
    }

    public void setHost(String r100) {
        this.mHost = r100;
        if (StrategyHelper.helper().isRunning() == false) goto L6;
        StrategyHelper.helper().getCenter().h(31207, this.mHost);
        return;
    }

    private static /* synthetic */ void lambda$inspectEvent$0(JSONObject r100, Error r101) {
        TTVideoEngineLog.d(TAG, "inspect event error:" + r101.toString());
    }
}
