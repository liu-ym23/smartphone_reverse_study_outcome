package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class OptRecord {
    public static final int HTTP_DNS_TYPE = 1;
    private static final int IP_COUNT_PER_SOURCE = 5;
    public static final int LOCAL_DNS_TYPE = 3;
    private static final int NATIVE_RANDOM_IP_COUNT = 3;
    public static final int REMOTE_DNS_TYPE = 2;
    private static final String ipv4Addr = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static String ipv6Addr = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    private List<String> blackIPList;
    private String evaluatorSymbol;
    public int hasLocalDNSResult;
    public final String host;
    private List<String> httpDnsResult;
    private Map<Integer, List<String>> httpDnsResultMap;
    private List<String> localDnsResult;
    private Map<Integer, List<String>> localDnsResultMap;
    public int mIpMode;
    private ReentrantLock mLock;
    private final List<String> nativeSortedIps;
    public int parseType;
    private List<String> remoteLocalDnsResult;
    private Map<Integer, List<String>> remoteLocalDnsResultMap;
    private final List<String> toPingIps;

    private boolean extractPingIps() {
        this.toPingIps.clear();
        List<String> r100 = this.httpDnsResult;
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (this.localDnsResult == null) goto L22;
        if (r100.size() <= 5) goto L10;
        this.toPingIps.addAll(this.httpDnsResult.subList(0, 5));
    L11:
        ArrayList r101 = new ArrayList(this.localDnsResult);
        r101.removeAll(this.httpDnsResult);
        int r102 = 10 - this.toPingIps.size();
        if (r101.size() < r102) goto L14;
        this.toPingIps.addAll(r101.subList(0, r102));
        return true;
    L14:
        this.toPingIps.addAll(r101);
        int r103 = 10 - this.toPingIps.size();
        if ((this.httpDnsResult.size() - 5) <= r103) goto L18;
        this.toPingIps.addAll(this.httpDnsResult.subList(5, r103 + 5));
        return true;
    L18:
        if ((this.httpDnsResult.size() - 5) <= 0) goto L25;
        List<String> r104 = this.toPingIps;
        List<String> r105 = this.httpDnsResult;
        r104.addAll(r105.subList(5, r105.size()));
        return true;
    L25:
        return true;
    L10:
        this.toPingIps.addAll(this.httpDnsResult);
        goto L11
    }

    public List<String> getAllIPList() {
        ArrayList r100 = new ArrayList();
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L18;
        int r101 = DnsOptimizer.inst().mCurrentNetworkType;
        List<String> r102 = getCurrentNetworkIpList(r101, 1);
        List<String> r103 = getCurrentNetworkIpList(r101, 2);
        List<String> r104 = getCurrentNetworkIpList(r101, 3);
        if (r102 != null) goto L7;
    L9:
        if (r103 != null) goto L11;
    L13:
        if (r104 != null) goto L15;
        return r100;
    L15:
        if (r104.isEmpty() == true) goto L20;
        r100.addAll(r104);
        return r100;
    L20:
        return r100;
    L11:
        if (r103.isEmpty() == true) goto L13;
        r100.addAll(r103);
        goto L13
    L7:
        if (r102.isEmpty() == true) goto L9;
        r100.addAll(r102);
        goto L9
    L18:
        return getAllResolveResults();
    }

    public List<String> getAllResolveResults() {
        this.mLock.lock();
        ArrayList r100 = new ArrayList();
        List<String> r101 = this.httpDnsResult;
        if (r101 != null) goto L5;
    L7:
        List<String> r102 = this.remoteLocalDnsResult;
        if (r102 != null) goto L10;
    L12:
        List<String> r103 = this.localDnsResult;
        if (r103 != null) goto L15;
    L17:
        this.mLock.unlock();
        return r100;
    L15:
        if (r103.isEmpty() == true) goto L17;
        r100.addAll(this.localDnsResult);
        goto L17
    L10:
        if (r102.isEmpty() == true) goto L12;
        r100.addAll(this.remoteLocalDnsResult);
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.addAll(this.httpDnsResult);
        goto L7
    }

    public JSONArray getRemoteResults() {
        this.mLock.lock();
        JSONArray r100 = new JSONArray();
        List<String> r101 = this.httpDnsResult;
        if (r101 != null) goto L5;
    L17:
        this.mLock.unlock();
        return r100;
    L5:
        if (this.remoteLocalDnsResult == null) goto L17;
        int r102 = 0;
        if (r101.isEmpty() == true) goto L13;
        int r103 = 0;
    L10:
        if (r103 >= this.httpDnsResult.size()) goto L13;
        r100.put(ListProtector.get(this.httpDnsResult, r103));
        r103 = r103 + 1;
    L13:
        if (this.remoteLocalDnsResult.isEmpty() == true) goto L17;
    L15:
        if (r102 >= this.remoteLocalDnsResult.size()) goto L17;
        r100.put(ListProtector.get(this.remoteLocalDnsResult, r102));
        r102 = r102 + 1;
        goto L15
    }

    public List<String> getToPingIps() {
        return Collections.unmodifiableList(this.toPingIps);
    }

    public List<String> getLocalDnsResult() {
        return this.localDnsResult;
    }

    public JSONObject getEvaluatorSymbol(String r100) {
        this.mLock.lock();
        JSONObject r101 = new JSONObject();
        List<String> r102 = this.localDnsResult;
        if (r102 != null) goto L5;
    L12:
        List<String> r103 = this.remoteLocalDnsResult;
        if (r103 != null) goto L15;
    L22:
        List<String> r104 = this.httpDnsResult;
        if (r104 != null) goto L25;
    L32:
        this.mLock.unlock();
        return r101;
    L25:
        if (r104.size() == 0) goto L32;
        r101.put(FeatureManager.HTTP_DNS, new JSONArray(this.httpDnsResult));     // Catch: JSONException -> L30
        if (this.httpDnsResult.contains(r100) == false) goto L32;
        r101.put(r100, FeatureManager.HTTP_DNS);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L15:
        if (r103.size() == 0) goto L22;
        r101.put("remote_local_dns", new JSONArray(this.remoteLocalDnsResult));     // Catch: JSONException -> L20
        if (this.remoteLocalDnsResult.contains(r100) == false) goto L22;
        r101.put(r100, "remote_local_dns");     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L5:
        if (r102.size() == 0) goto L12;
        r101.put("local_dns", new JSONArray(this.localDnsResult));     // Catch: JSONException -> L10
        if (this.localDnsResult.contains(r100) == false) goto L12;
        r101.put(r100, "local_dns");     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public JSONArray newGetRemoteResults(int r100) {
        this.mLock.lock();
        JSONArray r101 = new JSONArray();
        List<String> r102 = getCurrentNetworkIpList(r100, 1);
        List<String> r103 = getCurrentNetworkIpList(r100, 2);
        int r104 = 0;
        if (r102 != null) goto L5;
    L10:
        if (r103 != null) goto L12;
    L16:
        this.mLock.unlock();
        return r101;
    L12:
        if (r103.isEmpty() == true) goto L16;
    L14:
        if (r104 >= r103.size()) goto L16;
        r101.put(ListProtector.get(r103, r104));
        r104 = r104 + 1;
        goto L14
    L5:
        if (r102.isEmpty() == true) goto L10;
        int r105 = 0;
    L8:
        if (r105 >= r102.size()) goto L10;
        r101.put(ListProtector.get(r102, r105));
        r105 = r105 + 1;
        goto L8
    }

    public boolean setHttpDnsResult(List<String> r100) {
        this.mLock.lock();
        this.httpDnsResult = r100;
        this.mLock.unlock();
        return true;
    }

    public boolean setLocalDnsResult(List<String> r100) {
        this.mLock.lock();
        this.localDnsResult = r100;
        if (r100 != null) goto L5;
    L8:
        this.hasLocalDNSResult = 0;
    L9:
        this.mLock.unlock();
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        this.hasLocalDNSResult = 1;
        goto L9
    }

    public void setParseType(int r100) {
        this.parseType = r100;
    }

    public boolean setRemoteLocalDnsResult(List<String> r100) {
        this.mLock.lock();
        this.remoteLocalDnsResult = r100;
        this.mLock.unlock();
        return true;
    }

    public void setSymbol(String r100) {
        this.evaluatorSymbol = r100;
    }

    public void updateBlackIPList(String r100) {
        this.mLock.lock();
        this.blackIPList.add(r100);
        this.mLock.unlock();
    }

    public OptRecord(String r100, int r101) {
        this.parseType = 0;
        this.httpDnsResult = new ArrayList();
        this.localDnsResult = new ArrayList();
        this.remoteLocalDnsResult = new ArrayList();
        this.httpDnsResultMap = new HashMap();
        this.localDnsResultMap = new HashMap();
        this.remoteLocalDnsResultMap = new HashMap();
        this.blackIPList = new ArrayList();
        this.mLock = new ReentrantLock();
        this.toPingIps = new ArrayList(10);
        this.nativeSortedIps = new ArrayList();
        this.evaluatorSymbol = null;
        this.hasLocalDNSResult = -1;
        this.mIpMode = 2;
        this.host = r100;
        this.parseType = r101;
    }

    private List<String> getCurrentNetworkIpList(int r100, int r101) {
        if (r101 != 1) goto L5;
        Map<Integer, List<String>> r102 = this.httpDnsResultMap;
        if (r102 != null) goto L24;
        return null;
    L24:
        if (r102.containsKey(Integer.valueOf(r100)) == true) goto L26;
        return null;
    L26:
        return this.httpDnsResultMap.get(Integer.valueOf(r100));
    L5:
        if (r101 != 2) goto L7;
        Map<Integer, List<String>> r103 = this.remoteLocalDnsResultMap;
        if (r103 != null) goto L18;
        return null;
    L18:
        if (r103.containsKey(Integer.valueOf(r100)) == true) goto L20;
        return null;
    L20:
        return this.remoteLocalDnsResultMap.get(Integer.valueOf(r100));
    L7:
        if (r101 != 3) goto L34;
        Map<Integer, List<String>> r104 = this.localDnsResultMap;
        if (r104 != null) goto L12;
        return null;
    L12:
        if (r104.containsKey(Integer.valueOf(r100)) == true) goto L14;
        return null;
    L14:
        return this.localDnsResultMap.get(Integer.valueOf(r100));
    L34:
        return null;
    }

    private String getIpAsType(List<String> r100, int r101) {
        if (r100 != null) goto L5;
    L25:
        return null;
    L5:
        if (r100.size() == 0) goto L25;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptIpValid != 1) goto L10;
        boolean r102 = true;
    L11:
        if (r101 != 1) goto L18;
        Iterator<String> r103 = r100.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (isValidIpv6Addr(r104, r102) == false) goto L14;
        return r104;
    L18:
        if (r101 != 0) goto L25;
        Iterator<String> r105 = r100.iterator();
    L21:
        if (r105.hasNext() == false) goto L25;
        String r106 = r105.next();
        if (isValidIpv4Addr(r106, r102) == false) goto L21;
        return r106;
    L10:
        r102 = false;
        goto L11
    }

    public static boolean isValidIpv4Addr(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r101 == true) goto L7;
        String r102 = Normalizer.normalize(r100, Normalizer.Form.NFKC);     // Catch: Exception -> L10
        return PatternProtector.compile(ipv4Addr).matcher(r102).matches();
    L10:
        return false;
    L7:
        return r100.contains(".");
    }

    public static boolean isValidIpv6Addr(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r101 == true) goto L8;
        String r102 = Normalizer.normalize(r100, Normalizer.Form.NFKC);
        return PatternProtector.compile(ipv6Addr).matcher(r102).matches();
    L8:
        return r100.contains(":");
    }

    public List<String> getIpListByKey(int r110, int r111) {
        ArrayList r100 = new ArrayList();
        HashSet r101 = new HashSet();
        this.mLock.lock();
        List<String> r102 = this.httpDnsResult;
        List<String> r103 = this.localDnsResult;
        int r104 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredHttpIpCount;
        int r112 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredLocalIpCount;
        getIpResultFromRecord(r110, r111, r102, r100, r101, r104);
        getIpResultFromRecord(r110, r111, r103, r100, r101, r112);
        this.mLock.unlock();
        return r100;
    }

    public String lookup(boolean r100, int r101) {
        this.mLock.lock();
        List<String> r102 = this.httpDnsResult;
        List<String> r103 = this.remoteLocalDnsResult;
        List<String> r104 = this.localDnsResult;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableCheckHttpDnsAndLocalIntersection != 1) goto L15;
        List<String> r105 = this.httpDnsResult;
        if (r105 == null) goto L15;
        if (r105.size() <= 0) goto L15;
        List<String> r106 = this.localDnsResult;
        if (r106 == null) goto L15;
        if (r106.size() <= 0) goto L15;
        if (Collections.disjoint(this.httpDnsResult, this.localDnsResult) == false) goto L15;
        r102 = this.remoteLocalDnsResult;
        r103 = this.httpDnsResult;
    L15:
        if (r102 != null) goto L17;
    L21:
        if (r103 != null) goto L23;
    L27:
        if (r104 == null) goto L34;
        if (r104.isEmpty() == true) goto L34;
        if (this.blackIPList.size() <= 0) goto L34;
        r104.removeAll(this.blackIPList);
    L34:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptIpValid != 1) goto L36;
        boolean r107 = true;
    L38:
        if (DnsOptimizer.inst().mCurrentNetworkType == 4) goto L40;
    L65:
        if (r102 != null) goto L67;
    L70:
        if (r103 != null) goto L72;
    L75:
        if (r104 != null) goto L77;
    L91:
        this.mLock.unlock();
        return null;
    L77:
        if (r104.isEmpty() == true) goto L91;
        Iterator<String> r108 = r104.iterator();
    L80:
        if (r108.hasNext() == false) goto L89;
        String r109 = r108.next();
        if (isValidIpv6Addr(r109, r107) == true) goto L83;
        if (r100 == true) goto L80;
        this.mLock.unlock();
        return r109;
    L83:
        if (r100 == false) goto L80;
        this.mLock.unlock();
        return r109;
    L89:
        String r110 = (String) ListProtector.get(r104, 0);
        this.mLock.unlock();
        return r110;
    L72:
        if (r103.isEmpty() == true) goto L75;
        String r111 = (String) ListProtector.get(r103, 0);
        this.mLock.unlock();
        return r111;
    L67:
        if (r102.isEmpty() == true) goto L70;
        String r112 = (String) ListProtector.get(r102, 0);
        this.mLock.unlock();
        return r112;
    L40:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mForbidUseIpv6InWiFi != 1) goto L65;
        if (r102 == null) goto L49;
        Iterator<String> r113 = r102.iterator();
    L44:
        if (r113.hasNext() == false) goto L49;
        String r114 = r113.next();
        if (isValidIpv6Addr(r114, r107) == true) goto L44;
        this.mLock.unlock();
        return r114;
    L49:
        if (r103 == null) goto L57;
        Iterator<String> r115 = r103.iterator();
    L52:
        if (r115.hasNext() == false) goto L57;
        String r116 = r115.next();
        if (isValidIpv6Addr(r116, r107) == true) goto L52;
        this.mLock.unlock();
        return r116;
    L57:
        if (r104 == null) goto L65;
        Iterator<String> r117 = r104.iterator();
    L60:
        if (r117.hasNext() == false) goto L65;
        String r118 = r117.next();
        if (isValidIpv6Addr(r118, r107) == true) goto L60;
        this.mLock.unlock();
        return r118;
    L36:
        r107 = false;
        goto L38
    L23:
        if (r103.isEmpty() == true) goto L27;
        if (this.blackIPList.size() <= 0) goto L27;
        r103.removeAll(this.blackIPList);
        goto L27
    L17:
        if (r102.isEmpty() == true) goto L21;
        if (this.blackIPList.size() <= 0) goto L21;
        r102.removeAll(this.blackIPList);
        goto L21
    }

    public JSONObject newGetEvaluatorSymbol(String r100, int r101) {
        this.mLock.lock();
        JSONObject r102 = new JSONObject();
        List<String> r103 = getCurrentNetworkIpList(r101, 3);
        if (r103 != null) goto L5;
    L12:
        List<String> r104 = getCurrentNetworkIpList(r101, 2);
        if (r104 != null) goto L15;
    L22:
        List<String> r105 = getCurrentNetworkIpList(r101, 1);
        if (r105 != null) goto L25;
    L32:
        this.mLock.unlock();
        return r102;
    L25:
        if (r105.size() <= 0) goto L32;
        r102.put(FeatureManager.HTTP_DNS, new JSONArray(r105));     // Catch: JSONException -> L30
        if (r105.contains(r100) == false) goto L32;
        r102.put(r100, FeatureManager.HTTP_DNS);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L15:
        if (r104.size() <= 0) goto L22;
        r102.put("remote_local_dns", new JSONArray(r104));     // Catch: JSONException -> L20
        if (r104.contains(r100) == false) goto L22;
        r102.put(r100, "remote_local_dns");     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L5:
        if (r103.size() <= 0) goto L12;
        r102.put("local_dns", new JSONArray(r103));     // Catch: JSONException -> L10
        if (r103.contains(r100) == false) goto L12;
        r102.put(r100, "local_dns");     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public List<String> getIpListByKeyWithNetworkType(int r110, int r111, int r112) {
        ArrayList r100 = new ArrayList();
        HashSet r101 = new HashSet();
        this.mLock.lock();
        int r102 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredHttpIpCount;
        int r103 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredLocalIpCount;
        List<String> r104 = getCurrentNetworkIpList(r112, 1);
        List<String> r113 = getCurrentNetworkIpList(r112, 3);
        getIpResultFromRecord(r110, r111, r104, r100, r101, r102);
        getIpResultFromRecord(r110, r111, r113, r100, r101, r103);
        this.mLock.unlock();
        return r100;
    }

    public String newLookUp(boolean r100, int r101, int r102) {
        this.mLock.lock();
        List<String> r103 = getCurrentNetworkIpList(r101, 1);
        List<String> r104 = getCurrentNetworkIpList(r101, 2);
        List<String> r105 = getCurrentNetworkIpList(r101, 3);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableCheckHttpDnsAndLocalIntersection != 1) goto L13;
        if (r103 == null) goto L13;
        if (r103.size() <= 0) goto L13;
        if (r105 == null) goto L13;
        if (r105.size() <= 0) goto L13;
        if (Collections.disjoint(r103, r105) == false) goto L13;
        r104 = r103;
        r103 = r104;
    L13:
        ArrayList r106 = new ArrayList();
        if (r103 != null) goto L16;
    L21:
        if (r104 != null) goto L23;
    L28:
        if (r105 == null) goto L36;
        if (r105.size() <= 0) goto L36;
        if (this.blackIPList.size() <= 0) goto L34;
        r105.removeAll(this.blackIPList);
    L34:
        r106.addAll(r105);
    L36:
        if (r102 == (-1)) goto L41;
        String r107 = getIpAsType(r106, r102);
        if (r107 == null) goto L43;
        this.mLock.unlock();
        return r107;
    L43:
        if (r103 != null) goto L45;
    L48:
        if (r104 != null) goto L50;
    L53:
        if (r105 != null) goto L55;
    L73:
        this.mLock.unlock();
        return r107;
    L55:
        if (r105.size() <= 0) goto L73;
        Iterator<String> r108 = r105.iterator();
    L58:
        if (r108.hasNext() == false) goto L71;
        String r109 = r108.next();
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptIpValid != 1) goto L62;
        boolean r110 = true;
    L64:
        if (isValidIpv6Addr(r109, r110) == true) goto L65;
        if (r100 == true) goto L58;
        this.mLock.unlock();
        return r109;
    L65:
        if (r100 == false) goto L58;
        this.mLock.unlock();
        return r109;
    L62:
        r110 = false;
        goto L64
    L71:
        String r111 = (String) ListProtector.get(r105, 0);
        this.mLock.unlock();
        return r111;
    L50:
        if (r104.size() <= 0) goto L53;
        String r112 = (String) ListProtector.get(r104, 0);
        this.mLock.unlock();
        return r112;
    L45:
        if (r103.size() <= 0) goto L48;
        String r113 = (String) ListProtector.get(r103, 0);
        this.mLock.unlock();
        return r113;
    L41:
        r107 = null;
        goto L43
    L23:
        if (r104.size() <= 0) goto L28;
        if (this.blackIPList.size() <= 0) goto L27;
        r104.removeAll(this.blackIPList);
    L27:
        r106.addAll(r104);
        goto L28
    L16:
        if (r103.size() <= 0) goto L21;
        if (this.blackIPList.size() <= 0) goto L20;
        r103.removeAll(this.blackIPList);
    L20:
        r106.addAll(r103);
        goto L21
    }

    public boolean setDnsResult(List<String> r100, int r101, int r102) {
        this.mLock.lock();
        if (r101 != 1) goto L5;
        Map<Integer, List<String>> r103 = this.httpDnsResultMap;
        if (r103 == null) goto L18;
        r103.put(Integer.valueOf(r102), r100);
    L18:
        this.mLock.unlock();
        return true;
    L5:
        if (r101 != 2) goto L7;
        Map<Integer, List<String>> r104 = this.remoteLocalDnsResultMap;
        if (r104 == null) goto L18;
        r104.put(Integer.valueOf(r102), r100);
        goto L18
    L7:
        if (r101 != 3) goto L18;
        Map<Integer, List<String>> r105 = this.localDnsResultMap;
        if (r105 == null) goto L18;
        r105.put(Integer.valueOf(r102), r100);
        goto L18
    }

    public void getIpResultFromRecord(int r110, int r111, List<String> r112, List<String> r113, Set<String> r114, int r115) {
        int r100 = r113.size();
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptIpValid != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r112 != null) goto L8;
        return;
    L8:
        if (r112.isEmpty() == true) goto L35;
        Iterator<String> r116 = r112.iterator();
        int r102 = 0;
    L11:
        if (r116.hasNext() == false) goto L36;
        String r103 = r116.next();
        if (r102 >= r115) goto L37;
        if (r100 >= r111) goto L38;
        if (r110 == 0) goto L20;
        if (r110 == 1) goto L19;
        boolean r104 = false;
    L21:
        if (r104 == false) goto L11;
        if (r114.contains(r103) == true) goto L11;
        r113.add(r103);
        r114.add(r103);
        r100 = r100 + 1;
        r102 = r102 + 1;
        goto L11
    L19:
        r104 = isValidIpv6Addr(r103, r101);
        r103 = "[" + r103 + ']';
        goto L21
    L20:
        r104 = isValidIpv4Addr(r103, r101);
        goto L21
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
