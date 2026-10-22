package com.bytedance.pia.nsr;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class RecordsCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f266475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<f, a> f266476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<Pair<Long, f>> f266477c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f266478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f266479b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f266478a == r101.f266478a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f266479b, r101.f266479b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f266478a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f266479b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Record(once=" + this.f266478a + ", result=" + this.f266479b + ')';
        }

        public final void setResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f266479b = r100;
        }

        public a(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f266478a = r100;
            this.f266479b = r101;
        }
    }

    public RecordsCache() {
        this.f266475a = 10;
        this.f266476b = new HashMap(10);
        this.f266477c = new PriorityQueue(10, g.f266520a);
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
    L4:
        if ((!this.f266477c.isEmpty()) == false) goto L8;
        if (this.f266477c.peek().getFirst().longValue() > r100) goto L11;
        Pair<Long, f> r101 = this.f266477c.poll();
        ((HashMap) this.f266476b).remove(r101.getSecond());
        goto L4
    L11:
        return;
    }

    public final void b(final f r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        ((HashMap) this.f266476b).remove(r100);
        CollectionsKt.removeAll(this.f266477c, new RecordsCache$remove$1(r100));
    }
}
