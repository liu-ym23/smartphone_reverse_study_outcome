package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v<E extends Comparable> {
    public final PriorityQueue<E> a;
    public final int b;

    public class a implements Comparator<E> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((Comparable) r1).compareTo((Comparable) r2);
        }
    }

    public final List<E> b() {
        ArrayList r0 = new ArrayList(this.a);
        Collections.sort(r0);
        return r0;
    }

    public v(int r3) {
        if (r3 <= 0) goto L7;
        this.b = r3;
        this.a = new PriorityQueue(r3, new a());
        return;
    L7:
        throw new IllegalStateException();
    }

    public final void a(E r3) {
        if (this.a.size() >= this.b) goto L6;
        this.a.add(r3);
        return;
    L6:
        if (r3.compareTo(this.a.peek()) <= 0) goto L10;
        this.a.poll();
        this.a.add(r3);
        return;
    }
}
