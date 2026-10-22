package com.facebook.net;

import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class TTCallerContext {
    private final Map<String, String> extraMap;
    private Object mExtr;
    private final HashMap<String, Integer> mUrlIndex;

    public TTCallerContext() {
        this.mUrlIndex = new HashMap();
        this.extraMap = new HashMap();
    }

    public Object getExtrObject() {
        return this.mExtr;
    }

    public Map<String, String> getExtraMap() {
        return this.extraMap;
    }

    public TTCallerContext(Map<String, String> r100) {
        this.mUrlIndex = new HashMap();
        this.extraMap = r100;
    }

    public String getExtra(String r100) {
        return this.extraMap.get(r100);
    }

    public int getUrlIndex(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return -1;
    L6:
        if (this.mUrlIndex.containsKey(r100) == true) goto L8;
        return -1;
    L8:
        return this.mUrlIndex.get(r100).intValue();
    }

    public void setExtrObject(Object r100) {
        this.mExtr = r100;
    }

    public TTCallerContext addExtra(String r100, String r101) {
        this.extraMap.put(r100, r101);
        return this;
    }

    public void setUrlIndex(String r100, int r101) {
        if (StringUtils.isEmpty(r100) == true) goto L8;
        if (r101 <= 0) goto L9;
        this.mUrlIndex.put(r100, Integer.valueOf(r101));
        return;
    L9:
        return;
    }
}
