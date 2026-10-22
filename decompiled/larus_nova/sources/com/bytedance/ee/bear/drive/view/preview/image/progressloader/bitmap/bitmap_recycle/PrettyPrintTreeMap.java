package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes16.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("( ");
        Iterator<Map.Entry<K, V>> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<K, V> r102 = r101.next();
        r100.append('{');
        r100.append(r102.getKey());
        r100.append(':');
        r100.append(r102.getValue());
        r100.append("}, ");
        goto L4
    L7:
        if (isEmpty() == true) goto L9;
        r100.replace(r100.length() - 2, r100.length(), "");
    L9:
        r100.append(" )");
        return r100.toString();
    }

    public PrettyPrintTreeMap() {
    }
}
