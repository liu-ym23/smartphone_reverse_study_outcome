package com.bytedance.ttnet.httpdns;

import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class TTDnsResult {
    public int cache_source;
    public String detailed_info;
    public List<String> iplist;
    public int ret;
    public int source;

    public TTDnsResult(int r100, int r101, int r102, List<String> r103, String r104) {
        this.ret = r100;
        this.source = r101;
        this.cache_source = r102;
        this.iplist = r103;
        this.detailed_info = r104;
    }
}
