package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> map;

    public LinkedHashMapPack() {
        this.map = new LinkedHashMap();
    }

    public LinkedHashMap<String, String> getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String r100, long r101) {
        if (r100 == null) goto L4;
        this.map.put(r100, "" + r101);
    L4:
        return this;
    }

    public LinkedHashMapPack put(String r100, boolean r101) {
        if (r100 == null) goto L6;
        if (r101 == false) goto L5;
        this.map.put(r100, "1");
        goto L6
    L5:
        this.map.put(r100, "0");
    L6:
        return this;
    }

    public LinkedHashMapPack put(String r100, String r101) {
        if (r100 == null) goto L5;
        if (r101 == null) goto L5;
        this.map.put(r100, r101);
    L5:
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String r100, long r101, long r102) {
        if (r101 != r102) goto L6;
        return this;
    L6:
        return put(r100, r101);
    }
}
