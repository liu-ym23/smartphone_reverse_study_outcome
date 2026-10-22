package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.a;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
import vx5.d;

/* JADX INFO: loaded from: classes3.dex */
public class TTMetaDispatchManager {
    private static volatile TTMetaDispatchManager mInstance;
    private static TTMetaDispatchConfig mTncConfig;
    private static final ReentrantReadWriteLock mTncConfigLock = null;

    static {
        mTncConfigLock = new ReentrantReadWriteLock();
    }

    public static TTMetaDispatchManager getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTMetaDispatchManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTMetaDispatchManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMetaDispatchManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private TTMetaDispatchManager() {
    }

    public static void onServerConfigChanged(JSONObject r100) {
        ReentrantReadWriteLock r101 = mTncConfigLock;     // Catch: Throwable -> L16
        r101.writeLock().lock();     // Catch: Throwable -> L16
        TTMetaDispatchConfig r102 = new TTMetaDispatchConfig();     // Catch: Throwable -> L16
        mTncConfig = r102;     // Catch: Throwable -> L16
        if (r100 != null) goto L7;
        r101.writeLock().unlock();
        return;
    L7:
        if (r102.parseTNCConfig(r100) == true) goto L9;
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<a, TTMetaDispatchValue>> r103 = mTncConfig.getmRuleList();     // Catch: Throwable -> L16
        if (r103 != null) goto L12;
    L13:
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L14:
        r101.writeLock().unlock();
        return;
    L12:
        if (r103.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        mTncConfigLock.writeLock().unlock();
        throw th;
    }

    private List<Header> handleHeader(Request r100, TTMetaDispatchValue r101, TTMetaDispatchLog r102) {
        ArrayList r103 = null;
        if (r100 == null) goto L49;
        if (r101 == null) goto L49;
        if (r102 == null) goto L49;
        if (CollectionUtils.isEmpty(r101.headerRmSet) == false) goto L15;
        Map<String, String> r104 = r101.headerAddMap;
        if (r104 != null) goto L12;
    L13:
        return null;
    L12:
        if (r104.isEmpty() == true) goto L13;
    L15:
        if (r100.getHeaders() != null) goto L17;
        r103 = new ArrayList();
    L19:
        if (CollectionUtils.isEmpty(r103) == false) goto L21;
    L31:
        Map<String, String> r105 = r101.headerAddMap;
        if (r105 == null) goto L49;
        if (r105.isEmpty() == true) goto L49;
        Iterator<Map.Entry<String, String>> r106 = r101.headerAddMap.entrySet().iterator();
    L37:
        if (r106.hasNext() == false) goto L49;
        Map.Entry<String, String> r107 = r106.next();
        if (r107 == null) goto L37;
        if (TextUtils.isEmpty(r107.getKey()) == true) goto L37;
        if (r107.getValue() == null) goto L37;
        r103.add(new Header(r107.getKey(), r107.getValue()));
        if (r102.headerAdd != null) goto L48;
        r102.headerAdd = new HashSet();
    L48:
        r102.headerAdd.add(r107.getKey());
        goto L37
    L21:
        if (CollectionUtils.isEmpty(r101.headerRmSet) == true) goto L31;
        Iterator<String> r108 = r101.headerRmSet.iterator();
    L24:
        if (r108.hasNext() == false) goto L31;
        String r109 = r108.next();
        List<Header> r110 = r100.headers(r109);
        if (r110 == null) goto L24;
        r103.removeAll(r110);
        if (r102.headerRm != null) goto L30;
        r102.headerRm = new HashSet();
    L30:
        r102.headerRm.add(r109);
        goto L24
    L17:
        r103 = new ArrayList(r100.getHeaders());
    L49:
        return r103;
    }

    private boolean handleQuery(Map<String, List<String>> r100, TTMetaDispatchValue r101, TTMetaDispatchLog r102) {
        boolean r103 = false;
        if (r101 == null) goto L41;
        if (r102 == null) goto L41;
        if (r100.isEmpty() == false) goto L9;
    L21:
        Map<String, String> r104 = r101.queryAddMap;
        if (r104 == null) goto L41;
        if (r104.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r105 = r101.queryAddMap.entrySet().iterator();
    L27:
        if (r105.hasNext() == false) goto L41;
        Map.Entry<String, String> r106 = r105.next();
        if (r106 == null) goto L27;
        if (TextUtils.isEmpty(r106.getKey()) == true) goto L27;
        if (r106.getValue() == null) goto L27;
        String r107 = r106.getKey();
        List<String> r108 = r100.get(r107);
        if (r108 != null) goto L37;
        r108 = new ArrayList();
        r100.put(r107, r108);
    L37:
        r108.add(r106.getValue());
        if (r102.queryAdd != null) goto L40;
        r102.queryAdd = new HashSet();
    L40:
        r102.queryAdd.add(r106.getKey());
        r103 = true;
        goto L27
    L9:
        if (CollectionUtils.isEmpty(r101.queryRmSet) == true) goto L21;
        Iterator<String> r109 = r101.queryRmSet.iterator();
    L12:
        if (r109.hasNext() == false) goto L21;
        String r110 = r109.next();
        if (TextUtils.isEmpty(r110) == true) goto L12;
        if (r100.remove(r110) == null) goto L12;
        if (r102.queryRm != null) goto L20;
        r102.queryRm = new HashSet();
    L20:
        r102.queryRm.add(r110);
        r103 = true;
    L41:
        return r103;
    }

    public String dispatch(String r100, Request r101, TTMetaDispatchLog r102, List<Header> r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        ReentrantReadWriteLock r105 = mTncConfigLock;
        r105.readLock().lock();
        Pair<String, String> r106 = null;
        boolean r107 = false;
        TTMetaDispatchConfig r108 = mTncConfig;     // Catch: Throwable -> L22
        if (r108 != null) goto L6;
    L10:
        r105.readLock().unlock();
        return r100;
    L6:
        if (r108.isEnabled() == false) goto L10;
        TTMetaDispatchValue r109 = mTncConfig.getValue(r100);     // Catch: Throwable -> L22
        if (r109 == null) goto L10;
        List<Header> r110 = handleHeader(r101, r109, r102);     // Catch: Throwable -> L22
        if (CollectionUtils.isEmpty(r110) == true) goto L36;
        r103.addAll(r110);     // Catch: Throwable -> L22
    L36:
        r106 = UrlUtils.parseUrlWithValueList(r100, r104);     // Catch: Throwable -> L17
    L19:
        if (r106 == null) goto L24;
        r107 = handleQuery(r104, r109, r102);     // Catch: Throwable -> L22
    L24:
        mTncConfigLock.readLock().unlock();
        if (r107 == true) goto L28;
        return r100;
    L28:
        return d.b(r100, r106, r104);
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        mTncConfigLock.readLock().unlock();
        throw th;
    }
}
