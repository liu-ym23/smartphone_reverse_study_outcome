package mt3;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MappedByteBuffer f515624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f515625b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f515626a = null;

        static {
            f515626a = new f();
        }
    }

    public final long a() {
        if (this.f515624a == null) goto L19;
    L13:
        MappedByteBuffer r100 = this.f515624a;
        if (r100 == null) goto L17;
        long r101 = r100.getLong(0) + 1;
        this.f515625b = r101;
        this.f515624a.putLong(0, r101);
        return this.f515625b;
    L17:
        long r102 = this.f515625b;
        this.f515625b = 1 + r102;
        return r102;
    L19:
        PolarisFileWrapper r103 = new PolarisFileWrapper(b.e(), du3.a.e().replace(".", "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L11
        boolean r104 = r103.exists();     // Catch: Throwable -> L11
        if (r104 == true) goto L7;
        r103.createNewFile();     // Catch: Throwable -> L11
    L7:
        MappedByteBuffer r105 = new RandomAccessFile(r103, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L11
        this.f515624a = r105;     // Catch: Throwable -> L11
        if (r104 == true) goto L13;
        r105.putLong(0, 0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        List<String> r106 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "prepare seq_number fail.", th);
        goto L13
    }

    public f() {
        this.f515625b = 0;
    }
}
