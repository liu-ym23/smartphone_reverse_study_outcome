package vt3;

import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f557213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f557214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f557215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f557216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f557217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f557218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f557219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f557220h;

    public h() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f557213a), this.f557214b});
    }

    public final String toString() {
        return "ThreadExceptionItem{threadId=" + this.f557213a + ", threadName='" + this.f557214b + "', threadCpuTime=" + this.f557215c + ", processCpuTime=" + this.f557219g + ", cpuUsage=" + this.f557216d + ", weight=" + this.f557217e + ", nice=" + this.f557220h + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f557213a == r101.f557213a) goto L11;
    L13:
        return false;
    L11:
        if (this.f557214b.equals(r101.f557214b) == false) goto L13;
        return true;
    }
}
