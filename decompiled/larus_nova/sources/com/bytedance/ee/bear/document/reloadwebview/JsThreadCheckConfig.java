package com.bytedance.ee.bear.document.reloadwebview;

import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "ccm_check_js_thread_was_blocked_config")
public class JsThreadCheckConfig implements NonProguard {
    private static final String TAG = "JsThreadCheckConfig";
    private long checkTimeOutWhenDestory;
    private long checkTimeoutHigh;
    private long checkTimeoutLow;
    private long checkWhenDestoryDelay;
    private ArrayList<Condition> conditions;
    private boolean enableCheckWhenDestory;
    private boolean enableCheckWhenLoadFailed;
    private long loadHtmlTimeOutHigh;
    private long loadHtmlTimeOutLow;
    private int maxKillTims;

    public static class Condition implements Serializable {
        public int cancel100Count;
        public int overtime100Count;
        public int preloadHtmlFailedCount;

        public String toString() {
            return "Condition{preloadHtmlFailedCount=" + this.preloadHtmlFailedCount + ", overtime100Count=" + this.overtime100Count + ", cancel100Count=" + this.cancel100Count + '}';
        }

        public Condition() {
            this.preloadHtmlFailedCount = 3;
            this.overtime100Count = 0;
            this.cancel100Count = 0;
        }
    }

    public long getCheckTimeout() {
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L7;
        return this.checkTimeoutLow;
    L7:
        return this.checkTimeoutHigh;
    }

    public List<Condition> getConditions() {
        if (CollectionUtils.isEmpty(this.conditions) == false) goto L6;
        tt5.a.h(TAG, "conditions is null");
        Condition r100 = new Condition();
        r100.preloadHtmlFailedCount = 3;
        r100.overtime100Count = 0;
        r100.cancel100Count = 0;
        this.conditions.add(r100);
        Condition r101 = new Condition();
        r101.preloadHtmlFailedCount = 2;
        r101.overtime100Count = 1;
        r101.cancel100Count = 0;
        this.conditions.add(r101);
        Condition r102 = new Condition();
        r102.preloadHtmlFailedCount = 2;
        r102.overtime100Count = 0;
        r102.cancel100Count = 3;
        this.conditions.add(r102);
    L6:
        return this.conditions;
    }

    public long getLoadHtmlTimeOut() {
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L7;
        return this.loadHtmlTimeOutLow;
    L7:
        return this.loadHtmlTimeOutHigh;
    }

    public long getMaxKillTims() {
        return this.maxKillTims;
    }

    public String toString() {
        return "JsThreadCheckConfig{conditions=" + this.conditions + ", checkTimeOutWhenDestory=" + this.checkTimeOutWhenDestory + ", checkWhenDestoryDelay=" + this.checkWhenDestoryDelay + ", checkTimeoutHigh=" + this.checkTimeoutHigh + ", checkTimeoutLow=" + this.checkTimeoutLow + ", enableCheckWhenDestory=" + this.enableCheckWhenDestory + ", enableCheckWhenLoadFailed=" + this.enableCheckWhenLoadFailed + ", maxKillTims=" + this.maxKillTims + ", loadHtmlTimeOutHigh=" + this.loadHtmlTimeOutHigh + ", loadHtmlTimeOutLow=" + this.loadHtmlTimeOutLow + '}';
    }

    public JsThreadCheckConfig() {
        this.conditions = new ArrayList();
        this.checkTimeOutWhenDestory = 20000;
        this.checkWhenDestoryDelay = 3000;
        this.checkTimeoutHigh = 11000;
        this.checkTimeoutLow = 30000;
        this.enableCheckWhenDestory = true;
        this.enableCheckWhenLoadFailed = true;
        this.maxKillTims = 1;
        this.loadHtmlTimeOutHigh = 32000;
        this.loadHtmlTimeOutLow = 60000;
    }

    public long getCheckTimeOutWhenDestory() {
        return this.checkTimeOutWhenDestory;
    }

    public long getCheckWhenDestoryDelay() {
        return this.checkWhenDestoryDelay;
    }

    public boolean isEnableCheckWhenDestory() {
        return this.enableCheckWhenDestory;
    }

    public boolean isEnableCheckWhenLoadFailed() {
        return this.enableCheckWhenLoadFailed;
    }

    public void setCheckTimeOutWhenDestory(int r100) {
        this.checkTimeOutWhenDestory = r100;
    }

    public void setCheckTimeoutHigh(int r100) {
        this.checkTimeoutHigh = r100;
    }

    public void setCheckTimeoutLow(int r100) {
        this.checkTimeoutLow = r100;
    }

    public void setCheckWhenDestoryDelay(int r100) {
        this.checkWhenDestoryDelay = r100;
    }

    public void setConditions(ArrayList<Condition> r100) {
        this.conditions = r100;
    }

    public void setEnableCheckWhenDestory(boolean r100) {
        this.enableCheckWhenDestory = r100;
    }

    public void setEnableCheckWhenLoadFailed(boolean r100) {
        this.enableCheckWhenLoadFailed = r100;
    }

    public void setLoadHtmlTimeOutHigh(int r100) {
        this.loadHtmlTimeOutHigh = r100;
    }

    public void setLoadHtmlTimeOutLow(int r100) {
        this.loadHtmlTimeOutLow = r100;
    }

    public void setMaxKillTims(int r100) {
        this.maxKillTims = r100;
    }
}
