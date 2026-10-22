package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.c;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\n\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/CertRuleStatusMap;", "Ljava/util/LinkedHashMap;", "", "Lmhc/a;", "Lkotlin/collections/LinkedHashMap;", "certRuleStatusMap", "tag", "", "mergeWithStatus$route_monitor_release", "(Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/CertRuleStatusMap;Ljava/lang/String;)V", "mergeWithStatus", "Lorg/json/JSONObject;", "toJsonObject$route_monitor_release", "()Lorg/json/JSONObject;", "toJsonObject", "TAG", "Ljava/lang/String;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class CertRuleStatusMap extends LinkedHashMap<String, mhc.a> {
    public static final a Companion = null;
    private final String TAG;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final JSONObject toJsonObject$route_monitor_release() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, mhc.a>> r101 = entrySet().iterator();     // Catch: Throwable -> L8
    L5:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, mhc.a> r102 = r101.next();     // Catch: Throwable -> L8
        r100.put(r102.getKey(), r102.getValue().a());     // Catch: Throwable -> L8
    L10:
        return r100;
    L8:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L10
    }

    public CertRuleStatusMap() {
        this.TAG = "CertRuleStatusMap";
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, mhc.a>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<mhc.a> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return false;
    L5:
        return containsKey((String) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof mhc.a) == true) goto L5;
        return false;
    L5:
        return containsValue((mhc.a) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        return remove((String) r100);
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(mhc.a r100) {
        return super.containsValue(r100);
    }

    public /* bridge */ mhc.a get(String r100) {
        return (mhc.a) super.get(r100);
    }

    public /* bridge */ mhc.a remove(String r100) {
        return (mhc.a) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L5;
        return r101;
    L5:
        return getOrDefault((String) r100, (mhc.a) r101);
    }

    public final void mergeWithStatus$route_monitor_release(CertRuleStatusMap r100, String r101) {
        if (r100 == null) goto L21;
        Iterator<Map.Entry<String, mhc.a>> r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, mhc.a> r103 = r102.next();
        String r104 = r103.getKey();
        mhc.a r105 = r103.getValue();
        boolean r106 = true;
        if (r105.f514025a == 1) goto L10;
        r106 = false;
    L10:
        if (r106 == true) goto L11;
        remove(r104);
        Logger.f454747c.b();
        goto L5
    L11:
        put(r104, r105);
        c.a().getClass();
        Logger r107 = Logger.f454747c;
        r105.toString();
        r107.b();
        goto L5
    L13:
        Logger r108 = Logger.f454747c;
        size();
        r100.size();
        r108.b();
        return;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L5;
        return false;
    L5:
        if ((r101 instanceof mhc.a) == true) goto L7;
        return false;
    L7:
        return remove((String) r100, (mhc.a) r101);
    }

    public /* bridge */ mhc.a getOrDefault(String r100, mhc.a r101) {
        return (mhc.a) super.getOrDefault(r100, r101);
    }

    public /* bridge */ boolean remove(String r100, mhc.a r101) {
        return super.remove(r100, r101);
    }

    public static /* synthetic */ void mergeWithStatus$route_monitor_release$default(CertRuleStatusMap r100, CertRuleStatusMap r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "";
    L5:
        r100.mergeWithStatus$route_monitor_release(r101, r102);
    }
}
