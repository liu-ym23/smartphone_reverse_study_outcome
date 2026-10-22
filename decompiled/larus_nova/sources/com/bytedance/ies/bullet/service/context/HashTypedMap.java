package com.bytedance.ies.bullet.service.context;

import com.amap.api.col.s.ce;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00042\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/service/context/HashTypedMap;", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "", ce.f26396k, "", "getBoolean", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "", "getString", "(Ljava/lang/Object;)Ljava/lang/String;", "getAny", "(Ljava/lang/Object;)Ljava/lang/Object;", BaseSwitches.V, "putAnyIfAbsent", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "putBooleanIfAbsent", "(Ljava/lang/Object;Z)Z", "putStringIfAbsent", "(Ljava/lang/Object;Ljava/lang/String;)Z", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class HashTypedMap<K, V> extends HashMap<K, V> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) getEntries();
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    public HashTypedMap() {
    }

    public V getAny(K r100) {
        return get(r100);
    }

    public Boolean getBoolean(K r100) {
        V r101 = get(r100);
        if ((r101 instanceof Boolean) == true) goto L7;
        return null;
    L7:
        return (Boolean) r101;
    }

    public String getString(K r100) {
        V r101 = get(r100);
        if ((r101 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r101;
    }

    public boolean putAnyIfAbsent(K r100, V r101) {
        if (containsKey(r100) == false) goto L6;
        return false;
    L6:
        put(r100, r101);
        return true;
    }

    public boolean putBooleanIfAbsent(K r100, boolean r101) {
        if (containsKey(r100) == false) goto L12;
        return false;
    L12:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(put(r100, Boolean.valueOf(r101)));     // Catch: Throwable -> L8
    L11:
        return Result.m9456isSuccessimpl(r103);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean putStringIfAbsent(K r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        if (containsKey(r100) == false) goto L12;
        return false;
    L12:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(put(r100, r101));     // Catch: Throwable -> L8
    L11:
        return Result.m9456isSuccessimpl(r103);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
