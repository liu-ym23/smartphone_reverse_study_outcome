package hy5;

import by5.n;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import ita.k;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MappedByteBuffer f487635a;

    public static synchronized void a(JSONObject r110) {
        monitor-enter(a.class);
        monitor-enter(SDKMonitor.class);     // Catch: Throwable -> L22
        String r100 = k.c(n.getContext());     // Catch: Throwable -> L17
        if (f487635a != null) goto L14;
        PolarisFileWrapper r101 = new PolarisFileWrapper(n.getContext().getFilesDir(), "sdk_" + r100 + "_seq_num.txt");     // Catch: Throwable -> L17
        boolean r102 = r101.exists();     // Catch: Throwable -> L17
        if (r102 == true) goto L11;
        r101.createNewFile();     // Catch: Throwable -> L17
    L11:
        MappedByteBuffer r103 = new RandomAccessFile(r101, "rws").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L17
        f487635a = r103;     // Catch: Throwable -> L17
        if (r102 == true) goto L14;
        r103.putLong(0, 0);     // Catch: Throwable -> L17
    L14:
        long r104 = f487635a.getLong(0);     // Catch: Throwable -> L17
        r110.put("seq_no", r104);     // Catch: Throwable -> L17
        r110.put("process_name", r100);     // Catch: Throwable -> L17
        f487635a.putLong(0, r104 + 1);     // Catch: Throwable -> L17
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        monitor-exit(a.class);
    }
}
