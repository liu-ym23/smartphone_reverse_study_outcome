package cq;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f464757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f464758b;

    /* JADX INFO: renamed from: cq.a$a, reason: collision with other inner class name */
    public static final class C5568a {
    }

    static {
    }

    public a() {
        this.f464757a = new byte[16];
    }

    public final void a(byte r100) {
        int r101 = this.f464758b + 1;
        byte[] r102 = this.f464757a;
        if (r101 <= r102.length) goto L5;
        this.f464757a = Arrays.copyOf(r102, r102.length + (r102.length >>> 1));
    L5:
        byte[] r103 = this.f464757a;
        int r104 = this.f464758b;
        this.f464758b = r104 + 1;
        r103[r104] = r100;
    }

    public final byte b(int r100) {
        if (r100 >= this.f464758b) goto L7;
        return this.f464757a[r100];
    L7:
        throw new IndexOutOfBoundsException(c(MonitorConstants.CONNECT_TYPE_GET, r100));
    }

    public final String c(String r100, int r101) {
        return "SlcByteArrayList:" + r100 + ", size: " + this.f464758b + ", index: " + r101;
    }
}
