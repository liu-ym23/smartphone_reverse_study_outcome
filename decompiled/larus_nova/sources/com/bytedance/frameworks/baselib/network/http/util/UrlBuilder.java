package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UrlBuilder {
    private final Map<String, List<String>> mParamMap;
    private String mUrl;

    public String build() {
        if (this.mParamMap.isEmpty() == true) goto L5;
        String r100 = UrlUtils.format(this.mParamMap, "UTF-8");
        String r101 = this.mUrl;
        if (r101 != null) goto L9;
        return r100;
    L9:
        if (r101.length() != 0) goto L12;
        return r100;
    L12:
        if (this.mUrl.indexOf(63) < 0) goto L16;
        return this.mUrl + "&" + r100;
    L16:
        return this.mUrl + "?" + r100;
    L5:
        return this.mUrl;
    }

    public Map<String, String> getParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, List<String>> r101 = this.mParamMap;
        if (r101 != null) goto L5;
    L19:
        return r100;
    L5:
        if (r101.size() <= 0) goto L19;
        Iterator<Map.Entry<String, List<String>>> r102 = this.mParamMap.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<String, List<String>> r103 = r102.next();
        String r104 = r103.getKey();
        if (StringUtils.isEmpty(r104) == true) goto L8;
        List<String> r105 = r103.getValue();
        if (r105 != null) goto L15;
    L17:
        String r106 = "";
    L18:
        r100.put(r104, r106);
        goto L8
    L15:
        if (r105.size() <= 0) goto L17;
        r106 = (String) ListProtector.get(r105, 0);
        goto L18
    }

    public UrlBuilder() {
        this.mParamMap = new LinkedHashMap();
        this.mUrl = null;
    }

    public String toString() {
        return build();
    }

    public Map<String, List<String>> getParamsWithValueList() {
        return this.mParamMap;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public UrlBuilder(String r100) {
        this.mParamMap = new LinkedHashMap();
        this.mUrl = r100;
    }

    public void setUrl(String r100) {
        this.mUrl = r100;
    }

    public void addParam(String r100, double r101) {
        List<String> r102 = this.mParamMap.get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedList();
    L5:
        r102.add(String.valueOf(r101));
        this.mParamMap.put(r100, r102);
    }

    public void addParam(String r100, int r101) {
        List<String> r102 = this.mParamMap.get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedList();
    L5:
        r102.add(String.valueOf(r101));
        this.mParamMap.put(r100, r102);
    }

    public void addParam(String r100, long r101) {
        List<String> r102 = this.mParamMap.get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedList();
    L5:
        r102.add(String.valueOf(r101));
        this.mParamMap.put(r100, r102);
    }

    public void addParam(String r100, String r101) {
        List<String> r102 = this.mParamMap.get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedList();
    L5:
        r102.add(String.valueOf(r101));
        this.mParamMap.put(r100, r102);
    }
}
