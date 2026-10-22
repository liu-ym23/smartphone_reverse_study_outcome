package com.ss.android.downloadlib.event;

import com.ss.android.download.api.model.DownloadEventModel;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SdkEventHandler {

    public static class SdkEventHandlerHolder {
        public static final SdkEventHandler INSTANCE = null;

        private SdkEventHandlerHolder() {
        }

        static {
            INSTANCE = new SdkEventHandler();
        }
    }

    public SdkEventHandler() {
    }

    public static SdkEventHandler getInstance() {
        return SdkEventHandlerHolder.INSTANCE;
    }

    private void onEvent(DownloadEventModel r100) {
        if (GlobalInfo.getDownloadEventLogger() != null) goto L5;
        return;
    L5:
        GlobalInfo.getDownloadEventLogger().onV3Event(r100);
    }

    public void sendV3Event(String r100, JSONObject r101) {
        onEvent(new DownloadEventModel.Builder().setLabel(r100).setIsAd(false).setExtJson(r101).setEventSource(2).setIsV3(true).build());
    }
}
