package com.ss.videoarch.strategy.dataCenter.strategyData.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.strategyData.BaseTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.NodeTableOperate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NodeCacheInfos {
    public String mCreateTime;
    public String mNodeDomain;
    public String mNodeIps;
    public String mNodeNetworkType;
    public int mNodeTTL;
    public String mUpdateTime;

    public String getIpFromIps() {
        String r100 = this.mNodeIps;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (this.mNodeIps.equals("none") == true) goto L15;
        String[] r101 = this.mNodeIps.split(",");
        if (r101.length > 0) goto L11;
        return null;
    L11:
        return r101[0];
    L15:
        return null;
    }

    public String toString() {
        return "domain: " + this.mNodeDomain + ",network:" + this.mNodeNetworkType + ",ips:" + this.mNodeIps + ",ttl:" + this.mNodeTTL + ",update_time:" + this.mUpdateTime;
    }

    public NodeCacheInfos() {
        this.mNodeDomain = "none";
        this.mNodeNetworkType = "none";
        this.mNodeIps = "none";
        this.mNodeTTL = 300000;
        this.mUpdateTime = "";
        this.mCreateTime = "";
    }

    public JSONObject queryIp(String r110, String r111) {
        JSONObject r100 = new JSONObject();
        Cursor r112 = BaseTableOperate.query(NodeTableOperate.TABLE_NAME_NODE, new String[]{NodeTableOperate.NODE_IPS, "update_time"}, NodeTableOperate.NODE_DOMAIN + " = ? and " + NodeTableOperate.NODE_NETWORK + " = ? ", new String[]{r110, String.valueOf(r111)}, null, null, null);
        if (r112 != null) goto L31;
    L21:
        int r101 = -1;
    L22:
        r100.put("code", -1);     // Catch: Throwable -> L18 Exception -> L20
        r100.put("reason", r101);     // Catch: Throwable -> L18 Exception -> L20
        if (r112 != null) goto L29;
    L30:
        return r100;
    L29:
        r112.close();
        goto L30
    L31:
    L18:
        th = move-exception;
        if (r112 == null) goto L27;
        r112.close();
    L27:
        throw th;
    L5:
        if (r112.getCount() == 0) goto L21;
        r101 = -1;
    L8:
        if (r112.moveToNext() == false) goto L22;
        this.mNodeIps = r112.getString(0);     // Catch: Throwable -> L18 Exception -> L20
        String r102 = r112.getString(1);     // Catch: Throwable -> L18 Exception -> L20
        this.mUpdateTime = r102;     // Catch: Throwable -> L18 Exception -> L20
        if (BaseTableOperate.calDiffOfTime(r102, BaseTableOperate.getCurrentTimeFormat()) >= LSSettings.inst().mPersistenceConfigInfo.mNodeCacheTime) goto L12;
        String r103 = getIpFromIps();     // Catch: Throwable -> L18 Exception -> L20
        int r104 = 0;
    L13:
        if (r103 != null) goto L14;
        r101 = r104;
        goto L8
    L14:
        r100.put("Ip", r103);     // Catch: Throwable -> L18 Exception -> L20
        r100.put("code", 0);     // Catch: Throwable -> L18 Exception -> L20
        r100.put("reason", r104);     // Catch: Throwable -> L18 Exception -> L20
        r112.close();
        return r100;
    L12:
        r103 = null;
        r104 = 1;
        goto L13
    L28:
        if (r112 == null) goto L30;
        goto L29
    }
}
