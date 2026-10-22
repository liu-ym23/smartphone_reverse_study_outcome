package com.ss.ttvideoengine.log;

import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
class HeadsetStateHistory implements HeadsetStateMonitor.HeadsetStateChangedListener {
    private static final String TAG = "HeadsetStateHistory";
    private final ArrayList<String> mConnectionHistoryList;
    private final HeadsetStateMonitor mHeadsetStateMonitor;
    private volatile long mLastSwitchTime;

    public ArrayList<String> get() {
        return new ArrayList(this.mConnectionHistoryList);
    }

    public void reset() {
        this.mLastSwitchTime = 0;
        this.mConnectionHistoryList.clear();
    }

    public void start() {
        this.mHeadsetStateMonitor.addStateChangedListener(this);
        TTVideoEngineLog.d(TAG, "start");
    }

    public void stop() {
        this.mHeadsetStateMonitor.removeStateChangedListener(this);
        TTVideoEngineLog.d(TAG, "stop");
    }

    public long getLastSwitchTime() {
        return this.mLastSwitchTime;
    }

    public HeadsetStateHistory(HeadsetStateMonitor r100) {
        this.mLastSwitchTime = 0;
        this.mHeadsetStateMonitor = r100;
        this.mConnectionHistoryList = new ArrayList();
    }

    private void addToHistory(boolean r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("t", Long.valueOf(System.currentTimeMillis()));
        r102.put("bt", Integer.valueOf(r101 ? 1 : 0));
        r102.put("con", Integer.valueOf(r100 ? 1 : 0));
        this.mConnectionHistoryList.add(new JSONObject(r102).toString());
    }

    @Override // com.ss.ttvideoengine.log.HeadsetStateMonitor.HeadsetStateChangedListener
    public void onHeadsetStateChanged(boolean r100, boolean r101) {
        this.mLastSwitchTime = System.currentTimeMillis();
        addToHistory(r100, r101);
    }
}
