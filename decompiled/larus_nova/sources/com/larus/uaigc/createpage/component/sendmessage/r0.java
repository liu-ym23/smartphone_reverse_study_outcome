package com.larus.uaigc.createpage.component.sendmessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes31.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f372417a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f372418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f372419b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f372418a == r101.f372418a) goto L12;
            return false;
        L12:
            if (this.f372419b == r101.f372419b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f372418a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f372419b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "VideoContext(maxDurationSeconds=" + this.f372418a + ", updatedAtMs=" + this.f372419b + ')';
        }

        public a(long r100, long r101) {
            this.f372418a = r100;
            this.f372419b = r101;
        }
    }

    static {
        f372417a = new ConcurrentHashMap();
    }

    public static void a() {
        long r100 = System.currentTimeMillis() - 300000;
        Set<Map.Entry<String, a>> r101 = f372417a.entrySet();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((a) ((Map.Entry) r104).getValue()).f372419b >= r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        Iterator r106 = r102.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        Map.Entry r107 = (Map.Entry) r106.next();
        f372417a.remove(r107.getKey(), r107.getValue());
        goto L13
    }
}
