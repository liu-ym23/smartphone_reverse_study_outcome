package f9a;

import com.bytedance.apm.d;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;
import x8a.c;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f475987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile PolarisFileWrapper f475988b;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            return r100.isFile();
        }
    }

    /* JADX INFO: renamed from: f9a.b$b, reason: collision with other inner class name */
    public static class C5874b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f475989a = null;

        static {
            f475989a = new b();
        }
    }

    public final File a() {
        if (this.f475988b != null) goto L10;
        if (d.getContext() == null) goto L7;
        this.f475988b = new PolarisFileWrapper(d.getContext().getFilesDir(), "cloud_uploading");
        goto L10
    L7:
        return null;
    L10:
        if (this.f475988b == null) goto L15;
        if (this.f475988b.exists() == true) goto L15;
        this.f475988b.mkdirs();
    L15:
        return this.f475988b;
    }

    public b() {
        this.f475987a = new HashMap();
    }

    public final synchronized void b(z8a.a r110, File r111, String r112) throws Exception {
        monitor-enter(this);
        f9a.a.a(r110.f570967c, "命令产物已生成，等待上传", 0, null);     // Catch: Throwable -> L44
        if (this.f475988b != null) goto L7;
    L9:
        String r100 = r110.f570967c;     // Catch: Throwable -> L44
        File r101 = a();     // Catch: Throwable -> L44
        if (r101 == null) goto L43;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, r100);     // Catch: Throwable -> L44
        if (r102.exists() == false) goto L14;
        com.monitor.cloudmessage.utils.a.d(r102);     // Catch: Throwable -> L44
    L14:
        r111.renameTo(r102);     // Catch: Throwable -> L44
        long r103 = com.bytedance.apm.util.b.c(r102);     // Catch: Throwable -> L44
        boolean r104 = true;
        if (r110.f570968d.optBoolean("wifiOnly") == true) goto L17;
    L19:
        boolean r113 = false;
    L20:
        ((HashMap) this.f475987a).put(r100, Boolean.valueOf(r113));     // Catch: Throwable -> L44
        if (r113 == true) goto L23;
    L27:
        File[] r114 = r102.listFiles(new a());     // Catch: Throwable -> L44
        int r105 = r114.length;     // Catch: Throwable -> L44
        int r106 = 0;
    L28:
        if (r106 >= r105) goto L37;
        File r107 = r114[r106];     // Catch: Throwable -> L44
        boolean r108 = f9a.a.b(r100, r107, r112, "正在上传:" + r107.getName());     // Catch: Throwable -> L44
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L44
        r109.append("文件上传");     // Catch: Throwable -> L44
        if (r108 == false) goto L32;
        String r115 = "成功";
    L33:
        r109.append(r115);     // Catch: Throwable -> L44
        r109.append(":");     // Catch: Throwable -> L44
        r109.append(r107.getName());     // Catch: Throwable -> L44
        f9a.a.a(r110.f570967c, r109.toString(), 0, null);     // Catch: Throwable -> L44
        if (r108 == true) goto L36;
        r104 = false;
    L36:
        r106 = r106 + 1;     // Catch: Throwable -> L44
        goto L28
    L32:
        r115 = "失败";
        goto L33
    L37:
        if (r104 == false) goto L39;
        f9a.a.a(r100, "上传成功", 2, null);     // Catch: Throwable -> L44
    L39:
        com.monitor.cloudmessage.utils.a.d(r102);     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L23:
        if (NetworkUtils.g(c.b().getContext()) == true) goto L27;
        f9a.a.a(r110.f570967c, "产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r103, 0, null);     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L17:
        if (r103 <= 2097152) goto L19;
        r113 = true;
        goto L20
    L43:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L44
    L7:
        if (this.f475988b.exists() == true) goto L9;
        this.f475988b.mkdirs();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
