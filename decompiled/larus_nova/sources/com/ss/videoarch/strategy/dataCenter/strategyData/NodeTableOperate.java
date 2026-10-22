package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.NodeCacheInfos;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NodeTableOperate extends BaseTableOperate {
    public static String NODE_DOMAIN = "domain";
    public static String NODE_IPS = "ips";
    public static String NODE_NETWORK = "network_type";
    public static String NODE_TTL = "ttl";
    public static final String SQL_OF_NODE = null;
    public static String TABLE_NAME_NODE = "node_optimizer";
    public static StrategySQLMonitorLog mNodeStrategySQLMonitor;

    static {
        SQL_OF_NODE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_NODE + " (" + NODE_DOMAIN + " text not null," + NODE_NETWORK + " text," + NODE_IPS + " text ," + NODE_TTL + " integer,expand_value text ,update_time text,create_time timestamp not null default (datetime('now','localtime')))";
        mNodeStrategySQLMonitor = new StrategySQLMonitorLog();
    }

    public static Set<String> getAllDomain() {
        HashSet r100 = new HashSet();
        Cursor r101 = BaseTableOperate.querySQL(TABLE_NAME_NODE, "select DISTINCT " + NODE_DOMAIN + " from " + TABLE_NAME_NODE);
        if (r101 != null) goto L22;
        return r100;
    L22:
    L11:
        th = move-exception;
        r101.close();     // Catch: Exception -> L17
    L13:
        throw th;
    L6:
        if (r101.moveToNext() == false) goto L20;
        r100.add(r101.getString(0));     // Catch: Exception -> L15 Throwable -> L11
    L20:
        r101.close();     // Catch: Exception -> L16
    L14:
        return r100;
    }

    public NodeTableOperate() {
    }

    public static long insertDomain(Set<String> r110) {
        if (r110 != null) goto L5;
        return -1;
    L5:
        BaseLogInfo.inst();
        String r100 = String.valueOf(SDKMonitorUtils.getInstance(BaseLogInfo.REAL_SDK_APP_ID).getNetWorkType());
        if (BaseTableOperate.getCount(TABLE_NAME_NODE, NODE_DOMAIN, null) >= r110.size()) goto L17;
        ContentValues r101 = new ContentValues();     // Catch: Exception -> L19
        Iterator<String> r111 = r110.iterator();     // Catch: Exception -> L19
    L9:
        if (r111.hasNext() == false) goto L28;
        String r102 = r111.next();     // Catch: Exception -> L19
        int r112 = 0;
        Cursor r103 = BaseTableOperate.query(TABLE_NAME_NODE, new String[]{NODE_DOMAIN}, NODE_DOMAIN + " = ?", new String[]{r102}, null, null, null);     // Catch: Exception -> L19
        if (r103 == null) goto L14;
        r112 = r103.getCount();     // Catch: Exception -> L19
        r103.close();     // Catch: Exception -> L19
    L14:
        if (r112 != 0) goto L9;
        r101.put(NODE_DOMAIN, r102);     // Catch: Exception -> L19
        r101.put(NODE_NETWORK, r100);     // Catch: Exception -> L19
        r101.put(NODE_TTL, Integer.valueOf(LSSettings.inst().mBasePostRequestInterval));     // Catch: Exception -> L19
        r101.put("update_time", BaseTableOperate.getCurrentTimeFormat());     // Catch: Exception -> L19
        BaseTableOperate.insert(TABLE_NAME_NODE, r101);     // Catch: Exception -> L19
        r101.clear();     // Catch: Exception -> L19
        goto L9
    L28:
        return 0;
    L17:
        return 0;
    L27:
        return 0;
    }

    public static long replaceAllRecord(List<NodeCacheInfos> r100) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (r100.size() <= 0) goto L15;
        String[] r101 = {NODE_DOMAIN, NODE_NETWORK};
        ArrayList r102 = new ArrayList();
        Iterator<NodeCacheInfos> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        NodeCacheInfos r104 = r103.next();
        ContentValues r105 = new ContentValues();
        r105.put(NODE_DOMAIN, r104.mNodeDomain);
        r105.put(NODE_NETWORK, r104.mNodeNetworkType);
        r105.put(NODE_IPS, r104.mNodeIps);
        r105.put(NODE_TTL, Integer.valueOf(r104.mNodeTTL));
        r105.put("update_time", r104.mUpdateTime);
        r102.add(r105);
        goto L8
    L11:
        return BaseTableOperate.replaceAll(TABLE_NAME_NODE, r101, r102);
    L15:
        return -1;
    }

    public static HashMap<String, JSONObject> getAllData(String r110, String[] r111, String r112, String r113, String r114) {
        HashMap<String, JSONObject> r100 = new HashMap();
        Cursor r101 = BaseTableOperate.query(TABLE_NAME_NODE, new String[]{NODE_DOMAIN, NODE_NETWORK, NODE_IPS, NODE_TTL, "update_time", "create_time"}, r110, r111, r112, r113, r114);
        if (r101 != null) goto L25;
        return r100;
    L25:
        if (r101.moveToNext() == false) goto L23;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L18 Throwable -> L14
        NodeCacheInfos r103 = new NodeCacheInfos();     // Catch: Exception -> L18 Throwable -> L14
        r103.mNodeDomain = r101.getString(0);     // Catch: Exception -> L18 Throwable -> L14
        r103.mNodeNetworkType = r101.getString(1);     // Catch: Exception -> L18 Throwable -> L14
        r103.mNodeIps = r101.getString(2);     // Catch: Exception -> L18 Throwable -> L14
        r103.mNodeTTL = r101.getInt(3);     // Catch: Exception -> L18 Throwable -> L14
        r103.mUpdateTime = r101.getString(4);     // Catch: Exception -> L18 Throwable -> L14
        r103.mCreateTime = r101.getString(5);     // Catch: Exception -> L18 Throwable -> L14
        if (r100.containsKey(r103.mNodeDomain) == false) goto L10;
        r102 = r100.get(r103.mNodeDomain);     // Catch: Exception -> L18 Throwable -> L14
    L10:
        r102.put(r103.mNodeNetworkType, r103);     // Catch: Exception -> L18 Throwable -> L14
        r100.put(r103.mNodeDomain, r102);     // Catch: Exception -> L18 Throwable -> L14
        goto L25
    L14:
        th = move-exception;
        r101.close();     // Catch: Exception -> L20
    L16:
        throw th;
    L23:
        r101.close();     // Catch: Exception -> L19
    L17:
        return r100;
    }
}
