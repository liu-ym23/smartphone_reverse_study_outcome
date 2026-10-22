package com.bytedance.ttnet.tnc;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TNCConfig {
    public String httpCodeBlack;
    public boolean localEnable;
    public Map<String, Integer> localHostFilterList;
    public int probeCmd;
    public boolean probeEnable;
    public long probeVersion;
    public int reqErrApiCnt;
    public int reqErrCnt;
    public int reqErrIpCnt;
    public int reqToApiCnt;
    public int reqToCnt;
    public int reqToIpCnt;
    public int updateInterval;
    public int updateRandomRange;

    public String toString() {
        StringBuilder r100 = new StringBuilder(" localEnable: ");
        r100.append(this.localEnable);
        r100.append(" probeEnable: ");
        r100.append(this.probeEnable);
        r100.append(" hostFilter: ");
        Map<String, Integer> r101 = this.localHostFilterList;
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L6:
        r100.append(r102);
        r100.append(" reqTo: ");
        r100.append(this.reqToCnt);
        r100.append("#");
        r100.append(this.reqToApiCnt);
        r100.append("#");
        r100.append(this.reqToIpCnt);
        r100.append(" reqErr: ");
        r100.append(this.reqErrCnt);
        r100.append("#");
        r100.append(this.reqErrApiCnt);
        r100.append("#");
        r100.append(this.reqErrIpCnt);
        r100.append(" updateInterval: ");
        r100.append(this.updateInterval);
        r100.append(" updateRandom: ");
        r100.append(this.updateRandomRange);
        r100.append(" httpBlack: ");
        r100.append(this.httpCodeBlack);
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public TNCConfig() {
        this.localEnable = false;
        this.probeEnable = true;
        this.localHostFilterList = null;
        this.reqToCnt = 10;
        this.reqToApiCnt = 3;
        this.reqToIpCnt = 3;
        this.reqErrCnt = 10;
        this.reqErrApiCnt = 3;
        this.reqErrIpCnt = 3;
        this.updateInterval = 900;
        this.updateRandomRange = 120;
        this.httpCodeBlack = null;
        this.probeCmd = 0;
        this.probeVersion = 0;
    }
}
