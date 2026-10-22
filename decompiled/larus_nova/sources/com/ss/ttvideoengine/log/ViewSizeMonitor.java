package com.ss.ttvideoengine.log;

import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
class ViewSizeMonitor {
    private int currentHeight;
    private int currentWidth;
    private final ArrayList<String> historyList;
    private int lastValidHeight;
    private int lastValidWidth;

    public void reset() {
        this.currentWidth = 0;
        this.currentHeight = 0;
        this.historyList.clear();
    }

    public ArrayList<String> getHistory() {
        return new ArrayList(this.historyList);
    }

    public void tryAddLastSizeToHistory() {
        if (this.currentWidth <= 0) goto L5;
        return;
    L5:
        if (this.currentHeight > 0) goto L9;
        maybeAddToHistory(this.lastValidWidth, this.lastValidHeight);
        return;
    }

    public ViewSizeMonitor() {
        this.historyList = new ArrayList();
    }

    private void maybeAddToHistory(int r100, int r101) {
        if (r100 <= 0) goto L14;
        if (r101 <= 0) goto L15;
        HashMap r102 = new HashMap();
        r102.put("w", Integer.valueOf(r100));
        r102.put("h", Integer.valueOf(r101));
        r102.put("t", Long.valueOf(System.currentTimeMillis()));
        TTVideoEngineUtils.addToList(this.historyList, new JSONObject(r102).toString());     // Catch: Exception -> L8
    L10:
        this.currentWidth = 0;
        this.currentHeight = 0;
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L15:
        return;
    }

    public void setSize(int r100, int r101) {
        if (r100 <= 0) goto L4;
        this.currentWidth = r100;
        this.lastValidWidth = r100;
    L4:
        if (r101 <= 0) goto L6;
        this.currentHeight = r101;
        this.lastValidHeight = r101;
    L6:
        maybeAddToHistory(this.currentWidth, this.currentHeight);
    }
}
