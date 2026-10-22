package com.bytedance.geckox;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class OptionCheckUpdateParams {
    private Map<String, Map<String, Object>> customParam;
    private boolean enableDownloadAutoRetry;
    private boolean enableRetry;
    private boolean enableThrottle;
    private boolean lazyUpdate;
    private GeckoUpdateListener listener;
    private boolean requestWhenHasLocalVersion;
    private String tag;
    private int updatePriority;

    /* JADX INFO: loaded from: classes19.dex */
    public interface ChannelUpdatePriority {
        public static final int HIGH = 2;
        public static final int LOW = 0;
        public static final int MIDDLE = 1;
        public static final int USE_INTERACTION = 3;
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface CustomValue {
        Object getValue();
    }

    public OptionCheckUpdateParams() {
        this.enableThrottle = true;
        this.customParam = new HashMap();
        this.enableRetry = true;
        this.enableDownloadAutoRetry = true;
        this.updatePriority = 1;
        this.requestWhenHasLocalVersion = true;
        this.tag = null;
    }

    public int getChannelUpdatePriority() {
        return this.updatePriority;
    }

    public Map<String, Map<String, Object>> getCustomParam() {
        return this.customParam;
    }

    public GeckoUpdateListener getListener() {
        return this.listener;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isEnableDownloadAutoRetry() {
        return this.enableDownloadAutoRetry;
    }

    public boolean isEnableRetry() {
        return this.enableRetry;
    }

    public boolean isEnableThrottle() {
        return this.enableThrottle;
    }

    public boolean isLazyUpdate() {
        return this.lazyUpdate;
    }

    public boolean isRequestWhenHasLocalVersion() {
        return this.requestWhenHasLocalVersion;
    }

    public OptionCheckUpdateParams setChannelUpdatePriority(int r100) {
        this.updatePriority = r100;
        return this;
    }

    public OptionCheckUpdateParams setCustomParam(Map<String, Map<String, Object>> r100) {
        this.customParam = r100;
        return this;
    }

    public OptionCheckUpdateParams setEnableDownloadAutoRetry(boolean r100) {
        this.enableDownloadAutoRetry = r100;
        return this;
    }

    public OptionCheckUpdateParams setEnableRetry(boolean r100) {
        this.enableRetry = r100;
        return this;
    }

    public OptionCheckUpdateParams setEnableThrottle(boolean r100) {
        this.enableThrottle = r100;
        return this;
    }

    public OptionCheckUpdateParams setLazyUpdate(boolean r100) {
        this.lazyUpdate = r100;
        return this;
    }

    public OptionCheckUpdateParams setListener(GeckoUpdateListener r100) {
        this.listener = r100;
        return this;
    }

    public OptionCheckUpdateParams setRequestWhenHasLocalVersion(boolean r100) {
        this.requestWhenHasLocalVersion = r100;
        return this;
    }

    public void setTag(String r100) {
        this.tag = r100;
    }
}
