package com.bytedance.webx.event;

import iq7.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import oq7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class EventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<b> f272595a = null;

    public static class MyTreeMap<K, V> extends TreeMap<K, V> {
        public static final int MAX_ID = 10000;
        private int mId;

        public void addId() {
            int r100 = this.mId + 1;
            this.mId = r100;
            if (r100 == 10000) goto L6;
            return;
        L6:
            throw new Error("listener id > 999");
        }

        private MyTreeMap() {
            this.mId = -1;
        }

        public int getId() {
            return this.mId;
        }

        public /* synthetic */ MyTreeMap(a r100) {
            this();
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface PriorityRegion {
    }

    public static /* synthetic */ class a {
    }

    public EventManager() {
    }

    static {
        f272595a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    }

    public static com.bytedance.webx.event.a b(oq7.a r100, String r101) {
        if (r100 != null) goto L6;
        kq7.a.a("EventManager");
        return null;
    L6:
        Map<String, TreeMap<Integer, com.bytedance.webx.event.a>> r102 = r100.f524894f;
        if (r102 != null) goto L9;
        return null;
    L9:
        TreeMap<Integer, com.bytedance.webx.event.a> r103 = r102.get(r101);
        if (r103 != null) goto L13;
        return null;
    L13:
        if (r103.size() > 0) goto L15;
        return null;
    L15:
        com.bytedance.webx.event.a r104 = r103.firstEntry().getValue();
        iq7.a r105 = r104.d();
        if (r105.f495386b == true) goto L18;
    L21:
        g.c();
        return a(r100, r104, r101);
    L18:
        if (r105.f495387c == false) goto L21;
        g.c();
        return r104;
    }

    public static com.bytedance.webx.event.a a(b r100, com.bytedance.webx.event.a r101, String r102) {
        Map<String, TreeMap<Integer, com.bytedance.webx.event.a>> r103 = ((oq7.a) r100).f524894f;
        if (r103 != null) goto L5;
        return null;
    L5:
        TreeMap<Integer, com.bytedance.webx.event.a> r104 = r103.get(r102);
        if (r104 != null) goto L9;
        return null;
    L9:
        if (r104.size() > 0) goto L11;
        return null;
    L11:
        Iterator<com.bytedance.webx.event.a> r105 = r104.values().iterator();
    L13:
        if (r105.hasNext() == false) goto L29;
        if (r101 != r105.next()) goto L13;
    L18:
        if (r105.hasNext() == false) goto L27;
        com.bytedance.webx.event.a r106 = r105.next();
        iq7.a r107 = r106.d();
        if (r107.f495386b == false) goto L26;
        if (r107.f495387c == false) goto L26;
        g.c();
        return r106;
    L26:
        g.c();
        goto L18
    L27:
        g.c();
        return null;
    L29:
        g.c();
        return null;
    }

    public static void c(b r100, String r101, com.bytedance.webx.event.a r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        oq7.a r103 = (oq7.a) r100;
        Map<String, TreeMap<Integer, com.bytedance.webx.event.a>> r104 = r103.f524894f;
        if (r104 != null) goto L7;
        r104 = Collections.synchronizedMap(new HashMap());
        r103.f524894f = r104;
        f272595a.add(r100);
    L7:
        MyTreeMap r105 = (MyTreeMap) r104.get(r101);
        if (r105 != null) goto L11;
        r105 = new MyTreeMap(null);
        r104.put(r101, r105);
    L11:
        if (r105.containsValue(r102) == false) goto L14;
        return;
    L14:
        monitor-enter(EventManager.class);
        r105.addId();     // Catch: Throwable -> L18
        r105.put(Integer.valueOf(5000000 + r105.getId()), r102);     // Catch: Throwable -> L18
        monitor-exit(EventManager.class);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
