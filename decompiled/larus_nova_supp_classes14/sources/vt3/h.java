package vt3;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public int a;
    public String b;
    public long c;
    public double d;
    public String e;
    public String f;
    public long g;
    public int h;

    public h() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), this.b});
    }

    public final String toString() {
        return "ThreadExceptionItem{threadId=" + this.a + ", threadName='" + this.b + "', threadCpuTime=" + this.c + ", processCpuTime=" + this.g + ", cpuUsage=" + this.d + ", weight=" + this.e + ", nice=" + this.h + '}';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (this.a == r6.a) goto L11;
    L13:
        return false;
    L11:
        if (this.b.equals(r6.b) == false) goto L13;
        return true;
    }
}
