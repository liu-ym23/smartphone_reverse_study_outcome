package com.ttnet.org.chromium.base;

import android.util.Pair;
import com.android.ttcjpaysdk.base.wxpay.CJPayWXPaymentService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean[] booleanListToBooleanArray(List<Boolean> r100) {
        boolean[] r101 = new boolean[r100.size()];
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101[r102] = ((Boolean) ListProtector.get(r100, r102)).booleanValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int[] integerListToIntArray(List<Integer> r100) {
        int[] r101 = new int[r100.size()];
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101[r102] = ((Integer) ListProtector.get(r100, r102)).intValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static long[] longListToLongArray(List<Long> r100) {
        long[] r101 = new long[r100.size()];
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101[r102] = ((Long) ListProtector.get(r100, r102)).longValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... r100) {
        CJPayWXPaymentService.AnonymousClass3 r101 = (HashMap<K, V>) new HashMap();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<? extends K, ? extends V> r104 = r100[r103];
        r101.put(r104.first, r104.second);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... r100) {
        HashSet<E> r101 = new HashSet(r100.length);
        Collections.addAll(r101, r100);
        return r101;
    }

    public static <T> List<T> strengthen(Collection<WeakReference<T>> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<WeakReference<T>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        T r103 = r102.next().get();
        if (r103 == null) goto L7;
        r101.add(r103);
        goto L4
    L7:
        r102.remove();
        goto L4
    L9:
        return r101;
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> r100, Callback<Map.Entry<K, V>> r101) {
        Iterator<Map.Entry<? extends K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.onResult(r102.next());
        goto L4
    }

    public static <T> void forEach(Collection<? extends T> r100, Callback<T> r101) {
        Iterator<? extends T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.onResult(r102.next());
        goto L4
    }
}
