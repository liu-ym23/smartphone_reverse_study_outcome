package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("( ");
        Iterator<Map.Entry<K, V>> r1 = entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<K, V> r2 = r1.next();
        r0.append('{');
        r0.append(r2.getKey());
        r0.append(':');
        r0.append(r2.getValue());
        r0.append("}, ");
        goto L4
    L7:
        if (isEmpty() == true) goto L9;
        r0.replace(r0.length() - 2, r0.length(), "");
    L9:
        r0.append(" )");
        return r0.toString();
    }

    public PrettyPrintTreeMap() {
    }
}
