package tia;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f546300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<a> f546301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f546302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f546303d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f546304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f546305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f546306c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f546304a, r101.f546304a) == true) goto L12;
            return false;
        L12:
            if (this.f546305b == r101.f546305b) goto L15;
            return false;
        L15:
            if (this.f546306c == r101.f546306c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = Arrays.hashCode(this.f546304a) * 31;
            long r101 = this.f546305b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f546306c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "CaptureAudioFrame(data=" + Arrays.toString(this.f546304a) + ", startMs=" + this.f546305b + ", endMs=" + this.f546306c + ')';
        }

        public a(byte[] r100, long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f546304a = r100;
            this.f546305b = r101;
            this.f546306c = r102;
        }
    }

    public f() {
        this.f546300a = 30000;
        this.f546301b = new ArrayDeque();
    }

    public final d b(long r210, byte[] r211) {
        Intrinsics.checkNotNullParameter(r211, "dst");
        int r100 = 0;
        if (r211.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return new d(0, r210, 0);
    L10:
        if (this.f546301b.peekFirst() == null) goto L12;
        long r102 = this.f546302c;
        long r103 = 0;
        if (r210 >= r102) goto L16;
        long r110 = r102;
        long r111 = r102 - r210;
    L18:
        if (r110 >= this.f546303d) goto L20;
        Iterator<a> r104 = this.f546301b.iterator();
        long r105 = r110;
    L23:
        if (r104.hasNext() == false) goto L40;
        a r106 = r104.next();
        if (r106.f546306c <= r110) goto L38;
        long r107 = r106.f546305b;
        if (r107 <= r105) goto L31;
        if (r100 > 0) goto L40;
    L31:
        long r108 = RangesKt.coerceAtLeast(r110, r107);
        long r112 = RangesKt.coerceAtLeast(r108 - r106.f546305b, r103);
        int r113 = tia.a.f546279a;
        int r109 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r112, r103) * ((long) 128), r106.f546304a.length);
        int r114 = r106.f546304a.length - r109;
        if (r114 <= 0) goto L38;
        int r115 = Math.min(r114, r211.length - r100);
        System.arraycopy(r106.f546304a, r109, r211, r100, r115);
        r100 = r100 + r115;
        r105 = tia.a.a(r115) + r108;
        if (r100 >= r211.length) goto L40;
        r110 = r105;
    L38:
        r103 = 0;
    L40:
        return new d(r100, r105, r111);
    L20:
        return new d(0, r110, r111);
    L16:
        r110 = r210;
        r111 = 0;
        goto L18
    L12:
        return new d(0, r210, 0);
    L5:
        r101 = false;
        goto L6
    }

    public final void a(byte[] r100, int r110, long r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r110 > 0) goto L5;
        return;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L28;
        a r102 = new a(Arrays.copyOf(r100, RangesKt.coerceAtMost(r110, r100.length)), r111, RangesKt.coerceAtLeast(r112, r111));
        this.f546301b.addLast(r102);
        long r103 = r102.f546306c;
        this.f546303d = r103;
        if (this.f546302c > 0) goto L13;
        this.f546302c = r102.f546305b;
    L13:
        long r104 = r103 - this.f546300a;
    L15:
        if ((!this.f546301b.isEmpty()) == false) goto L19;
        if (this.f546301b.peekFirst().f546306c > r104) goto L19;
        this.f546301b.removeFirst();
    L19:
        a r105 = this.f546301b.peekFirst();
        if (r105 == null) goto L22;
        long r106 = r105.f546305b;
    L23:
        this.f546302c = r106;
        return;
    L22:
        r106 = this.f546303d;
        goto L23
    L28:
        return;
    L7:
        r101 = false;
        goto L8
    }
}
