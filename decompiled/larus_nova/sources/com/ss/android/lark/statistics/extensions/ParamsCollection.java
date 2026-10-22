package com.ss.android.lark.statistics.extensions;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;
import s5c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0096\u0002J\u001f\u0010\u0007\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/statistics/extensions/ParamsCollection;", "Ls5c/d;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", PickerReporterConstants.KEY.TARGET, "plus", "", "Lorg/json/JSONObject;", "toJson", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "value", "getValue", SoloKtvContext.SOLO_PAGE_FIRST, "<init>", "(Ls5c/d;)V", "statistics-base_release"}, k = 1, mv = {1, 4, 0})
public final class ParamsCollection extends HashMap<String, Object> implements d {
    private final String key;
    private final String value;

    @Override // s5c.d
    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Object> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L6:
        return r100;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
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

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    @Override // s5c.d
    public String getKey() {
        return this.key;
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public ParamsCollection(d r100) {
        super(2);
        this.key = "";
        this.value = "";
        plus(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return false;
    L5:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        return get((String) r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        if ((r100 instanceof ParamsCollection) == false) goto L5;
        putAll((Map) r100);
    L6:
        return this;
    L5:
        put(r100.getKey(), r100.getValue());
        goto L6
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

    public /* bridge */ Object get(String r100) {
        return super.get(r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L4;
        putAll(r100);
    L4:
        return this;
    }

    public /* bridge */ Object remove(String r100) {
        return super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L5;
        return r101;
    L5:
        return getOrDefault((String) r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == false) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        return remove((String) r100, r101);
    L7:
        return false;
    }

    public /* bridge */ Object getOrDefault(String r100, Object r101) {
        return super.getOrDefault(r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Object r101) {
        return super.remove(r100, r101);
    }
}
