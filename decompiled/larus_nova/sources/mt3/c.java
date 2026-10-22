package mt3;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements rt3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f515613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f515614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yu3.a<pt3.a> f515615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile pt3.c f515616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile pt3.c f515617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile cv3.a f515618f;

    /* JADX INFO: loaded from: classes14.dex */
    public class a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f515619d;

        @Override // java.lang.Runnable
        public final void run() {
            c.c(this.f515619d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, long r101, long r102) {
            this.f515619d = r100;
            super(r101, r102);
        }
    }

    public class b extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f515620d;

        @Override // java.lang.Runnable
        public final void run() {
            c.c(this.f515620d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c r100, long r101) {
            this.f515620d = r100;
            super(0, r101);
        }
    }

    /* JADX INFO: renamed from: mt3.c$c, reason: collision with other inner class name */
    public class C6852c extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f515621d;

        public final void a() {
            this.f515621d.getClass();
            PolarisFileWrapper r100 = new PolarisFileWrapper(mt3.b.e(), "child_process_persistent");
            if (r100.exists() == false) goto L44;
            File[] r101 = r100.listFiles();
            if (r101 == null) goto L57;
            int r102 = r101.length;
            int r103 = 0;
        L9:
            if (r103 >= r102) goto L58;
            File r104 = r101[r103];
            if (r104 == null) goto L43;
            if (r104.exists() == false) goto L43;
            if (r104.length() <= 0) goto L43;
            if (CastLongProtector.parseLong(r104.getName().split("_")[0]) >= du3.a.g()) goto L43;
            FileChannel r105 = null;
            r105 = new RandomAccessFile(r104, "rw").getChannel();     // Catch: Throwable -> L34
            FileLock r106 = r105.tryLock(0, Long.MAX_VALUE, false);     // Catch: Throwable -> L34
            if (r106 == null) goto L31;
            if (r106.isValid() == false) goto L31;
            PolarisFileWrapper r107 = new PolarisFileWrapper(mt3.b.a(), System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log");     // Catch: Throwable -> L34
            boolean r110 = IOUtils.renameFile(r104.getAbsolutePath(), r107.getAbsolutePath());     // Catch: Throwable -> L34
            if (xu3.a.a() == false) goto L29;
            List<String> r111 = mt3.a.f515607a;     // Catch: Throwable -> L34
            av3.b.a("APM-Slardar", "moveInactiveSubProcessData: src:" + r104.getAbsolutePath() + " dst:" + r107.getAbsolutePath() + " isSuccess:" + r110);     // Catch: Throwable -> L34
        L29:
            r106.release();     // Catch: Throwable -> L34
        L39:
            xu3.c.a(r105);
        L31:
            if (xu3.a.a() == false) goto L39;
            List<String> r108 = mt3.a.f515607a;     // Catch: Throwable -> L34
            av3.b.a("APM-Slardar", "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L34
        L40:
            th = move-exception;
            xu3.c.a(r105);
            throw th;
        L35:
            if (xu3.a.a() == false) goto L39;
            List<String> r109 = mt3.a.f515607a;     // Catch: Throwable -> L40
            av3.a r112 = av3.b.f16366a;     // Catch: Throwable -> L40
            if (r112 == null) goto L39;
            r112.b();     // Catch: Throwable -> L40
        L43:
            r103 = r103 + 1;
            goto L9
        L58:
            return;
        L57:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C6852c(c r100) {
            this.f515621d = r100;
            super(10000);
        }
    }

    public class d implements Comparator<String> {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(String r100, String r101) {
            Comparator r102 = String.CASE_INSENSITIVE_ORDER;
            return r102.compare(r100, r101);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f515622a = null;

        static {
            f515622a = new c();
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.f515618f = new b(this, this.f515613a);     // Catch: Throwable -> L8
        AsyncTaskManagerType r100 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L8
        cv3.b.a(r100).c(this.f515618f);     // Catch: Throwable -> L8
        if (du3.a.o() == false) goto L6;
        cv3.b.a(r100).c(new C6852c(this));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // rt3.e
    public final String getName() {
        return "first_log_dir";
    }

    public final void e() {
        if (this.f515617e != null) goto L5;
        return;
    L5:
        String[] r100 = this.f515617e.d();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.length == 0) goto L45;
        List r101 = Arrays.asList(r100);
        Collections.sort(r101, new d());
        if (xu3.a.a() == false) goto L13;
        List<String> r102 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "reportPriorityFile: parsing " + r101.size() + " files. fileNameList" + r101);
    L13:
        ArrayList r103 = new ArrayList();
        int r104 = 0;
        int r105 = 0;
    L15:
        if (r104 >= r101.size()) goto L35;
        PolarisFileWrapper r106 = new PolarisFileWrapper(mt3.b.d(), (String) ListProtector.get(r101, r104));
        if (r106.exists() == false) goto L33;
        pt3.a r107 = pt3.a.a(r106);
        if (r107 == null) goto L22;
        int r108 = r107.f530635c;
        if (r105 != 0) goto L28;
    L32:
        r105 = r105 + r108;
        r103.add(r107);
        goto L33
    L28:
        if ((r105 + r108) < this.f515614b) goto L32;
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r103, r101.size() - r103.size(), true);
        return;
    L22:
        if (xu3.a.a() == false) goto L24;
        List<String> r109 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "priority logFile invalid. delete now.");
    L24:
        r106.delete();
    L33:
        r104 = r104 + 1;
        goto L15
    L35:
        if (r103.isEmpty() == true) goto L44;
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r103, 0, true);
        return;
    L44:
        return;
    }

    @Override // rt3.e
    public final long getSize() {
        if (this.f515616d == null) goto L5;
        String[] r100 = this.f515616d.d();
    L6:
        int r101 = 0;
        long r102 = 0;
        if (r100 == null) goto L14;
        if (r100.length <= 0) goto L14;
        int r103 = r100.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        String r105 = r100[r104];
        r102 = r102 + new PolarisFileWrapper(mt3.b.a(), r105).length();
        r104 = r104 + 1;
    L14:
        if (this.f515617e == null) goto L22;
        String[] r106 = this.f515617e.d();
        if (r106 == null) goto L22;
        if (r106.length <= 0) goto L22;
        int r107 = r106.length;
    L20:
        if (r101 >= r107) goto L22;
        String r108 = r106[r101];
        r102 = r102 + new PolarisFileWrapper(mt3.b.d(), r108).length();
        r101 = r101 + 1;
    L22:
        return r102;
    L5:
        r100 = null;
        goto L6
    }

    public c() {
        this.f515613a = 60000;
        this.f515614b = 1048576;
        this.f515615c = new yu3.a(10);
    }

    public static void c(c r110) {
        r110.getClass();
        long r100 = System.currentTimeMillis();
    L10:
        th = move-exception;
        List<String> r101 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "flushBuffer", th);
    L13:
        if (r110.f515615c.a() == true) goto L30;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L17:
        if (r110.f515615c.a() == true) goto L28;
        r102.add(r110.f515615c.b());
        pt3.a r104 = r110.f515615c.b();
        if (r104 == null) goto L17;
        int r105 = r104.f530635c;
        if (r103 == 0) goto L27;
        if ((r103 + r105) < r110.f515614b) goto L27;
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r102, 0, false);
        r102.clear();
        r102.add(r104);
        r103 = r105;
    L27:
        r103 = r103 + r105;
        r102.add(r104);
        goto L17
    L28:
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r102, 0, false);
    L30:
        if (du3.a.o() == false) goto L64;
        r110.e();
        if (r110.f515616d == null) goto L34;
        String[] r106 = r110.f515616d.d();
    L35:
        if (r106 == null) goto L64;
        if (r106.length == 0) goto L64;
        List r107 = Arrays.asList(r106);
        Collections.sort(r107, new mt3.e());
        if (xu3.a.a() == false) goto L42;
        List<String> r108 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "reportFile: parsing " + r107.size() + " files. fileNameList" + r107);
    L42:
        ArrayList r109 = new ArrayList();
        int r111 = 0;
        int r112 = 0;
    L44:
        if (r111 >= r107.size()) goto L62;
        PolarisFileWrapper r113 = new PolarisFileWrapper(mt3.b.a(), (String) ListProtector.get(r107, r111));
        if (r113.exists() == false) goto L61;
        pt3.a r114 = pt3.a.a(r113);
        if (r114 == null) goto L51;
        int r115 = r114.f530635c;
        if (r112 != 0) goto L57;
    L60:
        r112 = r112 + r115;
        r109.add(r114);
        goto L61
    L57:
        if ((r112 + r115) < r110.f515614b) goto L60;
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r109, r107.size() - r109.size(), false);
        goto L64
    L51:
        if (xu3.a.a() == false) goto L53;
        List<String> r116 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "logFile invalid. delete now.");
    L53:
        r113.delete();
    L61:
        r111 = r111 + 1;
        goto L44
    L62:
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.e(r109, 0, false);
        goto L64
    L34:
        List<String> r117 = mt3.a.f515607a;
        av3.b.b("APM-Slardar", "persistentBuffer is null");
        r106 = null;
    L64:
        if (xu3.a.a() == false) goto L83;
        List<String> r118 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r100) + ", isPaused=false, isMainProcess=" + du3.a.o());
        return;
    L83:
        return;
    L4:
        if (r110.f515616d == null) goto L7;
        r110.f515616d.b();     // Catch: Throwable -> L10
    L7:
        if (r110.f515617e == null) goto L13;
        r110.f515617e.b();     // Catch: Throwable -> L10
        goto L13
    }

    @Override // rt3.e
    public final void a(long r110) {
        if (this.f515616d != null) goto L5;
        return;
    L5:
        String[] r100 = this.f515616d.d();
        if (r100 == null) goto L23;
        if (r100.length <= 0) goto L23;
        int r101 = r100.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L23;
        PolarisFileWrapper r103 = new PolarisFileWrapper(mt3.b.a(), r100[r102]);
        String r104 = r103.getName();
        int r111 = r104.indexOf("_");
        if (r111 != (-1)) goto L44;
    L13:
        long r112 = -1;
    L16:
        if (r112 != (-1)) goto L19;
        xu3.b.a(r103);
    L21:
        r102 = r102 + 1;
        goto L10
    L19:
        if (r112 > r110) goto L21;
        xu3.b.a(r103);
        goto L21
    L44:
        r112 = CastLongProtector.parseLong(r104.substring(0, r111));     // Catch: Exception -> L42
    L23:
        if (this.f515617e == null) goto L41;
        String[] r105 = this.f515617e.d();
        if (r105 != null) goto L27;
        return;
    L27:
        if (r105.length <= 0) goto L57;
        int r106 = r105.length;
        int r107 = 0;
    L29:
        if (r107 >= r106) goto L58;
        PolarisFileWrapper r108 = new PolarisFileWrapper(mt3.b.d(), r105[r107]);
        String r109 = r108.getName();
        int r113 = r109.indexOf("_");
        if (r113 != (-1)) goto L46;
    L32:
        long r114 = -1;
    L35:
        if (r114 != (-1)) goto L38;
        xu3.b.a(r108);
    L40:
        r107 = r107 + 1;
        goto L29
    L38:
        if (r114 > r110) goto L40;
        xu3.b.a(r108);
        goto L40
    L46:
        r114 = CastLongProtector.parseLong(r109.substring(0, r113));     // Catch: Exception -> L43
    L58:
        return;
    L57:
        return;
    }

    @Override // rt3.e
    public final void b(long r110) {
        if (this.f515616d != null) goto L5;
        return;
    L5:
        String[] r100 = this.f515616d.d();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.length == 0) goto L96;
        Arrays.sort(r100);
        int r101 = r100.length;
        long r102 = 0;
        long r103 = 0;
        int r104 = 0;
    L11:
        if (r104 >= r101) goto L18;
        PolarisFileWrapper r111 = new PolarisFileWrapper(mt3.b.a(), r100[r104]);
        if (r111.exists() == false) goto L17;
        if (r111.isFile() == false) goto L17;
        r103 = r103 + r111.length();
    L17:
        r104 = r104 + 1;
        goto L11
    L18:
        int r105 = r100.length;
        long r106 = 0;
        int r107 = 0;
    L19:
        if (r107 >= r105) goto L36;
        String r112 = r100[r107];
        if ((r103 - r106) <= r110) goto L36;
        PolarisFileWrapper r113 = new PolarisFileWrapper(mt3.b.a(), r112);
        if (r113.exists() == false) goto L34;
        if (r113.isFile() == false) goto L34;
        long r114 = r113.length();
        if (r113.exists() == true) goto L71;
    L31:
        boolean r115 = false;
    L32:
        if (r115 == false) goto L34;
        r106 = r106 + r114;
        goto L34
    L71:
        r115 = r113.delete();     // Catch: Throwable -> L67
    L34:
        r107 = r107 + 1;
    L36:
        if (this.f515617e == null) goto L93;
        String[] r108 = this.f515617e.d();
        if (r108 != null) goto L40;
        return;
    L40:
        if (r108.length <= 0) goto L95;
        Arrays.sort(r108);
        int r109 = r108.length;
        long r116 = 0;
        int r117 = 0;
    L42:
        if (r117 >= r109) goto L49;
        PolarisFileWrapper r118 = new PolarisFileWrapper(mt3.b.d(), r108[r117]);
        if (r118.exists() == false) goto L48;
        if (r118.isFile() == false) goto L48;
        r116 = r116 + r118.length();
    L48:
        r117 = r117 + 1;
        goto L42
    L49:
        int r119 = r108.length;
        int r120 = 0;
    L50:
        if (r120 >= r119) goto L97;
        String r121 = r108[r120];
        if ((r116 - r102) <= r110) goto L98;
        PolarisFileWrapper r122 = new PolarisFileWrapper(mt3.b.d(), r121);
        if (r122.exists() == false) goto L65;
        if (r122.isFile() == false) goto L65;
        long r123 = r122.length();
        if (r122.exists() == true) goto L69;
    L62:
        boolean r124 = false;
    L63:
        if (r124 == false) goto L65;
        r102 = r102 + r123;
        goto L65
    L69:
        r124 = r122.delete();     // Catch: Throwable -> L68
    L65:
        r120 = r120 + 1;
        goto L50
    L98:
        return;
    L97:
        return;
    L95:
        return;
    L93:
        return;
    }

    public final synchronized void f(long r100) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (xu3.a.a() == false) goto L8;
        List<String> r101 = mt3.a.f515607a;     // Catch: Throwable -> L21
        av3.b.a("APM-Slardar", "setLoopInterval:" + this.f515613a);     // Catch: Throwable -> L21
    L8:
        if (r100 > 0) goto L10;
    L19:
        monitor-exit(this);
        return;
    L10:
        if (this.f515613a == r100) goto L19;
        this.f515613a = r100;     // Catch: Throwable -> L21
        if (this.f515618f != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        AsyncTaskManagerType r102 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L21
        cv3.b.a(r102).b(this.f515618f);     // Catch: Throwable -> L21
        this.f515618f = new a(this, this.f515613a, this.f515613a);     // Catch: Throwable -> L21
        cv3.b.a(r102).c(this.f515618f);     // Catch: Throwable -> L21
        monitor-exit(this);
    }
}
