package com.bytedance.ee.bear.document.reloadwebview;

import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        if (DevicePerfManager.b.a.e.h == false) goto L7;
        return this.checkTimeoutLow;
    L7:
        return this.checkTimeoutHigh;
    }

    public List<Condition> getConditions() {
        if (CollectionUtils.isEmpty(this.conditions) == false) goto L6;
        tt5.a.h(TAG, "conditions is null");
        Condition r0 = new Condition();
        r0.preloadHtmlFailedCount = 3;
        r0.overtime100Count = 0;
        r0.cancel100Count = 0;
        this.conditions.add(r0);
        Condition r1 = new Condition();
        r1.preloadHtmlFailedCount = 2;
        r1.overtime100Count = 1;
        r1.cancel100Count = 0;
        this.conditions.add(r1);
        Condition r2 = new Condition();
        r2.preloadHtmlFailedCount = 2;
        r2.overtime100Count = 0;
        r2.cancel100Count = 3;
        this.conditions.add(r2);
    L6:
        return this.conditions;
    }

    public long getLoadHtmlTimeOut() {
        if (DevicePerfManager.b.a.e.h == false) goto L7;
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
        this.checkWhenDestoryDelay = ToastModel.DEFAULT_DURATION;
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

    public void setCheckTimeOutWhenDestory(int r3) {
        this.checkTimeOutWhenDestory = r3;
    }

    public void setCheckTimeoutHigh(int r3) {
        this.checkTimeoutHigh = r3;
    }

    public void setCheckTimeoutLow(int r3) {
        this.checkTimeoutLow = r3;
    }

    public void setCheckWhenDestoryDelay(int r3) {
        this.checkWhenDestoryDelay = r3;
    }

    public void setConditions(ArrayList<Condition> r1) {
        this.conditions = r1;
    }

    public void setEnableCheckWhenDestory(boolean r1) {
        this.enableCheckWhenDestory = r1;
    }

    public void setEnableCheckWhenLoadFailed(boolean r1) {
        this.enableCheckWhenLoadFailed = r1;
    }

    public void setLoadHtmlTimeOutHigh(int r3) {
        this.loadHtmlTimeOutHigh = r3;
    }

    public void setLoadHtmlTimeOutLow(int r3) {
        this.loadHtmlTimeOutLow = r3;
    }

    public void setMaxKillTims(int r1) {
        this.maxKillTims = r1;
    }
}
