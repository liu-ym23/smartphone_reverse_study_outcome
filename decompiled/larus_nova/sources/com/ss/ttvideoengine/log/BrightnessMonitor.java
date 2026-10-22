package com.ss.ttvideoengine.log;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BrightnessMonitor {
    private static final int LIST_SIZE = 100;
    private static final String TAG = "BrightnessMonitor";
    private final ContentObserver mBrightnessObserver;
    private final Context mContext;
    private final ArrayList<String> mHistoryList;
    private volatile boolean mIsPlaying;
    private volatile boolean mIsStart;

    private void addToHistory() {
        if (this.mIsPlaying == true) goto L5;
        return;
    L5:
        if (this.mHistoryList.size() > 100) goto L10;
        HashMap r100 = new HashMap();
        r100.put("b", Float.valueOf(ScreenUtils.getNormalizedBrightness(this.mContext)));
        r100.put("t", Long.valueOf(System.currentTimeMillis()));
        TTVideoEngineUtils.addToList(this.mHistoryList, new JSONObject(r100).toString());
        return;
    }

    public void start() {
        if (this.mIsStart == false) goto L5;
        return;
    L5:
        this.mIsStart = true;
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.mBrightnessObserver);     // Catch: Exception -> L8
    L10:
        addToHistory();
        return;
    L8:
        e = move-exception;
        TTVideoEngineLog.w(TAG, e.getMessage());
        goto L10
    }

    public void stop() {
        if (this.mIsStart == true) goto L5;
        return;
    L5:
        this.mIsStart = false;
        this.mContext.getContentResolver().unregisterContentObserver(this.mBrightnessObserver);
    }

    public ArrayList<String> getList() {
        return this.mHistoryList;
    }

    public BrightnessMonitor(Context r100) {
        this.mHistoryList = new ArrayList();
        final Handler r101 = null;
        this.mBrightnessObserver = new AnonymousClass1(this, r101);
        this.mContext = r100.getApplicationContext();
    }

    public static /* synthetic */ void access$000(BrightnessMonitor r100) {
        r100.addToHistory();
    }

    public void setPlaying(boolean r100) {
        this.mIsPlaying = r100;
    }
}
