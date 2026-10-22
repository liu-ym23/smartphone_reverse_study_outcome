package com.bytedance.android.shopping.store.tabkit.monitor;

import com.bytedance.apm.constant.UploadTypeInf;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitFramePref;", "Ljava/util/HashMap;", "", "", "()V", "map", "", "(Ljava/util/Map;)V", UploadTypeInf.TIMER, "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "recordEvent", "", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "(Ljava/lang/String;Ljava/lang/Long;)V", "recordTime", "tick", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TabkitFramePref extends HashMap<String, Long> {
    private final Timer timer;

    public TabkitFramePref() {
        this.timer = new PthreadTimer("TabkitFramePref");
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
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
    public final /* bridge */ Collection<Long> values() {
        return getValues();
    }

    public final Timer getTimer() {
        return this.timer;
    }

    public TabkitFramePref(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this();
        putAll(r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsValue((Long) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Long r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ Long get(String r1) {
        return (Long) super.get(r1);
    }

    public /* bridge */ Long remove(String r1) {
        return (Long) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if (r2 == null) goto L4;
        boolean r0 = r2 instanceof String;
    L5:
        if (r0 == true) goto L8;
        return r3;
    L8:
        return getOrDefault((String) r2, (Long) r3);
    L4:
        r0 = true;
        goto L5
    }

    public void recordEvent(String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (containsKey(r3) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L8;
        long r0 = 1;
    L9:
        put(r3, Long.valueOf(r0));
        return;
    L8:
        r0 = 0;
        goto L9
    }

    public void recordTime(String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (containsKey(r3) == false) goto L5;
        return;
    L5:
        if (r4 == null) goto L7;
        long r0 = r4.longValue();
    L8:
        put(r3, Long.valueOf(r0));
        return;
    L7:
        r0 = System.currentTimeMillis();
        goto L8
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        boolean r0 = true;
        if (r3 == null) goto L5;
        boolean r1 = r3 instanceof String;
    L6:
        if (r1 == false) goto L13;
        if (r4 == null) goto L9;
        r0 = r4 instanceof Long;
    L9:
        if (r0 == true) goto L12;
        return false;
    L12:
        return remove((String) r3, (Long) r4);
    L13:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public /* bridge */ Long getOrDefault(String r1, Long r2) {
        return (Long) super.getOrDefault(r1, r2);
    }

    public void recordEvent(String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (containsKey(r3) == false) goto L5;
        return;
    L5:
        if (r4 == null) goto L7;
        long r0 = r4.longValue();
    L8:
        put(r3, Long.valueOf(r0));
        return;
    L7:
        r0 = 0;
        goto L8
    }

    public /* bridge */ boolean remove(String r1, Long r2) {
        return super.remove(r1, r2);
    }

    public static /* synthetic */ void recordEvent$default(TabkitFramePref r0, String r1, Boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.recordEvent(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordEvent");
    }

    public static /* synthetic */ void recordTime$default(TabkitFramePref r0, String r1, Long r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.recordTime(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordTime");
    }

    public static /* synthetic */ void recordEvent$default(TabkitFramePref r0, String r1, Long r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.recordEvent(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordEvent");
    }
}
