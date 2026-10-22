package pt3;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f530633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f530635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f530636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f530637e;

    public final String toString() {
        return "LogFile{startID=" + this.f530633a + ", totalCount=" + this.f530634b + ", totalBytes=" + this.f530635c + ", source=" + this.f530636d + ", logList=" + this.f530637e + '}';
    }

    public static a a(PolarisFileWrapper r100) {
        byte[] r101 = xu3.b.b(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        a r102 = b(ByteBuffer.wrap(r101));     // Catch: Throwable -> L12
        if (r102 == null) goto L8;
        r102.f530636d = r100;     // Catch: Throwable -> L12
    L9:
        return r102;
    L8:
        List<String> r103 = mt3.a.f515607a;     // Catch: Throwable -> L12
        av3.b.b("APM-Slardar", "fromMemory bytes is null");     // Catch: Throwable -> L12
        goto L9
    L10:
        List<String> r104 = mt3.a.f515607a;     // Catch: Throwable -> L12
        av3.b.b("APM-Slardar", "fromFile bytes is null");     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        List<String> r105 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "fromFile", th);
        return null;
    }

    public static a b(ByteBuffer r110) {
    L14:
        return null;
    L4:
        if (r110.getShort() == 2082) goto L6;
        return null;
    L6:
        long r100 = r110.getLong();     // Catch: Throwable -> L14
        int r101 = r110.getInt();     // Catch: Throwable -> L14
        int r102 = r110.getInt();     // Catch: Throwable -> L14
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L14
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= r101) goto L12;
        int r106 = r110.getInt();     // Catch: Throwable -> L14
        r105 = r105 + r106;     // Catch: Throwable -> L14
        if (r105 > r102) goto L10;
        byte[] r107 = new byte[r106];     // Catch: Throwable -> L14
        r110.get(r107);     // Catch: Throwable -> L14
        r103.add(new b(r107));     // Catch: Throwable -> L14
        r104 = r104 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new a(r100, r101, r102, r103);
    }

    public a(long r100, int r101, int r102, List<b> r103) {
        this.f530633a = r100;
        this.f530634b = r101;
        this.f530635c = r102;
        this.f530637e = r103;
    }
}
