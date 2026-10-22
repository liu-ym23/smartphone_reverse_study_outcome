package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MutableTagBundle extends TagBundle {
    public static MutableTagBundle create() {
        return new MutableTagBundle(new ArrayMap());
    }

    private MutableTagBundle(Map<String, Object> r1) {
        super(r1);
    }

    public static MutableTagBundle from(TagBundle r4) {
        ArrayMap r0 = new ArrayMap();
        Iterator<String> r1 = r4.listKeys().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();
        r0.put(r2, r4.getTag(r2));
        goto L4
    L7:
        return new MutableTagBundle(r0);
    }

    public void addTagBundle(TagBundle r2) {
        Map<String, Object> r0 = this.mTagMap;
        if (r0 == null) goto L8;
        Map<String, Object> r3 = r2.mTagMap;
        if (r3 == null) goto L9;
        r0.putAll(r3);
        return;
    L9:
        return;
    }

    public void putTag(String r2, Object r3) {
        this.mTagMap.put(r2, r3);
    }
}
