package com.larus.avlink.activeSummary;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c<T>> f291482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f291483b;

    public static final class a {
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c<T>> f291484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c<T>> f291485b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f291484a, r101.f291484a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291485b, r101.f291485b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f291484a.hashCode() * 31) + this.f291485b.hashCode();
        }

        public final String toString() {
            return "EnqueueResult(expired=" + this.f291484a + ", overwritten=" + this.f291485b + ')';
        }

        public b(List<c<T>> r100, List<c<T>> r101) {
            Intrinsics.checkNotNullParameter(r100, AiBotPollingAuthResult.STATUS_EXPIRED);
            Intrinsics.checkNotNullParameter(r101, "overwritten");
            this.f291484a = r100;
            this.f291485b = r101;
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f291486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f291487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f291488c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f291486a, r101.f291486a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291487b, r101.f291487b) == true) goto L15;
            return false;
        L15:
            if (this.f291488c == r101.f291488c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f291486a.hashCode() * 31;
            T r101 = this.f291487b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f291488c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(source=" + this.f291486a + ", value=" + this.f291487b + ", expiredTimestampMs=" + this.f291488c + ')';
        }

        public c(String r100, T r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f291486a = r100;
            this.f291487b = r101;
            this.f291488c = r102;
        }
    }

    static {
    }

    public k() {
        this.f291482a = new ArrayList();
        this.f291483b = RangesKt.coerceAtLeast(5, 1);
    }

    public final List<c<T>> b(long r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) this.f291482a).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        c r103 = (c) r102.next();
        if (r103.f291488c > r100) goto L4;
        r101.add(r103);
        r102.remove();
        goto L4
    L8:
        return r101;
    }

    public final b<T> a(String r100, T r101, long r110, Integer r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r112 != null) goto L5;
    L7:
        List<c<T>> r113 = b(r110);
        if (r111 == null) goto L10;
        ArrayList r102 = new ArrayList();
    L13:
        if (((ArrayList) this.f291482a).size() < this.f291483b) goto L15;
        r102.add(ListProtector.remove(this.f291482a, 0));
        goto L13
    L15:
        List<c<T>> r103 = this.f291482a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new c(r100, r101, r110 + (((long) r111.intValue()) * 1000)));
        return new b(r113, r102);
    L10:
        return new b(r113, CollectionsKt.emptyList());
    L5:
        if (r112.intValue() <= 0) goto L7;
        this.f291483b = r112.intValue();
        goto L7
    }
}
